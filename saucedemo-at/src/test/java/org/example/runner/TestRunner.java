package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.step", "org.example.utilities"}, // <== Fixed: Use package, not path
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report/json/report.json",
                "junit:target/cucumber-report/junit/report.xml",
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
