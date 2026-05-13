package org.example.kinotirana.service;

import org.example.kinotirana.entity.MovieCinema;
import org.example.kinotirana.repository.MovieCinemaRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieCinemaService {
    private final MovieCinemaRep movieCinemaRep;
    public MovieCinemaService(MovieCinemaRep movieCinemaRep){
        this.movieCinemaRep = movieCinemaRep;
    }
    public List<MovieCinema> getAll(){
        return movieCinemaRep.findAll();
    }
    public MovieCinema create (MovieCinema movieCinema){
        return movieCinemaRep.save(movieCinema);
    }
    @Transactional
    public MovieCinema update(Long mcId, MovieCinema newMovieCinema){
        MovieCinema mc = movieCinemaRep.findById(mcId).orElseThrow(() -> new RuntimeException("Movie not found"));
        mc.setMcTimestamp(newMovieCinema.getMcTimestamp());
        mc.setMcPrice(newMovieCinema.getMcPrice());
        mc.setMcAvailableSeats(newMovieCinema.getMcAvailableSeats());
        return movieCinemaRep.save(mc);
    }

    @Transactional
    public void delete(Long mcId){
        MovieCinema mc = movieCinemaRep.findById(mcId).orElseThrow(() -> new RuntimeException("Movie with id: " + mcId + " not found!"));
        movieCinemaRep.delete(mc);
    }
}