package com.bmp.show.controller;

import com.bmp.show.entity.MovieShow;
import com.bmp.show.service.MovieShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/movie-shows")
@RequiredArgsConstructor
public class MovieShowController {

    private final MovieShowService movieShowService;

    @PostMapping
    public MovieShow create(@RequestBody MovieShow movieShow) {
        return movieShowService.create(movieShow);
    }

    @GetMapping("/by-movie/{movieId}")
    public List<MovieShow> getByMovie(@PathVariable Long movieId) {
        return movieShowService.findByMovie(movieId);
    }

    @GetMapping("/by-movie-and-date")
    public List<MovieShow> getByMovieAndDate(@RequestParam Long movieId,
                                             @RequestParam String date) {
        return movieShowService.findByMovieAndDate(movieId, LocalDate.parse(date));
    }

    @GetMapping("/resolve")
    public ResponseEntity<MovieShow> resolveShow(@RequestParam Long movieId,
                                                 @RequestParam Long screenId,
                                                 @RequestParam LocalDate showDate,
                                                 @RequestParam String show) {
        MovieShow mvShow = movieShowService.findByDetails(movieId, screenId,showDate,show);
        return ResponseEntity.ok(mvShow);
    }
}
