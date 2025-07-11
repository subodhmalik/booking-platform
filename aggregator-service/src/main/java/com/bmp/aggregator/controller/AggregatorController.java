package com.bmp.aggregator.controller;

import com.bmp.aggregator.dto.BookingRequestDTO;
import com.bmp.aggregator.dto.ShowDetailsDTO;
import com.bmp.aggregator.service.AggregatorGetService;
import com.bmp.aggregator.service.AggregatorPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/aggregator")
@RequiredArgsConstructor
public class AggregatorController {

private final AggregatorGetService aggrGetService;
    private final AggregatorPostService aggrPostService;

    @GetMapping("/shows-by-movie-name")
    public ResponseEntity<List<ShowDetailsDTO>> getShowsByMovieNameAndDate(@RequestParam String movieName, @RequestParam(required = false) LocalDate date) {
        return aggrGetService.getShowsByMovieAndDate(movieName, date);
    }

    @PostMapping("/book-tickets")
    public ResponseEntity<String> bookTickets(@RequestBody BookingRequestDTO request) {
        String result = aggrPostService.processBooking(request);
        return ResponseEntity.ok(result);
    }
}
