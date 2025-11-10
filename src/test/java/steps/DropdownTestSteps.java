package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DropdownPage;

public class DropdownTestSteps {

    private DropdownPage dropdownPage;

    @Given("I am on dropdown page")
    public void iAmOnDropdownPage() {
        dropdownPage = new DropdownPage(WebHooks.driver);
        dropdownPage.open();
    }

    @When("I select {string}")
    public void iSelect(String option) {
        dropdownPage.selectByVisibleText(option);
    }

    @Then("I should see {string} on dropdown")
    public void iShouldSeeOnDropdown(String expectedOption) {
        dropdownPage.getSelectedOption();
        Assert.assertEquals(dropdownPage.getSelectedOption(), expectedOption,
                "Очікується, що буде вибрано 'Option 2'");
    }
}