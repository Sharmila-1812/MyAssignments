package week3.day4;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailWebTable {

	public static void main(String[] args) {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter From, To Station --> Clear and send values
		WebElement From = driver.findElement(By.id("txtStationFrom"));
		From.clear();
		From.sendKeys("MAS", Keys.ENTER);
		WebElement To = driver.findElement(By.id("txtStationTo"));
		To.clear();
		To.sendKeys("MDU", Keys.ENTER);
		// Sort by Date uncheck
		driver.findElement(By.id("chkSelectDateOnly")).click();
		// Get the Count of available trains using "//table//tr"
		List<WebElement> TrainList = driver
				.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr"));
		int TrainCount = TrainList.size();
		System.out.println("Count of Trains Available: " + TrainCount);
		System.out.println("---------List of Train Names----------");
		// Declare Set to find duplicates
		Set<String> OverAll = new LinkedHashSet<String>(); // OverAll Train List
		Set<String> DupTrainLst = new LinkedHashSet<String>(); // Duplicate Train List
		// To get Name List of Available trains including Duplicates
		for (int i = 1; i < TrainCount; i++) {
			String TrainNames = driver
					.findElement(By.xpath("(//table[contains(@class,'DataTable TrainList')]//tr//td[2]/a)[" + i + "]"))
					.getText();
			System.out.println(TrainNames);
			// Separate Duplicate and Available train names using Set --> Does not allow
			// duplicates
			if (OverAll.add(TrainNames) == false) {
				DupTrainLst.add(TrainNames);
			} else {
				OverAll.add(TrainNames);
			}
		}
		//Print two sets of Duplicate train names and Available train names
		System.out.println("Duplicate Train Names : " + DupTrainLst);
		System.out.println("Overall Train Available List : " + OverAll);
		// close the browser
		driver.close();
	}
}
