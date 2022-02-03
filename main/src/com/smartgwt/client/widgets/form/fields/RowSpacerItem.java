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
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Form item that renders as a blank row in the form layout.<br> Set {@link
 * com.smartgwt.client.widgets.form.fields.RowSpacerItem#getStartRow startRow} to <code>false</code> to create a rowSpacer
 * that simply takes up every remaining column in the current row rather than starting a new row.
 */
@BeanFactory.FrameworkClass
public class RowSpacerItem extends SpacerItem {

    public static RowSpacerItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof RowSpacerItem) {
            existingObj.setJsObj(jsObj);
            return (RowSpacerItem)existingObj;
        } else

        {
            return new RowSpacerItem(jsObj);
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RowSpacerItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RowSpacerItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RowSpacerItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RowSpacerItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.RowSpacerItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public RowSpacerItem(){
        setAttribute("editorType", "RowSpacerItem");
    }

    public RowSpacerItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public RowSpacerItem(String name) {
        setName(name);
                setAttribute("editorType", "RowSpacerItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * by default, separators span all remaining columns
     *
     * @param colSpan New colSpan value. Default value is "*"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setColSpan(int colSpan) {
        setAttribute("colSpan", colSpan);
    }

    /**
     * by default, separators span all remaining columns
     *
     * <p><b>Note :</b> This method will return -1 if the underlying SmartClient JavaScript
     * attribute value cannot be expressed as a(n) int.  In that case, other
     * getters,  similarly-named but ending in <code>AsString</code>, <code>AsCanvas</code>,
     * etc., may be provided.
     *
     * @return Current colSpan value. Default value is "*"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getColSpan()  {
        if (!(getAttributeAsObject("colSpan") instanceof Integer)) { return -1; }
        return getAttributeAsInt("colSpan");
    }

    /**
     * by default, separators span all remaining columns
     *
     * @param colSpan New colSpan value. Default value is "*"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setColSpan(String colSpan) {
        setAttribute("colSpan", colSpan);
    }

    /**
     * by default, separators span all remaining columns
     *
     * @return Current colSpan value. Default value is "*"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getColSpanAsString()  {
        return getAttributeAsString("colSpan");
    }
    

    /**
     * these items are in a row by themselves by default
     *
     * @param endRow New endRow value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * these items are in a row by themselves by default
     *
     * @return Current endRow value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getEndRow()  {
        Boolean result = getAttributeAsBoolean("endRow", true);
        return result == null ? true : result;
    }
    

    /**
     * we never show a separate title cell for separators
     *
     * @param showTitle New showTitle value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * we never show a separate title cell for separators
     *
     * @return Current showTitle value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle", true);
        return result == null ? false : result;
    }
    

    /**
     * these items are in a row by themselves by default
     *
     * @param startRow New startRow value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * these items are in a row by themselves by default
     *
     * @return Current startRow value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
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
     * @param rowSpacerItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RowSpacerItem rowSpacerItemProperties) /*-{
        if (rowSpacerItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RowSpacerItem.@java.lang.Object::getClass()(), "setDefaultProperties", rowSpacerItemProperties.@java.lang.Object::getClass()());
        }
        rowSpacerItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = rowSpacerItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.RowSpacerItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
