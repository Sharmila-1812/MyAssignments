package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.When;

public class HomePage extends ProjectSpecificMethod{

	/*
	 * public HomePage(ChromeDriver driver) { this.driver=driver; }
	 */
	@When ("Click Leads Tab")
	public LeadsPage clickLeadsTab() throws IOException {
		
		try {
			driver.findElement(By.xpath("//a[text()='Leads']")).click();
			reportStep("pass", "Leads Tab clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click Leads Tab");
		}
		return new LeadsPage();
	}
	
	public AccountsPage clickAccountsTab() throws IOException {
		try {
			driver.findElement(By.xpath("//a[text()='Accounts']")).click();
			reportStep("pass", "Accounts Tab clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click Accounts Tab");
		}
		return new AccountsPage(driver);
	}
	
	
	public void clickContactsTab() {
		
	}
	
	
}
