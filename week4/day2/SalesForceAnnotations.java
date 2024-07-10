package week4.day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SalesForceAnnotations extends ProjectSpecificMethod {
	@Test
	public void runSalesForce() {
		//Click of App Launcher and Legal Entities using Explicit wait and JS Click
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement legal = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		wait.until(ExpectedConditions.elementToBeClickable(legal));
		driver.executeScript("arguments[0].click();", legal);
		/*
		 * if(driver.findElement(By.xpath("//span[contains(text(),'Recently Viewed')]"))
		 * .isEnabled ()==true) { driver.findElement(By.
		 * xpath("//span[contains(text(),'Recently Viewed')]/following::*[@icon-name='utility:close']"
		 * )).click(); }*/
		 
		//Click on Legal Entities Dropdown
		WebElement LegalDD = driver
				.findElement(By.xpath("//span[contains(text(),'Legal Entities')]/following::span[contains(text(),'Legal Entities List')]"));
		wait.until(ExpectedConditions.elementToBeClickable(LegalDD));
		driver.executeScript("arguments[0].click();", LegalDD);// .click();
		//Click on New Legal Entity using Explicit wait and JS Click
		WebElement NewLegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		wait.until(ExpectedConditions.elementToBeClickable(NewLegal));
		driver.executeScript("arguments[0].click();", NewLegal);
		//Enter Company Name and Description
		driver.findElement(By.xpath("//label[text()='Company Name']/following::input")).sendKeys("Testleaf");
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Salesforces");
		//Click on Status Dropdown and select Active
		WebElement Status = driver.findElement(By.xpath("//label[text()='Status']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Status));
		driver.executeScript("arguments[0].click();", Status);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		//Click Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//Get Error Message and Verify
		driver.findElement(By.xpath("//ul[contains(@class,'errorsList')]//a")).click();
		WebElement Error = driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
		wait.until(ExpectedConditions.visibilityOf(Error));
		String ErrorMsg = Error.getText();
		System.out.println("Error Msg : "+ErrorMsg);
		if (ErrorMsg.contains("Complete this field")) {
			System.out.println("Please provide input for this field");
		} else {
			System.out.println("Entity Saved");
		}
	}
	//}
}
