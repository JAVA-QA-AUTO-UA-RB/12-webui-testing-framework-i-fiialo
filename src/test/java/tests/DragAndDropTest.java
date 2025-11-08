package tests;

import BaseTest.java.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void elementsShouldBeSwappedAfterDragAndDrop() {
        DragAndDropPage page = new DragAndDropPage(driver)
                .open();
        page.dragColumnAToB();

        String columnAText = page.getColumnAText();
        String columnBText = page.getColumnBText();

        Assert.assertEquals(columnAText, "B", "Елемент A не був перетягнутий на місце B");
        Assert.assertEquals(columnBText, "A", "Елемент B не був переміщений на місце A");
    }
}