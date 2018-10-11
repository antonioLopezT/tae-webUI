package com.globant.starbucks.tests;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.globant.starbucks.config.Driver;

public class BaseTest {

    Driver driver;

    private ResourceBundle resource = ResourceBundle.getBundle("config");

    @BeforeSuite (alwaysRun = true)
    public void beforeSuite () {
        String browser = System.getProperty("browser");
        driver = new Driver(browser);
    }

    @AfterSuite (alwaysRun = true)
    public void afterSuite () {
        // driver.getDriver().quit();
    }

    public String getPropertie (String key) {
        return resource.getString(key);
    }

    public List<String> getProperties (String key) {
        String[] arr = resource.getString(key).split(",");
        return Arrays.asList(arr);
    }

}
