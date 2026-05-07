package org.example.kinotirana.Controllers;

import jakarta.validation.Valid;
import org.example.kinotirana.Entities.Payment;
import org.example.kinotirana.Services.PaymentService;
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
