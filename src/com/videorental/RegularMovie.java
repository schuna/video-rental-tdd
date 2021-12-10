package com.videorental;

public class RegularMovie extends MovieGrade {
    @Override
    public double getCharge(int dayRented) {
        double chargeAmount = 2;
        if (dayRented > 2)
            chargeAmount += (dayRented - 2) * 1.5;
        return chargeAmount;
    }
}
