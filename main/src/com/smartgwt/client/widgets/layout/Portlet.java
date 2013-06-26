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
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Custom subclass of Window configured to be embedded within a PortalLayout.
 */
public class Portlet extends Window {

    public native static Portlet getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("Portlet",jsObj);
        } else {
            return instance;
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }



    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc["Portlet"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc["Portlet"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public Portlet(){
        scClassName = "Portlet";
    }

    public Portlet(JavaScriptObject jsObj){
        scClassName = "Portlet";
        setJavaScriptObject(jsObj);
        
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************



    /**
     * Confirmation message to show the user when closing portlets if {@link
     * com.smartgwt.client.widgets.layout.Portlet#getShowCloseConfirmationMessage showCloseConfirmationMessage} is true.
     *
     * @param closeConfirmationMessage . See {@link com.smartgwt.client.docs.String String}. Default value is "Close portlet?"
     */
    public void setCloseConfirmationMessage(String closeConfirmationMessage) {
        setAttribute("closeConfirmationMessage", closeConfirmationMessage, true);
    }

    /**
     * Confirmation message to show the user when closing portlets if {@link
     * com.smartgwt.client.widgets.layout.Portlet#getShowCloseConfirmationMessage showCloseConfirmationMessage} is true.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCloseConfirmationMessage()  {
        return getAttributeAsString("closeConfirmationMessage");
    }


    /**
     * Whether to call {@link com.smartgwt.client.widgets.Canvas#destroy destroy()} when closing the Portlet.
     *
     * @param destroyOnClose destroyOnClose Default value is false
     */
    public void setDestroyOnClose(Boolean destroyOnClose) {
        setAttribute("destroyOnClose", destroyOnClose, true);
    }

    /**
     * Whether to call {@link com.smartgwt.client.widgets.Canvas#destroy destroy()} when closing the Portlet.
     *
     * @return Boolean
     */
    public Boolean getDestroyOnClose()  {
        return getAttributeAsBoolean("destroyOnClose");
    }




    /**
     * Specifies a minimum height for the Portlet. The height of rows within a {@link
     * com.smartgwt.client.widgets.layout.Portlet#getPortaLayout PortaLayout} will be adjusted to take into account the
     * minHeight of all the Portlets in that row.
     *
     * @param minHeight minHeight Default value is 60
     * @see com.smartgwt.client.widgets.Canvas#setMinHeight
     */
    public void setMinHeight(int minHeight) {
        setAttribute("minHeight", minHeight, true);
    }

    /**
     * Specifies a minimum height for the Portlet. The height of rows within a {@link
     * com.smartgwt.client.widgets.layout.Portlet#getPortaLayout PortaLayout} will be adjusted to take into account the
     * minHeight of all the Portlets in that row.
     *
     * @return int
     * @see com.smartgwt.client.widgets.Canvas#getMinHeight
     */
    public int getMinHeight()  {
        return getAttributeAsInt("minHeight");
    }


    /**
     * Specifies a minimum width for the Portlet.
     *
     * @param minWidth minWidth Default value is 70
     * @see com.smartgwt.client.widgets.Canvas#setMinWidth
     */
    public void setMinWidth(int minWidth) {
        setAttribute("minWidth", minWidth, true);
    }

    /**
     * Specifies a minimum width for the Portlet.
     *
     * @return int
     * @see com.smartgwt.client.widgets.Canvas#getMinWidth
     */
    public int getMinWidth()  {
        return getAttributeAsInt("minWidth");
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
     * @return Boolean
     */
    public Boolean getShowCloseConfirmationMessage()  {
        return getAttributeAsBoolean("showCloseConfirmationMessage");
    }

    // ********************* Methods ***********************
	/**
     * closeClick overridden to show {@link com.smartgwt.client.widgets.layout.Portlet#getCloseConfirmationMessage
     * closeConfirmationMessage} to the user before removing the portlet from the PortalLayout via {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removePortlet PortalLayout.removePortlet}
     */
    public native void closeClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.closeClick();
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
     * @param portletProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Portlet portletProperties) /*-{
    	var properties = $wnd.isc.addProperties({},portletProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Portlet.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * If you set the rowHeight of a Portlet before adding it to a {@link com.smartgwt.client.widgets.layout.PortalLayout},
     * then the height will be used when creating the new row. If adding the Portlet to an existing row (or dragging it there),
     * the Portlet's rowHeight will be used if  the row's height has not already been specified. However, if you  set the
     * rowHeight of a Portlet after adding it to the PortalLayout, then the height of the entire row will always be adjusted to
     * match. <p> You can also just specify {@link com.smartgwt.client.widgets.Canvas#getHeight height} when initializing a
     * Portlet, and it will be applied to the rowHeight when added to a PortalLayout. However, changing the Portlet's height
     * after initialization will not affect the row. <p> Note that getting the rowHeight will indicate the rowHeight specified
     * for this Portlet, not the actual height of the row it is in.
     *
     * @param rowHeight rowHeight Default value is null
     */
    public void setRowHeight(int rowHeight) {
        setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * If you set the rowHeight of a Portlet before adding it to a {@link com.smartgwt.client.widgets.layout.PortalLayout},
     * then the height will be used when creating the new row. If adding the Portlet to an existing row (or dragging it there),
     * the Portlet's rowHeight will be used if  the row's height has not already been specified. However, if you  set the
     * rowHeight of a Portlet after adding it to the PortalLayout, then the height of the entire row will always be adjusted to
     * match. <p> You can also just specify {@link com.smartgwt.client.widgets.Canvas#getHeight height} when initializing a
     * Portlet, and it will be applied to the rowHeight when added to a PortalLayout. However, changing the Portlet's height
     * after initialization will not affect the row. <p> Note that getting the rowHeight will indicate the rowHeight specified
     * for this Portlet, not the actual height of the row it is in.
     *
     *
     * @return Integer
     */
    public Integer getRowHeight()  {
        return getAttributeAsInt("rowHeight");
    }

    /**
     * If you set the rowHeight of a Portlet before adding it to a {@link com.smartgwt.client.widgets.layout.PortalLayout},
     * then the height will be used when creating the new row. If adding the Portlet to an existing row (or dragging it there),
     * the Portlet's rowHeight will be used if  the row's height has not already been specified. However, if you  set the
     * rowHeight of a Portlet after adding it to the PortalLayout, then the height of the entire row will always be adjusted to
     * match. <p> You can also just specify {@link com.smartgwt.client.widgets.Canvas#getHeight height} when initializing a
     * Portlet, and it will be applied to the rowHeight when added to a PortalLayout. However, changing the Portlet's height
     * after initialization will not affect the row. <p> Note that getting the rowHeight will indicate the rowHeight specified
     * for this Portlet, not the actual height of the row it is in.
     *
     * @param rowHeight rowHeight Default value is null
     */
    public void setRowHeight(String rowHeight) {
        setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * If you set the rowHeight of a Portlet before adding it to a {@link com.smartgwt.client.widgets.layout.PortalLayout},
     * then the height will be used when creating the new row. If adding the Portlet to an existing row (or dragging it there),
     * the Portlet's rowHeight will be used if  the row's height has not already been specified. However, if you  set the
     * rowHeight of a Portlet after adding it to the PortalLayout, then the height of the entire row will always be adjusted to
     * match. <p> You can also just specify {@link com.smartgwt.client.widgets.Canvas#getHeight height} when initializing a
     * Portlet, and it will be applied to the rowHeight when added to a PortalLayout. However, changing the Portlet's height
     * after initialization will not affect the row. <p> Note that getting the rowHeight will indicate the rowHeight specified
     * for this Portlet, not the actual height of the row it is in.
     *
     *
     * @return String
     */
    public String getRowHeightAsString()  {
        return getAttributeAsString("rowHeight");
    }
	
    /**
     * If you set the height of a Portlet, then that height will be used as the 
     * Portlet's {@link com.smartgwt.client.widgets.layout.Portlet#getRowHeight rowHeight} (if no rowHeight is set).
     * <p>
     * After initialization, the {@link com.smartgwt.client.widgets.layout.PortalLayout} manages the height of Portlets. If you
     * want to change the height, use {@link com.smartgwt.client.widgets.layout.PortalLayout#setRowHeight}.
     *
     * @param height height Default value is null
     */
    public void setHeight(int height) {
        setAttribute("height", height, true);
    }

    /**
     * If you set the height of a Portlet, then that height will be used as the 
     * Portlet's {@link com.smartgwt.client.widgets.layout.Portlet#getRowHeight rowHeight} (if no rowHeight is set).
     * <p>
     * After initialization, the {@link com.smartgwt.client.widgets.layout.PortalLayout} manages the height of Portlets. If you
     * want to change the height, use {@link com.smartgwt.client.widgets.layout.PortalLayout#setRowHeight}.
     *
     * @return Integer
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * If you set the height of a Portlet, then that height will be used as the 
     * Portlet's {@link com.smartgwt.client.widgets.layout.Portlet#getRowHeight rowHeight} (if no rowHeight is set).
     * <p>
     * After initialization, the {@link com.smartgwt.client.widgets.layout.PortalLayout} manages the height of Portlets. If you
     * want to change the height, use {@link com.smartgwt.client.widgets.layout.PortalLayout#setRowHeight}.
     *
     * @param height height Default value is null
     */
    public void setHeight(String height) {
        setAttribute("height", height, true);
    }

    /**
     * If you set the height of a Portlet, then that height will be used as the 
     * Portlet's {@link com.smartgwt.client.widgets.layout.Portlet#getRowHeight rowHeight} (if no rowHeight is set).
     * <p>
     * After initialization, the {@link com.smartgwt.client.widgets.layout.PortalLayout} manages the height of Portlets. If you
     * want to change the height, use {@link com.smartgwt.client.widgets.layout.PortalLayout#setRowHeight}.
     *
     * @return String
     */
    public String getHeightAsString()  {
        return getAttributeAsString("height");
    }

    public LogicalStructureObject setLogicalStructure(PortletLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.closeConfirmationMessage = getAttributeAsString("closeConfirmationMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Portlet.closeConfirmationMessage:" + t.getMessage() + "\n";
        }
        try {
            s.destroyOnClose = getAttributeAsString("destroyOnClose");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Portlet.destroyOnClose:" + t.getMessage() + "\n";
        }
        try {
            s.heightAsString = getAttributeAsString("height");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Portlet.heightAsString:" + t.getMessage() + "\n";
        }
        try {
            s.minHeight = getAttributeAsString("minHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Portlet.minHeight:" + t.getMessage() + "\n";
        }
        try {
            s.minWidth = getAttributeAsString("minWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Portlet.minWidth:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeightAsString = getAttributeAsString("rowHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Portlet.rowHeightAsString:" + t.getMessage() + "\n";
        }
        try {
            s.showCloseConfirmationMessage = getAttributeAsString("showCloseConfirmationMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Portlet.showCloseConfirmationMessage:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        PortletLogicalStructure s = new PortletLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

