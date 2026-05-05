package org.example.kinotirana.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "PAYMENT")

public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;
    private String payment_method;
    private String payment_status;
    private double payment_amount;
    @CreationTimestamp
    private Date payment_timestamp;
    private int transaction_nr;

    public Payment(int payment_id, String payment_status, String payment_method, double payment_amount, Date payment_timestamp, int transaction_nr) {
        this.payment_id = payment_id;
        this.payment_status = payment_status;
        this.payment_method = payment_method;
        this.payment_amount = payment_amount;
        this.payment_timestamp = payment_timestamp;
        this.transaction_nr = transaction_nr;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public Date getPayment_timestamp() {
        return payment_timestamp;
    }

    public void setPayment_timestamp(Date payment_timestamp) {
        this.payment_timestamp = payment_timestamp;
    }

    public int getTransaction_nr() {
        return transaction_nr;
    }

    public void setTransaction_nr(int transaction_nr) {
        this.transaction_nr = transaction_nr;
    }
}
