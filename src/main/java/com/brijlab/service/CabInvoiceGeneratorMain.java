package com.brijlab.service;
public class CabInvoiceGeneratorMain {

    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;
    public static void main(String[] args) {
        System.out.println("*************** Welcome to Cab Invoice Generator ***************");
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        if (totalFare <= MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceSummary calculateFare(NoumberOfRide[] rides) {
        double totalFare = 0;
        for (NoumberOfRide ride : rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
}
