public class OrderService {
    private final IEmailSender emailSender;
    private final ITaxCalculator taxCalculator;

    public OrderService(IEmailSender emailSender, ITaxCalculator taxCalculator) {
        this.emailSender = emailSender;
        this.taxCalculator = taxCalculator;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.calculate(subtotal);
        emailSender.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}