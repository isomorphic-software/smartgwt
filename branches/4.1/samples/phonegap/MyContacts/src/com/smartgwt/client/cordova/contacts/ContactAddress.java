package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JavaScriptObject;

public class ContactAddress extends JavaScriptObject {

    public static native ContactAddress create() /*-{
        return new $wnd.ContactAddress();
    }-*/;

    protected ContactAddress() {}

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

    public final native String getFormatted() /*-{
        return this.formatted;
    }-*/;

    public final native void setFormatted(String formatted) /*-{
        this.formatted = formatted;
    }-*/;

    public final native String getStreetAddress() /*-{
        return this.streetAddress;
    }-*/;

    public final native void setStreetAddress(String streetAddress) /*-{
        this.streetAddress = streetAddress;
    }-*/;

    public final native String getLocality() /*-{
        return this.locality;
    }-*/;

    public final native void setLocality(String locality) /*-{
        this.locality = locality;
    }-*/;

    public final native String getRegion() /*-{
        return this.region;
    }-*/;

    public final native void setRegion(String region) /*-{
        this.region = region;
    }-*/;

    public final native String getPostalCode() /*-{
        return this.postalCode;
    }-*/;

    public final native void setPostalCode(String postalCode) /*-{
        this.postalCode = postalCode;
    }-*/;

    public final native String getCountry() /*-{
        return this.country;
    }-*/;

    public final native void setCountry(String country) /*-{
        this.country = country;
    }-*/;
}
