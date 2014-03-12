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
 * FormItem for selecting a color via a pop-up ColorPicker.
 */
@BeanFactory.FrameworkClass
public class ColorItem extends TextItem {

    public static ColorItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("ColorItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (ColorItem) obj;
        } else {
            return new ColorItem(jsObj);
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
        $wnd.isc.ColorItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.ColorItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.ColorItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public ColorItem(){
        setType("color");
                    setAttribute("editorType", "ColorItem");
    }

    public ColorItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public ColorItem(String name) {
        setName(name);
                setType("color");
                    setAttribute("editorType", "ColorItem");
    }


    public ColorItem(String name, String title) {
        setName(name);
		setTitle(title);
                setType("color");
                    setAttribute("editorType", "ColorItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Should "complex" mode be allowed for the {@link com.smartgwt.client.widgets.form.ColorPicker} window associated with  
     * this ColorItem?<p> If false, no "More" button is shown on the simple picker
     *
     * @param allowComplexMode  Default value is true
     */
    public void setAllowComplexMode(Boolean allowComplexMode) {
        setAttribute("allowComplexMode", allowComplexMode);
    }

    /**
     * Should "complex" mode be allowed for the {@link com.smartgwt.client.widgets.form.ColorPicker} window associated with  
     * this ColorItem?<p> If false, no "More" button is shown on the simple picker
     *
     * @return Boolean
     */
    public Boolean getAllowComplexMode()  {
        return getAttributeAsBoolean("allowComplexMode");
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.ColorPicker} associated with this ColorItem can operate in either a "simple"
     * mode  (where it displays just the 40 basic colors and allows the user to click one), or a  "complex" mode (where the
     * user can specify a color from anywhere in the spectrum, with  an optional alpha element). The defaultPickMode attribute
     * specifies which of these two  modes is in force when the picker first loads.
     *
     * @param defaultPickerMode  Default value is "simple"
     */
    public void setDefaultPickerMode(String defaultPickerMode) {
        setAttribute("defaultPickerMode", defaultPickerMode);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.ColorPicker} associated with this ColorItem can operate in either a "simple"
     * mode  (where it displays just the 40 basic colors and allows the user to click one), or a  "complex" mode (where the
     * user can specify a color from anywhere in the spectrum, with  an optional alpha element). The defaultPickMode attribute
     * specifies which of these two  modes is in force when the picker first loads.
     *
     * @return String
     */
    public String getDefaultPickerMode()  {
        return getAttributeAsString("defaultPickerMode");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> It is not recommended to change the pickerIconHeight from the default value if {@link
     * com.smartgwt.client.docs.Skinning spriting} is enabled because the image sprites are set up assuming specific, fixed
     * dimensions of the picker icon. If the pickerIconHeight must be changed, then the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} should be changed to a custom CSS
     * style name.
     *
     * @param pickerIconHeight  Default value is 18
     */
    public void setPickerIconHeight(Integer pickerIconHeight) {
        setAttribute("pickerIconHeight", pickerIconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> It is not recommended to change the pickerIconHeight from the default value if {@link
     * com.smartgwt.client.docs.Skinning spriting} is enabled because the image sprites are set up assuming specific, fixed
     * dimensions of the picker icon. If the pickerIconHeight must be changed, then the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} should be changed to a custom CSS
     * style name.
     *
     * @return Integer
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon.
     *
     * @param pickerIconPrompt  Default value is "Click to select a new color"
     */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon.
     *
     * @return String
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon
     * image to be displayed.
     *
     * @param pickerIconSrc  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is "[SKIN]/DynamicForm/ColorPicker_icon.png"
     */
    public void setPickerIconSrc(String pickerIconSrc) {
        setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon
     * image to be displayed.
     *
     * @return  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} 
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> It is not recommended to change the pickerIconWidth from the default value if {@link
     * com.smartgwt.client.docs.Skinning spriting} is enabled because the image sprites are set up assuming specific, fixed
     * dimensions of the picker icon. If the pickerIconWidth must be changed, then the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} should be changed to a custom CSS
     * style name.
     *
     * @param pickerIconWidth  Default value is 18
     */
    public void setPickerIconWidth(Integer pickerIconWidth) {
        setAttribute("pickerIconWidth", pickerIconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> It is not recommended to change the pickerIconWidth from the default value if {@link
     * com.smartgwt.client.docs.Skinning spriting} is enabled because the image sprites are set up assuming specific, fixed
     * dimensions of the picker icon. If the pickerIconWidth must be changed, then the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} should be changed to a custom CSS
     * style name.
     *
     * @return Integer
     */
    public Integer getPickerIconWidth()  {
        return getAttributeAsInt("pickerIconWidth");
    }

    /**
     * Should the pick button icon be shown for choosing colors from a ColorPicker
     *
     * @param showPickerIcon  Default value is true
     */
    public void setShowPickerIcon(Boolean showPickerIcon) {
        setAttribute("showPickerIcon", showPickerIcon);
    }

    /**
     * Should the pick button icon be shown for choosing colors from a ColorPicker
     *
     * @return Boolean
     */
    public Boolean getShowPickerIcon()  {
        return getAttributeAsBoolean("showPickerIcon");
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.form.ColorPicker} associated with this ColorItem allows the
     * user  to set transparency/opacity information whilst selecting a color. If false, no opacity slider is shown and all
     * colors are 100% opaque.<p> <b>Note</b> ColorItems are representations of HTML color strings, they do not implicitly
     * support transparency.  Setting supportsTransparency to true just allows the user to  set opacity with the picker; if you
     * actually want to capture that information,  you will also need to override {@link
     * com.smartgwt.client.widgets.form.fields.ColorItem#pickerColorSelected ColorItem.pickerColorSelected}.
     *
     * @param supportsTransparency  Default value is false
     */
    public void setSupportsTransparency(Boolean supportsTransparency) {
        setAttribute("supportsTransparency", supportsTransparency);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.form.ColorPicker} associated with this ColorItem allows the
     * user  to set transparency/opacity information whilst selecting a color. If false, no opacity slider is shown and all
     * colors are 100% opaque.<p> <b>Note</b> ColorItems are representations of HTML color strings, they do not implicitly
     * support transparency.  Setting supportsTransparency to true just allows the user to  set opacity with the picker; if you
     * actually want to capture that information,  you will also need to override {@link
     * com.smartgwt.client.widgets.form.fields.ColorItem#pickerColorSelected ColorItem.pickerColorSelected}.
     *
     * @return Boolean
     */
    public Boolean getSupportsTransparency()  {
        return getAttributeAsBoolean("supportsTransparency");
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
     * @param colorItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ColorItem colorItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},colorItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.ColorItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}


