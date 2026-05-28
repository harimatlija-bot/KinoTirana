package org.example.kinotirana.repository;

import jakarta.persistence.Embedded;
import org.example.kinotirana.entity.Address;
import org.example.kinotirana.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRep extends JpaRepository <Cinema, Long>{
    List<Cinema> findByCinemaIsActiveTrue();
    boolean existsByCinemaNameAndCinemaAddress(String cinemaName, Address cinemaAddress);
}
