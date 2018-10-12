package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        waitClickable(giftLink);
        Commons.click(getDriver(), giftLink);
        waitClickable(cardLink);
        Commons.click(getDriver(), cardLink);
        return new CardPage(getDriver());
    }
}
