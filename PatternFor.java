import java.util.*;

public class PatternFor {
    public static final String GREEN = "🟩";
    public static final String YELLOW = "🟨";
    public static final String GRAY = "⬜";

    public static void main(String[] args) {
        System.out.println(patternFor("abbey", "bebop"));
        System.out.println(patternFor("abbey", "ether"));
        System.out.println(patternFor("abbey", "keeps"));
        System.out.println(patternFor("bebop", "abbey"));
    }

    public static String patternFor(String word, String guess) {
        List<String> guessStr = new ArrayList<String>();
        Map<Character, Integer> guessValues = new HashMap<Character, Integer>();
        for (int i = 0; i < guess.length(); i++) {
            String letter = String.valueOf(guess.charAt(i));
            guessStr.add(letter);
        }

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (guessValues.containsKey(letter)) {
                int count = guessValues.get(letter) + 1;
                guessValues.put(letter, count);
            } else {
                guessValues.put(letter, 1);
            }
        }
        System.out.println("GUESS VALUES: " + guessValues);

        for (int i = 0; i < guessStr.size(); i++) {
            char letter = word.charAt(i);
            if (guessStr.get(i).equals(String.valueOf(letter))) {
                guessStr.set(i, GREEN);
                int count = guessValues.get(letter);
                guessValues.put(letter, count - 1);
                System.out.println(guessStr);
            }
        }

        for (int i = 0; i < guessStr.size(); i++) {
            String guessLetter = guessStr.get(i);
            if (guessValues.containsKey(guessLetter.charAt(0)) && guessValues.get(guessLetter.charAt(0)) > 0) {
                guessStr.set(i, YELLOW);
                int count = guessValues.get(guessLetter.charAt(0));
                guessValues.put(guessLetter.charAt(0), count - 1);
                System.out.println(guessStr);
            }
        }
        System.out.println("GUESS VALUES: " + guessValues);

        for (int i = 0; i < guessStr.size(); i++) {
            String letter = guessStr.get(i);
            if (!letter.equals(GREEN) && !letter.equals(YELLOW)) {
                guessStr.set(i, GRAY);
                System.out.println(guessStr);
            }
        }



        guess = "";
        for (int i = 0; i < guessStr.size(); i++) {
            guess += guessStr.get(i);
        }
        return guess;
    }
}