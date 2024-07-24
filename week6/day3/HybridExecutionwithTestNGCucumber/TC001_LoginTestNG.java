package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC001_LoginTestNG extends ProjectSpecificMethod{

	
	@Test//(dataProvider = "sendData")
	public void runLogin() throws IOException {
		
		LoginPage lp = new LoginPage();		
		lp.enterUsername()
		.enterPassword()
		.clickLogin();
		}
	
	
	@BeforeTest
	public void setData() {
		//fileName = "Login";
		testcaseName ="TC001_Login";
		testcaseDesc = "Login testcase with valid credentials";
		authorName = "Sharmila";
		categoryName = "Functional";
	}
	
}
