package AdminTest.Dashboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TC02_dashboard {

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();

    @Parameters({"loginURL","username","password"})
    @BeforeClass
    public void setUp(String url, String username, String password) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Navigate to login page
        driver.get(url);
        //Enter username
        driver.findElement(By.id("emailaddress")).sendKeys(username);
        //Enter password
        driver.findElement(By.id("password")).sendKeys(password);
        //Click on client view detail
        driver.findElement(By.id("client_viewdetail_1")).click();
        //Close Welcome Message
        driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();
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

//  Needs unique attributes to access pie Chart
    @Test
    public void verifyStatus() throws InterruptedException {
        // Grids Elements
        WebElement statusGrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//kendo-grid[@dir=\"ltr\"])[1]")));
        WebElement pieChartGrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"k-chart-surface\"])[1]")));

        //Hard Assertions GRIDs
        Assert.assertTrue(statusGrid.isDisplayed(),"Status Grid Not Displayed");
        Assert.assertTrue(pieChartGrid.isDisplayed(),"Chart Grid Not Displayed");

        //Get Orders Values
        String unAssignedOrder = driver.findElement(By.xpath("((//kendo-grid[@dir=\"ltr\"])[1]//td[@role=\"gridcell\"])[4]")).getText();
        String assignedOrder = driver.findElement(By.xpath("((//kendo-grid[@dir=\"ltr\"])[1]//td[@role=\"gridcell\"])[8]")).getText();
        String fieldCompleteOrder = driver.findElement(By.xpath("((//kendo-grid[@dir=\"ltr\"])[1]//td[@role=\"gridcell\"])[12]")).getText();

        //Navigate to workOrder Page to get Que Values
        driver.get("https://testui.ipreservationlive.com/workorder");


        //Explicit Wait for ignore any error exception
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //CheckBox Buttons
        WebElement unAssignedCheckBox =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type=\"checkbox\"])[1]")));

        WebElement AssignedCheckBox =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type=\"checkbox\"])[2]")));

        WebElement fieldCompleteCheckBox =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type=\"checkbox\"])[3]")));

        WebElement officeApproved =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type=\"checkbox\"])[4]")));

        //UnAssigned Status & Que
        AssignedCheckBox.click();
        fieldCompleteCheckBox.click();
        officeApproved.click();
        WebElement unAssignedValue =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//kendo-pager-info[@class=\"k-pager-info k-label ng-star-inserted\"]")));
        String actualUnAssignedValue = unAssignedValue.getText();

        //Assigned Status & Que
        unAssignedCheckBox.click();
        AssignedCheckBox.click();
        Thread.sleep(6000);
        WebElement AssignedValue =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//kendo-pager-info[@class=\"k-pager-info k-label ng-star-inserted\"]")));
        String actualAssignedValue = AssignedValue.getText();

        //Field Complete Que
        AssignedCheckBox.click();
        fieldCompleteCheckBox.click();
        Thread.sleep(2000);
        WebElement fieldCompleteValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//kendo-pager-info[@class=\"k-pager-info k-label ng-star-inserted\"]")));
        String actualFieldCompleteValue = fieldCompleteValue.getText();

        System.out.println( fieldCompleteOrder + " | "+ actualFieldCompleteValue);
        System.out.println( assignedOrder + " | "+ actualAssignedValue);
        System.out.println( unAssignedOrder + " | "+ actualUnAssignedValue);

            //Soft Assertions for Que Values
            softAssert.assertTrue(actualUnAssignedValue.contains(unAssignedOrder),"UnAssigned Order Values Not match Que");
            softAssert.assertTrue(actualAssignedValue.contains(assignedOrder),"Assigned Order Values Not match Que");
            softAssert.assertTrue(actualFieldCompleteValue.contains(fieldCompleteOrder),"Field Complete Order Values Not match Que");

            //Assert All Values
            softAssert.assertAll();
    }



//    @Test
//    public void verifyClient() {
//        driver.get("https://testui.ipreservationlive.com/dashboard");
//        WebElement clientGrid =  driver.findElement(By.xpath("(//div[@class=\"card-box px-md-1\"])[2]"));
//        WebElement clientChart = driver.findElement(By.xpath("(//div[@class=\"card-box px-md-1 h-100\"])[3]"));
//
//            // Assert from Client Availability
//            Assert.assertTrue(clientGrid.isDisplayed());
//            Assert.assertTrue(clientChart.isDisplayed());
//
//        String [] clientName = new String[5];
//        String [] clientValues = new String[5];
//        String [] actualValues = new String[5];
//        for (int i=0 ; i< clientName.length ;i++){
//            int count = 6;
//            clientName[i] = driver.findElement(By.xpath("(//tr[@role=\"row\"])["+count+"]//td[@data-kendo-grid-column-index='0']")).getText();
//            clientValues[i] = driver.findElement(By.xpath("(//tr[@role=\"row\"])["+count+"]//td[@data-kendo-grid-column-index='5']")).getText();
//            count = count + 1;
//        }
//
//        WebElement workOrdersBtn = driver.findElement(By.xpath("(//a[@routerlinkactive=\"active\"])[1]"));
//        workOrdersBtn.click();
//
//        WebElement clientTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id=\"k-grid0-r1c4\"]//kendo-grid-filter-wrapper-cell[@id=\"abId0.0676888859836664\"]//input")));
//
//        for (int j = 0; j< clientName.length; j++){
//            clientTxtBox.clear();
//            clientTxtBox.sendKeys(clientName[j]);
//            actualValues[j] = driver.findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted']")).getText();
//        }
//
//        for (int count = 0 ; count < clientName.length;count++){
//            Assert.assertTrue(actualValues[count].contains(clientValues[count]));
//        }
//
//
//    }

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
