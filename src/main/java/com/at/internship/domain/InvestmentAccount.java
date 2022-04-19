package com.at.internship.domain;

import java.math.BigDecimal;

public class InvestmentAccount extends BankingAccount {
    public static final String ERR_MSG_INTEREST_RANGE = "Interest rate should be in the range between 0.00 and 0.20";

    private BigDecimal interestRate;

    public InvestmentAccount(BigDecimal initialBalance, BigDecimal interestRate) {
        super(initialBalance);
        if(interestRate == null)
            throw new IllegalArgumentException("Interest rate is required");
        if(BigDecimal.ZERO.compareTo(interestRate) > 0 || new BigDecimal("0.20").compareTo(interestRate) < 0)
            throw new  IllegalArgumentException(ERR_MSG_INTEREST_RANGE);
        this.interestRate = interestRate;
    }

    public void addYield() {
        addBalance(getBalance().multiply(interestRate));
    }

    @Override
    public String getAccountStatement() {
        return String.format("" +
                "Checking Account\n" +
                "Balance: %s\n" +
                "Interest rate: %s\n", getBalance(), interestRate);
    }

}
