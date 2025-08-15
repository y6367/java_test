package OnlineStore;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
//    String clothes = {c1.name,c2.name,c3.name};

    static ArrayList<String> items = new ArrayList<String>();
    static ArrayList<Integer> price = new ArrayList<Integer>();


    static Clothing c1 = new Clothing("Rick & Morty T-shirt", 40);
    static Clothing c2 = new Clothing("ATL Jeans", 200);
    static Clothing c3 = new Clothing("French Trench Coat", 350);


    Electronics e1 = new Electronics("Iphone", 700);
    Electronics e2 = new Electronics("AirPods", 150);
    Electronics e3 = new Electronics("Macbook", 1000);

    Food f1 = new Food("Bread", 10);
    Food f2 = new Food("Steak", 40);
    Food f3 = new Food("Lobster", 40);

    static String[] clothingName = {c1.name, c2.name, c3.name};
    String[] foodName = {f1.name, f2.name, f3.name};
    String[] electronicsName = {e1.name, e2.name, e3.name};
    static int[] clothingPrice = {c1.price, c2.price, c3.price};
    int[] foodPrice = {f1.price, f2.price, f3.price};
    int[] electronicsPrice = {c1.price, c2.price, c3.price};

    public static void getPurchase() {
        System.out.println("====================\nMain Menu\n=====================");
        System.out.println("1. Clothing");
        System.out.println("2. Electronics");
        System.out.println("3. Food");
        System.out.println("Enter your choice by number (1, 2, 3)");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.println("====================\nClothing\n=====================");
                System.out.println("1. Rick & Morty T-shirt");
                System.out.println("2. ATL Jeans");
                System.out.println("3. French Trench Coat");
                System.out.println("Enter your choice by number (1, 2, 3)");
                input = scanner.nextInt();

                System.out.println("Please confirm " + clothingName[input-1] + "for $" + clothingPrice[input-1] + ". Type yes or no");
                String confirm = scanner.next();
                if (confirm.equals("yes")) {
                    items.add(clothingName[input-1]);
                    price.add(clothingPrice[input-1]);
                    System.out.println(clothingName[input-1] + " has been added to cart!");
                    break;
                }
                else {
                    System.out.println("Item not added to cart");
                    break;
                }

            case 2:
                System.out.println("====================\nElectronics\n=====================");
                System.out.println("1. Iphone");
                System.out.println("2. AirPods");
                System.out.println("3. Macbook");
                System.out.println("Enter your choice by number (1, 2, 3)");
                input = scanner.nextInt();

            case 3:
                System.out.println("====================\nFood\n=====================");
                System.out.println("1. Bread");
                System.out.println("2. Steak");
                System.out.println("3. Lobster");
                System.out.println("Enter your choice by number (1, 2, 3)");
                input = scanner.nextInt();
                System.out.println();

        }
    }

    public static void main(String[] args) {
        getPurchase();
    }
}
