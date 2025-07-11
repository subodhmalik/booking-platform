package com.bmp.aggregator.service;

import com.bmp.aggregator.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AggregatorPostService {

    private final RestTemplate restTemplate;

    @Value("${services.mvshow-service-url}")
    private String mvShowUrl;
    @Value("${services.theatre-service-url}")
    private String theatreUrl;
    @Value("${services.booking-service-url}")
    private String bookingServiceUrl;

    public String processBooking(BookingRequestDTO request) {
        MovieDTO movie = restTemplate.getForObject(
                mvShowUrl + "/api/movies/by-name?name=" + request.getMovieName(),
                MovieDTO.class);

        ScreenDTO screen = restTemplate.getForObject(
                theatreUrl + "/api/screens/by-name/" + request.getScreenName(), ScreenDTO.class);

        String showServiceUrl = mvShowUrl + "/api/movie-shows/resolve?" +
                "movieId=" + movie.getId() +
                "&screenId=" + screen.getId() +
                "&showDate=" + request.getShowDate() +
                "&show=" + request.getShow().name();

        ResponseEntity<MovieShowDTO> response = restTemplate.getForEntity(showServiceUrl, MovieShowDTO.class);
        MovieShowDTO show = response.getBody();
        if (show == null) throw new RuntimeException("Show not found");

        // Step 2: Get Seat IDs from seat numbers
        String seatQueryUrl = bookingServiceUrl + "/api/seats/ids?seatNumbers=" + String.join(",", request.getSeatNumbers());

        ResponseEntity<List<Long>> seatIdsResp = restTemplate.exchange(
                seatQueryUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        List<Long> seatIds = seatIdsResp.getBody();

        // Step 3: Call booking-service
        BookingDTO bookingPayload = new BookingDTO();
        bookingPayload.setShowId(show.getId());
        bookingPayload.setSeatIds(seatIds);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BookingDTO> bookingEntity = new HttpEntity<>(bookingPayload, headers);

        String bookingUrl = bookingServiceUrl + "/api/book";
        ResponseEntity<String> bookingResp = restTemplate.postForEntity(bookingUrl, bookingEntity, String.class);

        return bookingResp.getBody();
    }
}