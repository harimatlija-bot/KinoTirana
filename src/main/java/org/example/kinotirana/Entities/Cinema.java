package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cinema {
    @OneToMany(mappedBy = "cinema")
    private List<Movie_Cinema> movieCinemas;
    @OneToMany(mappedBy = "cinema")
    private List<Event> events;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;
    @NotBlank
    private String cinemaName;
    @NotNull
    @Embedded
    private Address cinemaAddress;
    private LocalTime cinemaOpeningTime;
    private LocalTime cinemaClosingTime;
    private int cinemaOpeningDay;
    private boolean cinemaIsActive = true;
}