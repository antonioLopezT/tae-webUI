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

public class StarbucksTest extends BaseTest {

    @Test (priority = 1)
    public void testMenuOptions () {
        StarbucksHomePage homePage = new StarbucksHomePage(driver.getDriver());
        List<String> options = homePage.getMenuOptions();
        List<String> properties = getProperties("starbucks.menu.options");
        Assert.assertEquals(options, properties);
    }

    @Test (priority = 2, dataProvider = "coffeeProvider")
    public void testPerfectCoffee (Integer coffee) {
        StarbucksHomePage homePage = new StarbucksHomePage(driver.getDriver());
        CoffeeFinderPage coffeeFinderPage = homePage.goToCoffeFinder();
        coffeeFinderPage.findPefectCoffee(coffee);
        Assert.assertTrue(coffeeFinderPage.isFindMyCoffeeVisible());
        coffeeFinderPage.selectFindMyCoffeeButton();
        Assert.assertEquals(coffeeFinderPage.getCurrentUrl(), getPropertie("starbucks.url.finder"));
    }

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

    @DataProvider (name = "coffeeProvider")
    public static Object[][] coffeeProvider () {
        return new Object[][] { { 0 }, { 1 }, { 2 } };
    }
}
