package week3.day3Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CryptoWebTable {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://finance.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		WebElement market = driver.findElement(By.xpath("//span[text()='Markets']"));
		action.moveToElement(market).perform();
		
		driver.findElement(By.xpath("//span[text()='Markets']/following::div[text()='Crypto']")).click();
		driver.findElement(By.xpath("//span[@data-test='showRows-select-selected']")).click();
		driver.findElement(By.xpath("//span[text()='Show 100 rows']")).click();
		Thread.sleep(4000);		
		// Now get all the TR elements from the table in the List and print size of "tr"rows
		System.out.println("--------Names of CryptoCurrencies----------");
		List<WebElement> allRows = driver.findElements(By.xpath("//table//tr"));
		int rowSize = allRows.size();
		System.out.println("Row count: " + rowSize);
		// Print the Names of Crypto using td
		for (int i = 1; i < rowSize; i++) {
			String CryptoName = driver.findElement(By.xpath("(//td[@aria-label='Name'])[" + i + "]")).getText();
			System.out.println(i + " -->> " + CryptoName);
		}

		driver.quit();
	}
}

/*
 * //Grab the table WebElement table =
 * driver.findElement(By.id("searchResultsGrid")); //WebElement table =
 * driver.findElement(By.className("W(100%)")); //Now get all the TR elements
 * from the table List<WebElement> allRows =
 * table.findElements(By.tagName("tr")); //And iterate over them, getting the
 * cells for (WebElement row : allRows) { List<WebElement> cells =
 * row.findElements(By.tagName("td")); for (WebElement cell : cells) {
 * System.out.println("content >>   " + cell.getText()); } }
 */