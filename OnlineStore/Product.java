package OnlineStore;

public abstract class Product {
    String name;
    int price;
    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    abstract void getCategory();
}
