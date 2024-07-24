package week6.day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LearnProperties {

	public static void main(String[] args) throws IOException {
		
		//Step1 : Create object for FileInputStream and pass properties file in the constructor
		FileInputStream fis = new FileInputStream("./src/main/resources/Credentials.properties");
		
		//Step2 : Create object for Properties class from java.util package
		Properties prop = new Properties();
		
		//Step3 : Load the properties file
		prop.load(fis);
		
		//step4 : Get the value from properties file by using key
		String uname = prop.getProperty("username");
		System.out.println(uname);
		String pwd = prop.getProperty("password");
		System.out.println(pwd);
		
	}
	
	
}
