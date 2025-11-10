package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddRemoveElementsPage;

public class AddAndRemoveTestSteps {

    private AddRemoveElementsPage addRemoveElementsPage;

    @Given("I open the AddRemove Elements page")
    public void iOpenTheAddRemoveElementsPage() {
        addRemoveElementsPage = new AddRemoveElementsPage(WebHooks.driver);
        addRemoveElementsPage.open();
    }

    @When("I add {int} {string} buttons")
    public void iAddButtons(int count, String buttonName) {
        addRemoveElementsPage.addMultipleButtons(count);
    }

    @Then("I should see {int} {string} buttons")
    public void iShouldSeeButtons(int expectedCount, String buttonName) {
        Assert.assertEquals(addRemoveElementsPage.getDeleteButtonsCount(),
                expectedCount,
                "Кількість кнопок Delete не відповідає очікуваній");
    }

    @When("I remove {int} {string} buttons")
    public void iRemoveButtons(int count, String buttonName) {
        addRemoveElementsPage.clickDeleteAll();
    }

    @Then("I shouldn't see any {string} buttons")
    public void iShouldnTSeeAnyButtons(String arg0) {
            Assert.assertFalse(addRemoveElementsPage.areDeleteButtonsDisplayed(),
                    "Після видалення кнопки Delete все ще присутні");
        }
}