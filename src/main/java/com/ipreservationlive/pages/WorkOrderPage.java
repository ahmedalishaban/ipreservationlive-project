package com.ipreservationlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WorkOrderPage extends BasePage {

    private final By workOrdersGrid = By.xpath("(//div[@class=\"col-12\"])[2]");
    private final By getQueValue = By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted']");
    private final By filterBtn = By.xpath("//li[contains(text(),'Create Filters')]");
    private final By saveFilterBtn = By.xpath("//button[contains(text(),'Save')]");
    private final By creationFilterMessage = By.xpath("//div[@class=\"modal-content\"]//div[@class='text-center']/span");
    private final By closeCreatedMessageBtn = By.xpath("//div[@class=\"text-center\"]//button[@type=\"button\"]");
    private final By viewDetailsBtn = By.xpath("(//img[@class='mr-2 cursor-pinter message'])[1]");
    private final By commentsView = By.id("comnts");
    private final By instructionsView = By.id("instructions");
    private final By viewInstructionsBtn = By.xpath("(//a[@id='impo-tab'])[1]");
    private final By viewTasksBtn = By.id("log-tab");
    private final By tasksView = By.id("tasks");
    // CheckBoxes Access to get the actual values
    private final By unAssignedCheckBox = By.xpath("(//input[@type='checkbox'])[1]");
    private final By assignedCheckBox = By.xpath("(//input[@type='checkbox'])[2]");
    private final By fieldCompleteCheckBox = By.xpath("(//input[@type='checkbox'])[3]");
    private final By officeApprovedCheckBox = By.xpath("(//input[@type='checkbox'])[4]");
    private final By clientTextBox = By.xpath("(//div[@role='presentation']//td[@class='ng-star-inserted']//input)[4]");
    private final By clientColumn = By.xpath("//div[@role=\"presentation\"]//th[contains(@class,'k-header')]//span[text()='Client']");
    private final By clientAttributes = By.xpath("//thead[@role='presentation']//th[3]");
    private final By resetBtn = By.id("client_viewdetail_1");
    private final By historyQue = By.xpath("(//kendo-pager[contains(@class,'k-pager-wrap')])[2]");
    private final By actionsBtn = By.xpath("//li[contains(text(),'Action')]");
    private final By columnsBtn =By.xpath("//ul[@class='nav']//li[text()=' Columns']");
    private final By columnBox = By.xpath("//div[@class='popover-body']");
    private final By historyDetailsGrid = By.id("invtpast");
    private final By updateColumnsBtn = By.xpath("//button[text() = 'Update']");
    private final By loadBtn = By.xpath("//button[text() = 'Load']");
    private final By closeColumnsBtn = By.xpath("//button[text() = 'Close']");
    private final By statusText = By.xpath("(//tbody[@role='presentation'])[2]");
    private final By statusTextBox = By.xpath("(//div[@role='presentation']//td[@class='ng-star-inserted']//input)[3]");
    private final By loadOptionsDropDown =  By.xpath("(//kendo-dropdownlist[contains(@class,'k-widget')]//span[@class=\"k-input\"])[1]");
    private final By appliedFilterName = By.xpath("//div[@class=\"ng-star-inserted\"]//label[contains(text(),'Applied')]");
    private final By selectWorkProduct = By.xpath("(//td[@role=\"gridcell\"]//input[@type=\"checkbox\"])[1]");
    private final By loadFilter = By.xpath("//li[contains(text(),'Load Filters')]");
    private final By itemsDropDown =  By.xpath("//select[@aria-label='items per page']");
    private final By actionsOptions = By.xpath("//div[@class='popover-body']");
    private final By addComment =  By.cssSelector("div.k-editor-content iframe.k-iframe");
    private final By saveCommentBtn = By.xpath("(//button[contains(text(),'Save')])[1]");
    private final By saveTaskBtn = By.xpath("(//i[contains(text(),'Save')])[1]");
    private final By selectTaskType = By.xpath("(//select[@id='TaskType'])[1]");
    private final By enterQty = By.xpath("(//input[@placeholder='Enter Qty'])[1]");
    private final By msTask = By.cssSelector("div[class='text-center'] span");
    private final By contractorPrice = By.xpath("(//input[@type='text'])[1]");
    private final By clientPrice = By.xpath("(//input[@type='text'])[3]");
    private final By continueSaveTaskBtn = By.xpath("//button[text()='Continue']");
    private final String[] clientQueValues = new String[5];
    private final String[] clientNames = DashboardPage.clientName;
    public static String[] historyItemsNumber = new String[5];
    public final By msgIcon = By.xpath("(//img[contains(@src,'message')])[1]");
    public static String[] actualHistoryQueNumber = new String[5];


    public WebElement catchWorkOrderGrid(){
        return find(workOrdersGrid);
    }

    public String getWorkOrderUrl() throws InterruptedException {
        return getCurrentUrl();
    }

    public void clientInsert(String clientName){
        setText(clientTextBox,clientName);
    }

    public String getQueValue() throws InterruptedException {
        Thread.sleep(1000);
        String getQueValues = find(getQueValue).getText();
        System.out.println("Que Value: " + getQueValues);
        return getQueValues;
    }

    public String[] getClientQueValues() throws InterruptedException {
        clickResetBtn();
        for(int i = 0 ; i < clientNames.length ; i++){
            clear(clientTextBox);
            System.out.println("\n" + clientNames[i] + "\n");
            clientInsert(clientNames[i]);
            Thread.sleep(1000);
            clientQueValues[i] = getQueValue();
        }
        return clientQueValues;
    }

    public void clickColumnBtn(){
        click(columnsBtn);
    }
    public void changeColumns() throws InterruptedException {
        Thread.sleep(10000);
        updateColumnsBtn();
    }

    public void closeColumnsBtn(){
     click(closeColumnsBtn);
    }

    public void updateColumnsBtn(){
        click(updateColumnsBtn);
    }

    public void clickLoadFilterBtn(){
        click(loadFilter);
    }
    public void clickLoadBtn() throws InterruptedException {
        click(loadBtn);
        Thread.sleep(5000);
    }
    public WebElement getColumnsBox(){
        return find(columnBox);
    }
    public void clickLoadOptionDropDown() throws InterruptedException {
        Thread.sleep(1000);
        click(loadOptionsDropDown);
        Thread.sleep(5000);
    }
    public void setStatus(String setWorkOrderStates) throws InterruptedException {
        setText(statusTextBox,setWorkOrderStates);
        Thread.sleep(2000);
    }
    public void clickCreateFilterBtn() {
        click(filterBtn);

    }
    public void createFilter() throws InterruptedException {
        Thread.sleep(50000);
        click(saveFilterBtn);
        Thread.sleep(2000);
    }

    public String getFilterCreationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String createdMessageContent = wait.until(ExpectedConditions.visibilityOfElementLocated(creationFilterMessage)).getText();
        click(closeCreatedMessageBtn);
        return createdMessageContent;
    }
    public void clearStatus(){
        clear(statusTextBox);
    }
    public String getFilterName(){
        String filterName = find(loadOptionsDropDown).getText();
        System.out.println( "Filter Name: " + filterName);
        return filterName;
    }

    public String getAppliedFilterName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String appliedFiltersName = wait.until(ExpectedConditions.visibilityOfElementLocated(appliedFilterName)).getText();
        System.out.println("Applied Filter Name: " + appliedFiltersName);
        return appliedFiltersName;
    }

    public void clickResetBtn() throws InterruptedException {
        Thread.sleep(2000);
        click(resetBtn);
        Thread.sleep(7000);
    }
    public String sortByClientName() {
        click(clientColumn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clientColumnAttributes = wait.until(ExpectedConditions.presenceOfElementLocated(clientAttributes));
        String sortStatus = clientColumnAttributes.getAttribute("aria-sort");
        System.out.println("Sort Status: " + sortStatus);
        return sortStatus;
    }

    public boolean changeItemsPerPage(int valueLocation) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(itemsDropDown)));
        select.selectByIndex(valueLocation);
        Thread.sleep(3000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemsDropDown)).isEnabled();
    }

    public boolean viewCommentsOrders(String addYourComment) throws InterruptedException {
        clickResetBtn();
        click(viewDetailsBtn);
        System.out.println("#########Comments Buttons#########");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean commentsViewStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(commentsView)).isDisplayed();
        boolean saveCommentBtnStatus = wait.until(ExpectedConditions.elementToBeClickable(saveCommentBtn)).isEnabled();
        System.out.println("\nSave Button of Comments is displayed? \n" + saveCommentBtnStatus);
        return commentsViewStatus;
    }

    public boolean viewInstructionsOrders() throws InterruptedException {
        click(viewInstructionsBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(5000);
        System.out.println("#########Instructions Buttons#########\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Qty']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Qty']"))).sendKeys("20");
        System.out.println("Quantity of Instructions Added Successfully");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Price']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Price']"))).sendKeys("100");
        System.out.println("Price of Instructions Added Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id=\"client_viewdetail_1\"])[6]"))).click();
        System.out.println("Save Instructions Button Working Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id=\"client_viewdetail_1\"])[8]"))).click();
        System.out.println("Continue Instructions Button Working Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id=\"client_viewdetail_1\"])[5]"))).click();
        System.out.println("Add Instructions Button Working Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@style,'justify-content')]//span[3]//a"))).click();
        driver.switchTo().alert().accept();
        System.out.println("Delete Instructions Button Working Successfully\n");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(instructionsView)).isDisplayed();
    }

    public boolean viewTasksOrders(int setYourTaskTypeIndex) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        click(viewTasksBtn);
        boolean availabilityTaskView = wait.until(ExpectedConditions.visibilityOfElementLocated(tasksView)).isDisplayed();
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(selectTaskType)));
        select.selectByIndex(setYourTaskTypeIndex);
        Thread.sleep(3000);
        find(enterQty).clear();
        find(enterQty).sendKeys("15");
        System.out.println("#########Tasks Buttons#########");
        System.out.println("\nQuantity of Task Added Successfully");
        find(contractorPrice).clear();
        find(contractorPrice).sendKeys("50");
        System.out.println("Contract Price of Task Added Successfully");
        find(clientPrice).clear();
        find(clientPrice).sendKeys("500");
        System.out.println("Client Price of Task Added Successfully");
        click(saveTaskBtn);
        System.out.println("Save of Tasks Button Working Successfully");
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueSaveTaskBtn)).click();
        System.out.println("Continue Saving Task button Working Successfully\n");
        return availabilityTaskView;
    }

    public void selectWorkProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectWorkProduct)).click();

    }

    public WebElement clickActionsBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actionsBtnElement = wait.until(ExpectedConditions.elementToBeClickable(actionsBtn));
        actionsBtnElement.click();
        return actionsBtnElement;
    }

    public boolean actionsOptionsAvailability(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actionsOptionsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(actionsOptions));
        return actionsOptionsElement.isDisplayed();
    }


    public void checkUnAssignedOrders() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignedCheckBox)).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldCompleteCheckBox)).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(officeApprovedCheckBox)).click();
        Thread.sleep(2000);
    }

    public void checkAssignedOrders() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(unAssignedCheckBox)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignedCheckBox)).click();
        Thread.sleep(5000);
    }

    public void checkFieldCompleteOrders() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignedCheckBox)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldCompleteCheckBox)).click();
        Thread.sleep(2000);
    }

    public void checkOfficeApprovedOrders() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldCompleteCheckBox)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(officeApprovedCheckBox)).click();
        Thread.sleep(2000);
    }

    public String getStatusText(){
        String statusNames = find(statusText).getText();
        System.out.println("Status:" + statusNames);
        return statusNames;
    }



    public boolean checkHistoryDetailsGridDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean historyGridAvailability = false;
        String[] wordsToRemove = {"items per page"};
        for (int i = 0; i<5;i++){
            historyItemsNumber[i] = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@role=\"presentation\"])["+(i+3)+"]//td[@class='ng-star-inserted']//div//div"))).getText();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[contains(@src,'history')])["+(i+1)+"]"))).click();
            historyGridAvailability = wait.until(ExpectedConditions.visibilityOfElementLocated(historyDetailsGrid)).isDisplayed();
            actualHistoryQueNumber[i] = wait.until(ExpectedConditions.visibilityOfElementLocated(historyQue)).getText();
            click(By.xpath("//button[@class='close']"));
            String pattern = "\\b(" + String.join("|", wordsToRemove) + ")\\b";
            String modifiedString = actualHistoryQueNumber[i].replaceAll(pattern, "");
            System.out.println("##################");
            System.out.println( "#" + (i+1)+ " The History Items Number: " + historyItemsNumber[i] + " for work order" + "\n" + "#" + (i+1)+ " Actual History Que Numbers:" + modifiedString);
            System.out.println("##################");
        }
        return historyGridAvailability ;
    }

    public boolean clickMessagePopUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(msgIcon)).click();
        WebElement messageContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
        boolean messageContentAvailability = messageContent.isEnabled();
        if (messageContentAvailability){
            System.out.println("Message Pop Up Works Successfully");
        }else {
            System.out.println("Message Pop Up not Works Successfully");
        }
        return find(By.xpath("//div[@class='modal-content']")).isDisplayed();
    }

    public void clickMapPopUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'d-flex')]//img[contains(@src,'address')])[1]"))).click();
    }

    public boolean MapPopUpVisibility(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean mapPopUpStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'d-flex')]//img[contains(@src,'address')])[1]"))).isDisplayed();
        System.out.println("Map Pop Up is Displayed? | " + mapPopUpStatus);
        return mapPopUpStatus;
    }

    public void clickContractorDetails(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[contains(@src,'view_user')])[1]"))).click();
    }
    public boolean contractorDetailsVisibility(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        boolean contractorDetailsStatus =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='popover-body']"))).isDisplayed();
        String contractorDetailsText=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='popover-body']"))).getText();
        System.out.println("Contractor Details (Name, Email, Phone) Are Displayed? | " + contractorDetailsStatus);
        System.out.println("Contractor Details: " + contractorDetailsText);
        return contractorDetailsStatus;
    }
    public String contractorDetails(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='popover-body']"))).getText();
    }

    public void clickPhotoIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@title='view Records']//img[contains(@src,'images')])[1]")));
    }

    public void clickClientWorkOrderEyeIcon(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href,'clientresultinstruction')]//i[contains(@class,'fa fa-eye')])[1]"))).click();
    }

    public String getInstructionsTap(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-tab"))).getText();
    }

    public void setComment(String setComments){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//kendo-editor[@id='myFrame']//div//iframe"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//kendo-editor[@id='myFrame']//div//iframe"))).sendKeys(setComments);
    }
    public void clickSaveCommentBtn(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Save')])[1]")));
    }

    public void clickAddTask(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Add Task')]"))).click();

    }
    public void selectCompletionTask(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='TaskType'])[1]"))));
        select.selectByIndex(2);
    }

    public void setCompletionTaskValues() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterQty)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterQty)).sendKeys("50");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]"))).sendKeys("20");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[4]"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[4]"))).sendKeys("50");
    }

    public void clickSaveTask(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Save')])[1]"))).click();
        driver.switchTo().alert().accept();
    }

    public String getMsgTask(){
        return getText(msTask);
    }

    public void selectBidTask(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='TaskType'])[1]"))));
        select.selectByIndex(1);
    }
    public void setBidTaskValues(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Enter Qty'])[2]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Enter Qty'])[2]"))).sendKeys("50");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[7]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[7]"))).sendKeys("20");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[9]"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[9]"))).sendKeys("50");

    }

    public void selectInspectionTask(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='TaskType'])[1]"))));
        select.selectByIndex(3);
    }

    public void setInspectionTaskValues(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterQty)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterQty)).sendKeys("15");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]"))).sendKeys("50");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[4]"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[4]"))).sendKeys("30");
    }

    public void clickAddInstructions(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Add Instructions')]"))).click();
    }

    public void addInstructionsValues() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Qty']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Qty']"))).sendKeys("40");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Price']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Price']"))).sendKeys("200");
    }

    public void clickSaveInstructions(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Save')])[1]"))).click();
        driver.switchTo().alert().accept();
    }

    public void clickAddDocument(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Attach Document')]"))).click();
    }

    public void addDocument(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='k-dropzone']//div[@role='button']//input[@name='files']"))).sendKeys("D:/Nezam/CTAI-Syllabus.pdf");
    }

    public String documentStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//kendo-upload-status-total[contains(text(),'Done')]"))).getText();
    }

    public void clickAccessLog(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Access Log')]"))).click();
    }

    public String getDateText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String clientDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//tr[@role='row'])[3]//td[@class='ng-star-inserted'])[3]"))).getText();
        System.out.println("Client Date: " + clientDate);
        return clientDate;
    }

    public boolean userViewFileLogDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//tr[@role='row'])[3]//td[@class='ng-star-inserted'])[4]"))).isDisplayed();
    }

    public void clickImportFilesLog(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement importFileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Imported Files')]")));
        importFileElement.click();
    }
    public boolean importFilesLogEnabled(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement importFileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Imported Files')]")));
        return importFileElement.isEnabled();
    }
    public void clickOfficeResults() throws InterruptedException {
        Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='home-tab']"))).click();
        Thread.sleep(6000);
    }

    public WebElement contentOfficeResults(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content-page']")));
    }

    public void clickPropertyInfo() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myTab']//a[@id='pi-tab']"))).click();
        Thread.sleep(6000);
    }

    public WebElement contentPropertyInfo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mt-3 tab-content')]")));
    }

    public WebElement clientDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#home")));
    }

    public WebElement formsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='module-box']")));
    }

    public void clickBidInvoice() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Bid')]"))).click();
    }

    public void verifyCreateBid(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement createBidContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='table-responsive']//tr[@type='Bid'])[2]")));
        System.out.println("Bid Content Enabled To Create/Edit?"+ " | " + createBidContent.isEnabled());
    }

    public void verifyCreateCompletion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@id='inscinvoice-tab'])[2]"))).click();
        WebElement createCompletionContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='table-responsive']//tr[@type='Inv'])[2]")));
        System.out.println("Completion Content Enabled To Create/Edit?"+ " | " + createCompletionContent.isEnabled());
    }

    public void verifyAddDamage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@id='insdamage-tab'])[2]"))).click();
        WebElement addDamageContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='tech-companies-1'])[2]")));
        System.out.println("Add Damage Content Enabled To Create/Edit?"+ " | " + addDamageContent.isEnabled());
    }

    public void addValuesToBid() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@type='Bid']//input[@type='text'])[12]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@type='Bid']//input[@type='text'])[12]"))).sendKeys("30");
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@type='Bid']//td[3])[2]//select"))));
        select.selectByIndex(3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@type='Bid']//td[4])[2]//input"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@type='Bid']//td[4])[2]//input"))).sendKeys("200");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@type='Bid']//td[6])[2]//input"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@type='Bid']//td[6])[2]//input"))).sendKeys("500");
    }

    public String clickSaveBid(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='home2']//div[@class=\"row mt-1\"])//button[contains(text(),'Save')])[2]"))).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msTask)).getText();
    }


    public void addValuesToCompletion() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='inscinvoice'])[2]//input)[1]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='inscinvoice'])[2]//input)[1]"))).sendKeys("40");
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='inscinvoice'])[2]//tr[@type='Inv']//select"))));
        select.selectByIndex(4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='inscinvoice'])[2]//tr[@type='Inv']//input)[4]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='inscinvoice'])[2]//tr[@type='Inv']//input)[4]"))).sendKeys("600");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='inscinvoice'])[2]//tr[@type='Inv']//input)[8]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='inscinvoice'])[2]//tr[@type='Inv']//input)[8]"))).sendKeys("100");
    }

    public String clickSaveCompletion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Save')])[8]"))).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msTask)).getText();
    }

    public void addValuesToDamage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='myinvContent']//div[@id='insdamage']//select)[2]"))));
        select.selectByIndex(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='myinvContent']//div[@id='insdamage']//input[@type='text'])[7]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='myinvContent']//div[@id='insdamage']//input[@type='text'])[7]"))).sendKeys("Hello World");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='myinvContent']//div[@id='insdamage']//input[@type='text'])[8]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='myinvContent']//div[@id='insdamage']//input[@type='text'])[8]"))).sendKeys("5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='myinvContent']//div[@id='insdamage']//input[@type='text'])[9]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='myinvContent']//div[@id='insdamage']//input[@type='text'])[9]"))).sendKeys("100");
    }

    public String clickSaveDamage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Save')])[9]"))).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msTask)).getText();
    }


    public void clickAddAppliance(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//a[@id='Appliance-tab']"))).click();
    }

    public void clickOnApplianceStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content']//div[@id='myinvContent']//div[@id='Appliance']//input[@type='button'])[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content']//div[@id='myinvContent']//div[@id='Appliance']//input[@type='button'])[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content']//div[@id='myinvContent']//div[@id='Appliance']//input[@type='button'])[3]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content']//div[@id='myinvContent']//div[@id='Appliance']//input[@type='button'])[4]"))).click();
    }

    public String clickSaveAppliance(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='myinvContent']//div[@id='Appliance']//button[contains(text(),'Save')]"))).click();
        String applianceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(msTask)).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-center']//button[contains(text(),'Close')]"))).click();
        return applianceMessage;
    }

    public void clickOfficeDocument(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//a[@id='OfficeDocument-tab']"))).click();
    }

    public void clickAddOfficeDocumentBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='OfficeDocument']//button[contains(text(),'Add')]"))).click();
    }

    public void addOfficeDocument(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='document']//div[@class='modal-content']//div[@class='modal-body']//kendo-upload[@dir='ltr']//div[@class='k-dropzone']//div[@role='button']//input[@name='files']"))).sendKeys("D:/Nezam/CTAI-Syllabus.pdf");
    }

    public String officeDocumentStatus(){
        return documentStatus();
    }

    public void clickFieldResults() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myTab']//a[contains(text(),'Field Results')]"))).click();
        Thread.sleep(5000);
    }

    public void clickPropertyInformation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        System.out.println("Key Property Info Enabled" + "|"  +   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='KeyPropertyInfo-tab']"))).isEnabled());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='PropertySettings-tab']"))).click();
        System.out.println("Property Settings Enabled?" +  "|"  +   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='PropertySettings-tab']"))).isEnabled());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='PropertyTeam-tab']"))).click();
        System.out.println("Property Team Enabled?" + "| " +   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id=\"myreco\"]//a[@id='PropertyTeam-tab']"))).isEnabled());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='LoanSettings-tab']"))).click();
        System.out.println("Loan Settings Enabled?" + " | " +  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='LoanSettings-tab']"))).isEnabled());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='ServiceDates-tab']"))).click();
        System.out.println("Service Dates Enabled?" + " | " + wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myreco']//a[@id='ServiceDates-tab']"))).isEnabled());
    }

    public boolean clickFieldResultsForm() throws InterruptedException {
        Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='module-box']//button[contains(text(),'Forms')]"))).click();
        System.out.println("PCR Displayed?" + wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//h4"))).isDisplayed());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//span[@aria-haspopup='listbox']"))).isEnabled();
    }

    public void clickInvoiceTap() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='myTab']//a[@id='invoice-tab']"))).click();
    }

    public void addValuesToScoreCard() throws InterruptedException {
        Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement radioBtn1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='myTabContent']//div[@class='module-box']//input[@id='Prefered-0'])[1]")));
        radioBtn1.click();
        System.out.println("Can Edit Picture Quality Values?" + " | " +  radioBtn1.isEnabled());

        WebElement radioBtn2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='myTabContent']//div[@class='module-box']//input[@id='Prefered-1'])[2]")));
        radioBtn2.click();
        System.out.println("Can Edit Followed Instructions Values?" + " | " +  radioBtn2.isEnabled());

        WebElement radioBtn3 =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='myTabContent']//div[@class='module-box']//input[@id='Prefered-2'])[3]")));
        radioBtn3.click();
        System.out.println("Can Edit Work Quality Values?" + " | " +  radioBtn3.isEnabled());
    }

    public String clickSaveScoreCardValues() throws InterruptedException {
        Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='scorecard-table']//button[contains(text(),'Save')]"))).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msTask)).getText();
    }

    public void clickAddViolation(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//a[@id='insviolation-tab']"))).click();
    }

    public void addValuesToViolation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement violationNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='myinvContent']//div[@id='insviolation']//input[@placeholder='Violation Name']")));
        violationNameInput.sendKeys("Test1");

        WebElement violationIdInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='myinvContent']//div[@id='insviolation']//input[@placeholder='Violation Id']")));
        violationIdInput.sendKeys("52136");

        WebElement fineAmountInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='myinvContent']//div[@id='insviolation']//input[@placeholder='Fine Amount']")));
        fineAmountInput.clear();
        fineAmountInput.sendKeys("50");

        WebElement contactInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='myinvContent']//div[@id='insviolation']//input[@placeholder='Contact']")));
        contactInput.sendKeys("AhmedAli@gmail.com");
    }

    public void clickSaveViolation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//div[@id='insviolation']//button[contains(text(),'Save')]"))).click();
    }

    public String violationStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msTask)).getText();
    }

    public void clickAddHazard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//a[@id='inshazard-tab']"))).click();
    }

    public void addHazardValues(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hazardName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='myinvContent']//div[@id='inshazard']//input[@placeholder='Hazard Name']")));
        hazardName.clear();
        hazardName.sendKeys("Ahmed Ali");
        WebElement hazardDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='myinvContent']//div[@id='inshazard']//textarea[contains(@placeholder,'Description')]")));
        hazardDescription.clear();
        hazardDescription.sendKeys("Ahmed Ali & Micheal Working Together");
    }

    public void clickSaveHazard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='inshazard']//button[contains(text(),'Save')]"))).click();
    }

    public String hazardStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msTask)).getText();
    }

    public void clickPropertyHistory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Property History')]"))).click();
    }

    public void clickBidHistory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//ul[@id='myinvpro']//a[contains(text(),'Bid')]"))).click();
        WebElement bidHistoryContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='invbidhistory']")));
        System.out.println("Bid History Content Displayed? " + " | " + bidHistoryContent.isDisplayed());
    }

    public void clickCompletionHistory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//ul[@id='myinvpro']//a[contains(text(),'Completion')]"))).click();
        WebElement completionHistoryContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='invinvoicehistory']")));
        System.out.println("Completion History Content Displayed? " + " | " + completionHistoryContent.isDisplayed());
    }

    public void clickDamageHistory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//ul[@id='myinvpro']//a[contains(text(),'Damage')]"))).click();
        WebElement damageHistoryContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='invdamagehistory']")));
        System.out.println("Damage History Content Displayed? " + " | " + damageHistoryContent.isDisplayed());
    }

    public void clickContractorInvoiceHistory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//ul[@id='myinvpro']//a[contains(text(),'Contractor')]"))).click();
        WebElement contractorHistoryContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='contractorinvoicehistory']")));
        System.out.println("Contractor Invoice History Content Displayed? " + " | " + contractorHistoryContent.isDisplayed());
    }

    public void clickClientInvoiceHistory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//a[contains(text(),'Client Invoice')]"))).click();
        WebElement contractorHistoryContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@id='clientinvoicehistory']")));
        System.out.println("Contractor Invoice History Content Displayed? " + " | " + contractorHistoryContent.isDisplayed());
    }

}
