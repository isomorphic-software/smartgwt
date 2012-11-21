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
 
package com.smartgwt.client.widgets.menu.events;



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
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
public class MenuItemClickEvent extends AbstractSmartEvent<ClickHandler>  {

    /**
     * Handler type.
     */
    private static Type<ClickHandler> TYPE;

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasClickHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            MenuItemClickEvent event = new MenuItemClickEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<ClickHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<ClickHandler>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(ClickHandler handler) {
        handler.onClick(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<ClickHandler> getAssociatedType() {
        return TYPE;
    }

    public MenuItemClickEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }


    /**
     * for a menu shown as a context menu, the Canvas the menu was shown                        on.  Otherwise the ${isc.DocUtils.linkForRef('class:Menu')} instance of which this&#010                        ${isc.DocUtils.linkForRef('object:MenuItem')} is a member.
     *
     * @return for a menu shown as a context menu, the Canvas the menu was shown                        on.  Otherwise the ${isc.DocUtils.linkForRef('class:Menu')} instance of which this&#010                        ${isc.DocUtils.linkForRef('object:MenuItem')} is a member.
     */
    public  native Canvas getTarget() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.target);
    }-*/;

    /**
     * The ${isc.DocUtils.linkForRef('object:MenuItem')} that was clicked on.
     *
     * @return The ${isc.DocUtils.linkForRef('object:MenuItem')} that was clicked on.
     */
    public  native MenuItem getItem() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.menu.MenuItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.item);
    }-*/;

    /**
     * The ${isc.DocUtils.linkForRef('class:Menu')} instance of which this ${isc.DocUtils.linkForRef('object:MenuItem')} is a                          member.
     *
     * @return The ${isc.DocUtils.linkForRef('class:Menu')} instance of which this ${isc.DocUtils.linkForRef('object:MenuItem')} is a                          member.
     */
    public  native Menu getMenu() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.menu.Menu::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.menu);
    }-*/;

    /**
     * Index of the column the user clicked. May be null if the                          user activated the menu via a keyboard event.
     *
     * @return Index of the column the user clicked. May be null if the                          user activated the menu via a keyboard event.
     */
    public  native int getColNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return jsObj.colNum;
    }-*/;


}
