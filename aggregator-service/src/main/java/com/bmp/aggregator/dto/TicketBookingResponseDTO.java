package com.bmp.aggregator.dto;

import lombok.Data;

@Data
public class TicketBookingResponseDTO {
    private String status;
    private String message;
    private String paymentId;
}
