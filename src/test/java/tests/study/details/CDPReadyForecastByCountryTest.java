package tests.study.details;

import io.qameta.allure.Allure;
import locators.Div;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.site.tracker.SiteTrackerPage;
import pages.study.studydetails.CDPReadyForecastByCountryPage;
import tests.BaseTest;
import utils.DatabaseUtils;

import java.util.List;

public class CDPReadyForecastByCountryTest extends BaseTest {
    private CDPReadyForecastByCountryPage CDPReadyForecastPage;

    @BeforeMethod
    void setUpCDPReadyForecastPage() {
        this.CDPReadyForecastPage = new CDPReadyForecastByCountryPage(BaseTest.basePage.page);
    }

}
