package tests;

import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.ConfigReader;


public class BaseTest {

    public static BasePage basePage;
    private static final ThreadLocal<BasePage> THREAD_LOCAL_BASE_PAGE = new ThreadLocal<>();

    @BeforeMethod
    void initBasePage() {
        String browserName = ConfigReader.getProperty("browser");
        basePage = new BasePage(DriverFactory.initDriver(browserName));
        THREAD_LOCAL_BASE_PAGE.set(basePage);
    }

    @AfterMethod
    void closeBrowser() {
        getBasePage().page.close();
    }

    public static BasePage getBasePage() {
        return THREAD_LOCAL_BASE_PAGE.get();
    }
}
