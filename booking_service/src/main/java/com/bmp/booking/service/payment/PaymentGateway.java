package com.bmp.booking.service.payment;

public interface PaymentGateway {
    boolean processPayment(Long userId, Double amount);
}
