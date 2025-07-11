package com.bmp.aggregator.dto;

import lombok.Data;

import java.util.List;


@Data
public class BookingDTO {
    private Long showId;
    private List<Long> seatIds;
}

