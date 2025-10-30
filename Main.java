import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> birds = new TreeSet<String>();
        String[] array = {"Hummingbird", "Flicker", "Sparrow", "Snowy Owl"};
        for (int i = 0; i < array.length; i++) {
            birds.add(array[i]);
        }

// Answer what prints out here for question 1
        System.out.println(birds);

        String[] array2 = {"Flicker", "Bushtit"};
        for (int i = 0; i < array2.length; i++) {
            birds.remove(array2[i]);
        }

// Answer what prints out here for question 2
        System.out.println(birds);

        String[] array3 = {"Stellar's Jay", "Crow", "Sparrow"};
        for (int i = 0; i < array3.length; i++) {
            birds.add(array3[i]);
        }

// Answer what prints out here for question 3
        System.out.println(birds);
    }

    public static void mystery1(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<Integer>();
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
            q.add(n);
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        System.out.println(s);
    }
    public static List<Integer> mystery(int[][] data) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data[i].length - 1; j++) {
                result.add(data[i][j] - 1);
            }
        }
        return result;
    }
}
