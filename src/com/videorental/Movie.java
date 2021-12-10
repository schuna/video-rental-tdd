package com.videorental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int dayRented) {
        double chargeAmount = 0.0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                chargeAmount += 2;
                if (dayRented > 2)
                    chargeAmount += (dayRented - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                chargeAmount += dayRented * 3;
                break;

            case Movie.CHILDRENS:
                chargeAmount += 1.5;
                if (dayRented > 3)
                    chargeAmount += (dayRented - 3) * 1.5;
                break;
        }
        return chargeAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (isNewRelease() && daysRented > 1) return 2;
        else return 1;
    }

    private boolean isNewRelease() {
        return getPriceCode() == Movie.NEW_RELEASE;
    }

    ;
}