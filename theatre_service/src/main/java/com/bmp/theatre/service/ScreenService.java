package com.bmp.theatre.service;

import com.bmp.theatre.entity.Screen;
import com.bmp.theatre.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;

    public List<Screen> getScreensByTheatre(Long theatreId) {
        return screenRepository.findByTheatreId(theatreId);
    }

    public Optional<Screen> getbyScreenId(Long screenId) {
        return screenRepository.findById(screenId);
    }

    public Screen save(Screen screen) {
        return screenRepository.save(screen);
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Optional<Screen> getScreensByName(String screenName) {
        return screenRepository.findByScreenName(screenName);
    }
}
