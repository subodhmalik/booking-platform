package com.bmp.booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long movieShowId;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public enum SeatStatus {
        AVAILABLE,
        BOOKED,
        BLOCKED
    }
}
