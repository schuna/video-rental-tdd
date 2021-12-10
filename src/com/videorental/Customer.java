package com.videorental;

import java.util.ArrayList;
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
        return generateRentalReport();
    }

    private String generateRentalReport() {
        String result = rentalReportHeader();
        for (Rental rental : rentals) {
            result += rentalReportBody(rental);
        }
        result += rentalReportTail();        
        return result;
    }

    private String rentalReportBody(Rental rental) {
        return "\t" + rental.getChargeAmount() + "(" + rental.getMovie().getTitle() + ")" + "\n";
    }

    private String rentalReportTail() {
        String result = "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter pointers";
        return result;
    }

    private String rentalReportHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private double getTotalCharge() {
        double chargeAmount = 0.0;
        for (Rental rental : rentals) {
            chargeAmount += rental.getChargeAmount();
        }
        return chargeAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}