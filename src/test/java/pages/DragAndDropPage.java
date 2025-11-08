package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DragAndDropPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
    }

    public DragAndDropPage open() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        return this;
    }

    public DragAndDropPage dragColumnAToB() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();
        return this;
    }

    public String getColumnAText() {
        return columnA.getText();
    }

    public String getColumnBText() {
        return columnB.getText();
    }
}