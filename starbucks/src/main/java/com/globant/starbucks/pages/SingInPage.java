package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
