package tests.Day11_Actions_FileUploadDownload_Robot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionMenuHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		// Navigate to the practice website
		driver.get("https://demoqa.com/menu");

		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement mainMenu=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		js.executeScript("arguments[0].scrollIntoView(true);", mainMenu);
		Actions act=new Actions(driver);
		act.moveToElement(mainMenu);
		act.pause(Duration.ofSeconds(5));
		act.perform();

		WebElement subList=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		act.moveToElement(subList);
		act.pause(Duration.ofSeconds(5));
		act.perform();
		
		WebElement subList2=driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
		
		subList2.isDisplayed();
		subList2.isEnabled();
		subList2.click();
		
		System.out.println("Completed");
		
		driver.quit();
		
		
		
		
	}

}
