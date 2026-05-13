package org.example.kinotirana.repository;


import org.example.kinotirana.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRep extends JpaRepository<Movie, Long> {
    List<Movie> findByMovieIsActiveTrue();
}
