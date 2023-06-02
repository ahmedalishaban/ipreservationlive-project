package com.ipreservationlive.tests.AdminTest.Dashboard;

import com.ipreservationlive.pages.BasePage;
import com.ipreservationlive.pages.DashboardPage;
import com.ipreservationlive.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class TC02_Dashboard extends BaseTest{

    @Test(priority = 1)
    public void verifyNavigateIcon() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        dashboardPage.clickDashboardIcon();
        Assert.assertEquals(dashboardPage.getDashboardUrl(),"https://testui.ipreservationlive.com/dashboard",
                    "Dashboard page not opened successfully");
    }

//  Needs unique attributes to access pie Chart
    @Test(priority = 2)
    public void verifyStatus() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
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
        workOrderPage.checkUnAssignedOrders();
        String actualUnAssignedValue = dashboardPage.getQueValue();
        //Assigned Status & Que
        workOrderPage.checkAssignedOrders();
        String actualAssignedValue = dashboardPage.getQueValue();
        //Field Complete Que
        workOrderPage.checkFieldCompleteOrders();
        String actualFieldCompleteValue = dashboardPage.getQueValue();

            //Soft Assertions for Que Values
            softAssert.assertTrue(actualUnAssignedValue.contains(unAssignedValue),"UnAssigned Order Values Not match Que");
            softAssert.assertTrue(actualAssignedValue.contains(assignedValue),"Assigned Order Values Not match Que");
            softAssert.assertTrue(actualFieldCompleteValue.contains(fieldCompleteValue),"Field Complete Order Values Not match Que");

            //Assert All Values
            softAssert.assertAll();
    }


    @Test(priority = 3)
    public void verifyClient() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToWebsite();

        //Assert from Client Availability
        softAssert.assertTrue(dashboardPage.catchClientGrid().isDisplayed());
        softAssert.assertTrue(dashboardPage.catchClientChart().isDisplayed());

        String[] clientValues = dashboardPage.getClientValues();
        dashboardPage.printClientValues();

        dashboardPage.getWorkOrderPage();
        String[] clientQueValues = workOrderPage.getClientQueValues();

        for (int i = 0; i<clientQueValues.length;i++){
            softAssert.assertTrue(clientQueValues[i].contains(clientValues[i]),"Values Not Match Each Other");
        }
        softAssert.assertAll();
    }

}
