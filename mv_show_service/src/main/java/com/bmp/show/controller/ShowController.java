package com.bmp.show.controller;

import com.bmp.show.entity.Show;
import com.bmp.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping
    public List<Show> getAll() {
        return showService.getAllShows();
    }

    @GetMapping("/by-id/{showId}")
    public Show getShow(@PathVariable Long showId) {
        Optional<Show> showOptional = showService.getById(showId);
        return showOptional.isPresent() ? showOptional.get() : new Show();
    }

    @PostMapping
    public Show create(@RequestBody Show show) {
        return showService.create(show);
    }
}
