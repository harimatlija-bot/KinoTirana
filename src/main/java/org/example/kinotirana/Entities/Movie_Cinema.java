package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="MOVIE_CINEMA")
public class Movie_Cinema {
    @OneToMany(mappedBy = "movie_cinema")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieCId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date movieCTimestamp;
    @NotNull
    private double movieCPrice;
    @NotNull
    @Min(0)
    private int movieCAvailSeats;
}
