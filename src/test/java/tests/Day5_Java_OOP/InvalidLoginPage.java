package tests.Day5_Java_OOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//extend loginpage to ingerit those properties
public class InvalidLoginPage extends LoginPage {
	public InvalidLoginPage(WebDriver driver) {
		//using base class constructor
		super(driver);
	}

	//*************************Overriding*****************
	@Override
    public void submitLogin(String username, String password) {
        System.out.println("Attempting invalid login...");

        // Use parent class's methods
        enterUserName(username);
        enterPassword(password);
        submitLogin();

        // Validate error message
        WebElement errorMsg = driver.findElement(By.id("error"));
        String actualMessage = errorMsg.getText();
        String expectedMessage = "Your username is invalid!";

        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Error message displayed correctly: " + actualMessage);
        } else {
            System.out.println("Unexpected error message: " + actualMessage);
        }
}
}
