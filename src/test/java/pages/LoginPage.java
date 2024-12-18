package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import utils.WebActions;

public class LoginPage extends BasePage {
    public final Locator USERNAME_EDITBOX;
    public final Locator PASSWORD_EDITBOX;
    private final Locator LOGIN_BUTTON;
    private final Locator REGISTER_LINK;
    private final Locator USER;
    public final Locator ERROR_MESSAGE;

    public LoginPage(BasePage page) {
        super(page.page);
        this.USERNAME_EDITBOX = page.page.locator("//input[@formcontrolname='username']");
        this.PASSWORD_EDITBOX = page.page.locator("//input[@formcontrolname='password']");
        this.LOGIN_BUTTON = page.page.locator("//button/span[text()='Login']");
        this.REGISTER_LINK = page.page.locator("//button/span[text()='Register']");
        this.USER = page.page.locator("//*[@aria-haspopup='menu']//span[contains(@class, 'label')]");
        this.ERROR_MESSAGE = page.page.locator("//mat-error");
    }

    @Step("User navigates to LoginPage")
    public void navigateToUrl() {
        super.navigateToUrl("https://bookcart.azurewebsites.net/login");
    }

    @Step("User enters {username}")
    public void enterUsername(String username) {
        USERNAME_EDITBOX.fill(username);
    }

    @Step("User enters {password}")
    public void enterPassword(String password) {
        PASSWORD_EDITBOX.fill(password);
    }

    @Step("User click to login button")
    public void clickLogin() {
        LOGIN_BUTTON.click();
    }

    public void clickRegister() {
        REGISTER_LINK.click();
    }

    public void clickOnIcon(String iconName) {
        this.page.getByText(iconName, new Page.GetByTextOptions().setExact(true)).click();  // Clicks on the Exact text
    }

    @Step("Verify Profile Page")
    public boolean verifyProfilePage() {
        return WebActions.waitUntilElementDisplayed(this.USER, 5);
    }

    public String getErrorMessage(){
        return this.ERROR_MESSAGE.innerText();
    }
}
