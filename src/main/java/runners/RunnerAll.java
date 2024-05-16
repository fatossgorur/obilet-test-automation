package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-html-reports", "pretty"},
        features = {"src/test/java/features/LoginTest.feature","src/test/java/features/SearchFlightTicketTest.feature"},
        glue = {"definitions"}
)

public class RunnerAll {
}


