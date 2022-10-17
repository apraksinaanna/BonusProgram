package com.example.bonusprogram.stateModel;

import java.math.BigDecimal;

// состояние -  возврат
public class Return implements State {
    @Override
    public void doPayment(PaymentContext paymentContext) {

        // получаем 10%
        BigDecimal returnAmount = paymentContext.getPayAmount().multiply(new BigDecimal("0.10"));

        // начисляем
        paymentContext.getBankAccount().addMoney(returnAmount);

        // состояние - банк
        paymentContext.setState(new Bank());
    }
}
