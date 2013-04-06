package com.smartgwt.sample.showcase.client;


public class ShowcaseConfiguration  {

    private final int maxDetailsLength;
    private final boolean openForTesting;

    private ShowcaseConfiguration() {
        String value;
        value = com.google.gwt.user.client.Window.Location.getParameter("autotest");
        openForTesting = null != value ? value.equals("true") : false;
        value = com.google.gwt.user.client.Window.Location.getParameter("autotest_report_limit");
        maxDetailsLength = null != value ? Integer.parseInt(value) : 0;
    }

    public boolean isOpenForTesting() {
        return openForTesting;
    }
    public int getMaximumDetailsLength() {
        return maxDetailsLength;
    }

    // singleton paradigm for ShowcaseConfiguration

    private static ShowcaseConfiguration singleton;

    public static ShowcaseConfiguration getSingleton() {
        if (singleton == null) {
            singleton = new ShowcaseConfiguration();
        }
        return singleton;
    }
}