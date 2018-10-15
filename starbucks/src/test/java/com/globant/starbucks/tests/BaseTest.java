package com.globant.starbucks.tests;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.globant.starbucks.config.Driver;

/**
 * This class represents the base test for all the test in the framework.
 *
 * @author joseantonio.lopez
 */
public class BaseTest {

    /**
     * Driver
     */
    Driver driver;

    /**
     * Resource to get information of the properties file.
     */
    private ResourceBundle resource = ResourceBundle.getBundle("config");

    /**
     * Method that runs before the suite.
     *
     * @author joseantonio.lopez
     */
    @BeforeSuite (alwaysRun = true)
    public void beforeSuite () {
        String browser = System.getProperty("browser");
        driver = new Driver(browser);
    }

    /**
     * Method that runs after the suite.
     *
     * @author joseantonio.lopez
     */
    @AfterSuite (alwaysRun = true)
    public void afterSuite () {
        driver.getDriver().quit();
    }

    /**
     * Get a single propertie.
     *
     * @param key The key of the propertie.
     * @return A <code>String</code> with the value of the propertie.
     * @author joseantonio.lopez
     */
    public String getPropertie (String key) {
        return resource.getString(key);
    }

    /**
     * Get a list of properties.
     *
     * @param key The key of the propertie with values separated with commas.
     * @return A <code>List</code> of <code>String</code> with the values of the
     *         propertie.
     * @author joseantonio.lopez
     */
    public List<String> getProperties (String key) {
        String[] arr = resource.getString(key).split(",");
        return Arrays.asList(arr);
    }

}
