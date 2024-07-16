package StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SFCreateAccount extends ProjectSpecificBase {

	/*
	 * public ChromeDriver driver; public WebDriverWait wait;
	 */
	String AccName = "Sharmiladevi";

	@Given("Launch browser and load the url")
	public void launch_browser_and_load_the_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Given("Enter Username")
	public void enter_username() {
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
	}

	@Given("Enter Username as {string}") // Static Parameterization
	public void enter_username(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@Given("Enter Password")
	public void enter_password() {
		driver.findElement(By.id("password")).sendKeys("Leaf$123");
	}

	@Given("Enter Password as {string}") // Static Parameterization
	public void enter_password(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click Login")
	public void click_login() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("Verify Login is Successful")
	public void verify_login_is_successful() {
		String title = driver.getTitle();
		System.out.println("Login Successful Page Title : " + title);

	}

	@When("Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() {
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
	}

	@When("Click view All")
	public void click_view_all() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@When("Click Sales from App Launcher")
	public void click_sales_from_app_launcher() {
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		wait.until(ExpectedConditions.elementToBeClickable(sales));
		driver.executeScript("arguments[0].click();", sales);
	}

	@When("Click on Accounts Tab")
	public void click_on_accounts_tab() {
		driver.findElement(By.xpath("//span[text()='Accounts']/following::a")).click();
	}

	@When("Click on New button")
	public void click_on_new_button() {
		WebElement NewAcc = driver.findElement(By.xpath("//span[text()='New Account']"));
		wait.until(ExpectedConditions.elementToBeClickable(NewAcc));
		driver.executeScript("arguments[0].click();", NewAcc);
	}

	@Given("Enter Account Name as (.*)$") // Dynamic Parameterization
	public void enter_account_name(String AccName) {

		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(AccName);
		System.out.println("Account Name : " + AccName);
	}

	@Given("Enter Account Name")
	public void enter_account_name() {

		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(AccName);
		System.out.println("Account Name : " + AccName);
	}

	@Given("Select Ownership")
	public void select_ownership() {
		WebElement Ownershp = driver.findElement(By.xpath("//label[text()='Ownership']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Ownershp));
		driver.executeScript("arguments[0].click();", Ownershp);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
	}

	@When("Click SF Save")
	public void click_save() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

	@Then("Verify Account Name")
	public void verify_account_name() {

		String VerifyName = driver.findElement(By.xpath("//*[text()='Account']/following::*[@slot='primaryField']"))
				.getText();
		System.out.println("Verify Account Name : " + VerifyName);

		String AccNameTitle = driver.getTitle();
		System.out.println("Account Created Page Title : " + AccNameTitle);

		/*
		 * if (VerifyName.contains(AccName)) { System.out.println("Name Verified : " +
		 * AccName + " --> " + VerifyName); } else {
		 * System.out.println("Name Mismatch : " + AccName + " --> " + VerifyName); }
		 */
	}

	@Given("Close SF Browser")
	public void close_browser() {
		driver.close();
	}
}
