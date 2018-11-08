package com.globant.imdb.enums;

/**
 * Enum that maps the differents types of browsers.
 *
 * @author joseantonio.lopez
 */
public enum Browser {

    /**
     * Chrome.
     */
    CHROME("webdriver.chrome.driver", "chromedriver", "chrome"),

    /**
     * Firefox.
     */
    FIREFOX("webdriver.gecko.driver", "geckodriver", "firefox");

    /**
     * Key for propertie system {@link System#setProperty(String, String)}.
     */
    private String propertie;

    /**
     * Url of the location of the <code>WebDriver</code>.
     */
    private String url;

    /**
     * Identifier of the <code>WebDriver</code>.
     */
    private String id;

    /**
     * Constructor for initialize values.
     *
     * @author joseantonio.lopez
     * @param propertie The key for propertie system.
     * @param url       Url of the location of the <code>WebDriver</code>.
     * @param id        Identifier of the <code>WebDriver</code>.
     */
    private Browser (String propertie, String url, String id) {
        this.propertie = propertie;
        this.url = url;
        this.id = id;
    }

    /**
     * Get the propertie value.
     *
     * @return A <code>String</code> with the propertie value.
     * @author joseantonio.lopez
     */
    public String getPropertie () {
        return propertie;
    }

    /**
     * Get the Url propertie value.
     *
     * @return A <code>String</code> with the propertie value.
     * @author joseantonio.lopez
     */
    public String getUrl () {
        return url;
    }

    /**
     * Get the Id propertie value.
     *
     * @return A <code>String</code> with the propertie value.
     * @author joseantonio.lopez
     */
    public String getId () {
        return id;
    }

}
