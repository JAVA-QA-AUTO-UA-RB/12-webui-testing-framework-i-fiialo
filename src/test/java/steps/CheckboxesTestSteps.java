package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckboxesPage;

public class CheckboxesTestSteps {

    private CheckboxesPage checkboxesPage;

    @Given("I am on the checkbox page")
    public void iAmOnTheCheckboxPage() {
        checkboxesPage = new CheckboxesPage(WebHooks.driver);
        checkboxesPage.open();
    }

    @When("I select all checkboxes")
    public void iSelectAllCheckboxes() {
        checkboxesPage.fillAllCheckboxes();
    }

    @Then("all checkboxes should be checked")
    public void allCheckboxesShouldBeChecked() {
        checkboxesPage.areAllCheckboxesSelected();
        Assert.assertTrue(checkboxesPage.areAllCheckboxesSelected(), "Чекбокси мають бути заповнені");
    }
}