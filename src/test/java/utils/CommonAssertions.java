package utils;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CommonAssertions {
    @Step("Then verify {locatorName} is visible")
    public static void isVisible(Locator locator, String locatorName){
        assertThat(locator).isVisible();
    }

    @Step("Then verify {locatorName} text is displayed correctly")
    public static void verifyText(Locator locator, String locatorName, String text){
        assertThat(locator).hasText(text);
    }

    @Step("Then verify value in {columnName} displayed correctly")
    public static void verifyValueInColumn(Locator table, String columnName, List<String> columnValuesEXP){
        List<String> columnValuesUI = CommonActions.getListValueByColumn(table, columnName);
        System.out.println(columnValuesEXP);
        System.out.println(columnValuesUI);
        assertTrue(columnValuesEXP.containsAll(columnValuesUI));
    }
}
