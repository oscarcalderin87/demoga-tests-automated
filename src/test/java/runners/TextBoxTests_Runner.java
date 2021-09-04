package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        tags = "@textbox",
        monochrome = true,
        plugin = { "json:report/cucumber.json", "pretty",
                "html:target/automated-test-report.html" }
)
public class TextBoxTests_Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
