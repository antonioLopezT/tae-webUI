package com.globant.starbucks.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.starbucks.common.Commons;

/**
 * This class represents the Coffee finder page in the Starbucks web page.
 *
 * @author joseantonio.lopez
 */
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

    /**
     * Constructor for initialize values.
     *
     * @param driver The <code>WebDriver</code>.
     * @author joseantonio.lopez
     */
    public CoffeeFinderPage (WebDriver driver) {
        super(driver);
    }

    /**
     * Method that select all the answers to find the perfect coffee.
     *
     * @param coffee A <code>Integer</code> that indentify the number of the answer.
     * @author joseantonio.lopez
     */
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

    /**
     * Method that return <code>True</code> if the find my coffee button is visible
     * or <code>False</code> otherwise.
     *
     * @return A <code>Boolean</code> of the visibility of the coffee button.
     * @author joseantonio.lopez
     */
    public boolean isFindMyCoffeeVisible () {
        waitVisibility(findMyCoffeeButton);
        return findMyCoffeeButton.isDisplayed() && findMyCoffeeButton.isEnabled();
    }

    /**
     * Method that select the find my coffee button.
     *
     * @author joseantonio.lopez
     */
    public void selectFindMyCoffeeButton () {
        waitClickable(findMyCoffeeButton);
        findMyCoffeeButton.click();
        waitVisibility(By.id("back-top"));
    }

    /**
     * Method that select the answer of the given question and answer index.
     *
     * @param question A <code>WebElement</code> that represent the question.
     * @param coffee   A <code>Integer</code> that represent the index of the
     *                 answer.
     * @author joseantonio.lopez
     */
    private void selectAnswer (WebElement question, Integer coffee) {
        waitVisibility(question);
        List<WebElement> options = question.findElements(By.tagName(Commons.BUTTON_TAG));
        waitVisibility(options);
        options.get(coffee).click();
    }

}
