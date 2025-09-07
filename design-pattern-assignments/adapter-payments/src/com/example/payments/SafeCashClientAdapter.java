package com.example.payments;

public class SafeCashClientAdapter implements PaymentGateway{
    SafeCashClient client;

    public SafeCashClientAdapter(SafeCashClient client){
        this.client = client;
    }

    @Override
    public String charge(String customerId, int amountCents){
        return client.createPayment(amountCents, customerId).confirm();
    }
    
}
