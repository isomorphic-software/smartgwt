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
 
package com.smartgwt.client.widgets.form;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * The ColorPicker widget allows the user to select a color from anywhere in the  color spectrum. It also supports
 * selecting the alpha (opacity) value of the  color.  The picker supports a simple mode - which allows for one-click
 * selection from a standard palette of colors - and a complex mode which allow the user to define any conceivable color.
 * It is possible for the user to switch from simple mode to complex by interacting with the widget.  In general, the
 * widget provides very similar functionality to the color picker dialogs found in graphics packages and other desktop
 * software.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ColorPicker")
public class ColorPicker extends Window implements com.smartgwt.client.widgets.form.events.HasColorChangedHandlers, com.smartgwt.client.widgets.form.events.HasColorSelectedHandlers {

    public static ColorPicker getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ColorPicker(jsObj);
        } else {
            assert refInstance instanceof ColorPicker;
            return (ColorPicker)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ColorPicker.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ColorPicker.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ColorPicker.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ColorPicker.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public ColorPicker(){
        scClassName = "ColorPicker";
    }

    public ColorPicker(JavaScriptObject jsObj){
        scClassName = "ColorPicker";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Should the "complex" mode be allowed for this ColorPicker? If false, no "More" button is shown on the simple picker
     *
     * @param allowComplexMode New allowComplexMode value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setAllowComplexMode(Boolean allowComplexMode)  throws IllegalStateException {
        return (ColorPicker)setAttribute("allowComplexMode", allowComplexMode, false);
    }

    /**
     * Should the "complex" mode be allowed for this ColorPicker? If false, no "More" button is shown on the simple picker
     *
     * @return Current allowComplexMode value. Default value is true
     */
    public Boolean getAllowComplexMode()  {
        Boolean result = getAttributeAsBoolean("allowComplexMode");
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoPosition autoPosition} is false, this property controls
     * whether to automatically center the colorPicker every time it is redisplayed with the show() method.
     *
     * @param autoCenterOnShow New autoCenterOnShow value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.form.ColorPicker#setAutoPosition
     */
    public ColorPicker setAutoCenterOnShow(Boolean autoCenterOnShow)  throws IllegalStateException {
        return (ColorPicker)setAttribute("autoCenterOnShow", autoCenterOnShow, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoPosition autoPosition} is false, this property controls
     * whether to automatically center the colorPicker every time it is redisplayed with the show() method.
     *
     * @return Current autoCenterOnShow value. Default value is true
     * @see com.smartgwt.client.widgets.form.ColorPicker#getAutoPosition
     */
    public Boolean getAutoCenterOnShow()  {
        Boolean result = getAttributeAsBoolean("autoCenterOnShow");
        return result == null ? true : result;
    }
    

    /**
     * When this property is set to true, the <code>ColorPicker</code> will automatically hide when a color has been selected
     * using the swatch picker, even in "complex" mode. By default it will only hide the <code>ColorPicker</code> in "simple"
     * defaultPickMode. <p> Set this property to false to disable the <code>ColorPicker</code> from automatically hiding, this
     * can be especially useful when for instance embedding this component inside another component.
     *
     * @param autoHide New autoHide value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.form.ColorPicker#setDefaultPickMode
     */
    public ColorPicker setAutoHide(Boolean autoHide)  throws IllegalStateException {
        return (ColorPicker)setAttribute("autoHide", autoHide, false);
    }

    /**
     * When this property is set to true, the <code>ColorPicker</code> will automatically hide when a color has been selected
     * using the swatch picker, even in "complex" mode. By default it will only hide the <code>ColorPicker</code> in "simple"
     * defaultPickMode. <p> Set this property to false to disable the <code>ColorPicker</code> from automatically hiding, this
     * can be especially useful when for instance embedding this component inside another component.
     *
     * @return Current autoHide value. Default value is null
     * @see com.smartgwt.client.widgets.form.ColorPicker#getDefaultPickMode
     */
    public Boolean getAutoHide()  {
        return getAttributeAsBoolean("autoHide");
    }
    

    /**
     * If true, causes the ColorPicker to appear near where the mouse was last clicked. If false, the ColorPicker is centered
     * on first show; depending on the value of  {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoCenterOnShow
     * autoCenterOnShow}, it either reappears wherever it was last shown after hide/show(),  or centered regardless of where it
     * was last shown.
     *
     * @param autoPosition New autoPosition value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.form.ColorPicker#setAutoCenterOnShow
     */
    public ColorPicker setAutoPosition(Boolean autoPosition)  throws IllegalStateException {
        return (ColorPicker)setAttribute("autoPosition", autoPosition, false);
    }

    /**
     * If true, causes the ColorPicker to appear near where the mouse was last clicked. If false, the ColorPicker is centered
     * on first show; depending on the value of  {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoCenterOnShow
     * autoCenterOnShow}, it either reappears wherever it was last shown after hide/show(),  or centered regardless of where it
     * was last shown.
     *
     * @return Current autoPosition value. Default value is true
     * @see com.smartgwt.client.widgets.form.ColorPicker#getAutoCenterOnShow
     */
    public Boolean getAutoPosition()  {
        Boolean result = getAttributeAsBoolean("autoPosition");
        return result == null ? true : result;
    }
    

    /**
     * The label shown above the basic color blocks.
     *
     * @param basicColorLabel New basicColorLabel value. Default value is "Basic Colors:"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setBasicColorLabel(String basicColorLabel)  throws IllegalStateException {
        return (ColorPicker)setAttribute("basicColorLabel", basicColorLabel, false);
    }

    /**
     * The label shown above the basic color blocks.
     *
     * @return Current basicColorLabel value. Default value is "Basic Colors:"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getBasicColorLabel()  {
        return getAttributeAsString("basicColorLabel");
    }
    

    /**
     * The text to show when the mouse hovers over the 'Blue' field in the complex chooser.
     *
     * @param blueFieldPrompt New blueFieldPrompt value. Default value is "The Blue component of the selected color"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setBlueFieldPrompt(String blueFieldPrompt)  throws IllegalStateException {
        return (ColorPicker)setAttribute("blueFieldPrompt", blueFieldPrompt, false);
    }

    /**
     * The text to show when the mouse hovers over the 'Blue' field in the complex chooser.
     *
     * @return Current blueFieldPrompt value. Default value is "The Blue component of the selected color"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getBlueFieldPrompt()  {
        return getAttributeAsString("blueFieldPrompt");
    }
    

    /**
     * The title for the 'Blue' field in the complex chooser.
     *
     * @param blueFieldTitle New blueFieldTitle value. Default value is "Blue"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setBlueFieldTitle(String blueFieldTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("blueFieldTitle", blueFieldTitle, false);
    }

    /**
     * The title for the 'Blue' field in the complex chooser.
     *
     * @return Current blueFieldTitle value. Default value is "Blue"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getBlueFieldTitle()  {
        return getAttributeAsString("blueFieldTitle");
    }
    

    /**
     * Cancel button for the ColorPicker
     * <p>
     * This component is an AutoChild named "cancelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current cancelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    
    

    /**
     * The title for the 'Cancel' button.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title for the 'Cancel' button.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * Array of 40 HTML color strings, used to render the basic color selection boxes.
     *
     * @param colorArray New colorArray value. Default value is [...]
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setColorArray(String[] colorArray)  throws IllegalStateException {
        return (ColorPicker)setAttribute("colorArray", colorArray, false);
    }

    /**
     * Array of 40 HTML color strings, used to render the basic color selection boxes.
     *
     * @return Current colorArray value. Default value is [...]
     */
    public String[] getColorArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("colorArray"));
    }
    

    /**
     * Base CSS style applied to the basic color boxes
     *
     * @param colorButtonBaseStyle New colorButtonBaseStyle value. Default value is "ColorChooserCell"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public ColorPicker setColorButtonBaseStyle(String colorButtonBaseStyle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("colorButtonBaseStyle", colorButtonBaseStyle, false);
    }

    /**
     * Base CSS style applied to the basic color boxes
     *
     * @return Current colorButtonBaseStyle value. Default value is "ColorChooserCell"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getColorButtonBaseStyle()  {
        return getAttributeAsString("colorButtonBaseStyle");
    }
    

    /**
     * Width and height of the basic color boxes (they are always square, and they are all the same size).
     *
     * @param colorButtonSize New colorButtonSize value. Default value is 20
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setColorButtonSize(int colorButtonSize)  throws IllegalStateException {
        return (ColorPicker)setAttribute("colorButtonSize", colorButtonSize, false);
    }

    /**
     * Width and height of the basic color boxes (they are always square, and they are all the same size).
     *
     * @return Current colorButtonSize value. Default value is 20
     */
    public int getColorButtonSize()  {
        return getAttributeAsInt("colorButtonSize");
    }
    

    /**
     * The location of the crosshair image file
     *
     * @param crosshairImageURL New crosshairImageURL value. Default value is "[SKIN]ColorPicker/crosshair.png"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public ColorPicker setCrosshairImageURL(String crosshairImageURL)  throws IllegalStateException {
        return (ColorPicker)setAttribute("crosshairImageURL", crosshairImageURL, false);
    }

    /**
     * The location of the crosshair image file
     *
     * @return Current crosshairImageURL value. Default value is "[SKIN]ColorPicker/crosshair.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getCrosshairImageURL()  {
        return getAttributeAsString("crosshairImageURL");
    }
    

    /**
     * The default color. This is the color that is selected when the picker first loads
     *
     * @param defaultColor New defaultColor value. Default value is #808080
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setDefaultColor(String defaultColor)  throws IllegalStateException {
        return (ColorPicker)setAttribute("defaultColor", defaultColor, false);
    }

    /**
     * The default color. This is the color that is selected when the picker first loads
     *
     * @return Current defaultColor value. Default value is #808080
     */
    public String getDefaultColor()  {
        return getAttributeAsString("defaultColor");
    }
    

    /**
     * The initial opacity value for the component, as a percentage value between 0 and 100
     *
     * @param defaultOpacity New defaultOpacity value. Default value is 100
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setDefaultOpacity(int defaultOpacity)  throws IllegalStateException {
        return (ColorPicker)setAttribute("defaultOpacity", defaultOpacity, false);
    }

    /**
     * The initial opacity value for the component, as a percentage value between 0 and 100
     *
     * @return Current defaultOpacity value. Default value is 100
     */
    public int getDefaultOpacity()  {
        return getAttributeAsInt("defaultOpacity");
    }
    

    /**
     * The <code>ColorPicker</code> can operate in either a "simple" mode (where it displays just the 40 basic colors and
     * allows the user to click one), or a "complex" mode (where the user can specify a color from anywhere in the spectrum,
     * with an optional alpha element). The <code>defaultPickMode</code> attribute specifies which of these two modes is in
     * force when the picker first loads.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the pick mode of this <code>ColorPicker</code> to <code>pickMode</code>. <p> Note: It is not allowed to set the pick mode to  {@link com.smartgwt.client.types.ColorPickerMode#COMPLEX} if {@link com.smartgwt.client.widgets.form.ColorPicker#getAllowComplexMode allowComplexMode} is <code>false</code>.
     *
     * @param defaultPickMode the new pick mode. Default value is "simple"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.form.ColorPicker#setAllowComplexMode
     */
    public ColorPicker setDefaultPickMode(ColorPickerMode defaultPickMode)  throws IllegalStateException {
        return (ColorPicker)setAttribute("defaultPickMode", defaultPickMode == null ? null : defaultPickMode.getValue(), false);
    }

    /**
     * The <code>ColorPicker</code> can operate in either a "simple" mode (where it displays just the 40 basic colors and
     * allows the user to click one), or a "complex" mode (where the user can specify a color from anywhere in the spectrum,
     * with an optional alpha element). The <code>defaultPickMode</code> attribute specifies which of these two modes is in
     * force when the picker first loads.
     *
     * @return Current defaultPickMode value. Default value is "simple"
     * @see com.smartgwt.client.widgets.form.ColorPicker#getAllowComplexMode
     */
    public ColorPickerMode getDefaultPickMode()  {
        return EnumUtil.getEnum(ColorPickerMode.values(), getAttribute("defaultPickMode"));
    }
    

    /**
     * The text to show when the mouse hovers over the 'Green' field in the complex chooser.
     *
     * @param greenFieldPrompt New greenFieldPrompt value. Default value is "The Green component of the selected color"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setGreenFieldPrompt(String greenFieldPrompt)  throws IllegalStateException {
        return (ColorPicker)setAttribute("greenFieldPrompt", greenFieldPrompt, false);
    }

    /**
     * The text to show when the mouse hovers over the 'Green' field in the complex chooser.
     *
     * @return Current greenFieldPrompt value. Default value is "The Green component of the selected color"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getGreenFieldPrompt()  {
        return getAttributeAsString("greenFieldPrompt");
    }
    

    /**
     * The title for the 'Green' field in the complex chooser.
     *
     * @param greenFieldTitle New greenFieldTitle value. Default value is "Green"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setGreenFieldTitle(String greenFieldTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("greenFieldTitle", greenFieldTitle, false);
    }

    /**
     * The title for the 'Green' field in the complex chooser.
     *
     * @return Current greenFieldTitle value. Default value is "Green"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getGreenFieldTitle()  {
        return getAttributeAsString("greenFieldTitle");
    }
    

    /**
     * The text to show when the mouse hovers over the 'HTML' field in the complex chooser.
     *
     * @param htmlFieldPrompt New htmlFieldPrompt value. Default value is "The selected color''s HTML coding"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setHtmlFieldPrompt(String htmlFieldPrompt)  throws IllegalStateException {
        return (ColorPicker)setAttribute("htmlFieldPrompt", htmlFieldPrompt, false);
    }

    /**
     * The text to show when the mouse hovers over the 'HTML' field in the complex chooser.
     *
     * @return Current htmlFieldPrompt value. Default value is "The selected color''s HTML coding"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getHtmlFieldPrompt()  {
        return getAttributeAsString("htmlFieldPrompt");
    }
    

    /**
     * The title for the 'HTML' field in the complex chooser.
     *
     * @param htmlFieldTitle New htmlFieldTitle value. Default value is "HTML"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setHtmlFieldTitle(String htmlFieldTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("htmlFieldTitle", htmlFieldTitle, false);
    }

    /**
     * The title for the 'HTML' field in the complex chooser.
     *
     * @return Current htmlFieldTitle value. Default value is "HTML"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getHtmlFieldTitle()  {
        return getAttributeAsString("htmlFieldTitle");
    }
    

    /**
     * The text to show when the mouse hovers over the 'Hue' field in the complex chooser.
     *
     * @param hueFieldPrompt New hueFieldPrompt value. Default value is "The Hue (base tone) of the selected color"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setHueFieldPrompt(String hueFieldPrompt)  throws IllegalStateException {
        return (ColorPicker)setAttribute("hueFieldPrompt", hueFieldPrompt, false);
    }

    /**
     * The text to show when the mouse hovers over the 'Hue' field in the complex chooser.
     *
     * @return Current hueFieldPrompt value. Default value is "The Hue (base tone) of the selected color"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getHueFieldPrompt()  {
        return getAttributeAsString("hueFieldPrompt");
    }
    

    /**
     * The title for the 'Hue' field in the complex chooser.
     *
     * @param hueFieldTitle New hueFieldTitle value. Default value is "Hue"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setHueFieldTitle(String hueFieldTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("hueFieldTitle", hueFieldTitle, false);
    }

    /**
     * The title for the 'Hue' field in the complex chooser.
     *
     * @return Current hueFieldTitle value. Default value is "Hue"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getHueFieldTitle()  {
        return getAttributeAsString("hueFieldTitle");
    }
    

    /**
     * The title for the button that switches to a less complex view.
     *
     * @param lessButtonTitle New lessButtonTitle value. Default value is "&lt;&lt; Less"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setLessButtonTitle(String lessButtonTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("lessButtonTitle", lessButtonTitle, false);
    }

    /**
     * The title for the button that switches to a less complex view.
     *
     * @return Current lessButtonTitle value. Default value is "&lt;&lt; Less"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLessButtonTitle()  {
        return getAttributeAsString("lessButtonTitle");
    }
    

    /**
     * The text to show when the mouse hovers over the 'Luminosity' field in the complex chooser.
     *
     * @param lumFieldPrompt New lumFieldPrompt value. Default value is "The Luminosity (brightness) of the selected color"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setLumFieldPrompt(String lumFieldPrompt)  throws IllegalStateException {
        return (ColorPicker)setAttribute("lumFieldPrompt", lumFieldPrompt, false);
    }

    /**
     * The text to show when the mouse hovers over the 'Luminosity' field in the complex chooser.
     *
     * @return Current lumFieldPrompt value. Default value is "The Luminosity (brightness) of the selected color"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLumFieldPrompt()  {
        return getAttributeAsString("lumFieldPrompt");
    }
    

    /**
     * The title for the 'Luminosity' field in the complex chooser.
     *
     * @param lumFieldTitle New lumFieldTitle value. Default value is "Lum"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setLumFieldTitle(String lumFieldTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("lumFieldTitle", lumFieldTitle, false);
    }

    /**
     * The title for the 'Luminosity' field in the complex chooser.
     *
     * @return Current lumFieldTitle value. Default value is "Lum"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLumFieldTitle()  {
        return getAttributeAsString("lumFieldTitle");
    }
    

    /**
     * Width of the Luminosity bar
     *
     * @param lumWidth New lumWidth value. Default value is 15
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setLumWidth(int lumWidth)  throws IllegalStateException {
        return (ColorPicker)setAttribute("lumWidth", lumWidth, false);
    }

    /**
     * Width of the Luminosity bar
     *
     * @return Current lumWidth value. Default value is 15
     */
    public int getLumWidth()  {
        return getAttributeAsInt("lumWidth");
    }
    

    /**
     * "More"/"Less" button for the ColorPicker
     * <p>
     * This component is an AutoChild named "modeToggleButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current modeToggleButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getModeToggleButton() throws IllegalStateException {
        errorIfNotCreated("modeToggleButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("modeToggleButton"));
    }
    
    

    /**
     * The title for the button that switches to a more complex view.
     *
     * @param moreButtonTitle New moreButtonTitle value. Default value is "More &gt;&gt;"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setMoreButtonTitle(String moreButtonTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("moreButtonTitle", moreButtonTitle, false);
    }

    /**
     * The title for the button that switches to a more complex view.
     *
     * @return Current moreButtonTitle value. Default value is "More &gt;&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getMoreButtonTitle()  {
        return getAttributeAsString("moreButtonTitle");
    }
    

    /**
     * "OK" button for the ColorPicker
     * <p>
     * This component is an AutoChild named "okButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current okButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getOkButton() throws IllegalStateException {
        errorIfNotCreated("okButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("okButton"));
    }
    
    

    /**
     * The title for the 'OK' button.
     *
     * @param okButtonTitle New okButtonTitle value. Default value is "OK"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setOkButtonTitle(String okButtonTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("okButtonTitle", okButtonTitle, false);
    }

    /**
     * The title for the 'OK' button.
     *
     * @return Current okButtonTitle value. Default value is "OK"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getOkButtonTitle()  {
        return getAttributeAsString("okButtonTitle");
    }
    

    /**
     * The label shown next to the opacity slider. Ignored if  {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
     *
     * @param opacitySliderLabel New opacitySliderLabel value. Default value is "Opacity:"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setOpacitySliderLabel(String opacitySliderLabel)  throws IllegalStateException {
        return (ColorPicker)setAttribute("opacitySliderLabel", opacitySliderLabel, false);
    }

    /**
     * The label shown next to the opacity slider. Ignored if  {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
     *
     * @return Current opacitySliderLabel value. Default value is "Opacity:"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getOpacitySliderLabel()  {
        return getAttributeAsString("opacitySliderLabel");
    }
    

    /**
     * The text to show underneath the selected color box, so that it can  be seen through semi-transparent colors. If you do
     * not want such text, set  this value to blank. This value is irrelevant if  {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
     *
     * @param opacityText New opacityText value. Default value is "Lorem ipsum"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setOpacityText(String opacityText)  throws IllegalStateException {
        return (ColorPicker)setAttribute("opacityText", opacityText, false);
    }

    /**
     * The text to show underneath the selected color box, so that it can  be seen through semi-transparent colors. If you do
     * not want such text, set  this value to blank. This value is irrelevant if  {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
     *
     * @return Current opacityText value. Default value is "Lorem ipsum"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getOpacityText()  {
        return getAttributeAsString("opacityText");
    }
    

    /**
     * The text to show when the mouse hovers over the 'Red' field in the complex chooser.
     *
     * @param redFieldPrompt New redFieldPrompt value. Default value is "The Red component of the selected color"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setRedFieldPrompt(String redFieldPrompt)  throws IllegalStateException {
        return (ColorPicker)setAttribute("redFieldPrompt", redFieldPrompt, false);
    }

    /**
     * The text to show when the mouse hovers over the 'Red' field in the complex chooser.
     *
     * @return Current redFieldPrompt value. Default value is "The Red component of the selected color"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getRedFieldPrompt()  {
        return getAttributeAsString("redFieldPrompt");
    }
    

    /**
     * The title for the 'Red' field in the complex chooser.
     *
     * @param redFieldTitle New redFieldTitle value. Default value is "Red"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setRedFieldTitle(String redFieldTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("redFieldTitle", redFieldTitle, false);
    }

    /**
     * The title for the 'Red' field in the complex chooser.
     *
     * @return Current redFieldTitle value. Default value is "Red"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getRedFieldTitle()  {
        return getAttributeAsString("redFieldTitle");
    }
    

    /**
     * The text to show when the mouse hovers over the 'Saturation' field in the complex chooser.
     *
     * @param satFieldPrompt New satFieldPrompt value. Default value is "The Saturation (color purity) of the selected color"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setSatFieldPrompt(String satFieldPrompt)  throws IllegalStateException {
        return (ColorPicker)setAttribute("satFieldPrompt", satFieldPrompt, false);
    }

    /**
     * The text to show when the mouse hovers over the 'Saturation' field in the complex chooser.
     *
     * @return Current satFieldPrompt value. Default value is "The Saturation (color purity) of the selected color"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSatFieldPrompt()  {
        return getAttributeAsString("satFieldPrompt");
    }
    

    /**
     * The title for the 'Sat' field in the complex chooser.
     *
     * @param satFieldTitle New satFieldTitle value. Default value is "Sat"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setSatFieldTitle(String satFieldTitle)  throws IllegalStateException {
        return (ColorPicker)setAttribute("satFieldTitle", satFieldTitle, false);
    }

    /**
     * The title for the 'Sat' field in the complex chooser.
     *
     * @return Current satFieldTitle value. Default value is "Sat"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSatFieldTitle()  {
        return getAttributeAsString("satFieldTitle");
    }
    

    /**
     * The label shown next to the selected color box.
     *
     * @param selectedColorLabel New selectedColorLabel value. Default value is "Selected Color:"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ColorPicker setSelectedColorLabel(String selectedColorLabel)  throws IllegalStateException {
        return (ColorPicker)setAttribute("selectedColorLabel", selectedColorLabel, false);
    }

    /**
     * The label shown next to the selected color box.
     *
     * @return Current selectedColorLabel value. Default value is "Selected Color:"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSelectedColorLabel()  {
        return getAttributeAsString("selectedColorLabel");
    }
    

    /**
     * Should the Cancel button be visible. Set to false to hide the Cancel button.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCancelButton New showCancelButton value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setShowCancelButton(Boolean showCancelButton)  throws IllegalStateException {
        return (ColorPicker)setAttribute("showCancelButton", showCancelButton, false);
    }

    /**
     * Should the Cancel button be visible. Set to false to hide the Cancel button.
     *
     * @return Current showCancelButton value. Default value is true
     */
    public Boolean getShowCancelButton()  {
        Boolean result = getAttributeAsBoolean("showCancelButton");
        return result == null ? true : result;
    }
    

    /**
     * Should the Mode Toggle button be visible. Set to false to hide the Mode Toggle button.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showModeToggleButton New showModeToggleButton value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setShowModeToggleButton(Boolean showModeToggleButton)  throws IllegalStateException {
        return (ColorPicker)setAttribute("showModeToggleButton", showModeToggleButton, false);
    }

    /**
     * Should the Mode Toggle button be visible. Set to false to hide the Mode Toggle button.
     *
     * @return Current showModeToggleButton value. Default value is true
     */
    public Boolean getShowModeToggleButton()  {
        Boolean result = getAttributeAsBoolean("showModeToggleButton");
        return result == null ? true : result;
    }
    

    /**
     * Should the OK button be visible. Set to false to hide the OK button.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOkButton New showOkButton value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setShowOkButton(Boolean showOkButton)  throws IllegalStateException {
        return (ColorPicker)setAttribute("showOkButton", showOkButton, false);
    }

    /**
     * Should the OK button be visible. Set to false to hide the OK button.
     *
     * @return Current showOkButton value. Default value is true
     */
    public Boolean getShowOkButton()  {
        Boolean result = getAttributeAsBoolean("showOkButton");
        return result == null ? true : result;
    }
    

    /**
     * Determines whether to show the opacity slider. This allows the user to select colors with an alpha element (ie,
     * semi-transparent colors). If this attribute is set to false, no opacity slider is shown, and all colors are completely
     * opaque.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the {@link com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} flag.
     *
     * @param supportsTransparency Set to true to enable transparency/opacity. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setSupportsTransparency(Boolean supportsTransparency)  throws IllegalStateException {
        return (ColorPicker)setAttribute("supportsTransparency", supportsTransparency, false);
    }

    /**
     * Determines whether to show the opacity slider. This allows the user to select colors with an alpha element (ie,
     * semi-transparent colors). If this attribute is set to false, no opacity slider is shown, and all colors are completely
     * opaque.
     *
     * @return Current supportsTransparency value. Default value is true
     */
    public Boolean getSupportsTransparency()  {
        Boolean result = getAttributeAsBoolean("supportsTransparency");
        return result == null ? true : result;
    }
    

    /**
     * Displayed height of the color swatch image. The default height is approximately that used by the Windows&#174; XP color
     * picking window
     *
     * @param swatchHeight New swatchHeight value. Default value is 170
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setSwatchHeight(int swatchHeight)  throws IllegalStateException {
        return (ColorPicker)setAttribute("swatchHeight", swatchHeight, false);
    }

    /**
     * Displayed height of the color swatch image. The default height is approximately that used by the Windows&#174; XP color
     * picking window
     *
     * @return Current swatchHeight value. Default value is 170
     */
    public int getSwatchHeight()  {
        return getAttributeAsInt("swatchHeight");
    }
    

    /**
     * The location of the color swatch image file
     *
     * @param swatchImageURL New swatchImageURL value. Default value is "[SKIN]ColorPicker/spectrum.png"
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public ColorPicker setSwatchImageURL(String swatchImageURL)  throws IllegalStateException {
        return (ColorPicker)setAttribute("swatchImageURL", swatchImageURL, false);
    }

    /**
     * The location of the color swatch image file
     *
     * @return Current swatchImageURL value. Default value is "[SKIN]ColorPicker/spectrum.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSwatchImageURL()  {
        return getAttributeAsString("swatchImageURL");
    }
    

    /**
     * Displayed width of the color swatch image. The default width is approximately that used by the Windows&#174; XP color
     * picking window
     *
     * @param swatchWidth New swatchWidth value. Default value is 170
     * @return {@link com.smartgwt.client.widgets.form.ColorPicker ColorPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColorPicker setSwatchWidth(int swatchWidth)  throws IllegalStateException {
        return (ColorPicker)setAttribute("swatchWidth", swatchWidth, false);
    }

    /**
     * Displayed width of the color swatch image. The default width is approximately that used by the Windows&#174; XP color
     * picking window
     *
     * @return Current swatchWidth value. Default value is 170
     */
    public int getSwatchWidth()  {
        return getAttributeAsInt("swatchWidth");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a colorChanged handler.
     * <p>
     * Override this method to be kept informed when the ColorPicker changes in real-time  (for example, if you need to update
     * your own GUI accordingly). Then use the  getXxxx() methods (for example, {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getBlue getBlue()} or  {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getLuminosity getLuminosity()})to obtain current state as required.
     *
     * @param handler the colorChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addColorChangedHandler(com.smartgwt.client.widgets.form.events.ColorChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ColorChangedEvent.getType()) == 0) setupColorChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ColorChangedEvent.getType());
    }

    private native void setupColorChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var colorChanged = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.form.events.ColorChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.ColorPicker::handleTearDownColorChangedEvent()();
            if (hasDefaultHandler) this.Super("colorChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("colorChanged"));
            obj.addProperties({colorChanged:  colorChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("colorChanged"));
            obj.colorChanged =  colorChanged             ;
        }
    }-*/;

    private void handleTearDownColorChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.ColorChangedEvent.getType()) == 0) tearDownColorChangedEvent();
    }

    private native void tearDownColorChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("colorChanged")) delete obj.colorChanged;
    }-*/;

    /**
     * Add a colorSelected handler.
     * <p>
     * Override this method to be notified when the user selects a color either by clicking a basic color box in simple mode,
     * or by clicking  the OK button in complex mode. It is not intended that client code  call this method. The
     * <code>ColorPicker</code> may automatically hide itself after calling this method depending on {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getAutoHide ColorPicker.autoHide} and {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getDefaultPickMode ColorPicker.defaultPickMode}.
     *
     * @param handler the colorSelected handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addColorSelectedHandler(com.smartgwt.client.widgets.form.events.ColorSelectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ColorSelectedEvent.getType()) == 0) setupColorSelectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ColorSelectedEvent.getType());
    }

    private native void setupColorSelectedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var colorSelected = $entry(function(){
            var param = {"_this": this, "color" : arguments[0], "opacity" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.events.ColorSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.ColorPicker::handleTearDownColorSelectedEvent()();
            if (hasDefaultHandler) this.Super("colorSelected", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("colorSelected"));
            obj.addProperties({colorSelected:  colorSelected              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("colorSelected"));
            obj.colorSelected =  colorSelected             ;
        }
    }-*/;

    private void handleTearDownColorSelectedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.ColorSelectedEvent.getType()) == 0) tearDownColorSelectedEvent();
    }

    private native void tearDownColorSelectedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("colorSelected")) delete obj.colorSelected;
    }-*/;

	/**
     * Returns the Blue element of the currently-selected color, as an integer from 0-255
     *
     * @return blue color component
     * @see com.smartgwt.client.widgets.form.ColorPicker#setBlue
     */
    public native int getBlue() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getBlue", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getBlue();
        return ret;
    }-*/;

	/**
     * Returns the Green element of the currently-selected color, as an integer from 0-255
     *
     * @return green color component
     * @see com.smartgwt.client.widgets.form.ColorPicker#setGreen
     */
    public native int getGreen() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getGreen", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getGreen();
        return ret;
    }-*/;

	/**
     * Returns the currently-selected color, in HTML color representation form, as a string. HTML color representation is a
     * hash sign, followed by the red, green and blue elements of the color in 2-digit hex form - for example "#F17F1D"
     *
     * @return HTML color value
     * @see com.smartgwt.client.widgets.form.ColorPicker#setHtmlColor
     */
    public native String getHtmlColor() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getHtmlColor", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getHtmlColor();
        return ret;
    }-*/;

	/**
     * Returns the Hue of the currently-selected color, as an integer from 0-239
     *
     * @return hue value
     * @see com.smartgwt.client.widgets.form.ColorPicker#setHue
     */
    public native int getHue() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getHue", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getHue();
        return ret;
    }-*/;

	/**
     * Returns the Luminosity (brightness) of the currently-selected color, as an  integer from 0-240
     *
     * @return luminosity value
     * @see com.smartgwt.client.widgets.form.ColorPicker#setLuminosity
     */
    public native int getLuminosity() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLuminosity", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLuminosity();
        return ret;
    }-*/;

	/**
     * Returns the Red element of the currently-selected color, as an integer from 0-255
     *
     * @return red color component
     * @see com.smartgwt.client.widgets.form.ColorPicker#setRed
     */
    public native int getRed() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRed", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRed();
        return ret;
    }-*/;

	/**
     * Returns the Saturation of the currently-selected color, as an integer from 0-240
     *
     * @return saturation value
     * @see com.smartgwt.client.widgets.form.ColorPicker#setSaturation
     */
    public native int getSaturation() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSaturation", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSaturation();
        return ret;
    }-*/;

	/**
     * Sets the Blue element of the selected color
     * @param newValue An integer between 0 and 255
     * @see com.smartgwt.client.widgets.form.ColorPicker#getBlue
     */
    public native void setBlue(int newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setBlue", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setBlue(newValue);
    }-*/;

	/**
     * Changes the pick mode of this <code>ColorPicker</code> to <code>pickMode</code>. <p> Note: It is not allowed to set the
     * pick mode to  {@link com.smartgwt.client.types.ColorPickerMode#COMPLEX} if {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getAllowComplexMode allowComplexMode} is <code>false</code>.
     * @param pickMode the new pick mode.
     */
    public native void setCurrentPickMode(ColorPickerMode pickMode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCurrentPickMode", "ColorPickerMode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCurrentPickMode(pickMode.@com.smartgwt.client.types.ColorPickerMode::getValue()());
    }-*/;

	/**
     * Sets the Green element of the selected color
     * @param newValue An integer between 0 and 255
     * @see com.smartgwt.client.widgets.form.ColorPicker#getGreen
     */
    public native void setGreen(int newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setGreen", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setGreen(newValue);
    }-*/;

	/**
     * Changes the selected color to the one represented by the supplied HTML color  string. Note that the method only accepts
     * the parameter if it represents a  valid color (otherwise it is simply ignored).
     * @param newValue A string in HTML color representation format (#RRGGBB)
     * @see com.smartgwt.client.widgets.form.ColorPicker#getHtmlColor
     */
    public native void setHtmlColor(String newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setHtmlColor", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHtmlColor(newValue);
    }-*/;

	/**
     * Sets the Hue of the selected color
     * @param newValue An integer between 0 and 239
     * @see com.smartgwt.client.widgets.form.ColorPicker#getHue
     */
    public native void setHue(int newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setHue", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHue(newValue);
    }-*/;

	/**
     * Sets the Luminosity (brightness) of the selected color
     * @param newValue An integer between 0 and 240
     * @see com.smartgwt.client.widgets.form.ColorPicker#getLuminosity
     */
    public native void setLuminosity(int newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setLuminosity", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setLuminosity(newValue);
    }-*/;

	/**
     * Sets the Opacity of the selected color. Ignored if opacity is switched off.
     * @param newValue An integer between 0 and 100
     * @see com.smartgwt.client.widgets.form.ColorPicker#getOpacity
     */
    public native void setOpacity(int newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setOpacity", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setOpacity(newValue);
    }-*/;

	/**
     * Sets the Red element of the selected color
     * @param newValue An integer between 0 and 255
     * @see com.smartgwt.client.widgets.form.ColorPicker#getRed
     */
    public native void setRed(int newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setRed", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setRed(newValue);
    }-*/;

	/**
     * Sets the Saturation of the selected color
     * @param newValue An integer between 0 and 240
     * @see com.smartgwt.client.widgets.form.ColorPicker#getSaturation
     */
    public native void setSaturation(int newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setSaturation", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSaturation(newValue);
    }-*/;


    // ********************* Static Methods ***********************


    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
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
     * @param colorPickerProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ColorPicker colorPickerProperties) /*-{
        if (colorPickerProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ColorPicker.@java.lang.Object::getClass()(), "setDefaultProperties", colorPickerProperties.@java.lang.Object::getClass()());
        }
        colorPickerProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = colorPickerProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.ColorPicker.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ColorPickerLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.allowComplexMode = getAttributeAsString("allowComplexMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.allowComplexMode:" + t.getMessage() + "\n";
        }
        try {
            s.autoCenterOnShow = getAttributeAsString("autoCenterOnShow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.autoCenterOnShow:" + t.getMessage() + "\n";
        }
        try {
            s.autoHide = getAttributeAsString("autoHide");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.autoHide:" + t.getMessage() + "\n";
        }
        try {
            s.autoPosition = getAttributeAsString("autoPosition");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.autoPosition:" + t.getMessage() + "\n";
        }
        try {
            s.basicColorLabel = getAttributeAsString("basicColorLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.basicColorLabel:" + t.getMessage() + "\n";
        }
        try {
            s.blueFieldPrompt = getAttributeAsString("blueFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.blueFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.blueFieldTitle = getAttributeAsString("blueFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.blueFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.colorArray = getAttributeAsStringArray("colorArray");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.colorArrayArray:" + t.getMessage() + "\n";
        }
        try {
            s.colorButtonBaseStyle = getAttributeAsString("colorButtonBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.colorButtonBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.colorButtonSize = getAttributeAsString("colorButtonSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.colorButtonSize:" + t.getMessage() + "\n";
        }
        try {
            s.crosshairImageURL = getAttributeAsString("crosshairImageURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.crosshairImageURL:" + t.getMessage() + "\n";
        }
        try {
            s.defaultColor = getAttributeAsString("defaultColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.defaultColor:" + t.getMessage() + "\n";
        }
        try {
            s.defaultOpacity = getAttributeAsString("defaultOpacity");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.defaultOpacity:" + t.getMessage() + "\n";
        }
        try {
            s.defaultPickMode = getAttributeAsString("defaultPickMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.defaultPickMode:" + t.getMessage() + "\n";
        }
        try {
            s.greenFieldPrompt = getAttributeAsString("greenFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.greenFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.greenFieldTitle = getAttributeAsString("greenFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.greenFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.htmlFieldPrompt = getAttributeAsString("htmlFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.htmlFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.htmlFieldTitle = getAttributeAsString("htmlFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.htmlFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.hueFieldPrompt = getAttributeAsString("hueFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.hueFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.hueFieldTitle = getAttributeAsString("hueFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.hueFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.lessButtonTitle = getAttributeAsString("lessButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.lessButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.lumFieldPrompt = getAttributeAsString("lumFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.lumFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.lumFieldTitle = getAttributeAsString("lumFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.lumFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.lumWidth = getAttributeAsString("lumWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.lumWidth:" + t.getMessage() + "\n";
        }
        try {
            s.moreButtonTitle = getAttributeAsString("moreButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.moreButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.okButtonTitle = getAttributeAsString("okButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.okButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.opacitySliderLabel = getAttributeAsString("opacitySliderLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.opacitySliderLabel:" + t.getMessage() + "\n";
        }
        try {
            s.opacityText = getAttributeAsString("opacityText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.opacityText:" + t.getMessage() + "\n";
        }
        try {
            s.redFieldPrompt = getAttributeAsString("redFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.redFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.redFieldTitle = getAttributeAsString("redFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.redFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.satFieldPrompt = getAttributeAsString("satFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.satFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.satFieldTitle = getAttributeAsString("satFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.satFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.selectedColorLabel = getAttributeAsString("selectedColorLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.selectedColorLabel:" + t.getMessage() + "\n";
        }
        try {
            s.showCancelButton = getAttributeAsString("showCancelButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.showCancelButton:" + t.getMessage() + "\n";
        }
        try {
            s.showModeToggleButton = getAttributeAsString("showModeToggleButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.showModeToggleButton:" + t.getMessage() + "\n";
        }
        try {
            s.showOkButton = getAttributeAsString("showOkButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.showOkButton:" + t.getMessage() + "\n";
        }
        try {
            s.supportsTransparency = getAttributeAsString("supportsTransparency");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.supportsTransparency:" + t.getMessage() + "\n";
        }
        try {
            s.swatchHeight = getAttributeAsString("swatchHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.swatchHeight:" + t.getMessage() + "\n";
        }
        try {
            s.swatchImageURL = getAttributeAsString("swatchImageURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.swatchImageURL:" + t.getMessage() + "\n";
        }
        try {
            s.swatchWidth = getAttributeAsString("swatchWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColorPicker.swatchWidth:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ColorPickerLogicalStructure s = new ColorPickerLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
