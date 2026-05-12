package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @JoinColumn(name = "movieCId")
    private Movie_Cinema movieCinema;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @CreationTimestamp
    private Date reservationTimestamp;
    private boolean reservationConfirmed;
    private boolean reservationIsActive = true;
}
