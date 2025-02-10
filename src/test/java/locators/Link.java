package locators;

import com.microsoft.playwright.Locator;
import tests.BaseTest;

public class Link {
    public static Locator linkByText(String text){
        return BaseTest.basePage.page.locator("//a[normalize-space()='"+ text + "']");
    }
}
