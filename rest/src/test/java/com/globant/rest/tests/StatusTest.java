package com.globant.rest.tests;

import static io.restassured.RestAssured.get;

import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

/**
 * This class represent the tests for the HTTP Status code of the resources.
 *
 * @author joseantonio.lopez
 */
public class StatusTest extends BaseTest {

    /**
     * Element for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(StatusTest.class);
    /**
     * JSONPlaceholder endpoint "https://jsonplaceholder.typicode.com"
     */
    private final String endpointUrl;

    /**
     * @author joseantonio.lopez
     */
    public StatusTest () {
        endpointUrl = getPropertie("jsonplaceholder.endpoint");
    }

    /**
     * Test that validate the 200 HTTP response status of the posts resource.
     *
     * @param The resource of the endpoint.
     * @author joseantonio.lopez
     */
    @Test (dataProvider = "resourceProvider")
    public void testStatusPostsResource (String resource) {
        StringBuilder url = new StringBuilder();
        url.append(endpointUrl).append(resource);
        Response response = get(url.toString());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        LOGGER.info("Resource: " + resource + " Status Code: " + response.getStatusCode());
    }

    /**
     * Data provider.
     *
     * @return All the data for the test.
     * @author joseantonio.lopez
     */
    @DataProvider (name = "resourceProvider")
    public Object[][] coffeeProvider () {
        List<String> list = getProperties("jsonplaceholder.resources");
        return new Object[][] { { list.get(0) }, { list.get(1) }, { list.get(2) }, { list.get(3) }, { list.get(4) },
                { list.get(5) }, };
    }
}
