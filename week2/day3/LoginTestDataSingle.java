package week2.day3Assignments;

public class LoginTestDataSingle extends TestDataSingle {
	
	public void enterUsername(){
		System.out.println("Enter the Username for Login TestData");
		
	}

	public void enterPassword(){
		System.out.println("Enter the Password for Login TestData");
		
	}
	
	public static void main(String[] args) {
		LoginTestDataSingle Login = new LoginTestDataSingle();
		Login.navigateToHomePage();
		Login.enterCredentials();
		Login.enterUsername();
		Login.enterPassword();
		
	}
}
