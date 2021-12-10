package com.videorental;

public class ChildrenMovie extends MovieGrade{
    @Override
    public double getCharge(int dayRented) {
        double chargeAmount = 1.5;
        if (dayRented > 3)
            chargeAmount += (dayRented - 3) * 1.5;
        return chargeAmount;
    }
}
