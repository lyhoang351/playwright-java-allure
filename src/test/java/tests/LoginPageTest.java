package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    void setUp() {
        this.loginPage = new LoginPage(getBasePage());
    }

    @Test
    void loginFailWithInvalidUsernameAndPassword(){
        loginPage.navigateToUrl();
        loginPage.enterUsername("aaaabcc-invaid@az");
        loginPage.enterPassword("21111asf");
        loginPage.clickLogin();
        assert !loginPage.verifyProfilePage();
    }
}