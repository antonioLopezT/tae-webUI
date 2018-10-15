package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.globant.starbucks.common.Commons;

/**
 * This class represents the Card page of the Starbucks Gift Card.
 *
 * @author joseantonio.lopez
 */
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

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>WebDriver</code>.
     * @author joseantonio.lopez
     */
    public CardPage (WebDriver driver) {
        super(driver);
    }

    /**
     * Method that complete the information in the checkout form and click on the
     * checkout button.
     *
     * @param name    Name for the input element.
     * @param email   Email for the input element.
     * @param message Message for the input element.
     * @author joseantonio.lopez
     */
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

    /**
     * Get the text in the send gift button.
     *
     * @return A <code>String</code> of the text in the send gift button.
     * @author joseantonio.lopez
     */
    public String getTextSendGift () {
        waitClickable(sendGiftButton);
        return sendGiftButton.getText();
    }

    /**
     * Method for select the Master Card option in the combo element.
     *
     * @author joseantonio.lopez
     */
    public void selectPayment () {
        Select select = new Select(paymentSelect);
        select.selectByValue("masterpass");
    }

    /**
     * Get the text in the continue button.
     *
     * @return A <code>String</code> of the text in the continue button.
     * @author joseantonio.lopez
     */
    public String getTextContinue () {
        waitClickable(continueButton);
        return continueButton.getText();
    }
}
