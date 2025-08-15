package PaymentProccessor;

public abstract class Payments {
    String name;
    int amount;
    public Payments(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    abstract public void pay();
    void confirmation() {
        System.out.println(this.name + " paid $" + this.amount);
    }
}
