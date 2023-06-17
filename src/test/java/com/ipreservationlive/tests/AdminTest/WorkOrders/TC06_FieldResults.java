package com.ipreservationlive.tests.AdminTest.WorkOrders;

import com.ipreservationlive.tests.AdminTest.Dashboard.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_FieldResults extends BaseTest {

    @Test
    //1. Field Results Tab opens?
    public void verifyFieldResults() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        Assert.assertTrue(workOrderPage.getCurrentUrl().contains("field"));
    }

    @Test
    //2. Can view the property Information?
    public void verifyPropertyInfo() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickPropertyInfo();
        workOrderPage.clickPropertyInformation();
        Assert.assertTrue(workOrderPage.getCurrentUrl().contains("propertyInfo"));
    }

    @Test
    //3. Forms
    public void verifyClickingOnForms() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        Assert.assertTrue(workOrderPage.formsDisplayed().isDisplayed(), "Form Information not Displayed Successfully");
        Assert.assertTrue(workOrderPage.clickFieldResultsForm());
    }

    @Test
    //4. Bid/Invoice
    public void verifyBidInvoiceContent() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.verifyCreateBid();
        workOrderPage.verifyCreateCompletion();
        workOrderPage.verifyAddDamage();
        //No Need to Assert, there are included in the Work Order Page
    }

    @Test
    //6. Create Bid
    public void verifyCreateBid() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.verifyCreateBid();
        //Needs to add the Task Manually
        workOrderPage.addValuesToBid();
        Assert.assertTrue(workOrderPage.clickSaveBid().contains("Data Saved"));
    }

    @Test
    //7. Create Completion
    public void verifyCreatCompletion() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.verifyCreateCompletion();
        //Needs to add the Type Manually
        workOrderPage.addValuesToCompletion();
        Assert.assertTrue(workOrderPage.clickSaveCompletion().contains("Data Saved"));
    }


    @Test
    //8. Add Damage
    public void verifyAddDamage() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.verifyAddDamage();
        //Needs to add the Type Manually
        workOrderPage.addValuesToDamage();
        Assert.assertTrue(workOrderPage.clickSaveDamage().contains("Data Saved"));
    }

    @Test
    //9. Add Appliance
    public void verifyAddAppliance() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.clickAddAppliance();
        workOrderPage.clickOnApplianceStatus();
        Assert.assertTrue(workOrderPage.clickSaveAppliance().contains("Appliance Saved"));

    }

    @Test
    //11. Add Violation
    public void verifyAddViolation() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.clickAddViolation();
        workOrderPage.addValuesToViolation();
        workOrderPage.clickSaveViolation();
        Assert.assertTrue(workOrderPage.violationStatus().contains("Data Saved"));
    }

    @Test
    //12. Add Hazard
    public void verifyAddHazard() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.clickAddHazard();
        workOrderPage.addHazardValues();
        workOrderPage.clickSaveHazard();
        Assert.assertTrue(workOrderPage.hazardStatus().contains("Data Saved"));
    }

    @Test
    //13. Property History
    public void verifyPropertyHistory() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickFieldResults();
        workOrderPage.clickPropertyHistory();
        workOrderPage.clickBidHistory();
        workOrderPage.clickCompletionHistory();
        workOrderPage.clickDamageHistory();
        workOrderPage.clickContractorInvoiceHistory();
        workOrderPage.clickClientInvoiceHistory();
        //No Need To Assert
    }

}
