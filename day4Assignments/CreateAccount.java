package week1.day4Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("Sharmilaaa");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("50");
		driver.findElement(By.id("officeSiteName")).sendKeys("Leaftaps");
		driver.findElement(By.className("smallSubmit")).click();

		Thread.sleep(5000);
		String ExpectedTitle = "Account Details | opentaps CRM";
		String title = driver.getTitle();
		System.out.println("Title of the Page:" + title);

		if (ExpectedTitle.equals(title)) {
			System.out.println("Expected and Actual Title Matched");
		} else {
			System.out.println("Expected and Actual Title Mismatch");
		}
		driver.close();
		
	}

}
