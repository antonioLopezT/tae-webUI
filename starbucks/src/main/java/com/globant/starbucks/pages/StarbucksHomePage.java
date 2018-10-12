package com.globant.starbucks.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.collections.CollectionUtils;

import com.globant.starbucks.common.Commons;

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
        action.moveToElement(coffeeMenu).build().perform();
        waitClickable(perfectCoffeeLink);
        perfectCoffeeLink.click();
        return new CoffeeFinderPage(getDriver());
    }

    public SingInPage goToSingIn () {
        waitClickable(singInLink);
        Commons.click(getDriver(), singInLink);
        return new SingInPage(getDriver());
    }

}
