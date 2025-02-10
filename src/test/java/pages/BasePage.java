package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import locators.Div;
import locators.Input;
import locators.Span;
import tests.BaseTest;
import utils.ConfigReader;


public class BasePage {
    public final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigateToUrl(String url) {
        this.page.navigate(url);
    }

    public void takeScreenShot() {
        BaseTest.takeScreenShot();
    }
}