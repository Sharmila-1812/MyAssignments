package week4.day3Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class TestCaseServiceNow {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://dev198624.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Login with the Credentials
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("B6LIoxDq=r!9");
		driver.findElement(By.id("sysverb_login")).click();
		// Shadow DOM - Shadow root is a special type of DOM which encapsulates the
		// webElements in a web page. If any web page is designed by developer with
		// Shadow DOM, then the elements cannot be located by findElement method.
		Shadow dom = new Shadow(driver);
		Thread.sleep(2000);
		//Click All and Service Catalog using dom Object 
		WebElement All = dom.findElementByXPath("//div[text()='All']");
		All.click();
		Thread.sleep(2000);
		WebElement Service = dom.findElementByXPath("//span[text()='Service Catalog']");
		Service.click();
		//Switch to Frame using Xpath
		WebElement Frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(Frame);
		//Click on Hardware, Apple Mac Book and Add to Cart
		driver.findElement(By.xpath("//h2[contains(text(),'Hardware')]")).click();
		driver.findElement(By.xpath("//strong[text()='Apple MacBook Pro 15\"']")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		//Get SubTotal of the Product
		String SubTotal = driver.findElement(By.xpath("//span[@id='price_subtotal_span']")).getText();
		System.out.println("Sub Total : " + SubTotal);
		Thread.sleep(2000);
		//Click Proceed to Check Out
		driver.findElement(By.xpath("//button[text()='Proceed to Checkout']")).click();
		//Get Request Number and Total Sum
		String ReqNum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request Number : " + ReqNum);
		String Total = driver.findElement(By.xpath("//td[@class='checkoutTotalSum']")).getText();
		System.out.println("Total : " + Total);
		//Verify SubTotal and Total
		if (SubTotal.contains(Total)) {
			System.out.println("Amount Verified - Total and SubTotal is :" + Total + " == " + SubTotal);
		} else {
			System.out.println("Amount Mismatch - Total and SubTotal is :" + Total + " != " + SubTotal);
		}
		//Take Screenshot of Checkout Page
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen1.png"));
		System.out.println("Screenshot is captured");
		driver.close();
	}

}
