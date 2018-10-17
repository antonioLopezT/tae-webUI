package com.globant.rest.endpoints;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;

import com.globant.rest.commons.Commons;

/**
 * This class represents the setup for the grey endpoint.
 *
 * @author joseantonio.lopez
 */
public class Grey {

    /**
     * Grey endpoint
     * "https://gp_search.grey.com/gp_searchapi/search?d=id&p=t&c=t&s=publish&m=all"
     */
    private final String endpointUrl;

    /**
     * Constructor for initialize values.
     *
     * @author joseantonio.lopez
     */
    public Grey () {
        endpointUrl = Commons.getPropertie("grey.endpoint");
    }

    /**
     * Get JSON from resource sending parameters.
     *
     * @param params  <code>Map</code> with the parameters.
     * @param headers <code>Map</code> with the headers.
     * @return A <code>String</code> as JSON.
     * @author joseantonio.lopez
     */
    public String getJsonFromResourceWithParams (Map<String, Object> params, Map<String, Object> headers) {
        return given().headers(headers).params(params).when().get(getEndpointUrl()).then().statusCode(HttpStatus.SC_OK)
                .extract().body().asString();
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

}
