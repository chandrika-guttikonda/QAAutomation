package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Day3FormAutomationTest {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub

		//Launch chrome browser and open the demo website
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		//identify the form element and scroll that into view
		WebElement form=driver.findElement(By.className("practice-form-wrapper"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", form);
		
		//enter first name and last name and email
		driver.findElement(By.id("firstName")).sendKeys("Chandrika");
		driver.findElement(By.id("lastName")).sendKeys("Guttikonda");
		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		
		//enter phone no
		driver.findElement(By.id("userNumber")).sendKeys("1234567890");
	
		//select a gender by using javascript click cause of element intercepted exception
		WebElement gender=driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
		js.executeScript("arguments[0].click();", gender);
		
		//select multiple hobbies by javascript click cause of element intercepted exception
		List<WebElement> hobbies=driver.findElements(By.xpath("//input[contains(@id,'hobbies-checkbox')]"));
		js.executeScript("arguments[0].click();", hobbies.get(0));
		js.executeScript("arguments[0].click();", hobbies.get(1));
		
		//scroll view to select stae and city dropdowns
		WebElement stateCity=driver.findElement(By.id("stateCity-wrapper"));
		js.executeScript("arguments[0].scrollIntoView(true);", stateCity);
		
		//identify state element and send keys since it's not a select dropdown
		WebElement state=driver.findElement(By.id("react-select-3-input"));
		state.sendKeys("NCR");
		state.sendKeys(Keys.ENTER);
		
		//identify city element and send keys since it's not a select dropdown
		WebElement city=driver.findElement(By.id("react-select-4-input"));
		city.sendKeys("Delhi");
		city.sendKeys(Keys.ENTER);
		
		//identify submit and click
		driver.findElement(By.id("submit")).click();
		
		//validate the success message
		String success=driver.findElement(By.xpath("//div[@class='modal-header']")).getText();
		Assert.assertEquals(success, "Thanks for submitting the form");
		
		//scroll to bottom and wait for sometime and scroll to top again
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0);");
		
		//quit the browser
		driver.quit();
		
		
	}

}
