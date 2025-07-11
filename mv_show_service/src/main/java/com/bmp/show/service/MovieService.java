package com.bmp.show.service;


import com.bmp.show.entity.Movie;
import com.bmp.show.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllActiveMovies() {
        return movieRepository.findByActiveTrue();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMoviesByName(String movieName) {
        return movieRepository.findByName(movieName);
    }
}