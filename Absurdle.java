// Joewah Yu
// 10/29/2025
// CSE 122
// P2: Absurdle
// TA: Katharine Zhang

// TODO: Write your class comment here!
// This class is a game inspired from the popular game Wordle, where there is a word that has to be
// guessed. There are infinite guesses and no set word, the game tries to keep the game going
// for as long as possible.

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

    // This method takes words from a file that matches the desired word length into a set before
    // the game starts. This happens only if the desired word length is more than 1.
    // Exception: If the desired word length is less than 1, an IllegalArgumentException is thrown
    // Returns: Returns a HashSet of words for the game.
    // Parameters:
    // - contents: contains all the words in the word file
    // - wordLength: the amount of letters each word should have in the game
    public static Set<String> prepDictionary(List<String> contents, int wordLength) {
        if (wordLength < 1) {
            throw new IllegalArgumentException();
        }
        Set<String> words = new HashSet<>();
        for (String word : contents) {
            if (word.length() == wordLength) {
                words.add(word);
            }
        }
        return words;
    }

    // This method processes the user's guess to update the set of words that are valid in the
    // game. This happens only if the set of words is not empty and if the user's guessed word has
    // the right length.
    // Exception: If the set of words is empty or the guess from the user does not have the right
    // length, an IllegalArgumentException is thrown
    // Returns: Returns a String that has the guessed word translated into the color pattern
    // Parameters:
    // - guess: the word that the user has guessed
    // - words: the set of words that are still in the game
    // - wordLength: the amount of letters each word should have in the game
    public static String recordGuess(String guess, Set<String> words, int wordLength) {
        if (words.isEmpty() || guess.length() != wordLength) {
            throw new IllegalArgumentException();
        }
        Map<String, Set<String>> possibleWords = new TreeMap<>();
        for (String word : words) {
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
        String mostPattern = containsMost(possibleWords, words);
        return mostPattern;
    }

    // This method turns the user's guess into a pattern
    // Returns: Returns a String that has the guessed word translated into the color pattern
    // Parameters:
    // - word: the word that is being guessed
    // - guess: the user's guess
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
        convertToPattern(guessStr, word, guessValues);
        guess = "";
        for (int i = 0; i < guessStr.size(); i++) {
            guess += guessStr.get(i);
        }
        return guess;
    }

    // This method identifies the pattern that contains the most words.
    // Returns: pattern containing the most words
    // Parameters:
    // - possibleWords: a map containing patterns along with words that match the pattern
    // - mostPattern: a string that houses the pattern with the most words that match the pattern
    // - words: the set of words that are in play
    public static String containsMost(Map<String, Set<String>> possibleWords, Set<String> words) {
        String mostPattern = "";
        int mostWords = 0;
        for (String pattern : possibleWords.keySet()) {
            int size = possibleWords.get(pattern).size();
            if (size > mostWords) {
                mostPattern = pattern;
                mostWords = size;
            }
        }
        words.clear();
        words.addAll(possibleWords.get(mostPattern));
        return mostPattern;
    }

    // This changes the letter in the words into colors that represent the pattern
    // Parameters:
    // - guessStr: ArrayList containing each letter of the user's guess
    // - word: the word that is being guessed
    // - guessValues: counts the characters from the word
    public static void convertToPattern(List<String> guessStr, String word,
                                        Map<Character, Integer> guessValues) {
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
    }
}
