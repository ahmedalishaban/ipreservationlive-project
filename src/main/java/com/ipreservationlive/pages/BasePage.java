package com.ipreservationlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected String getText(By locator){
        String text =  driver.findElement(locator).getText();
        System.out.println("Current Text: " + text);
        return text;
    }

    protected void setText(By locator,String yourText){
        driver.findElement(locator).sendKeys(yourText);
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public String getCurrentUrl() throws InterruptedException {
        Thread.sleep(2000);
        return driver.getCurrentUrl();
    }

    public void clear(By locator){
        driver.findElement(locator).clear();
    }
}
