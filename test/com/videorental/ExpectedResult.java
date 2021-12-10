package com.videorental;

public class ExpectedResult {
    private final String userName;
    private final double price;
    private final String movieName;
    private final double amountOwed;
    private final int frequentPoint;

    public ExpectedResult(String userName, double price, String movieName, double amountOwed, int frequentPoint) {
        this.userName = userName;
        this.price = price;
        this.movieName = movieName;
        this.amountOwed = amountOwed;
        this.frequentPoint = frequentPoint;
    }

    public String getUserName() {
        return userName;
    }

    public double getPrice() {
        return price;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public int getFrequentPoint() {
        return frequentPoint;
    }
}
