
public class Demo04 {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService();
        System.out.println(ps.pay(new Payment(new UpiPayment(), 499)));
        System.out.println(ps.pay(new Payment(new CardPayment(), 100)));
        System.out.println(ps.pay(new Payment(new WalletPayment(), 50)));
    }
}
