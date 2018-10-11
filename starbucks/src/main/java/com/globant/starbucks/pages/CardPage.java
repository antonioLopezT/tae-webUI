package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.globant.starbucks.common.Commons;

public class CardPage extends BasePage {

    @FindBy (xpath = "//label[text()='Recipient Name']//following-sibling::input")
    private WebElement nameInput;

    @FindBy (xpath = "//label[text()='Recipient Email']//following-sibling::input")
    private WebElement emailInput;

    @FindBy (xpath = "//label[text()='Message (optional)']//following-sibling::input")
    private WebElement messageInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement checkOutButton;

    @FindBy (xpath = "//button[text()='Send gift']")
    private WebElement sendGiftButton;

    @FindBy (xpath = "//select[@id='paymentMethod']")
    private WebElement paymentSelect;

    @FindBy (xpath = "//select[@id='paymentMethod']//child::option[@value='masterpass']")
    private WebElement masterCardOption;

    @FindBy (xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    public CardPage (WebDriver driver) {
        super(driver);
    }

    public void checkOutCard (String name, String email, String message) {
        getWait().until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.clear();
        nameInput.sendKeys(name);
        getWait().until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
        getWait().until(ExpectedConditions.visibilityOf(messageInput));
        messageInput.clear();
        messageInput.sendKeys(message);
        getWait().until(ExpectedConditions.elementToBeClickable(checkOutButton));
        Commons.click(getDriver(), checkOutButton);
    }

    public String getTextSendGift () {
        getWait().until(ExpectedConditions.elementToBeClickable(sendGiftButton));
        return sendGiftButton.getText();
    }

    public void selectPayment () {
        Select select = new Select(paymentSelect);
        select.selectByValue("masterpass");
    }

    public String getTextContinue () {
        getWait().until(ExpectedConditions.elementToBeClickable(continueButton));
        return continueButton.getText();
    }
}
