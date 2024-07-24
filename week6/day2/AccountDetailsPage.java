package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class AccountDetailsPage extends ProjectSpecificMethod {

	public AccountDetailsPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public AccountDetailsPage getAccName() throws IOException {
		try {
			String AccountName = driver.findElement(By.xpath("//span[text()='Account Name']/following::span")).getText();
			System.out.println("Account Name : " + AccountName);
			String AccountID = AccountName.replaceAll("[^0-9]", "");
			System.out.println("Account ID : " + AccountID);
			reportStep("pass", "Account Name and Account ID captured successfully : "+AccountID+"and"+AccountName);
		} catch (Exception e) {
			reportStep("fail", "unable to capture Account ID");
		}
		return this;
	}

}
