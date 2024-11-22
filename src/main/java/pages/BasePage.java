package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    private Page page;
    public BasePage(Page page) {
      this.page = page;
    };

    public void navigateToUrl(String url) {
        this.page.navigate(url);
    };


}