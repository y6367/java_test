import java.util.*;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> s3 = new Stack<Integer>();
        s3.push(2);
        s3.push(6);
        s3.push(1);

        mystery1(s3);
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
