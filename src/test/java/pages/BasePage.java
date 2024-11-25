package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Path;

public class BasePage {
    public final Page PAGE;
    public final String TC_NAME;
    private int screenShotImageIndex = 1;

    public BasePage(Page page, String testCaseName) {
      this.PAGE = page;
      this.TC_NAME = testCaseName;
    }

    public void navigateToUrl(String url) {
        this.PAGE.navigate(url);
    };

    @Step("Take screenshot")
    public void takeScreenShot() {
        takeScreenshotByPage(this, this.TC_NAME);
    }

    public static void takeScreenshotByPage(BasePage basePage, String testcaseName){
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        screenshotOptions.setFullPage(true);
        String screenShotImageExtension = ".png";
        Path reportPath = Path.of("src", "test", "screenshots");
        screenshotOptions.setPath(Path.of(
                reportPath + File.separator +
                        testcaseName + File.separator +
                        (basePage.screenShotImageIndex) + screenShotImageExtension));
        Allure.addAttachment(testcaseName + "-" + String.valueOf(basePage.screenShotImageIndex++), new ByteArrayInputStream(basePage.PAGE.screenshot(screenshotOptions)));
    }
}