package VehicleManagement;

public class Main {
    public static void main(String[] args) {
        TankHawk tankHawk = new TankHawk("Lexus", 2025, 19000);
        tankHawk.start();
        tankHawk.drive();
        tankHawk.refuel();
        tankHawk.fly();
        tankHawk.returnCost();

    }
}
