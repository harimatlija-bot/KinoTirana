package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRep extends JpaRepository <Payment, Long> {
    List<Payment> fingByPaymentIsActiveTrue();
}
