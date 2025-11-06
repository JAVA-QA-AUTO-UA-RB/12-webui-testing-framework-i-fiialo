import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTestngTest extends BasicSetupTest {

    @Test
    public void abTestingPageHasSpecificTextTest() {
        browser.get("https://the-internet.herokuapp.com/");
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        String actualText = header.getText().trim();
        Assert.assertTrue(actualText.contains("A/B Test"),
                "Очікуваний текст не знайдено. Фактичний: " + actualText);
    }

    @Test
    public void addRemoveElementsTest() {
        browser.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement = browser.findElement(By.cssSelector("button[onclick='addElement()']"));

        for (int i = 0; i < 3; i++) {
            addElement.click();
        }

        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.cssSelector("button.added-manually"), 3));

        List<WebElement> deleteButtons = browser.findElements(By.cssSelector("button.added-manually"));
        Assert.assertEquals(deleteButtons.size(), 3,
                "Очікується 3 кнопки Delete, але знайдено " + deleteButtons.size());

        while (!browser.findElements(By.cssSelector("button.added-manually")).isEmpty()) {
            WebElement deleteButton = browser.findElement(By.cssSelector("button.added-manually"));
            deleteButton.click();
            wait.until(ExpectedConditions.stalenessOf(deleteButton));
        }

        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.cssSelector("button.added-manually"), 0));

        List<WebElement> remainingButtons = browser.findElements(By.cssSelector("button.added-manually"));
        Assert.assertTrue(remainingButtons.isEmpty(), "Усі кнопки видалені");
    }

    @Test
    public void checkboxesTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkboxesTest1 = browser.findElement(By.cssSelector("input[type=checkbox]:nth-child(1)"));
        WebElement checkboxesTest2 = browser.findElement(By.cssSelector("input[type=checkbox]:nth-child(2)"));

        if (!checkboxesTest1.isSelected()) {
            checkboxesTest1.click();
        }

        if (!checkboxesTest2.isSelected()) {
            checkboxesTest2.click();
        }

        Assert.assertTrue(checkboxesTest1.isSelected(), "Перший чекбокс не обраний");
        Assert.assertTrue(checkboxesTest2.isSelected(), "Другий чекбокс не обраний");
    }

    @Test
    public void dropdownListTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownListElement = browser.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownListElement);
        dropdown.selectByIndex(2);
        Thread.sleep(1500);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2",
                "Очікується, що буде вибрано 'Option 2'");
    }

    @Test
    public void formAuthenticationTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/login");
        WebElement username = browser.findElement(By.cssSelector("form#login input[name='username']"));
        WebElement password = browser.findElement(By.cssSelector("form#login input[name='password']"));
        WebElement loginButton = browser.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement successMessage = browser.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Вхід не вдався");

        WebElement logout = browser.findElement(By.cssSelector("a[href='/logout']"));
        logout.click();

        WebElement loginField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("form#login input[name='username']")));
        Assert.assertTrue(loginField.isDisplayed(),
                "Користувач не був перенаправлений на сторінку входу після виходу з системи");
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnA = browser.findElement(By.cssSelector("#column-a"));
        WebElement columnB = browser.findElement(By.cssSelector("#column-b"));

        Actions actions = new Actions(browser);
        actions.dragAndDrop(columnA, columnB).perform();

        String headerA = browser.findElement(By.cssSelector("#column-a header")).getText();
        Assert.assertEquals(headerA, "B", "Елемент A не був перетягнутий на місце B");
    }

    @Test
    public void horizontalSliderStepTo3_5Test() {
        browser.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = browser.findElement(By.cssSelector("input[type='range']"));
        WebElement valueDisplay = browser.findElement(By.id("range"));

        for (int i = 0; i < 6; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        slider.sendKeys(Keys.ARROW_RIGHT);

        Assert.assertEquals(
                valueDisplay.getText(),
                "3.5",
                "Слайдер не встановив точне значення 3.5");
    }
}