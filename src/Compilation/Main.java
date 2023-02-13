package Compilation;


import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Main {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        int read;

        while ((read = inputStream.read()) > 0) {
            sum = Integer.rotateLeft(sum, 1) ^ read;
        }

        return sum;
    }

    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Animal) {
                return Objects.equals(name, ((Animal) o).name);
            }
            return false;
        }
    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setClone1 = new HashSet<>(set1);
        Set<T> setClone2 = new HashSet<>(set2);

        setClone1.removeAll(set2);
        setClone2.removeAll(set1);
        setClone1.addAll(setClone2);

        return setClone1;
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.stream().max(order).get(), list.stream().min(order).get());
        }
    }

    //////////////////////// Main ////////////////////////

    public static void main(String[] args) throws Exception {

        ParameterList<String> parameterList = new ParameterList<>();

        parameterList.add("Parameter1");
        parameterList.add("Parameter2");
        parameterList.add("Parameter3");

        // size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

        System.out.println(parameterList);
        System.out.println(parameterList.size());
        System.out.println(parameterList.get(0));
        parameterList.set(0, "setParameter");
        System.out.println(parameterList);
        parameterList.remove(0);
        System.out.println(parameterList);
        parameterList.insert(0, "Parameter1");
        System.out.println(parameterList);
        System.out.println(parameterList.find("Parameter1"));


        int sum1 = IntStream.iterate(1, n -> n + 1)
            .filter(n -> n % 5 == 0 && n % 2 != 0)
            .limit(10)
            .map(n -> n * n)
            .sum();

        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        IntStream chars = "word".chars();

        Path path = Paths.get("C:/Java/Sample_Tasks");
        Stream<Path> stream2 = Files.list(path);
        Stream<Path> stream3 = Files.walk(path);

        DoubleStream randomNumbers = DoubleStream.generate(Math::random);

        IntStream integers = IntStream.iterate(1, n -> ++n);

        IntStream hundredInt = IntStream.range(0, 11);

        IntStream tenIntegers = IntStream.rangeClosed(0, 11);

        IntStream combinedStreams = IntStream.concat(hundredInt, tenIntegers);

        IntStream empty = IntStream.empty();

        double[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        DoubleStream doubleStream = Arrays.stream(array);

        IntStream stream4 = IntStream.of(1, 2, 3, 4, 5);

//        doubleStream.filter(n -> n < 5)
//                .mapToObj(Double::toString)
//                .flatMapToInt(String::chars)
//                .distinct() //dubles
//                .peek(System.out::println)
//                .sorted()
//                .skip(2)
//                .limit(1)
//                .forEach(System.out::println);

        stream4.filter(n -> n < 5)
                .allMatch(n -> n <5);

        Stream<String> stream = Stream.of("A", "Mass", "ABs");
        List<String> list = stream.collect(Collectors.toList());

        int n = 13;
        BigInteger bigInteger = IntStream.rangeClosed(1, n)
                .mapToObj(t -> BigInteger.valueOf(n))
                .reduce(BigInteger.ONE, BigInteger::multiply);


        String s = "Ab21 2ba";
        StringBuilder leftToRight = new StringBuilder();
//
//        s.chars().filter(Character::isLetterOrDigit)
//                .map(Character::toLowerCase)
//                .forEach(leftToRight::appendCodePoint);

        StringBuilder rightToLeft = new StringBuilder(leftToRight).reverse();

        boolean isPalindrome = leftToRight.toString().equals(rightToLeft.toString());
    }


    private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-7;
        double result = 0;

        while (a <= b) {
            result += step * f.applyAsDouble(a);
            a+= step;
        }
        return result;
    }

    public static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }


    public static class Pair<T, U> {

        private final T left;
        private final U right;

        private Pair(T left, U right) {
            this.left = left;
            this.right = right;
        }

        public static <T, E> Pair<T, E> of(T left, E right) {
            return new Pair<>(left, right);
        }

        public T getFirst() {
            return left;
        }

        public U getSecond() {
            return right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }

    public static GenMethod[] deserializeAnimalArray(byte[] data) {
        int buff;

        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data))) {
            buff = in.readInt();
            GenMethod[] animals = new GenMethod[buff];

            for (int i = 0; i < buff; i++) {
                animals[i] = (GenMethod) in.readObject();
            }
            in.close();
            return animals;

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    class GenMethod implements Serializable {
        private final String name;

        public GenMethod(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof GenMethod) {
                return Objects.equals(name, ((GenMethod) obj).name);
            }
            return false;
        }
    }

    static void generator (int n,int k) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        String s = "";
        String s1 = "";
        boolean flag = false;

        for (int i = (int) Math.pow(10, (n - 1)); i < ((int) Math.pow(10, n) - 1); i++) {
            s = String.valueOf(i);

            for (int j = 0; j < s.length(); j++) {
                String[] arr = s.split("");
                x = Integer.parseInt(arr[j]);

                if (!(x >= 1 && x <= k)) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }

            if (flag) {
                s1 = s.replace("", " ").trim();
                set.add(s1);
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for (String r : list)
            System.out.println(r);

    }
}