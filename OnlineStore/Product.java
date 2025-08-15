package OnlineStore;

public abstract class Product {
    String name;
    int price;
    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }

    abstract void getCategory();
}
