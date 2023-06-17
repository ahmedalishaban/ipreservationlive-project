package com.ipreservationlive.tests.AdminTest.WorkOrders;

import com.ipreservationlive.tests.AdminTest.Dashboard.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_OfficeResults extends BaseTest {

    @Test
    //1. Office Results Tab opens
    public void verifyOfficeResultPageOpen() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickOfficeResults();
        Assert.assertTrue(workOrderPage.getCurrentUrl().contains("result"));
        Assert.assertTrue(workOrderPage.contentOfficeResults().isDisplayed());
    }

    @Test
    //2. Can view the property Information
    public void verifyPropertyInfoDisplayed() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickPropertyInfo();
        Assert.assertTrue(workOrderPage.getCurrentUrl().contains("property"));
        Assert.assertTrue(workOrderPage.contentPropertyInfo().isDisplayed());
    }

    @Test
    //3. Can view the client details?
    public void verifyViewClientDetails() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickOfficeResults();
        Assert.assertTrue(workOrderPage.clientDetails().isDisplayed(), "Clients Details not Displayed Successfully");
    }

    @Test
    //4. Forms
    public void verifyClickingOnForms() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickOfficeResults();
        Assert.assertTrue(workOrderPage.formsDisplayed().isDisplayed(), "Form Information not Displayed Successfully");
    }

    @Test
    //5. Bid/Invoice
    public void verifyBidInvoiceContent() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickOfficeResults();
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
        workOrderPage.clickOfficeResults();
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
        workOrderPage.clickOfficeResults();
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
        workOrderPage.clickOfficeResults();
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
        workOrderPage.clickOfficeResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.clickAddAppliance();
        workOrderPage.clickOnApplianceStatus();
        Assert.assertTrue(workOrderPage.clickSaveAppliance().contains("Appliance Saved"));

    }
    @Test
    //10. Office Document
    public void verifyAttachDocument() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickOfficeResults();
        workOrderPage.clickBidInvoice();
        workOrderPage.clickOfficeDocument();
        workOrderPage.clickAddOfficeDocumentBtn();
        workOrderPage.addOfficeDocument();
        Assert.assertTrue(workOrderPage.officeDocumentStatus().contains("Done"));
    }

    @Test
    //11. Add Violation
    public void verifyAddViolation() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickOfficeResults();
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
        workOrderPage.clickOfficeResults();
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
        workOrderPage.clickOfficeResults();
        workOrderPage.clickPropertyHistory();
        workOrderPage.clickBidHistory();
        workOrderPage.clickCompletionHistory();
        workOrderPage.clickDamageHistory();
        workOrderPage.clickContractorInvoiceHistory();
        workOrderPage.clickClientInvoiceHistory();
        //No Need To Assert
    }


}
