package com.globant.rest.endpoints;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;

import com.globant.rest.commons.Commons;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * This class represents the setup for the Json placeholder endpoint.
 *
 * @author joseantonio.lopez
 */
public class JsonPlaceholder {

    /**
     * JSONPlaceholder endpoint "https://jsonplaceholder.typicode.com"
     */
    private final String endpointUrl;

    /**
     * Constant that identify the schemas folder.
     */
    private static final String SCHEMA_FOLDER = "schemas";

    /**
     * Constant that identify the extension of the schema file.
     */
    private static final String SCHEMA_EXTENSION = ".json";

    /**
     * Constructor for initialize values.
     *
     * @author joseantonio.lopez
     */
    public JsonPlaceholder () {
        endpointUrl = Commons.getPropertie("jsonplaceholder.endpoint");
    }

    /**
     * Get the {@link Response} of the resource.
     *
     * @param resource The resource of the endpoint.
     * @return A <code>Response</code> of the resource.
     * @author joseantonio.lopez
     */
    public Response getResponseResource (String resource) {
        return get(getUrl(resource));
    }

    /**
     * Get the {@link JsonPath} of the resource.
     *
     * @param resource The resource of the endpoint.
     * @return A <code>JsonPath</code> of the resource.
     * @author joseantonio.lopez
     */
    public JsonPath getJsonPathResource (String resource) {
        return getResponseResource(resource).jsonPath();
    }

    /**
     * Get the value of the node by jsonPath.
     *
     * @param jsonPath The jsonPath.
     * @param query    The query to search node
     * @return A <code>String</> of the value.
     * @author joseantonio.lopez
     */
    public String getNodeWithJsonPath (JsonPath jsonPath, String query) {
        return jsonPath.getList(query, String.class).get(0);
    }

    /**
     * Get the JSON of the node by jsonPath.
     *
     * @param jsonPath The jsonPath.
     * @param query    The query to search node
     * @return A <code>String</> as JSON.
     * @author joseantonio.lopez
     */
    public String getNodeAsJson (JsonPath jsonPath, String query) {
        return jsonPath.getJsonObject(query).toString();
    }

    /**
     * Get JSON from resource sending parameters.
     *
     * @param resource The resource of the endpoint.
     * @param params   <code>Map</code> with the parameters.
     * @return A <code>String</code> as JSON.
     * @author joseantonio.lopez
     */
    public String getJsonFromResourceWithParams (String resource, Map<String, Object> params) {
        return given().params(params).when().get(getUrl(resource)).then().statusCode(HttpStatus.SC_OK).extract().body()
                .asString();
    }

    /**
     * Get the Json placeholder url endpoint.
     *
     * @return A <code>String</code> of the property value.
     * @author joseantonio.lopez
     */
    public String getEndpointUrl () {
        return endpointUrl;
    }

    /**
     * Get the Url of the endpoint with resource.
     *
     * @param resource The resource of the endpoint.
     * @return A <String> of the url value;
     * @author joseantonio.lopez
     */
    private String getUrl (String resource) {
        StringBuilder url = new StringBuilder();
        url.append(endpointUrl).append("/").append(resource);
        return url.toString();
    }

    /**
     * Method that get the schema file as Stream.
     *
     * @param resource The resource of the endpoint.
     * @return An <code>InputStream</code> of the schema file.
     * @author joseantonio.lopez
     */
    public InputStream getSchemaFile (String resource) {
        StringBuilder file = new StringBuilder();
        file.append(SCHEMA_FOLDER).append(File.separator);
        file.append(resource).append(SCHEMA_EXTENSION);
        return this.getClass().getClassLoader().getResourceAsStream(file.toString());
    }

}
