package com.ipreservationlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class WorkOrderPage extends BasePage {
    private final By workOrdersGrid = By.xpath("(//div[@class=\"col-12\"])[2]");
    private final By getQueValue = By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted']");
    private final By clientTextBox = By.xpath("(//div[@role='presentation']//td[@class='ng-star-inserted']//input)[4]");
    private final By resetBtn = By.id("client_viewdetail_1");
    private final String[] clientQueValues = new String[5];
    private final String[] clientNames = DashboardPage.clientName;

    public WebElement catchWorkOrderGrid(){
        return find(workOrdersGrid);
    }

    public String getWorkOrderUrl() throws InterruptedException {
        return getCurrentUrl();
    }

    public void clientInsert(String clientName){
        setText(clientTextBox,clientName);
    }

    public String getQueValue(){
        String getQueValues = find(getQueValue).getText();
        System.out.println("Que Value: " + getQueValues);
        return getQueValues;
    }

    public String[] getClientQueValues() throws InterruptedException {
        click(resetBtn);
        Thread.sleep(7000);
        for(int i = 0 ; i < clientNames.length ; i++){
            clear(clientTextBox);
            System.out.println("\n" + clientNames[i] + "\n");
            clientInsert(clientNames[i]);
            Thread.sleep(1000);
            clientQueValues[i] = getQueValue();
        }
        return clientQueValues;
    }


}
