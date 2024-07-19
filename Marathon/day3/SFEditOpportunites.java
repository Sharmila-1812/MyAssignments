package week5.day5Marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SFEditOpportunites extends ProjectSpecificBase {

	@Test(groups={"SFEdit"},
		dataProvider = "sendData", 
		dependsOnGroups = { "SFCreate" })
	public void run_EditOpportunities(String Name, String CDate, String description) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Name, Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement CloseDate = driver.findElement(By.xpath("//label[text()='Close Date']/following::input"));
		CloseDate.clear();
		CloseDate.sendKeys(CDate);
		WebElement Stage = driver.findElement(By.xpath("//label[text()='Stage']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Stage));
		driver.executeScript("arguments[0].click();", Stage);

		// driver.findElement(By.xpath("//span[text()='Needs Analysis']")).click();
		WebElement Percep = driver.findElement(By.xpath("//span[@title='Perception Analysis']"));
		// wait.until(ExpectedConditions.visibilityOf(Percep));
		// driver.executeScript("arguments[0].click();", Percep);
		Percep.click();
		// label[text()='Description']/following::textarea
		WebElement desc = driver.findElement(By.xpath("//label[text()='Description']/following::textarea"));
		wait.until(ExpectedConditions.visibilityOf(desc));
		desc.sendKeys(description);

		WebElement Status = driver
				.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Status));
		driver.executeScript("arguments[0].click();", Status);
		driver.findElement(By.xpath("//span[text()='In progress']")).click();

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(3000);
		String VerifyStage = driver.findElement(By.xpath("(//span[@data-aura-class='forceInlineEditCell'])[4]"))
				.getText();
		System.out.println("Verify Stage:" + VerifyStage);

	}

	@BeforeTest
	public void setData() {
		fileName = "EditOpp";
	}

}
