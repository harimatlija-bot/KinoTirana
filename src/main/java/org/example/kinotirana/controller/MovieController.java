package org.example.kinotirana.controller;

import org.example.kinotirana.entity.Movie;
import org.example.kinotirana.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filma")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }
    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }
    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }
}