package com.bmp.theatre.controller;

import com.bmp.theatre.entity.Screen;
import com.bmp.theatre.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @GetMapping("/by-theatre/{theatreId}")
    public List<Screen> getByTheatre(@PathVariable Long theatreId) {
        return screenService.getScreensByTheatre(theatreId);
    }

    @GetMapping("/by-name/{screenName}")
    public Screen getScreenByName(@PathVariable String screenName) {
        Optional<Screen> sc = screenService.getScreensByName(screenName);
        return sc.isPresent()? sc.get() : new Screen();
    }

    @GetMapping("/by-id/{screenId}")
    public Screen getbyScreenId(@PathVariable Long screenId) {
        Optional<Screen> screenOptional =  screenService.getbyScreenId(screenId);
        return screenOptional.isPresent() ? screenOptional.get() : new Screen();
    }

    @GetMapping
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    @PostMapping
    public Screen create(@RequestBody Screen screen) {
        return screenService.save(screen);
    }
}
