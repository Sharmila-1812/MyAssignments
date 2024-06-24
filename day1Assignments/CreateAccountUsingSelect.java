package week2.day1Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountUsingSelect {

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
		// Click on Accounts Tab and then Create Account
		driver.findElement(By.xpath("//a[text()=\"Accounts\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Create Account\"]")).click();
		// Enter Account Name
		WebElement EleAcctName = driver.findElement(By.xpath("//input[@id=\"accountName\"]"));
		EleAcctName.sendKeys("Sharmiladevii");
		//To get Account Name Attribute Value
		String AccName = EleAcctName.getAttribute("value");
		System.out.println(AccName);
		// Enter Description
		driver.findElement(By.xpath("//textarea[@name=\"description\"]")).sendKeys("Selenium Automation Tester");
		// Select Industry by Index
		WebElement EleIndustry = driver.findElement(By.name("industryEnumId"));
		Select IndustryDD = new Select(EleIndustry);
		IndustryDD.selectByIndex(4);
		// Select Ownership by Visible Text
		WebElement EleOwner = driver.findElement(By.name("ownershipEnumId"));
		Select OwnerDD = new Select(EleOwner);
		OwnerDD.selectByVisibleText("S-Corporation");
		// Select Source by Value
		WebElement EleSource = driver.findElement(By.id("dataSourceId"));
		Select SourceDD = new Select(EleSource);
		SourceDD.selectByValue("LEAD_EMPLOYEE");
		// Select MArketing by Index
		WebElement EleMkt = driver.findElement(By.id("marketingCampaignId"));
		Select MktDD = new Select(EleMkt);
		MktDD.selectByIndex(6);
		// Select State by Value
		WebElement EleState = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select StateDD = new Select(EleState);
		StateDD.selectByValue("TX");
		// Click Create Account
		driver.findElement(By.xpath("//input[@value=\"Create Account\"]")).click();
		//To get Account Name
		String VerifyAccName = driver.findElement(By.xpath("(//span[text()=\"Account Name\"]/following::span)[1]"))
				.getText();
        
		if (AccName.equalsIgnoreCase(VerifyAccName)) {
			System.out.println("Account Name Verified " + AccName + "--------" + VerifyAccName);
		} else {
			System.out.println("Account Name not Verified " + AccName + "--------" + VerifyAccName);
		}
		
		//driver.findElement(By.xpath("//a[text()='Deactivate Account']")).click();
		driver.close();
		

	}
	
}
