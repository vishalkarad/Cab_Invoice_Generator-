package com.brijlab.service;
public class CabInvoiceGeneratorMain {

    private RideRepository rideRepository;

    public static void main(String[] args) {
        System.out.println("*************** Welcome to Cab Invoice Generator ***************");
    }

    public enum RideCategories{
        NORMAL_RIDE,PREMIUM_RIDE;
    }
    RideCategories rideCategories;

    public CabInvoiceGeneratorMain(RideCategories premiumRide) {
        this.rideCategories = premiumRide;
    }
    public CabInvoiceGeneratorMain() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = CabInvoiceFactory.givenRideType(distance,time,rideCategories);
        return totalFare;
    }

    public InvoiceSummary calculateFare(NoumberOfRide[] rides) {
        double totalFare = 0;
        for (NoumberOfRide ride : rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userId, NoumberOfRide[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary CabInvoiceGeneratorMain(String userId,RideCategories premiumRide) {
        this.rideCategories = premiumRide;
        return this.calculateFare(rideRepository.getRides(userId));
    }
    public InvoiceSummary CabInvoiceGeneratorMain(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
