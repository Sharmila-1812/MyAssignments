package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class AccountsPage extends ProjectSpecificMethod {

	public AccountsPage(ChromeDriver driver) {
		this.driver = driver;
	}

public CreateAccountPage clickCreateAccountLink() throws IOException {
		
		try {
			driver.findElement(By.xpath("//a[text()='Create Account']")).click();
			reportStep("pass", "Create Account Link clicked Successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click Create Account Link");
		} 
		return new CreateAccountPage(driver);
	}
}
