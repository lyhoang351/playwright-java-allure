package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import pages.BasePage;
import pages.LoginPage;
import io.qameta.allure.listener.StepLifecycleListener;

import java.lang.reflect.Method;

import static io.qameta.allure.Allure.step;

public class LoginPageTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeMethod
    private void setUp(Method method) {
        this.loginPage = new LoginPage(initBasePage(method));
    }

    @Test
    public void loginFailWithInvalidUsernameAndPassword(){
        loginPage.navigateToUrl();
        loginPage.enterUsername("aaaabcc-invaid@az");
        loginPage.enterPassword("21111asf");
        loginPage.clickLogin();
        assert !loginPage.verifyProfilePage();
    }
}