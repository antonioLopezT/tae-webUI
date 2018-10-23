package com.globant.mobile.pages;

import org.openqa.selenium.By;

import com.globant.mobile.commons.Commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * This class represents the Home in page.
 *
 * @author joseantonio.lopez
 */
public class HomePage extends BasePage {

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>AppiumDriver</code>.
     * @author joseantonio.lopez
     */
    public HomePage (AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Method that obtain the text from the home message.
     *
     * @return A <code>String</code>
     * @author joseantonio.lopez
     */
    public String getHomeMessage () {
        StringBuilder sb = new StringBuilder();
        sb.append(Commons.getPropertie("android.app.package")).append(":id/");
        String appPackage = sb.toString();
        By messageText = By.id(appPackage + "message");

        waitVisibility(messageText);

        MobileElement message = getMobileDriver().findElement(messageText);
        return message.getText();
    }
}
