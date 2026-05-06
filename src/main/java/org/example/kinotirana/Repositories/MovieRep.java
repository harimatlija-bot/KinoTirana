package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRep extends JpaRepository<Movie, Long> {
}
