package week2.day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
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
		// Click on create lead from menu
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		// Enter the required details like first name, last name, company name etc..
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("(//input[contains(@id,'firstName')])[1]")).sendKeys("Sharmila");
		driver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys("devi");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Sharmi");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Software");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test");
		driver.findElement(By.name("primaryEmail")).sendKeys("sharmi@gmail.com");
		WebElement EleState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select StateDD = new Select(EleState);
		StateDD.selectByVisibleText("New York");
		// Click on Create Lead
		driver.findElement(By.xpath("//input[contains(@name,'submit')]")).click();
		// Click Edit Lead
		driver.findElement(By.linkText("Edit")).click();
		// Clear Description
		driver.findElement(By.id("updateLeadForm_description")).clear();
		// Enter Imp Note
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Edit Lead Test");
		// Click Update Button
		driver.findElement(By.xpath("//input[contains(@name,'submit')]")).click();
		// Get the Title
		String title = driver.getTitle();
		System.out.println("Title of the Page: " + title);
		driver.close();

	}
}
