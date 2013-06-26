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
 
package com.smartgwt.client.widgets.form.fields.events;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
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

public class ChangeEvent extends AbstractSmartEvent<ChangeHandler>  implements Cancellable {
    private boolean cancel = false;

    /**
     * Handler type.
     */
    private static Type<ChangeHandler> TYPE;

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasChangeHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            ChangeEvent event = new ChangeEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<ChangeHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<ChangeHandler>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(ChangeHandler handler) {
        handler.onChange(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<ChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public ChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * In your handler, Call this method to cancel the change,
     */
    public void cancel() {
        cancel = true;
    }

    /**
     * @return true if cancelled
     */
    public boolean isCancelled() {
        return cancel;
    }
	/**
     * the managing DynamicForm instance
     *
     * @return the managing DynamicForm instance
     */
    public native DynamicForm getForm() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.form;
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * the form item itself (also available as "this")
     *
     * @return the form item itself (also available as "this")
     */
    public native FormItem getItem() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.item;
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * The new value of the form item
     *
     * @return The new value of the form item
     */
    public native Object getValue() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.value;
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;
	/**
     * The previous value of the form item
     *
     * @return The previous value of the form item
     */
    public native Object getOldValue() /*-{
        var self = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var ret = self.oldValue;
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

}
