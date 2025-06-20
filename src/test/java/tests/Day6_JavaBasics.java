package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Strings,Arrays,Loops.Conditional Logic
public class Day6_JavaBasics {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch chrome browser and open the demo website
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();

		// identify the form element and scroll that into view
		WebElement form = driver.findElement(By.className("practice-form-wrapper"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", form);

		// enter first name and last name and email
		driver.findElement(By.id("firstName")).sendKeys("Chandrika");
		driver.findElement(By.id("lastName")).sendKeys("QA");
		driver.findElement(By.id("userEmail")).sendKeys("chandrika.qa@example.com");

		//Array+String+Loop Validation
		String[] expectedGenders = { "Male", "Female", "Other" };
		List<WebElement> labels = driver.findElements(By.xpath("//input[@type='radio']//following-sibling::label"));
		for (WebElement label : labels) {
			System.out.println(label.getText());
		}
		WebElement gender = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
		js.executeScript("arguments[0].click();", gender);

		List<WebElement> hobbies = driver.findElements(By.xpath("//input[contains(@id,'hobbies-checkbox')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", hobbies.get(0));
		for (WebElement hobby : hobbies) {
			if (hobby.getText().equals("Reading")) {
				hobby.click();
			}
		}

		// enter phone no
		//conditional logic
		String mobile = "1234567890";
		if (mobile.length() == 10) {
			driver.findElement(By.id("userNumber")).sendKeys(mobile);
		}
		String address = "Hyderabad";
		if (address.isEmpty()) {
			WebElement addressLoc = driver.findElement(By.id("currentAddress"));
			js.executeScript("arguments[0].scrollIntoView(true);", addressLoc);
			addressLoc.sendKeys(address);
		}

		// identify state element and send keys since it's not a select dropdown
		WebElement state = driver.findElement(By.id("react-select-3-input"));
		state.sendKeys("NCR");
		state.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		// identify city element and send keys since it's not a select dropdown
		WebElement city = driver.findElement(By.id("react-select-4-input"));
		city.sendKeys("Delhi");
		city.sendKeys(Keys.ENTER);

		// identify submit and click
		driver.findElement(By.id("submit")).click();

		// validate the success message
		String success = driver.findElement(By.xpath("//div[@class='modal-header']")).getText();
		Assert.assertEquals(success, "Thanks for submitting the form");

		// scroll to bottom and wait for sometime and scroll to top again
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0);");

		// quit the browser
		driver.quit();
	}

}
