package com.globant.imdb.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.imdb.common.Commons;

/**
 * This class represents the base page for all the pages in the testing
 * framework.
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
    private static final long WAIT_TIME = Integer.valueOf(Commons.getPropertie("implicit.wait.time"));
    /**
     * Constant for the visibility message.
     */
    private static final String VISIBILITY_MESSAGE = Commons.getPropertie("timeout.visibility");
    /**
     * Constant for the clickable message.
     */
    private static final String CLICKABLE_MESSAGE = Commons.getPropertie("timeout.clickable");
    /**
     * Instance varible of {@link WebDriver}
     */
    private WebDriver webDriver;
    /**
     * Instance varible of {@link WebDriverWait}
     */
    private WebDriverWait wait;

    /**
     * Constructor for initialize values.
     *
     * @param webDriver The <code>WebDriver</code>.
     * @author joseantonio.lopez
     */
    public BasePage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, WAIT_TIME);
        this.webDriver = webDriver;
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            LOGGER.error(VISIBILITY_MESSAGE, e);
        }
    }

    /**
     * Method for waiting a element to be clickable located by a
     * <code>Locator</code>.
     *
     * @param locator The locator {@link By}
     * @author joseantonio.lopez
     */
    public void waitClickable (By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            LOGGER.error(CLICKABLE_MESSAGE, e);
        }
    }

    /**
     * Get the current url of the web browser.
     *
     * @return A <code>String</code> of the current url;
     * @author joseantonio.lopez
     */
    public String getCurrentUrl () {
        return webDriver.getCurrentUrl();
    }

    /**
     * Get the title of website.
     *
     * @return A <code>String</code> with the title value.
     * @author joseantonio.lopez
     */
    public String getTitle () {
        return webDriver.getTitle();
    }

    /**
     * Get the <code>WebDriver<code> property value.
     *
     * @return A <code>WebDriver</code> with the property value.
     *
     * @author joseantonio.lopez
     */
    public WebDriver getWebDriver () {
        return webDriver;
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
