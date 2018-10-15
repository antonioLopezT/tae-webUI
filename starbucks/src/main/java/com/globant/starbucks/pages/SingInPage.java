package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.starbucks.common.Commons;

/**
 * This class represents the sing in page of the Starbucks account.
 *
 * @author joseantonio.lopez
 */
public class SingInPage extends BasePage {

    @FindBy (xpath = "//label[text()='Username or email address']//following-sibling::input")
    private WebElement usernameInput;

    @FindBy (xpath = "//label[text()='Password']//following-sibling::input")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement singInButton;

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>WebDriver</code>.
     * @author joseantonio.lopez
     */
    public SingInPage (WebDriver driver) {
        super(driver);
    }

    /**
     * Method that complete the form with the account information and submit the
     * form clicking the sing in button.
     *
     * @param username The username of the account.
     * @param password The password of the account.
     * @return A <code>AccountPage</code>.
     * @author joseantonio.lopez
     */
    public AccountPage singIn (String username, String password) {
        waitVisibility(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        waitVisibility(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        waitClickable(singInButton);
        Commons.click(getDriver(), singInButton);
        return new AccountPage(getDriver());
    }
}
