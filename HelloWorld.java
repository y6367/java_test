import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(2%5);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.printf("Hello %s, how are you?", name);

        scanner.close();
    }
}
