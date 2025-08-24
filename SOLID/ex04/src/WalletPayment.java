public class WalletPayment implements IPaymentProvider {

    @Override
    public String pay(double amount) {
        return "Wallet debit: " + amount;
    }
}