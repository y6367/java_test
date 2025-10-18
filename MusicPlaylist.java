// Joewah Yu
// 10/18/2025
// CSE 122
// P1: Music Playlist
// TA: Katharine Zhang

import java.util.*;
import java.io.*;

// This class is a music playlist simulation, where you can listen to songs, view upcoming and
// previously played songs, and delete songs in the song history.
public class MusicPlaylist {
    // TODO: Your Code Here
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Queue<String> songQueue = new LinkedList<String>();
        Stack<String> songHistory = new Stack<String>();
        Stack<String> auxiliaryStack = new Stack<String>();

        System.out.println("Welcome to the CSE 122 Music Playlist!");
        String input = loopMenu(console);
        while (!input.equalsIgnoreCase("q")) {
            if (input.equalsIgnoreCase("a")) {
                System.out.print("Enter song name: ");
                String songName = console.nextLine();
                System.out.println("Successfully added " + songName);
                songQueue.add(songName);
            } else if (input.equalsIgnoreCase("p")) {
                playSong(songQueue, songHistory);
            } else if (input.equalsIgnoreCase("h")) {
                printHistory(songHistory, auxiliaryStack);
            } else if (input.equalsIgnoreCase("v")) {
                viewPlaylist(songQueue);
            } else if (input.equalsIgnoreCase("c")) {
                songHistory.clear();
            } else if (input.equalsIgnoreCase("d")) {
                System.out.println("A positive number will delete from recent history.");
                System.out.println("A negative number will delete from the beginning of history.");
                System.out.print("Enter number of songs to delete: ");
                int numDelete = Integer.parseInt(console.nextLine());
                deleteHistory(numDelete, songHistory, auxiliaryStack);
            }
            input = loopMenu(console);
        }
    }

    // This method prints menu option until user decides to quit
    // Returns: String that represents what action user wants to do
    // Parameters:
    // - console: to take in input
    public static String loopMenu(Scanner console) {
        System.out.println("(A) Add song");
        System.out.println("(P) Play song");
        System.out.println("(H) Print history");
        System.out.println("(V) View playlist");
        System.out.println("(C) Clear history");
        System.out.println("(D) Delete from history");
        System.out.println("(Q) Quit");
        System.out.println();
        System.out.print("Enter choice: ");
        return console.nextLine();
    }

    // This method plays a song only if there is a song in the playlist queue
    // Exception: If there are no songs in the playlist, an IllegalStateException is thrown
    // Returns: Printing to console.
    // Parameters:
    // - songQueue: the queue of songs not yet played
    // - songHistory: the history of the songs that have been played
    public static void playSong(Queue<String> songQueue, Stack<String> songHistory) {
        if (songQueue.isEmpty()) {
            throw new IllegalStateException("Music playlist is empty.");
        } else {
            String currentSong = songQueue.remove();
            songHistory.push(currentSong);
            System.out.println("Playing song: " +  currentSong);
            System.out.println();
        }
    }

    // This method prints the previously played songs only if there are songs that have been played
    // Exception: If there are no songs in the song history, an IllegalStateException is thrown
    // Returns: Printing to console.
    // Parameters:
    // - songHistory: the history of the songs that have been played
    // - auxiliaryStack: a temporary stack used to help order Stack<String> songHistory
    public static void printHistory(Stack<String> songHistory, Stack<String> auxiliaryStack) {
        if (songHistory.isEmpty()) {
            throw new IllegalStateException("Music history is empty.");
        } else {
            while (!songHistory.isEmpty()) {
                String removedSong = songHistory.pop();
                System.out.println("    " + removedSong);
                auxiliaryStack.push(removedSong);
            }
            while (!auxiliaryStack.isEmpty()) {
                songHistory.push(auxiliaryStack.pop());
            }
            System.out.println();
        }
    }

    // This method prints the songs in the playlist, only if there are songs in the playlist
    // Exception: If there are no songs in the playlist, an IllegalStateException is thrown
    // Returns: Printing to console.
    // Parameters:
    // - songQueue: the queue of songs not yet played
    public static void viewPlaylist(Queue<String> songQueue) {
        if (songQueue.isEmpty()) {
            throw new IllegalStateException("Music playlist is empty.");
        } else {
            int queueSize = songQueue.size();
            for (int i = 0; i < queueSize; i++) {
                String queuedSong = songQueue.remove();
                System.out.println("    " + queuedSong);
                songQueue.add(queuedSong);
            }
            System.out.println();
        }
    }

    // This method deletes songs from the beginning or the end of the listening history, only if
    // the input is less than the size of the history
    // Exception: If the size of the history is less than the absolute value of the user input,
    // an IllegalStateException is thrown
    // Returns: Printing to console.
    // Parameters:
    // - numDelete: the number determining how many songs to be deleted and in which direction
    // - songHistory: the history of the songs that have been played
    // - auxiliaryStack: a temporary stack used to help order Stack<String> songHistory
    public static void deleteHistory(int numDelete, Stack<String> songHistory,
                                     Stack<String> auxiliaryStack) {

        if (songHistory.size() < Math.abs(numDelete)) {
            throw new IllegalArgumentException("Not enough songs in history to delete.");
        } else {
            // delete recently played
            if (numDelete > 0) {
                for (int i = 0; i < numDelete; i++) {
                    songHistory.pop();
                }
                printHistory(songHistory, auxiliaryStack);
            } else { // delete from first played
                numDelete = Math.abs(numDelete);
                while (!songHistory.isEmpty()) {
                    auxiliaryStack.push(songHistory.pop());
                }
                for (int i = 0; i < numDelete; i++) {
                    auxiliaryStack.pop();
                }
                while (!auxiliaryStack.isEmpty()) {
                    songHistory.push(auxiliaryStack.pop());
                }
                printHistory(songHistory, auxiliaryStack);
            }
        }
    }
}