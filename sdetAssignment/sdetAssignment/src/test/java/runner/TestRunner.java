package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features"
     ,glue={"stepDefinitions"}
 )
public class TestRunner {

}
