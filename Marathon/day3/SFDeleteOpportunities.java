package week5.day5Marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SFDeleteOpportunities extends ProjectSpecificBase {
	@Test(dataProvider = "sendData",
dependsOnGroups = { "SFCreate", "SFEdit" })
	public void run_DeleteOpportunities(String Name) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Name, Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		WebElement SearchName = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));//
		SearchName.clear();
		SearchName.sendKeys(Name, Keys.ENTER);
		Thread.sleep(3000);
		String VerifyOppList = driver
				.findElement(By.xpath("//div[contains(@class,'listViewContent')]//div[@role='status']")).getText();
		System.out.println("Opportunity Name List: " + VerifyOppList);
	}

	@BeforeTest
	public void setData() {
		fileName = "DeleteOpp";
	}
}
