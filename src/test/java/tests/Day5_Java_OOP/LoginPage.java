package tests.Day5_Java_OOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	//Initializing private element
	private WebElement userNameEle;
	private WebElement passWordEle;
	private WebElement submitBtn;
	private String username;
	private String password;
	WebDriver driver;
	
	//**********Constructor Overloading***********
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage(WebDriver driver, String username, String password) {
        this.driver = driver;
        enterUserName(username);
        enterPassword(password);
    }
	
	//identify the element and enter username
	public void enterUserName(String username) {
		userNameEle=driver.findElement(By.id("username"));
		userNameEle.clear();
		userNameEle.sendKeys(username);
	}
	
	//identify the ele and enter password
	public void enterPassword(String password) {
		passWordEle=driver.findElement(By.id("password"));
		passWordEle.clear();
		passWordEle.sendKeys(password);
	}
	
	//********Method overloading**********
	public void submitLogin() {
		submitBtn=driver.findElement(By.id("submit"));
		submitBtn.click();
	}
	
	public void submitLogin(String username, String password) {
		userNameEle=driver.findElement(By.id("username"));
		userNameEle.clear();
		userNameEle.sendKeys(username);
		
		passWordEle=driver.findElement(By.id("password"));
		passWordEle.clear();
		passWordEle.sendKeys(password);
		submitBtn=driver.findElement(By.id("submit"));
		submitBtn.click();
	}
	
}
