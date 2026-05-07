package org.example.kinotirana.Controllers;

import jakarta.validation.Valid;
import org.example.kinotirana.Entities.Cinema;
import org.example.kinotirana.Services.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kinema")
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }
    @GetMapping
    public List<Cinema> getAll() {
        return cinemaService.getAll();
    }
    @PostMapping
    public Cinema create(@Valid @RequestBody Cinema cinema) {
        return cinemaService.create(cinema);
    }
    @PutMapping("/{id}")
    public Cinema update(@PathVariable Long id, @Valid @RequestBody Cinema cinema) {
        return cinemaService.update(id, cinema);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cinemaService.delete(id);
    }
}