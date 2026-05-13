package org.example.kinotirana.service;

import org.example.kinotirana.entity.Review;
import org.example.kinotirana.repository.ReviewRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRep reviewRep;
    public ReviewService(ReviewRep reviewRep){
        this.reviewRep = reviewRep;
    }
    public List<Review> getAll(){
        return reviewRep.findByReviewIsActiveTrue();
    }
    public Review create (Review review){
        return reviewRep.save(review);
    }
    @Transactional
    public Review update (Long reviewId, Review newreview){
        Review r = reviewRep.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        r.setReviewRate(newreview.getReviewRate());
        r.setReviewComment(newreview.getReviewComment());
        r.setReviewDate(newreview.getReviewDate());
        r.setReviewIsActive(newreview.isReviewIsActive());
        return reviewRep.save(r);
    }
    @Transactional
    public void delete (Long reviewId){
        Review r = reviewRep.findById(reviewId).orElseThrow(() -> new RuntimeException("Review with id: " + reviewId + " not found!"));
        r.setReviewIsActive(false);
    }
}