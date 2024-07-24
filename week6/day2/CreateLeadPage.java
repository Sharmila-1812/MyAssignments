package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class CreateLeadPage extends ProjectSpecificMethod{

	public CreateLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}

	public CreateLeadPage enterCompanyName(String cname) throws IOException {
	
		try {
			driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(cname);
			reportStep("pass", "Company Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter Company name");
		} 

		return this;
	}
	
	public CreateLeadPage enterFirstName(String fname) throws IOException {
		try {
			driver.findElement(By.xpath("(//input[contains(@id,'firstName')])[1]")).sendKeys(fname);
			reportStep("pass", "First Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter First name");
		}// Partial
		
		return this;
	}
	
	public CreateLeadPage enterLastName(String lname) throws IOException {
		try {
			driver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys(lname);
			reportStep("pass", "Last Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter Last Name");
		}
		
		return this;
	}
	
	public ViewLeadPage clickCreateLeadBtn() throws IOException {
		try {
			driver.findElement(By.xpath("//input[contains(@value,'Create Lead')]")).click();
			reportStep("pass", "Create Lead Button clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click create lead button");
		}
		return new ViewLeadPage(driver);
	}
	
	
	
}
