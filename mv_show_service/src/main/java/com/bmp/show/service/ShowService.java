package com.bmp.show.service;

import com.bmp.show.entity.Show;
import com.bmp.show.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show create(Show show) {
        return showRepository.save(show);
    }

    public Optional<Show> getById(Long id) {
        return showRepository.findById(id);
    }

    public void delete(Long id) {
        showRepository.deleteById(id);
    }

    public Show update(Long id, Show updated) {
        return showRepository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setStartTime(updated.getStartTime());
                    existing.setEndTime(updated.getEndTime());
                    return showRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Show not found with id " + id));
    }
}
