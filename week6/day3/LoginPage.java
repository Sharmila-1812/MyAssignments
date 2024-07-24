package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPage extends ProjectSpecificMethod{

	/*
	 * public LoginPage(ChromeDriver driver) { this.driver = driver; }
	 */
	@Given ("Enter the Username")
	public LoginPage enterUsername() throws IOException {
		try {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		
			reportStep("pass", "username entered successfully");
		} catch (IOException e) {
			reportStep("fail", "Unable to enter the username "+e);
		
		}
//		LoginPage lp = new LoginPage();
//		return lp;
		
//		return new LoginPage();
		
		return this;
	}
	
	@Given ("Enter the Password")
	public LoginPage enterPassword() throws IOException {
		
		try {
			driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			reportStep("pass", "password entered successfully");
		} catch (Exception e) {
			reportStep("fail", "Unable to enter the password "+e);
		}
		return this;
	}
	
	@When ("Click on Login")
	public WelcomePage clickLogin() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("pass", "Login button clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click login button "+e);
		}
		return new WelcomePage();
	}
	
}
