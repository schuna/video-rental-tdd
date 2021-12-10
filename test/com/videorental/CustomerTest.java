package com.videorental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    int REGULAR_CODE = 0;
    int NEW_RELEASE_CODE = 1;
    int CHILDREN_CODE = 2;

    // 렌탈이 없을 때
    @Test
    public void 랜탈이_발생하지_않은_경우() {
        //given
        String expectedResult = "Rental Record for \n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers";

        Movie movie = new Movie("Ghost", 0);
        movie.setPriceCode(REGULAR_CODE);
        Rental rental = new Rental(movie, 10);
        Customer customer = new Customer("");
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(expectedResult, result);
    }

    // 일반 비디오 렌탈
    @Test
    public void 일반_비디오_렌탈의_2일_이하_경우() {
        //given
        String userName = "Schuna";
        String movieName = "Ghost";
        double price = 2.0;
        double amountOwed = 2.0;
        int frequentPoint = 1;
        int dayRental = 1;
        int priceCode = REGULAR_CODE;

        ExpectedResult expectedResult = new ExpectedResult(userName, price, movieName, amountOwed, frequentPoint);

        Customer customer = getCustomer(new RentalInfo(movieName, priceCode, dayRental, userName));
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(getExpectedResultString(expectedResult), result);
    }


    // 일반 비디오 렌탈
    @Test
    public void 일반_비디오_렌탈의_2일_이상_경우() {
        //given
        String userName = "Schuna";
        String movieName = "Ghost";
        double price = 14.0;
        double amountOwed = 14.0;
        int frequentPoint = 1;
        int dayRental = 10;

        ExpectedResult expectedResult = new ExpectedResult(userName, price, movieName, amountOwed, frequentPoint);

        Customer customer = getCustomer(new RentalInfo(movieName, REGULAR_CODE, dayRental, userName));
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(getExpectedResultString(expectedResult), result);
    }

    // 어린이 비디오 렌탈
    @Test
    public void 어린이_비디오_렌탈_3일_이하의_경우() {
        //given
        String userName = "Schuna";
        String movieName = "Aladdin";
        double price = 1.5;
        double amountOwed = 1.5;
        int frequentPoint = 1;
        int dayRental = 1;

        ExpectedResult expectedResult = new ExpectedResult(userName, price, movieName, amountOwed, frequentPoint);

        Customer customer = getCustomer(new RentalInfo(movieName, CHILDREN_CODE, dayRental, userName));
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(getExpectedResultString(expectedResult), result);
    }

    // 어린이 비디오 렌탈
    @Test
    public void 어린이_비디오_렌탈_4일_이상_경우() {
        //given
        String userName = "Schuna";
        String movieName = "Aladdin";
        double price = 12.0;
        double amountOwed = 12.0;
        int frequentPoint = 1;
        int dayRental = 10;

        ExpectedResult expectedResult = new ExpectedResult(userName, price, movieName, amountOwed, frequentPoint);

        Customer customer = getCustomer(new RentalInfo(movieName, CHILDREN_CODE, dayRental, userName));
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(getExpectedResultString(expectedResult), result);
    }

    // 신작 비디오 렌탈
    @Test
    public void 신작_비디오_렌탈의_경우() {
        //given
        String userName = "Schuna";
        String movieName = "Spider Man";
        double price = 30.0;
        double amountOwed = 30.0;
        int frequentPoint = 2;
        int dayRental = 10;

        ExpectedResult expectedResult = new ExpectedResult(userName, price, movieName, amountOwed, frequentPoint);

        Customer customer = getCustomer(new RentalInfo(movieName, NEW_RELEASE_CODE, dayRental, userName));
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(getExpectedResultString(expectedResult), result);
    }

    // 신작 비디오 렌탈
    @Test
    public void 신작_비디오_렌탈의_0일인_경우() {
        //given
        String userName = "Schuna";
        String movieName = "Spider Man";
        double price = 0.0;
        double amountOwed = 0.0;
        int frequentPoint = 1;
        int dayRental = 0;

        ExpectedResult expectedResult = new ExpectedResult(userName, price, movieName, amountOwed, frequentPoint);

        Customer customer = getCustomer(new RentalInfo(movieName, NEW_RELEASE_CODE, dayRental, userName));
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(getExpectedResultString(expectedResult), result);
    }

    // Price Code가 없는 경우
    @Test
    public void 프라이스_코드가_없는_경우() {
        //given
        String userName = "Schuna";
        String movieName = "Ghost";
        double price = 0.0;
        double amountOwed = 0.0;
        int frequentPoint = 1;
        int dayRental = 1;

        ExpectedResult expectedResult = new ExpectedResult(userName, price, movieName, amountOwed, frequentPoint);

        Customer customer = getCustomer(new RentalInfo(movieName, 4, dayRental, userName));
        //action
        String result = customer.getRentalReport();
        //asert
        assertEquals(getExpectedResultString(expectedResult), result);
    }

    // getPriceCode
    @Test
    public void 겟프라이스_코드_정상동작() {
        //given
        int priceCode = 2;
        Movie movie = new Movie("ABC", priceCode);
        //asert
        assertEquals(priceCode, movie.getPriceCode());
    }

    // getDaysRented
    @Test
    public void 겟데이즈_랜탈_코드_정상동작() {
        //given
        int daysRental = 2;
        int priceCode = 2;
        Movie movie = new Movie("ABC", priceCode);
        Rental rental = new Rental(movie, daysRental);

        //asert
        assertEquals(daysRental, rental.getDaysRented());
    }

    private Customer getCustomer(RentalInfo rentalInfo) {
        Movie movie = new Movie(rentalInfo.getMovieName(), rentalInfo.getPriceCode());
        Rental rental = new Rental(movie, rentalInfo.getDayRental());
        Customer customer = new Customer(rentalInfo.getUserName());
        customer.addRental(rental);
        return customer;
    }

    private String getExpectedResultString(ExpectedResult expectedResult1) {
        String expectedResult = "Rental Record for " + expectedResult1.getUserName() + "\n" +
                "\t" + expectedResult1.getPrice() + "(" + expectedResult1.getMovieName() + ")\n" +
                "Amount owed is " + expectedResult1.getAmountOwed() + "\n" +
                "You earned " + expectedResult1.getFrequentPoint() + " frequent renter pointers";
        return expectedResult;
    }

}
