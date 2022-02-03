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
public class ChangedEvent extends AbstractSmartEvent<ChangedHandler>  {

    /**
     * Handler type.
     */
    private static Type<ChangedHandler> TYPE;

    /**
     * Returns the {@link com.smartgwt.client.core.DataClass DataClass} firing the event.
     * @return DataClass firing the event
     */
    public DataClass getFiringDataClass() {
        JavaScriptObject dataClassJS = getFiringInstanceAsJavaScriptObject();
        return dataClassJS != null ? (DataClass) ListGridField.getOrCreateRef(dataClassJS) :
                              null;
    }

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasChangedHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            ChangedEvent event = new ChangedEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<ChangedHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<ChangedHandler>();
        }
        return TYPE;
    }


    @Override
    protected void dispatch(ChangedHandler handler) {
        handler.onChanged(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<ChangedHandler> getAssociatedType() {
        return TYPE;
    }

    public ChangedEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }



    /**
     * the managing DynamicForm instance
     *
     * @return the managing DynamicForm instance
     */
    public  native DynamicForm getForm() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.form);
    }-*/;

    /**
     * the editor (form item) itself (also available as "this").                              Note that in addition to the standard FormItem APIs available&#010                              on the editor, it also has:<br>&#010                              - a pointer back to the containing listGrid &#010                              [<code>item.grid</code>]<br>&#010                              - the colNum being edited [<code>item.colNum</code>]<br>&#010                              - the rowNum being edited [<code>item.rowNum</code>]
     *
     * @return the editor (form item) itself (also available as "this").                              Note that in addition to the standard FormItem APIs available&#010                              on the editor, it also has:<br>&#010                              - a pointer back to the containing listGrid &#010                              [<code>item.grid</code>]<br>&#010                              - the colNum being edited [<code>item.colNum</code>]<br>&#010                              - the rowNum being edited [<code>item.rowNum</code>]
     */
    public  native FormItem getItem() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.item);
    }-*/;

    /**
     * The current value (after the change).
     *
     * @return The current value (after the change).
     */
    public  native Object getValue() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return $wnd.SmartGWT.convertToJavaType(jsObj.value);
    }-*/;

    /**
     * row number for the cell
     *
     * @return row number for the cell
     */
    public  native int getRowNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        if(jsObj.item) {
          return jsObj.item.rowNum;
        } else {
            //when this event fired from due to field.canToggle, getColNum/getRowNum will not have access to this.item and need to use ListGrid.getEventRow() instead
            var listGrid = jsObj.sourceJSO;
            return listGrid.getEventRow();
        }
    }-*/;

    /**
     * column number of the cell
     *
     * @return column number of the cell
     */
    public  native int getColNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        if(jsObj.item) {
            return jsObj.item.colNum;
        } else {
            //when this event fired from due to field.canToggle, getColNum/getRowNum will not have access to this.item and need to use ListGrid.getEventColumn() instead
            var listGrid = jsObj.sourceJSO;
            return listGrid.getEventColumn();
        }
    }-*/;

}
