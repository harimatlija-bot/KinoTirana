package org.example.kinotirana.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;
    @CreationTimestamp
    private Date reservation_timestamp;
    private boolean reservation_confirmed;
    private boolean reservation_is_active;

    public Reservation(int reservation_id, Date reservation_timestamp, boolean reservation_confirmed, boolean reservation_is_active) {
        this.reservation_id = reservation_id;
        this.reservation_timestamp = reservation_timestamp;
        this.reservation_confirmed = reservation_confirmed;
        this.reservation_is_active = reservation_is_active;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Date getReservation_timestamp() {
        return reservation_timestamp;
    }

    public void setReservation_timestamp(Date reservation_timestamp) {
        this.reservation_timestamp = reservation_timestamp;
    }

    public boolean isReservation_confirmed() {
        return reservation_confirmed;
    }

    public void setReservation_confirmed(boolean reservation_confirmed) {
        this.reservation_confirmed = reservation_confirmed;
    }

    public boolean isReservation_is_active() {
        return reservation_is_active;
    }

    public void setReservation_is_active(boolean reservation_is_active) {
        this.reservation_is_active = reservation_is_active;
    }
}
