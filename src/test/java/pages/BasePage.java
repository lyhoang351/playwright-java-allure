package pages;

import com.microsoft.playwright.Page;

import java.io.File;
import java.nio.file.Path;

public class BasePage {
    protected final Page PAGE;
    protected final String TC_NAME;
    private static int screenShotImageIndex = 1;

    public BasePage(Page page, String testCaseName) {
      this.PAGE = page;
      this.TC_NAME = testCaseName;
    }

    public void navigateToUrl(String url) {
        this.PAGE.navigate(url);
    };

    public void takeScreenShot() {
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        screenshotOptions.setFullPage(true);
        String screenShotImageExtension = ".png";
        Path reportPath = Path.of("src", "test", "screenshots");
        screenshotOptions.setPath(Path.of(
                reportPath + File.separator +
                        TC_NAME + File.separator +
                        (screenShotImageIndex++) + screenShotImageExtension));
        PAGE.screenshot(screenshotOptions);
    }
}