package com.globant.rest.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.rest.commons.Commons;
import com.globant.rest.endpoints.JsonPlaceholder;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * This class represent the tests against the jsonplaceholder endpoint an his
 * resources.
 *
 * @author joseantonio.lopez
 */
public class JsonPlaceholderTest {

    /**
     * Element for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(JsonPlaceholderTest.class);

    /**
     * Json placeholder endpoint.
     */
    private final JsonPlaceholder endpoint;

    /**
     * Constructor for initialize values.
     *
     * @author joseantonio.lopez
     */
    public JsonPlaceholderTest () {
        endpoint = new JsonPlaceholder();
    }

    /**
     * Test that validate the 200 HTTP response status of all resources.
     *
     * @param resource The resource of the endpoint.
     * @author joseantonio.lopez
     */
    @Test (dataProvider = "resourceProvider", priority = 1, enabled = true)
    public void testStatusPostsResource (String resource) {
        Response response = endpoint.getResponseResource(resource);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        LOGGER.info("Resource: " + resource + " Status Code: " + response.getStatusCode());
    }

    /**
     * Test that validate the JSON Schema of all resources.
     *
     * @param resource The resource of the endpoint.
     * @author joseantonio.lopez
     */
    @Test (dataProvider = "resourceProvider", priority = 2, enabled = true)
    public void testResourceSchema (String resource) {
        Response response = endpoint.getResponseResource(resource);
        try {
            response.then().assertThat().body(matchesJsonSchema(endpoint.getSchemaFile(resource)));
            LOGGER.info("Resource: " + resource + " Schema match: " + Boolean.TRUE);
        } catch (AssertionError e) {
            LOGGER.info("Resource: " + resource + " Schema match: " + Boolean.FALSE);
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Test that validate the data from id 20 in posts resource.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 3, enabled = true)
    public void testPost20 () {
        JsonPath jsonPath = endpoint.getJsonPathResource(Commons.getPropertie("jsonplaceholder.posts"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 20}.userId"),
                Commons.getPropertie("jsonplaceholder.id.20.userId"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 20}.id"),
                Commons.getPropertie("jsonplaceholder.id.20.id"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 20}.title"),
                Commons.getPropertie("jsonplaceholder.id.20.title"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 20}.body"),
                Commons.getPropertie("jsonplaceholder.id.20.body"));

        LOGGER.info("Node with id=20: " + endpoint.getNodeAsJson(jsonPath, "findAll{it.id == 20}"));
    }

    /**
     * Test that validate the data from id 50 in posts resource.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 4, enabled = true)
    public void testPost50 () {
        JsonPath jsonPath = endpoint.getJsonPathResource(Commons.getPropertie("jsonplaceholder.posts"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 50}.userId"),
                Commons.getPropertie("jsonplaceholder.id.50.userId"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 50}.id"),
                Commons.getPropertie("jsonplaceholder.id.50.id"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 50}.title"),
                Commons.getPropertie("jsonplaceholder.id.50.title"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 50}.body"),
                Commons.getPropertie("jsonplaceholder.id.50.body"));

        LOGGER.info("Node with id=50: " + endpoint.getNodeAsJson(jsonPath, "findAll{it.id == 50}"));
    }

    /**
     * Test that validate the data from id 100 in posts resource.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 5, enabled = true)
    public void testPost100 () {
        JsonPath jsonPath = endpoint.getJsonPathResource(Commons.getPropertie("jsonplaceholder.posts"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 100}.userId"),
                Commons.getPropertie("jsonplaceholder.id.100.userId"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 100}.id"),
                Commons.getPropertie("jsonplaceholder.id.100.id"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 100}.title"),
                Commons.getPropertie("jsonplaceholder.id.100.title"));

        Assert.assertEquals(endpoint.getNodeWithJsonPath(jsonPath, "findAll{it.id == 100}.body"),
                Commons.getPropertie("jsonplaceholder.id.100.body"));

        LOGGER.info("Node with id=100: " + endpoint.getNodeAsJson(jsonPath, "findAll{it.id == 100}"));
    }

    /**
     * Test that validate the call for comments resource with parameter.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 6, enabled = true)
    public void testCommentsParameter () {
        Map<String, Object> params = new HashMap<>();
        params.put("postId", 1);
        String json = endpoint.getJsonFromResourceWithParams(Commons.getPropertie("jsonplaceholder.comments"), params);
        Assert.assertNotNull(json);
        LOGGER.info(json);
    }

    /**
     * Test that validate the call for posts resource with parameter.
     *
     * @author joseantonio.lopez
     */
    @Test (priority = 7, enabled = true)
    public void testPostsParameter () {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 1);
        String json = endpoint.getJsonFromResourceWithParams(Commons.getPropertie("jsonplaceholder.posts"), params);
        Assert.assertNotNull(json);
        LOGGER.info(json);
    }

    /**
     * Data provider.
     *
     * @return All the data for the test.
     * @author joseantonio.lopez
     */
    @DataProvider (name = "resourceProvider")
    public Object[][] coffeeProvider () {
        List<String> list = Commons.getProperties("jsonplaceholder.resources");
        return new Object[][] { { list.get(0) }, { list.get(1) }, { list.get(2) }, { list.get(3) }, { list.get(4) },
                { list.get(5) } };
    }
}
