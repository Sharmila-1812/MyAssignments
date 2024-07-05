package week3.day4Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasketActionCls {

	public static void main(String[] args) {
		// Launch the Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//Click on Shop by Category, Mouse hover to Food grains using Actions Class
		driver.findElement(By.id("headlessui-menu-button-:R5bab6:")).click();
		Actions action = new Actions(driver);
		WebElement Food = driver.findElement(By.xpath("(//a[contains(text(),'Foodgrains')])[2]"));
		action.moveToElement(Food).perform();
		//Mouse hover to Rice Products using Actions Class and Click Boiled Rice
		WebElement Rice = driver.findElement(By.xpath("//a[contains(text(),'Rice & Rice')]"));
		action.moveToElement(Rice).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Boiled')]")).click();
		//Under Brands Filter, Select "BB royal" using JS scroll and click
		WebElement Brand = driver.findElement(By.xpath("//span[text()='Brands']/following::label[text()='BB Royal']"));
		driver.executeScript("arguments[0].scrollIntoView();", Brand); 
		Brand.click();
		//Click on Tamil Ponni rice and get the windows & Switch to next window
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled - Rice']")).click();
		Set<String> RiceWin = driver.getWindowHandles();
		List<String> RiceWindow = new ArrayList<String>(RiceWin);
		driver.switchTo().window(RiceWindow.get(1));
		//Click on 5 Kg weight using Explicit wait,JS scroll and click
		WebElement Weight = driver.findElement(By.xpath("//span[text()='5 kg']//following::div[contains(@class,'flex-col items-end')]"));
		wait.until(ExpectedConditions.elementToBeClickable(Weight));
		driver.executeScript("arguments[0].scrollIntoView(true);", Weight);
		Weight.click();
		//Print the Price of 5 Kg Rice
		String RiceAmt = driver
				.findElement(By.xpath("(//span[text()='5 kg']/following::span[contains(text(),'₹')])[1]")).getText();
		System.out.println("Price of Tamil Ponni Rice - 5 Kg : " + RiceAmt);
		//Click Add to Basket using Explicit wait & JS Click
		WebElement Add = driver.findElement(By.xpath("//button[text()='Add to basket']"));
		wait.until(ExpectedConditions.elementToBeClickable(Add));
		driver.executeScript("arguments[0].click();", Add);
		//Get the Success Msg using Explicit wait Visibility check
		WebElement Msg = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']"));
		wait.until(ExpectedConditions.visibilityOf(Msg));
		String SuccessMsg = Msg.getText();
		System.out.println("Success Msg: " + SuccessMsg);
		//Verify the Success msg
		if (SuccessMsg.contains("added to your basket")) {
			System.out.println("Success Message Displayed and Verified");
		} else {
			System.out.println("Success Message not Displayed");
		}
		//Close the child window
		driver.close();
		//Move the control to parent window
		driver.switchTo().window(RiceWindow.get(0));
		//Close the Parent window
		driver.close();

	}
}
