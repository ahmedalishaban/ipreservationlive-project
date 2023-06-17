package com.ipreservationlive.tests.AdminTest.WorkOrders;

import com.ipreservationlive.tests.AdminTest.Dashboard.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_Invoice extends BaseTest {

    @Test
    //1. Invoice Tab Opens
    public void verifyInvoiceTap() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickInvoiceTap();
        Assert.assertTrue(workOrderPage.getCurrentUrl().contains("invoice"));
    }

    @Test
    //2. Scorecard Edit
    public void verifyScoreCardEdit() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickInvoiceTap();
        workOrderPage.addValuesToScoreCard();
        Assert.assertTrue(workOrderPage.clickSaveScoreCardValues().contains("Score Card Data Saved"));
    }
}
