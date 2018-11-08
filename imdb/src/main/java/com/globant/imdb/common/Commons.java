package com.globant.imdb.common;

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
     * <code>ResourceBundle</code> to get information of a properties file.
     */
    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle("resources");

    /**
     * Character for split a string.
     */
    private static final String SPLIT_CHAR = ",";

    /**
     * Private constructor.
     *
     * @author joseantonio.lopez
     */
    private Commons () {

    }

    /**
     * Get the single value of a property.
     *
     * @param key The key of the property.
     * @return A <code>String</code> with the value of the property.
     * @author joseantonio.lopez
     */
    public static String getPropertie (String key) {
        return RESOURCE.getString(key);
    }

    /**
     * Get a list of values of a property.
     *
     * @param key The key of the property.
     * @return A <code>List</code> of <code>String</code> with the values of the
     *         property.
     * @author joseantonio.lopez
     */
    public static List<String> getPropertiesAsList (String key) {
        String[] arr = RESOURCE.getString(key).split(SPLIT_CHAR);
        return Arrays.asList(arr);
    }
}
