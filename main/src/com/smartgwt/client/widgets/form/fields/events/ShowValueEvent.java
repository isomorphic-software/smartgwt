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
 
package com.smartgwt.client.widgets.form.fields.events;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


public class ShowValueEvent extends AbstractSmartEvent<ShowValueHandler>  {

    /**
     * Handler type.
     */
    private static Type<ShowValueHandler> TYPE;
    
    /**
     * Returns the {@link com.smartgwt.client.widgets.form.fields.FormItem FormItem} firing the
     * event.
     * @return FormItem firing the event
     */
    public FormItem getFiringItem() {
        JavaScriptObject itemJS = getFiringInstanceAsJavaScriptObject();
        return itemJS != null ? FormItemFactory.getFormItem(itemJS) : null;
    }

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasShowValueHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            ShowValueEvent event = new ShowValueEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<ShowValueHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<ShowValueHandler>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(ShowValueHandler handler) {
        handler.onShowValue(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<ShowValueHandler> getAssociatedType() {
        return TYPE;
    }

    public ShowValueEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    
	/**
     * new display value for the item.  This is the value after applying   any custom formatter or valueMap
     *
     * @return new display value for the item.  This is the value after applying   any custom formatter or valueMap
     */
    public native Object getDisplayValue() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.displayValue;
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;
    
	/**
     * underlying data value for the item
     *
     * @return underlying data value for the item
     */
    public native Object getDataValue() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.dataValue;
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;
    
	/**
     * the dynamicForm in which this item is contained
     *
     * @return the dynamicForm in which this item is contained
     */
    public native DynamicForm getForm() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.form;
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
	/**
     * the live form item instance
     *
     * @return the live form item instance
     */
    public native CanvasItem getItem() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.item;
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.CanvasItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


    /**
     * underlying data value for this item as a Record.
     */
    public native Record getDataValueAsRecord() /*-{
        // Note: Avoid retrieving data via getDataValue() as that converts the value to a Java
        // object which is not needed and may require us to do extra work to convert it back.
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.dataValue;
        if (ret == null) return null;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * underlying data value for this item as a RecordList
     */
    public native RecordList getDataValueAsRecordList() /*-{
        // Note: Avoid retrieving data via getDataValue() as that converts the value to a Java
        // object which is not needed and may require us to do extra work to convert it back.
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.dataValue;
        if (ret == null) return null;
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;




}
