package com.globant.starbucks.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoffeeFinderPage extends BasePage {

    private WebElement findMyCoffeeButton;

    public CoffeeFinderPage (WebDriver driver) {
        super(driver);
    }

    public void findPefectCoffee (Integer coffee) {
        WebElement question1 = getDriver().findElement(By.id("question1"));
        List<WebElement> options = question1.findElements(By.tagName("button"));
        getWait().until(ExpectedConditions.visibilityOfAllElements(options));
        options.get(coffee).click();

        WebElement question2 = getDriver().findElement(By.id("question2"));
        getWait().until(ExpectedConditions.visibilityOf(question2));
        options = question2.findElements(By.tagName("button"));
        getWait().until(ExpectedConditions.visibilityOfAllElements(options));
        options.get(coffee).click();

        String questionId = "light-questions";
        if (coffee.intValue() == 1) {
            questionId = "medium-questions";
        } else if (coffee.intValue() == 2) {
            questionId = "dark-questions";
        }

        WebElement question3 = getDriver().findElement(By.id(questionId));
        getWait().until(ExpectedConditions.visibilityOf(question3));
        options = question3.findElements(By.tagName("button"));
        getWait().until(ExpectedConditions.visibilityOfAllElements(options));
        options.get(coffee).click();

        WebElement question4 = getDriver().findElement(By.id("question4"));
        getWait().until(ExpectedConditions.visibilityOf(question4));
        options = question4.findElements(By.tagName("button"));
        getWait().until(ExpectedConditions.visibilityOfAllElements(options));
        options.get(coffee).click();
    }

    public boolean isFindMyCoffeeButtonDisplayed () {
        findMyCoffeeButton = getDriver().findElement(By.id("find-my-coffee"));
        getWait().until(ExpectedConditions.visibilityOf(findMyCoffeeButton));
        return findMyCoffeeButton.isDisplayed() && findMyCoffeeButton.isEnabled();
    }

    public void selectFindMyCoffeeButton () {
        getWait().until(ExpectedConditions.elementToBeClickable(findMyCoffeeButton));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findMyCoffeeButton).click().perform();
    }

}
