package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JavaScriptObject;

public class ContactFindOptions extends JavaScriptObject {

    public static native ContactFindOptions create() /*-{
        return new $wnd.ContactFindOptions();
    }-*/;

    protected ContactFindOptions() {}

    public final native String getFilter() /*-{
        return this.filter;
    }-*/;

    public final native void setFilter(String filter) /*-{
        this.filter = filter;
    }-*/;

    public final native boolean getMultiple() /*-{
        return this.multiple;
    }-*/;

    public final native void setMultiple(boolean multiple) /*-{
        this.multiple = multiple;
    }-*/;
}
