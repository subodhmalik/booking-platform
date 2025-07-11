package com.bmp.booking.repository;

import com.bmp.booking.entity.Seat;
import com.bmp.booking.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s.id FROM Seat s WHERE s.seatNumber IN :seatNumbers")
    List<Long> findIdsBySeatNumbers(@Param("seatNumbers") List<String> seatNumbers);

}
