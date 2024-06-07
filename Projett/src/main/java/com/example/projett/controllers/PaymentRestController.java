package com.example.projett.controllers;

import com.example.projett.services.PaymentService;
import com.stripe.model.PaymentIntent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentRestController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentIntent> createPayment(@RequestParam Double amount) {
        PaymentIntent paymentIntent = paymentService.createPaymentIntent(amount);
        return ResponseEntity.ok(paymentIntent);
    }
}
