package com.globant.imdb.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.globant.imdb.common.Commons;
import com.globant.imdb.driver.Driver;

/**
 * This class represents the base test for all the tests in the testing
 * framework.
 *
 * @author joseantonio.lopez
 */
public class BaseTest {

    /**
     * Instance variable of {@link Driver}
     */
    public Driver driver;

    /**
     * Method that is going to be executed before every test.
     *
     * @author joseantonio.lopez
     */
    @BeforeTest (alwaysRun = true)
    public void beforeTest () {
        String browser = System.getProperty(Commons.getPropertie("browser.name"));
        driver = new Driver(browser);
    }

    /**
     * Method that is going to be executed after every test.
     *
     * @author joseantonio.lopez
     */
    @AfterTest (alwaysRun = true)
    public void afterTest () {
        if (driver != null) {
            driver.getWebDriver().quit();
        }
    }

}
