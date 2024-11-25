package tests;

import com.microsoft.playwright.Page;
import factory.DriverFactory;
import io.qameta.allure.Allure;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import pages.BasePage;
import utils.WebActions;

import java.lang.reflect.Method;


public class BaseTest {

    public static BasePage BASE_PAGE;

    public Page initBrowser() {
        String browserName = WebActions.getProperty("browser");
        return new DriverFactory().initDriver(browserName);
    }

    public BasePage initBasePage(Method method){
        BASE_PAGE = new BasePage(initBrowser(),  method.getName());
        return BASE_PAGE;
    }

    @BeforeClass
    public void setUp(){
    }

    @AfterMethod
    public void closeBrowser() {
        BASE_PAGE.PAGE.close();
    }

//    @Override
//    public void afterStepStop(StepResult result) {
//
//        new BasePage(PAGE)
//        StepLifecycleListener.super.afterStepStop(result);
//    }

}
