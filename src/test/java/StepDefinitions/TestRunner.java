package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/", 
		glue= {"StepDefinitions"}, 
		monochrome = true, 
//		tags = "@regression",
		plugin= {"pretty","html:target/HtmlReports.html", "junit:target/jUnitReports.xml", "json:target/jsonReports.json"})
public class TestRunner {

}
