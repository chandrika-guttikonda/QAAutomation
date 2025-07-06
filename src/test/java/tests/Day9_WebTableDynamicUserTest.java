package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Day9_WebTableDynamicUserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		// Navigate to the practice website
		driver.get("https://demoqa.com/webtables");

		driver.manage().window().maximize();

		driver.findElement(By.id("addNewRecordButton")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

		driver.findElement(By.id("firstName")).sendKeys("Chandrika");
		
		driver.findElement(By.id("lastName")).sendKeys("Guttikonda");
		
		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		
		driver.findElement(By.id("age")).sendKeys("20");
		
		driver.findElement(By.id("salary")).sendKeys("80000");
		
		driver.findElement(By.id("department")).sendKeys("Finance");
		
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.xpath("//div[@role='gridcell' and text()='Chandrika']")).isDisplayed();
		
		WebElement delete=driver.findElement(By.xpath("//div[@role='gridcell' and text()='Chandrika']//following-sibling::div//div//span[contains(@id,'delete')]"));
		
		driver.navigate().refresh();
		
		try {
            delete.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Caught stale element. Refetching...");
         
        }
		
		boolean isUserPresent = driver.findElements(By.xpath("//div[@class='rt-td' and text()='Chandrika']")).size() > 0;
        Assert.assertFalse(isUserPresent, "User still exists in the table after delete");

        driver.quit();
		
		
	}

}
