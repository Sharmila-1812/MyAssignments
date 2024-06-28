package week2.day5Marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PVRCinemasMarathon {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter the details like City, Date, Time
		driver.findElement(By.xpath("//input[@placeholder='Search for city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@role='option']")).click();
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Select Date']")).click();
		driver.findElement(By.xpath("//li[@role='option']/span[contains(text(),'Tom')]")).click();
		driver.findElement(By.xpath("//span[text()='Select Movie']")).click();
		driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Select Timing']")).click();
		driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
		//Click Book Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Accept the terms and conditions
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		//Select any one Available Seat
		driver.findElement(By.xpath("(//span[@class='seat-current-pvr'])[1]")).click();
		//Get the Movie Info - Booking Summary
		String Name = driver.findElement(By.xpath("//h3[text()='Booking Summary']/following::h5")).getText();
		System.out.println("Name of the Movie: " + Name);
		System.out.println("Movie Info :");
		List<WebElement> info = driver.findElements(By.xpath("//h3[text()='Booking Summary']/following::li"));
		for (WebElement e : info) {
			System.out.println(" " + e.getText());
		}
		List<WebElement> LocInfo = driver.findElements(By.xpath("//h3[text()='Booking Summary']/following::p"));
		for (WebElement e1 : LocInfo) {
			System.out.println(" " + e1.getText());
		}
		String Total = driver.findElement(By.xpath("//h6[text()='Grand Total']/following::h6")).getText();
		System.out.println("Grand Total: " + Total);
		//Click Proceed
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		//Enter Mobile Number
		driver.findElement(By.xpath("(//input[@id='mobileInput'])[2]")).sendKeys("9876543210");
				//input[@id='mobileInput' and @data-gtm-form-interact-field-id='1']"))
				// driver.findElement(By.id("mobileInput")).sendKeys("9876543210");
		Thread.sleep(3000);
		//Close the popup
		driver.findElement(By.xpath("(//div[@class='cross-icon mx-2'])[2]")).click();
		// driver.switchTo().alert().dismiss();
		//Get the Title of the Current page
		String title = driver.getTitle();
		System.out.println("Title of Current Page : " + title);
		//Close the Browser
		driver.close();

	}
}
/*  **********Output:************
 * Name of the Movie: KALKI 2898 AD
Movie Info :
 U/A
 Sci-Fi
 Tamil
 Sat, 29 Jun, 10:45 AM - 2:29 PM
 INOX National,Virugambakkam Chennai
 PREMIERE
 A9
 95.12
Grand Total: 117.54
Title of Current Page : PVR Cinemas
 */
