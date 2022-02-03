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
 * Set of horizontally arranged buttons.
 */
@BeanFactory.FrameworkClass
public class ToolbarItem extends CanvasItem {

    public static ToolbarItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof ToolbarItem) {
            existingObj.setJsObj(jsObj);
            return (ToolbarItem)existingObj;
        } else

        {
            return new ToolbarItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ToolbarItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ToolbarItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ToolbarItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ToolbarItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.ToolbarItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public ToolbarItem(){
        setAttribute("editorType", "ToolbarItem");
    }

    public ToolbarItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public ToolbarItem(String name) {
        setName(name);
                setAttribute("editorType", "ToolbarItem");
    }


    public ToolbarItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "ToolbarItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If specified this baseStyle will be applied to the buttons in this toolbar.
     *
     * @param buttonBaseStyle New buttonBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setButtonBaseStyle(String buttonBaseStyle) {
        setAttribute("buttonBaseStyle", buttonBaseStyle);
    }

    /**
     * If specified this baseStyle will be applied to the buttons in this toolbar.
     *
     * @return Current buttonBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getButtonBaseStyle()  {
        return getAttributeAsString("buttonBaseStyle");
    }
    
    
    

    /**
     * List of buttons for the toolbar.  Each button should be specified as a simple JS object with properties to apply to the 
     * button to be displayed. Note that any <code>click</code> stringMethod applied to the  button will be passed 2
     * parameters: <code>form</code> and <code>item</code>.
     *
     * @param buttons New buttons value. Default value is null
     * @see com.smartgwt.client.docs.Items Items overview and related methods
     */
    public void setButtons(StatefulCanvas... buttons) {
        setAttribute("buttons", buttons);
    }
    

    /**
     * Space between the buttons of this toolbar. Configures the {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembersMargin Layout.membersMargin}   property on the created {@link
     * com.smartgwt.client.widgets.form.fields.ToolbarItem#getCanvas canvas}.
     *
     * @param buttonSpace New buttonSpace value. Default value is 4
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setButtonSpace(int buttonSpace) {
        setAttribute("buttonSpace", buttonSpace);
    }

    /**
     * Space between the buttons of this toolbar. Configures the {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembersMargin Layout.membersMargin}   property on the created {@link
     * com.smartgwt.client.widgets.form.fields.ToolbarItem#getCanvas canvas}.
     *
     * @return Current buttonSpace value. Default value is 4
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getButtonSpace()  {
        return getAttributeAsInt("buttonSpace");
    }
    

    /**
     * This item is an autoChild generated {@link com.smartgwt.client.widgets.Canvas} displayed by the ToolbarItem and is an
     * instance of {@link com.smartgwt.client.widgets.toolbar.Toolbar} by default, customizable  via the {@link
     * com.smartgwt.client.widgets.form.fields.ToolbarItem#getCanvasConstructor canvasConstructor} attribute.
     * <p>
     * This component is an AutoChild named "canvas".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current canvas value. Default value is null
     */
    public Canvas getCanvas()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("canvas"));
    }
    
    

    /**
     * If set to true, causes the toolbar created by this item to create its child buttons  during initialization, instead of
     * waiting until draw(). <p> See the corresponding {@link
     * com.smartgwt.client.widgets.toolbar.Toolbar#getCreateButtonsOnInit Toolbar attribute} for more information.
     *
     * @param createButtonsOnInit New createButtonsOnInit value. Default value is null
     */
    public void setCreateButtonsOnInit(Boolean createButtonsOnInit) {
        setAttribute("createButtonsOnInit", createButtonsOnInit);
    }

    /**
     * If set to true, causes the toolbar created by this item to create its child buttons  during initialization, instead of
     * waiting until draw(). <p> See the corresponding {@link
     * com.smartgwt.client.widgets.toolbar.Toolbar#getCreateButtonsOnInit Toolbar attribute} for more information.
     *
     * @return Current createButtonsOnInit value. Default value is null
     */
    public Boolean getCreateButtonsOnInit()  {
        return getAttributeAsBoolean("createButtonsOnInit", true);
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
     * Don't show a title for toolbars
     *
     * @param showTitle New showTitle value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Don't show a title for toolbars
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
    

    /**
     * Should the toolbar stack its buttons vertically or horizontally?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param vertical New vertical value. Default value is false
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical);
    }

    /**
     * Should the toolbar stack its buttons vertically or horizontally?
     *
     * @return Current vertical value. Default value is false
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical", true);
        return result == null ? false : result;
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
     * @param toolbarItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ToolbarItem toolbarItemProperties) /*-{
        if (toolbarItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ToolbarItem.@java.lang.Object::getClass()(), "setDefaultProperties", toolbarItemProperties.@java.lang.Object::getClass()());
        }
        toolbarItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = toolbarItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.ToolbarItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
