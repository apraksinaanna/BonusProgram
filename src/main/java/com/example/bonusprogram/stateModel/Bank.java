package com.example.bonusprogram.stateModel;

import java.math.BigDecimal;

// состояние - банк
public class Bank implements State {
    @Override
    public void doPayment(PaymentContext paymentContext) {
        // определяем процент
        BigDecimal EMoneyPercent = getEMoneyPercent(paymentContext.getPayAmount(),
                paymentContext.getStatusName());
        // вычисляем бонусы
        BigDecimal EMoney = paymentContext.getPayAmount().multiply(EMoneyPercent);
        // зачисляем на счёт
        paymentContext.getBankAccount().addEMoney(EMoney);

    }

    // получаем процент в зависимости от состояния и платежа
    private BigDecimal getEMoneyPercent(BigDecimal payAmount, StatusName statusName) {
        return switch (statusName) {
            case SHOP -> new BigDecimal("0.10");
            case ONLINE -> new BigDecimal(payAmount.compareTo(new BigDecimal(300)) > 0 ? "0.30" : "0.17");
        };
    }
}
