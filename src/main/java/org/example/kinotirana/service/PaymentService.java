package org.example.kinotirana.service;

import org.example.kinotirana.entity.Payment;
import org.example.kinotirana.entity.PaymentMethod;
import org.example.kinotirana.repository.PaymentRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRep paymentRep;
    public PaymentService(PaymentRep paymentRep) {
        this.paymentRep = paymentRep;
    }

    public List<Payment> getAll() {
        return paymentRep.findByPaymentIsActiveTrue();
    }

    public Payment create(Payment payment) {
        validatePayment(payment);
        return paymentRep.save(payment);
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

    private void validatePayment(Payment payment) {
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