package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JavaScriptObject;

public class ContactName extends JavaScriptObject {

    public static native ContactName create() /*-{
        return new $wnd.ContactName();
    }-*/;

    protected ContactName() {}

    public final native String getFormatted() /*-{
        return this.formatted;
    }-*/;

    public final native void setFormatted(String formatted) /*-{
        this.formatted = formatted;
    }-*/;

    public final native String getFamilyName() /*-{
        return this.familyName;
    }-*/;

    public final native void setFamilyName(String familyName) /*-{
        this.familyName = familyName;
    }-*/;

    public final native String getGivenName() /*-{
        return this.givenName;
    }-*/;

    public final native void setGivenName(String givenName) /*-{
        this.givenName = givenName;
    }-*/;

    public final native String getMiddleName() /*-{
        return this.middleName;
    }-*/;

    public final native void setMiddleName(String middleName) /*-{
        this.middleName = middleName;
    }-*/;

    public final native String getHonorificPrefix() /*-{
        return this.honorificPrefix;
    }-*/;

    public final native void setHonorificPrefix(String honorificPrefix) /*-{
        this.honorificPrefix = honorificPrefix;
    }-*/;

    public final native String getHonorificSuffix() /*-{
        return this.honorificSuffix;
    }-*/;

    public final native void setHonorificSuffix(String honorificSuffix) /*-{
        this.honorificSuffix = honorificSuffix;
    }-*/;
}
