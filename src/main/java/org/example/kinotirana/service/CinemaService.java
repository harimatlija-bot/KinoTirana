package org.example.kinotirana.service;

import org.example.kinotirana.entity.Cinema;
import org.example.kinotirana.repository.CinemaRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CinemaService {
    private final CinemaRep cinemaRep;
    public CinemaService(CinemaRep cinemaRep) {
        this.cinemaRep = cinemaRep;
    }
    public List<Cinema> getAll() {
        return cinemaRep.findByCinemaIsActiveTrue();
    }
    public Cinema create(Cinema cinema) {
        return cinemaRep.save(cinema);
    }
    @Transactional
    public Cinema update(Long cinemaId, Cinema newCinema) {
        Cinema c = cinemaRep.findById(cinemaId).orElseThrow(() -> new RuntimeException("Cinema with id: " + cinemaId + " not found!"));
        c.setCinemaName(newCinema.getCinemaName());
        c.setCinemaAddress(newCinema.getCinemaAddress());
        c.setCinemaOpeningTime(newCinema.getCinemaOpeningTime());
        c.setCinemaClosingTime(newCinema.getCinemaClosingTime());
        c.setCinemaOpeningDay(newCinema.getCinemaOpeningDay());
        c.setCinemaIsActive(newCinema.isCinemaIsActive());
        return cinemaRep.save(c);
    }
    @Transactional
    public void delete(Long cinemaId) {
        Cinema c = cinemaRep.findById(cinemaId).orElseThrow(() -> new RuntimeException("Cinema with id: " + cinemaId + " not found!"));
        c.setCinemaIsActive(false);
    }
}