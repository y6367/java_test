// TODO: Write your header comment here!

// TODO: Write your class comment here! 

import java.util.*;
import java.io.*;

public class Absurdle  {
    public static final String GREEN = "🟩";
    public static final String YELLOW = "🟨";
    public static final String GRAY = "⬜";

    // [[ ALL OF MAIN PROVIDED ]]
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the game of Absurdle.");

        System.out.print("What dictionary would you like to use? ");
        String dictName = console.next();

        System.out.print("What length word would you like to guess? ");
        int wordLength = console.nextInt();

        List<String> contents = loadFile(new Scanner(new File(dictName)));
        Set<String> words = prepDictionary(contents, wordLength);

        List<String> guessedPatterns = new ArrayList<>();
        while (!isFinished(guessedPatterns)) {
            System.out.print("> ");
            String guess = console.next();
            String pattern = recordGuess(guess, words, wordLength);
//            System.out.println(words);
            guessedPatterns.add(pattern);
            System.out.println(": " + pattern);
            System.out.println();
        }
        System.out.println("Absurdle " + guessedPatterns.size() + "/∞");
        System.out.println();
        printPatterns(guessedPatterns);
    }

    // [[ PROVIDED ]]
    // Prints out the given list of patterns.
    // - List<String> patterns: list of patterns from the game
    public static void printPatterns(List<String> patterns) {
        for (String pattern : patterns) {
            System.out.println(pattern);
        }
    }

    // [[ PROVIDED ]]
    // Returns true if the game is finished, meaning the user guessed the word. Returns
    // false otherwise.
    // - List<String> patterns: list of patterns from the game
    public static boolean isFinished(List<String> patterns) {
        if (patterns.isEmpty()) {
            return false;
        }
        String lastPattern = patterns.get(patterns.size() - 1);
        return !lastPattern.contains("⬜") && !lastPattern.contains("🟨");
    }

    // [[ PROVIDED ]]
    // Loads the contents of a given file Scanner into a List<String> and returns it.
    // - Scanner dictScan: contains file contents
    public static List<String> loadFile(Scanner dictScan) {
        List<String> contents = new ArrayList<>();
        while (dictScan.hasNext()) {
            contents.add(dictScan.next());
        }
        return contents;
    }

    // TODO: Write your code here! 

    public static Set<String> prepDictionary(List<String> contents, int wordLength) {
        Set<String> words = new HashSet<>();
        if (wordLength < 1) {
            throw new IllegalArgumentException();
        }
        for (String word : contents) {
            if (word.length() == wordLength) {
                words.add(word);
            }
        }
        return words;
    }

    public static String recordGuess(String guess, Set<String> words, int wordLength) {
        if (words.isEmpty() || guess.length() != wordLength) {
            throw new IllegalArgumentException();
        }
        Map<String, Set<String>> possibleWords = new TreeMap<>();
        for (String word : words) {
            if (word.length() == wordLength) {
                String pattern = patternFor(word, guess);
                if (possibleWords.containsKey(pattern)) {
                    Set<String> current = possibleWords.get(pattern);
                    current.add(word);
                    possibleWords.put(pattern,  current);
                } else {
                    Set<String> current = new HashSet<>();
                    current.add(word);
                    possibleWords.put(pattern,  current);
                }
            }
        }

        String mostPattern = "";
        int mostWords = 0;
        for (String pattern : possibleWords.keySet()) {
            int size = possibleWords.get(pattern).size();
            if (size > mostWords) {
                mostPattern = pattern;
                mostWords = size;
            }
        }
        System.out.println(possibleWords);
        System.out.println(mostPattern);
        words.clear();
        words.addAll(possibleWords.get(mostPattern));

        return mostPattern;
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
        for (int i = 0; i < guessStr.size(); i++) {
            char letter = word.charAt(i);
            if (guessStr.get(i).equals(String.valueOf(letter))) {
                guessStr.set(i, GREEN);
                int count = guessValues.get(letter);
                guessValues.put(letter, count - 1);
            }
        }

        for (int i = 0; i < guessStr.size(); i++) {
            String guessLetter = guessStr.get(i);
            if (guessValues.containsKey(guessLetter.charAt(0)) && guessValues.get(guessLetter.charAt(0)) > 0) {
                guessStr.set(i, YELLOW);
                int count = guessValues.get(guessLetter.charAt(0));
                guessValues.put(guessLetter.charAt(0), count - 1);
            }
        }

        for (int i = 0; i < guessStr.size(); i++) {
            String letter = guessStr.get(i);
            if (!letter.equals(GREEN) && !letter.equals(YELLOW)) {
                guessStr.set(i, GRAY);
            }
        }
        guess = "";
        for (int i = 0; i < guessStr.size(); i++) {
            guess += guessStr.get(i);
        }
        return guess;
    }
}
