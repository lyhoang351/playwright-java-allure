package tests;

import com.microsoft.playwright.Page;
import factory.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.ConfigReader;
import utils.TestListener;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;


public class BaseTest {

    public static BasePage basePage;
    public static int screenShotImageIndex = 1;

    @Step("And Take Screenshot")
    public static void takeScreenShot() {
        String imageName = screenShotImageIndex + ".png";
        String testcaseName = TestListener.getTestCastName();
        Path reportPath = Path.of("src", "test", "screenshots", testcaseName, imageName);
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions()
                .setFullPage(true)
                .setPath(reportPath);
        Allure.addAttachment(testcaseName + "-" + screenShotImageIndex,
                new ByteArrayInputStream(basePage.page.screenshot(screenshotOptions)));
        screenShotImageIndex++;
    }

    @BeforeMethod
    protected void initBasePage() {
        String browserName = ConfigReader.getProperty("browser");
        basePage = new BasePage(DriverFactory.initDriver(browserName));
    }

    @BeforeMethod
    protected void initScreenShotImageIndex() {
        screenShotImageIndex = 1;
    }

    @AfterMethod
    void closeBrowser() {
        basePage.page.close();
    }

}
