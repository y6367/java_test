import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(16);
        list.add(9);
        list.add(1);
        list.add(64);
        list.add(25);
        list.add(25);
        list.add(14);
        list.add(0);

        mystery(list);
    }

    public static void mystery1(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                int element = list.get(i);
                list.remove(i);
                list.add(0, element);
            }
        }

        System.out.println(list);

    }
    public static void mystery(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i += 2) {
            if (list.get(i - 1) >= list.get(i)) {
                list.remove(i);
                list.add(0, 0);
            }
        }
        System.out.println(list);
    }
}
