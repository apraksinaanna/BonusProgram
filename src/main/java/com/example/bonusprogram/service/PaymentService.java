package com.example.bonusprogram.service;

import com.example.bonusprogram.stateModel.PaymentContext;
import com.example.bonusprogram.stateModel.StatusName;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// серсив для получении информации о платеже
@Service
public class PaymentService {
    public void getPayment(String status, BigDecimal amount) {

        PaymentContext paymentContext = new PaymentContext(StatusName.valueOf(status),
                amount);

        paymentContext.payment();

    }
}
