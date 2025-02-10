package factory;

import com.microsoft.playwright.*;
import utils.ConfigReader;

import java.util.List;

public class DriverFactory {
    public static Browser browser;
    public static final Playwright playwright = Playwright.create();


    //Launches Browser as set by user in config file
    public static Page initDriver(String browserName) {
        browser = initBrowser(browserName);
        BrowserContext context = browser.newContext();
        //Below line is used to start the trace file
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
        return context.newPage();
    }

    private static Browser initBrowser(String browserName) {
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headless).setArgs(List.of("--window-size=1920,1040"));
        switch (browserName) {
            case "chrome":
                return playwright.chromium().launch(launchOptions.setChannel("chrome"));
            case "firefox":
                return playwright.firefox().launch(launchOptions);
            case "webkit":
                return playwright.webkit().launch(launchOptions);
            default:
                throw new IllegalArgumentException("Could not Launch Browser for type" + browserName);
        }
    }
}
