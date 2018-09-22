package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue="stepdefinition",features="@target/rerun.txt",tags="@login",
plugin={"json:target/json-report.json","html:target/html-report.html","pretty:STDOUT","rerun:target/rerun.txt"},
strict=true)

public class Re {

}
