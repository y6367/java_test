package Inheritance;

public class Management {
    public static void main(String[] args) {
        FullTimeEmployee fte1 = new FullTimeEmployee("John", 5,100000,true, 10000);

        PartTimeEmployee pte1 = new PartTimeEmployee("Jennifer", 1,40000,false, 1000);

        PartTimeEmployee pte2 = new PartTimeEmployee("Janet", 2,47000,true, 1200);

        System.out.println(fte1.calculateSalary());
        System.out.println(fte1.printSalary());
        System.out.println(pte1.printSalary());
        System.out.println(pte2.printSalary());
    }
}
