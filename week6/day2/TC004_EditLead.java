package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC004_EditLead extends ProjectSpecificMethod {

	@Test(dataProvider = "sendData")
	public void runEditLead(String username, String password, String phno, String cname) throws InterruptedException, IOException {
		
		new LoginPage(driver)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickCrmsfa()
		.clickLeadsTab()
		.clickFindLeadLink()
		.clickPhoneTab()
		.enterPhno(phno)
		.clickFindLeadsBtn()
		.clickFirstLeadId()
		.clickEditLink()
		.updateCompanyName(cname)
		.clickUpdateBtn()
		.getLeadId();
		
	}
	
	@BeforeTest
	public void setData() {
		fileName = "EditLead";
		testcaseName ="TC004_Edit_Lead";
		testcaseDesc = "Edit Lead testcase with valid credentials";
		authorName = "Sharmila";
		categoryName = "Functional";
	}
}
