package com.brijlab.test;
import com.brijlab.service.CabInvoiceGeneratorMain;
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
}
