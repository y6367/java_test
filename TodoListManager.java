// Joewah Yu
// 10/13/2025
// CSE 122
// C1: TODO list
// TA: Katharine Zhang

import java.util.*;
import java.io.*;

// This class is a To-do List simulator. You can add and remove a single thing or a range of things
// from the to-do list. You can also save your list and load your list to/from a file.
public class TodoListManager {
    public static final boolean EXTENSION_FLAG = false;

    public static void main(String[] args) throws FileNotFoundException {
        // TODO: Your Code Here
        List<String> todos = new ArrayList<String>();
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to your TODO List Manager!");
        System.out.println("What would you like to do?");
        System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? ");
        String userAction = console.nextLine();
        while (!userAction.equalsIgnoreCase("q")) {

            if (userAction.equalsIgnoreCase("a")) {
                addItem(console, todos);
            } else if (userAction.equalsIgnoreCase("m")) {
                if (EXTENSION_FLAG) {
                    markRangeAsDone(console, todos);
                } else {
                    markItemAsDone(console, todos);
                }
            } else if (userAction.equalsIgnoreCase("l")) {
                loadItems(console, todos);
            } else if (userAction.equalsIgnoreCase("s")) {
                saveItems(console, todos);
            } else {
                System.out.println("Unknown input: " + userAction);
                printTodos(todos);
            }
            System.out.println("What would you like to do?");
            System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, " +
                    "(Q)uit? ");
            userAction = console.nextLine();
        }
    }

    // This method prints the current things to do
    // Returns: Does not return anything, only prints to console
    // Parameters:
    // - ArrayList of current things to do
    public static void printTodos(List<String> todos) {
        // TODO: Your Code Here
        System.out.println("Today's TODOs:");
        for (int i = 0; i < todos.size(); i++) {
            System.out.println("  " + (i + 1) + ": " + todos.get(i));
        }
        if (todos.isEmpty()) {
            System.out.println("  You have nothing to do yet today! Relax!");
        }
    }

    // This method adds items to the to-do list, with the user being asked where the item
    // should be placed, except for when the list is empty.
    // Returns: Does not return anything, only prints to console
    // Parameters:
    // - Scanner to take in user input
    // - ArrayList of current things to do
    public static void addItem(Scanner console, List<String> todos) {
        // TODO: Your Code Here
        System.out.print("What would you like to add? ");
        String userInput = console.nextLine();
        int userIndex;
        if (todos.size() > 0) {
            System.out.print("Where in the list should it be (1-" + (todos.size() + 1) + ")? " +
                    "(Enter for end): ");
            String indexString = console.nextLine();
            if (indexString.isEmpty()) {
                userIndex = todos.size();
            } else {
                userIndex = Integer.parseInt(indexString) - 1;
            }
            todos.add(userIndex, userInput);
        } else {
            todos.add(userInput);
        }
        printTodos(todos);
    }

    // This method removes a single item in the to-do list only if there are items in the
    // to-do list.
    // Returns: Does not return anything, only prints to console
    // Parameters:
    // - Scanner to take in user input
    // - ArrayList of current things to do
    public static void markItemAsDone(Scanner console, List<String> todos) {
        // TODO: Your Code Here
        if (todos.isEmpty()) {
            System.out.println("All done! Nothing left to mark as done!");
        } else {
            System.out.print("Which item did you complete (1-" + todos.size() + ")? ");
            int markIndex = Integer.parseInt(console.nextLine());
            todos.remove(markIndex - 1);
        }
        printTodos(todos);
    }

    // Extension
    // This method removes a range of items in the to-do list only if there are items in the
    // to-do list.
    // Returns: Does not return anything, only prints to console
    // Parameters:
    // - Scanner to take in user input
    // - ArrayList of current things to do
    public static void markRangeAsDone(Scanner console, List<String> todos) {
        if (todos.isEmpty()) {
            System.out.println("All done! Nothing left to mark as done!");
        } else {
            System.out.print("What is the first item you completed (1-" + todos.size() + ")? ");
            int firstIndex = Integer.parseInt(console.nextLine());
            System.out.print("What is the last item you completed (1-" + todos.size() + ")? ");
            int lastIndex = Integer.parseInt(console.nextLine());
            int times = lastIndex - firstIndex + 1;

            for (int i = 0; i < times; i++) {
                todos.remove(firstIndex - 1);
            }
            printTodos(todos);
        }
    }

    // This method clears the current to-do list and loads to-do items from a file into
    // the to-do list
    // Returns: Does not return anything, only prints to console
    // Parameters:
    // - Scanner to take in user input
    // - ArrayList of current things to do
    public static void loadItems(Scanner console, List<String> todos)
            throws FileNotFoundException {
        System.out.print("File name? ");
        String fileName = console.nextLine();
        Scanner fileScan = new Scanner(new File(fileName));
        todos.clear();
        while (fileScan.hasNextLine()) {
            todos.add(fileScan.nextLine());
        }
        printTodos(todos);
        // TODO: Your Code Here
    }

    // This method stores to-do actions into a file
    // Returns: Does not return anything, only prints to console
    // Parameters:
    // - Scanner to take in user input
    // - ArrayList of current things to do
    public static void saveItems(Scanner console, List<String> todos)
            throws FileNotFoundException {
        // TODO: Your Code Here
        System.out.print("File name? ");
        String fileName = console.nextLine();
        PrintStream output = new PrintStream(new File(fileName));
        for (int i = 0; i < todos.size(); i++) {
            output.println(todos.get(i));
        }
        printTodos(todos);
    }
}