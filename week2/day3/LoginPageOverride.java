package week2.day3Assignments;

public class LoginPageOverride extends BasePageOverride {
	
	@Override
	public void findElement() {
		System.out.println("Find Element from Login Page");
	}
	
	@Override
	public void clickElement() {
		System.out.println("Click Element from Login Page");
	}
	
	@Override
	public void enterText() {
		System.out.println("Enter Text from Login Page");
	}
	
	@Override
	public void performCommonTasks() {
		System.out.println("Perform Common Tasks from Login Page");
	}

	public static void main(String[] args) {
		LoginPageOverride Login = new LoginPageOverride();
		Login.clickElement();
		Login.findElement();
		Login.performCommonTasks();
		Login.enterText();
		System.out.println("--------------------------------------------");
		BasePageOverride Base = new BasePageOverride();
		Base.clickElement();
		Base.findElement();
		Base.performCommonTasks();
		Login.performCommonTasks();
		Base.enterText();
		
	}
}
