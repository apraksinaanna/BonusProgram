package com.example.bonusprogram.conroller;

import com.example.bonusprogram.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

// REST контроллер для информации о платеже
@RestController
@RequestMapping("/api")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/{status}/{amount}")
    public void getStatusPayment(@PathVariable String status,
                                 @PathVariable BigDecimal amount) {
        paymentService.getPayment(status, amount);
    }

}
