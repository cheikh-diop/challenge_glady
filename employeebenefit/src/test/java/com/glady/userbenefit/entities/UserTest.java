package com.glady.userbenefit.entities;

import com.glady.userbenefit.benefit.GiftBenefit;
import com.glady.userbenefit.benefit.MealBenefit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;

    @Test
    @DisplayName(" User should have 100 $ on gift balance")
    void testAddBenefit() {
        // given
        user = new User("User1");
        Company company = new Company("Tesla");
        GiftBenefit benefit = new GiftBenefit();
        benefit.setAmount(100l);

        // when
        user.addBenefit(benefit, company, LocalDate.now());

        // then
        assertEquals(100, user.getGiftBalance());
    }

    @Test
    @DisplayName(" User should have 100 $ on meal balance")
    void testAddBenefit1() {
        // given
        user = new User("User1");
        Company company = new Company("Tesla");
        MealBenefit benefit = new MealBenefit();
        benefit.setAmount(100l);
        // when
        user.addBenefit(benefit, company, LocalDate.now());

        // then
        assertEquals(100, user.getMealBalance() );
    }

    @Test
    @DisplayName(" User should not have Meal benefit because it is expired")
    void testAddBenefit2() {
        user = new User("User1");
        Company company = new Company("Tesla");
        MealBenefit benefit = new MealBenefit();
        benefit.setAmount(100l);
        user.addBenefit(benefit, company, LocalDate.of(2020, 1, 1));

        // then
        assertEquals(0, user.getMealBalance());
    }

    @Test
    @DisplayName("User should not have any benefit because it is expired")
    void testCalculateBalance() {
        //  given
        user = new User("User1");
        Company company = new Company("Tesla");
        // when
        MealBenefit benefit = new MealBenefit();
        benefit.setAmount(500l);
        user.addBenefit(benefit, company, LocalDate.of(2019, 1, 1));

        // then
        assertEquals( "Gift Balance: 0 Meal Balance: 0", user.calculateBalance());
    }

    @Test
    @DisplayName("User should have meal on balance because benefit is valid")
    void testCalculateBalance1() {
        user = new User("User1");
        Company company = new Company("Tesla");
        MealBenefit benefit = new MealBenefit();
        benefit.setAmount(500l);
        user.addBenefit(benefit, company, LocalDate.of(2022, 1, 1));

        // then
        assertEquals("Gift Balance: 0 Meal Balance: 500", user.calculateBalance());

    }

}