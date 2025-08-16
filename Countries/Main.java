package Countries;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Integer> countries = new HashMap<>();


    public static void main(String[] args) {
        while (true) {
            System.out.println("Please enter a country: (type exit to leave)");
            String tempName = scanner.next();
            if (tempName.equals("exit")) {
                System.out.println("You've successfully exited");
               break;
           }
            System.out.println("Please rate country 1-10: (type exit to leave)");
            int tempRate = scanner.nextInt();
            countries.put(tempName, tempRate);
            System.out.println(countries);
       }

        System.out.println("Your rating of countries:");
        for (String country : countries.keySet()) {
            System.out.println(country + " - " + countries.get(country));
        }
    }
}
