package tests.Day11_Actions_FileUploadDownload_Robot;

import java.awt.datatransfer.StringSelection;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		// Navigate to the practice website
		driver.get("https://demo.guru99.com/test/upload/");

		driver.manage().window().maximize();
		
		String filePath="D:\\QAQuestions\\Definitions";
		StringSelection selection=new StringSelection(filePath);
		
		
		WebElement chooseFile=driver.findElement(By.className("upload_txt"));
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		
		chooseFile.sendKeys("D:\\QAQuestions\\Definitions.docx");
		
		driver.findElement(By.id("submitbutton")).click();
		
		driver.quit();
		
		
		//upload file function using robot class if upload tah is not input type=file
		
		/*chooseFile.click();
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

//button//span[text()='Choose Files']
		try {
	    Robot robot = new Robot();
	    robot.delay(2000);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_C);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_C);
	    
	    robot.delay(500);  // Optional: give small delay

	    // Press Enter
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);

	    Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("file upload not happened");
		}*/
		
	   

	}

}
