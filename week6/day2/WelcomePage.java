package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class WelcomePage extends ProjectSpecificMethod {

	public WelcomePage(ChromeDriver driver) {
		this.driver = driver;
	}

	public HomePage clickCrmsfa() throws IOException {
		try {
			driver.findElement(By.xpath("//a[contains(text(),\"CRM\")]")).click();
			reportStep("pass", "CRM/SFA Clicked successfully");
		} catch (Exception e) {
			reportStep("fail+", "unable to click CRM/SFA");
			
		}

		return new HomePage(driver);
	}

	public LoginPage clickLogout() {

		return new LoginPage(driver);
	}

}
