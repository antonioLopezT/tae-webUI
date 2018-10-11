package com.globant.starbucks.enums;

public enum Browser {

    CHROME("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe", "chrome"),

    FIREFOX("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe", "firefox");

    private String propertie;

    private String url;

    private String id;

    private Browser (String propertie, String url, String id) {
        this.propertie = propertie;
        this.url = url;
        this.id = id;
    }

    public String getPropertie () {
        return propertie;
    }

    public String getUrl () {
        return url;
    }

    public String getId () {
        return id;
    }

}
