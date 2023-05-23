package com.ipreservationlive.tests.AdminTest.Dashboard;

import org.testng.Assert;
import org.testng.annotations.*;


public class TC01_Login extends BaseTest {

    //Test to verify successful login
    @Parameters({"username","password"})
    @Test
    public void testLogin(String username, String password) throws InterruptedException {
        //Navigate to Login Page
        loginPage.loadLoginPage();
        //Enter username
        loginPage.setUsername(username);
        //Enter password
        loginPage.setPassword(password);
        //Click on Login Button
        loginPage.clickLoginBtn();
        //Verify successful login message is displayed
        Assert.assertTrue(loginPage.accessLoginMessage().isDisplayed(),
                "\n The message doesn't displayed successfully \n");
        //Click on a button to close the message
        loginPage.clickMessageBtn();
    }

}
