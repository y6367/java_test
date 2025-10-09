import java.util.*;
import java.io.*;

public class CoinFlip {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input1 = new Scanner(new File("test1.txt"));
//        Scanner input2 = new Scanner(new File("test2.txt"));
//        Scanner input3 = new Scanner(new File("test3.txt"));

        coinFlip(input1);
//        coinFlip(input2);
//        coinFlip(input3);
    }

    public static void coinFlip(Scanner input) {
        while(input.hasNextLine()) {
            int heads = 0;
            int tails = 0;
            String flips = input.nextLine();

            if (input.hasNext()) {
                
            }



            for (int i = 0; i < flips.length(); i++) {
                if (flips.charAt(i) == 'H' || flips.charAt(i) == 'h') {
                    heads++;
                } else if (flips.charAt(i) == ' ') {
                    heads++;
                    heads--;
                }
                else {
                    tails++;
                }
            }
            double headDouble = heads;
            double tailDouble = tails;
            double percent = (headDouble / (headDouble + tailDouble)) * 100.0;
//            System.out.print(heads + " heads (");
            System.out.printf("%d heads (%.1f%%)", heads, percent);
            System.out.println();
            if (percent > 50) {
                System.out.println("You win!");
            }
        }
    }
    // Your code here
}