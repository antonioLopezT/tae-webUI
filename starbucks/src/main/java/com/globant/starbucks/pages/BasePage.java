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

/**
 * This class represents the base page of all the pages in the framework.
 *
 * @author joseantonio.lopez
 */
public abstract class BasePage {

    /**
     * Element for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    /**
     * Constant for the implicit wait time.
     */
    private static final long WAIT_TIME = 10;
    /**
     * Constant for the visibility message.
     */
    private static final String VISIBILITY_MESSAGE = "Time out exception waiting visibility";
    /**
     * Constant for the clickable message.
     */
    private static final String CLICKABLE_MESSAGE = "Time out exception waiting clickable element";

    /**
     * Instance varible of {@link WebDriver}
     */
    private WebDriver driver;
    /**
     * Instance varible of {@link WebDriverWait}
     */
    private WebDriverWait wait;
    /**
     * Instance varible of {@link JavascriptExecutor}
     */
    private JavascriptExecutor javaScriptExe;

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>WebDriver</code>.
     * @author joseantonio.lopez
     */
    public BasePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WAIT_TIME);
        this.driver = driver;
        this.javaScriptExe = (JavascriptExecutor) driver;
    }

    /**
     * Get the <code>WebDriver<code> property value.
     *
     * @return A <code>WebDriver</code> with the property value.
     *
     * @author joseantonio.lopez
     */
    public WebDriver getDriver () {
        return driver;
    }

    /**
     * Get the <code>WebDriverWait<code> property value.
     *
     * @return A <code>WebDriverWait</code> with the property value.
     *
     * @author joseantonio.lopez
     */
    public WebDriverWait getWait () {
        return wait;
    }

    /**
     * Get the current url of the web browser.
     *
     * @return A <code>String</code> of the current url;
     * @author joseantonio.lopez
     */
    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }

    /**
     * Get the <code>JavascriptExecutor<code> property value.
     *
     * @return A <code>JavascriptExecutor</code> with the property value.
     *
     * @author joseantonio.lopez
     */
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

    /**
     * Method for waiting the visibility of all the elements in the list.
     *
     * @param elements A list of <code>WebElement</code>.
     * @author joseantonio.lopez
     */
    public void waitVisibility (List<WebElement> elements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {
            LOGGER.error(VISIBILITY_MESSAGE, e);
        }
    }

    /**
     * Method for waiting the visibility of a element located by a
     * <code>Locator</code>.
     *
     * @param locator The locator {@link By}
     * @author joseantonio.lopez
     */
    public void waitVisibility (By locator) {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            LOGGER.error(VISIBILITY_MESSAGE, e);
        }
    }

    /**
     * Method for waiting a element to be clickable.
     *
     * @param element The <code>WebElement</code>.
     * @author joseantonio.lopez
     */
    public void waitClickable (WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            LOGGER.error(CLICKABLE_MESSAGE, e);
        }
    }

}
