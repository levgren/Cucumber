import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm", "pretty", "json:target/cucumber-report/report.json"},
        glue = "cucumberTests")

public class RunnerTest{
}

