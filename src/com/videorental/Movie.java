package com.videorental;

public class Movie extends MovieGrade {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;
    private int priceCode;
    private final MovieGrade movieGrade;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        this.movieGrade = setMovieGrade();
    }

    public MovieGrade setMovieGrade(){
        MovieGrade movieGrade;
        switch (priceCode) {
            case Movie.REGULAR:
                movieGrade = new RegularMovie();
                break;

            case Movie.NEW_RELEASE:
                movieGrade = new NewReleaseMovie();
                break;

            case Movie.CHILDRENS:
                movieGrade = new ChildrenMovie();
                break;
            default:
                movieGrade = new UnavailableMovie();
        }
        return movieGrade;
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

    @Override
    public double getCharge(int dayRented) {
        return movieGrade.getCharge(dayRented);
//        double chargeAmount = 0.0;
//        switch (priceCode) {
//            case Movie.REGULAR:
//                chargeAmount = regularMovieCharge(dayRented);
//                break;
//
//            case Movie.NEW_RELEASE:
//                chargeAmount = newReleaseMovieCharge(dayRented);
//                break;
//
//            case Movie.CHILDRENS:
//                chargeAmount = childrenMovieCharge(dayRented);
//                break;
//        }
//        return chargeAmount;
    }

    private double childrenMovieCharge(int dayRented) {
        double chargeAmount = 1.5;
        if (dayRented > 3)
            chargeAmount += (dayRented - 3) * 1.5;
        return chargeAmount;
    }

    private double newReleaseMovieCharge(int dayRented) {
        return dayRented * 3;
    }

    private double regularMovieCharge(int dayRented) {
        double chargeAmount = 2;
        if (dayRented > 2)
            chargeAmount += (dayRented - 2) * 1.5;
        return chargeAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (isNewRelease() && daysRented > 1) return 2;
        else return 1;
    }

    private boolean isNewRelease() {
        return priceCode == Movie.NEW_RELEASE;
    }

}