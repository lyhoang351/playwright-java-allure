package tests;

import com.microsoft.playwright.Page;
import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import utils.WebActions;

public class BaseTest {

    public static Page page;

    public Page initBrowser() {
        String browserName = WebActions.getProperty("browser");
        page = new DriverFactory().initDriver(browserName);
        return page;
    }

    @AfterMethod
    public void closeBrowser() {
        page.close();
    }
}
