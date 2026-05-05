package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import java.time.Duration;
import java.util.Date;

@Entity
@Table(name="MOVIE")
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    private String movie_title;
    private String movie_genre;
    private String movie_director;
    private String movie_cast;
    @Lob
    private String movie_synopsis;
    @Temporal(TemporalType.TIMESTAMP)
    private Date movie_releaseDate;
    private Duration movie_duration;
    @URL(message = "Must be a valid URL")
    private String movie_trailerUrl;
    private boolean movie_isActive;

    public Movie(int movie_id, String movie_title, String movie_genre, String movie_director, String movie_cast, String movie_synopsis, Date movie_releaseDate, Duration movie_duration, String movie_trailerUrl, boolean movie_isActive) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_genre = movie_genre;
        this.movie_director = movie_director;
        this.movie_cast = movie_cast;
        this.movie_synopsis = movie_synopsis;
        this.movie_releaseDate = movie_releaseDate;
        this.movie_duration = movie_duration;
        this.movie_trailerUrl = movie_trailerUrl;
        this.movie_isActive = movie_isActive;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_cast() {
        return movie_cast;
    }

    public void setMovie_cast(String movie_cast) {
        this.movie_cast = movie_cast;
    }

    public String getMovie_synopsis() {
        return movie_synopsis;
    }

    public void setMovie_synopsis(String movie_synopsis) {
        this.movie_synopsis = movie_synopsis;
    }

    public Date getMovie_releaseDate() {
        return movie_releaseDate;
    }

    public void setMovie_releaseDate(Date movie_releaseDate) {
        this.movie_releaseDate = movie_releaseDate;
    }

    public Duration getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(Duration movie_duration) {
        this.movie_duration = movie_duration;
    }

    public String getMovie_trailerUrl() {
        return movie_trailerUrl;
    }

    public void setMovie_trailerUrl(String movie_trailerUrl) {
        this.movie_trailerUrl = movie_trailerUrl;
    }

    public boolean isMovie_isActive() {
        return movie_isActive;
    }

    public void setMovie_isActive(boolean movie_isActive) {
        this.movie_isActive = movie_isActive;
    }
}
