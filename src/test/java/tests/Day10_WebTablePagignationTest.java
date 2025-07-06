package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Day10_WebTablePagignationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// initialize webdriver wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Navigate to the practice website
		driver.get("https://datatables.net/examples/data_sources/ajax.html");

		// maximize browser
		driver.manage().window().maximize();

		// store table element and scroll it into view and wait for it to be present
		WebElement table = driver.findElement(By.xpath("//table[@id='example']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#example")));

		// wait for ajax to be disappeared
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("td.dataTables_empty")));
		boolean found = false;

		// start the infinte loop
		while (true) {
			// wait for the rows to be displayed
			List<WebElement> row = driver.findElements(By.xpath("//table[@id='example']/tbody//tr"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='example']/tbody//tr")));
//			
//			List<WebElement> cols = driver.findElements(By.xpath("//table[@id='example']//tr[1]//td"));
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='example']//tr[1]//td")));
			if (row.size() < 2)
				continue;
			System.out.println(row.size());
			
			//loop through the rows and find the desired name and it's position
			for (int i = 0; i < row.size(); i++) {
				WebElement col = row.get(i).findElement(By.xpath("./td[1]"));

				wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(row.get(i), By.xpath("./td[1]")));

				System.out.println(col.getText());
				if (col.getText().equalsIgnoreCase("Charde Marshall")) {
					String position = row.get(i).findElement(By.xpath("./td[2]")).getText();
					Assert.assertEquals(position, "Regional Director");
					System.out.println("found the person");
					found = true;
					break;
				}
			}
			
			//break the infinte loop if person is found
			if (found)
				break;

			//if person not found search for next button in pagignation and click on it if is not disabled
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Next']")));

			WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next']"));
			String ariaDisabled = nextBtn.getAttribute("aria-disabled");

			if (ariaDisabled != null && ariaDisabled.equals("true"))
				break;
			nextBtn.click();
			
			//wait for ajax to be disabled
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("td.dataTables_empty")));
		}

		if (!found) {
			System.out.println("Charde Marshall not found.");
		}

	}

}
