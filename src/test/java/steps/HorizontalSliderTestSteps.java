package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HorizontalSliderPage;

public class HorizontalSliderTestSteps {

    private HorizontalSliderPage horizontalSliderPage;

    @Given("I open the Horizontal Slider page")
    public void iOpenTheHorizontalSliderPage() {
        horizontalSliderPage = new HorizontalSliderPage(WebHooks.driver);
        horizontalSliderPage.open();
    }

    @When("I move the slider to {double}")
    public void iMoveTheSliderTo(double value) {
        horizontalSliderPage.moveSliderTo3_5(value);
    }

    @Then("I should see that the slider value is updated")
    public void iShouldSeeThatTheSliderValueIsUpdated() {
        Assert.assertEquals(horizontalSliderPage.getSliderValue(),
                "3.5",
                "Слайдер не встановив точне значення 3.5");
    }
}