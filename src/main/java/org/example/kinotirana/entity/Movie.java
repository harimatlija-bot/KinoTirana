package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties({"reviews", "movieCinemas"})
@Entity
@Table(name="MOVIE")
public class Movie {
    @JsonIgnoreProperties("movie")
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;
    @JsonIgnoreProperties("movie")
    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinemas;
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
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String movieSynopsis;
    private LocalDate movieReleaseDate;
    @NotNull
    private Integer movieDuration;
    @URL(message = "Must be a valid URL")
    private String movieTrailerUrl;
    private boolean movieIsActive = true;
}