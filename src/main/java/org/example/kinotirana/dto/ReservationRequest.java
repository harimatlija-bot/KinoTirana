package org.example.kinotirana.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long mcId;
    private LocalDateTime reservationTimestamp;
    private boolean reservationConfirmed;
}
