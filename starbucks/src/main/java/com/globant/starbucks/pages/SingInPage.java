package com.globant.starbucks.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingInPage extends BasePage {

    @FindBy (xpath = "//label[text()='Username or email address']//following-sibling::input")
    private WebElement usernameInput;

    @FindBy (xpath = "//label[text()='Password']//following-sibling::input")
    private WebElement passwordInput;

    @FindBy (xpath = "//div[@class='visible']//child::button")
    private WebElement singInButton;

    public SingInPage (WebDriver driver) {
        super(driver);
    }

    public AccountPage singIn (String username, String password) {
        getWait().until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
        getWait().until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
        return new AccountPage(getDriver());
    }
}
