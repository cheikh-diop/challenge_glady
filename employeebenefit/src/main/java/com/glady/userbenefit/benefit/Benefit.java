package com.glady.userbenefit.benefit;



import java.time.LocalDate;

/*
 * This class is the base class for all benefits
 */
public interface Benefit {

    /*
     * This method is used to check if the benefit is valid
     */
    public  boolean isValidBenefit();


    public  void setDate(LocalDate now);
}
