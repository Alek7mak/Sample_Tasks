package Compilation;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Main {


    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        if (stackTrace.length > 2) {
            return stackTrace[2].getClassName() + "#" + stackTrace[2].getMethodName();
        }
        return null;
    }

    public final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }



    }


    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean isMove = false;

        for (int i = 0; i < 3; i++) {
            try (RobotConnection rc = robotConnectionManager.getConnection()) {
                rc.moveRobotTo(toX, toY);
                isMove = true;
                i = 3;
            } catch (RobotConnectionException ignore) {

            }
        }
        if (!isMove) {
            throw new RobotConnectionException("Can't move");
        }
    }

    public static void main(String[] args) {


//        ParameterList<String> list = new ParameterList<>();
//        list.add("EXCEPTION");
//        list.add("COLLISION");
//        list.add("FALLING");
//ф
//        list.set(1, "SET");
//        list.remove(1);
//        list.insert(1, "INSERT");
//        System.out.println(list.find("INSERT"));
//        System.out.println(list.find("NONE"));
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();
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


    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }


    public static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private static Function<String, Integer> ternaryOperator(Predicate<Object> condition,
                                                             Function<Object, Integer> ifTrue,
                                                             Function<CharSequence, Integer> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> set2Clone = new HashSet<>(set2);

        result.removeIf(set2Clone::remove);
        result.addAll(set2Clone);

        return result;
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