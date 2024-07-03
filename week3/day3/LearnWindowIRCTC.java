package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindowIRCTC {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[contains(@class,'menu-list')]/following::a[contains(text(),'FLIGHTS')]"))
				.click();
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Size of Windows: "+windowHandles.size());	
		List<String> win = new ArrayList<String>(windowHandles);
		driver.switchTo().window(win.get(1));
		System.out.println("Title of Current Page :" + driver.getTitle());
		driver.switchTo().window(win.get(0));
		driver.close();
	}

}
