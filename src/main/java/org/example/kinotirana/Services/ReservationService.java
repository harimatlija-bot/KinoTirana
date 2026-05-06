package org.example.kinotirana.Services;

import org.example.kinotirana.Entities.Reservation;
import org.example.kinotirana.Repositories.ReservationRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRep reservationRep;
    public ReservationService(ReservationRep reservationRep){
        this.reservationRep=reservationRep;
    }
    public List<Reservation> getAll(){
        return reservationRep.findAll();
    }
    public Reservation create (Reservation reservation){
        return reservationRep.save(reservation);
    }
    @Transactional
    public Reservation update (Long reservationId, Reservation newreservation){
        Reservation res = reservationRep.findById(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found"));
        res.setReservationTimestamp(newreservation.getReservationTimestamp());
        res.setReservationConfirmed(newreservation.isReservationConfirmed());
        res.setReservationIsActive(newreservation.isReservationIsActive());
        return reservationRep.save(res);
    }
    @Transactional
    public void delete (Long reservationId){
        Reservation res = reservationRep.findById(reservationId).orElseThrow(() -> new RuntimeException("Reservation with id: " + reservationId + " not found!"));
        res.setReservationIsActive(false);
    }
}