package com.ipreservationlive.tests.AdminTest.Dashboard;

import com.ipreservationlive.pages.BasePage;
import com.ipreservationlive.pages.DashboardPage;
import com.ipreservationlive.pages.LoginPage;
import com.ipreservationlive.pages.WorkOrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected BasePage basePage;
    protected DashboardPage dashboardPage;
    protected WorkOrderPage workOrderPage;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void loadApplication(){
       loginPage = new LoginPage();
       basePage = new BasePage();
       dashboardPage = new DashboardPage();
       workOrderPage = new WorkOrderPage();
       basePage.setDriver(driver);
    }


    @AfterMethod
    public void takeFailedScreenShots(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/" + testResult.getName() + ".png");
            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
