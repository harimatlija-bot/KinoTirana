package org.example.kinotirana.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="MOVIE_CINEMA")
public class Movie_Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieCId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date movieCTimestamp;
    private double movieCPrice;
    private int movieCAvailSeats;


    public Movie_Cinema(Long movieCId, Date movieCTimestamp, double movieCPrice, int movieCAvailSeats) {
        this.movieCId = movieCId;
        this.movieCTimestamp = movieCTimestamp;
        this.movieCPrice = movieCPrice;
        this.movieCAvailSeats = movieCAvailSeats;
    }

    public Long getMovieCId() {
        return movieCId;
    }

    public void setMovieCId(Long movieCId) {
        this.movieCId = movieCId;
    }

    public Date getMovieCTimestamp() {
        return movieCTimestamp;
    }

    public void setMovieCTimestamp(Date movieCTimestamp) {
        this.movieCTimestamp = movieCTimestamp;
    }

    public double getMovieCPrice() {
        return movieCPrice;
    }

    public void setMovieCPrice(double movieCPrice) {
        this.movieCPrice = movieCPrice;
    }

    public int getMovieCAvailSeats() {
        return movieCAvailSeats;
    }

    public void setMovieCAvailSeats(int movieCAvailSeats) {
        this.movieCAvailSeats = movieCAvailSeats;
    }
}
