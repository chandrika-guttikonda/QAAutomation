package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Day8_SeleniumSmartWaits {

    static WebDriver driver;
    static WebDriverWait explicitWait;

    public static void main(String[] args) {
        try {
            setup();
            testEnableInputWithExplicitWaitAndRetry();
            testRemoveCheckboxWithFluentWait();
            testAddCheckboxAndHandleStaleElement();
        } finally {
            teardown();
        }
    }

    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    public static void testEnableInputWithExplicitWaitAndRetry() {
        System.out.println("Running: testEnableInputWithExplicitWaitAndRetry");
        WebElement enableBtn = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enableBtn.click();

        WebElement message = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        if (!message.getText().equals("It's enabled!")) {
            System.out.println(" Message text mismatch!");
        }

        int retries = 3;
        boolean success = false;
        while (retries > 0 && !success) {
            try {
                WebElement inputBox = driver.findElement(By.xpath("//form[@id='input-example']/input"));
                inputBox.sendKeys("Hello, automation!");
                String value = inputBox.getAttribute("value");
                if ("Hello, automation!".equals(value)) {
                    success = true;
                    System.out.println(" Text entered successfully.");
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying input due to stale element...");
                retries--;
            }
        }

        if (!success) {
            System.out.println(" Input field interaction failed after retries.");
        }
    }

    public static void testRemoveCheckboxWithFluentWait() {
        System.out.println("Running: testRemoveCheckboxWithFluentWait");
        WebElement removeBtn = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        removeBtn.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

        WebElement message = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement msg = driver.findElement(By.id("message"));
                if (msg.isDisplayed() && msg.getText().contains("It's gone!")) {
                    return msg;
                }
                return null;
            }
        });

        if (message != null && message.getText().equals("It's gone!")) {
            System.out.println(" Message appeared: It's gone!");
        } else {
            System.out.println(" Message did not appear as expected.");
        }

        if (driver.findElements(By.id("checkbox")).size() == 0) {
            System.out.println(" Checkbox removed from DOM.");
        } else {
            System.out.println(" Checkbox still present.");
        }
    }

    public static void testAddCheckboxAndHandleStaleElement() {
        System.out.println("Running: testAddCheckboxAndHandleStaleElement");
        WebElement addBtn = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        addBtn.click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

        int attempts = 3;
        boolean clicked = false;

        while (attempts > 0 && !clicked) {
            try {
                WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
                checkbox.click();
                if (checkbox.isSelected()) {
                    clicked = true;
                    System.out.println(" Checkbox selected successfully.");
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Retry due to stale checkbox...");
                attempts--;
            }
        }

        if (!clicked) {
            System.out.println(" Failed to click checkbox after retries.");
        }
    }

    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
