public class CardPayment implements IPaymentProvider {

    @Override
    public String pay(double amount) {
        return "Charged card: " + amount;
    }
}
