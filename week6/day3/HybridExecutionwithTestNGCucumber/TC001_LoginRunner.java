package testcases;

import org.testng.annotations.BeforeTest;

import base.ProjectSpecificMethod;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/features/Login.feature" }, glue = { "pages" })
public class TC001_LoginRunner extends ProjectSpecificMethod {

	@BeforeTest
	public void setData() {
		// fileName = "Login";
		testcaseName = "TC001_Login";
		testcaseDesc = "Login testcase with valid credentials";
		authorName = "Sharmila";
		categoryName = "Functional";
	}

}
