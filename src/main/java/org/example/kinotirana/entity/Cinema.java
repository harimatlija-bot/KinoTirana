package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties({"movieCinemas", "events"})
@Entity
@Table (name = "CINEMA")

public class Cinema {
    @JsonIgnoreProperties("cinema")
    @OneToMany(mappedBy = "cinema")
    private List<MovieCinema> movieCinemas;
    @JsonIgnoreProperties("cinema")
    @OneToMany(mappedBy = "cinema")
    private List<Event> events;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;
    @NotBlank
    private String cinemaName;
    @Embedded
    private Address cinemaAddress;
    private LocalTime cinemaOpeningTime;
    private LocalTime cinemaClosingTime;
    private String cinemaOpeningDay;
    private boolean cinemaIsActive = true;
}