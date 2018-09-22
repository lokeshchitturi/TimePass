package cucumberTest;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=3)
@CucumberOptions(glue="stepdefinition",features="Feature",tags="@login",
plugin={"json:target/json-report.json","html:target/html-report.html","pretty:STDOUT"},
strict=true)

public class ReRunnerTest {

}
