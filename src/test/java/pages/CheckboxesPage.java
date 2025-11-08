package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckboxesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#checkboxes input[type='checkbox']:nth-of-type(1)")
    private WebElement checkboxesTest1;
    @FindBy(css = "#checkboxes input[type='checkbox']:nth-of-type(2)")
    private WebElement checkboxesTest2;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
    }

    public CheckboxesPage open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        return this;
    }

    public CheckboxesPage fillAllCheckboxes() {
        if (!checkboxesTest1.isSelected()) {
            checkboxesTest1.click();
        }
        if (!checkboxesTest2.isSelected()) {
            checkboxesTest2.click();
        }
        return this;
    }

    public boolean areAllCheckboxesSelected() {
        return checkboxesTest1.isSelected() && checkboxesTest2.isSelected();
    }
}