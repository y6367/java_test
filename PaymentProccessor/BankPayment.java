package PaymentProccessor;

public class BankPayment extends Payments{
    public BankPayment(String name, int amount) {
        super(name, amount);
    }

    @Override
    public String pay() {
        return ("Bank Transer");
    }

}
