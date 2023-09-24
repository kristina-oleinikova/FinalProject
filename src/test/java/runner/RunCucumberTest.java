package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"json:target/json/file.json", "html:target/site/cucumber-pretty.html"},
        glue = "stepDefs",
        tags = "@"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}