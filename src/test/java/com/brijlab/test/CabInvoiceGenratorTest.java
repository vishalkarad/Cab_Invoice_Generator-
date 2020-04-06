package com.brijlab.test;
import com.brijlab.service.CabInvoiceGeneratorMain;
import com.brijlab.service.InvoiceSummary;
import com.brijlab.service.NoumberOfRide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGenratorTest {

    // Main class object
    CabInvoiceGeneratorMain cabInvoiceGenerator = null;
    @Before
    public void settUp()throws Exception{
        cabInvoiceGenerator = new CabInvoiceGeneratorMain();
    }
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
}
