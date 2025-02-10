package pages.study.studydetails;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import locators.Link;
import locators.Table;
import utils.CommonActions;
import utils.CommonAssertions;

import java.util.List;

public class CDPReadyForecastByCountryPage extends StudyDetailsPage{
    public CDPReadyForecastByCountryPage(Page page) {
        super(page);
    }

}
