package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import utils.TestListener;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;

public class BasePage {
    public final Page page;
    private int screenShotImageIndex = 1;

    public BasePage(Page page) {
      this.page = page;
    }

    public void navigateToUrl(String url) {
        this.page.navigate(url);
    }

    public void takeScreenShot() {
        String imageName = screenShotImageIndex + ".png";
        String testcaseName = TestListener.getTestCastName();
        Path reportPath = Path.of("src", "test", "screenshots", testcaseName, imageName);
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions()
                .setFullPage(true)
                .setPath(reportPath);
        Allure.addAttachment(testcaseName + "-" + screenShotImageIndex,
                new ByteArrayInputStream(this.page.screenshot(screenshotOptions)));
        screenShotImageIndex++;
    }
}