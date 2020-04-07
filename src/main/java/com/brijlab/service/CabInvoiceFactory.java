package com.brijlab.service;

public class CabInvoiceFactory {


    public static double givenRideType(double distance, int time, CabInvoiceGeneratorMain.RideCategories rideCategories){
        RideCategory rideCategory = new RideCategory();
         if (rideCategories == null || rideCategories.equals(CabInvoiceGeneratorMain.RideCategories.NORMAL_RIDE))
            return rideCategory.normalRide(distance,time);
        else if (rideCategories.equals(CabInvoiceGeneratorMain.RideCategories.PREMIUM_RIDE))
            return rideCategory.premiumRide(distance,time);
        else
            return 0;
    }
}
