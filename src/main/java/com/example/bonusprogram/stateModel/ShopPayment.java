package com.example.bonusprogram.stateModel;

// состояние - магазин
public class ShopPayment implements State {
    @Override
    public void doPayment(PaymentContext paymentContext) {
        // снятие средств
        paymentContext.getBankAccount().debitMoney(paymentContext.getPayAmount());

        paymentContext.setState(new Bank());

        paymentContext.doPaymentNext();
    }
}
