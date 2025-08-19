package OnlineStore;
import java.util.ArrayList;
import java.util.Scanner;
import PaymentProccessor.*;
import java.util.HashMap;

public class Main {

    static Scanner scanner = new Scanner(System.in);
//    String clothes = {c1.name,c2.name,c3.name};

    static ArrayList<String> items = new ArrayList<String>();
    static ArrayList<Integer> price = new ArrayList<Integer>();

    static HashMap<String, Integer> map = new HashMap<>();


    static Clothing c1 = new Clothing("Rick & Morty T-shirt", 40);
    static Clothing c2 = new Clothing("ATL Jeans", 200);
    static Clothing c3 = new Clothing("French Trench Coat", 350);


    static Electronics e1 = new Electronics("Iphone", 700);
    static Electronics e2 = new Electronics("AirPods", 150);
    static Electronics e3 = new Electronics("Macbook", 1000);

    static Food f1 = new Food("Bread", 10);
    static Food f2 = new Food("Steak", 40);
    static Food f3 = new Food("Lobster", 40);

    static String[] clothingName = {c1.getName(), c2.getName(), c3.getName()};
    static String[] foodName = {f1.getName(), f2.getName(), f3.getName()};
    static String[] electronicsName = {e1.getName(), e2.getName(), e3.getName()};
    static int[] clothingPrice = {c1.getPrice(), c2.getPrice(), c3.getPrice()};
    static int[] foodPrice = {f1.getPrice(), f2.getPrice(), f3.getPrice()};
    static int[] electronicsPrice = {e1.getPrice(), e2.getPrice(), e3.getPrice()};

    static String[] paymentOptions = {"Bank Transfer", "Credit Card Payment", "Paypal Payment"};

    public static void getConfirmation(String[] categoryName, int[] categoryPrice, int input) {
        System.out.println("Please confirm " + categoryName[input-1] + "for $ " + categoryPrice[input-1] + ". Type 1 or 2");
        int confirm = scanner.nextInt();
        if (confirm == 1) {
            items.add(categoryName[input-1]);
            price.add(categoryPrice[input-1]);
            System.out.println(categoryName[input-1] + " has been added to cart!");
        }
        else {
            System.out.println("Item not added to cart");
        }
    }

    public static void getPurchase() {
        boolean running = true;
        while (running) {
            System.out.println("====================\nMain Menu\n=====================");
            System.out.println("1. Clothing");
            System.out.println("2. Electronics");
            System.out.println("3. Food");
            System.out.println("4. View cart");
            System.out.println("5. Checkout");
            System.out.println("Enter your choice by number (1, 2, 3, 4, 5)");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Clothing");
                    System.out.println("1. Rick & Morty T-shirt");
                    System.out.println("2. ATL Jeans");
                    System.out.println("3. French Trench Coat");
                    System.out.println("Enter your choice by number (1, 2, 3)");
                    input = scanner.nextInt();

                    getConfirmation(clothingName, clothingPrice, input);
                    break;

                case 2:
                    System.out.println("Electronics");
                    System.out.println("1. Iphone");
                    System.out.println("2. AirPods");
                    System.out.println("3. Macbook");
                    System.out.println("Enter your choice by number (1, 2, 3)");
                    input = scanner.nextInt();

                    getConfirmation(electronicsName, electronicsPrice, input);
                    break;

                case 3:
                    System.out.println("Food");
                    System.out.println("1. Bread");
                    System.out.println("2. Steak");
                    System.out.println("3. Lobster");
                    System.out.println("Enter your choice by number (1, 2, 3)");
                    input = scanner.nextInt();

                    getConfirmation(foodName, foodPrice, input);
                    break;

                case 4:
                    System.out.println("Cart");
                    System.out.println("Quanity | Price | Item");
//                    for (int i = 0; i < items.size(); i++) {
//                        System.out.print((i + 1) + ". " + items.get(i));
//                        System.out.println(" for $" + price.get(i));
//                    }
                    for (int i =0; i < items.size(); i++) {
                        String key = "$" + price.get(i) + " - " + items.get(i);
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                    map.forEach((k, v) -> System.out.println(v + "x - " + k));
                    break;

                case 5:
                    System.out.println("Checkout");
                    int total = 0;
                    for (int i : price) {
                        total += i;
                    }
                    System.out.println("You owe $" + total);

//                    System.out.println("Please confirm to pay $" + total + " type 1 or 2");
//                    int confirm = scanner.nextInt();

                    System.out.println("Please enter the method you want to pay");
                    System.out.println("1. Bank Transfer");
                    System.out.println("2. Credit Card Payment");
                    System.out.println("3. Paypal Payment");
                    int confirm =  scanner.nextInt();
                    System.out.println("Please confirm you want to pay with: " + paymentOptions[confirm-1] + ", type 1 or 2");
                    confirm = scanner.nextInt();
                    if (confirm == 1) {
                        System.out.println("You've successfully used " + paymentOptions[confirm-1] + " to pay $" + total + ". Have a great day!");
                        running = false;
                        break;
                    } else if (confirm == 2) {
                        System.out.println("Payment failed, please try again");
                        break;
                    }
            }
        }
    }

    public static void main(String[] args) {
        getPurchase();
    }
}
