package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRep extends JpaRepository<Reservation, Long> {
}
