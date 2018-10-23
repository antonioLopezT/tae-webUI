package com.globant.mobile.commons;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class represents commons utilities for the testing framework.
 *
 * @author joseantonio.lopez
 */
public class Commons {

    /**
     * Resource to get information of the properties file.
     */
    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle("resources");

    /**
     * Private constructor.
     *
     * @author joseantonio.lopez
     */
    private Commons () {

    }

    /**
     * Get a single propertie.
     *
     * @param key The key of the propertie.
     * @return A <code>String</code> with the value of the propertie.
     * @author joseantonio.lopez
     */
    public static String getPropertie (String key) {
        return RESOURCE.getString(key);
    }

    /**
     * Get a list of properties.
     *
     * @param key The key of the propertie with values separated with commas.
     * @return A <code>List</code> of <code>String</code> with the values of the
     *         propertie.
     * @author joseantonio.lopez
     */
    public static List<String> getProperties (String key) {
        String[] arr = RESOURCE.getString(key).split(",");
        return Arrays.asList(arr);
    }

}
