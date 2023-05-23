package com.ipreservationlive.tests.AdminTest.Dashboard;

import com.ipreservationlive.pages.BasePage;
import com.ipreservationlive.pages.DashboardPage;
import com.ipreservationlive.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class TC02_Dashboard extends BaseTest{

    @Test
    public void verifyNavigateIcon() throws InterruptedException {
        loginPage.loginToWebsite();
        basePage.navigateTo("https://testui.ipreservationlive.com/workorder");
        dashboardPage.clickDashboardIcon();
        Assert.assertEquals(dashboardPage.getDashboardUrl(),"https://testui.ipreservationlive.com/dashboard",
                    "Dashboard page not opened successfully");
    }

//  Needs unique attributes to access pie Chart
    @Test
    public void verifyStatus() throws InterruptedException {
        loginPage.loginToWebsite();
        //Hard Assertions GRIDs
        Assert.assertTrue(dashboardPage.catchStatusGrid().isDisplayed(),"Status Grid Not Displayed");
        Assert.assertTrue(dashboardPage.catchPieChartGrid().isDisplayed(),"Pie Chart Grid Not Displayed");
        //Get Values at Dashboard
        String unAssignedValue = dashboardPage.getUnAssignedValue();
        String assignedValue = dashboardPage.getAssignedValue();
        String fieldCompleteValue = dashboardPage.getFieldCompleteValue();
        //Navigate to workOrder Page to get Que Values
        dashboardPage.getWorkOrderPage();
        //UnAssigned Status & Que
        dashboardPage.checkUnAssignedOrders();
        String actualUnAssignedValue = dashboardPage.getQueValue();
        //Assigned Status & Que
        dashboardPage.checkAssignedOrders();
        String actualAssignedValue = dashboardPage.getQueValue();
        //Field Complete Que
        dashboardPage.checkFieldCompleteOrders();
        String actualFieldCompleteValue = dashboardPage.getQueValue();

            //Soft Assertions for Que Values
            softAssert.assertTrue(actualUnAssignedValue.contains(unAssignedValue),"UnAssigned Order Values Not match Que");
            softAssert.assertTrue(actualAssignedValue.contains(assignedValue),"Assigned Order Values Not match Que");
            softAssert.assertTrue(actualFieldCompleteValue.contains(fieldCompleteValue),"Field Complete Order Values Not match Que");

            //Assert All Values
            softAssert.assertAll();
    }


    @Test
    public void verifyClient() throws InterruptedException {
        loginPage.loginToWebsite();
        // Assert from Client Availability

        softAssert.assertTrue(dashboardPage.catchClientGrid().isDisplayed());
        softAssert.assertTrue(dashboardPage.catchClientChart().isDisplayed());
        softAssert.assertAll();

        dashboardPage.getClientValues();
        dashboardPage.printClientValues();
    }

}
