package com.ui.tests;


import com.ui.pages.MyAccountPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListeners.class})
public class SearchProductTest extends TestBase {
    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM = "Printed Summer Dress";


    @BeforeMethod(description = "Valid User logs in the application")
    public void setup() {
        myAccountPage = homePage.goToLoginPage().doLoginWith("javafo8487@noroasis.com", "password");
    }

    @Test(description = "Verify if Logged in User is able to search for a product and correct product search results is displayed", groups = {"e2e", "smoke", "sanity"})
    public void verifyProductSearchTest() {
        boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
        Assert.assertTrue(actualResult);

    }
}

