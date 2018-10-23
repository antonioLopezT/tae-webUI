package com.globant.mobile.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.globant.mobile.driver.Driver;

/**
 * This class represents the base test for all the test in the framework.
 *
 * @author joseantonio.lopez
 */
public class BaseTest {

    /**
     * Element for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    /**
     * Driver
     */
    Driver driver;

    /**
     * Method that runs before the suite.
     *
     * @author joseantonio.lopez
     */
    @BeforeSuite (alwaysRun = true)
    public void beforeSuite () {
        try {
            driver = new Driver();
        } catch (MalformedURLException e) {
            LOGGER.error("Error creating driver: ", e);
        }
    }

    /**
     * Method that runs after the suite.
     *
     * @author joseantonio.lopez
     */
    @AfterSuite (alwaysRun = true)
    public void afterSuite () {
        driver.closeApp();
    }

}
