package com.globant.starbucks.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.collections.CollectionUtils;

public class StarbucksHomePage extends BasePage {

    private static final String URL = "http://www.starbucks.com/";

    @FindBy (css = "#nav > div.nav_menu > ul > li")
    private List<WebElement> menu;

    @FindBy (css = "#nav_coffee > a")
    private WebElement coffeeMenu;

    @FindBy (linkText = "Find Your Perfect Coffee")
    private WebElement perfectCoffeeLink;

    @FindBy (xpath = "//li[@class='utility_link signin']/child::a")
    private WebElement singInLink;

    public StarbucksHomePage (WebDriver driver) {
        super(driver);
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public List<String> getMenuOptions () {
        List<String> options = new ArrayList<>();
        if (CollectionUtils.hasElements(menu)) {
            menu.forEach(m -> options.add(m.getText()));
        }
        return options;
    }

    public CoffeeFinderPage goToCoffeFinder () {
        Actions action = new Actions(getDriver());
        action.moveToElement(coffeeMenu).perform();
        getWait().until(ExpectedConditions.visibilityOf(perfectCoffeeLink));
        action.moveToElement(perfectCoffeeLink);
        getWait().until(ExpectedConditions.elementToBeClickable(perfectCoffeeLink));
        action.click();
        action.perform();
        return new CoffeeFinderPage(getDriver());
    }

    public SingInPage goToSingIn () {
        getWait().until(ExpectedConditions.elementToBeClickable(singInLink));
        singInLink.click();
        return new SingInPage(getDriver());
    }

}
