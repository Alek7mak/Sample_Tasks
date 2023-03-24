package Compilation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reader_Writer {

    public static void startMethod() throws Exception {

        String inputPath = "src/Compilation/test/input.txt";
        String outputPath = "src/Compilation/test/output.txt";

        File inputFile = new File(inputPath);
        Scanner sc = new Scanner(inputFile);

        String line = "";
        String result = "";

        double firstNum = 0.0;
        double secondNum = 0.0;
        char sign = ' ';
        int i = 0;
        boolean is = true;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            for (String num : line.split(" ")) {
                i++;
                if (i == 1) {
                    try {
                        firstNum = Double.parseDouble(num);
                    } catch (NumberFormatException e) {
                        result = "Error! Not number";
                        is = false;
                        break;
                    }
                }
                if (i == 3) {
                    try {
                        secondNum = Double.parseDouble(num);
                    } catch(NumberFormatException e) {
                        result = "Error! Not number";
                        is = false;
                        break;
                    }
                }
            }
            if (is) {
                i = 0;
                for (String num : line.split(" ")) {
                    i++;
                    if (i == 2) {
                        try {
                            sign = result(num);
                        } catch(Exception s){
                            result = "Operation Error!";
                            is = false;
                            break;
                        }
                    }
                }
            }
            if (is) {
                switch (sign) {
                    case '+':
                        result = String.valueOf(firstNum + secondNum);
                        break;
                    case '-':
                        result = String.valueOf(firstNum - secondNum);
                        break;
                    case '*':
                        result = String.valueOf(firstNum * secondNum);
                        break;
                    case '/':
                        if (secondNum == 0.0) {
                            result = "Error! Division by zero";
                        } else {
                            result = String.valueOf(firstNum / secondNum);
                        }
                        break;
                }
            }

            try (FileWriter writer = new FileWriter(outputPath, false)) {
                writer.write(result);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static char result(String nms) throws Exception {
        if (nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
            return nms.charAt(0);
        }
        else throw new Exception("OperationError");
    }
}
