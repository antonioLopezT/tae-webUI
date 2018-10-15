package com.globant.starbucks.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * This class represents commons utilities for the testing framework.
 *
 * @author joseantonio.lopez
 */
public class Commons {

    /**
     * OS property.
     */
    public static final String OS_PROPERTY = "os.name";
    /**
     * System property for windows os.
     */
    public static final String WINDOWS = "win";
    /**
     * System property for mac os.
     */
    public static final String MAC = "mac";
    /**
     * Constant for HTML Button Tag.
     */
    public static final String BUTTON_TAG = "button";
    /**
     * Class variable of {@link Actions}.
     */
    private static Actions action;

    /**
     * Private constructor.
     *
     * @author joseantonio.lopez
     */
    private Commons () {

    }

    /**
     * Uses the method {@link Actions#moveToElement(WebElement)} to move to an
     * specific element and click on it.
     *
     * @param driver  The <code>WebDriver</code>.
     * @param element The <code>WebElement</code> to click.
     * @author joseantonio.lopez
     */
    public static void click (WebDriver driver, WebElement element) {
        if (action == null) {
            action = new Actions(driver);
        }
        action.moveToElement(element).click().build().perform();
    }
}
