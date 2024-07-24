package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Then;

public class ViewLeadPage extends ProjectSpecificMethod{

	/*
	 * public ViewLeadPage(ChromeDriver driver) { this.driver=driver;
	 * 
	 * }
	 */
	@Then("Verify Create Lead is Successful")
	public ViewLeadPage getLeadId() throws IOException {
		try {
			String leadId = getDriver().findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("[^0-9]", "");
			System.out.println("Lead Id: "+leadId);
			reportStep("pass", "Lead Id Captured successfully : "+leadId);
		} catch (Exception e) {
			reportStep("fail", "unable to capture Lead ID");
		}
		
		return this;
	}
	public EditLeadPage clickEditLink() throws IOException {
		try {
			getDriver().findElement(By.linkText("Edit")).click();
			reportStep("pass", "Edit Link clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click Edit Link");
		}
		return new EditLeadPage();
	}
	
	
	
}
