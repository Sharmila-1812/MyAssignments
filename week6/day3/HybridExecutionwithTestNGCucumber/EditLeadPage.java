package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class EditLeadPage extends ProjectSpecificMethod{

	
	/*
	 * public EditLeadPage(ChromeDriver driver) { this.driver = driver; // TODO
	 * Auto-generated constructor stub }
	 */


	

	public EditLeadPage updateCompanyName(String cname) throws IOException {
		try {
			WebElement cnameField = getDriver().findElement(By.id("updateLeadForm_companyName"));
			cnameField.clear();
			cnameField.sendKeys(cname);
			reportStep("pass", "Company Name updated successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to update company name");
		}
		return this;
	}
	
	
	public ViewLeadPage clickUpdateBtn() throws IOException {
		try {
			getDriver().findElement(By.className("smallSubmit")).click();
			reportStep("pass", "Update Button Clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click update button");
		}
		return new ViewLeadPage();
	}
	
}
