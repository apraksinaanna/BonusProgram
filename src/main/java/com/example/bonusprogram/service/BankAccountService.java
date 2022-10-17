package com.example.bonusprogram.service;

import com.example.bonusprogram.repository.BankAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// сервис для получения информации о банковском аккаунте клиента
@Service
public class BankAccountService {
    private BankAccount bankAccount;

    public BigDecimal getEMoney() {
        return bankAccount.getEMoney();
    }

    public BigDecimal getMoney() {
        return bankAccount.getMoney();
    }
}
