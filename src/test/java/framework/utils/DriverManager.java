package framework.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static framework.utils.Utils.applyDefaultIfMissing;

public class DriverManager {
    private static ThreadLocal<WebDriver> sharedDriver = new ThreadLocal<>();
//    private static final GetProperties properties = new GetProperties();
//    private static final String browser = properties.getString("browser").toUpperCase();
    private static final String browser = applyDefaultIfMissing(System.getProperty("browser"),
        "CHROME");
    private static final int IMPLICIT_TIMEOUT = 20;

    public WebDriver getDriver() {
        if (sharedDriver.get() == null) {
            setWebDriver(createDriver());
            getWebDriver().manage().window().maximize();
            getWebDriver().manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
        return getWebDriver();
    }

    private WebDriver createDriver() {
        WebDriver driver;
        if (browser.equals("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(OptionsManager.getChromeOptions());
        }
        return driver;
    }

    private WebDriver getWebDriver() {
        return sharedDriver.get();
    }

    private void setWebDriver(WebDriver driver) {
        sharedDriver.set(driver);
    }

    public void quitDriver() {
        if (sharedDriver.get() != null) {
            getWebDriver().quit();
            sharedDriver.remove();
        }
    }
}
