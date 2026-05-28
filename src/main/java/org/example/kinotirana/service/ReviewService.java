package org.example.kinotirana.service;

import org.example.kinotirana.dto.ReviewRequest;
import org.example.kinotirana.entity.Movie;
import org.example.kinotirana.entity.Review;
import org.example.kinotirana.entity.User;
import org.example.kinotirana.repository.MovieRep;
import org.example.kinotirana.repository.ReviewRep;
import org.example.kinotirana.repository.UserRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRep reviewRep;
    private final UserRep userRep;
    private final MovieRep movieRep;
    public ReviewService(ReviewRep reviewRep, UserRep userRep, MovieRep movieRep){
        this.reviewRep = reviewRep;
        this.userRep = userRep;
        this.movieRep = movieRep;
    }
    public List<Review> getAll(){
        return reviewRep.findByReviewIsActiveTrue();
    }
    public Review create (ReviewRequest reviewRequest){
        User user = userRep.findById(reviewRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRep.findById(reviewRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Review r = new Review();
        r.setUser(user);
        r.setMovie(movie);
        r.setReviewIsActive(true);
        r.setReviewRate(reviewRequest.getReviewRate());
        r.setReviewDate(reviewRequest.getReviewDate());
        r.setReviewComment(reviewRequest.getReviewComment());
        return reviewRep.save(r);
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