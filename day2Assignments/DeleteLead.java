package week2.day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the url
		driver.get("http://leaftaps.com/opentaps");
		// maximize the window
		driver.manage().window().maximize();
		// Login to the leaftaps
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on crmsfa link
		driver.findElement(By.xpath("//a[contains(text(),\"CRM\")]")).click();
		// Click on the leads tab
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		// Find Lead
		driver.findElement(By.linkText("Find Leads")).click();
		// Click Phone Tab
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("987");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		// To get First Resulting Lead
		String LeadID = driver
				.findElement(By.xpath("//span[text()='Lead List']/following::table//a[contains(@href,'partyId')]"))
				.getText();
		// span[text()='Lead
		// List']/following::table[contains(@class,'table')]//td//a[contains(@href,'partyId')]
		System.out.println("First Lead ID: " + LeadID);
		driver.findElement(By.xpath("//span[text()='Lead List']/following::table//a[contains(@href,'partyId')]"))
				.click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys(LeadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		String RecList = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("No. of Records found: " + RecList);

		if (RecList.equals("No records to display")) {
			System.out.println("Lead List verified successfully");
		} else {
			System.out.println("Lead List verification failed");
		}
		driver.close();

	}
}
