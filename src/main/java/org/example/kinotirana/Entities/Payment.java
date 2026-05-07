package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "PAYMENT")

public class Payment {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @NotNull
    @Positive
    private double paymentAmount;
    private boolean paymentCompleted = false;
    @NotBlank
    private String cardHolderName;
    @NotNull
    private int cardLastFourDigits;
    @CreationTimestamp
    private Date paymentTimestamp;
    @NotNull
    private int transactionNr;
    private boolean paymentIsActive = true;

    public Payment(){}

    public Long getPaymentId() {return paymentId;}
    public void setPaymentId(Long paymentId) {this.paymentId = paymentId;}

    public PaymentMethod getPaymentMethod() {return paymentMethod;}
    public void setPaymentMethod(PaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}

    public boolean isPaymentCompleted() {return paymentCompleted;}
    public void setPaymentCompleted(boolean paymentCompleted) {this.paymentCompleted = paymentCompleted;}

    public String getCardHolderName() {return cardHolderName;}
    public void setCardHolderName(String cardHolderName) {this.cardHolderName = cardHolderName;}

    public int getCardLastFourDigits() {return cardLastFourDigits;}
    public void setCardLastFourDigits(int cardLastFourDigits) {this.cardLastFourDigits = cardLastFourDigits;}

    public double getPaymentAmount() {return paymentAmount;}
    public void setPaymentAmount(double paymentAmount) {this.paymentAmount = paymentAmount;}

    public Date getPaymentTimestamp() {return paymentTimestamp;}
    public void setPaymentTimestamp(Date paymentTimestamp) {this.paymentTimestamp = paymentTimestamp;}

    public int getTransactionNr() {return transactionNr;}

    public void setTransactionNr(int transactionNr) {this.transactionNr = transactionNr;}

    public boolean isPaymentIsActive() {return paymentIsActive;}
    public void setPaymentIsActive(boolean paymentIsActive) {this.paymentIsActive = paymentIsActive;}
}
