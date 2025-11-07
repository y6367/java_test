// public class <real class name>
public class Car {
    private int wheelsNum;
    private String brand;
    private String color;
    private boolean electric;

    public Car(int wheelsNum, String brand, String color, boolean electric) {
        this.wheelsNum = wheelsNum;
        this.brand = brand;
        this.color = color;
        this.electric = electric;
    }

    public Car() {
        this(4, "Toyota", "White", false);
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
    public int getWheels() {
        return wheelsNum;
    }

    public boolean getElectric() {
        return electric;
    }

    public boolean isUniqueBuild() {
        if (getWheels() != 4) {
            return true;
        }
        return false;
    }

    public String getLongCarName() {
        int count = 0;
        count += getBrand().length();
        count += getColor().length();
        return ("There are " + count + " many words in this Long Car Name." + getColor() + getBrand());
    }

    public void setColor(String newColor) {
        color = newColor;
    }

    public void setBrand(String newBrand) {
        brand = newBrand;
    }

    public String toString() {
        return("This is a " + getColor() + " " + getBrand());
    }

    public boolean equals(Car c) {
        if (this == c) {
            return true;
        } else {
            return false;
        }
    }

}