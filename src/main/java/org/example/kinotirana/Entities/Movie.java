package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.time.DurationMin;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="MOVIE")
public class Movie {
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;
    @OneToMany(mappedBy = "movie")
    private List<Movie_Cinema> movieCinemas;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @NotBlank
    private String movieTitle;
    @NotBlank
    private String movieGenre;
    @NotBlank
    private String movieDirector;
    @NotBlank
    private String movieCast;
    @Lob
    private String movieSynopsis;
    @Temporal(TemporalType.TIMESTAMP)
    private Date movieReleaseDate;
    @DurationMin(minutes = 1)
    private Duration movieDuration;
    @URL(message = "Must be a valid URL")
    private String movieTrailerUrl;
    private boolean movieIsActive = true;
}
