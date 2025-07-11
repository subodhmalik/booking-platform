package com.bmp.aggregator.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ShowDTO {
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
}
