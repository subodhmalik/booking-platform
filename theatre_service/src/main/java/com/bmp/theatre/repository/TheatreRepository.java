package com.bmp.theatre.repository;

import com.bmp.theatre.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {}
