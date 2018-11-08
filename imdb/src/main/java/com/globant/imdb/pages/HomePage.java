package com.globant.imdb.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.globant.imdb.common.Commons;

/**
 * This class represents the home page of the IMDB web site.
 *
 * @author joseantonio.lopez
 */
public class HomePage extends BasePage {

    /**
     * Css selector for the main menu.
     */
    private String mainMenuSelector = "#consumer_main_nav li.js_nav_item";

    /**
     * Css selector for the values in the main menu option.
     */
    private String optionDescriptionSelector = "p.navCategory > a";

    /**
     * Css selector for the opening this week options.
     */
    private String openingThisWeekSelector = "#sidebar > div:nth-child(6) > span > div > div > div";

    /**
     * Css selector for the titles in the opening this week section.
     */
    private String titlesOpeningThisWeekSelector = "div.rhs-row > div.title";

    /**
     * Constructor for initialize values and open the web browser in the specify
     * url.
     *
     * @param webDriver The <code>WebDriver</code>
     * @author joseantonio.lopez
     */
    public HomePage (WebDriver webDriver) {
        super(webDriver);
        webDriver.get(Commons.getPropertie("website.url"));
        webDriver.manage().window().maximize();
    }

    /**
     * Method that obtains the number of options that are in the main menu.
     *
     * @return A <code>int</code> with the value of number of options.
     * @author joseantonio.lopez
     */
    public int getNumberOfMainMenuOptions () {
        int num = 0;
        List<WebElement> mainMenuOptions = getWebDriver().findElements(By.cssSelector(mainMenuSelector));
        if ((mainMenuOptions != null) && !mainMenuOptions.isEmpty()) {
            num = mainMenuOptions.size();
        }
        return num;
    }

    /**
     * Method that obtains the description(s) of the main menu option depending of
     * the index.
     *
     * @param index Number of index of the main manu option
     * @return A <code>List</code> with the value(s) of the description(s).
     * @author joseantonio.lopez
     */
    public List<String> getDescriptionsOfMainMenuOption (int index) {
        List<WebElement> mainMenuOptions = getWebDriver().findElements(By.cssSelector(mainMenuSelector));
        WebElement mainMenuOption = mainMenuOptions.get(index);
        List<WebElement> descriptions = mainMenuOption.findElements(By.cssSelector(optionDescriptionSelector));
        List<String> textDescriptions = new ArrayList<>();
        descriptions.forEach(des -> textDescriptions.add(des.getText()));
        return textDescriptions;
    }

    /**
     * Method that obtains the list of opening this week options.
     *
     * @return A <code>List</code> with the values of the opening this week options.
     * @author joseantonio.lopez
     */
    public List<String> getOpeningThisWeekOptions () {
        WebElement openingThisWeek = getWebDriver().findElement(By.cssSelector(openingThisWeekSelector));
        List<WebElement> titles = openingThisWeek.findElements(By.cssSelector(titlesOpeningThisWeekSelector));
        List<String> textTitles = new ArrayList<>();
        titles.forEach(des -> textTitles.add(des.getText()));
        return textTitles;
    }

    /**
     * Method that redirect to the celebrity born today page.
     *
     * @return A <code>CelebBornTodayPage</code>.
     * @author joseantonio.lopez
     */
    public CelebBornTodayPage goToCelebBornToday () {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(getWebDriver().findElement(By.linkText(Commons.getPropertie("celebs.link.text"))));
        actions.build().perform();
        By bornTodayLocator = By.linkText(Commons.getPropertie("celebs.born.link.text"));
        waitClickable(bornTodayLocator);
        getWebDriver().findElement(bornTodayLocator).click();
        return new CelebBornTodayPage(getWebDriver());
    }

}
