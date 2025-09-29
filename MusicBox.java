// Joewah Yu
// 09/29/2025
// CSE 122
// P0: Warm Up
// TA: Katharine Zhang

import java.util.*;

//This class is ...
public class MusicBox {
    public static final String NOTES = "CDEFGAB";
    public static final String SHARP = "♯";
    public static final String FLAT = "♭";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[][] song = composeSong(console);
        System.out.println("Returned song 2D array:");
        for (int i = 0; i < song.length; i++) {
            for (int j = 0; j < song[0].length; j++) {
                System.out.print(song[i][j] + " ");
            }
            System.out.println();
        }
    }

    // TODO: write the composeSong method and helper methods here

    public static String[][] composeSong(Scanner console) {
        int melodiesNum = getMelodies(console);
        int lengthNum = getLength(console);

        System.out.println();

        String[][] song = new String[melodiesNum][lengthNum];

        for (int i = 0; i < melodiesNum; i++) {
            System.out.println("Composing melody #" + (i + 1));
            for (int j = 0; j < lengthNum; j++) {
                System.out.print("Enter note #" + (i + 1) + ": ");
                song[i][j] = console.next();
            }
            System.out.println();
        }
        return song;
    }
    public static int getMelodies(Scanner console) {
        System.out.print("Enter the number of melodies: ");
        String melodies = console.nextLine();
        return Integer.parseInt(melodies);
    }

    public static int getLength(Scanner console) {
        System.out.print("Enter the length of each melody: ");
        String length = console.nextLine();
        return Integer.parseInt(length);
    }

    public static String[] mostCommonNaturals(String[][] song) {
        String[] naturalsArray = new String[song.length];
        String[] normalNotes = NOTES.split("");
        int[] notesTracker = new int[normalNotes.length];

        for (int i = 0; i < song.length; i++) {
            for (int j = 0; j < song[i].length; j++) {
                for (int k = 0; k < normalNotes.length; k++) {
                    if (song[i][j].equals(normalNotes[k])) {
                        notesTracker[k]++;
                    }
                }
            }
            naturalsArray[i] = song[i][song[0].length - 1];
        }


        return naturalsArray;
    }
}