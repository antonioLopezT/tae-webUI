package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private static final long WAIT_TIME = 10;

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WAIT_TIME);
        this.driver = driver;
    }

    public WebDriver getDriver () {
        return driver;
    }

    public WebDriverWait getWait () {
        return wait;
    }

}
