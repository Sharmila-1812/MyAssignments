package week5.day5Marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SFCreateOpportunities extends ProjectSpecificBase {
	
@Test(dataProvider = "sendData",
		groups={"SFCreate"})
public void runCreateOpportunities(String Name,String CDate,String Amount) throws InterruptedException {
			Thread.sleep(3000);
			WebElement OppDD = driver
					.findElement(By.xpath("//span[contains(text(),'Opportunities')]/following::span[contains(text(),'Opportunities List')]"));
			wait.until(ExpectedConditions.elementToBeClickable(OppDD));
			driver.executeScript("arguments[0].click();", OppDD);
			
			WebElement NewOpp = driver.findElement(By.xpath("//span[text()='New Opportunity']"));
			wait.until(ExpectedConditions.elementToBeClickable(NewOpp));
			driver.executeScript("arguments[0].click();", NewOpp);
			
			driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input")).sendKeys(Name);
			driver.findElement(By.xpath("//label[text()='Close Date']/following::input")).sendKeys(CDate);
			driver.findElement(By.xpath("//label[text()='Amount']/following::input")).sendKeys(Amount);
			
			WebElement Stage = driver.findElement(By.xpath("//label[text()='Stage']/following::button"));
			wait.until(ExpectedConditions.elementToBeClickable(Stage));
			driver.executeScript("arguments[0].click();", Stage);
			//Thread.sleep(5000);
			
			//driver.findElement(By.xpath("//span[text()='Needs Analysis']")).click();
			WebElement Needs = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
			/*
			 * wait.until(ExpectedConditions.visibilityOf(Needs)); Thread.sleep(3000);
			 * driver.executeScript("arguments[0].click();", Needs);
			 */
			Needs.click();
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			
			
			String OppName = driver.findElement(By.xpath("//*[text()='Opportunity']/following::*[@slot='primaryField']")).getText();
			System.out.println("Opportunity Name: "+OppName);
			
}
@BeforeTest
public void setData() {
	fileName = "CreateOpp";
}

}
