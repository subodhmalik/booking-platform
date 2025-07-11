package com.bmp.booking.controller;

import com.bmp.booking.entity.Booking;
import com.bmp.booking.request.BookingRequest;
import com.bmp.booking.entity.ShowSeat;
import com.bmp.booking.repository.SeatRepository;
import com.bmp.booking.service.BookingService;
import com.bmp.booking.repository.ShowSeatRepository;
import com.bmp.booking.service.SeatAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ShowSeatRepository showSeatRepository;
    private final SeatRepository seatRepository;
    private final SeatAvailabilityService seatAvailabilityService;

    @PostMapping("/book")
    public ResponseEntity<String> book(@RequestBody BookingRequest bookingDTO) {
        return bookingService.bookSeats(bookingDTO.getShowId(), bookingDTO.getSeatIds());
    }

    @GetMapping("/available-seats")
    public List<ShowSeat> getAvailableSeats(@RequestParam Long movieShowId) {
        return seatAvailabilityService.getAvailableSeats(movieShowId);
    }

    @GetMapping("/total-collection")
    public Double getTotalCollection(@RequestParam Long movieShowId) {
        return bookingService.getTotalCollection(movieShowId);
    }

    @GetMapping("/seats/ids")
    public ResponseEntity<List<Long>> getSeatIds(@RequestParam List<String> seatNumbers) {
        List<Long> ids = seatRepository.findIdsBySeatNumbers(seatNumbers);
        return ResponseEntity.ok(ids);
    }

}