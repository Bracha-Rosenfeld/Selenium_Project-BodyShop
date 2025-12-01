package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import pages.HomePage;
import utils.BaseTest;
import utils.ScreenshotUtils;

import java.time.Duration;

public class DynamicContentTest extends BaseTest {

    @Test
    public void testDynamicContentChange_and_screenshots() throws InterruptedException {


        DynamicContentPage dynamicPage = new DynamicContentPage(driver);
        dynamicPage.open();
        ScreenshotUtils.takeScreenshot(driver, "beforeChange.png");
        dynamicPage.clickTwoProductsPerRow();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> dynamicPage.isTwoPerRow());
        ScreenshotUtils.takeScreenshot(driver, "afterChange.png");

    }
}
