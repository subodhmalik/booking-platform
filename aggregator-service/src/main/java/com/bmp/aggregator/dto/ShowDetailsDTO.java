package com.bmp.aggregator.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowDetailsDTO {
    private String movieName;
    private String showName;
    private LocalDate showDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String theatreName;
    private String screenName;
}
