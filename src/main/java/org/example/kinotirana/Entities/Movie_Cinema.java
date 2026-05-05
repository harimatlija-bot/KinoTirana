package org.example.kinotirana.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="MOVIE_CINEMA")
public class Movie_Cinema {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieC_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date movieC_timestamp;
    private double movieC_price;
    private int movieC_available_seats;

    public Movie_Cinema(int movieC_id, Date movieC_timestamp, double movieC_price, int movieC_available_seats) {
        this.movieC_id = movieC_id;
        this.movieC_timestamp = movieC_timestamp;
        this.movieC_price = movieC_price;
        this.movieC_available_seats = movieC_available_seats;
    }

    public int getMovieC_id() {
        return movieC_id;
    }

    public void setMovieC_id(int movieC_id) {
        this.movieC_id = movieC_id;
    }

    public Date getMovieC_timestamp() {
        return movieC_timestamp;
    }

    public void setMovieC_timestamp(Date movieC_timestamp) {
        this.movieC_timestamp = movieC_timestamp;
    }

    public double getMovieC_price() {
        return movieC_price;
    }

    public void setMovieC_price(double movieC_price) {
        this.movieC_price = movieC_price;
    }

    public int getMovieC_available_seats() {
        return movieC_available_seats;
    }

    public void setMovieC_available_seats(int movieC_available_seats) {
        this.movieC_available_seats = movieC_available_seats;
    }
}
