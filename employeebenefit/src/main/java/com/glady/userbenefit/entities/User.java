package com.glady.userbenefit.entities;

import com.glady.userbenefit.benefit.Benefit;
import com.glady.userbenefit.benefit.GiftBenefit;
import com.glady.userbenefit.benefit.MealBenefit;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private String name;

    List<Benefit> benefits;

    private Long giftBalance;

    private Long mealBalance;

    public User(String name) {
        this.name = name;
        benefits = new ArrayList<>();
        this.giftBalance = 0L;
        this.mealBalance = 0L;
    }


    public void addBenefit(Benefit benefit, Company company, LocalDate date) {
        benefit.setDate(date);
        if (benefit instanceof GiftBenefit giftBenefit) {
            if (giftBenefit.isValidBenefit())
                this.giftBalance += giftBenefit.getAmount();
            company.setGiftBalance(company.getGiftBalance() - giftBenefit.getAmount());
        } else if (benefit instanceof MealBenefit mealBenefit) {
            if (mealBenefit.isValidBenefit())
                this.mealBalance += mealBenefit.getAmount();
            company.setMealBalance(company.getMealBalance() - mealBenefit.getAmount());
        }
        this.benefits.add(benefit);
    }

    public String calculateBalance() {
        this.mealBalance = 0l;
        this.giftBalance = 0l;
        this.benefits.stream().forEach(benefit -> {
            if (benefit instanceof GiftBenefit giftBenefit) {
                if (giftBenefit.isValidBenefit())
                    this.giftBalance += giftBenefit.getAmount();
            } else if (benefit instanceof MealBenefit mealBenefit) {
                if (mealBenefit.isValidBenefit())
                    this.mealBalance += mealBenefit.getAmount();
            }
        });
        return "Gift Balance: " + this.giftBalance + " Meal Balance: " + this.mealBalance;
    }


}

