package week4.day3Marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseTataCliq {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//MouseHover to Brands
		Actions action = new Actions(driver);
		WebElement Brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		action.moveToElement(Brands).perform();
		//MouseHover to Watch
		WebElement Watch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		action.moveToElement(Watch).perform();
		//Click on First Resulting Brand under Featured Brands
		driver.findElement(
				By.xpath("(//div[text()='Featured brands']/following::div[@class='DesktopHeader__brandsDetails'])[1]"))
				.click();
		//Sort by New Arrivals using Select by Value
		WebElement SortBy = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
		Select SortByDD = new Select(SortBy);
		SortByDD.selectByValue("isProductNew");
		//Click on Men Category using Explicit wait and JS Click
		WebElement Category = driver
				.findElement(By.xpath("//div[text()='Men']/preceding::div[@class='CheckBox__base']"));
		wait.until(ExpectedConditions.elementToBeClickable(Category));
		Category.click();
		Thread.sleep(5000);
		//Get the List of Prices of all watches displayed
		List<WebElement> Price = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		String Price1 = null;
		for (int i = 0; i < Price.size(); i++) {
			// action.scrollToElement(Price.get(i)).perform();
			System.out.println(Price.get(i).getText());
			Price1 = Price.get(0).getText();//Get the Price of First resulting watch
		}
		//Click on First Resulting watch link
		driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv']")).click();
		//Get the Windows count as Set and convert to List then switch to current window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		//Get the Price of the Watch in Current Window
		String PriceAmt = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		System.out.println("Price of Watch after clicking the first result : " + PriceAmt);
		//Compare the Price Amount in List and Price Amount in Current Window
		if (PriceAmt.contains(Price1)) {
			System.out.println("Amount Matched : " + PriceAmt + " == " + Price1);
		} else {
			System.out.println("Amount Mismatch: " + PriceAmt + " != " + Price1);
		}
		//Click on Add to Cart
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		//Get the Cart Count after Adding to Cart
		String CartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("Cart Count : " + CartCount);
		//Click on Cart option
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		//Close the current window
		driver.close();
		//Switch to Parent window and Close the browser
		driver.switchTo().window(window.get(0));
		driver.close();

	}

}
