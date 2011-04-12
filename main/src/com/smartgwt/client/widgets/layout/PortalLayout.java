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
 * A PortalLayout is a special subclass of Layout designed to display {@link com.smartgwt.client.widgets.layout.Portlet}
 * windows. A PortalLayout displays Portlets in columns and supports drag-drop interaction for moving  Portlets around
 * within the PortalLayout. Portlets may be drag-reordered within columns, dragged into other columns, or dragged next to
 * other Portlets to sit next to them horizontally within a column.
 */
public class PortalLayout extends Layout {

    public static PortalLayout getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (PortalLayout) obj;
        } else {
            return new PortalLayout(jsObj);
        }
    }

    public PortalLayout(){
        scClassName = "PortalLayout";
    }

    public PortalLayout(JavaScriptObject jsObj){
        super(jsObj);
    }

    public PortalLayout(int numColumns) {
        setNumColumns(numColumns);
        scClassName = "PortalLayout";
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Are columns in this portalLayout drag-resizeable?
     *
     * @param canResizeColumns canResizeColumns Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanResizeColumns(Boolean canResizeColumns)  throws IllegalStateException {
        setAttribute("canResizeColumns", canResizeColumns, false);
    }

    /**
     * Are columns in this portalLayout drag-resizeable?
     *
     *
     * @return Boolean
     */
    public Boolean getCanResizeColumns()  {
        return getAttributeAsBoolean("canResizeColumns");
    }

    /**
     * Should vertical drag-resize of portlets within columns be allowed?
     *
     * @param canResizeRows canResizeRows Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanResizeRows(Boolean canResizeRows)  throws IllegalStateException {
        setAttribute("canResizeRows", canResizeRows, false);
    }

    /**
     * Should vertical drag-resize of portlets within columns be allowed?
     *
     *
     * @return Boolean
     */
    public Boolean getCanResizeRows()  {
        return getAttributeAsBoolean("canResizeRows");
    }

    /**
     * Border to show around columns in this PortalLayout
     * Sets the columnBorder for to the specified value and updates any drawn columns to reflect this.
     *
     * @param columnBorder New border to show around columns. Default value is "1px solid gray"
     */
    public void setColumnBorder(String columnBorder) {
        setAttribute("columnBorder", columnBorder, true);
    }

    /**
     * Border to show around columns in this PortalLayout
     *
     *
     * @return String
     */
    public String getColumnBorder()  {
        return getAttributeAsString("columnBorder");
    }


    /**
     * Initial number of columns to show in this PortalLayout. Note that after initialization columns should be added / removed
     * via {@link com.smartgwt.client.widgets.layout.PortalLayout#addColumn PortalLayout.addColumn} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removeColumn PortalLayout.removeColumn}
     *
     * @param numColumns numColumns Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNumColumns(int numColumns)  throws IllegalStateException {
        setAttribute("numColumns", numColumns, false);
    }

    /**
     * Initial number of columns to show in this PortalLayout. Note that after initialization columns should be added / removed
     * via {@link com.smartgwt.client.widgets.layout.PortalLayout#addColumn PortalLayout.addColumn} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removeColumn PortalLayout.removeColumn}
     *
     *
     * @return int
     */
    public int getNumColumns()  {
        return getAttributeAsInt("numColumns");
    }

    /**
     * Should a menu be shown within each column with options to add / remove columns?
     *
     * @param showColumnMenus showColumnMenus Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowColumnMenus(Boolean showColumnMenus)  throws IllegalStateException {
        setAttribute("showColumnMenus", showColumnMenus, false);
    }

    /**
     * Should a menu be shown within each column with options to add / remove columns?
     *
     *
     * @return Boolean
     */
    public Boolean getShowColumnMenus()  {
        return getAttributeAsBoolean("showColumnMenus");
    }

    // ********************* Methods ***********************
            
    /**
     * Adds a new portal column to this layout at the specified position
     * @param index target position for the new column
     */
    public native void addColumn(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addColumn(index);
    }-*/;
            
    /**
     * Adds a {@link com.smartgwt.client.widgets.layout.Portlet} instance to this portalLayout in the specified position.
     * @param portlet Portlet to add to this layout.
     */
    public native void addPortlet(Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPortlet(portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Adds a {@link com.smartgwt.client.widgets.layout.Portlet} instance to this portalLayout in the specified position.
     * @param portlet Portlet to add to this layout.
     * @param colNum Column in which the Portlet should be added. If unspecified  defaults to zero.
     * @param rowNum Position within the column for the Portlet
     */
    public native void addPortlet(Portlet portlet, int colNum, int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPortlet(portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), colNum, rowNum);
    }-*/;
            
    /**
     * Removes the specified column from this layout. All portlets displayed within this column will be destroyed when the
     * column is removed.
     * @param index column number to remove
     */
    public native void removeColumn(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeColumn(index);
    }-*/;
            
    /**
     * Removes a {@link com.smartgwt.client.widgets.layout.Portlet} which is currently rendered in this PortalLayout. Portlet
     * will not be destroyed by default - if this is desired the calling code should do this explicitly.
     * @param portlet portlet to remove
     */
    public native void removePortlet(Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removePortlet(portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param portalLayoutProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(PortalLayout portalLayoutProperties) /*-{
    	var properties = $wnd.isc.addProperties({},portalLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.PortalLayout.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}



