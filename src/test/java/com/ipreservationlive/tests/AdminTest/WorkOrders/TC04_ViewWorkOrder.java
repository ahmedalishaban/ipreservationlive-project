package com.ipreservationlive.tests.AdminTest.WorkOrders;

import com.ipreservationlive.tests.AdminTest.Dashboard.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class TC04_ViewWorkOrder extends BaseTest {

    @Test
    public void verifyViewOpensWorkOrderToInstructionTab() throws InterruptedException {
        //1. View Opens Work Order to instruction Tab
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        Assert.assertTrue(workOrderPage.getCurrentUrl().contains("instruction"),"The instructions tap not opened successfully");
        Assert.assertEquals(workOrderPage.getInstructionsTap(),"Instructions");  ;
    }

    //Blocked
//    @Test
//    public void verifyEditComment() throws InterruptedException {
//        //2. Can Edit Comments
//        loginPage.loginToWebsite();
//        dashboardPage.getWorkOrderPage();
//        workOrderPage.clickClientWorkOrderEyeIcon();
//        workOrderPage.setComment("Hello");
//        workOrderPage.clickSaveCommentBtn();
//    }

    @Test
    //3. Can add completion task
    public void verifyAddCompletionTask() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.selectWorkProduct();
        workOrderPage.clickActionsBtn();
        workOrderPage.clickAddTask();
        workOrderPage.selectCompletionTask();
        workOrderPage.setCompletionTaskValues();
        workOrderPage.clickSaveTask();
        Assert.assertTrue(workOrderPage.getMsgTask().contains("Record has been Updated"));
    }

    @Test
    //4. Can Add Bid Task
    public void verifyAddBidTask() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.selectWorkProduct();
        workOrderPage.clickActionsBtn();
        workOrderPage.clickAddTask();
        workOrderPage.selectBidTask();
        workOrderPage.setBidTaskValues();
        workOrderPage.clickSaveTask();
        Assert.assertTrue(workOrderPage.getMsgTask().contains("Record has been Updated"));
    }

    @Test
    //5. Can Add Bid Task
    public void verifyAddInspectionTask() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.selectWorkProduct();
        workOrderPage.clickActionsBtn();
        workOrderPage.clickAddTask();
        workOrderPage.selectInspectionTask();
        workOrderPage.setInspectionTaskValues();
        workOrderPage.clickSaveTask();
        Assert.assertTrue(workOrderPage.getMsgTask().contains("Record has been Updated"));
    }

    @Test
    //6. Can add Custom Completion Task
    public void verifyAddCustomCompletionTask(){

    }

    @Test
    //7. Can add Custom Bid Task
    public void verifyAddCustomBidTask(){

    }

    @Test
    //8. Can add Custom Inspection Task
    public void verifyAddCustomInspectionTask(){

    }

    @Test
    //9. Can Add Instructions
    public void verifyAddInstructions() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.selectWorkProduct();
        workOrderPage.clickActionsBtn();
        workOrderPage.clickAddInstructions();
        workOrderPage.addInstructionsValues();
        workOrderPage.clickSaveInstructions();
        Assert.assertTrue(workOrderPage.getMsgTask().contains("Record has been Updated"));
    }

    @Test
    //10. Can Add Documents to Work order
    public void verifyAddDocument() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.selectWorkProduct();
        workOrderPage.clickActionsBtn();
        workOrderPage.clickAddDocument();
        workOrderPage.addDocument();
        Assert.assertTrue(workOrderPage.documentStatus().contains("Done"),"Failed to Upload The File Successfully");
    }

    @Test
    //11. Can View Access Log
    public void verifyViewAccessLog() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        workOrderPage.clickAccessLog();
        String dateRegex = "\\d{2}/\\d{2}/\\d{4}";
        String actualDate = workOrderPage.getDateText();
        boolean isDateValid = Pattern.matches(dateRegex, actualDate);
        Assert.assertTrue(isDateValid, "Date assertion failed");
        Assert.assertTrue(workOrderPage.userViewFileLogDisplayed());
    }

    @Test
    //12. Can View Import File Log
    public void verifyViewImportFileLog() throws InterruptedException {
        loginPage.loginToWebsite();
        dashboardPage.getWorkOrderPage();
        workOrderPage.clickClientWorkOrderEyeIcon();
        Assert.assertTrue(workOrderPage.importFilesLogEnabled());
    }
}
