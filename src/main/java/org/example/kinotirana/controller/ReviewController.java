package org.example.kinotirana.controller;

import jakarta.validation.Valid;
import org.example.kinotirana.dto.ReviewRequest;
import org.example.kinotirana.entity.Review;
import org.example.kinotirana.service.ReviewService;
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
    public Review create(@Valid @RequestBody ReviewRequest reviewRequest) {
        return reviewService.create(reviewRequest);
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