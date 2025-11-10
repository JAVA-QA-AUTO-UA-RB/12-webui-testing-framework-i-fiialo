package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void horizontalSliderStepTo3_5Test(double value) {
        HorizontalSliderPage page = new HorizontalSliderPage(driver)
                .open()
                .moveSliderTo3_5(value);

        Assert.assertEquals(page.getSliderValue(),
                "3.5",
                "Слайдер не встановив точне значення 3.5");
    }
}