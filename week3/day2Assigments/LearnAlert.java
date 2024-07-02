package week3.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String name = "Sharmila";

		driver.findElement(By.xpath("//h5[contains(text(),'Prompt')]/following::span[text()='Show']")).click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.sendKeys(name);
		al.dismiss();
		String text = driver.findElement(By.id("confirm_result")).getText();
		System.out.println(text);

		if (text.equals(name)) {
			System.out.println("Prompt Verified");
		} else {
			System.out.println("Prompt Text mismatch");
		}
		driver.close();
	}

}
