import java.util.*;
public class GPACalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        welcome();

        double total = 0;
        int classNum = 1;
        classNum = classCount(classNum);
        total += gpaInput(console);

        classNum = classCount(classNum);
        total += gpaInput(console);

        classNum = classCount(classNum);
        total += gpaInput(console);

        calculateGrades(total);
    }

    public static void welcome() {
        System.out.println("welcome! please input the grades");
        System.out.println("earned in your three classes, and");
        System.out.println("we will calculate your total gpa");
    }

    public static int classCount(int classNum) {
        System.out.println("  class #" + classNum);
        return classNum + 1;
    }

    public static double gpaInput(Scanner console) {
        System.out.print("    gpa earned: ");
        double grade1 = console.nextDouble();
        while (0 > grade1 || grade1 > 4) {
            System.out.println("    grade must be between 0.0-4.0");
            System.out.print("    gpa earned: ");
            grade1 = console.nextDouble();
        }
        return Math.round(grade1 * 10.0) / 10.0;
    }

    public static void calculateGrades(double total) {
        double gpa = Math.round(total / 3.0 * 10.0) / 10.0;
        System.out.println("your average gpa was: " + gpa);
    }
}