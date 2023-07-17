package Compilation;


import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.regex.Pattern;
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

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setClone1 = new HashSet<>(set1);
        Set<T> setClone2 = new HashSet<>(set2);

        setClone1.removeAll(set2);
        setClone2.removeAll(set1);
        setClone1.addAll(setClone2);

        return setClone1;
    }


    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-6;
        double result = 0;

        for (double i = a; i <= b; ) {
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


    public static String primer(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" + ").append(b).append(" = ").append(a + b);
        return sb.toString();
    }

    public static class AsciiCharSequence implements CharSequence {

        private final byte[] data;

        public AsciiCharSequence(byte[] data) {
            this.data = data.clone();
        }

        @Override
        public int length() {
            return data.length;
        }

        @Override
        public char charAt(int index) {
            return (char) data[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(Arrays.copyOfRange(data, start, end));
        }

        @Override
        public String toString() {
            return new String(data);
        }

    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int read;

        while ((read = inputStream.read()) != -1) {
            if ((byte) read % 2 == 0) {
                outputStream.write((byte) read);
            }
        }
        outputStream.flush();
    }

    @FunctionalInterface
    public interface NumberGenerator<T extends Number> {
        boolean cond(T arg);
    }

    public static NumberGenerator<? super Number> getGenerator() {
        return T -> T.intValue() > 0;
    }


    public <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> n * n / 10 % 1000);
    }

    public <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.stream().min(order).get(), list.stream().max(order).get());
        }
        stream.close();
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count + 1;
    }

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node addFirst(Node node, int newData) {
        if (node != null) {
            Node first = new Node(newData);
            first.next = node;
            return first;
        }
        return new Node(newData);
    }

    public static Node addLast(Node node, int newData) {
        Node tmp = node;

        return node;
    }

    public static int size(Node node) {
        int size = 0;

        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public static int getLast(Node node) {
        int count = 0;

        while (node != null) {
            node = node.next;
            if (count == size(node)) {
                return node.data;
            }
            count++;
        }

        return 0;
    }


    //////////////////////////////////////////////// Main ////////////////////////////////////////////////

    public static void main(String[] args) throws Exception {

        ParameterList<Integer> sampleList = new ParameterList<>();




        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

//        IntStream chars = "word".chars();

        Path path = Paths.get("C:/Java/Sample_Tasks");
//        Stream<Path> stream2 = Files.list(path);
//        Stream<Path> stream3 = Files.walk(path);

        DoubleStream randomNumbers = DoubleStream.generate(Math::random);


        IntStream hundredInt = IntStream.range(0, 11);

        IntStream tenIntegers = IntStream.rangeClosed(0, 11);

        IntStream combinedStreams = IntStream.concat(hundredInt, tenIntegers);

        IntStream empty = IntStream.empty();

        IntStream stream4 = IntStream.of(1, 2, 3, 4, 5);


        Stream<String> stream = Stream.of("A", "Mass", "ABs");
        List<String> list2 = stream.collect(Collectors.toList());

    }
}