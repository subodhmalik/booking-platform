package com.bmp.theatre.controller;

import com.bmp.theatre.entity.Theatre;
import com.bmp.theatre.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    private final TheatreService theatreService;

    @GetMapping
    public List<Theatre> getAll() {
        return theatreService.getAll();
    }

    @PostMapping
    public Theatre create(@RequestBody Theatre theatre) {
        return theatreService.save(theatre);
    }
}
