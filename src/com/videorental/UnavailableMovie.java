package com.videorental;

public class UnavailableMovie extends MovieGrade {
    @Override
    public double getCharge(int dayRented) {
        return 0;
    }
}
