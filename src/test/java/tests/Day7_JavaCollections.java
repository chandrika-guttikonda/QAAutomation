package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Day7_JavaCollections {
	public static void main(String args[]) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// Navigate to the practice website
		driver.get("https://practicetestautomation.com/practice-test-login/");

		driver.manage().window().maximize();
		
		// Create a List<String>: expectedFields = ["Username", "Password", "Submit"]
		List<String> expectedFields = new ArrayList<String>();
		expectedFields.add("Username");
		expectedFields.add("Password");
		expectedFields.add("Submit");

//		- Locate the Username field, Password field, and Submit button.
//		- Get their placeholders or visible labels.
//		- Store them in a List<String>: actualFields

		List<String> actualLabels = new ArrayList<String>();
		actualLabels.add(driver.findElement(By.xpath("//label[@for='username']")).getText());
		actualLabels.add(driver.findElement(By.xpath("//label[@for='password']")).getText());
		actualLabels.add(driver.findElement(By.xpath("//button[@id='submit']")).getText());

		System.out.println(actualLabels == expectedFields);
		Assert.assertEquals(actualLabels, expectedFields);

//		- Leave both username and password blank.
//		- Click the Submit button.
		driver.findElement(By.xpath("//button[@id='submit']")).click();

		//Capture all error messages
		List<String> errorMessages = Arrays.asList("Username cannot be empty", "Password cannot be empty",
				"Username cannot be empty");

		//convert it into a set
		Set<String> setError = new HashSet<String>(errorMessages);
		System.out.println(setError);

		//Print or log which ones were repeated
		//create two sets
		Set<String> unique = new HashSet<String>();
		Set<String> duplicate = new HashSet<String>();
		
		//check whether both set and list are same size
		if (setError.size() != errorMessages.size()) {

			//loop through the list
			for (String s : errorMessages) {
				
				//check if we are able to add the resource to unique set. if it is already present then the condition passes
				if (!unique.add(s)) {
					//add the duplicate set to duplicate set
					duplicate.add(s);
				}
			}
		}

		System.out.println("Unique error messages: " + unique);
		System.out.println("Duplicate error messages: " + duplicate);
		
		Map<String,String> errorMap=new HashMap<String,String>();
		errorMap.put("userName", "Your username is invalid!");
		errorMap.put("password","Your password is invalid!");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		System.out.println(driver.findElement(By.id("error")).getText());
		Thread.sleep(1000);
		Assert.assertEquals(errorMap.get("userName"), driver.findElement(By.id("error")).getText());
		
		List<String> users= Arrays.asList("", " ", "wronguser","student");
		
		for(String user:users) {
			WebElement userName=driver.findElement(By.id("username"));
			userName.clear();
			userName.sendKeys(user);
			driver.findElement(By.id("password")).sendKeys("Password123");
			driver.findElement(By.xpath("//button[@id='submit']")).click();
			List<WebElement> errors=driver.findElements(By.id("error"));
			if(errors.size()>0 && errors.get(0).isDisplayed()) {
				System.out.println(user+" triggered the error messages");
			}
		}
		

	}

}
