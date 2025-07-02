package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue ="stepDefinition",
        plugin =  {"pretty",
                "html:target/cucumber-html-report.html",
                "html:target/cucumber-html-report"})
public  class TestRunner {
}
