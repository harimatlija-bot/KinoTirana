package org.example.kinotirana.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "REVIEW")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    private double review_rate;
    private String review_comment;
    @CreationTimestamp
    private Date review_date;
    private boolean review_is_active;

    public Review(int review_id, double review_rate, String review_comment, Date review_date, boolean review_is_active) {
        this.review_id = review_id;
        this.review_rate = review_rate;
        this.review_comment = review_comment;
        this.review_date = review_date;
        this.review_is_active = review_is_active;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public double getReview_rate() {
        return review_rate;
    }

    public void setReview_rate(double review_rate) {
        this.review_rate = review_rate;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }

    public boolean isReview_is_active() {
        return review_is_active;
    }

    public void setReview_is_active(boolean review_is_active) {
        this.review_is_active = review_is_active;
    }
}
