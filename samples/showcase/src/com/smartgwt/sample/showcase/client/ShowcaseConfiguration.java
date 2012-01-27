package com.smartgwt.sample.showcase.client;

import com.smartgwt.sample.showcase.client.data.ExplorerTreeNode;

public class ShowcaseConfiguration  {

    private final boolean openForTesting;

    private ShowcaseConfiguration() {
        String value = com.google.gwt.user.client.Window.Location.getParameter("autotest");
        openForTesting = null != value ? value.equals("true") : false;
    }

    public boolean isOpenForTesting() {
        return openForTesting;
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
