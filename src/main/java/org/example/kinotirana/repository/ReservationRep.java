package org.example.kinotirana.repository;

import org.example.kinotirana.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRep extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationIsActiveTrue();
}
