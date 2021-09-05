package framework.bases.po;

import framework.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(final By elementBy) {
        return SeleniumUtils.waitForElement(this.driver, elementBy);
    }

    public void highlightElement(final By elementBy) {
        SeleniumUtils.highlightElement(this.driver, elementBy);
    }

    public void clickElement(final WebElement element) {
        SeleniumUtils.clickElement(this.driver, element);
    }
}
