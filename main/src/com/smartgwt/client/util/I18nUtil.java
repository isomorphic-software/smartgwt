package com.smartgwt.client.util;

import com.smartgwt.client.i18n.SmartGwtMessages;
import com.google.gwt.core.client.GWT;

public class I18nUtil {

    /**
     * Setup SmartGWT i18n.
     */
    public static void init() {
        SmartGwtMessages messages = GWT.create(SmartGwtMessages.class);
        doInit(messages);
    }

    private static native void doInit(SmartGwtMessages messages) /*-{

         $wnd.isc.RPCManager.addClassProperties({timeoutErrorMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::rpcManager_timeoutErrorMessage()()});
    }-*/;
}
