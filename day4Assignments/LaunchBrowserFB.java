package week1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowserFB {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");

		driver.findElement(By.name("login")).click();
		driver.findElement(By.partialLinkText("Find your account")).click();
		String title = driver.getTitle();
		System.out.println("Title of the Page: " + title);
		driver.close();

	}

}
