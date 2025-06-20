package tests;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//WebDriver Methods, Browser Navigationmethods, Window handling
public class Day2BrowserNavigation {
	public static void main(String args[]) throws Exception{

		// Launch browser using Chrome Driver
		WebDriver driver = new ChromeDriver();

		// Navigate to the practice website
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		// maximize the current widow
		driver.manage().window().maximize();

		// get page title and print it
		System.out.println(driver.getTitle());

		// get current url and print it
		System.out.println(driver.getCurrentUrl());

		// refresh the page
		driver.navigate().refresh();

		// naviagate to google
		driver.navigate().to("https://www.google.com/");

		// implicit wait for google page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		// get page title and print it
		System.out.println(driver.getTitle());

		// get current url and print it
		System.out.println(driver.getCurrentUrl());
		
		//navigate back
		driver.navigate().back();
		
		//navigate forward
		driver.navigate().forward();
		
		//navigate back to original page
		driver.navigate().back();
		
		//scroll to the bottom
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		//taking screenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File("/screenshots/day2_scroll.png"));
		
		//scroll to the openwindow button
		WebElement openWindow=driver.findElement(By.id("openwindow"));
		js.executeScript("arguments[0].scrollIntoView(true);", openWindow);
		
		//click on open window
		openWindow.click();
		
		//get the window handles
	    Set<String> windows=driver.getWindowHandles();
	    
	    //initialize an iterator for the windows
		Iterator<String> it=windows.iterator();
		
		//get the id of parent window
		String parent=it.next();
		
		//get the id of child window
		String child=it.next();
		
		//switch to child
		driver.switchTo().window(child);
		
		//close the current window
		driver.close();
		
		//switch back to parent window
		driver.switchTo().window(parent);
		//check if element is displayed 
		boolean res=driver.findElement(By.className("inputs")).isDisplayed();
		Assert.assertTrue(res);
		
		driver.quit();
	}
}
