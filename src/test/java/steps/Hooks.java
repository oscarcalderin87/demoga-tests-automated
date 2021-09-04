package steps;

import framework.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private TestContext testContext;
    private WebDriver driver;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void initializeTest(){
        driver = testContext.getWebDriverManager().getDriver();
    }

    @After
    public void tearDown() {
        testContext.getWebDriverManager().quitDriver();
    }
}
