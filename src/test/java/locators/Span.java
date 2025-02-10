package locators;

import com.microsoft.playwright.Locator;
import tests.BaseTest;

public class Span{
    public static Locator spanByText(String text){
        return BaseTest.basePage.page.locator("//span[normalize-space()='" + text + "']");
    }

    public static Locator spanById(String id){
        return BaseTest.basePage.page.locator("//span[@id='" + id + "']");
    }
}
