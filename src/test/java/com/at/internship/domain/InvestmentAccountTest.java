package com.at.internship.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class InvestmentAccountTest {

    InvestmentAccount account;

    @BeforeEach
    public void beforeEach() {
        account = new InvestmentAccount(new BigDecimal("100"), new BigDecimal("0.02"));
    }

    @Test
    public void testAddYield() {
        account.addYield();
        Assertions.assertEquals(new BigDecimal("102.00"), account.getBalance());
    }

    @Test
    public void testAddBalance_NullAmount() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, this::executeAddBalance);
        Assertions.assertEquals("Adding amount is required", e.getMessage());
    }

    @Test
    public void testCreateAccount_interestRateTooHigh() {
        BigDecimal initialAmount = new BigDecimal("100");
        BigDecimal interestRate = new BigDecimal("1.1");

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new InvestmentAccount(initialAmount, interestRate);
        });
        Assertions.assertEquals(InvestmentAccount.ERR_MSG_INTEREST_RANGE, e.getMessage());
    }

    private void executeAddBalance() {
        account.addBalance(null);
    }
}
