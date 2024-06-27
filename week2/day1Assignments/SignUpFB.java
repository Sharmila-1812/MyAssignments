package week2.day1Assignments;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpFB {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		// To Load URL
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// To Create new Account
		driver.findElement(By.linkText("Create new account")).click();
		// driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		// To enter details like name,surname,pwd
		driver.findElement(By.name("firstname")).sendKeys("Sharmila");
		driver.findElement(By.name("lastname")).sendKeys("devi");
		driver.findElement(By.id("password_step_input")).sendKeys("Sharmil");
		// To enter mail or phone number
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		// To Enter Day Dropdown
		WebElement EleDay = driver.findElement(By.id("day"));
		Select DayDD = new Select(EleDay);
		DayDD.selectByIndex(17);
		// To enter month Dropdown
		WebElement EleMonth = driver.findElement(By.id("month"));
		Select MonthDD = new Select(EleMonth);
		MonthDD.selectByVisibleText("Dec");
		// To Enter Year
		WebElement EleYear = driver.findElement(By.id("year"));
		Select YearDD = new Select(EleYear);
		YearDD.selectByValue("1992");
		// Click Gender Radio Button
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
