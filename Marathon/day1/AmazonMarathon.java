package week2.day5Marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonMarathon {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Search for Bags for Boy
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for boy");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[1]")).click();
		//Get Total no.of Results
		String Results = driver
				.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
		System.out.println("Total No.of Results : "+Results);
		//Select first 2 brands
		driver.findElement(
				By.xpath("(//div[contains(@id,'brandsRefinements')]//i[@class='a-icon a-icon-checkbox'])[1]")).click();
		driver.findElement(
				By.xpath("(//div[contains(@id,'brandsRefinements')]//i[@class='a-icon a-icon-checkbox'])[2]")).click();
		//Sort By Newest Arrivals
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		//Get 1st Result Bag Details
		System.out.println("---------- First Resulting Bag ----------");
		List<WebElement> info = driver.findElements(By.xpath("(//div[contains(@class,'instructions-style')])[1]//h2"));
		// div[contains(@class,'right-micro')]//following::h2"));
		// div[@class='a-section a-spacing-small puis-padding-left-micro
		// puis-padding-right-micro']//following::h2
		for (WebElement e : info) {
			System.out.println(" " + e.getText());
		}
		//Amount of the 1st Resulting Bag
		System.out.println("------------ Discounted Price Details------------- ");
		List<WebElement> price = driver
				.findElements(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]//span"));
		for (WebElement p : price) {
			System.out.println(" " + p.getText());
		}
		//Title of the Page
		String title = driver.getTitle();
		System.out.println("Title of the Current Page : "+title);
		//Close the Browser
		driver.close();

	}

}
/* ***************************Output****************************************
 * Total No.of Results : 1-48 of over 9,000 results for "bags for boys"
 * ---------- First Resulting Bag ---------- Skybags Casual Backpack 28L, 2 Main
 * Compartments, Bottle Pocket, Front Pocket, Padded Shoulder Strap ------------
 * Discounted Price Details------------- ₹599
 * 
 * ₹599 ₹ 599 M.R.P: ₹2,100
 * 
 * ₹2,100
 * 
 * (71% off) Title of the Current Page : Amazon.in: Bags For Boys - 418063 Or
 * 58941: Bags, Wallets And Luggage
 */