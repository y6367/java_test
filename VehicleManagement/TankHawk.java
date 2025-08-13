package VehicleManagement;

public class TankHawk extends Vehicle implements Gas, Flyable {
     TankHawk(String brand, int year, int price) {
         super(brand, year, price);
     }

     void drive() {
         System.out.println("Tank Hawk is driving");
     }

    @Override
    public void refuel() {
         System.out.println("Tank Hawk is refueling");
    }
    @Override
    public void fly() {
         System.out.println("Tank Hawk is flying");
    }
}
