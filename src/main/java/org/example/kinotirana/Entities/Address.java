package org.example.kinotirana.Entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Address {
    @NotBlank
    private String cityName;
    @NotBlank
    private String streetName;
    @NotNull
    private double streetNr;
    @NotNull
    private int zipCode;
    @NotBlank
    private String country;

    public Address() {}

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public double getStreetNr() {
        return streetNr;
    }
    public void setStreetNr(double streetNr) {
        this.streetNr = streetNr;
    }

    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNr=" + streetNr +
                ", zipCode=" + zipCode +
                ", country='" + country + '\'' +
                '}';
    }
}
