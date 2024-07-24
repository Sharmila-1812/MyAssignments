package week6.day1;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	
	public static void main(String[] args) throws IOException {
		
		//Step1: Set the file path for the report
		ExtentHtmlReporter report = new ExtentHtmlReporter("./reports/result.html");
		
		// To maintain history of report
		report.setAppendExisting(true);
		
		//Step2: Create object for ExtentReports
		ExtentReports extent = new ExtentReports();
		
		// Step3: Attach reporter path to the report
		extent.attachReporter(report);
		
		// Step4: Create report for a testcase
		ExtentTest test1 = extent.createTest("TC001_Login");
		
		// Step5: Provide/assign information to the testcase -> author, categories
		test1.assignAuthor("Gokul");
		test1.assignCategory("Regression");
		
		// Step6: Testcase status pass or fail
		test1.pass("Username entered successfully");
		test1.pass("Password entered Successfully", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img2.png").build() );
		
		test1.fail("Login is unsccessfull");
		
		
		
		ExtentTest test2 = extent.createTest("TC002_Logout","Leaftaps logout");
		test2.assignAuthor("Arun");
		test2.assignCategory("functional");
		
		test2.pass("Enter username ");
		test2.pass("Enter password");
		test2.pass("Login click button");
		test2.pass("Logout button clicked successfully", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img1.png").build());
		
		
		ExtentTest test3 = extent.createTest("TC003");
		test3.fail("No such session");
		
		//Step7: close the report
		extent.flush();
		
		System.out.println("Report generated");
	}
	
	
}
