package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthenticationTest extends BaseTest {

    @Test
    public void authentication() {
        LoginPage page = new LoginPage(driver)
                .open()
                .fillCredentialsAndSubmitLogin();
        Assert.assertTrue(page.isLoginSuccessful(), "Вхід не вдався або повідомлення про успіх не відображається.");
        page.logout();
        Assert.assertTrue(page.isLoginFieldDisplayed(),
                "Сесія не завершена, логін-форма не відображається");
    }
}