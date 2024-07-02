package week2.day4Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateAJIO {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.findElement(By.id("closeBtn")).click();
		//Search for Bags and choose Gender, Category
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='gender']//following::label[contains(text(),'Men')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='category']//following::label[contains(text(),'Fashion')]")).click();
		Thread.sleep(2000);
		//To get count of Bags available
		String Result = driver.findElement(By.xpath("(//div[@class=' info search-info']//following::strong)[1]"))
				.getText();
		System.out.println("Count of Bags : "+Result);
		System.out.println("---------------------List of Bag Brand Names--------------------");
		List<WebElement> Names = driver.findElements(By.xpath("//div[contains(@class,'brand')]"));
		for (WebElement BrndList : Names) {

			System.out.println(BrndList.getText());

		}
		System.out.println("---------------------List of Bag Names--------------------");
		List<WebElement> Bag = driver.findElements(By.xpath("//div[contains(@class,'name')]"));
		for (WebElement BagList : Bag) {

			System.out.println(BagList.getText());

		}
		driver.close();
	}
}
