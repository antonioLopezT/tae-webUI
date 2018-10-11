package com.globant.starbucks.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Commons {

    public static final String BUTTON_TAG = "button";

    private Commons () {

    }

    public static void click (WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
}