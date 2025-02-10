package pages.study.studydetails;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import pages.BasePage;
import utils.ConfigReader;

public class StudyDetailsPage extends BasePage {

    public StudyDetailsPage(Page page) {
        super(page);
    }

    @Step("And user navigate to Study Details page")
    public void navigateToStudyDetailsByStudyId(String studyId){
        page.navigate(ConfigReader.getProperty("url") + "tracker/study?id=" + studyId.replace("/", "%2F"));
        page.waitForLoadState();
        takeScreenShot();
    }
}
