package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC003_CreateAccount extends ProjectSpecificMethod {

	@Test(dataProvider = "sendData")
	public void run_CreateAccount(String username,String password, String accName,String desc,String empCount,String siteName) throws IOException {
		new LoginPage(driver)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickCrmsfa()
		.clickAccountsTab()
		.clickCreateAccountLink()
		.enterAccountName(accName)
		.enterDescription(desc)
		.enterNo_of_Employees(empCount)
		.enterSiteName(siteName)
		.clickCreateAccountBtn()
		.getAccName();
		
	}
	
	@BeforeTest
	public void setData() {
		fileName = "CreateAccount";
		testcaseName ="TC003_Create_Account";
		testcaseDesc = "Create Account testcase with valid credentials";
		authorName = "Sharmila";
		categoryName = "Functional";
	}
}
