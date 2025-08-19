import java.util.Scanner;
import java.util.HashMap;

public class WordCount {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Enter a paragraph: ");
        String input = scanner.nextLine();
        String[] myArray = input.split("\\W+");
        for (String s : myArray) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            System.out.println("Printed " + map);
        }

        System.out.println(map);
    }
}
