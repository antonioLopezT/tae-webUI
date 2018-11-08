package com.globant.imdb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class represents the celebrity born today page of the IMDB web site.
 *
 * @author joseantonio.lopez
 */
public class CelebBornTodayPage extends BasePage {

    /**
     * Css selector for list of celebrities born today.
     */
    private String celebrityListSelector = "#main > div > div.lister-list > div";

    /**
     * Css selector for the name of the celebrity.
     */
    private String celebrityNameSelector = "div.lister-item-content > h3 > a";

    /**
     * Constructor for initialize values and open the web browser in the specify
     * url.
     *
     * @param webDriver The <code>WebDriver</code>
     * @author joseantonio.lopez
     */
    public CelebBornTodayPage (WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Method that obtains the name of the celebrity depending of the index.
     *
     * @param index Number of index of the list of celebrities.
     * @return A <code>String</code> with the value of the name.
     * @author joseantonio.lopez
     */
    public String getNameCelebrity (int index) {
        List<WebElement> list = getWebDriver().findElements(By.cssSelector(celebrityListSelector));
        WebElement celebrity = list.get(index);
        WebElement name = celebrity.findElement(By.cssSelector(celebrityNameSelector));
        return name.getText();
    }
}
