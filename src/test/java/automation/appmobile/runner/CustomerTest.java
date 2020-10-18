package automation.appmobile.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber-report/cucumber.json"},
				features = "classpath:features",
				glue = "automation.appmobile.steps",
				monochrome = true,
				dryRun = false)
public class CustomerTest {

}
