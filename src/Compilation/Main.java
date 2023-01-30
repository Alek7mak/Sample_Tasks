package Compilation;

import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) {
    }

    public class Example<X> {
        private final X v;

        public Example(X v) {
            this.v = v;
        }

        public void someMethod(Object obj) {
            Optional<X> x2 = Optional.empty();
            X x3 = (X) obj;
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