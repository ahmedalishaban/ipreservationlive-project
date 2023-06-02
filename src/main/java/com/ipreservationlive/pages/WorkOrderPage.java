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
    private final By enterQty = By.xpath("(//input[@placeholder=\"Enter Qty\"])[1]");
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(5000);
        System.out.println("#########Instructions Buttons#########\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Qty']"))).sendKeys("20");
        System.out.println("Quantity of Instructions Added Successfully");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Price']"))).sendKeys("100");
        System.out.println("Price of Instructions Added Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id=\"client_viewdetail_1\"])[6]"))).click();
        System.out.println("Save Instructions Button Working Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id=\"client_viewdetail_1\"])[8]"))).click();
        System.out.println("Continue Instructions Button Working Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id=\"client_viewdetail_1\"])[5]"))).click();
        System.out.println("Add Instructions Button Working Successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-trash'])[4]"))).click();
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
}
