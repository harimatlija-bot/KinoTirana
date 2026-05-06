package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import java.time.Duration;
import java.util.Date;

@Entity
@Table(name="MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String movieTitle;
    private String movieGenre;
    private String movieDirector;
    private String movieCast;
    @Lob
    private String movieSynopsis;
    @Temporal(TemporalType.TIMESTAMP)
    private Date movieReleaseDate;
    private Duration movieDuration;
    @URL(message = "Must be a valid URL")
    private String movieTrailerUrl;
    private boolean movieIsActive;

    public Movie(Long movieId, String movieTitle, String movieGenre, String movieDirector, String movieCast, String movieSynopsis, Date movieReleaseDate, Duration movieDuration, String movieTrailerUrl, boolean movieIsActive) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieDirector = movieDirector;
        this.movieCast = movieCast;
        this.movieSynopsis = movieSynopsis;
        this.movieReleaseDate = movieReleaseDate;
        this.movieDuration = movieDuration;
        this.movieTrailerUrl = movieTrailerUrl;
        this.movieIsActive = movieIsActive;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(String movieCast) {
        this.movieCast = movieCast;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public Date getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public Duration getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(Duration movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieTrailerUrl() {
        return movieTrailerUrl;
    }

    public void setMovieTrailerUrl(String movieTrailerUrl) {
        this.movieTrailerUrl = movieTrailerUrl;
    }

    public boolean isMovieIsActive() {
        return movieIsActive;
    }

    public void setMovieIsActive(boolean movieIsActive) {
        this.movieIsActive = movieIsActive;
    }
}
