package com.bmp.show.service;

import com.bmp.show.entity.MovieShow;
import com.bmp.show.repository.MovieShowRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieShowService {

    private final MovieShowRepository movieShowRepository;
    private final ShowService showService;

    public MovieShow create(MovieShow movieShow) {
        return movieShowRepository.save(movieShow);
    }

    public Optional<MovieShow> getById(Long id) {
        return movieShowRepository.findById(id);
    }

    public List<MovieShow> findByMovie(Long movieId) {
        return movieShowRepository.findByMovieId(movieId);
    }

    public List<MovieShow> findByMovieAndDate(Long movieId, LocalDate date) {
        return movieShowRepository.findByMovieIdAndShowDate(movieId, date);
    }

    public List<MovieShow> findByScreenAndDate(Long screenId, LocalDate date) {
        return movieShowRepository.findByScreenIdAndShowDate(screenId, date);
    }

    public void delete(Long id) {
        movieShowRepository.deleteById(id);
    }

    public MovieShow findByDetails(Long movieId,  Long screenId, LocalDate showDate, String show) {
        // 1. Call theatre-service to resolve screenId
        Long showId = showService.getAllShows().stream().filter(s -> s.getName().equalsIgnoreCase(show)).findAny().get().getId();

        // 4. Now fetch movie_show row
        return movieShowRepository.findByMovieIdAndScreenIdAndShowIdAndShowDate(
                movieId, screenId, showId, showDate
        ).orElseThrow(() -> new EntityNotFoundException("Show not found for given criteria"));
    }

    public MovieShow update(Long id, MovieShow updated) {
        return movieShowRepository.findById(id)
                .map(existing -> {
                    existing.setMovieId(updated.getMovieId());
                    existing.setScreenId(updated.getScreenId());
                    existing.setShowId(updated.getShowId());
                    existing.setLanguageId(updated.getLanguageId());
                    existing.setShowDate(updated.getShowDate());
                    return movieShowRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("MovieShow not found with id " + id));
    }
}
