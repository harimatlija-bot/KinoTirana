package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

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
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @NotNull
    @Positive
    private double paymentAmount;
    private boolean paymentCompleted = false;
    private String cardHolderName;
    private Integer cardLastFourDigits;
    @CreationTimestamp
    private Date paymentTimestamp;
    @NotNull
    private int transactionNr;
    private boolean paymentIsActive = true;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
