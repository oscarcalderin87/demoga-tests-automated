package steps;

import framework.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {
    private TestContext testContext;
    private WebDriver driver;
    private static Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void initializeTest(){
        driver = testContext.getWebDriverManager().getDriver();
    }

    @After
    public void embedScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            try {
                LOGGER.log(Level.SEVERE, "Failed scenario: " + scenario.getName());
                byte[] screenshot = ((TakesScreenshot)testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                LOGGER.log(Level.INFO, "Screenshot taken !!");
            } catch (Exception e){
                LOGGER.log(Level.SEVERE, "Error taking screenshot");
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
            testContext.getWebDriverManager().quitDriver();
        }
    }
}
