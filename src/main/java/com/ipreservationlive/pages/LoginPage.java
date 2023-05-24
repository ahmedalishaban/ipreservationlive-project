package com.ipreservationlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By emailLocator = By.id("emailaddress");
    private final By passwordLocator = By.id("password");
    private final By loginBtn = By.id("client_viewdetail_1");
    private final By messageBtn = By.xpath("(//button[@type=\"button\"])[3]");
    private final By loginMessage = By.xpath("//span[text()= ' Welcome back check']");

    public void setUsername(String email) {
        setText(emailLocator,email);
    }

    public void setPassword(String password){
        setText(passwordLocator, password);
    }

    public void clickLoginBtn(){
        click(loginBtn);
    }

    public void clickMessageBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageBtn));
        click(messageBtn);
    }

    public WebElement accessLoginMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginMessage));
    }

    public void loadLoginPage(){
        String loginUrl = "https://testui.ipreservationlive.com/admin/login";
        driver.get(loginUrl);
    }

    public void loginToWebsite() throws InterruptedException {
        loadLoginPage();
        setUsername("check123");
        setPassword("helloworld");
        clickLoginBtn();
        clickMessageBtn();
        Thread.sleep(2000);
    }
}

