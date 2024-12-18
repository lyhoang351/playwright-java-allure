package factory;

import com.microsoft.playwright.*;
import utils.ConfigReader;

public class DriverFactory {
    public static Page page;
    public static Browser browser;
    public static BrowserContext context;
    public static final Playwright playwright = Playwright.create();

    public static final ThreadLocal<Page> THREAD_LOCAL_DRIVER = new ThreadLocal<>(); //For Parallel execution
    public static final ThreadLocal<BrowserContext> THREAD_LOCAL_CONTEXT = new ThreadLocal<>();

    //Launches Browser as set by user in config file
    public static Page initDriver(String browserName) {
        browser = initBrowser(browserName);
        context = browser.newContext();
        //Below line is used to start the trace file
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
        page = context.newPage();
        THREAD_LOCAL_DRIVER.set(page);
        THREAD_LOCAL_CONTEXT.set(context);
        return page;
    }

    private static Browser initBrowser(String browserName) {
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headless);
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

    public static synchronized Page getPage() {
        return THREAD_LOCAL_DRIVER.get(); // Will return Initialized Thread Local Driver
    }

    public static synchronized BrowserContext getContext() {
        return THREAD_LOCAL_CONTEXT.get(); // Will return Initialized Thread Local Context
    }

}
