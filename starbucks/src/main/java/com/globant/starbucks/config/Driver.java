package com.globant.starbucks.config;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.globant.starbucks.common.Commons;
import com.globant.starbucks.enums.Browser;

/**
 * This class represents the <code>WebDriver</code> that is going to be use
 * depending the browser.
 *
 * @author joseantonio.lopez
 */
public class Driver {

    /**
     * Instance variable of {@link WebDriver}
     */
    private WebDriver webDriver;

    /**
     * Constructor that depending the browser a <code>WebDriver</code> is going to
     * be created.
     *
     * @param browser The browser to be created.
     * @author joseantonio.lopez
     */
    public Driver (String browser) {
        final String os = System.getProperty(Commons.OS_PROPERTY).toLowerCase();
        if (browser.equals(Browser.FIREFOX.getId())) {
            setDriverByOSAndBrowser(Browser.FIREFOX, os);
            webDriver = new FirefoxDriver();
        } else {
            setDriverByOSAndBrowser(Browser.CHROME, os);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            webDriver = new ChromeDriver(options);
        }
    }

    /**
     * Set the driver in system property.
     *
     * @param driver  The <code>WebDriver</code>
     * @param browser The browser.
     * @param os      The operation system.
     * @author joseantonio.lopez
     */
    private void setDriverByOSAndBrowser (Browser browser, String os) {
        StringBuilder url = new StringBuilder();
        url.append("src").append(File.separator);
        url.append("test").append(File.separator);
        url.append("resources").append(File.separator);
        url.append("drivers").append(File.separator);

        if (os.contains(Commons.WINDOWS)) {
            url.append("win").append(File.separator);
            url.append(browser.getUrl());
            url.append(".exe");
        } else {
            url.append("mac").append(File.separator);
            url.append(browser.getUrl());
        }
        System.setProperty(browser.getPropertie(), url.toString());
    }

    /**
     * Get the <code>WebDriver<code> property value.
     *
     * @return A <code>WebDriver</code> with the property value.
     *
     * @author joseantonio.lopez
     */
    public WebDriver getDriver () {
        return webDriver;
    }

}
