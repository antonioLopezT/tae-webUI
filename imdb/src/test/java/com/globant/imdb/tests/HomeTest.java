package com.globant.imdb.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.imdb.common.Commons;
import com.globant.imdb.pages.HomePage;

/**
 * This class represents the test that are going to be executed against the IMDB
 * Home page.
 *
 * @author joseantonio.lopez
 */
public class HomeTest extends BaseTest {

    /**
     * Element for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(HomeTest.class);

    /**
     * Instance variable of {@link HomePage}
     */
    private HomePage homePage;

    /**
     * Test that validate the correct url and title of the website.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 1, enabled = true)
    public void testWebSiteURLTitle () {
        homePage = new HomePage(driver.getWebDriver());
        String url = homePage.getCurrentUrl();
        String title = homePage.getTitle();

        LOGGER.info("Current URL: " + url);
        LOGGER.info("Website title: " + title);

        Assert.assertEquals(url, Commons.getPropertie("website.url"));
        Assert.assertEquals(title, Commons.getPropertie("website.title"));
    }

    /**
     * Test that validate that there are 4 options in the main menu
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 2, enabled = true)
    public void testNumberOfMainMenuOptions () {
        int numOptions = homePage.getNumberOfMainMenuOptions();

        LOGGER.info("Number of options in the main menu: " + numOptions);

        Assert.assertEquals(numOptions, Integer.valueOf(Commons.getPropertie("number.menu.options")).intValue());
    }

    /**
     * Test that validate that the description(s) of the main menu option is
     * correct.
     *
     * @param index        Number of index of the main menu option.
     * @param descriptions Descriptions op the main menu option.
     * @author joseantonio.lopez
     */
    @Test (priority = 3, enabled = true, dataProvider = "mainMenuOptionsProvider")
    public void testDescriptionMainMenuOption (int index, List<String> descriptions) {
        List<String> textDescriptions = homePage.getDescriptionsOfMainMenuOption(index);

        LOGGER.info("Description(s) of the main menu option: " + textDescriptions);

        Assert.assertNotNull(textDescriptions);
        Assert.assertEquals(textDescriptions, descriptions);
    }

    /**
     * test that validate that the titles of the opening this week sections are
     * correct.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 4, enabled = true)
    public void testOpeningThisWeekOptions () {
        List<String> textTitles = homePage.getOpeningThisWeekOptions();

        LOGGER.info("Titles of the opening of this week: " + textTitles);

        Assert.assertNotNull(textTitles);
        Assert.assertEquals(textTitles, Commons.getPropertiesAsList("opening.week.options"));
    }

    /**
     * Data provider.
     *
     * @return All the data for the test.
     * @author joseantonio.lopez
     */
    @DataProvider (name = "mainMenuOptionsProvider")
    public static Object[][] mainMenuOptionsProvider () {
        return new Object[][] { { 0, Commons.getPropertiesAsList("description.option.0") },
                { 1, Commons.getPropertiesAsList("description.option.1") },
                { 2, Commons.getPropertiesAsList("description.option.2") },
                { 3, Commons.getPropertiesAsList("description.option.3") } };
    }
}
