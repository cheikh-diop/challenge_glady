package com.glady.userbenefit.benefit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftBenefit implements Benefit {

    protected Long amount;

    protected LocalDate date;



    @Override
    public boolean isValidBenefit() {
          // check if benefit is valid
            return  ChronoUnit.DAYS.between(this.date, LocalDate.now()) <= 364;
    }
}
