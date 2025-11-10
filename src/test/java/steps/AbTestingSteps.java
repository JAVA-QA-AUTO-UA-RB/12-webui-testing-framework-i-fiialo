package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AbTestingPage;

public class AbTestingSteps {

    private AbTestingPage abTestingPage;

    @Given("I open the AB Testing page")
    public void iOpenTheAbTestingPage() {
        abTestingPage = new AbTestingPage(WebHooks.driver);
        abTestingPage.open();
    }


    @Then("I should see text that contains {string}")
    public void iShouldSeeTextThatContains(String expectedText) {
        String actualText = abTestingPage.getHeaderText();
        Assert.assertTrue(
                actualText.contains(expectedText),
                "Очікували, що заголовок міститиме '" + expectedText + "' але знайдено: '" + actualText + "'");
    }
}