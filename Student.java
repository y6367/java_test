import java.util.Scanner;
import java.util.Arrays;

public class Student {
    static Scanner scanner = new Scanner(System.in);

    static String name;
    static int[] grades = {0, 0, 0, 0, 0};

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    static String getName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    static int[] getGrades() {
        int grade;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter grade #" + (i+1) + ": ");
            grade = scanner.nextInt();
            grades[i] = grade;
        }
        return grades;
    }



    public static void main(String[] args) {
        Student s1 = new Student(getName(), getGrades());

        System.out.println(s1.name);
        System.out.println("Entered grades: " + Arrays.toString(s1.grades));

        for (int i = 0; i < 5; i++) {
            for (int j = i; j > 0; j--) {
                int temp = 0;
                if (s1.grades[j] > s1.grades[j-1]) {
                    break;
                } else {
                    temp = s1.grades[j];
                    s1.grades[j] = s1.grades[j-1];
                    s1.grades[j-1] = temp;
                }
            }
        }
        System.out.println("Sorted grades: " + Arrays.toString(s1.grades));

        int average = 0;
        for (int i = 0; i < s1.grades.length; i++) {
            average += s1.grades[i];
        }
        System.out.println("Average grade: " + average / s1.grades.length);


//        System.out.print("Enter your name: ");
//        name = scanner.nextLine();

//        name = getName();
//        grades = getGrades();



//        int grade;
//        int average = 0;
//
//        for (int i = 0; i < 5; i++) {
//            System.out.print("Enter grade #" + (i+1) + ": ");
//            grade = scanner.nextInt();
//            average += grade;
//            grades[i] = grade;
//        }
//        average /= 5;
//        System.out.println(Arrays.toString(grades));
//        System.out.println("The average grade for " + name + " is: " + average);
    }
}
