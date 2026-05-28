package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties({"reservations"})
@Entity
@Table(name="MOVIE_CINEMA")
public class MovieCinema {
    @JsonIgnoreProperties("movieCinema")
    @OneToMany(mappedBy = "movieCinema")
    private List<Reservation> reservations;
    @JsonIgnoreProperties({"reviews", "movieCinemas"})
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;
    @JsonIgnoreProperties({"movieCinemas", "events"})
    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcId;
    private LocalDateTime mcTimestamp;
    @NotNull
    private double mcPrice;
    @NotNull
    @Min(0)
    private int mcAvailableSeats;
}