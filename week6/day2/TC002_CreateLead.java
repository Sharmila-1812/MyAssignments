package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC002_CreateLead extends ProjectSpecificMethod {
	@Test(dataProvider = "sendData")
	public void runCreateLead(String cname,String fname,String lname) throws IOException {
		
		new LoginPage(driver)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickCrmsfa()
		.clickLeadsTab()
		.clickCreateLeadLink()
		.enterCompanyName(cname)
		.enterFirstName(fname)
		.enterLastName(lname)
		.clickCreateLeadBtn()
		.getLeadId();
		
	}
	@BeforeTest
	public void setData() {
		fileName = "CreateLead";
		testcaseName ="TC002_Create_Lead";
		testcaseDesc = "Create Lead testcase with valid credentials";
		authorName = "Sharmila";
		categoryName = "Functional";
	}

}
