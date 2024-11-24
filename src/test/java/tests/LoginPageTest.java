package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.lang.reflect.Method;

import static io.qameta.allure.Allure.step;

public class LoginPageTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeMethod
    private void setUp(Method method) {
        this.loginPage = new LoginPage(initBrowser(), method.getName());
    }

    @Test
    public void loginSuccessfully(){
        step("User navigates to LoginPage");
        loginPage.navigateToUrl();
        step("Take screenshot");
        loginPage.takeScreenShot();
        step("User enters invalid username");
        loginPage.enterUsername("aaaabcc-invaid@az");
        step("User enters invalid password");
        loginPage.enterPassword("21111asf");
        step("Take screenshot");
        loginPage.takeScreenShot();
        step("User click to login button");
        loginPage.clickLogin();
        step("Verify Profile Page");
        assert !loginPage.verifyProfilePage();
        step("Take screenshot");
        loginPage.takeScreenShot();
    }
}