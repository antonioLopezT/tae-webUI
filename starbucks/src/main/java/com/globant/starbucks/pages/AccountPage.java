package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.starbucks.common.Commons;

/**
 * This class represents the Account page of the Starbucks Gift Card.
 *
 * @author joseantonio.lopez
 */
public class AccountPage extends BasePage {

    @FindBy (xpath = "//a[text()='Gift']")
    private WebElement giftLink;

    @FindBy (xpath = "//a[@href='/gift/873069716']")
    private WebElement cardLink;

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>WebDriver</code>.
     * @author joseantonio.lopez
     */
    public AccountPage (WebDriver driver) {
        super(driver);
    }

    /**
     * Method for clicking the link of gift.
     *
     * @return The <code>CardPage</code>
     * @author joseantonio.lopez
     */
    public CardPage selectGift () {
        waitClickable(giftLink);
        Commons.click(getDriver(), giftLink);
        waitClickable(cardLink);
        Commons.click(getDriver(), cardLink);
        return new CardPage(getDriver());
    }
}
