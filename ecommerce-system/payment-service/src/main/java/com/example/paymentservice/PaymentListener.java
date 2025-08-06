package com.example.paymentservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    @KafkaListener(topics = "order-topic", groupId = "payment-group")
    public void processPayment(String message) {
        // Simulate payment processing
        System.out.println("Processing payment for: " + message);
    }
}