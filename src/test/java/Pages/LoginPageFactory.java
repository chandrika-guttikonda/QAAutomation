package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	

//each method is returning this cause this returns current instance of the method so the methods will run continuously with out calling

	private WebDriver driver;

    // Elements
    @FindBy(id="username")
    private WebElement usernameField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="submit")
    private WebElement submitButton;

    @FindBy(css=".post-title")
    private WebElement successMessage;

    By error=By.id("error");

    // Constructor: initialize PageFactory
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public LoginPageFactory enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Entered username: " + username);
        return this;
    }

    public LoginPageFactory enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password: " + password);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
        System.out.println("Clicked Submit button");
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getErrorMessage() {
    	WebElement errorMessage=driver.findElement(error);
    	System.out.println(errorMessage.getText());
        return errorMessage.getText();
    }
}
