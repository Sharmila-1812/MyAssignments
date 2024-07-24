package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class LeadsPage extends ProjectSpecificMethod{

	public LeadsPage(ChromeDriver driver) {
		this.driver=driver;
	}

	public CreateLeadPage clickCreateLeadLink() throws IOException {
		
		try {
			driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
			reportStep("pass", "Create Lead Link clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click Create Lead Link");
		} 
		return new CreateLeadPage(driver);
	}
	
	public FindLeadsPage clickFindLeadLink() throws IOException {
		try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep("pass", "Find Leads Link Clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click Find Leads Link");
		}
		return new FindLeadsPage(driver);
	}
	
	
}
