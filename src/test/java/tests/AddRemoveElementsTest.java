package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void elementShouldAppearAndDisappear() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver)
                .open();
        page.addMultipleButtons(3);
        Assert.assertEquals(page.getDeleteButtonsCount(), 3,
                "Відображається 3 кнопки Delete");
        page.clickDeleteAll();
        Assert.assertFalse(page.areDeleteButtonsDisplayed(),
                "Всі кнопки Delete видалені");
    }
}