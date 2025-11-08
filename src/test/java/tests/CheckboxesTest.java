package tests;

import BaseTest.java.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void fillAllCheckboxes() {
        CheckboxesPage page = new CheckboxesPage(driver)
                .open()
                .fillAllCheckboxes();
        Assert.assertTrue(page.areAllCheckboxesSelected(), "Чекбокси мають бути заповнені");
    }
}