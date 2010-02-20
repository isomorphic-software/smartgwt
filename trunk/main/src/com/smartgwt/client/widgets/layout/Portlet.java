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
 
package com.smartgwt.client.widgets.layout;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Custom subclass of Window configured to be embedded within a PortalLayout.
 */
public class Portlet extends Window {

    public static Portlet getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Portlet) obj;
        } else {
            return new Portlet(jsObj);
        }
    }

    public Portlet(){
        scClassName = "Portlet";
    }

    public Portlet(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Portlet.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Confirmation message to show the user when closing portlets if {@link
     * com.smartgwt.client.widgets.layout.Portlet#getShowCloseConfirmationMessage showCloseConfirmationMessage} is true.
     *
     * @param closeConfirmationMessage closeConfirmationMessage Default value is "Close portlet?"
     */
    public void setCloseConfirmationMessage(String closeConfirmationMessage) {
        setAttribute("closeConfirmationMessage", closeConfirmationMessage, true);
    }

    /**
     * Confirmation message to show the user when closing portlets if {@link
     * com.smartgwt.client.widgets.layout.Portlet#getShowCloseConfirmationMessage showCloseConfirmationMessage} is true.
     *
     *
     * @return String
     */
    public String getCloseConfirmationMessage()  {
        return getAttributeAsString("closeConfirmationMessage");
    }

    /**
     * If true, {@link com.smartgwt.client.widgets.layout.Portlet#getCloseConfirmationMessage closeConfirmationMessage} will be
     * displayed before portlets are closed
     *
     * @param showCloseConfirmationMessage showCloseConfirmationMessage Default value is true
     */
    public void setShowCloseConfirmationMessage(Boolean showCloseConfirmationMessage) {
        setAttribute("showCloseConfirmationMessage", showCloseConfirmationMessage, true);
    }

    /**
     * If true, {@link com.smartgwt.client.widgets.layout.Portlet#getCloseConfirmationMessage closeConfirmationMessage} will be
     * displayed before portlets are closed
     *
     *
     * @return Boolean
     */
    public Boolean getShowCloseConfirmationMessage()  {
        return getAttributeAsBoolean("showCloseConfirmationMessage");
    }

    // ********************* Methods ***********************
            
    /**
     * closeClick overridden to show {@link com.smartgwt.client.widgets.layout.Portlet#getCloseConfirmationMessage
     * closeConfirmationMessage} to the user before removing the portlet from the PortalLayout via {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removePortlet}
     */
    public native void closeClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.closeClick();
    }-*/;

    // ********************* Static Methods ***********************

}



