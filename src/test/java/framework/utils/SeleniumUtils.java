package framework.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class SeleniumUtils {
    private static int TIMEOUT = 30;

    public static WebElement waitForElement(final WebDriver driver, final By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.ignoring(NoSuchElementException.class);
        return wait.until(drv -> drv.findElement(elementBy));
    }

    public static void highlightElement(final WebDriver driver, final By elementBy) {
        WebElement element = driver.findElement(elementBy);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
    }

    public static void clickElement(final WebDriver driver, final WebElement element) {
        try {
            element.click();
        }
        catch (ElementClickInterceptedException e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        }
    }
}
