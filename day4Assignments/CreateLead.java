package week1.day4Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sharmila");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("devi");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Test");

		driver.findElement(By.className("smallSubmit")).click();

		Thread.sleep(5000);
		String ExpectedTitle = "View Lead | opentaps CRM";
		String title = driver.getTitle();
		System.out.println("Title of the Page:" + title);

		if (ExpectedTitle.equals(title)) {
			System.out.println("Expected and Actual Title Matched");
		} else {
			System.out.println("Expected and Actual Title Mismatch");
		}
		driver.close();
		//driver.quit();

	}
}
