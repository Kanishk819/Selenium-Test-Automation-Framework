package com.ui.tests;

import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners({com.ui.listeners.TestListeners.class})
public class InvalidCredsLoginTest extends TestBase{
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String INVALID_EMAIL_ADDRESS = "kwedefvfjbvqjn@gmail.com";
    private static final String INVALID_PASSWORD = "QWERTYUIO123";

    @Test(description = "Verifies if proper error messages is shown for user for invalid credentials",groups = {"e2e","sanity"},retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void invalidLoginTest() {
        logger.info("Starting the Invalid Credential test ");
        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage(),"Authentication failed.","Error Message Mismatch");
    }
}
