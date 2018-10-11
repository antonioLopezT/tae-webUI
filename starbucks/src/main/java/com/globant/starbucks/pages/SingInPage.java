package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.starbucks.common.Commons;

public class SingInPage extends BasePage {

    @FindBy (xpath = "//label[text()='Username or email address']//following-sibling::input")
    private WebElement usernameInput;

    @FindBy (xpath = "//label[text()='Password']//following-sibling::input")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement singInButton;

    public SingInPage (WebDriver driver) {
        super(driver);
    }

    public AccountPage singIn (String username, String password) {
        getWait().until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        getWait().until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        getWait().until(ExpectedConditions.elementToBeClickable(singInButton));
        Commons.click(getDriver(), singInButton);
        return new AccountPage(getDriver());
    }
}
