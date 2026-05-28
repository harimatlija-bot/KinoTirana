package org.example.kinotirana.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MovieCinemaRequest {
    @NotNull
    private Long movieId;
    @NotNull
    private Long cinemaId;
    private LocalDateTime mcTimestamp;
    @NotNull
    private double mcPrice;
    @NotNull
    @Min(0)
    private int mcAvailableSeats;
}
