import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("====================\nMain Menu\n=====================");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
//            System.out.println("add | subtract | multiply | divide");
            System.out.print("Select your option: ");

            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    int sum = 0;
                    System.out.println("Enter number: ");
                    while (scanner.hasNextInt()) {
                        System.out.println("Enter number, type exit to exit: ");
                        sum += scanner.nextInt();
//                        scanner.nextLine();
                    }
                    System.out.println("The answer is: " + sum);
                    break;

                case "subtract":
                    int sub = 0;
                    System.out.println("Enter number: ");
                    while (scanner.hasNextInt()) {
                        System.out.println("Enter number, type exit to exit: ");
                        if (sub == 0) {
                            sub = scanner.nextInt();
                        } else {
                            sub -= scanner.nextInt();
                        }
//                        scanner.nextLine();
                    }
                    System.out.println("The answer is: " + sub);
                    break;

                case "multiply":
                    int mul = 0;
                    System.out.println("Enter number: ");
                    while (scanner.hasNextInt()) {
                        System.out.println("Enter number, type exit to exit: ");
                        if (mul == 0) {
                            mul = scanner.nextInt();
                        } else {
                            mul *= scanner.nextInt();
                        }
//                        scanner.nextLine();
                    }
                    System.out.println("The answer is: " + mul);
                    break;

                case "divide":
                    int div = 0;
                    System.out.println("Enter number: ");
                    while (scanner.hasNextInt()) {
                        System.out.println("Enter number, type exit to exit: ");
                        if (div == 0) {
                            div = scanner.nextInt();
                        } else {
                            div /= scanner.nextInt();
                        }
//                        scanner.nextLine();
                    }
                    System.out.println("The answer is: " + div);
                    break;
            }
        }

    }
}
