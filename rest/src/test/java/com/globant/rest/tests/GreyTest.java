package com.globant.rest.tests;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globant.rest.endpoints.Grey;

/**
 * This class represent the tests against the jsonplaceholder endpoint an his
 * resources.
 *
 * @author joseantonio.lopez
 */
public class GreyTest {

    /**
     * Element for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(GreyTest.class);

    /**
     * Header value to be set by user.
     */
    private static final String HEADER_VALUE = "";

    /**
     * Grey endpoint.
     */
    private final Grey endpoint;

    /**
     * Constructor for initialize values.
     *
     * @author joseantonio.lopez
     */
    public GreyTest () {
        endpoint = new Grey();
    }

    /**
     * Test that validate the call to grey´s endpont with headers and params.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 1, enabled = true)
    public void testHeader () {
        Map<String, Object> params = new HashMap<>();
        params.put("u", "qa");
        params.put("q", "publish_6847");
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", HEADER_VALUE);
        String json = endpoint.getJsonFromResourceWithParams(params, headers);
        Assert.assertNotNull(json);
        LOGGER.info(json);
    }
}
