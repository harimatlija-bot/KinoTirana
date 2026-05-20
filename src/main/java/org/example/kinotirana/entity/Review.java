package org.example.kinotirana.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "REVIEW")
public class Review {
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @NotNull
    @Min(1)
    @Max(10)
    private double reviewRate;
    @NotBlank
    private String reviewComment;
    private LocalDateTime reviewDate;
    private boolean reviewIsActive = true;
}
