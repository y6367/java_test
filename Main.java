import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(8);
//        list.add(-4);
//        list.add(16);
//        list.add(9);
//        list.add(1);
//        list.add(64);
//        list.add(25);
//        list.add(36);
//        list.add(4);
//        list.add(49);
        mystery1(list);
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
}
