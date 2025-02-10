package utils;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

public class CommonActions {
    @Step("Then scroll to {locatorName}")
    public static void scrollToLocator(Locator locator, String locatorName){
        locator.scrollIntoViewIfNeeded();
    }

    @Step("Then click on {locatorName}")
    public static void clickOnLocator(Locator locator, String locatorName){
        locator.click();
    }

    @Step("And get {columnName} index")
    public static int getColumnIndex(Locator table, String columnName){
        List<String> itemHeaders = table.locator("//thead/tr[1]/th/div/span").allTextContents();
        System.out.println("ItemHeaders:>> " + itemHeaders);
        return itemHeaders.indexOf(columnName) + 1;
    }
    @Step("And get list value in {columnName} column")
    public static List<String> getListValueByColumn(Locator table, String columnName){
        int columnIndex = getColumnIndex(table, columnName);
        System.out.println("columnIndex:>>>>" + columnIndex);
        List<Locator> rows = table.locator(("//tbody/tr")).all();
        return rows.stream()
                .map((Locator row) ->
                        row.locator("//td")
                                .nth(columnIndex - 1)
                                .textContent().trim()
                )
                .collect(Collectors.toList());
    }

    @Step("And get {cssProperty}")
    public static String getCssValue(Locator locator, String cssProperty){
        return (String) locator.evaluate("(e, p) => getComputedStyle(e).getPropertyValue(p)", cssProperty);
    }
}
