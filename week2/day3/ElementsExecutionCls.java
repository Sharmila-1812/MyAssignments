package week2.day3Assignments;

public class ElementsExecutionCls extends ButtonSub {

	public static void main(String[] args) {
		ButtonSub Button = new ButtonSub();
		Button.click();
		Button.setText("Button Subclass called");
		Button.submit();
		System.out.println("-----------------------------------------------------------------------");
		TextFieldSub Txt = new TextFieldSub();
		Txt.click();
		Txt.setText("TextField SubClass Called");
		Txt.getText();
		System.out.println("-----------------------------------------------------------------------");
		CheckBoxButtonSub Chk = new CheckBoxButtonSub();
		Chk.click();
		Chk.setText("CheckBox Subclass Called");
		Chk.submit();
		Chk.clickCheckButton();
		System.out.println("-----------------------------------------------------------------------");
		RadioButtonSub Rad = new RadioButtonSub();
		Rad.click();
		Rad.setText("Radio Button SubClass Called");
		Rad.submit();
		Rad.selectRadioButton();
		System.out.println("-----------------------------------------------------------------------");
		ElementsExecutionCls Exe = new ElementsExecutionCls();
		Exe.click();
		Exe.setText("Execution Class Called");
		Exe.submit();

	}

}
