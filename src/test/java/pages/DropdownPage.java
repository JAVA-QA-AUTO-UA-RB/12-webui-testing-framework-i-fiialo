package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "dropdown")
    private WebElement dropdownListElement;

    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public DropdownPage open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        return this;
    }

    public DropdownPage selectByIndex(int index) {
        new Select(dropdownListElement).selectByIndex(index);
        return this;
    }

    public String getSelectedOption() {
        return new Select(dropdownListElement).getFirstSelectedOption().getText();
    }
}