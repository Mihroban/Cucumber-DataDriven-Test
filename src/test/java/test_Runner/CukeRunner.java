package test_Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"Features"},
		glue={"step_definitions"},
		plugin = { "pretty", "html:target/cucumber-reports" },
		tags = { "@SignUpTest",
				//"@LoginTest"
		},
		dryRun = false,
		monochrome = true
		
		)
public class CukeRunner {

}
