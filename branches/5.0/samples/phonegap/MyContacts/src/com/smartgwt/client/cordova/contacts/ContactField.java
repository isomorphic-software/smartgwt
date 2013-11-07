package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JavaScriptObject;

public class ContactField extends JavaScriptObject {

    public static native ContactField create() /*-{
        return new $wnd.ContactField();
    }-*/;

    protected ContactField() {}

    public final native boolean isPreferred() /*-{
        return this.pref;
    }-*/;

    public final native void setPreferred(boolean preferred) /*-{
        this.pref = preferred;
    }-*/;

    public final native String getType() /*-{
        return this.type;
    }-*/;

    public final native void setType(String type) /*-{
        this.type = type;
    }-*/;

    public final native String getValue() /*-{
        return this.value;
    }-*/;

    public final native void setValue(String value) /*-{
        this.value = value;
    }-*/;
}
