package tests;

import BaseTest.java.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void selectDropdownListElement() {
        DropdownPage page = new DropdownPage(driver, wait)
                .open()
                .selectByIndex(2);

        Assert.assertEquals(page.getSelectedOption(), "Option 2",
                "Очікується, що буде вибрано 'Option 2'");
    }
}