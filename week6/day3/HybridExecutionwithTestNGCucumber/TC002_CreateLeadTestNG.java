package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;


public class TC002_CreateLeadTestNG extends ProjectSpecificMethod {

	@Test
	public void runCreateLead() throws IOException {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickCrmsfa()
		.clickLeadsTab()
		.clickCreateLeadLink()
		.enterCompanyName()
		.enterFirstName()
		.enterLastName()
		.clickCreateLeadBtn()
		.getLeadId();
	}
	@BeforeTest
	public void setData() {
		// fileName = "CreateLead";
		testcaseName = "TC002_Create_Lead";
		testcaseDesc = "Create Lead testcase with valid credentials";
		authorName = "Sharmila";
		categoryName = "Functional";
	}

}
