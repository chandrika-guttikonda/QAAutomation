package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Day1Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Launch browser using Chrome Driver
		WebDriver driver=new ChromeDriver();
		//Navigate to the practice website
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//maximize the current widow
		driver.manage().window().maximize();
		
		//implicit wait for global page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		//use of id locator
		driver.findElement(By.id("name")).sendKeys("Chandrika");
		
		//use of name locator
		List<WebElement> radioBtn=driver.findElements(By.name("radioButton"));
		for(WebElement radio:radioBtn) {
			radio.click();
		}
		
		//use of xpath locator
		WebElement optionCheckbox=driver.findElement(By.xpath("//input[@value='option2']"));
		optionCheckbox.click();
		boolean res=optionCheckbox.isSelected();
		Assert.assertEquals(res, true);
		optionCheckbox.click();
		res=optionCheckbox.isSelected();
		Assert.assertEquals(res, false);
		
		//use of css selector
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("Automation is fun if learned correctly");
		
		//validate total number of checkboxes
		int size=driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println(size);
		
		//creation of select dropdown element
		WebElement dropdown=driver.findElement(By.tagName("select"));
		Select select=new Select(dropdown);
		
		//print all the dropdown options'
		List<WebElement> options=driver.findElements(By.xpath("//option[contains(@value,'option')]"));
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
		Thread.sleep(3000);
		//scroll to the bottom and click on VIEW ALL COURSES link
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement link=driver.findElement(By.xpath("//a[contains(text(),'Discount Coupons')]"));
		
		link.click();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
