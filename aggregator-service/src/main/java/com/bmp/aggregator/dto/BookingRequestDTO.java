package com.bmp.aggregator.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookingRequestDTO {
    private String screenName;
    private String movieName;
    private LocalDate showDate;
    private ShowEnum show;
    private List<String> seatNumbers;

    public enum ShowEnum {
        Morning,
        Matinee,
        Evening
    }
}
