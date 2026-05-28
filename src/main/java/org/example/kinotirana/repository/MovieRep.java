package org.example.kinotirana.repository;


import org.example.kinotirana.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRep extends JpaRepository<Movie, Long> {
    List<Movie> findByMovieIsActiveTrue();
    boolean existsByMovieTitleAndMovieReleaseDate(String movieTitle, LocalDate movieReleaseDate);
}
