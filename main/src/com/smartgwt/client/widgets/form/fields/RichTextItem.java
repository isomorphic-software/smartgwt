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
 
package com.smartgwt.client.widgets.form.fields;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
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
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * FormItem for rich text (HTML) editing. Makes use of a {@link com.smartgwt.client.widgets.RichTextEditor} as the  editing
 * interface.
 */
@BeanFactory.FrameworkClass
public class RichTextItem extends CanvasItem {

    public static RichTextItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("RichTextItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (RichTextItem) obj;
        } else {
            return new RichTextItem(jsObj);
        }
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
        $wnd.isc.RichTextItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.RichTextItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        $wnd.isc.RichTextItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.RichTextItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public RichTextItem(){
        setAttribute("editorType", "RichTextItem");
    }

    public RichTextItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public RichTextItem(String name) {
        setName(name);
                setAttribute("editorType", "RichTextItem");
    }


    public RichTextItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "RichTextItem");
    }


    // ********************* Properties / Attributes ***********************
    

    /**
     * {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups} to display for this editor. Each
     * controlGroup should be a property set either on this item or on the RichTextEditor prototype and should be set to an
     * array of {@link com.smartgwt.client.types.ControlName}s.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param controlGroups  Default value is null
     */
    public void setControlGroups(String... controlGroups) {
        setAttribute("controlGroups", controlGroups);
    }
    

    /**
     * By default RichTextItems take up an entire row
     *
     * @param endRow  Default value is true
     */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * By default RichTextItems take up an entire row
     *
     * @return Boolean
     */
    public Boolean getEndRow()  {
        Boolean result = getAttributeAsBoolean("endRow", true);
        return result == null ? true : result;
    }
    

    /**
     * If the user presses the "Tab" key, should focus be taken from this editor? If set to <code>false</code> a "Tab" keypress
     * will cause a Tab character to be inserted into the text, and focus will be left in the edit area.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.RichTextItem#getMoveFocusOnTab moveFocusOnTab}.
     *
     * @param moveFocusOnTab new value for moveFocusOnTab. Default value is true
     */
    public void setMoveFocusOnTab(boolean moveFocusOnTab) {
        setAttribute("moveFocusOnTab", moveFocusOnTab);
    }

    /**
     * If the user presses the "Tab" key, should focus be taken from this editor? If set to <code>false</code> a "Tab" keypress
     * will cause a Tab character to be inserted into the text, and focus will be left in the edit area.
     *
     * @return boolean
     */
    public boolean getMoveFocusOnTab()  {
        Boolean result = getAttributeAsBoolean("moveFocusOnTab", true);
        return result == null ? true : result;
    }
    

    /**
     * Don't show the title for rich text items by default
     *
     * @param showTitle  Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Don't show the title for rich text items by default
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle", true);
        return result == null ? false : result;
    }
    

    /**
     * By default RichTextItems take up an entire row
     *
     * @param startRow  Default value is true
     */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * By default RichTextItems take up an entire row
     *
     * @return Boolean
     */
    public Boolean getStartRow()  {
        Boolean result = getAttributeAsBoolean("startRow", true);
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param richTextItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(RichTextItem richTextItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},richTextItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.RichTextItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}


