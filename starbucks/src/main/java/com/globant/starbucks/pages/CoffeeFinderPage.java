package com.globant.starbucks.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.starbucks.common.Commons;

public class CoffeeFinderPage extends BasePage {

    @FindBy (id = "question1")
    private WebElement question1;

    @FindBy (id = "question2")
    private WebElement question2;

    @FindBy (id = "light-questions")
    private WebElement question3A;

    @FindBy (id = "medium-questions")
    private WebElement question3B;

    @FindBy (id = "dark-questions")
    private WebElement question3C;

    @FindBy (id = "question4")
    private WebElement question4;

    @FindBy (id = "find-my-coffee")
    private WebElement findMyCoffeeButton;

    public CoffeeFinderPage (WebDriver driver) {
        super(driver);
    }

    public void findPefectCoffee (Integer coffee) {
        selectAnswer(question1, coffee);
        selectAnswer(question2, coffee);
        switch (coffee.intValue()) {
        case 0:
            selectAnswer(question3A, coffee);
            break;
        case 1:
            selectAnswer(question3B, coffee);
            break;
        default:
            selectAnswer(question3C, coffee);
            break;
        }
        selectAnswer(question4, coffee);

    }

    public boolean isFindMyCoffeeVisible () {
        getWait().until(ExpectedConditions.visibilityOf(findMyCoffeeButton));
        return findMyCoffeeButton.isDisplayed() && findMyCoffeeButton.isEnabled();
    }

    public void selectFindMyCoffeeButton () {
        getWait().until(ExpectedConditions.elementToBeClickable(findMyCoffeeButton));
        findMyCoffeeButton.click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("back-top")));
    }

    private void selectAnswer (WebElement question, Integer coffee) {
        getWait().until(ExpectedConditions.visibilityOf(question));
        List<WebElement> options = question.findElements(By.tagName(Commons.BUTTON_TAG));
        getWait().until(ExpectedConditions.visibilityOfAllElements(options));
        Commons.click(getDriver(), options.get(coffee));
    }

}
