package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/"},
        glue = {"TestCases"},
        plugin = {"pretty", "html:target/cucumber-reports",
        "html:target/site/cucumber-pretty",
        "json:target/cucumber.json","usage:target/cucumber-usage.json","" +
                "junit:target/cucumber-results.xml"},
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
