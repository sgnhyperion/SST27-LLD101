public class UpiPayment implements IPaymentProvider {
    @Override
    public String pay(double amount) {
        return "Paid via UPI: " + amount;
    }
    
}
