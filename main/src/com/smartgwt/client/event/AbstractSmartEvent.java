package com.smartgwt.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import com.smartgwt.client.util.JSOHelper;

public abstract class AbstractSmartEvent<H extends EventHandler> extends GwtEvent<H> {

    protected JavaScriptObject jsObj;

    protected AbstractSmartEvent(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    protected JavaScriptObject getFiringInstanceAsJavaScriptObject() {
        return jsObj != null ? JSOHelper.getAttributeAsJavaScriptObject(jsObj, "_this") : null;
    }
}
