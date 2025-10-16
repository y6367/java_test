import java.util.*;

public class IsPalindrome {
    public static void main(String[] args) {
        Queue<Character> tacocatQueue = new LinkedList<>(Arrays.asList('t', 'a', 'c', 'o', 'c', 'a', 't'));
        Queue<Character> noonQueue = new LinkedList<>(Arrays.asList('N', 'O', 'O', 'N'));
        Queue<Character> helloQueue = new LinkedList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        Queue<Character> hannahQueue = new LinkedList<>(Arrays.asList('h', 'a', 'n', 'n', 'a', 'h'));

        System.out.println(isPalindrome(tacocatQueue));
        System.out.println(isPalindrome(noonQueue));
        System.out.println(isPalindrome(helloQueue));
        System.out.println(isPalindrome(hannahQueue));
    }

    /* TODO */
    // implement the isPalindrome() method below.
    public static boolean isPalindrome(Queue<Character> queue) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < queue.size(); i++) {
            char ch = queue.remove();
            stack.push(ch);
            queue.add(ch);
        }
        for (int i = 0; i < queue.size(); i++) {
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }
        return true;
    }
}