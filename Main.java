import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        List<String> arr3 = new ArrayList<>();
        List<String> arr4 = new ArrayList<>();
        List<String> arr5 = new ArrayList<>();
        arr1.add("poison");
        arr1.add("grass");
        map.put("Bulbasaur", arr1);
        arr2.add("electric");
        map.put("Pikachu", arr2);
        arr3.add("grass");
        arr3.add("poison");
        map.put("Amoo", arr3);
        arr4.add("electric");
        arr4.add("flying");
        map.put("Zaptos", arr4);
        arr5.add("electric");
        map.put("Ampharos", arr5);

        Map<Integer, List<String>> result = new TreeMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (String pokemon : map.keySet()) {
            List<String> list = map.get(pokemon);
            for (String type : list) {
                if (count.containsKey(type)) {
                    count.put(type, count.get(type) + 1);
                } else {
                    count.put(type, 1);
                }
            }
        }
        for (String type : count.keySet()) {
            if (result.containsKey(count.get(type))) {
                List<String> temp = result.get(count.get(type));
                temp.add(type);
                result.put(count.get(type), temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(type);
                result.put(count.get(type), temp);
            }
        }
        System.out.println(result);
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
