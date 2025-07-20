package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

	private WebDriver driver;

    private By successMessageLocator = By.cssSelector(".post-title");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        String msg = driver.findElement(successMessageLocator).getText();
        System.out.println("Success message from SecureAreaPage: " + msg);
        return msg;
    }
}
