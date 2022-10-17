package com.example.bonusprogram.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.math.BigDecimal;

// банковский аккаунт клиента
@Setter
@Getter
@ToString
public class BankAccount {
    // данные по условию
    private BigDecimal money;
    private BigDecimal eMoney;

    public BankAccount() {
        this.money = new BigDecimal(5000);
        this.eMoney = new BigDecimal(0);
    }

    // зачисление бонусов
    public void addEMoney(BigDecimal amount) {
        eMoney = eMoney.add(amount);
    }

    // списание денег
    public void debitMoney(BigDecimal amount) {
        money = money.subtract(amount);
    }

    // зачисление денег
    public void addMoney(BigDecimal amount) {
        money = money.add(amount);
    }

}
