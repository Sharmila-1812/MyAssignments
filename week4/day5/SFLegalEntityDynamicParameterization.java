package week4.day5Assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week4.day5.LearnExcelcopy;

public class SFLegalEntityDynamicParameterization extends week4.day4Assignments.ProjectSpecificBaseMethod {
	@Test(dataProvider = "sendData")
	public void runSalesForce(String LName) throws InterruptedException {
		// Click of App Launcher and Legal Entities using Explicit wait and JS Click
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement legal = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		wait.until(ExpectedConditions.elementToBeClickable(legal));
		driver.executeScript("arguments[0].click();", legal);
		// Click on Legal Entities Dropdown
		WebElement LegalDD = driver.findElement(By.xpath(
				"//span[contains(text(),'Legal Entities')]/following::span[contains(text(),'Legal Entities List')]"));
		wait.until(ExpectedConditions.elementToBeClickable(LegalDD));
		driver.executeScript("arguments[0].click();", LegalDD);// .click();
		// Click on New Legal Entity using Explicit wait and JS Click
		WebElement NewLegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		wait.until(ExpectedConditions.elementToBeClickable(NewLegal));
		driver.executeScript("arguments[0].click();", NewLegal);
		driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following::input")).sendKeys(LName);
		System.out.println("Excel LegalName : " + LName);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		/*
		 * Thread.sleep(2000); Alert alert = driver.switchTo().alert(); String alertText
		 * = alert.getText(); System.out.println(alertText);
		 */
		String EntityName = driver
				.findElement(By.xpath("//*[text()='Legal Entity']/following::*[@slot='primaryField']")).getText();
		System.out.println("Legal Entity Name: "+EntityName);

		if (LName.equals(EntityName)) {
			System.out.println("Name Verified : " +LName+" --> "+EntityName);
		} else {
			System.out.println("Name Mismatch : " +LName+" --> "+EntityName);
		}

	}

	@DataProvider
	public String[][] sendData() throws IOException {
		return ExcelLegalName.readExcel();
	}
}