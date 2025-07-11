package com.bmp.booking.request;

import lombok.Data;

import java.util.List;


@Data
public class BookingRequest {
    private Long showId;
    private List<Long> seatIds;
}

