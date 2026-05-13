package org.example.kinotirana.controller;

import jakarta.validation.Valid;
import org.example.kinotirana.entity.Payment;
import org.example.kinotirana.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagesa")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }
    @PostMapping
    public Payment create(@Valid @RequestBody Payment payment) {
        return paymentService.create(payment);
    }
    @PutMapping("/{id}")
    public Payment update(@PathVariable Long id, @Valid @RequestBody Payment payment) {
        return paymentService.update(id, payment);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
