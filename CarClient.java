// public class <real class name>
public class CarClient {
    public static void main(String[] args) {
        Car c1 = new Car(4, "Hondagini", "Red", true);
        Car c2 = new Car(5, "Toyotagini", "Blue", true);
        Car c3 = new Car(4, "Fordgini", "Purple", false);

        System.out.println(c1.getColor());
        System.out.println(c2.getColor());
        System.out.println(c3.getColor());

        System.out.println(c1.isUniqueBuild());
        System.out.println(c2.isUniqueBuild());
        System.out.println(c3.isUniqueBuild());
    }

}