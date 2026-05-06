package org.example.kinotirana.Services;

import org.example.kinotirana.Entities.Movie_Cinema;
import org.example.kinotirana.Repositories.Movie_CinemaRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Movie_CinemaService {
    private final Movie_CinemaRep movieCinemaRep;
    public Movie_CinemaService (Movie_CinemaRep movieCinemaRep){
        this.movieCinemaRep = movieCinemaRep;
    }
    public List<Movie_Cinema> getAll(){
        return movieCinemaRep.findAll();
    }
    public Movie_Cinema create (Movie_Cinema movieCinema){
        return movieCinemaRep.save(movieCinema);
    }
    @Transactional
    public Movie_Cinema update(Long movieCId, Movie_Cinema newMovieCinema){
        Movie_Cinema mc = movieCinemaRep.findById(movieCId).orElseThrow(() -> new RuntimeException("Movie not found"));
        mc.setMovieCTimestamp(newMovieCinema.getMovieCTimestamp());
        mc.setMovieCPrice(newMovieCinema.getMovieCPrice());
        mc.setMovieCAvailSeats(newMovieCinema.getMovieCAvailSeats());
        return movieCinemaRep.save(mc);
    }
    @Transactional
    public void delete (Long movieCId){
        Movie_Cinema mc = movieCinemaRep.findById(movieCId).orElseThrow(() -> new RuntimeException("Movie with id: " + movieCId + " not found!"));
    }
}