package locators;

import com.microsoft.playwright.Locator;
import tests.BaseTest;

public class Div{
    public static Locator divByText(String text){
        return BaseTest.basePage.page.locator("//div[normalize-space(text())='" + text + "']");
    }

    public static Locator divPaginationNumber(){
        return BaseTest.basePage.page.locator("//div[@class='pagination__items__number__display']");
    }
}