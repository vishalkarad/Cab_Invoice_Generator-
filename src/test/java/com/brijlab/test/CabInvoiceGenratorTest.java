package com.brijlab.test;
import com.brijlab.service.CabInvoiceGeneratorMain;
import com.brijlab.service.NoumberOfRide;
import org.junit.Assert;
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
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFare_ShouldReturnMinimumFareForJourney() {
        int time = 3;
        double distance = 0.1;
        NoumberOfRide rides[] = {new NoumberOfRide(2.0, 5),new NoumberOfRide(2.0, 5)};
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        Assert.assertEquals(25 , totalFare, 0);
    }
}
