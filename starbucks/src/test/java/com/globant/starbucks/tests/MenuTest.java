package com.globant.starbucks.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.CoffeeFinderPage;
import com.globant.starbucks.pages.StarbucksHomePage;

public class MenuTest extends BaseTest {

    private StarbucksHomePage homePage;

    @Test
    public void testMenuOptions () {
        homePage = new StarbucksHomePage(driver.getDriver());
        List<String> options = homePage.getMenuOptions();
        List<String> properties = getProperties("starbucks.menu.options");
        Assert.assertEquals(options, properties);
    }

    @Test
    public void testPerfectCoffee () {
        CoffeeFinderPage finderPage = homePage.goToCoffeFinder();
    }
}
