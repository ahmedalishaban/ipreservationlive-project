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

public class TC02_dashboard {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @Parameters({"loginURL","username","password"})
    @BeforeClass
    public void setUp(String url, String username, String password) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        //Navigate to login page
        driver.get(url);
        //Enter username
        driver.findElement(By.id("emailaddress")).sendKeys(username);
        //Enter password
        driver.findElement(By.id("password")).sendKeys(password);
        //Click on client view detail
        driver.findElement(By.id("client_viewdetail_1")).click();
        Thread.sleep(2000);
    }

    @Test
    public void verifyNavigateIcon() throws InterruptedException {
        driver.get("https://testui.ipreservationlive.com/accounting/accountingdetails");
        driver.findElement(By.xpath("//span[@class=\"logo-lg\"]")).click();
        Thread.sleep(1000);
        String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl,"https://testui.ipreservationlive.com/dashboard",
                    "Dashboard page not opened successfully");
    }


    @Test
    public void verifyStatus() throws InterruptedException {
        Thread.sleep(2000);
        // Grids Elements
        WebElement statusGrid = driver.findElement(By.xpath("(//kendo-grid[@dir=\"ltr\"])[1]"));
        WebElement pieChartGrid = driver.findElement(By.xpath("(//div[@class=\"k-chart-surface\"])[1]"));

        // Values
        WebElement[] pieChartValues = new WebElement[2];
        pieChartValues[0] = driver.findElement(By.xpath("(//*[text() =\"2\"])[3]"));
        pieChartValues[1] = driver.findElement(By.xpath("(//*[text() =\"181\"])[3]"));
        WebElement[] statusValues = new WebElement[2];
        statusValues[0] = driver.findElement(By.xpath("(//*[text() =\"2\"])[2]"));
        statusValues[1] = driver.findElement(By.xpath("(//*[text() =\"181\"])[2]"));


            //Assert GRIDs
            Assert.assertTrue(statusGrid.isDisplayed());
            Assert.assertTrue(pieChartGrid.isDisplayed());

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

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
