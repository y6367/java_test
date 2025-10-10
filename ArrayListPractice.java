import java.util.*;
import java.io.*;

public class ArrayListPractice {
    public static void main(String[] args) throws FileNotFoundException {
        // Set up
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(18.5);
        doubles.add(-1384.2);
        doubles.add(99.99999);
        doubles.add(21.0);
        doubles.add(134.12462487);

        List<Integer> integers = new ArrayList<Integer>();
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        moveRight(integers, 1);
        System.out.println(integers);

        List<Integer> integers2 = new ArrayList<Integer>();
        integers2.add(7);
        integers2.add(5);
        integers2.add(9);
        integers2.add(0);
        integers2.add(2);
        compareToList(integers, integers2);

        List<Character> characters = new ArrayList<Character>();
        characters.add('g');
        characters.add('u');
        characters.add('m');
        characters.add('b');
        characters.add('a');
        characters.add('l');
        characters.add('l');
        List<Character> result = topN(characters, 3);
        System.out.println(result);

        Scanner fileScan = new Scanner(new File("words.txt"));
        ArrayList<String> words = loadFromFile(fileScan);
        System.out.println(words);
    }
    // 1. write loadFromFile here
    public static ArrayList<String> loadFromFile(Scanner fileScan) {
        ArrayList<String> result = new ArrayList<String>();
        while(fileScan.hasNextLine()) {
            result.add(fileScan.nextLine());
        }
        result.remove(result.size()-1);
        return result;
    }

    // 2. write moveRight here
    public static void moveRight(List<Integer> list, int index) {
        int temp = list.remove(index);
        list.add(index + 1, temp);
    }

    // 3. write compareToList here
    public static void compareToList(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) == list2.get(j)) {
                    System.out.println(list1.get(i) + " (list 1 at " + i + ", list2 at " + j + ")");
                }
            }
        }
    }

    // 4. write topN here
    public static List<Character> topN(List<Character> characters, int n) {
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(characters.get(i));
        }
        return result;
    }
}