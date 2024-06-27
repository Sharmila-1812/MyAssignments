package week2.day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnButtons {

	public static void main(String[] args) throws InterruptedException {
		
		// To Launch Browser,Load URL, maximize and implicitly wait
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// To Click Button
		driver.findElement(By.xpath("//button[contains(@class,'ly mr-2')]")).click();
		// To Get Title and Verify
		String title = driver.getTitle();
		if (title.equals("Dashboard")) {
			System.out.println("Title Verified: " + title);
		} else {
			System.out.println("Title Mismatch: " + title);
		}
		// To go back to the Launch URL
		// driver.get("https://www.leafground.com/button.xhtml");
		driver.navigate().back();
		// To check Button Enabled or Disabled
		boolean Enabled = driver.findElement(By.xpath("//button[contains(@class,'ui-state-disabled')]")).isEnabled();
		if (Enabled == true) {
			System.out.println("Button is Enabled");
		} else {
			System.out.println("Button is Disabled");
		}
		// To Get Position of button
		Point location = driver
				.findElement(By.xpath("//span[contains(@class,'left')]/following-sibling::span[text()='Submit']"))
				.getLocation();
		System.out.println("Location of Submit: " + location);
		// To get Background Color of Button
		String cssValue = driver.findElement(By.xpath("//button[contains(@class,'ry mr-2 mb-2')]"))
				.getCssValue("background-color");
		System.out.println("Background Color: " + cssValue);
		// To get height and width of Button
		Dimension size = driver
				.findElement(By.xpath("//span[contains(@class,'right')]/following-sibling::span[text()='Submit']"))
				.getSize();
		System.out.println("Size of Submit Button: " + size);
		// To Close the Browser
		driver.close();

	}

}
