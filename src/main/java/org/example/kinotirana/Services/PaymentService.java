package org.example.kinotirana.Services;

import org.example.kinotirana.Entities.Payment;
import org.example.kinotirana.Repositories.CinemaRep;
import org.example.kinotirana.Repositories.PaymentRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRep paymentRep;
    public PaymentService(PaymentRep paymentRep){
        this.paymentRep = paymentRep;
    }
    public List<Payment> getAll(){
        return paymentRep.fingByPaymentIsActiveTrue();
    }
    public Payment create (Payment payment){
        return paymentRep.save(payment);
    }
    @Transactional
    public Payment update (Long paymentId, Payment newpayment){
        Payment p = paymentRep.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));
        p.setPaymentMethod(newpayment.getPaymentMethod());
        p.setPaymentCompleted(newpayment.isPaymentCompleted());
        p.setCardHolderName(newpayment.getCardHolderName());
        p.setCardLastFourDigits(newpayment.getCardLastFourDigits());
        p.setPaymentAmount(newpayment.getPaymentAmount());
        p.setPaymentTimestamp(newpayment.getPaymentTimestamp());
        p.setTransactionNr(newpayment.getTransactionNr());
        p.setPaymentIsActive(newpayment.isPaymentIsActive());
        return paymentRep.save(p);
    }
    @Transactional
    public void delete (Long paymentId){
        Payment p = paymentRep.findById(paymentId).orElseThrow(()-> new RuntimeException("Payment with id: " + paymentId + " not found!"));
        p.setPaymentIsActive(false);
    }
}