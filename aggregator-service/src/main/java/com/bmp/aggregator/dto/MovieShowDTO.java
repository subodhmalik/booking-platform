package com.bmp.aggregator.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieShowDTO {
    private Long id;
    private Long movieId;
    private Long screenId;
    private Long showId;
    private LocalDate showDate;
    private Long languageId;
}

