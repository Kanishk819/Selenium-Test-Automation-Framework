package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);//Initialize the Instance Variable Driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
    }

    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

        } else {
            System.err.println("Invalid Browser Name.... Please Select Chrome or Edge Only");
        }
    }

    public BrowserUtility(Browser browserName) {
        logger.info("Launching Browser for " + browserName);
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

        } else if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

        } else {
            System.err.println("Invalid Browser Name.... Please Select Chrome or Edge Only");
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadless) {
        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");//Ensure driver launches in headless mode
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            } else {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            }
        } else if (browserName == Browser.EDGE) {
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--window-size=1920,1080");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            } else {
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            }
        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");
                driver.set(new FirefoxDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            } else {
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            }

        } else {
            System.err.println("Invalid Browser Name.... Please Select Chrome or Edge Only");
        }
    }

    public void goToWebsite(String url) {
        logger.info("Visiting the Website " + url);
        driver.get().get(url);
    }

    public void maximizeWindow() {
        logger.info("Maximizing the Browser Window");
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator) {
        logger.info("Element found with locator" + locator);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        logger.info("Element found and now performing click " + locator);
        element.click();
    }

    public void clickOnCheckBox(By locator) {
        logger.info("Element found with locator" + locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element found and now performing click " + locator);
        element.click();
    }

    public void clickOn(WebElement element) {
        logger.info("Element found and now performing click");
        element.click();
    }

    public void clearText(By textBoxLocator) {
        logger.info("Element found with locator" + textBoxLocator);
//        WebElement element = driver.get().findElement(textBoxLocator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
        logger.info("Element found and clearing the text box field ");
        element.clear();
    }

    public void enterText(By locator, String text) {
        logger.info("Element found with locator" + locator);
//        WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element found and now Entering text " + text);
        element.sendKeys(text);
    }

    public void enterSpecialKey(By locator, Keys keyToEnter) {
        logger.info("Element found with locator" + locator);

        WebElement element = driver.get().findElement(locator);
        logger.info("Element found and now Enter the special key " + keyToEnter);

        element.sendKeys(keyToEnter);
    }


    public String getVisibleText(By locator) {
        logger.info("Element found with locator" + locator);
//        WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element found and now returning the visible text " + element.getText());
        return element.getText();
    }

    public String getVisibleText(WebElement element) {
        logger.info("Returning the visible text " + element.getText());
        return element.getText();
    }

    public List<String> getAllVisibleText(By locator) {
        logger.info("Element found with locator" + locator);
        List<WebElement> elementList = driver.get().findElements(locator);
        logger.info("Elements found and now printing the List of Elements");
        List<String> visibleTextList = new ArrayList<>();
        for (WebElement element : elementList) {
            visibleTextList.add(getVisibleText(element));
        }
        return visibleTextList;
    }

    public List<WebElement> getAllElements(By locator) {
        logger.info("Element found with locator" + locator);
        List<WebElement> elementList = driver.get().findElements(locator);
        logger.info("Elements found and now returning the List of Elements");
        return elementList;
    }

    public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
        logger.info("Element found with locator" + dropDownLocator);
        WebElement element = driver.get().findElement(dropDownLocator);
        Select select = new Select(element);
        logger.info("Selecting the option" + optionToSelect);
        select.selectByVisibleText(optionToSelect);

    }

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = "./screenshots/" + name + " - " + "timeStamp" + ".png";
        File screeshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screeshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return path;
    }

    public void quitDriver() {
        driver.get().quit();
    }

}
