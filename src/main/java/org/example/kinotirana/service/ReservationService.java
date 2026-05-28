package org.example.kinotirana.service;

import org.example.kinotirana.dto.ReservationRequest;
import org.example.kinotirana.entity.MovieCinema;
import org.example.kinotirana.entity.Reservation;
import org.example.kinotirana.entity.User;
import org.example.kinotirana.repository.MovieCinemaRep;
import org.example.kinotirana.repository.ReservationRep;
import org.example.kinotirana.repository.UserRep;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRep reservationRep;
    private final UserRep userRep;
    private final MovieCinemaRep movieCinemaRep;

    public ReservationService (ReservationRep reservationRep, UserRep userRep, MovieCinemaRep movieCinemaRep){
        this.reservationRep = reservationRep;
        this.userRep = userRep;
        this.movieCinemaRep = movieCinemaRep;
    }
    public List<Reservation> getAll(){
        return reservationRep.findByReservationIsActiveTrue();
    }

    public Reservation create (@NonNull ReservationRequest reservationRequest){
        User user = userRep.findById(reservationRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        MovieCinema movieCinema = movieCinemaRep.findById(reservationRequest.getMcId())
                .orElseThrow(() -> new RuntimeException("MCid doesn't exist"));

        Reservation r = new Reservation();
        r.setUser(user);
        r.setMovieCinema(movieCinema);
        r.setReservationTimestamp(reservationRequest.getReservationTimestamp());
        r.setReservationConfirmed(reservationRequest.isReservationConfirmed());
        r.setReservationIsActive(true);

        return reservationRep.save(r);
    }

    @Transactional
    public Reservation update (Long reservationId, @NonNull Reservation newreservation){
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