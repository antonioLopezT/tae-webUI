package com.globant.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.globant.mobile.commons.Commons;
import com.globant.mobile.pages.HomePage;
import com.globant.mobile.pages.LogInPage;

/**
 * This class represents the test that are going to be executed against the
 * mobile app.
 *
 * @author joseantonio.lopez
 */
public class MobileTest extends BaseTest {

    /**
     * Test that validate the login of the mobile app sending the email and password
     * values.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 1, enabled = true)
    public void testLogin () {
        LogInPage logInPage = new LogInPage(driver.getMobileDriver());
        HomePage homePage = logInPage.logIn("antonio@globant", "password");
        String messageText = homePage.getHomeMessage();
        Assert.assertEquals(messageText, Commons.getPropertie("android.assert.home"));
    }

}
