package com.smartgwt.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public abstract class AbstractSmartEvent<H extends EventHandler> extends GwtEvent<H> {

    protected JavaScriptObject jsObj;

    protected AbstractSmartEvent(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }
}
