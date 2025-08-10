package Inheritance;

public class FullTimeEmployee extends Employee {
    boolean insurance;
    int bonus;

    FullTimeEmployee(String name, int experience, int salary, boolean insurance, int bonus) {
        super(name, experience, salary);
        this.insurance = insurance;
        this.bonus = bonus;
    }

    public int calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}
