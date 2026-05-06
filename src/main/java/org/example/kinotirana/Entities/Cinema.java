package org.example.kinotirana.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;
    private String cinemaName;
    private Address cinemaAddress;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cinemaOpeningTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cinemaClosingTime;
    private int cinemaOpeningDay;
    private boolean cinemaIsActive;

    public Cinema() {}

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Address getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(Address cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public Date getCinemaOpeningTime() {
        return cinemaOpeningTime;
    }

    public void setCinemaOpeningTime(Date cinemaOpeningTime) {
        this.cinemaOpeningTime = cinemaOpeningTime;
    }

    public Date getCinemaClosingTime() {
        return cinemaClosingTime;
    }

    public void setCinemaClosingTime(Date cinemaClosingTime) {
        this.cinemaClosingTime = cinemaClosingTime;
    }

    public int getCinemaOpeningDay() {
        return cinemaOpeningDay;
    }

    public void setCinemaOpeningDay(int cinemaOpeningDay) {
        this.cinemaOpeningDay = cinemaOpeningDay;
    }

    public boolean isCinemaIsActive() {
        return cinemaIsActive;
    }

    public void setCinemaIsActive(boolean cinemaIsActive) {
        this.cinemaIsActive = cinemaIsActive;
    }
}
