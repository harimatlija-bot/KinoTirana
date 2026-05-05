package org.example.kinotirana.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Cinema {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinema_id;
    private String cinema_name;
    private String cinema_address;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cinema_openingTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cinema_closingTime;
    private int cinema_openingDay;
    private boolean cinema_isActive;

    public Cinema(int cinema_id, String cinema_name, String cinema_address, Date cinema_openingTime, Date cinema_closingTime, int cinema_openingDay, boolean cinema_isActive) {
        this.cinema_id = cinema_id;
        this.cinema_name = cinema_name;
        this.cinema_address = cinema_address;
        this.cinema_openingTime = cinema_openingTime;
        this.cinema_closingTime = cinema_closingTime;
        this.cinema_openingDay = cinema_openingDay;
        this.cinema_isActive = cinema_isActive;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getCinema_address() {
        return cinema_address;
    }

    public void setCinema_address(String cinema_address) {
        this.cinema_address = cinema_address;
    }

    public Date getCinema_openingTime() {
        return cinema_openingTime;
    }

    public void setCinema_openingTime(Date cinema_openingTime) {
        this.cinema_openingTime = cinema_openingTime;
    }

    public Date getCinema_closingTime() {
        return cinema_closingTime;
    }

    public void setCinema_closingTime(Date cinema_closingTime) {
        this.cinema_closingTime = cinema_closingTime;
    }

    public int getCinema_openingDay() {
        return cinema_openingDay;
    }

    public void setCinema_openingDay(int cinema_openingDay) {
        this.cinema_openingDay = cinema_openingDay;
    }

    public boolean isCinema_isActive() {
        return cinema_isActive;
    }

    public void setCinema_isActive(boolean cinema_isActive) {
        this.cinema_isActive = cinema_isActive;
    }
}
