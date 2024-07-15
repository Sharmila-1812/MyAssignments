package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/SFCreateAccount.feature"},glue="StepDef")
public class SFCreateAccountRunner extends AbstractTestNGCucumberTests{

}
