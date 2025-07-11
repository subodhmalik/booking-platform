package com.bmp.aggregator.service;

import com.bmp.aggregator.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AggregatorGetService {

    private final RestTemplate restTemplate;

    @Value("${services.mvshow-service-url}")
    private String mvShowUrl;
    @Value("${services.theatre-service-url}")
    private String theatreUrl;
    @Value("${services.booking-service-url}")
    private String bookingUrl;


    public ResponseEntity<List<ShowDetailsDTO>> getShowsByMovieAndDate(String movieName, LocalDate date) {
        List<MovieShowDTO> movieShows = getMovieShowDto(movieName, date);

        List<ShowDetailsDTO> result = new ArrayList<>();

        for (MovieShowDTO ms : movieShows) {
            ShowDetailsDTO dto = new ShowDetailsDTO();
            dto.setMovieName(movieName);

            // Get Show Info
            ShowDTO show = restTemplate.getForObject(
                    mvShowUrl + "/api/shows/by-id/" + ms.getShowId(), ShowDTO.class);
            dto.setShowName(show.getName());
            dto.setShowDate(ms.getShowDate());
            dto.setStartTime(show.getStartTime());
            dto.setEndTime(show.getEndTime());

            // Get Screen Info (with Theatre name)
            ScreenDTO screen = restTemplate.getForObject(
                    theatreUrl + "/api/screens/by-id/" + ms.getScreenId(), ScreenDTO.class);
            dto.setScreenName(screen.getScreenName());
            dto.setTheatreName(screen.getTheatre().getName()); // assuming theatre is embedded

            result.add(dto);
        }

        return ResponseEntity.ok(result);
    }

    private List<MovieShowDTO> getMovieShowDto(String movieName, LocalDate date){
        MovieDTO movie = restTemplate.getForObject(
                mvShowUrl + "/api/movies/by-name?name=" + movieName,
                MovieDTO.class);

        // Step 2: Get movie_show records
        ResponseEntity<MovieShowDTO[]> response = restTemplate.getForEntity(
                mvShowUrl + "/api/movie-shows/by-movie/" + movie.getId(),
                MovieShowDTO[].class);

        return Arrays.asList(Objects.requireNonNull(response.getBody()))
                .stream().filter(m -> date==null || m.getShowDate().equals(date)).toList();
    }
}