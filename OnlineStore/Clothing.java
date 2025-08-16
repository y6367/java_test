package OnlineStore;

public class Clothing extends Product{
    Clothing(String name, int price) {
        super(name, price);
    }

    @Override
    void getCategory() {
        System.out.println("Clothing");
    }
}
