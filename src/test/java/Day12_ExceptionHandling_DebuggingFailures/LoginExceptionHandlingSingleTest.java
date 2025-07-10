package Day12_ExceptionHandling_DebuggingFailures;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginExceptionHandlingSingleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;

        try {
            System.out.println("🚀 Test started");

          
            // replace with actual path
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://practicetestautomation.com/practice-test-login/");
            System.out.println("Opened login page");

            // Edge case: blank username
            String username = "";
            String password = "Password123";
            if (username.isEmpty()) {
                throw new BlankUsernameException("Username cannot be blank!");
            }

            // Positive test
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            boolean logoutVisible = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
            if (logoutVisible) {
                System.out.println("Positive test passed: Login successful");
            }

            // Negative test
            driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("WrongPassword");
            driver.findElement(By.id("submit")).click();

            String errorText = driver.findElement(By.id("error")).getText();
            System.out.println(" Negative test passed: error shown → " + errorText);

        } catch (BlankUsernameException e) {
            System.out.println(" Edge case caught: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            takeScreenshot(driver, "NoSuchElementException");
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
            takeScreenshot(driver, "GeneralException");
        } finally {
            if (driver != null) driver.quit();
            System.out.println(" Test ended");
        }
    }

    public static void takeScreenshot(WebDriver driver, String filePrefix) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            File dest = new File("Screenshots/" + filePrefix + "_" + timestamp + ".png");
            dest.getParentFile().mkdirs(); // make sure folder exists
            src.renameTo(dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(" Failed to save screenshot: " + e.getMessage());
        }

	}

}
