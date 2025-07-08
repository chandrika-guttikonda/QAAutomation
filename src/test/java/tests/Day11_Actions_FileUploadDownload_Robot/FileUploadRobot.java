package tests.Day11_Actions_FileUploadDownload_Robot;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadRobot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Navigate to the practice website
		driver.get("https://smallpdf.com/word-to-pdf");

		driver.manage().window().maximize();

		String filePath = "D:\\QAQuestions\\Definitions.docx";
		StringSelection selection = new StringSelection(filePath);

		WebElement chooseFile=driver.findElement(By.xpath("//button//span[text()='Choose Files']"));
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		chooseFile.click();
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		// button//span[text()='Choose Files']
		try {
			Robot robot = new Robot();
			robot.delay(2000);

			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			

			robot.delay(500); // Optional: give small delay

			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(2000);
			System.out.println("File Upload Successful");
		} catch (Exception e) {
			System.out.println("file upload not happened");
		}

		driver.quit();
	}

}
