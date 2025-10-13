import java.util.*;
import java.io.*;

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
        while (userAction.equalsIgnoreCase("a") || userAction.equalsIgnoreCase("m") ||
                userAction.equalsIgnoreCase("l") || userAction.equalsIgnoreCase("s") ||
                !userAction.equalsIgnoreCase("q")) {
            
            if (userAction.equalsIgnoreCase("a")) {
                addItem(console, todos);
            } else if (userAction.equalsIgnoreCase("m")) {

            } else if (userAction.equalsIgnoreCase("l")) {

            } else if (userAction.equalsIgnoreCase("s")) {

            } else {
                System.out.println("Unknown console: " + userAction);
                printTodos(todos);
            }
            System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? ");
            userAction = console.nextLine();
        }
    }

    public static void printTodos(List<String> todos) {
        // TODO: Your Code Here
        System.out.println("Today's TODOs:");
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ": " + todos.get(i));
        }
        System.out.println("  You have nothing to do yet today! Relax!");
    }

    public static void addItem(Scanner console, List<String> todos) {
        // TODO: Your Code Here
        System.out.print("What would you like to add? ");
        String userInput = console.nextLine();
        int userIndex;
        if (todos.size() > 0) {
            System.out.print("Where in the list should it be (1-" + (todos.size() + 1) + ")? (Enter for end): ");
            String indexString = console.nextLine();
            if (indexString == "") {
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

    public static void markItemAsDone(Scanner console, List<String> todos) {
        // TODO: Your Code Here
    }

    public static void loadItems(Scanner console, List<String> todos)
            throws FileNotFoundException {
        // TODO: Your Code Here
    }

    public static void saveItems(Scanner console, List<String> todos)
            throws FileNotFoundException {
        // TODO: Your Code Here
    }
}