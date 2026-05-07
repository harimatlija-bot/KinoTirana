package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @CreationTimestamp
    private Date reservationTimestamp;
    private boolean reservationConfirmed;
    private boolean reservationIsActive = true;

    public Reservation(){}

    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationTimestamp() {
        return reservationTimestamp;
    }
    public void setReservationTimestamp(Date reservationTimestamp) {
        this.reservationTimestamp = reservationTimestamp;
    }

    public boolean isReservationConfirmed() {return reservationConfirmed;}
    public void setReservationConfirmed(boolean reservationConfirmed) {this.reservationConfirmed = reservationConfirmed;}

    public boolean isReservationIsActive() {
        return reservationIsActive;
    }
    public void setReservationIsActive(boolean reservationIsActive) {
        this.reservationIsActive = reservationIsActive;
    }
}
