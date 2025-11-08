package tests;

import BaseTest.java.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void horizontalSliderStepTo3_5Test() {
        HorizontalSliderPage page = new HorizontalSliderPage(driver, wait)
                .open()
                .moveSliderTo3_5();

        Assert.assertEquals(page.getSliderValue(),
                "3.5",
                "Слайдер не встановив точне значення 3.5");
    }
}