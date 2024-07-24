package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class CreateAccountPage extends ProjectSpecificMethod {

	public CreateAccountPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public  CreateAccountPage enterAccountName(String AccName) throws IOException {
		try {
			driver.findElement(By.id("accountName")).sendKeys(AccName);
			reportStep("pass", "Account Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter account name");
		}
		return this;
	}
	
	public CreateAccountPage enterDescription(String Description) throws IOException {
		try {
			driver.findElement(By.name("description")).sendKeys(Description);
			reportStep("pass", "Description entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter Description");
		}
		return this;
		
	}
	public CreateAccountPage  enterNo_of_Employees(String EmpCount) throws IOException {
		try {
			driver.findElement(By.id("numberEmployees")).sendKeys(EmpCount);
			reportStep("pass", "Employee Count entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter Employee count");
		}
		return this;
	}
	public CreateAccountPage enterSiteName(String siteName) throws IOException {
		try {
			driver.findElement(By.id("officeSiteName")).sendKeys(siteName);
			reportStep("pass", "Site Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter Site Name");
		}
		return this;
	}
	
	public AccountDetailsPage clickCreateAccountBtn() throws IOException {
	try {
		driver.findElement(By.className("smallSubmit")).click();
		reportStep("pass", "Create Account Clicked Successfully");
	} catch (Exception e) {
		reportStep("fail", "unable to click Create Account");
	}
	return new AccountDetailsPage(driver);
	}
	
}

