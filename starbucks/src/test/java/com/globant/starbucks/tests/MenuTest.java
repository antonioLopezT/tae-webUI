package com.globant.starbucks.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.CoffeeFinderPage;
import com.globant.starbucks.pages.StarbucksHomePage;

public class MenuTest extends BaseTest {

    @Test
    public void testMenuOptions () {
        StarbucksHomePage homePage = new StarbucksHomePage(driver.getDriver());
        List<String> options = homePage.getMenuOptions();
        List<String> properties = getProperties("starbucks.menu.options");
        Assert.assertEquals(options, properties);
    }

    @Test (dataProvider = "coffeeData")
    public void testPerfectCoffee (Integer coffee) {
        StarbucksHomePage homePage = new StarbucksHomePage(driver.getDriver());
        CoffeeFinderPage coffeeFinderPage = homePage.goToCoffeFinder();
        coffeeFinderPage.findPefectCoffee(coffee);
        Assert.assertTrue(coffeeFinderPage.isFindMyCoffeeButtonDisplayed());
        coffeeFinderPage.selectFindMyCoffeeButton();
        Assert.assertEquals(coffeeFinderPage.getCurrentUrl(), getPropertie("starbucks.url.finder"));
    }

    @DataProvider (name = "coffeeData")
    public static Object[][] coffeeData () {
        return new Object[][] { { 0 }, { 1 }, { 2 } };
    }
}
