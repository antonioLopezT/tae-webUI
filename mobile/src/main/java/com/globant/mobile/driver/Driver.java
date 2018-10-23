package com.globant.mobile.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.globant.mobile.commons.Commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * This class represents the <code>AppiumDriver</code> that is going to be used.
 *
 * @author joseantonio.lopez
 */
public class Driver {

    /**
     * Instance variable of {@link AppiumDriver}.
     */
    private final AppiumDriver<MobileElement> driver;

    /**
     * Constructor for initialize values.
     *
     * @author joseantonio.lopez
     * @throws MalformedURLException
     */
    public Driver () throws MalformedURLException {
        URL url = new URL(Commons.getPropertie("appium.url"));
        File appDir = new File(Commons.getPropertie("android.app.url"));
        File app = new File(appDir, Commons.getPropertie("android.app.name"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Commons.getPropertie("android.app.platform"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Commons.getPropertie("android.version"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Commons.getPropertie("android.app.device"));
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("appPackage", Commons.getPropertie("android.app.package"));
        capabilities.setCapability("appActivity", Commons.getPropertie("android.app.activity"));

        capabilities.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver<>(url, capabilities);
    }

    /**
     * Method that close the app using configure driver.
     *
     * @author joseantonio.lopez
     */
    public void closeApp () {
        if (driver != null) {
            driver.closeApp();
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

}
