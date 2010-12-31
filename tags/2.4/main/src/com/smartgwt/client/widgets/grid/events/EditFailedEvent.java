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
 
package com.smartgwt.client.widgets.grid.events;



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
public class EditFailedEvent extends BrowserEvent<EditFailedHandler>  {

    /**
     * Handler type.
     */
    private static Type<EditFailedHandler> TYPE;

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasEditFailedHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            EditFailedEvent event = new EditFailedEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<EditFailedHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<EditFailedHandler>();
        }
        return TYPE;
    }


    @Override
    protected void dispatch(EditFailedHandler handler) {
        handler.onEditFailed(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<EditFailedHandler> getAssociatedType() {
        return TYPE;
    }

    public EditFailedEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }



    /**
     * current index of the row we attempted to save
     *
     * @return current index of the row we attempted to save
     */
    public  native int getRowNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return jsObj.rowNum;
    }-*/;

    /**
     * index of the column where the edit failed, if applicable
     *
     * @return index of the column where the edit failed, if applicable
     */
    public  native int getColNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return jsObj.colNum;
    }-*/;

    /**
     * Edit completion event that led to the save                                                  attempt
     *
     * @return Edit completion event that led to the save                                                  attempt
     */
    public  native EditCompletionEvent getEditCompletionEvent() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
            var enumValues = @com.smartgwt.client.types.EditCompletionEvent::values()();
            return @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(enumValues, jsObj.editCompletionEvent);
    }-*/;

    /**
     * DSResponse, for saves through a DataSource
     *
     * @return DSResponse, for saves through a DataSource
     */
    public  native DSResponse getDsResponse() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.dsResponse);
    }-*/;


    /**
     * A Map of the new values that we attempted to save. In addition to fields that were changed, the Map contains
     * the primary key field
     *
     * @return new values that we attempted to save
     */
    public  native Map getNewValues() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.newValues);        
    }-*/;

    /**
     * old values before the save occurred
     *
     * @return old values before the save occurred
     */
    public  native Record getRecord() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.oldValues);    
    }-*/;    


}
