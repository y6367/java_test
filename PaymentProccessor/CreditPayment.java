package PaymentProccessor;

public class CreditPayment extends Payments {
    public CreditPayment(String name, int amount) {
        super(name, amount);
    }

    @Override
    public String pay() {
        return ("Credit Card Payment");
    }
}
