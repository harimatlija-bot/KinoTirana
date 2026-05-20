package org.example.kinotirana.controller;

import org.example.kinotirana.entity.Cinema;
import org.example.kinotirana.service.CinemaService;
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
    public Cinema create(@RequestBody Cinema cinemas) {
        return cinemaService.create(cinemas);
    }
    @PutMapping("/{id}")
    public Cinema update(@PathVariable Long id, @RequestBody Cinema cinemas) {
        return cinemaService.update(id, cinemas);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cinemaService.delete(id);
    }
}