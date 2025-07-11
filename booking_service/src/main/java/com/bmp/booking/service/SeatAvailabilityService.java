package com.bmp.booking.service;

import com.bmp.booking.entity.ShowSeat;
import com.bmp.booking.repository.ShowSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatAvailabilityService {

    private final ShowSeatRepository repository;

    @Cacheable(value = "availableSeats", key = "#movieShowId")
    public List<ShowSeat> getAvailableSeats(Long movieShowId) {
            return repository.findByMovieShowIdAndStatus(movieShowId, ShowSeat.SeatStatus.AVAILABLE);
    }

    @CachePut(value = "availableSeats", key = "#movieShowId")
    public List<ShowSeat> updateCache(Long movieShowId, List<ShowSeat> updatedSeats) {
        return updatedSeats; // cache is updated
    }

    @CacheEvict(value = "availableSeats", key = "#movieShowId")
    public void clearCache(Long movieShowId) {
        // used after final DB update post-payment
    }
}
