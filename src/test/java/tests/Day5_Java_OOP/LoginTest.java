package tests.Day5_Java_OOP;

import org.openqa.selenium.WebDriver;

//Java OOP 
//Extend the BaseTest to use the driver properties
public class LoginTest extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//object creation for Basetest
		BaseTest bp = new BaseTest();
		
		//accessing protected member of BaseTest class
		WebDriver driver = bp.driver;
		
		//creating object for Loginpage
		LoginPage login = new LoginPage(driver);
		
		//use one form of method overloading
		login.enterUserName("student");
		login.enterPassword("Password123");
		login.submitLogin();
		Thread.sleep(1000);
		driver.navigate().back();

		//calling another form of method overloading
		login.submitLogin("student", "Password123");
		Thread.sleep(1000);
		driver.navigate().back();

		//validating constructor overloading
		LoginPage login2 = new LoginPage(driver, "student", "Password123");
		login2.submitLogin();
		driver.navigate().back();
		Thread.sleep(1000);


		//create object for invalid login page to validate error messages
		InvalidLoginPage invalid = new InvalidLoginPage(driver);
		invalid.submitLogin("wrongUser", "wrongPass");
		Thread.sleep(1000);

		bp.teardown();

	}

}
