package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnExceptionHandling {
		public static void main(String[] args) {
			int x = 100;
			System.out.println(x);
			try {
				int i = 1/0;
				System.out.println(i);
				x++;
			} catch (ArithmeticException e) {
				System.out.println(1/2);
				System.out.println("Run time Exception is occur and the exception is "+e);
			}
			
			System.out.println(x);
			
			System.out.println("Before try finally");
			
			try {
				int[] a = {1,2,3,4};
				try {
					System.out.println(a[4]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Inside nested try catch "+a[a.length-1]);
				}
			} finally {
				System.out.println("I'm finally block");
			}
			
			System.out.println("After finally block");
			
			System.out.println("--------------------------------------");
			String num="";
			try {
				
				num  = "123$";
				System.out.println(Integer.parseInt(num));
				int b[] = {};
				System.out.println(b[0]);
				
			}catch(NumberFormatException e) {
				String numStr = num.replaceAll("[^0-9]", "");
				System.out.println(Integer.parseInt(numStr));
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("7");
			}finally {
				System.out.println("Close the DB");
			}
			
			
			
			
			
			
		}
		
		
		public void click(WebElement ele, String locator ) {
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/");
			try {
				driver.findElement(By.className("decortive Submit")).click();
			} catch (NoSuchElementException e) {
				
			}catch(StaleElementReferenceException e) {
				
			}catch(ElementClickInterceptedException e) {
				
			}catch(ElementNotInteractableException e) {
				
			}catch(InvalidSelectorException e) {
				
			}
		}
}
