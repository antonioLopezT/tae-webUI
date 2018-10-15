package com.globant.starbucks.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.AccountPage;
import com.globant.starbucks.pages.CardPage;
import com.globant.starbucks.pages.CoffeeFinderPage;
import com.globant.starbucks.pages.SingInPage;
import com.globant.starbucks.pages.StarbucksHomePage;

/**
 * This class represents the test that are going to be executed against the
 * Starbucks page.
 *
 * @author joseantonio.lopez
 */
public class StarbucksTest extends BaseTest {

    /**
     * Test that validate the options in the main menu of the Starbucks home page
     * against a list in a properties file
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 1)
    public void testMenuOptions () {
        StarbucksHomePage homePage = new StarbucksHomePage(driver.getDriver());
        List<String> options = homePage.getMenuOptions();
        List<String> properties = getProperties("starbucks.menu.options");
        Assert.assertEquals(options, properties);
    }

    /**
     * Test that select all the answers of all the questions in the coffee finder
     * page and validate that the button is visible and the current url once the
     * button is clicked is correct.
     *
     * @param coffee Parameter obtain by a {@link DataProvider}
     * @author joseantonio.lopez
     */
    @Test (priority = 2, dataProvider = "coffeeProvider")
    public void testPerfectCoffee (Integer coffee) {
        StarbucksHomePage homePage = new StarbucksHomePage(driver.getDriver());
        CoffeeFinderPage coffeeFinderPage = homePage.goToCoffeFinder();
        coffeeFinderPage.findPefectCoffee(coffee);
        Assert.assertTrue(coffeeFinderPage.isFindMyCoffeeVisible());
        coffeeFinderPage.selectFindMyCoffeeButton();
        Assert.assertEquals(coffeeFinderPage.getCurrentUrl(), getPropertie("starbucks.url.finder"));
    }

    /**
     * Test that login in the starbucks page, select a gift card, fill the form for
     * the gift card and validate that the correct buttons are visible.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 3)
    public void testGiftCard () {
        StarbucksHomePage homePage = new StarbucksHomePage(driver.getDriver());
        SingInPage singInPage = homePage.goToSingIn();
        AccountPage accountPage = singInPage.singIn(getPropertie("starbucks.username"),
                getPropertie("starbucks.password"));
        CardPage cardPage = accountPage.selectGift();
        cardPage.checkOutCard(getPropertie("starbucks.card.name"), getPropertie("starbucks.card.email"),
                getPropertie("starbucks.card.message"));
        Assert.assertEquals(cardPage.getTextSendGift(), getPropertie("starbucks.sendGift"));
        cardPage.selectPayment();
        Assert.assertEquals(cardPage.getTextContinue(), getPropertie("starbucks.continue"));
    }

    /**
     * Data provider.
     *
     * @return All the data for the test.
     * @author joseantonio.lopez
     */
    @DataProvider (name = "coffeeProvider")
    public static Object[][] coffeeProvider () {
        return new Object[][] { { 0 }, { 1 }, { 2 } };
    }
}
