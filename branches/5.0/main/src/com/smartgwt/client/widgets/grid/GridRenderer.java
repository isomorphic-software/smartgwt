/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.widgets.grid;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.event.shared.*;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.widgets.*;

/**
 * A flexible, high-speed table that offers consistent cross-platform sizing, clipping, and events.
 */
public class GridRenderer extends Canvas {

    public native static GridRenderer getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            instance = @com.smartgwt.client.widgets.grid.GridRenderer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
        return instance;
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        onBind();
    }

    public GridRenderer(){
        scClassName = "GridRenderer";
    }

    public GridRenderer(JavaScriptObject jsObj){
        scClassName = "GridRenderer";
        setJavaScriptObject(jsObj);
        
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
}
