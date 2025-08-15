package OnlineStore;

public class Food extends Product implements Discountable{
    Food(String name, int price) {
        super(name, price);
    }

    @Override
    void getCategory() {
        System.out.println("Food");
    }
    @Override
    public void discountAmount() {
        this.price *= 0.9;
        System.out.println("10% off");
    }
}
