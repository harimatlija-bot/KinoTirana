package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRep extends JpaRepository<Review, Long> {
}
