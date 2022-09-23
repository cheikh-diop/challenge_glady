package com.glady.userbenefit;

import com.glady.userbenefit.benefit.BenefitType;
import com.glady.userbenefit.entities.Company;
import com.glady.userbenefit.entities.User;


public class EmployeeBenefitApplication {

    public static void main(String[] args) {

        Company company = new Company("Glady");

        company.setGiftBalance(300);
        company.setMealBalance(200);

        User john = new User("User1");
        User jane = new User("User2");


        company.deposit(john, BenefitType.meal, 50);

        company.deposit(john, BenefitType.gift, 100);

        company.deposit(john, BenefitType.gift, 50);


        company.deposit(jane, BenefitType.gift, 150);

        System.out.println(john.calculateBalance());

        System.out.println(jane.calculateBalance());


    }

}