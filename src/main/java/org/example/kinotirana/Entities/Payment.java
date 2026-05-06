package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "PAYMENT")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String paymentMethod;
    private String paymentStatus;
    private double paymentAmount;
    @CreationTimestamp
    private Date paymentTimestamp;
    private int transactionNr;
    private boolean paymentIsActive;

    public Payment(Long paymentId, String paymentMethod, String paymentStatus, double paymentAmount, Date paymentTimestamp, int transactionNr, boolean paymentIsActive) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paymentAmount = paymentAmount;
        this.paymentTimestamp = paymentTimestamp;
        this.transactionNr = transactionNr;
        this.paymentIsActive = paymentIsActive;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentTimestamp() {
        return paymentTimestamp;
    }

    public void setPaymentTimestamp(Date paymentTimestamp) {
        this.paymentTimestamp = paymentTimestamp;
    }

    public int getTransactionNr() {
        return transactionNr;
    }

    public void setTransactionNr(int transactionNr) {
        this.transactionNr = transactionNr;
    }

    public boolean isPaymentIsActive() {return paymentIsActive;}

    public void setPaymentIsActive(boolean paymentIsActive) {this.paymentIsActive = paymentIsActive;}
}
