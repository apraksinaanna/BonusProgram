package com.example.bonusprogram.stateModel;

import java.math.BigDecimal;

// состояние - онлайн
public class OnlinePayment implements State {
    @Override
    public void doPayment(PaymentContext paymentContext) {
        // снятие средсв
        paymentContext.getBankAccount().debitMoney(paymentContext.getPayAmount());

        // проверка на покупку менее 20 рублей
        if (paymentContext.getPayAmount().compareTo(new BigDecimal("20")) < 0) {
            paymentContext.setState(new Return());
            paymentContext.doPaymentNext();
        } else {
            paymentContext.setState(new Bank());
            paymentContext.doPaymentNext();
        }
        paymentContext.doPaymentNext();
    }
}
