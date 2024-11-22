package tests;

import factory.DriverFactory;
import pages.LoginPage;
import org.testng.annotations.*;
import io.qameta.allure.Step;
import utils.WebActions;

import static io.qameta.allure.Allure.step;

public class LoginPageTest {
    private LoginPage loginPage;

    @BeforeClass
    private void setUp() {
        new DriverFactory().initDriver("chrome"); // Pa
        this.loginPage = new LoginPage(DriverFactory.getPage());
    }

    @Test
    public void loginSuccessfully(){
        step("User navigates to LoginPage");
        loginPage.navigateToUrl();
        step("Take screenshot");
        step("User enters invalid username");
        step("Take screenshot");
        step("Take screenshot");
        step("Take screenshot");
        step("Take screenshot");
    }
}