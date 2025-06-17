package tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Day4AdvancedUIInteractions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launch Chrome Driver
		WebDriver driver = new ChromeDriver();
		
		//**********ALERTS********************
		driver.get("https://demoqa.com/alerts");

		//Declaring WebDriver waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//maxi,ize window
		driver.manage().window().maximize();

		//Identify the alerts section
		WebElement alertWrapper = driver.findElement(By.id("javascriptAlertsWrapper"));
		//Initialize Java Script Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//scroll the browser till alerts section
		js.executeScript("arguments[0].scrollIntoView(true);", alertWrapper);

		//Handling a simple alert
		driver.findElement(By.id("alertButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//handling a Confirmation alert
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmAlert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		confirmAlert.dismiss();

		//handling a prompt alert
		driver.findElement(By.id("promtButton")).click();
		Alert promptAlert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		promptAlert.sendKeys("Chandrika");
		promptAlert.accept();


		//************FRAMES********************
		driver.get("https://demoqa.com/frames");
		//scroll browser till frames section
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("frame1")));
		
		//switch to frame
		driver.switchTo().frame("frame1");

		//validate header message
		Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(),"This is a sample page");
		//switch to default
		driver.switchTo().defaultContent();

		//Naviagate to nested frame website
		driver.get("https://demoqa.com/nestedframes");
		
		//scroll the nested frame section into view point
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("framesWrapper")));
		
		//switch to outer frame
		driver.switchTo().frame("frame1");

		//switch to inner frame
		driver.switchTo().frame(0);

		//print the message from inner frame
		System.out.println(driver.findElement(By.tagName("p")).getText());

		//switch to default
		driver.switchTo().defaultContent();

		//**************Window handling********************
		driver.get("https://demoqa.com/browser-windows");

		//scroll to the window section
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("browserWindows")));
		
		//click on a button and when a new tab open handle it by getWindowHandles()
		driver.findElement(By.id("tabButton")).click();
		String parent = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		for (String win : windows) {
			if (win != parent) {
				driver.switchTo().window(win);
			}
		}

		Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(), "This is a sample page");
		driver.close();

		driver.switchTo().window(parent);

		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("browserWindows")));
		
		
		driver.findElement(By.id("windowButton")).click();

		String parentWindow = driver.getWindowHandle();

		Set<String> windows2 = driver.getWindowHandles();

		for (String win : windows2) {
			if (win != parentWindow) {
				driver.switchTo().window(win);
			}
		}

		Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(), "This is a sample page");
		driver.close();

		driver.switchTo().window(parentWindow);
		
		//***************MODAL HANDLING****************
		driver.get("https://demoqa.com/modal-dialogs");
		
		//scroll
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("modalWrapper")));
		
		driver.findElement(By.id("showSmallModal")).click();

		//close by locator identification
		driver.findElement(By.id("closeSmallModal")).click();
		
		//quit the browser
		driver.quit();
		

	}

}
