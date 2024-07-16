package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SFEditAccount extends ProjectSpecificBase {
	@When("Click Account")
	public void click_account() {
		WebElement Accounts = driver.findElement(By.xpath("//p[text()='Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(Accounts));
		driver.executeScript("arguments[0].click();", Accounts);

	}

	@Given("Search for the account name")
	public void search_for_the_account_name() {
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Sharmila",Keys.ENTER);
	}

	@When("Click the dropdown icon and Select Edit")
	public void click_the_dropdown_icon_and_select_edit() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

	}

	@Given("Select Type")
	public void select_type() {
		WebElement Type = driver.findElement(By.xpath("//label[text()='Type']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Type));
		driver.executeScript("arguments[0].click();", Type);
		driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
	}

	@Given("Select Industry")
	public void select_industry() {
		WebElement Industry = driver.findElement(By.xpath("//label[text()='Industry']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Industry));
		driver.executeScript("arguments[0].click();", Industry);
		WebElement Healthcare = driver.findElement(By.xpath("//span[text()='Healthcare']"));
		wait.until(ExpectedConditions.visibilityOf(Healthcare));
		driver.executeScript("arguments[0].click();", Healthcare);
		//Healthcare.click();

	}

	@Given("Enter Billing Address as {string}")
	public void enter_billing_address_as(String BAddr) {
		WebElement BillAddr = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
		wait.until(ExpectedConditions.visibilityOf(BillAddr));
		BillAddr.sendKeys(BAddr);
	}

	@Given("Enter Shipping Address as {string}")
	public void enter_shipping_address_as(String SAddr) {
		WebElement ShipAddr = driver.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea"));
		wait.until(ExpectedConditions.visibilityOf(ShipAddr));
		ShipAddr.sendKeys(SAddr);
	}

	@Given("Set Customer Priority")
	public void set_customer_priority() {
		WebElement Priority = driver.findElement(By.xpath("//label[text()='Customer Priority']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Priority));
		driver.executeScript("arguments[0].click();", Priority);
		driver.findElement(By.xpath("//span[text()='Low']")).click();
	}

	@Given("Set SLA")
	public void set_sla() {
		WebElement SLA = driver.findElement(By.xpath("//label[text()='SLA']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(SLA));
		driver.executeScript("arguments[0].click();", SLA);
		driver.findElement(By.xpath("//span[text()='Silver']")).click();
	}

	@Given("Set Active")
	public void set_active() {
		WebElement Active = driver.findElement(By.xpath("//label[text()='Active']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Active));
		driver.executeScript("arguments[0].click();", Active);
		driver.findElement(By.xpath("//span[text()='No']")).click();
	}

	@Given("Enter Phone Number as {string}")
	public void enter_phone_number_as(String Phno) {
		WebElement PhoneNum = driver.findElement(By.xpath("//label[text()='Phone']/following::input"));
		wait.until(ExpectedConditions.visibilityOf(PhoneNum));
		PhoneNum.clear();
		PhoneNum.sendKeys(Phno);
		System.out.println("Static Phone Number given as : " + Phno);
	}

	@Given("Set Upsell Opportunity")
	public void set_upsell_opportunity() {
		WebElement Upsell = driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(Upsell));
		driver.executeScript("arguments[0].click();", Upsell);
		driver.findElement(By.xpath("//span[text()='No']")).click();
	}

	@Then("Verify Phone Number")
	public void verify_phone_number() {
		String VerifyPhno = driver.findElement(By.xpath("//span[@class='forceOutputPhone slds-truncate']")).getText();
		System.out.println("Verify Phone Number : " + VerifyPhno);
		System.out.println("Title of Current Page : "+driver.getTitle());
	}

}
