package org.example.kinotirana.Controllers;

import org.example.kinotirana.Entities.Reservation;
import org.example.kinotirana.Services.ReservationService;
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
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }
    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.delete(id);
    }
}