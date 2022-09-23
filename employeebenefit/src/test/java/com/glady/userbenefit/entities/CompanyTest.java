package com.glady.userbenefit.entities;

import com.glady.userbenefit.benefit.BenefitType;
import com.glady.userbenefit.exception.BalanceNotEnoughtException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompanyTest {

    private Company company;
    @Test
    @DisplayName("Company should have 900 $ on gift balance, user should have 100 $ on gift balance")
    void testDeposit() {
        // given
        company = new Company("Tesla");
        company.setGiftBalance(1000l);
        company.setMealBalance(1000l);
        User john = new User("User1");

        // when
        company.deposit(john, BenefitType.gift, 100l);

        // then
        assertEquals(900l, company.getGiftBalance());
        assertEquals(100l, john.getGiftBalance());
    }

    @Test
    @DisplayName("Company should have 950 $ on meal balance, user should have 50 $ on meal balance")
    void testDeposit1() {
        // given
        company = new Company("Apple");
        company.setGiftBalance(1000l);
        company.setMealBalance(1000l);

        User jessica = new User("User2");

        // when
        company.deposit(jessica, BenefitType.meal, 50);

        // then
        assertEquals(950l, company.getMealBalance());
        assertEquals(50, jessica.getMealBalance());
    }

    @Test
    @DisplayName("Company does not have enough balance to deposit")
    void companyDoesNotHaveEnoughtBalance() {
        // given
        company = new Company("Apple");
        company.setGiftBalance(100);
        company.setMealBalance(0);

        // when
        User jessica = new User("User2");
        User john = new User("User1");
        company.deposit(john, BenefitType.gift, 50);
        // then
        assertThrows(BalanceNotEnoughtException.class, () -> company.deposit(jessica, BenefitType.gift, 51));
    }

}