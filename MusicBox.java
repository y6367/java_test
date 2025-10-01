// Joewah Yu
// 09/29/2025
// CSE 122
// P0: Warm Up
// TA: Katharine Zhang

import java.util.*;

// This class is a music box. It takes in melodies and the length of each melody and returns
// the melodies in a 2D array. It also finds the most common natural note for each melody.
public class MusicBox {
    public static final String NOTES = "CDEFGAB";
    public static final String SHARP = "♯";
    public static final String FLAT = "♭";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[][] song = composeSong(console);
        System.out.println("Returned song 2D array:");
        for (int i = 0; i < song.length; i++) {
            for (int j = 0; j < song[i].length; j++) {
                System.out.print(song[i][j] + " ");
            }
            System.out.println();
        }

        String[] mostCommon = mostCommonNaturals(song);
        System.out.println("Most common natural notes in each melody:");
        for (int i = 0; i < mostCommon.length; i++) {
            System.out.print(mostCommon[i] + " ");
        }
    }

    // TODO: write the composeSong method and helper methods here

    // This method takes melodies and notes and output them as a 2D array.
    // Returns: 2D string array with the given notes and melodies entered by the user.
    // Parameters: Scanner parameter in order to get input.
    public static String[][] composeSong(Scanner console) {
        int melodiesNum = getMelodies(console);
        int lengthNum = getLength(console);

        System.out.println();

        String[][] song = new String[melodiesNum][lengthNum];

        for (int i = 0; i < melodiesNum; i++) {
            System.out.println("Composing melody #" + (i + 1));
            for (int j = 0; j < lengthNum; j++) {
                System.out.print("Enter note #" + (j + 1) + ": ");
                song[i][j] = console.next();
            }
            System.out.println();
        }
        return song;
    }

    // This method takes the number of melodies from the user.
    // Returns: integer that has the number of melodies entered by the user.
    // Parameters: Scanner parameter in order to get input.
    public static int getMelodies(Scanner console) {
        System.out.print("Enter the number of melodies: ");
        String melodies = console.nextLine();
        return Integer.parseInt(melodies);
    }

    // This method takes the length of each melody from the user.
    // Returns: integer that has the length of melodies entered by the user.
    // Parameters: Scanner parameter in order to get input.
    public static int getLength(Scanner console) {
        System.out.print("Enter the length of each melody: ");
        String length = console.nextLine();
        return Integer.parseInt(length);
    }

    // This method calculates the most common naturals in each melody.
    // Returns: String array with the most common natural notes for each melody.
    // Parameters: 2D String array to get notes and melodies entered previously.
    public static String[] mostCommonNaturals(String[][] song) {
        String[] naturalsArray = new String[song.length];

        for (int i = 0; i < song.length; i++) {
            // A way to mark each time a note has been found.
            int[] notesTracker = new int[NOTES.length()];

            sortNaturals(song[i], notesTracker);
            // Set variables after naturals notes have been sorted.
            int mostCommonIndex = 0;
            int maxCount = notesTracker[0];

            mostCommonIndex = mostNaturals(notesTracker, mostCommonIndex, maxCount);
            // Turn char into string, then put the character of mostCommonIndex in string array.
            naturalsArray[i] = String.valueOf(NOTES.charAt(mostCommonIndex));
        }

        return naturalsArray;
    }

    // This method sorts the natural notes for each melody.
    // Returns: an update to the notesTracker array to list each time a note was found.
    // Parameters:
    // String array to get current melody,
    // integer array to track each time a note is found in melody.
    public static void sortNaturals(String[] songLine, int[] notesTracker) {
        for (int j = 0; j < songLine.length; j++) {
            for (int k = 0; k < NOTES.length(); k++) {
                // Turns char into string to compare with string.
                if (songLine[j].equals(String.valueOf(NOTES.charAt(k)))) {
                    notesTracker[k]++;
                }
            }
        }
    }

    // This method finds the most natural notes in each melody after melody is sorted.
    // Returns: integer of the index of the most found note in the notesTracker array.
    // Parameters:
    // integer array of each time a note is found,
    // integer mostCommonIndex is the most common index in melody,
    // integer maxCount is the value of the most common index.
    public static int mostNaturals(int[] notesTracker, int mostCommonIndex, int maxCount) {
        for (int j = 1; j < NOTES.length(); j++) {
            if (notesTracker[j] > maxCount) {
                maxCount = notesTracker[j];
                mostCommonIndex = j;
            }
        }
        return mostCommonIndex;
    }
}