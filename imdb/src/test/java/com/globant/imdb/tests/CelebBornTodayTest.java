package com.globant.imdb.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.imdb.common.Commons;
import com.globant.imdb.pages.CelebBornTodayPage;
import com.globant.imdb.pages.HomePage;

/**
 * This class represents the test that are going to be executed against the IMDB
 * celebrity born today page.
 *
 * @author joseantonio.lopez
 */
public class CelebBornTodayTest extends BaseTest {

    /**
     * Element for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(CelebBornTodayTest.class);

    /**
     * Instance variable of {@link CelebBornTodayPage}
     */
    private CelebBornTodayPage celebPage;

    /**
     * Test that validate the name of the first celebrity born today.
     *
     * @param index Index of the celebrity position.
     * @param name  Name of the celebrity.
     * @author joseantonio.lopez
     */
    @Test (priority = 1, enabled = true, dataProvider = "celebNamesProvider")
    public void testFirstCelebrity (int index, String name) {
        HomePage homePage = new HomePage(driver.getWebDriver());
        celebPage = homePage.goToCelebBornToday();
        String celeb = celebPage.getNameCelebrity(index);

        LOGGER.info("Celebrity name: " + celeb);

        Assert.assertNotNull(celeb);
        Assert.assertEquals(celeb, name);
    }

    /**
     * Data provider.
     *
     * @return All the data for the test.
     * @author joseantonio.lopez
     */
    @DataProvider (name = "celebNamesProvider")
    public static Object[][] celebNamesProvider () {
        List<String> names = Commons.getPropertiesAsList("celebs.name.born");
        Object[][] matrix = new Object[names.size()][2];
        for (int i = 0; i < names.size(); i++) {
            Object[] arr = new Object[] { i, names.get(i) };
            matrix[i] = arr;
        }
        return matrix;
    }

}
