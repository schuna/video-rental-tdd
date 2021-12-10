package com.videorental;

public class NewReleaseMovie extends MovieGrade{
    @Override
    public double getCharge(int dayRented) {
        return dayRented * 3;
    }
}
