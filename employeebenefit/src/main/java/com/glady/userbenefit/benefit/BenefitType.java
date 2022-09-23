package com.glady.userbenefit.benefit;

public enum BenefitType {
    gift("gift"),
    meal("meal");

    private String value;

    BenefitType(String value) {
        this.value = value;
    }
}
