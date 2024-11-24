package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.WebActions;

public class LoginPage extends BasePage {
    public final Locator USERNAME_EDITBOX;
    public final Locator PASSWORD_EDITBOX;
    private final Locator LOGIN_BUTTON;
    private final Locator REGISTER_LINK;
    private final Locator USER;
    public final Locator ERROR_MESSAGE;

    public LoginPage(Page page, String testCaseName) {
        super(page, testCaseName);
        this.USERNAME_EDITBOX = page.locator("//input[@formcontrolname='username']");
        this.PASSWORD_EDITBOX = page.locator("//input[@formcontrolname='password']");
        this.LOGIN_BUTTON = page.locator("//button/span[text()='Login']");
        this.REGISTER_LINK = page.locator("//button/span[text()='Register']");
        this.USER = page.locator("//*[@aria-haspopup='menu']//span[contains(@class, 'label')]");
        this.ERROR_MESSAGE = page.locator("//mat-error");
    }

    public void navigateToUrl() {
        super.navigateToUrl("https://bookcart.azurewebsites.net/login");
    }

    public void enterUsername(String username) {
        USERNAME_EDITBOX.fill(username);
    }

    public void enterPassword(String password) {
        PASSWORD_EDITBOX.fill(password);
    }

    public void clickLogin() {
        LOGIN_BUTTON.click();
    }

    public void clickRegister() {
        REGISTER_LINK.click();
    }

    public void clickOnIcon(String iconName) {
        this.PAGE.getByText(iconName, new Page.GetByTextOptions().setExact(true)).click();  // Clicks on the Exact text
    }

    public boolean verifyProfilePage() {
        return WebActions.waitUntilElementDisplayed(this.USER, 30);
    }

    public String getErrorMessage(){
        return this.ERROR_MESSAGE.innerText();
    }
}
