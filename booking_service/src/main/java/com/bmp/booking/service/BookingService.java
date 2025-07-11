package com.bmp.booking.service;

import com.bmp.booking.entity.Booking;
import com.bmp.booking.entity.ShowSeat;

import com.bmp.booking.repository.BookingRepository;
import com.bmp.booking.repository.ShowSeatRepository;
import com.bmp.booking.service.payment.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowSeatRepository showSeatRepository;
    private final PaymentGateway paymentGateway;
    private final SeatAvailabilityService seatAvailabilityService;

    public ResponseEntity<String> bookSeats(Long movieShowId, List<Long> seatIds) {
        // Use Caching to manage parallel bookings
        List<ShowSeat> seats = seatAvailabilityService.getAvailableSeats(movieShowId);

        List<ShowSeat> seatsToBeBooked = seats.stream().filter(ss -> seatIds.contains(ss.getSeat().getId())).collect(Collectors.toList());
        if(seats.isEmpty()) {
            return ResponseEntity.ok("Seat not found or Already Booked");
        }  else {
            seatAvailabilityService.updateCache(movieShowId, seats.stream()
                    .filter(element -> !seatsToBeBooked.contains(element))
                    .toList());
        }


        double total = seatsToBeBooked.stream().mapToDouble(ShowSeat::getPrice).sum();

        Booking booking = Booking.builder()
                .movieShowId(movieShowId)
                .userId(123l)
                .seatNumbers(seatsToBeBooked.stream().map(s -> s.getSeat().getSeatNumber()).collect(Collectors.toList()))
                .bookingTime(LocalDateTime.now())
                .totalAmount(total)
                .status(Booking.BookingStatus.PENDING)
                .build();

        booking = bookingRepository.save(booking);

        // Todo: Can use Lock here for concurrent requests and and Cache for in process seat bookings
        boolean paymentSuccess = paymentGateway.processPayment(123l, total);

        if (paymentSuccess) {
            seatsToBeBooked.forEach(s -> s.setStatus(ShowSeat.SeatStatus.BOOKED));
            showSeatRepository.saveAll(seatsToBeBooked);
            booking.setStatus(Booking.BookingStatus.CONFIRMED);
        } else {
            booking.setStatus(Booking.BookingStatus.FAILED);
        }

        seatAvailabilityService.clearCache(movieShowId);
        Booking bookObj =  bookingRepository.save(booking);
        // clear cache now
        return ResponseEntity.ok().body(bookObj.toString());
    }

    public Double getTotalCollection(Long movieShowId) {
        return bookingRepository.findAll().stream()
                .filter(b -> b.getMovieShowId().equals(movieShowId) && b.getStatus() == Booking.BookingStatus.CONFIRMED)
                .mapToDouble(Booking::getTotalAmount)
                .sum();
    }

}
