package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties({"payment"})
@Entity
@Table(name = "RESERVATION")
public class Reservation {
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
