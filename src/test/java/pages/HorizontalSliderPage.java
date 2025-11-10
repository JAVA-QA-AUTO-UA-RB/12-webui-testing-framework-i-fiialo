package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HorizontalSliderPage {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement valueDisplay;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public HorizontalSliderPage open() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        return this;
    }

    public HorizontalSliderPage moveSliderTo3_5(double value) {
        for (int i = 0; i < 7; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public String getSliderValue() {
        return valueDisplay.getText();
    }
}