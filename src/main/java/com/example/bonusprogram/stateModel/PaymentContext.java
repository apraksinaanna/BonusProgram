package com.example.bonusprogram.stateModel;

import com.example.bonusprogram.repository.BankAccount;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

//класс объекты которого меняют свое поведение в зависимости от состояния объекта
@Setter
@Getter
public class PaymentContext {
    private State state;

    private BankAccount bankAccount = new BankAccount();

    private StatusName statusName;

    private BigDecimal payAmount;

    public PaymentContext(StatusName statusName, BigDecimal payAmount) {
        this.statusName = statusName;
        this.payAmount = payAmount;
    }

    // метод для обработки платежа
    public void payment() {
        // хватает ли денег на счёте клиента
        if (bankAccount.getMoney().compareTo(payAmount) < 0) {
            throw new RuntimeException("Нехвадка стредств");
        }

        // в зависимости от статуса выбираем состояние
        state = switch (statusName) {
            case SHOP -> new ShopPayment();
            case ONLINE -> new OnlinePayment();
        };
        // следующее состояние
        doPaymentNext();
    }

    public void doPaymentNext() {
        state.doPayment(this);
    }
}

