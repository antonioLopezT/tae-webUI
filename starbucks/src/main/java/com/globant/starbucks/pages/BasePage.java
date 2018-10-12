package com.globant.starbucks.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    private static final long WAIT_TIME = 10;
    private static final String VISIBILITY_MESSAGE = "Time out exception waiting visibility";
    private static final String CLICKABLE_MESSAGE = "Time out exception waiting clickable element";

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor javaScriptExe;

    public BasePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WAIT_TIME);
        this.driver = driver;
        this.javaScriptExe = (JavascriptExecutor) driver;
    }

    public WebDriver getDriver () {
        return driver;
    }

    public WebDriverWait getWait () {
        return wait;
    }

    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }

    public JavascriptExecutor getJavaScriptExe () {
        return javaScriptExe;
    }

    public void waitVisibility (WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            LOGGER.error(VISIBILITY_MESSAGE, e);
        }
    }

    public void waitVisibility (List<WebElement> elements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {
            LOGGER.error(VISIBILITY_MESSAGE, e);
        }
    }

    public void waitVisibility (By locator) {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            LOGGER.error(VISIBILITY_MESSAGE, e);
        }
    }

    public void waitClickable (WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            LOGGER.error(CLICKABLE_MESSAGE, e);
        }
    }

}
