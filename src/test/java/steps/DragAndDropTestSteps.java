package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DragAndDropPage;

public class DragAndDropTestSteps {

    private DragAndDropPage dragAndDropPage;

    @Given("I am on the drag and drop page")
    public void iAmOnTheDragAndDropPage() {
        dragAndDropPage = new DragAndDropPage(WebHooks.driver);
        dragAndDropPage.open();
    }

    @When("I drag element A to element B")
    public void iDragElementAToElementB() {
        dragAndDropPage.dragColumnAToB();
    }

    @Then("elements should swap places")
    public void elementsShouldSwapPlaces() {
        String columnAText = dragAndDropPage.getColumnAText();
        String columnBText = dragAndDropPage.getColumnBText();

        Assert.assertEquals(columnAText, "B", "Елемент A не був перетягнутий на місце B");
        Assert.assertEquals(columnBText, "A", "Елемент B не був переміщений на місце A");
    }
}