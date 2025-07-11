package com.bmp.aggregator.dto;

import lombok.*;

@Data
public class MovieDTO {
    private Long id;
    private String name;
    private String genre;
    private boolean active;
}

