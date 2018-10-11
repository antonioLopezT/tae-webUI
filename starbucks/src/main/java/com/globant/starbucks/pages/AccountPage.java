package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.starbucks.common.Commons;

public class AccountPage extends BasePage {

    @FindBy (xpath = "//a[text()='Gift']")
    private WebElement giftLink;

    @FindBy (xpath = "//a[@href='/gift/873069716']")
    private WebElement cardLink;

    public AccountPage (WebDriver driver) {
        super(driver);
    }

    public CardPage selectGift () {
        getWait().until(ExpectedConditions.elementToBeClickable(giftLink));
        Commons.click(getDriver(), giftLink);
        getWait().until(ExpectedConditions.elementToBeClickable(cardLink));
        Commons.click(getDriver(), cardLink);
        return new CardPage(getDriver());
    }
}
