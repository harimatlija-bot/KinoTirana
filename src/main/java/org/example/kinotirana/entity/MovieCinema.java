package org.example.kinotirana.entity;

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
public class MovieCinema {
    @OneToMany(mappedBy = "movieCinema")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date mcTimestamp;
    @NotNull
    private double mcPrice;
    @NotNull
    @Min(0)
    private int mcAvailableSeats;
}
