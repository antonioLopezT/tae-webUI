package com.globant.mobile.pages;

import org.openqa.selenium.By;

import com.globant.mobile.commons.Commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * This class represents the Log in page.
 *
 * @author joseantonio.lopez
 */
public class LogInPage extends BasePage {

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>AppiumDriver</code>.
     * @author joseantonio.lopez
     */
    public LogInPage (AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Method that enter email and password for the log in.
     *
     * @param email    The email.
     * @param password The password
     * @return A <code>HomePage</code>.
     * @author joseantonio.lopez
     */
    public HomePage logIn (String email, String password) {
        StringBuilder sb = new StringBuilder();
        sb.append(Commons.getPropertie("android.app.package")).append(":id/");
        String appPackage = sb.toString();
        By userInput = By.id(appPackage + "email");
        By passwordInput = By.id(appPackage + "password");
        By loginButton = By.id(appPackage + "email_sign_in_button");

        getMobileDriver().findElement(userInput).sendKeys(email);
        getMobileDriver().findElement(passwordInput).sendKeys(password);
        getMobileDriver().findElement(loginButton).click();

        return new HomePage(getMobileDriver());
    }

}
