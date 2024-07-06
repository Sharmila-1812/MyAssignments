package week3.day4Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapdealActionCls {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Mouse Hover on Mens Fashion using Action Class
		Actions action = new Actions(driver);
		WebElement MenFash = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		action.moveToElement(MenFash).perform();
		// Click on Sports Shoes and get Count of results for Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String Count = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		System.out.println("Count of Sport Shoes available : "+Count);
		// Click on Training shoes in navigation
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		// Sort from Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		WebElement Sort = driver.findElement(By.xpath("//li[@data-sorttype='plth']"));
		Sort.click();
		// Get Sort Attribute value and check whether it is sorted properly or not
		String SortValue = Sort.getAttribute("class");
		System.out.println("Attribute Value of Sort: "+SortValue);
		if (SortValue.contains("sort-active")) {
			System.out.println("Verification Msg : Sorted from Low to High");
		} else {
			System.out.println("Verification Msg : Not Sorted Properly");
		}
		// Enter From and To Value for Price Range Filter and Click GO button
		WebElement From = driver.findElement(By.name("fromVal"));
		From.clear();
		From.sendKeys("500");
		WebElement To = driver.findElement(By.name("toVal"));
		To.clear();
		To.sendKeys("700");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		// Select any Color using Explicit wait and JS Click
		WebElement Color = driver.findElement(By.xpath("//a[contains(text(),'Black')]"));
		wait.until(ExpectedConditions.elementToBeClickable(Color));
		driver.executeScript("arguments[0].click();", Color);
		// Get the Size of Filter Applied and verify
		List<WebElement> elements = driver.findElements(By.xpath(
				"//div[@class='product-row js-product-list centerCardAfterLoadWidgets dp-click-widgets']/preceding::a[@class='clear-filter-pill']"));
		// div[@class='filters-top-selected']//div"));
		// //"(//div[@class='filters'])[1]//a"));
		int FilterSize = elements.size();
		System.out.println("Applied Filter Size : "+FilterSize);
		if (FilterSize == 2) {
			System.out.println("Verification Msg : Filter Verified");
		} else {
			System.out.println("Verification Msg : Filter not applied properly");
		}
		// Mouse hover on First Shoe and Click Quick View using Explicit wait and JS
		// Click
		WebElement FirstShoe = driver.findElement(By.xpath("(//p[@class='product-title'])[1]"));
		action.moveToElement(FirstShoe).perform();
		WebElement Quick = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(Quick));
		driver.executeScript("arguments[0].click();", Quick);
		// Get Price and Discount % from Quick View Page in List and Print
		System.out.println("----- Price and Discount % Details -----");
		List<WebElement> elements2 = driver
				.findElements(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span"));
		for (WebElement ele : elements2) {
			System.out.println(ele.getText());
		}
		// Close the Browser
		driver.close();

	}

}
