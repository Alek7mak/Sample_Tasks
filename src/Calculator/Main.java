package Calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MyProgram {
    static public void main (String []args) throws FileNotFoundException {
        String path = "src/Calculator/test/input.txt";

        File file = new File(path);
        Scanner sc = new Scanner(file);
        String line = sc.nextLine();
        sc.close();

        double firstNum = 0.0;
        double secondNum = 0.0;
        char sign = ' ';
        int i = 0;
        boolean is = true;

        for(String num:line.split(" ")) {
            i++;
            if(i == 1) {
                try {
                    firstNum = Double.parseDouble(num);
                }catch(NumberFormatException e) {
                    System.out.print("Error! Not number\n");
                    is = false;
                    break;
                }
            }
            if(i == 3) {
                try {
                    secondNum = Double.parseDouble(num);
                }catch(NumberFormatException e) {
                    System.out.print("Error! Not number\n");
                    is = false;
                    break;
                }
            }
        }
        if(is) {
            i = 0;
            for(String num:line.split(" ")) {
                i++;
                if(i == 2) {
                    try {
                        sign = result(num);
                    }catch(Exception s){
                        System.out.print("Operation Error!");
                        is = false;
                        break;
                    }
                }
            }
        }
        if(is) {
            switch(sign){
                case('+'):
                    System.out.print(firstNum + secondNum);
                    break;
                case('-'):
                    System.out.print(firstNum - secondNum);
                    break;
                case('*'):
                    System.out.print(firstNum * secondNum);
                    break;
                case('/'):
                    if(secondNum == 0.0) {
                        System.out.print("Error! Division by zero");
                    }else {
                        System.out.print(firstNum / secondNum);
                    }
                    break;
            }
        }
    }

    public static char result(String nms) throws Exception {
        if(nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
            return nms.charAt(0);
        }
        else throw new Exception("OperationError");
    }
}