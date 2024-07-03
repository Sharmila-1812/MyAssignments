package week3.day3Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter Username,Pwd and Login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		// click CRM/SFA,Contacts and Merge Contacts
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		// click on Contact From Widget
		driver.findElement(By.xpath("//input[@id='partyIdFrom']//following::img[@alt='Lookup']")).click();
		// Handle window and go to Find Contacts window and Click first result
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> contactWin = new ArrayList<String>(windowHandles);
		driver.switchTo().window(contactWin.get(1));
		driver.findElement(By.xpath("(//div[contains(@class,'col-partyId')]/a)[1]")).click();
		// Go to Parent window
		driver.switchTo().window(contactWin.get(0));
		// Handle window and go to Find Contacts window and Click second result
		driver.findElement(By.xpath("//input[@id='partyIdTo']//following::img[@alt='Lookup']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> contactWin1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(contactWin1.get(1));
		driver.findElement(By.xpath("(//div[contains(@class,'col-partyId')]/a)[2]")).click();
		// Go to Parent window
		driver.switchTo().window(contactWin1.get(0));
		// Click Merge button
		driver.findElement(By.linkText("Merge")).click();
		// Accept the alert
		driver.switchTo().alert().accept();
		// Get Title of Current Page
		String title = driver.getTitle();
		System.out.println("Title of the Current Page :" + title);
		// Verify Page Title
		if (title.contains("View Contact")) {
			System.out.println("Page Title Verified : " + title);
		} else {
			System.out.println("Page Title Mismatch : " + title);
		}
		// Close the Browser
		driver.close();
	}

}
