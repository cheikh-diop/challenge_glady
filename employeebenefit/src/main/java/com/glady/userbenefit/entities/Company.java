package com.glady.userbenefit.entities;

import com.glady.userbenefit.benefit.Benefit;
import com.glady.userbenefit.benefit.BenefitType;
import com.glady.userbenefit.benefit.GiftBenefit;
import com.glady.userbenefit.benefit.MealBenefit;
import com.glady.userbenefit.exception.BalanceNotEnoughtException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Company {

    private String name;

    private long giftBalance;

    private long mealBalance;

    public Company(String name) {
        this.name = name;
    }

    public void deposit(User user, BenefitType benefitType, long amount) {
        Benefit benefit = benefitFactory(benefitType, amount);
        // deposit amount to user's benefit
        if (canDeposit(benefit)) {
            user.addBenefit(benefit, this, LocalDate.now());
        } else {
            throw new BalanceNotEnoughtException("balance not enough");
        }
    }

    private boolean canDeposit(Benefit benefit) {
        var canDeposite = false;
        if (benefit instanceof GiftBenefit giftBenefit) {
            canDeposite = this.giftBalance >= giftBenefit.getAmount();
        } else if (benefit instanceof MealBenefit mealBenefit) {
            canDeposite = this.mealBalance >= mealBenefit.getAmount();
        }
        return canDeposite;
    }

    /*
        Factory method to create benefit
     */
    private Benefit benefitFactory(BenefitType benefitType, long amount) {
        Benefit benefit = null;
        if (benefitType.equals(BenefitType.gift)) {
            benefit = GiftBenefit.builder().amount(amount).build();
        } else if (benefitType.equals(BenefitType.meal)) {
            benefit = MealBenefit.builder().amount(amount).build();
        }
        return benefit;
    }

}
