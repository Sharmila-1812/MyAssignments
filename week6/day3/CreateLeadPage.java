package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateLeadPage extends ProjectSpecificMethod{

	/*
	 * public CreateLeadPage(ChromeDriver driver) { this.driver=driver; }
	 */
	@Given ("Enter the Company Name")
	public CreateLeadPage enterCompanyName() throws IOException {
	
		try {
			driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(prop.getProperty("cname"));
			reportStep("pass", "Company Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter Company name");
		} 

		return this;
	}
	
	@Given ("Enter the First Name")
	public CreateLeadPage enterFirstName() throws IOException {
		try {
			driver.findElement(By.xpath("(//input[contains(@id,'firstName')])[1]")).sendKeys(prop.getProperty("fname"));
			reportStep("pass", "First Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter First name");
		}// Partial
		
		return this;
	}
	
	@Given("Enter the Last Name")
	public CreateLeadPage enterLastName() throws IOException {
		try {
			driver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys(prop.getProperty("lname"));
			reportStep("pass", "Last Name entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter Last Name");
		}
		
		return this;
	}
	@When("Click Submit")
	public ViewLeadPage clickCreateLeadBtn() throws IOException {
		try {
			driver.findElement(By.xpath("//input[contains(@value,'Create Lead')]")).click();
			reportStep("pass", "Create Lead Button clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click create lead button");
		}
		return new ViewLeadPage();
	}
	
	
	
}
