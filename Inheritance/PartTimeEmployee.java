package Inheritance;

public class PartTimeEmployee extends Employee {
    boolean insurance;
    int bonus;

    PartTimeEmployee(String name, int experience, int salary, boolean insurance, int bonus) {
        super(name, experience, salary);
        this.insurance = insurance;
        this.bonus = bonus;
    }

    public int calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}
