package tests.Day5_Java_OOP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	// Initializing WebDriver as protected to check inheritance access specifiers
	protected WebDriver driver;
	// TODO Auto-generated method stub

	// Constructor- Code stub which will execute first
	public BaseTest() {

		// Initialize cr=hrome driver and launch and maximize the browser
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
	}

	//method to teardown browser
	public void teardown() {
		driver.quit();
	}

}
