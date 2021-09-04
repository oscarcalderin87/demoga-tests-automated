package steps;

import framework.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.TextBoxPage;

public class TextBoxPage_Steps {
    private WebDriver driver;
    private TextBoxPage textBoxPage;
    private SoftAssert softAssert;

    public TextBoxPage_Steps(TestContext testContext) {
        driver = testContext.getWebDriverManager().getDriver();
        textBoxPage = new TextBoxPage(driver);
        softAssert = new SoftAssert();
    }

    @Given("The user goes to the Text Box page")
    public void theUserGoesToTheTextBoxPage() {
        textBoxPage.goToPage();
    }

    @When("The user fills the form with the data: {string}, {string}, {string} and {string}")
    public void theUserFillsTheFormWithTheDataAnd(String fullName, String email, String currentAddress,
                                                  String permanentAddress) {
        textBoxPage.fillForm(fullName, email, currentAddress, permanentAddress);
    }

    @Then("The output data is being displayed")
    public void theOutputDataIsBeingDisplayed() {
        Assert.assertTrue(textBoxPage.outputDataIsDisplayed(),
                "The output should be displayed, but it is not");
    }

    @And("The output data contains the expected data: {string}, {string}, {string} and {string}")
    public void theOutputDataContainsTheExpectedDataAnd(String fullName, String email, String currentAddress,
                                                        String permanentAddress) {
        textBoxPage.highlightOutput();
        softAssert.assertEquals(textBoxPage.getFullName(), fullName,
                "The full name should be '" + fullName + "', but it is '" + textBoxPage.getFullName() + "'");
        softAssert.assertEquals(textBoxPage.getEmail(), email,
                "The email should be '" + email + "', but it is '" + textBoxPage.getEmail() + "'");
        softAssert.assertEquals(textBoxPage.getCurrentAddress(), currentAddress,
                "The current address should be '" + currentAddress + "', but it is '" + textBoxPage.getCurrentAddress()
                        + "'");
        softAssert.assertEquals(textBoxPage.getPermanentAddress(), permanentAddress,
                "The permanent address should be '" + permanentAddress + "', but it is '" + textBoxPage.getPermanentAddress()
                        + "'");
        softAssert.assertAll();
    }
}
