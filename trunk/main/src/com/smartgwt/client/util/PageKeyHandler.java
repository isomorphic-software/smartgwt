package com.smartgwt.client.util;

public abstract class PageKeyHandler {

    public abstract void execute(String keyName);
    
    final public native void cancel()/*-{
        $wnd.isc.Page._keyCallbackCancelled = true;
    }-*/;

}
