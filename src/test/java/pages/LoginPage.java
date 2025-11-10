package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "form#login input[name='username']")
    private WebElement username;
    @FindBy(css = "form#login input[name='password']")
    private WebElement password;
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;
    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;
    @FindBy(css = ".flash.success")
    private WebElement successMessage;
    @FindBy(css = "form#login input[name='username']")
    private WebElement loginField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get("https://the-internet.herokuapp.com/login");
        return this;
    }

    public LoginPage fillCredentialsAndSubmitLogin() {
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();
        return this;
    }

    public boolean isLoginSuccessful() {
        return successMessage.isDisplayed();
    }

    public LoginPage logout() {
        logoutButton.click();
        return this;
    }

    public boolean isLoginFieldDisplayed() {
        return loginField.isDisplayed();
    }
}