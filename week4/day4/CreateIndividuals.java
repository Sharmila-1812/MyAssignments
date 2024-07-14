package week4.day5;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateIndividuals extends Base {
	/*
	 * "Test Steps: 1. Login to https://login.salesforce.com 2. Click on the toggle
	 * menu button from the left corner 3. Click View All and click Individuals from
	 * App Launcher 4. Click on the Dropdown icon in the Individuals tab 5. Click on
	 * New Individual 6. Enter the Last Name as 'Kumar' 7.Click save and verify
	 * Individuals Name"
	 * 
	 */
	@Test(dataProvider = "sendData")
	public void runCreate(String fName, String lName) {

		/*
		 * ChromeOptions option = new ChromeOptions();
		 * option.addArguments("--disable-notifications");
		 * 
		 * ChromeDriver driver = new ChromeDriver(option);
		 * 
		 * driver.get("https://login.salesforce.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * 
		 * driver.findElement(By.id("username")).sendKeys(
		 * "hari.radhakrishnan@qeagle.com");
		 * driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		 * driver.findElement(By.id("Login")).click();
		 */
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
//	driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
		WebElement clk = driver.findElement(By.xpath("//a[@title='New']"));
		driver.executeScript("arguments[0].click();", clk);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(lName);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		String message = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		System.out.println(message);// verify Individuals Name
	}

	@DataProvider
	public String[][] sendData() throws IOException {
		/*
		 * String[][] data = new String[3][2]; data[0][0] = "Sharmila"; data[0][1] =
		 * "devi"; data[1][0] = "Sanvi"; data[1][1] = "C"; data[2][0] = "Chand";
		 * data[2][1] = "Sekar";
		 * // return data;
		 */
		return LearnExcelcopy.readExcel(); // Step 4: Excel Integration - Comment existing code and call static method by
										// classname.methodname without obj and return values from excel worksheet
		

	}
}