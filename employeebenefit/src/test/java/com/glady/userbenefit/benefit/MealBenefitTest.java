package com.glady.userbenefit.benefit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;


class MealBenefitTest {

    MealBenefit mealBenefit;

    @Test
    @DisplayName("Meal benefit should not be valid")
    void testIsValidBenefit() {
        // when
        mealBenefit = new MealBenefit(100l, LocalDate.of(2020, 1, 1));

        // then
        assertFalse(mealBenefit.isValidBenefit());
    }

    @Test
    @DisplayName("Meal benefit should not be valid")
    void testIsValidBenefit1() {
        // when
        mealBenefit = new MealBenefit(100l, LocalDate.of(Year.now().getValue() - 1, 12, 1));

        // then
        assertFalse(mealBenefit.isValidBenefit());
    }



    @Test
    @DisplayName("Meal benefit should be valid")
    void testIsValidBenefit2() {
        // when
        mealBenefit = new MealBenefit(100l, LocalDate.of(Year.now().getValue() , 12, 1));

        // then
        assertTrue(mealBenefit.isValidBenefit());
    }
}