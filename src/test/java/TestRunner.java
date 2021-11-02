

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = "gitHubStepdefs",
        format = {"pretty", "html:target/html/"},
        tags = "@TestGitHub"

      //  features = "Feature"

)

public class TestRunner {

}