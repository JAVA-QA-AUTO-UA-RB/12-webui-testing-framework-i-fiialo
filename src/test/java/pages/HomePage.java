package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By abTestingLink = By.linkText("A/B Testing");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void goToAbTesting() {
        driver.findElement(abTestingLink).click();
    }
}