package testcases;

import org.testng.annotations.BeforeTest;

import base.ProjectSpecificMethod;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/features/CreateLead.feature" },
				glue = { "pages" })
public class TC002_CreateLead extends ProjectSpecificMethod {

	@BeforeTest
	public void setData() {
		// fileName = "CreateLead";
		testcaseName = "TC002_Create_Lead";
		testcaseDesc = "Create Lead testcase with valid credentials";
		authorName = "Sharmila";
		categoryName = "Functional";
	}

}
