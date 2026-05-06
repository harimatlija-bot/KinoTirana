package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "REVIEW")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private double reviewRate;
    private String reviewComment;
    @CreationTimestamp
    private Date reviewDate;
    private boolean reviewIsActive;

    public Review(Long reviewId, double reviewRate, String reviewComment, Date reviewDate, boolean reviewIsActive) {
        this.reviewId = reviewId;
        this.reviewRate = reviewRate;
        this.reviewComment = reviewComment;
        this.reviewDate = reviewDate;
        this.reviewIsActive = reviewIsActive;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public double getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(double reviewRate) {
        this.reviewRate = reviewRate;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public boolean isReviewIsActive() {
        return reviewIsActive;
    }

    public void setReviewIsActive(boolean reviewIsActive) {
        this.reviewIsActive = reviewIsActive;
    }
}
