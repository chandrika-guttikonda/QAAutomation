package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPageFactory;
import Pages.SecureAreaPage;

public class Day16_LoginTest {

	WebDriver driver;
    LoginPageFactory loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPageFactory(driver);
        System.out.println("Opened login page");
    }

    @Test
    public void positiveLoginTest() {
        loginPage.enterUsername("student")
                 .enterPassword("Password123")
                 .clickSubmit();
        // Now use normal POM SecureAreaPage to verify
        SecureAreaPage securePage = new SecureAreaPage(driver);
        String actual = securePage.getSuccessMessage();
        System.out.println("actual message shown: " + actual);
        Assert.assertEquals(actual, "Logged In Successfully", "Positive login failed!");
    }

    @Test
    public void negativeLoginTest() {
        loginPage.enterUsername("wronguser")
                 .enterPassword("wrongpass")
                 .clickSubmit();
        String error = loginPage.getErrorMessage();
        System.out.println("Error message shown1: " + error);
        Assert.assertEquals(error, "Your username is invalid!", "Error message mismatch!");
    }

    @Test
    public void emptyUsernameTest() {
        loginPage.enterUsername("")
                 .enterPassword("Password123")
                 .clickSubmit();
        String error = loginPage.getErrorMessage();
        System.out.println("Error message shown2: " + error);
        Assert.assertEquals(error, "Your username is invalid!", "Empty username test failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Closed browser");
    }
}
