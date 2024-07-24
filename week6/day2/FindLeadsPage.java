package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class FindLeadsPage extends ProjectSpecificMethod{

	
	public FindLeadsPage(ChromeDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}


	public FindLeadsPage clickPhoneTab() throws IOException {
		try {
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			reportStep("pass", "Phone Tab clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click phone tab");
		}
		return this;
	}
	
	
	public FindLeadsPage enterPhno(String phNo) throws IOException {
		try {
			driver.findElement(By.name("phoneNumber")).sendKeys(phNo);
			reportStep("pass", "Phone Number entered successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to enter phone number");
		}
		return this;
	}
	
	
	public FindLeadsPage clickFindLeadsBtn() throws IOException {
		try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("pass", "Finds Leads Button clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click Find Leads button");
		}
		return this;
	}
	
	
	public ViewLeadPage clickFirstLeadId() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			reportStep("pass", "First Lead Link clicked successfully");
		} catch (InterruptedException e) {
			reportStep("fail", "unable to click First Lead Link");
		}
		return new ViewLeadPage(driver);
	}
	
}
