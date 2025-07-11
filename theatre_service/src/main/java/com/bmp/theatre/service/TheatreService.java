package com.bmp.theatre.service;

import com.bmp.theatre.entity.Theatre;
import com.bmp.theatre.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getAll() {
        return theatreRepository.findAll();
    }

    public Theatre save(Theatre theatre) {
        return theatreRepository.save(theatre);
    }
}
