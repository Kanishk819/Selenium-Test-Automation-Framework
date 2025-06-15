package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class MyAccountPage extends BrowserUtility {

    private static final By USER_NAME_LOCATOR = By.xpath("//a[@title= 'View my customer account']/span");
    private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
//    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_LOCATOR));
        return getVisibleText(USER_NAME_LOCATOR);
    }

    public SearchResultPage searchForAProduct(String productName) {
        enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
        enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        return searchResultPage;
    }
}
