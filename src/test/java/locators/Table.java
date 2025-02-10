package locators;

import com.microsoft.playwright.Locator;
import tests.BaseTest;

public class Table {

    public static Locator table(){
        return BaseTest.basePage.page.locator("//table");
    }
    public static Locator tableByParentTag(String tag){
        return BaseTest.basePage.page.locator("//" + tag + "//table");
    }

    public static Locator tableCellByRowColumnIndex(int rowIndex, int columnIndex){
        return BaseTest.basePage.page.locator("//table//tr[" + rowIndex + "]/th[" + columnIndex + "]");
    }

    public static Locator tableColumnByText(String text){
        return BaseTest.basePage.page.locator("//thead/tr/th[@role='columnheader']/div/span[normalize-space()='" + text + "']");
    }

    public static Locator backgroundByColumnName(String colName){
        return BaseTest.basePage.page.locator("(//mat-form-field/div[1])[count(//span[normalize-space()='" + colName + "']//ancestor::th//preceding-sibling::th)]");
    }

    public static Locator matSelectContainsThClass(String thClass){
        return BaseTest.basePage.page.locator("//th[contains(@class, '" + thClass + "')]//mat-select");
    }
}
