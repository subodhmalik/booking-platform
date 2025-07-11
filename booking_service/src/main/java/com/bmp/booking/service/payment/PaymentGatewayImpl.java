package com.bmp.booking.service.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayImpl implements PaymentGateway {

    @Override
    public boolean processPayment(Long userId, Double amount) {
        // Simulate success or failure
        if (amount > 200) {
            try {
                Thread.sleep(60000); // sleep for 60 seconds to demonstrate locking
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return false;
        } else {
            return true;
        }
    }
}
