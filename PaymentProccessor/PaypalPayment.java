package PaymentProccessor;

public class PaypalPayment extends Payments{
    public PaypalPayment(String name, int amount) {
        super(name, amount);
    }

    @Override
    public String pay() {
        return "Paypal Payment";
    }
}
