import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        sc.close();

        if (Double.parseDouble(array[2]) == 0.0) {
            System.out.println("Error! Division by zero");
        } else {
            try {
                switch (array[1]) {
                    case "+":
                        System.out.println(Double.parseDouble(array[0]) + Double.parseDouble(array[2]));
                        break;
                    case "-":
                        System.out.println(Double.parseDouble(array[0]) - Double.parseDouble(array[2]));
                        break;
                    case "*":
                        System.out.println(Double.parseDouble(array[0]) * Double.parseDouble(array[2]));
                        break;
                    case "/":
                        System.out.println(Double.parseDouble(array[0]) / Double.parseDouble(array[2]));
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error! Not number\n");
            } catch (Exception e) {
                System.out.println("Operation error!");
            }
        }
    }
}