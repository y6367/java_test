package OnlineStore;

public class Electronics extends Product{
    Electronics(String name, int experience) {
        super(name, experience);
    }
    void getCategory() {
        System.out.println("Category");
    }
}
