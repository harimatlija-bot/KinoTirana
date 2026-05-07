package org.example.kinotirana.Controllers;

import jakarta.validation.Valid;
import org.example.kinotirana.Entities.Review;
import org.example.kinotirana.Services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }
    @PostMapping
    public Review create(@Valid @RequestBody Review review) {
        return reviewService.create(review);
    }
    @PutMapping("/{id}")
    public Review update(@PathVariable Long id, @Valid @RequestBody Review review) {
        return reviewService.update(id, review);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}