package locators;

import com.microsoft.playwright.Locator;
import tests.BaseTest;

public class Input{
    public static Locator inputByType(String type){
        return BaseTest.basePage.page.locator("//input[@type='" + type + "']");
    }

    public static Locator inputById(String id){
        return BaseTest.basePage.page.locator("//input[@id='" + id + "']");
    }

}
