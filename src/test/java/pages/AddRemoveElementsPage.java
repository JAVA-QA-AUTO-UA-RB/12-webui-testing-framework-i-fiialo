package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddRemoveElementsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addElement;

    @FindBy(css = "button.added-manually")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
    }

    public AddRemoveElementsPage open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        return this;
    }

    public AddRemoveElementsPage clickAddButton() {
        addElement.click();
        return this;
    }

    public AddRemoveElementsPage addMultipleButtons(int count) {
        for (int i = 0; i < count; i++) {
            clickAddButton();
        }
        return this;
    }

    public List<WebElement> getDeleteButtons() {
        return deleteButtons;
    }

    public int getDeleteButtonsCount() {
        return deleteButtons.size();
    }

    public boolean areDeleteButtonsDisplayed() {
        return !deleteButtons.isEmpty();
    }

    public AddRemoveElementsPage clickDeleteAll() {
        List<WebElement> buttons = getDeleteButtons();
        while (!buttons.isEmpty()) {
            WebElement button = buttons.get(0);
            button.click();
            wait.until(ExpectedConditions.stalenessOf(button));
            buttons = getDeleteButtons();
        }
        return this;
    }
}
