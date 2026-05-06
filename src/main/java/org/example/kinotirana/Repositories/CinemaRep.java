package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRep extends JpaRepository <Cinema, Long>{
}
