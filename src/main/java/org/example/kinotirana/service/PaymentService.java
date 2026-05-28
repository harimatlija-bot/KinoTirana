package org.example.kinotirana.service;

import org.example.kinotirana.dto.PaymentRequest;
import org.example.kinotirana.entity.Payment;
import org.example.kinotirana.entity.PaymentMethod;
import org.example.kinotirana.entity.Reservation;
import org.example.kinotirana.repository.PaymentRep;
import org.example.kinotirana.repository.ReservationRep;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRep paymentRep;
    private final ReservationRep reservationRep;
    public PaymentService(PaymentRep paymentRep, ReservationRep reservationRep) {
        this.paymentRep = paymentRep;
        this.reservationRep = reservationRep;
    }

    public List<Payment> getAll() {
        return paymentRep.findByPaymentIsActiveTrue();
    }

    public Payment create(PaymentRequest request) {
        Reservation reservation = reservationRep.findById(request.getReservationId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        Payment p = new Payment();
        p.setReservation(reservation);
        p.setPaymentMethod(request.getPaymentMethod());
        p.setPaymentAmount(request.getPaymentAmount());
        p.setPaymentCompleted(request.isPaymentCompleted());
        p.setCardHolderName(request.getCardHolderName());
        p.setCardLastFourDigits(request.getCardLastFourDigits());
        p.setPaymentTimestamp(request.getPaymentTimestamp());
        p.setTransactionNr(request.getTransactionNr());
        p.setPaymentIsActive(true);
        p.setPaymentStatus(request.getPaymentStatus());

        validatePayment(p);
        return paymentRep.save(p);
    }

    @Transactional
    public Payment update(Long paymentId, Payment newpayment) {
        validatePayment(newpayment);
        Payment p = paymentRep.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));
        p.setPaymentMethod(newpayment.getPaymentMethod());
        p.setPaymentCompleted(newpayment.isPaymentCompleted());
        p.setCardHolderName(newpayment.getCardHolderName());
        p.setCardLastFourDigits(newpayment.getCardLastFourDigits());
        p.setPaymentAmount(newpayment.getPaymentAmount());
        p.setPaymentTimestamp(newpayment.getPaymentTimestamp());
        p.setTransactionNr(newpayment.getTransactionNr());
        p.setPaymentIsActive(newpayment.isPaymentIsActive());
        p.setPaymentStatus(newpayment.getPaymentStatus());
        return paymentRep.save(p);
    }

    @Transactional
    public void delete(Long paymentId) {
        Payment p = paymentRep.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment with id: " + paymentId + " not found!"));
        p.setPaymentIsActive(false);
    }

    private void validatePayment(@NonNull Payment payment) {
        if(payment.getPaymentMethod() == PaymentMethod.CREDIT_CARD) {
            if(payment.getCardHolderName() == null || payment.getCardHolderName().isBlank()) {
                throw new RuntimeException("Cardholder name is required");
            }
            if(payment.getCardLastFourDigits() == null || !payment.getCardLastFourDigits().matches("\\d{4}")) {
                throw new RuntimeException("Card last four digits are required");
            }
        }
    }
}