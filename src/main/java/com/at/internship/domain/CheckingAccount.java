package com.at.internship.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckingAccount extends BankingAccount {
    @Getter @Setter
    private BigDecimal withdrawalFee;

    public CheckingAccount(BigDecimal initialBalance, BigDecimal withdrawalFee) {
        super(initialBalance);
        if(withdrawalFee == null)
            throw new IllegalArgumentException("Withdrawal fee is required");
        if(withdrawalFee.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Withdrawal fee should be greater than 0 or equal");
        this.withdrawalFee = withdrawalFee.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void subtractBalance(BigDecimal amount) {
        if(amount == null)
            throw new IllegalArgumentException("Subtract amount is required");
        if(amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Withdrawal fee should be greater than 0 or equal");
        BigDecimal totalAmount = amount.add(withdrawalFee);
        super.subtractBalance(totalAmount);
    }

    @Override
    public String getAccountStatement() {
        return String.format("" +
                "Checking Account\n" +
                "Balance: %s\n" +
                "Withdrawal Fee: %s\n", getBalance(), withdrawalFee);
    }

}
