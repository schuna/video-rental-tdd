package com.videorental;

public class RentalInfo {
    private final String movieName;
    private final int priceCode;
    private final int dayRental;
    private final String userName;

    public RentalInfo(String movieName, int priceCode, int dayRental, String userName) {
        this.movieName = movieName;
        this.priceCode = priceCode;
        this.dayRental = dayRental;
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public int getDayRental() {
        return dayRental;
    }

    public String getUserName() {
        return userName;
    }
}
