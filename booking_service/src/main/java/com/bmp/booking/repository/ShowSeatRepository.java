package com.bmp.booking.repository;

import com.bmp.booking.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findByMovieShowIdAndStatus(Long movieShowId, ShowSeat.SeatStatus status);
    List<ShowSeat> findByMovieShowIdAndSeatIdInAndStatus(Long movieShowId, List<Long> seatIds, ShowSeat.SeatStatus status);
}
