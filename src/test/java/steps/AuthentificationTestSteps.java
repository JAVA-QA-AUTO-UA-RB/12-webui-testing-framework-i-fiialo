package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

public class AuthentificationTestSteps {

    private LoginPage loginPage;

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        loginPage = new LoginPage(WebHooks.driver);
        loginPage.open();
    }

    @When("I fill username {string} and password {string} and click on the Login button")
    public void iFillUsernameAndPasswordAndClickOnTheLoginButton(String username, String password) {
        loginPage.fillCredentialsAndSubmitLogin();
    }

    @When("I click on the Logout button")
    public void iClickOnTheLogoutButton() {
        loginPage.logout();
    }

    @Then("I should see message {string}")
    public void iShouldSeeMessage(String text) {
        loginPage.isLoginSuccessful();
    }

    @Then("I should see login field")
    public void iShouldSeeLoginField() {
        Assert.assertTrue(loginPage.isLoginFieldDisplayed(),
                "Сесія не завершена, логін-форма не відображається");
    }
}