package pages;

import framework.bases.po.BasePage;
import framework.utils.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends BasePage {

    private static GetProperties properties = new GetProperties();
    private static String pageUrl = properties.getString("URL");

    private By inputFullNameBy = By.id("userName");
    private By inputEmailBy = By.id("userEmail");
    private By textAreaCurrentAddressBy = By.cssSelector("textarea#currentAddress");
    private By textAreaPermanentAddressBy = By.cssSelector("textarea#permanentAddress");
    private By buttonSubmitId = By.id("submit");
    private By outputDivId = By.id("output");
    private By outputFullNameBy = By.id("name");
    private By outputEmailBy = By.id("email");
    private By outputCurrentAddressBy = By.cssSelector("p#currentAddress");
    private By outputPermanentAddressId = By.cssSelector("p#permanentAddress");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        driver.get(pageUrl);
    }

    public void fillForm(final String fullName, final String userEmail, final String currentAddress,
                         final String permanentAddress) {
        driver.findElement(inputFullNameBy).sendKeys(fullName);
        driver.findElement(inputEmailBy).sendKeys(userEmail);
        driver.findElement(textAreaCurrentAddressBy).sendKeys(currentAddress);
        driver.findElement(textAreaPermanentAddressBy).sendKeys(permanentAddress);
        clickElement(driver.findElement(buttonSubmitId));
    }

    public boolean outputDataIsDisplayed() {
        try {
            WebElement outputDiv = waitForElement(outputDivId);
            return outputDiv.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    public void highlightOutput() {
        this.highlightElement(outputDivId);
    }

    public String getFullName() {
        return driver.findElement(outputFullNameBy).getText().replace("Name:", "");
    }

    public String getEmail() {
        return driver.findElement(outputEmailBy).getText().replace("Email:", "");
    }

    public String getCurrentAddress() {
        return driver.findElement(outputCurrentAddressBy).getText().replace("Current Address :", "");
    }

    public String getPermanentAddress() {
        return driver.findElement(outputPermanentAddressId).getText().replace("Permanent Address :", "");
    }

}
