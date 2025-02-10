package pages.site.tracker;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import pages.BasePage;
import utils.ConfigReader;

public class SiteTrackerPage extends BasePage {

    public SiteTrackerPage(Page page) {
        super(page);
    }

    @Step("Then verify current page is Site Tracker")
    public void isSiteTrackerPage(){
        String url = ConfigReader.getProperty("url") + "tracker/sites";
        page.waitForURL(url);
        assert (url).equals(page.url());
        takeScreenShot();
    }
}
