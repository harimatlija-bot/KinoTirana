package org.example.kinotirana.Controllers;

import jakarta.validation.Valid;
import org.example.kinotirana.Entities.Movie_Cinema;
import org.example.kinotirana.Services.Movie_CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmKinema")
public class MovieCinemaController {
    private final Movie_CinemaService movieCinemaService;
    public MovieCinemaController(Movie_CinemaService movieCinemaService) {
        this.movieCinemaService = movieCinemaService;
    }
    @GetMapping
    public List<Movie_Cinema> getAll() {
        return movieCinemaService.getAll();
    }
    @PostMapping
    public Movie_Cinema create(@Valid @RequestBody Movie_Cinema movieCinema) {
        return movieCinemaService.create(movieCinema);
    }
    @PutMapping("/{id}")
    public Movie_Cinema update(@PathVariable Long id, @Valid @RequestBody Movie_Cinema movieCinema) {
        return movieCinemaService.update(id, movieCinema);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieCinemaService.delete(id);
    }
}