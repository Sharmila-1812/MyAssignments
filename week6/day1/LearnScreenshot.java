package week6.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnScreenshot {

	public static void main(String[] args) throws IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		//Step1 : Take a screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		
		// Step2: Set file path for Screenshot
		File des = new File("./snaps/img2.png");
		
		//Step3: Copy the screenshot into the file location
		FileUtils.copyFile(src, des);
		
		
		//To take a snapshot of WebElement 
//		Step1 : Locate the WebElement
		WebElement loginForm = driver.findElement(By.xpath("//div[@id='form']"));
		
		//Step1 : Take a screenshot
				File src1 = loginForm.getScreenshotAs(OutputType.FILE);
				
				// Step2: Set file path for Screenshot
				File des1 = new File("./snaps/img1.png");
				
				//Step3: Copy the screenshot into the file location
				FileUtils.copyFile(src1, des1);
				
		
	}
	
	
	
}
