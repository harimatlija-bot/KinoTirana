package org.example.kinotirana.repository;

import org.example.kinotirana.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRep extends JpaRepository <Payment, Long> {
    List<Payment> findByPaymentIsActiveTrue();
}
