package tests.Day11_Actions_FileUploadDownload_Robot;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Filedownload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 // Step 1: Set custom download folder
        String downloadPath = "C:\\Downloads";  // Make sure this folder exists

        // Step 2: ChromeOptions to set download location
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        // Step 3: Launch driver with options
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Step 4: Navigate to site and click download
        driver.get("https://demoqa.com/upload-download");
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("downloadButton")));
        driver.findElement(By.id("downloadButton")).click();
        

        // Step 5: Wait for download (basic sleep or advanced polling)
        Thread.sleep(4000); 

        // Step 6: Check if file downloaded
        File downloadedFile = new File(downloadPath + "\\sampleFile.jpeg");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully: " + downloadedFile.getName());
            // Optionally delete
            downloadedFile.delete();
        } else {
            System.out.println("File not found in download folder.");
        }

        // Step 7: Close browser
        driver.quit();
		
	}

}
