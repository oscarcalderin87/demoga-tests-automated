package framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
