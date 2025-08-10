package Inheritance;

public class Management {
    public static void main(String[] args) {
        FullTimeEmployee fte1 = new FullTimeEmployee("John", 5,100000,true, 10000);

        PartTimeEmployee pte1 = new PartTimeEmployee("Jennifer", 1,40000,true, 1000);

        System.out.println(fte1.calculateSalary());
        System.out.println(fte1.printSalary());
        System.out.println(pte1.printSalary());
    }
}
