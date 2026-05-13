package org.example.kinotirana.controller;

import jakarta.validation.Valid;
import org.example.kinotirana.entity.MovieCinema;
import org.example.kinotirana.service.MovieCinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmKinema")
public class MovieCinemaController {
    private final MovieCinemaService movieCinemaService;
    public MovieCinemaController(MovieCinemaService movieCinemaService) {
        this.movieCinemaService = movieCinemaService;
    }
    @GetMapping
    public List<MovieCinema> getAll() {
        return movieCinemaService.getAll();
    }
    @PostMapping
    public MovieCinema create(@Valid @RequestBody MovieCinema movieCinema) {
        return movieCinemaService.create(movieCinema);
    }
    @PutMapping("/{id}")
    public MovieCinema update(@PathVariable Long id, @Valid @RequestBody MovieCinema movieCinema) {
        return movieCinemaService.update(id, movieCinema);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieCinemaService.delete(id);
    }
}