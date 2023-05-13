package AdminTest.Dashboard.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class TC01_login {

    //Declare class variables
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    //Set up the driver and navigate to the login page
    @Parameters({"loginURL"})
    @BeforeClass
    public void setUp(String url) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    //Test to verify successful login
    @Parameters({"username","password"})
    @Test
    public void testLogin(String username, String password) throws InterruptedException {
        //Enter username
        driver.findElement(By.id("emailaddress")).sendKeys(username);
        //Enter password
        driver.findElement(By.id("password")).sendKeys(password);
        //Click on client view detail
        driver.findElement(By.id("client_viewdetail_1")).click();
        Thread.sleep(2000);
        //Verify successful login message is displayed
        WebElement actualMessage = driver.findElement(By.xpath("//span[text()= ' Welcome back check']"));
        Assert.assertTrue(actualMessage.isDisplayed(),"The message doesn't displayed successfully");
        //Click on a button to close the message
        driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();
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

    //Close the browser window
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
