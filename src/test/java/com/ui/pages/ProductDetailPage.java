package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BrowserUtility {

    private static final By SIZE_DROP_DOWN = By.id("group_1");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(Size size){
        selectFromDropDown(SIZE_DROP_DOWN,size.toString());
        return new ProductDetailPage(getDriver());
    }
}
