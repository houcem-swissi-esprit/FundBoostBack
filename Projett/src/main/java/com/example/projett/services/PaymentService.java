package com.example.projett.services;


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeApiKey;
    }

    public PaymentIntent createPaymentIntent(Double amount) {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", (int) (amount * 100)); // Stripe expects the amount in cents
        params.put("currency", "usd");

        try {
            return PaymentIntent.create(params);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
