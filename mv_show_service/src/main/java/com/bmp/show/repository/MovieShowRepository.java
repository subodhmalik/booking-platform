package com.bmp.show.repository;

import com.bmp.show.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
    List<MovieShow> findByMovieId(Long movieId);
    List<MovieShow> findByMovieIdAndShowDate(Long movieId, LocalDate date);
    List<MovieShow> findByScreenIdAndShowDate(Long screenId, LocalDate date);
    Optional<MovieShow> findByMovieIdAndScreenIdAndShowIdAndShowDate(
            Long movieId, Long screenId, Long showId, LocalDate showDate);
}