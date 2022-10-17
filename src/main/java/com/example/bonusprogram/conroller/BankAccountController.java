package com.example.bonusprogram.conroller;

import com.example.bonusprogram.service.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

// REST контроллеры для получение информации о банковском аккаунте клиента
@RestController
@RequestMapping("/api")
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    // получение информации о бонусах
    @GetMapping("/bankAccountOfEMoney")
    public BigDecimal getEMoney() {
        return bankAccountService.getEMoney();
    }

    // получение информации о стредствах
    @GetMapping("/money")
    public BigDecimal getMoney() {
        return bankAccountService.getMoney();
    }
}
