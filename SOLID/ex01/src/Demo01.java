

public class Demo01 {
    public static void main(String[] args) {
        ITaxCalculator taxCalc = new SimpleTaxCalculator(0.18);
        IEmailSender email = new EmailClient();
        OrderService service = new OrderService(email, taxCalc);

        service.checkout("a@shop.com", 100.0);

        service.checkout("test@shop.com", 50.0);
    }
}
