package com.at.internship.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CheckingAccountTest {

    private BankingAccount account;

    @BeforeEach
    public void beforeEach() {
        account = new CheckingAccount(new BigDecimal("100"), new BigDecimal("1"));
    }

    @Test
    public void testInitialBalance() {
        Assertions.assertEquals(new BigDecimal("100.00"), account.getBalance());
    }

    @Test
    public void testAddBalance() {
        account.addBalance(new BigDecimal("20"));
        Assertions.assertEquals(new BigDecimal("120.00"), account.getBalance());
    }

    @Test
    public void testSubtractBalance() {
        account.subtractBalance(new BigDecimal("20"));
        Assertions.assertEquals(new BigDecimal("79.00"), account.getBalance());
    }

}
