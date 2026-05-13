package org.example.kinotirana.controller;

import jakarta.validation.Valid;
import org.example.kinotirana.entity.Reservation;
import org.example.kinotirana.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rezervime")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }
    @PostMapping
    public Reservation create(@Valid @RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }
    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id, @Valid @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.delete(id);
    }
}