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


/**
 * Form item for selecting a color via a pop-up {@link com.smartgwt.client.widgets.form.ColorPicker}.
 */
@BeanFactory.FrameworkClass
public class ColorItem extends TextItem implements com.smartgwt.client.widgets.form.fields.events.HasPickerColorSelectedHandlers {

    public static ColorItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof ColorItem) {
            existingObj.setJsObj(jsObj);
            return (ColorItem)existingObj;
        } else

        {
            return new ColorItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ColorItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ColorItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ColorItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ColorItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.ColorItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public ColorItem(){
        setType("color");
                    setAttribute("editorType", "ColorItem");
    }

    public ColorItem(JavaScriptObject jsObj){
        super(jsObj);
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
     * @param allowComplexMode New allowComplexMode value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     */
    public ColorItem setAllowComplexMode(Boolean allowComplexMode) {
        return (ColorItem)setAttribute("allowComplexMode", allowComplexMode);
    }

    /**
     * Should "complex" mode be allowed for the {@link com.smartgwt.client.widgets.form.ColorPicker} window associated with  
     * this ColorItem?<p> If false, no "More" button is shown on the simple picker
     *
     * @return Current allowComplexMode value. Default value is true
     */
    public Boolean getAllowComplexMode()  {
        Boolean result = getAttributeAsBoolean("allowComplexMode", true);
        return result == null ? true : result;
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.ColorPicker#getDefaultPickMode defaultPickMode} for the {@link
     * com.smartgwt.client.widgets.form.ColorPicker} associated with this <code>ColorItem</code>.
     *
     * @param defaultPickerMode New defaultPickerMode value. Default value is "simple"
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.ColorPicker#setDefaultPickMode
     */
    public ColorItem setDefaultPickerMode(ColorPickerMode defaultPickerMode) {
        return (ColorItem)setAttribute("defaultPickerMode", defaultPickerMode == null ? null : defaultPickerMode.getValue());
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.ColorPicker#getDefaultPickMode defaultPickMode} for the {@link
     * com.smartgwt.client.widgets.form.ColorPicker} associated with this <code>ColorItem</code>.
     *
     * @return Current defaultPickerMode value. Default value is "simple"
     * @see com.smartgwt.client.widgets.form.ColorPicker#getDefaultPickMode
     */
    public ColorPickerMode getDefaultPickerMode()  {
        return EnumUtil.getEnum(ColorPickerMode.values(), getAttribute("defaultPickerMode"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     *
     * @param pickerIconHeight New pickerIconHeight value. Default value is 18
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     */
    public ColorItem setPickerIconHeight(Integer pickerIconHeight) {
        return (ColorItem)setAttribute("pickerIconHeight", pickerIconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     *
     * @return Current pickerIconHeight value. Default value is 18
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }
    

    /**
     * Prompt to show when the user hovers the mouse over the picker icon.
     *
     * @param pickerIconPrompt New pickerIconPrompt value. Default value is "Click to select a new color"
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorItem setPickerIconPrompt(String pickerIconPrompt) {
        return (ColorItem)setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon.
     *
     * @return Current pickerIconPrompt value. Default value is "Click to select a new color"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon
     * image to be displayed. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting
     * this property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     *
     * @param pickerIconSrc New pickerIconSrc value. Default value is "[SKIN]/DynamicForm/ColorPicker_icon.png"
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public ColorItem setPickerIconSrc(String pickerIconSrc) {
        return (ColorItem)setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon
     * image to be displayed. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting
     * this property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     *
     * @return Current pickerIconSrc value. Default value is "[SKIN]/DynamicForm/ColorPicker_icon.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     *
     * @param pickerIconWidth New pickerIconWidth value. Default value is 18
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     */
    public ColorItem setPickerIconWidth(Integer pickerIconWidth) {
        return (ColorItem)setAttribute("pickerIconWidth", pickerIconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ColorItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     *
     * @return Current pickerIconWidth value. Default value is 18
     */
    public Integer getPickerIconWidth()  {
        return getAttributeAsInt("pickerIconWidth");
    }
    

    /**
     * Should the pick button icon be shown for choosing colors from a ColorPicker
     *
     * @param showPickerIcon New showPickerIcon value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     */
    public ColorItem setShowPickerIcon(Boolean showPickerIcon) {
        return (ColorItem)setAttribute("showPickerIcon", showPickerIcon);
    }

    /**
     * Should the pick button icon be shown for choosing colors from a ColorPicker
     *
     * @return Current showPickerIcon value. Default value is true
     */
    public Boolean getShowPickerIcon()  {
        Boolean result = getAttributeAsBoolean("showPickerIcon", true);
        return result == null ? true : result;
    }
    

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.form.ColorPicker} associated with this ColorItem allows the
     * user  to set transparency/opacity information whilst selecting a color. If false, no opacity slider is shown and all
     * colors are 100% opaque.<p> When an opacity value is selected, the HTML color string produced is 8 characters long
     * because the opacity setting is included. You can also capture the the separate color and opacity information by
     * overriding  {@link com.smartgwt.client.widgets.form.fields.ColorItem#addPickerColorSelectedHandler
     * ColorItem.pickerColorSelected()}.
     *
     * @param supportsTransparency New supportsTransparency value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ColorItem ColorItem} instance, for chaining setter calls
     */
    public ColorItem setSupportsTransparency(Boolean supportsTransparency) {
        return (ColorItem)setAttribute("supportsTransparency", supportsTransparency);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.form.ColorPicker} associated with this ColorItem allows the
     * user  to set transparency/opacity information whilst selecting a color. If false, no opacity slider is shown and all
     * colors are 100% opaque.<p> When an opacity value is selected, the HTML color string produced is 8 characters long
     * because the opacity setting is included. You can also capture the the separate color and opacity information by
     * overriding  {@link com.smartgwt.client.widgets.form.fields.ColorItem#addPickerColorSelectedHandler
     * ColorItem.pickerColorSelected()}.
     *
     * @return Current supportsTransparency value. Default value is true
     */
    public Boolean getSupportsTransparency()  {
        Boolean result = getAttributeAsBoolean("supportsTransparency", true);
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a pickerColorSelected handler.
     * <p>
     * Store the color value selected by the user from the color picker.  You will need to  override this method if you wish to
     * capture opacity information from the {@link com.smartgwt.client.widgets.form.ColorPicker}.
     *
     * @param handler the pickerColorSelected handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addPickerColorSelectedHandler(com.smartgwt.client.widgets.form.fields.events.PickerColorSelectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.PickerColorSelectedEvent.getType()) == 0) setupPickerColorSelectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.PickerColorSelectedEvent.getType());
    }

    private native void setupPickerColorSelectedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var pickerColorSelected = $entry(function(){
            var param = {"_this": this, "color" : arguments[0], "opacity" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.fields.events.PickerColorSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.ColorItem::handleTearDownPickerColorSelectedEvent()();
            });
        obj.pickerColorSelected =  pickerColorSelected 
        ;
    }-*/;

    private void handleTearDownPickerColorSelectedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.PickerColorSelectedEvent.getType()) == 0) tearDownPickerColorSelectedEvent();
    }

    private native void tearDownPickerColorSelectedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "pickerColorSelected" in obj) delete obj.pickerColorSelected;
    }-*/;


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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ColorItem colorItemProperties) /*-{
        if (colorItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ColorItem.@java.lang.Object::getClass()(), "setDefaultProperties", colorItemProperties.@java.lang.Object::getClass()());
        }
        colorItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = colorItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.ColorItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
