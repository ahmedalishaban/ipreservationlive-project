package com.ipreservationlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage{

    private final By dashboardIcon = By.xpath("//img[@src='assets/images/HomeLogoX.png']");
    private final By statusGrid = By.xpath("(//kendo-grid[@dir=\"ltr\"])[1]");
    private final By pieChartGrid = By.xpath("(//div[@class=\"k-chart-surface\"])[1]");
    private final By clientGrid = By.xpath("(//div[@class=\"card-box px-md-1\"])[2]");
    private final By clientChart = By.xpath("(//div[@class=\"card-box px-md-1 h-100\"])[3]");
    private final By workOrderBtn = By.xpath("//a[text() = ' Work Orders ']");
    public static final String[] clientName = new String[5];
    private final String[] clientValues = new String[5];



    //Order Values
    private final By unAssignedOrder = By.xpath("((//kendo-grid[@dir=\"ltr\"])[1]//td[@role=\"gridcell\"])[4]");
    private final By assignedOrder = By.xpath("((//kendo-grid[@dir=\"ltr\"])[1]//td[@role=\"gridcell\"])[8]");
    private final By fieldCompleteOrder = By.xpath("((//kendo-grid[@dir=\"ltr\"])[1]//td[@role=\"gridcell\"])[12]");


    // get Que Values
    private final By queValue = By.xpath("//kendo-pager-info[contains(@class,'k-pager-info')]");


    // Page Methods
    public void clickDashboardIcon() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIcon)).click();
        Thread.sleep(1000);
    }

    public String getDashboardUrl(){
        String dashboardUrl =  driver.getCurrentUrl();
        System.out.println("Current Url: " + dashboardUrl);
        return dashboardUrl;
    }

    public WebElement catchStatusGrid(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusGrid));
    }

    public WebElement catchPieChartGrid(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pieChartGrid));
    }

    public String getUnAssignedValue() throws InterruptedException {
        Thread.sleep(1000);
        String unAssignedValue = find(unAssignedOrder).getText();
        System.out.println("Un Assigned Value = "+ unAssignedValue);
        return unAssignedValue;
    }

    public String getAssignedValue() throws InterruptedException {
        Thread.sleep(1000);
        String assignedValue = find(assignedOrder).getText();
        System.out.println("Assigned Value = "+ assignedValue);
        return assignedValue;
    }

    public String getFieldCompleteValue() throws InterruptedException {
        Thread.sleep(1000);
        String fieldCompleteOrderValue = find(fieldCompleteOrder).getText();
        System.out.println("Field Complete Order Value = "+ fieldCompleteOrderValue);
        return fieldCompleteOrderValue;
    }



    public String getQueValue() throws InterruptedException {
        Thread.sleep(7000);
        String getValue = find(queValue).getText();
        System.out.println("Que Value: " + getValue);
        return getValue;
    }

    public void getWorkOrderPage() throws InterruptedException {
        click(workOrderBtn);
        Thread.sleep(5000);
    }

    public WebElement catchClientGrid(){
        return find(clientGrid);
    }

    public WebElement catchClientChart(){
        return find(clientChart);
    }

    public String[] getClientValues() throws InterruptedException {
        Thread.sleep(6000);
        for (int i=0 ; i< clientName.length ;i++){
            clientName[i] = find(By.xpath("(//table[contains(@style,'table-layout: fixed;')])[2]//tr["+(i+1)+"]/td[1]")).getText();
            clientValues[i] = find(By.xpath("(//table[contains(@style,'table-layout: fixed;')])[2]//tr["+(i+1)+"]/td["+6+"]")).getText();
        }
        return clientValues;
    }

    public void printClientValues(){
        for (int i =0 ; i <clientName.length ; i++){
            System.out.println("#" + (i+1) + " Client Name:"+ clientName[i] + ", Value:" + clientValues[i]);
        }
    }

}
