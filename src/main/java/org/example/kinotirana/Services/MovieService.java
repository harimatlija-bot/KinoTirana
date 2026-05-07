package org.example.kinotirana.Services;

import org.example.kinotirana.Entities.Movie;
import org.example.kinotirana.Repositories.MovieRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {
    private final MovieRep movieRep;
    public MovieService (MovieRep movieRep){
        this.movieRep = movieRep;
    }
    public List<Movie> getAll(){
        return movieRep.fingByMovieIsActiveTrue();
    }
    public Movie create (Movie movie){
        return movieRep.save(movie);
    }
    @Transactional
    public Movie update (Long movieId, Movie newMovie){
        Movie m = movieRep.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        m.setMovieTitle(newMovie.getMovieTitle());
        m.setMovieGenre(newMovie.getMovieGenre());
        m.setMovieDirector(newMovie.getMovieDirector());
        m.setMovieCast(newMovie.getMovieCast());
        m.setMovieSynopsis(newMovie.getMovieSynopsis());
        m.setMovieReleaseDate(newMovie.getMovieReleaseDate());
        m.setMovieDuration(newMovie.getMovieDuration());
        m.setMovieTrailerUrl(newMovie.getMovieTrailerUrl());
        m.setMovieIsActive(newMovie.isMovieIsActive());
        return movieRep.save(m);
    }
    @Transactional
    public void delete (Long movieId){
        Movie m = movieRep.findById(movieId).orElseThrow(() -> new RuntimeException("Movie with id: " + movieId + " not found!"));
        m.setMovieIsActive(false);
    }
}