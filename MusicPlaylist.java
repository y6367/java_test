import java.util.*;
import java.io.*;

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
                if (songQueue.isEmpty()) {
                    throw new IllegalStateException("Music playlist is empty.");
                } else {
                    String currentSong = songQueue.remove();
                    songHistory.push(currentSong);
                    System.out.println("Playing song: " +  currentSong);
                    System.out.println();
                }
            } else if (input.equalsIgnoreCase("h")) {
                if (songHistory.isEmpty()) {
                    throw new IllegalStateException("Music history is empty.");
                } else {
                    printHistory(songHistory, auxiliaryStack);
                }
            } else if (input.equalsIgnoreCase("v")) {
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
            } else if (input.equalsIgnoreCase("c")) {
                songHistory.clear();
            } else if (input.equalsIgnoreCase("d")) {
                System.out.println("A positive number will delete from recent history.");
                System.out.println("A negative number will delete from the beginning of history.");
                System.out.print("Enter number of songs to delete: ");
                int numDelete = console.nextInt();
                console.nextLine();
                if (songHistory.size() < Math.abs(numDelete)) {
                    throw new IllegalArgumentException("Not enough songs in history to delete.");
                } else {
                    // delete recent
                    if (numDelete > 0) {
                        for (int i = 0; i < numDelete; i++) {
                            songHistory.pop();
                        }
                        printHistory(songHistory, auxiliaryStack);
                    } else { // delete first
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
            input = loopMenu(console);
        }
    }

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

    public static void printHistory(Stack<String> songHistory, Stack<String> auxiliaryStack) {
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