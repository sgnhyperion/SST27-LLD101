public class Payment {
    private final IPaymentProvider provider; 
    private final double amount;
    
    public Payment(IPaymentProvider provider, double amount) {
        this.provider = provider;
        this.amount = amount;
    }

    public String pay() {
        return provider.pay(amount);
    }
}