package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {

    private static final By PRODUCT_LISTING_TITLE_LOCATOR= By.xpath("//span[contains(@class,'lighter')]");
    private static final By ALL_PRODUCT_LISTS = By.xpath("//h5[@itemprop = 'name']/a");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitle(){
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
        List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_LISTS);
        return productNamesList.stream()
                .anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
    }

    public ProductDetailPage clickOnTheProductAtIndex(int index) {
        clickOn(getAllElements(ALL_PRODUCT_LISTS).get(index));
        return new ProductDetailPage(getDriver());
    }

}
