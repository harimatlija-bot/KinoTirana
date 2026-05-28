package org.example.kinotirana.repository;

import org.example.kinotirana.entity.Cinema;
import org.example.kinotirana.entity.Movie;
import org.example.kinotirana.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface MovieCinemaRep extends JpaRepository <MovieCinema, Long> {
    boolean existsByMovieAndCinemaAndMcTimestamp(Movie movie, Cinema cinema, LocalDateTime mcTimestamp);
}
