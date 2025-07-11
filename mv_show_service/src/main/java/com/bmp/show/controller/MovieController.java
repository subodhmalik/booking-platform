package com.bmp.show.controller;


import com.bmp.show.entity.Movie;
import com.bmp.show.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/active")
    public List<Movie> getActiveMovies() {
        return movieService.getAllActiveMovies();
    }

    @GetMapping("/by-name")
    public Movie getMovieByName(@RequestParam String name) {
        List<Movie> movies =  movieService.getMoviesByName(name);
         return movies!=null ? movies.get(0): null;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }
}
