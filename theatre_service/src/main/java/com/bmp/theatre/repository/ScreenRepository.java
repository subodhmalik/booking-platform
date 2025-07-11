package com.bmp.theatre.repository;

import com.bmp.theatre.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    List<Screen> findByTheatreId(Long theatreId);

    Optional<Screen> findByScreenName(String screenName);
}
