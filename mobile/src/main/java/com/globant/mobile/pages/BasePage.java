package com.globant.mobile.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * This class represents the base page of all the pages in the framework.
 *
 * @author joseantonio.lopez
 */
public class BasePage {

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
     * Instance variable of {@link AppiumDriver}.
     */
    private final AppiumDriver<MobileElement> driver;

    /**
     * Instance varible of {@link WebDriverWait}
     */
    private WebDriverWait wait;

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>AppiumDriver</code>.
     * @author joseantonio.lopez
     */
    public BasePage (AppiumDriver<MobileElement> driver) {
        wait = new WebDriverWait(driver, WAIT_TIME);
        this.driver = driver;
    }

    /**
     * Method for waiting the visibility of the mobile element.
     *
     * @param element The <code>MobileElement</code>
     * @author joseantonio.lopez
     */
    public void waitVisibility (MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
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
     * Get the <code>AppiumDriver</code> property value.
     *
     * @return A <code>AppiumDriver</code> with the property value.
     * @author joseantonio.lopez
     */
    public AppiumDriver<MobileElement> getMobileDriver () {
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

}
