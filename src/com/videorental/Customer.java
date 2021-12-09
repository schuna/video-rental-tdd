package com.videorental;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String getRentalReport() {
        return generateRentalReport(getTotalCharge(), getTotalFrequentRenterPoints());
    }

    private String generateRentalReport(double totalAmount, int frequentRenterPoints) {
        Iterator<Rental> iterator = rentals.iterator();

        String result = "Rental Record for " + getName() + "\n";

        while (iterator.hasNext()) {
            double chargeAmount = 0;
            Rental rental = (Rental) iterator.next();
            // determine amounts for each line
            chargeAmount = getChargeAmount(rental);
            // show figures
            result += "\t" + String.valueOf(chargeAmount) + "(" + rental.getMovie().getTitle() + ")" + "\n";
        }


        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter pointers";
        return result;
    }

    private double getTotalCharge() {
        double chargeAmount = 0.0;
        for (Rental rental : rentals) {
            chargeAmount += getChargeAmount(rental);
        }
        return chargeAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += getFrequentRenterPoints(rental);
        }
        return frequentRenterPoints;
    }

    private int getFrequentRenterPoints(Rental rental) {
        int frequentRenterPoints = 1;
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private double getChargeAmount(Rental rental) {
        double chargeAmount = 0.0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                chargeAmount += 2;
                if (rental.getDaysRented() > 2)
                    chargeAmount += (rental.getDaysRented() - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                chargeAmount += rental.getDaysRented() * 3;
                break;

            case Movie.CHILDRENS:
                chargeAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    chargeAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return chargeAmount;
    }
}