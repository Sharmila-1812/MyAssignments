package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
		"src/test/java/features/MultiSFCreateAccount.feature" }, glue = "StepDef", publish = true, monochrome = true)
public class MultiSFCreateAccountRunner extends AbstractTestNGCucumberTests {

}
