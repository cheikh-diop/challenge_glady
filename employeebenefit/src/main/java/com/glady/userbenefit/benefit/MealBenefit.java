package com.glady.userbenefit.benefit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealBenefit implements Benefit {

    private Long amount;

    private LocalDate date;


    /*
        * This method is used to check if the benefit is valid
     */
    @Override
    public boolean isValidBenefit() {
        // check if benefit is valid
        LocalDate expirationDate = LocalDate.of(this.date.getYear() + 1, 3, 1).minusDays(1);
        return LocalDate.now().isBefore(expirationDate);
    }
}

