package com.bmp.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long movieShowId;

    private Long userId;

    private LocalDateTime bookingTime;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ElementCollection
    private List<String> seatNumbers;

    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        FAILED
    }
}
