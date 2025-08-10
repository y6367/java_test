package Inheritance;

public class Employee {
    String name;
    int experience;
    int salary;

    Employee(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public int calculateSalary() {
        return (int) (experience * 0.1 + 1) * salary;
    }

    public String printSalary() {
        return(name + " makes $" + salary + " this year.");
    }



}
