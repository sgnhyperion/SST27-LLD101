public class FastPayAdapter implements PaymentGateway {
    FastPayClient client;

    public FastPayAdapter(FastPayClient client){
        this.client = client;
    }

    @Override
    public String charge(String customerId, int amountCents){
        client.payNow(customerId, amountCents);
    }
}
