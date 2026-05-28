package org.example.kinotirana.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long movieId;
    @NotNull
    @Min(1)
    @Max(10)
    private double reviewRate;
    @NotBlank
    private String reviewComment;
    private LocalDateTime reviewDate;
}
