package com.ipreservationlive.tests.AdminTest.WorkOrders;

import com.ipreservationlive.tests.AdminTest.Dashboard.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;


public class TC03_WorkOrderQue extends BaseTest {

    @Test
    public void verifyWorkOrder() throws InterruptedException {

        //1. Can Navigate to Work Orders Tab?
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        Thread.sleep(3000);
        String actualUrl = workOrderPage.getWorkOrderUrl();
            //Assert work order page using work order tap
            softAssert.assertEquals(actualUrl,"https://testui.ipreservationlive.com/workorder",
                    "\n The work order not opened successfully\n ");

        //2. Can See Work orders?
        boolean actualView = workOrderPage.catchWorkOrderGrid().isDisplayed();
            ////Assert work order page view
            Assert.assertTrue(actualView,
                    "\n The user not able to see work order details successfully \n");

        //3. Can Filter work orders based upon Status
        workOrderPage.clickCreateFilterBtn();
    }







}
