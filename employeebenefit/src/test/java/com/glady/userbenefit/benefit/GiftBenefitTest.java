package com.glady.userbenefit.benefit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GiftBenefitTest {

    GiftBenefit giftBenefit;


    @Test
    @DisplayName("Gift benefit should not be valid because it is expired")
    void testIsValidBenefit() {
        // given
        giftBenefit = new GiftBenefit(100l, LocalDate.of(2021, 1, 1));
        // then
        assertFalse(giftBenefit.isValidBenefit());
    }

    @Test
    @DisplayName("Gift benefit should be valid")
    void testIsValidBenefit1() {
        // given
        giftBenefit = new GiftBenefit(100l, LocalDate.of(Year.now().getValue() - 1, 12, 1));
        // then
        assertTrue(giftBenefit.isValidBenefit());
    }
}