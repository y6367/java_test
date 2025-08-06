public class Car {
    String name;
    int year;
    int price;
    public Car(String carName, int carYear, int carPrice) {
        name = carName;
        year = carYear;
        price = carPrice;
    }

    public void carSale() {
        System.out.println("This " + name + " has been sold for " + price + "!");
    }

    public static void main(String[] args) {
        Car toyota = new Car("Toyota", 2025, 31000);
        System.out.println(toyota.name);
        System.out.println(toyota.year);
        System.out.println(toyota.price);
        toyota.carSale();

 ;   }
}
