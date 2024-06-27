package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadUsingXpath {

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
		driver.findElement(By.xpath("//a[contains(text(),\"CRM\")]")).click(); // Partial text based

		// Click on the leads tab
		driver.findElement(By.xpath("//a[text()='Leads']")).click(); // Text based

		// Click on create lead from menu
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click(); // Text based
		//To get title using TagName
		Thread.sleep(5000);
		WebElement PageTitle = driver.findElement(By.tagName("title"));
		System.out.println(PageTitle);
		// Enter the company name
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Testleaf"); // Attribute
																										// based
		// Enter the first name
		driver.findElement(By.xpath("(//input[contains(@id,'firstName')])[1]")).sendKeys("Sharmila");// Partial
																										// attribute and
																										// collection

		// Enter the last name
		driver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys("devi");
		// Enter the phno
		driver.findElement(By.xpath("//input[contains(@id,'PhoneNum')]")).sendKeys("9876543210");
		// Source dropdown
		// Step 1 : Locate the dropdown WebElement
		WebElement sourceWE = driver.findElement(By.id("createLeadForm_dataSourceId"));
		// Step 2: Create an object for Select class (from selenium)
		Select sourceDD = new Select(sourceWE);
		// step 3: Use select method
		sourceDD.selectByIndex(5);
		// marketingCampaignId dropdown
		WebElement marketingCampaignWE = driver
				.findElement(By.xpath("//select[@id='createLeadForm_marketingCampaignId']"));
		Select marketingCampaignDD = new Select(marketingCampaignWE);
		marketingCampaignDD.selectByVisibleText("Automobile");
		// createLeadForm_currencyUomId dropdown
		WebElement currencyWE = driver.findElement(By.xpath("//select[contains(@id,'UomId')]"));
		Select currencyDD = new Select(currencyWE);
		currencyDD.selectByValue("USD");
		// Click on the Create lead btn
		driver.findElement(By.xpath("//input[contains(@name,'submit')]")).click(); // Partial Attribute based
		// close the browser
		driver.close();
	}

}
