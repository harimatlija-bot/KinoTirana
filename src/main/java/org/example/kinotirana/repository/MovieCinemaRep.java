package org.example.kinotirana.repository;

import org.example.kinotirana.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCinemaRep extends JpaRepository <MovieCinema, Long> {
}
