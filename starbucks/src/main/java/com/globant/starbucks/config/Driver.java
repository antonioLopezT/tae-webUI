package com.globant.starbucks.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.globant.starbucks.enums.Browser;

public class Driver {

    private WebDriver webDriver;

    public Driver (String browser) {
        if (browser.equals(Browser.FIREFOX.getId())) {
            System.setProperty(Browser.FIREFOX.getPropertie(), Browser.FIREFOX.getUrl());
            webDriver = new FirefoxDriver();
        } else {
            System.setProperty(Browser.CHROME.getPropertie(), Browser.CHROME.getUrl());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            webDriver = new ChromeDriver(options);
        }
    }

    public WebDriver getDriver () {
        return webDriver;
    }

}
