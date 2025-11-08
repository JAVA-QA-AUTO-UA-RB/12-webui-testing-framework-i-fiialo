package tests;

import BaseTest.java.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthenticationTest extends BaseTest {

    @Test
    public void authentication() {
        LoginPage page = new LoginPage(driver, wait)
                .open()
                .fillCredentialsAndSubmitLogin();
        Assert.assertTrue(page.isLoginSuccessful(), "Вхід не вдався або повідомлення про успіх не відображається.");
        page.logout();
        Assert.assertTrue(page.isLoginFieldDisplayed(),
                "Сесія не завершена, логін-форма не відображається");
    }
}