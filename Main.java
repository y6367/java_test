import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(10);
        num.add(2);
        num.add(33);
        num.add(44);
        System.out.println(num);
        num.remove(2);
        System.out.println(num);
    }
}
