package Compilation;


import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
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


    public static void stockBuy(int m, int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= m) continue;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == m) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }




    public static String hashPass(String password) {
        int code = password.hashCode();
        return Integer.toString(code);
    }

    public static String allowedChars = "0123456789";

    public static String bruteforcePass(String hashedPass) {
        int code=Integer.parseInt(hashedPass);
        for (int i = 0; i < 100000; i++) {
            String hashed = Integer.toString(i);
            int code2 = hashed.hashCode();
            if(code==code2)
                return hashed;
        }
        for (int i = 0; i < 10000; i++) {
            String hashed ="0" + i;
            int code2 = hashed.hashCode();
            if(code==code2)
                return hashed;
        }
        for (int i = 0; i < 1000; i++) {
            String hashed ="00" + i;
            int code2 = hashed.hashCode();
            if(code==code2)
                return hashed;
        }
        for (int i = 0; i < 100; i++) {
            String hashed ="000" + i;
            int code2 = hashed.hashCode();
            if(code==code2)
                return hashed;
        }
        for (int i = 0; i < 10; i++) {
            String hashed ="0000" + i;
            int code2 = hashed.hashCode();
            if(code==code2)
                return hashed;
        }
        return "";
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-6;
        double result = 0;

        for (double i = a; i <= b;) {
            result += step * f.applyAsDouble(a);
            a += step;
        }
        return result;
    }

    //////////////////////////////////////////////// Methods ////////////////////////////////////////////////

    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        Logger loggerC = Logger.getLogger("org.java");

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());

        loggerC.setUseParentHandlers(false);
        loggerC.addHandler(handler);
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] resultArr = new int[a1.length + a2.length];

        for (int i = 0, j = 0, k = 0; i < resultArr.length; i++) {
            if (k == a2.length || j < a1.length && a1[j] <= a2[k]) {
                resultArr[i] = a1[j++];
            } else {
                resultArr[i] = a2[k++];
            }
        }
        return resultArr;
    }




    //////////////////////////////////////////////// Main ////////////////////////////////////////////////

    public static void main(String[] args) throws Exception {






        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

//        IntStream chars = "word".chars();

        Path path = Paths.get("C:/Java/Sample_Tasks");
        Stream<Path> stream2 = Files.list(path);
        Stream<Path> stream3 = Files.walk(path);

        DoubleStream randomNumbers = DoubleStream.generate(Math::random);



        IntStream hundredInt = IntStream.range(0, 11);

        IntStream tenIntegers = IntStream.rangeClosed(0, 11);

        IntStream combinedStreams = IntStream.concat(hundredInt, tenIntegers);

        IntStream empty = IntStream.empty();

        IntStream stream4 = IntStream.of(1, 2, 3, 4, 5);


        Stream<String> stream = Stream.of("A", "Mass", "ABs");
        List<String> list = stream.collect(Collectors.toList());

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