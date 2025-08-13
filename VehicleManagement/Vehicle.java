package VehicleManagement;

abstract class Vehicle {
    String brand;
    int year;
    int price;

    Vehicle(String brand, int year, int price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    void returnCost() {
        System.out.println("This " + this.year + " " + this.brand + " costs $" + this.price);
    }

    void start() {
        System.out.println("Starting Vehicle");
    }

    abstract void drive();
}