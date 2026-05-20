package org.example.kinotirana.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PAYMENT")

public class Payment {
    @OneToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @NotNull
    @Positive
    private double paymentAmount;
    private boolean paymentCompleted = false;
    private String cardHolderName;
    private String cardLastFourDigits;
    private LocalDateTime paymentTimestamp;
    @NotNull
    private Long transactionNr;
    private boolean paymentIsActive = true;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
