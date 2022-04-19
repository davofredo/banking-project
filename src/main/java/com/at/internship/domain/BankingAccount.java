package com.at.internship.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BankingAccount {
    @Getter
    private BigDecimal balance;

    public BankingAccount(BigDecimal initialBalance) {
        if(initialBalance == null)
            throw new IllegalArgumentException("Initial balance is required");
        balance = initialBalance.setScale(2, RoundingMode.HALF_UP);
    }

    public void addBalance(BigDecimal amount) {
        if(amount == null)
            throw new IllegalArgumentException("Adding amount is required");
        if(amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Adding amount should be positive");
        balance = balance.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public void subtractBalance(BigDecimal amount) {
        if(amount == null)
            throw new IllegalArgumentException("Subtracting amount is required");
        if(amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Subtracting amount should be positive");
        if(amount.compareTo(balance) > 0)
            throw new RuntimeException("Insufficient balance");
        else
            balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public abstract String getAccountStatement();

}
