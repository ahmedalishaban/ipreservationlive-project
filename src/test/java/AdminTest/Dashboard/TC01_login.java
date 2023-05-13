package AdminTest.Dashboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_login {

    //Declare class variables
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    //Set up the driver and navigate to the login page
    @Parameters({"URL"})
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
        //Click on a button to logout
        driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();
    }



    //Close the browser window
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
