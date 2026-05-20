package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @JsonCreator
    public Reservation(@JsonProperty("reservationId") Long reservationId) {
        this.reservationId = reservationId;
    }
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @OneToOne(mappedBy = "reservation")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "mcId")
    private MovieCinema movieCinema;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private LocalDateTime reservationTimestamp;
    private boolean reservationConfirmed;
    private boolean reservationIsActive = true;
}
