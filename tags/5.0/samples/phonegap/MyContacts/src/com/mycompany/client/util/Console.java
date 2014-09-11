package com.mycompany.client.util;

import com.google.gwt.core.client.GWT;

public class Console {

    private static final ConsoleStaticImpl IMPL = GWT.create(ConsoleStaticImpl.class);

    public static void log(String message) {
        IMPL.log(message);
    }

    public static void warn(String message) {
        IMPL.warn(message);
    }

    public static void error(String message) {
        IMPL.error(message);
    }

    private Console() {}
}
