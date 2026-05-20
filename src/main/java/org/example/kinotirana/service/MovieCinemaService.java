package org.example.kinotirana.service;

import lombok.Getter;
import lombok.Setter;
import org.example.kinotirana.entity.Cinema;
import org.example.kinotirana.entity.Movie;
import org.example.kinotirana.entity.MovieCinema;
import org.example.kinotirana.repository.CinemaRep;
import org.example.kinotirana.repository.MovieCinemaRep;
import org.example.kinotirana.repository.MovieRep;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Getter
@Setter

@Service
public class MovieCinemaService {
    private final MovieCinemaRep movieCinemaRep;
    private final MovieRep movieRep;
    private final CinemaRep cinemaRep;

    public MovieCinemaService(MovieCinemaRep movieCinemaRep, MovieRep movieRep, CinemaRep cinemaRep){
        this.movieCinemaRep = movieCinemaRep;
        this.movieRep = movieRep;
        this.cinemaRep = cinemaRep;
    }
    public List<MovieCinema> getAll(){

        return movieCinemaRep.findAll();
    }
    public MovieCinema create(MovieCinema movieCinema) {
        if (movieCinema.getMovie() == null || movieCinema.getMovie().getMovieId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "movie.movieId is required");
        }
        if (movieCinema.getCinema() == null || movieCinema.getCinema().getCinemaId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cinema.cinemaId is required");
        }
        Long movieId = movieCinema.getMovie().getMovieId();
        Long cinemaId = movieCinema.getCinema().getCinemaId();

        Movie movie = movieRep.findById(movieId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));

        Cinema cinema = cinemaRep.findById(cinemaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cinema not found"));

        movieCinema.setMovie(movie);
        movieCinema.setCinema(cinema);

        return movieCinemaRep.save(movieCinema);
    }
    @Transactional
    public MovieCinema update(Long mcId, MovieCinema newMovieCinema) {
        MovieCinema mc = movieCinemaRep.findById(mcId).orElseThrow(() -> new RuntimeException("Movie not found"));
        mc.setMcTimestamp(newMovieCinema.getMcTimestamp());
        mc.setMcPrice(newMovieCinema.getMcPrice());
        mc.setMcAvailableSeats(newMovieCinema.getMcAvailableSeats());
        if (newMovieCinema.getMovie() != null && newMovieCinema.getMovie().getMovieId() != null) {
            Movie movie = movieRep.findById(newMovieCinema.getMovie().getMovieId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
            mc.setMovie(movie);
        }
        if (newMovieCinema.getCinema() != null && newMovieCinema.getCinema().getCinemaId() != null) {
            Cinema cinema = cinemaRep.findById(newMovieCinema.getCinema().getCinemaId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found"));
            mc.setCinema(cinema);
        }
        return movieCinemaRep.save(mc);
    }
    @Transactional
    public void delete(Long mcId){
        MovieCinema mc = movieCinemaRep.findById(mcId).orElseThrow(() -> new RuntimeException("Movie with id: " + mcId + " not found!"));
        movieCinemaRep.delete(mc);
    }
}