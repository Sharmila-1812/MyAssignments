package week5.day5Marathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

//import utils.LearnExcelcopy;

public class ProjectSpecificBase {

	// ChromeDriver driver;
		public RemoteWebDriver driver;
		public WebDriverWait wait;
		public String fileName;
		//public String OppName;

		@Parameters({ "username", "password", "url", "browser" })
		@BeforeMethod
		public void preCondition(String uName, String pwd, String url, String browser) {
			//Use Switch Case to use browser
			switch (browser) {
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				break;
			case "edge":
				EdgeOptions options1 = new EdgeOptions();
				options1.addArguments("--disable-notifications");
				driver = new EdgeDriver(options1);
				break;
				default:
					InternetExplorerOptions options2= new InternetExplorerOptions();
					options2.addCommandSwitches("--disable-notifications");
					driver= new InternetExplorerDriver(options2);
			}

			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.findElement(By.id("username")).sendKeys(uName);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.id("Login")).click();
			driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			WebElement Opp = driver.findElement(By.xpath("//p[text()='Opportunities']"));
			wait.until(ExpectedConditions.elementToBeClickable(Opp));
			driver.executeScript("arguments[0].click();", Opp);
		}

		@AfterMethod
		public void postCondition() {
			// Close the Browser
			driver.close();

		}
		@DataProvider
		public String[][] sendData() throws IOException {

			return LearnExcelcopy.readExcel(fileName);
		}
}
