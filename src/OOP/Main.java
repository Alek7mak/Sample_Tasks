package OOP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        int read = System.in.read();
        int next;

        while (read > 0) {
            next = System.in.read();

            if (read != 13 || next != 10) {
                System.out.write(read);
            }
            read = next;
        }
        System.out.flush();
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder result = new StringBuilder();
        int read;

        while ((read = reader.read()) > 0) {
            result.append(read);
        }
        return result.toString();
    }


    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int read;
        int sum = 0;

        while ((read = inputStream.read()) != -1) {
            sum += Integer.rotateLeft(sum, 1) ^ read;
        }

        return sum;
    }

}