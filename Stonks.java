// Joewah Yu
// 10/06/2025
// CSE 122
// P0: Stonks
// TA: Katharine Zhang

import java.util.*;
import java.io.*;

// This class is a stock market simulator, where you can do many things, as if
// you were actually buying stocks.
public class Stonks {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: write main method here
        System.out.print("Enter stocks file name: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        File f = new File(fileName);
        Scanner fileScan = new Scanner(f);

        int stockAmount = fileScan.nextInt();
        String[] stocks = new String[stockAmount];
        double[] prices = new double[stockAmount];
        double[] portfolio = new double[stockAmount];

        setStonks(fileScan, stockAmount, stocks, prices);
        stonksMenu(input, stockAmount, stocks, prices, portfolio);
    }

    // TODO: write your methods here

    // This method loads the stonks on the market.
    // Returns: Printing to console.
    // Parameters:
    // - Scanner to take in input
    // - Integer to know the amount of stocks available.
    // - String array to have a name of stocks
    // - Double array to list prices for each stock.
    public static void setStonks(Scanner fileScan, int stockAmount, String[] stocks,
                                 double[] prices) {
        System.out.println("");
        System.out.println("Welcome to the CSE 122 Stocks Simulator!");
        fileScan.nextLine();
        fileScan.nextLine();
        for (int i = 0; i < stockAmount; i++) {
            stocks[i] = fileScan.next();
            prices[i] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        System.out.println("There are " + stockAmount + " stocks on the market:");
        for (int i = 0; i < stockAmount; i++) {
            System.out.println(stocks[i] + ": " + prices[i]);
        }
    }

    // This method loops through stock menu until user quits.
    // Returns: Printing to console.
    // Parameters:
    // - Scanner to take in input
    // - Integer to know the amount of stocks.
    // - String array to have a name of stocks
    // - Double array to list prices for each stock.
    // - Double array to keep track of shares bought per stock.
    // Exceptions: FileNotFound thrown if no file is found.
    public static void stonksMenu(Scanner input, int stockAmount, String[] stocks, double[] prices,
                                  double[] portfolio) throws FileNotFoundException {
        String selection = "";
        while (!selection.equals("Q") && !selection.equals("q")) {
            System.out.println("");
            System.out.println("Menu: (B)uy, (Se)ll, (D)isplay, (S)ave, (Q)uit");
            System.out.print("Enter your choice: ");
            selection = input.nextLine();
            if (selection.equals("B") || selection.equals("b")) {
                buyStonks(input, stockAmount, stocks, prices, portfolio);
            } else if (selection.equals("Se") || selection.equals("se") || selection.equals("SE")
                    || selection.equals("sE")) {
                sellStonks(input, stockAmount, stocks, portfolio);
            } else if (selection.equals("D") || selection.equals("d")) {
                displayStonks(stockAmount, stocks, portfolio);
            } else if (selection.equals("S") || selection.equals("s")) {
                saveStonks(input, stockAmount, stocks, portfolio);
            } else if (selection.equals("Q")  || selection.equals("q")) {
                quitStonks(stockAmount, prices, portfolio);
            } else {
                System.out.println("Invalid choice: " + selection);
                System.out.println("Please try again");
            }
        }
    }

    // This method buys stocks.
    // Returns: Printing to console.
    // Parameters:
    // - Scanner to take in input
    // - Integer to know the amount of stocks.
    // - String array to have a name of stocks
    // - Double array to list prices for each stock.
    // - Double array to keep track of shares bought per stock.
    public static void buyStonks(Scanner input, int stockAmount, String[] stocks,
                                 double[] prices, double[] portfolio) {
        System.out.print("Enter the stock ticker: ");
        String stock = input.nextLine();
        System.out.print("Enter your budget: ");
        String budgetStr = input.nextLine();
        double budget = Double.parseDouble(budgetStr);
        if (budget < 5.0) {
            System.out.println("Budget must be at least $5");
        } else {
            for (int i = 0; i < stockAmount; i++) {
                if (stocks[i].equals(stock)) {
                    portfolio[i] += budget / prices[i];
                }
            }
            System.out.println("You successfully bought " + stock + ".");
        }
    }

    // This method sells stocks in portfolio
    // Returns: Printing to console.
    // Parameters:
    // - Scanner to take in input
    // - Integer to know the amount of stocks.
    // - String array to have a name of stocks
    // - Double array to keep track of shares bought per stock.
    public static void sellStonks(Scanner input, int stockAmount, String[] stocks,
                                  double[] portfolio) {
        System.out.print("Enter the stock ticker: ");
        String stock = input.nextLine();
        System.out.print("Enter the number of shares to sell: ");
        String sellStr = input.nextLine();
        double sellAmount = Double.parseDouble(sellStr);
        for (int i = 0; i < stockAmount; i++) {
            if (stocks[i].equals(stock)) {
                if (portfolio[i] < sellAmount) {
                    System.out.println("You do not have enough shares of " + stock +
                            " to sell " + sellAmount + " shares.");
                } else {
                    portfolio[i] -= sellAmount;
                    System.out.println("You successfully sold " + sellAmount + " shares of " + stock + ".");
                }
            }
        }
    }

    // This method displays shares of each owned stock.
    // Returns: Printing to console.
    // Parameters:
    // - Integer to know the amount of stocks.
    // - String array to have a name of stocks.
    // - Double array to keep track of shares bought per stock.
    public static void displayStonks(int stockAmount, String[] stocks, double[] portfolio) {
        System.out.println("Portfolio:");
        for (int i = 0; i < stockAmount; i++) {
            if (portfolio[i] > 0.0) {
                System.out.println(stocks[i] + " " + portfolio[i]);
            }
        }
    }

    // This method puts stocks that are in portfolio to new text file.
    // Returns: Printing to console and printing to new file.
    // Parameters:
    // - Scanner to take in input.
    // - Integer to know the amount of stocks available.
    // - String array to have a name of stocks.
    // - Double array to keep track of shares bought per stock.
    // Exceptions: FileNotFound thrown if no file is found.
    public static void saveStonks(Scanner input, int stockAmount, String[] stocks,
                                  double[] portfolio) throws FileNotFoundException {
        System.out.print("Enter new portfolio file name: ");
        String portfolioFileName = input.nextLine();
        PrintStream output = new PrintStream(new File(portfolioFileName));
        for (int i = 0; i < stockAmount; i++) {
            if (portfolio[i] > 0.0) {
                output.println(stocks[i] + " " + portfolio[i]);
            }
        }
    }

    // This method prints portfolio value before exiting while loop
    // Returns: Printing to console.
    // Parameters:
    // - Integer to know the amount of stocks available.
    // - Double array to list prices for each stock.
    // - Double array to keep track of shares bought per stock.
    public static void quitStonks(int stockAmount, double[] prices, double[] portfolio) {
        double value = 0;
        for (int i = 0; i < stockAmount; i++) {
            value += prices[i] * portfolio[i];
        }
        System.out.println("");
        System.out.println("Your portfolio is currently valued at: $" + value);
    }
}