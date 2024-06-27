package week2.day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnRadioButton {

	public static void main(String[] args) {
		// To Launch Browser,Load URL, maximize and implicitly wait
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Select your Favorite Browser
		// div[@class='ui-radiobutton ui-widget']/following::label[text()='Chrome']
		WebElement FavBrowser = driver.findElement(By.xpath("//label[text()='Chrome']"));
		FavBrowser.click();
		// Unselectable
		WebElement Unselect = driver.findElement(By.xpath("//label[text()='Chennai']"));
		Unselect.click(); // Select Chennai
		Unselect.click(); // Deselect Chennai
		if (Unselect.isSelected() == true) {
			System.out.println("Chennai is Selected");
		} else {
			System.out.println("Chennai is Unselected");
		}
		// Identify the Default Browser
		boolean DefaultBrowser = driver
				.findElement(By.xpath(
						"//h5[contains(text(),'Find the default')]/following::div[contains(@class,'default ui')]"))
				.isEnabled();
		String DefaultOption = null;
		if (DefaultBrowser == true) {
			DefaultOption = driver
					.findElement(By.xpath("//h5[contains(text(),'default')]/following::input[@checked='checked']"))
					.getAttribute("value");
			System.out.println(DefaultOption);
		}

		if (DefaultOption.equals("Option1")) {
			System.out.println("Chrome is Default");
		} else if (DefaultOption.equals("Option2")) {
			System.out.println("Firefox is Default");
		} else if (DefaultOption.equals("Option3")) {
			System.out.println("Safari is Default");
		} else if (DefaultOption.equals("Option4")) {
			System.out.println("Edge is Default");
		}
		// Check and Select Age Group
		boolean AgeRadio = driver
				.findElement(By.xpath("//h5[contains(text(),'age')]/following::label[text()='21-40 Years']"))
				.isEnabled();
		if (AgeRadio == true) {
			System.out.println("Age 21-40 years is already Selected");
		} else {
			driver.findElement(By.xpath("//h5[contains(text(),'age')]/following::label[text()='21-40 Years']")).click();
			System.out.println("Now only Age 21-40 years is Selected");
		}
		// Close the Browser
		driver.close();
	}

}
