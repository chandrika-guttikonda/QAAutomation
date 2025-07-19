package Day14And15_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import Listeners.TestListener;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public class LoginWithExcelAndListenerTest {

	WebDriver driver;
	SoftAssert softAssert;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		softAssert = new SoftAssert();
	}

	@Test(dataProvider = "loginData", dataProviderClass = DataProvider.LoginDataProvider.class, groups = {
			"smoke" }, priority = 1)
	public void loginTest(String username, String password) {
		System.out.println("entered login");
		driver.get("https://automationexercise.com/login");

		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String currentUrl = driver.getCurrentUrl();

		if (username.isEmpty() && password.isEmpty()) {
			System.out.println("Entered empty username or password");
			WebElement error = driver
					.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
			softAssert.assertTrue(error.isDisplayed(), "Validation message not shown for empty fields");
		} else if (username.equals("validuser@mail.com") && password.equals("validpass")) {
			System.out.println("Entered correct credentials but navigation failed");
			Assert.assertTrue(currentUrl.contains("account"), "Did not navigate to account page");
		} else {
			System.out.println("Entered incorrect username or password");
			WebElement error = driver
					.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
			softAssert.assertTrue(error.isDisplayed(), "Error message not shown for invalid login");
		}

		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
