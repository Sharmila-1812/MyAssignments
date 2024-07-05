package week3.day4Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonActionCls {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Search for Product and get Product Price and Ratings
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String firstPdtPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of First Product : " + firstPdtPrice);
		WebElement Cust = driver.findElement(By.xpath("(//i[contains(@class,'star-small')])[1]"));
		Cust.click();
		String CustRatings = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText();
		System.out.println("Customer Ratings : " + CustRatings);
		//Click on the Product Link and move to next Window
		driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//a")).click();
		Set<String> PdtWin = driver.getWindowHandles();
		List<String> ProdWin = new ArrayList<String>(PdtWin);
		driver.switchTo().window(ProdWin.get(1));
		//Add to cart and get Sub Total using Explicit wait
		driver.findElement(By.id("add-to-cart-button")).click();
		WebElement Sub = driver.findElement(By.id("attach-accessory-cart-subtotal"));
		wait.until(ExpectedConditions.visibilityOf(Sub));
		String SubTotal = Sub.getText();
		System.out.println("Sub Total of the Product : " + SubTotal);
		//Verify Total and SubTotal
		if (SubTotal.contains(firstPdtPrice)) {
			System.out.println("Amount Verified");
		} else {
			System.out.println("Amount Mismatch");
		}
		driver.quit();

	}

}
