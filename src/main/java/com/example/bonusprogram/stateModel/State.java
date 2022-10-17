package com.example.bonusprogram.stateModel;

//интерфейс с методом для перехода между состояниями
public interface State {
    public void doPayment(PaymentContext paymentContext);
}
