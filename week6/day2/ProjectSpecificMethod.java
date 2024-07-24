package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.LearnExcelcopy;

public class ProjectSpecificMethod {

	public ChromeDriver driver;
	public String fileName, testcaseName, testcaseDesc, authorName, categoryName;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./result/report1.html");

		extent = new ExtentReports();

		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void setReportDetails() {
		test = extent.createTest(testcaseName, testcaseDesc);
		test.assignAuthor(authorName);
		test.assignCategory(categoryName);
	}

	@AfterSuite
	public void closeReport() {
		extent.flush();
	}

	@BeforeMethod
	public void preCondition() throws IOException {
		// Step1 : Create object for FileInputStream and pass properties file in the
		// constructor
		FileInputStream fis = new FileInputStream("./src/test/resources/Credentials.properties");

		// Step2 : Create object for Properties class from java.util package
		prop = new Properties();

		// Step3 : Load the properties file
		prop.load(fis);
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

	@DataProvider
	public String[][] sendData() throws IOException {

		return LearnExcelcopy.readExcel(fileName);
	}

	public int takeSnap() throws IOException {
		int random = (int) ((Math.random()) * 99999);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img" + random + ".png");
		FileUtils.copyFile(screenshotAs, desc);
		return random;
	}

	public void reportStep(String status, String desc) throws IOException {

		if (status.equalsIgnoreCase("pass")) {
			test.pass(desc,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			test.fail(desc,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());
		}

	}
}
