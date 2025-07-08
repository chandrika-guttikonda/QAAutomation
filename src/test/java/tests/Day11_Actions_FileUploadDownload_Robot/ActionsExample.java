package tests.Day11_Actions_FileUploadDownload_Robot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		// Navigate to the practice website
		driver.get("https://demoqa.com/buttons");

		driver.manage().window().maximize();
		
		WebElement doubleClickBtn=driver.findElement(By.id("doubleClickBtn"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", doubleClickBtn);
		wait.until(ExpectedConditions.visibilityOf(doubleClickBtn));
		
		Actions act=new Actions(driver);
		act.doubleClick(doubleClickBtn).perform();
		
		
		String expectedMessage="You have done a double click";
		String actualMessage=driver.findElement(By.id("doubleClickMessage")).getText();
		
		Assert.assertEquals(expectedMessage, actualMessage);
		
		
		WebElement rightClickBtn=driver.findElement(By.id("rightClickBtn"));
		
		act.contextClick(rightClickBtn).perform();
		
		
		expectedMessage="You have done a right click";
		actualMessage=driver.findElement(By.id("rightClickMessage")).getText();
		
		Assert.assertEquals(expectedMessage, actualMessage);
		
        WebElement clickBtn=driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		act.click(clickBtn).perform();
		
		expectedMessage="You have done a dynamic click";
		actualMessage=driver.findElement(By.id("dynamicClickMessage")).getText();
		
		Assert.assertEquals(expectedMessage, actualMessage);

	}

}
