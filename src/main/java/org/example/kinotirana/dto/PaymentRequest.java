package org.example.kinotirana.dto;
import lombok.*;
import org.example.kinotirana.entity.PaymentMethod;
import org.example.kinotirana.entity.PaymentStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentRequest {
    private Long reservationId;
    private PaymentMethod paymentMethod;
    private double paymentAmount;
    private boolean paymentCompleted;
    private String cardHolderName;
    private String cardLastFourDigits;
    private LocalDateTime paymentTimestamp;
    private Long transactionNr;
    private boolean paymentIsActive = true;
    private PaymentStatus paymentStatus;
}