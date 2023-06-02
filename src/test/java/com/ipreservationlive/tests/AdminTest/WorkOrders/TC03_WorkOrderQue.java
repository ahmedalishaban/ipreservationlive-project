package com.ipreservationlive.tests.AdminTest.WorkOrders;

import com.ipreservationlive.pages.WorkOrderPage;
import com.ipreservationlive.tests.AdminTest.Dashboard.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class TC03_WorkOrderQue extends BaseTest {

    @Test(priority = 1)
    public void verifyNavigateWorkOrderTap() throws InterruptedException {
            //<===================================================>//
            SoftAssert softAssert = new SoftAssert();
            //1. Can Navigate to Work Orders Tab?
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            String actualUrl = workOrderPage.getWorkOrderUrl();
            //Assert work order page using work order tap
            softAssert.assertEquals(actualUrl, "https://testui.ipreservationlive.com/workorder",
                    "\n The work order not opened successfully\n ");
            softAssert.assertAll();
    }

    @Test(priority = 2)
        public void verifyViewWorkOrder() throws InterruptedException {

            //<===================================================>//
            //2. Can See Work orders?
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            boolean actualView = workOrderPage.catchWorkOrderGrid().isDisplayed();
            ////Assert work order page view
            Assert.assertTrue(actualView,
                    "\n The user not able to see work order details successfully \n");
    }

    @Test(priority = 3)
            public void verifyStatusFilter() throws InterruptedException {
            //<===================================================>//
            //3. Can Filter work orders based upon Status CheckBoxes
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            workOrderPage.clickResetBtn();
            workOrderPage.checkUnAssignedOrders();
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Unassigned"), "UnAssigned CheckBox not Working Properly ");
            workOrderPage.checkAssignedOrders();
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Assigned"),"Assigned CheckBox not Working Properly");
            workOrderPage.checkFieldCompleteOrders();
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Field Complete"),"Field Complete CheckBox not Working Properly");
            workOrderPage.checkOfficeApprovedOrders();
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Office Approved"),"Office Approved CheckBox not Working Properly");
            workOrderPage.clickResetBtn();

            //3. Can Filter work orders based upon Status TextBoxes
            workOrderPage.setStatus("Unassigned");
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Unassigned"),"Can not sort using Status: UnAssigned");
            workOrderPage.clearStatus();
            workOrderPage.setStatus("Assigned");
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Assigned"),"Can not sort using Status: Assigned");
            workOrderPage.clearStatus();
            workOrderPage.setStatus("Field Complete");
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Field Complete"),"Can not sort using Status: Field Complete");
            workOrderPage.clearStatus();
            workOrderPage.setStatus("Office Approved");
            softAssert.assertTrue(workOrderPage.getStatusText().contains("Office Approved"),"Can not sort using Status: Office Approved");
            workOrderPage.clearStatus();

            softAssert.assertAll();
    }

    @Test(priority = 4)
            public void verifyFilterWorkOrderByColumns() throws InterruptedException {
            //<===================================================>//
            //4. Can Filter Work orders in Columns
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            workOrderPage.clickResetBtn();
            workOrderPage.clickColumnBtn();
            Assert.assertTrue(workOrderPage.getColumnsBox().isDisplayed());
            workOrderPage.changeColumns();
            softAssert.assertTrue(workOrderPage.getAlertMessage().contains("Column record has been updated"), "Columns Not Updated and Not Working Properly");
            workOrderPage.closeColumnsBtn();
            softAssert.assertAll();
    }

    @Test(priority = 5)
            public void verifyCreatingFilter() throws InterruptedException {
            //<===================================================>//
            //The filter created manually because access issue
            //6. Can Create Filters
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            workOrderPage.clickCreateFilterBtn();
            workOrderPage.createFilter();
            softAssert.assertTrue(workOrderPage.getFilterCreationMessage().contains("Filter saved"), "Filter Doesn't Created Successfully");
            softAssert.assertAll();
    }

    @Test(priority = 6)
            public void verifyLoadFilter() throws InterruptedException {
            //<===================================================>//
            //7. Can Load Filters
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            workOrderPage.clickLoadFilterBtn();
            workOrderPage.clickLoadOptionDropDown();
            workOrderPage.getFilterName();
            workOrderPage.clickLoadBtn();
            softAssert.assertTrue(workOrderPage.getAppliedFilterName().contains(workOrderPage.getFilterName()), "Filter Name doesn't match Created Filter Name");
            softAssert.assertAll();
    }
    @Test(priority = 7)
            public void verifySortColumns() throws InterruptedException {
            //<===================================================>//
            //8. Can Sort Columns
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            String[] actualResults = new String[2];
            actualResults[0] = workOrderPage.sortByClientName();
            softAssert.assertEquals(actualResults[0], "ascending");
            actualResults[1] = workOrderPage.sortByClientName();
            softAssert.assertEquals(actualResults[1], "descending");
            softAssert.assertAll();
    }

    @Test(priority = 8)
            public void verifyChangeItemsPerPage() throws InterruptedException {
            //<===================================================>//
            //9. Can Change items Per page
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            workOrderPage.clickResetBtn();
            boolean changeItemsAvailability = workOrderPage.changeItemsPerPage(2);
            softAssert.assertTrue(changeItemsAvailability, "Change Items Per Page not working properly");
            softAssert.assertAll();
    }

    @Test(priority = 9)
            public void verifyViewPastWorkOrders() throws InterruptedException {
            //<===================================================>//
            //10. Can View past work orders
            //15. History popup works
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            softAssert.assertTrue(workOrderPage.checkHistoryDetailsGridDisplayed());
            for (int i = 0 ; i<5 ; i++) {
                softAssert.assertTrue(WorkOrderPage.actualHistoryQueNumber[i].contains(WorkOrderPage.historyItemsNumber[i]), "History Items Not Match History Que Match");
            }
            softAssert.assertAll();
    }

    @Test(priority = 10)
            public void verifyPerformActions() throws InterruptedException {
            // <===================================================>//
            //11. Can Perform Actions.
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            workOrderPage.selectWorkProduct();
            workOrderPage.clickActionsBtn();
            softAssert.assertTrue(workOrderPage.actionsOptionsAvailability());
            softAssert.assertAll();
    }

    @Test(priority = 11)
            public void verifyInstructionsTaskCommentPopUp() throws InterruptedException {
            //<===================================================>//
            //12. Can View Instructions/Task/Comments in pop up
            //13. Can Edit Instructions/Task/Comments in pop up
            SoftAssert softAssert = new SoftAssert();
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            softAssert.assertTrue(workOrderPage.viewCommentsOrders("Hello World"), "The Comments view and Details not Appear Successfully");
            softAssert.assertTrue(workOrderPage.viewInstructionsOrders(), "The Instructions view and Details not Appear Successfully");
            softAssert.assertTrue(workOrderPage.viewTasksOrders(2), "The Tasks view and Details not Appear Successfully");
            softAssert.assertAll();
    }

    @Test(priority = 12)
            public void verifyMessagePopUp() throws InterruptedException {
            //14. Message Popup works
            loginPage.loginToWebsite();
            dashboardPage.getWorkOrderPage();
            Assert.assertTrue(workOrderPage.clickMessagePopUp());
    }



}
