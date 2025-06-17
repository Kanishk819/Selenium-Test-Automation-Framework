package com.ui.tests;

import com.ui.pages.SearchResultPage;
import static com.ui.pages.Size.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckoutTest extends TestBase{

    private static final String SEARCH_TERM = "Printed Summer Dress";
    private SearchResultPage searchResultPage;

    @BeforeMethod(description = "User logs into the application and searches for the product")
    public void setup(){
       searchResultPage = homePage.goToLoginPage().doLoginWith("javafo8487@noroasis.com","password").searchForAProduct(SEARCH_TERM);
    }

    @Test(description = "Verify if the logged in User is able to buy a dress", groups = {"e2e","smoke","sanity"})
    public void checkoutTest(){
        searchResultPage.clickOnTheFirstProductAt(0).changeSize(L);
    }
}
