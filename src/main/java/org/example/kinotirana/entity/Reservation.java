package org.example.kinotirana.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
    @CreationTimestamp
    private Date reservationTimestamp;
    private boolean reservationConfirmed;
    private boolean reservationIsActive = true;
}
