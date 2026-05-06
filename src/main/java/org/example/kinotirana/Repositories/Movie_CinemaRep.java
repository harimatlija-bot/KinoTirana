package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.Movie_Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Movie_CinemaRep extends JpaRepository <Movie_Cinema, Long> {
}
