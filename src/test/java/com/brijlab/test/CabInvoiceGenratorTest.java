package com.brijlab.test;
import com.brijlab.service.CabInvoiceGeneratorMain;
import com.brijlab.service.InvoiceSummary;
import com.brijlab.service.NoumberOfRide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGenratorTest {

    // Main class object
    CabInvoiceGeneratorMain cabInvoiceGenerator = new CabInvoiceGeneratorMain();

    @Test
    public void welcomeMesage() {
        CabInvoiceGeneratorMain cabInvoiceGeneratorMain = new CabInvoiceGeneratorMain();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFareOfJourney() {
        int time = 10;
        double distance = 5.0;
        double fare = cabInvoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(60,fare,0.0);
    }
    @Test
    public void givenDistanceAndTime_WhenMnimumFare_ReturnTrue() {
        int time = 0;
        double distance = 0.1;
        double fare = cabInvoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }
    @Test
    public void givenDistanceAndTime_WhenMultipleRides_ShouldReturnInvoiceSummary() {
        NoumberOfRide rides[] = {new NoumberOfRide(2.0, 5),new NoumberOfRide(0.1, 1)};
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSumry = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary,expectedSumry);
    }
    @Test
    public void givenUserIdAndRides_WhenRideList_ShouldReturnInvoiceSummary() {
        String userId = "Vishal#abc";
        NoumberOfRide rides[] = {new NoumberOfRide(2.0, 5),new NoumberOfRide(0.1, 1)};
        cabInvoiceGenerator.addRides(userId,rides);
        InvoiceSummary summary = cabInvoiceGenerator.CabInvoiceGeneratorMain(userId);
        InvoiceSummary expectedSumry = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary,expectedSumry);
    }
    @Test
    public void givenCategories_WhenRideList_ShouldReturnInvoiceSummary() {
        String userId = "Vishal#abc";
        NoumberOfRide rides[] = {new NoumberOfRide(2.0, 5),new NoumberOfRide(0.1, 1)};
        NoumberOfRide rides1[] = {new NoumberOfRide(2.0, 5),new NoumberOfRide(0.1, 1)};
        cabInvoiceGenerator.addRides(userId,rides);
        InvoiceSummary summary = cabInvoiceGenerator.CabInvoiceGeneratorMain(userId,CabInvoiceGeneratorMain.RideCategories.PREMIUM_RIDE);
        InvoiceSummary expectedSumry = new InvoiceSummary(2,60.0);
        Assert.assertEquals(summary,expectedSumry);
    }
}
