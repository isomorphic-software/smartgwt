package com.mycompany.client.util;

class ConsoleStaticImplSupported extends ConsoleStaticImpl {

    @Override
    native void log(String message) /*-{
        $wnd.console.log(message);
    }-*/;

    @Override
    native void warn(String message) /*-{
        $wnd.console.warn(message);
    }-*/;

    @Override
    native void error(String message) /*-{
        $wnd.console.error(message);
    }-*/;
}
