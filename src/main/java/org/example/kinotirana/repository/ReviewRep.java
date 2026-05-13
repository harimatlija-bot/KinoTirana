package org.example.kinotirana.repository;

import org.example.kinotirana.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRep extends JpaRepository<Review, Long> {
    List<Review> findByReviewIsActiveTrue();
}
