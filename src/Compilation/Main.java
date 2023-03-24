package Compilation;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
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
            byte[] result = Arrays.copyOfRange(data, start, end);
            return new AsciiCharSequence(result);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();

            for (byte b : data) {
                result.append((char) b);
            }
            return result.toString();
        }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder result = new StringBuilder();
        Reader isr = new InputStreamReader(inputStream, charset);
        int read;

        while ((read = isr.read()) != -1) {
            result.append((char) read);
        }
        return result.toString();
    }




    //////////////////////////////////////////////// Main ////////////////////////////////////////////////

    public static void main(String[] args) throws Exception {




        byte[] byteArray = {65, 108, 101, 107, 115};

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