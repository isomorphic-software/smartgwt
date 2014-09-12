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
 * Item for picking a number. Includes arrow buttons to increase / decrease the value
 */
@BeanFactory.FrameworkClass
public class SpinnerItem extends TextItem {

    public static SpinnerItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("SpinnerItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SpinnerItem) obj;
        } else {
            return new SpinnerItem(jsObj);
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
        $wnd.isc.SpinnerItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.SpinnerItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
        $wnd.isc.SpinnerItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.SpinnerItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public SpinnerItem(){
        setAttribute("editorType", "SpinnerItem");
    }

    public SpinnerItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public SpinnerItem(String name) {
        setName(name);
                setAttribute("editorType", "SpinnerItem");
    }


    public SpinnerItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "SpinnerItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons stacked mode}, the icon to decrease
     * the spinner's value (a down arrow by default).
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FormItemIcon
     */
    public FormItemIcon getDecreaseIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("decreaseIcon"));
    }
    

    /**
     * FormItemIcon properties applied to the {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getDecreaseIcon
     * decreaseIcon} AutoChild of this SpinnerItem.
     *
     * @param decreaseIconProperties  Default value is null
     */
    public void setDecreaseIconProperties(FormItemIcon decreaseIconProperties) {
        setAttribute("decreaseIconProperties", decreaseIconProperties.getJsObj());
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons stacked mode}, the icon to increase
     * the spinner's value (an up arrow by default).
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FormItemIcon
     */
    public FormItemIcon getIncreaseIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("increaseIcon"));
    }
    

    /**
     * FormItemIcon properties applied to the {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getIncreaseIcon
     * increaseIcon} AutoChild of this SpinnerItem.
     *
     * @param increaseIconProperties  Default value is null
     */
    public void setIncreaseIconProperties(FormItemIcon increaseIconProperties) {
        setAttribute("increaseIconProperties", increaseIconProperties.getJsObj());
    }
    

    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param mask  Default value is null
     */
    public void setMask(String mask) {
        setAttribute("mask", mask);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return String
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }
    

    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode  Default value is null
     */
    public void setMaskOverwriteMode(Boolean maskOverwriteMode) {
        setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return Boolean
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode", true);
    }
    

    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPadChar  Default value is " "
     */
    public void setMaskPadChar(String maskPadChar) {
        setAttribute("maskPadChar", maskPadChar);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return String
     */
    public String getMaskPadChar()  {
        return getAttributeAsString("maskPadChar");
    }
    

    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPromptChar  Default value is "_"
     */
    public void setMaskPromptChar(String maskPromptChar) {
        setAttribute("maskPromptChar", maskPromptChar);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return String
     */
    public String getMaskPromptChar()  {
        return getAttributeAsString("maskPromptChar");
    }
    

    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals  Default value is null
     */
    public void setMaskSaveLiterals(Boolean maskSaveLiterals) {
        setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return Boolean
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals", true);
    }
    

    /**
     * Maximum valid value for this item. If this and {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMin min}
     * are both null or unspecified, then  the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setNextValueHandler(NextValueHandler) nextValueHandler} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setPreviousValueHandler(PreviousValueHandler) previousValueHandler}
     * are used to increase or decrease the value and these handlers  are also used to determine the maximum value.
     *
     * @param max  Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Spinner Example</a>
     */
    public void setMax(Double max) {
        setAttribute("max", max);
    }

    /**
     * Maximum valid value for this item. If this and {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMin min}
     * are both null or unspecified, then  the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setNextValueHandler(NextValueHandler) nextValueHandler} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setPreviousValueHandler(PreviousValueHandler) previousValueHandler}
     * are used to increase or decrease the value and these handlers  are also used to determine the maximum value.
     *
     * @return Double
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Spinner Example</a>
     */
    public Double getMax()  {
        return getAttributeAsDouble("max");
    }
    

    /**
     * Minimum valid value for this item. If this and {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMax max}
     * are both null or unspecified, then  the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setNextValueHandler(NextValueHandler) nextValueHandler} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setPreviousValueHandler(PreviousValueHandler) previousValueHandler}
     * are used to increase or decrease the value and these handlers  are also used to determine the minimum value.
     *
     * @param min  Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Spinner Example</a>
     */
    public void setMin(Double min) {
        setAttribute("min", min);
    }

    /**
     * Minimum valid value for this item. If this and {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMax max}
     * are both null or unspecified, then  the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setNextValueHandler(NextValueHandler) nextValueHandler} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setPreviousValueHandler(PreviousValueHandler) previousValueHandler}
     * are used to increase or decrease the value and these handlers  are also used to determine the minimum value.
     *
     * @return Double
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Spinner Example</a>
     */
    public Double getMin()  {
        return getAttributeAsDouble("min");
    }
    

    /**
     * How much should the value be incremented / decremented when the user hits the icons to increase / decrease the value?
     * <p>  When providing a {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#setNextValueHandler(NextValueHandler)
     * nextValueHandler} and/or {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setPreviousValueHandler(PreviousValueHandler) previousValueHandler},
     * the sign of the step value determines whether these handlers  are expected to induce monotonically increasing or
     * decreasing functions.
     *
     * @param step  Default value is 1
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Spinner Example</a>
     */
    public void setStep(double step) {
        setAttribute("step", step);
    }

    /**
     * How much should the value be incremented / decremented when the user hits the icons to increase / decrease the value?
     * <p>  When providing a {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#setNextValueHandler(NextValueHandler)
     * nextValueHandler} and/or {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#setPreviousValueHandler(PreviousValueHandler) previousValueHandler},
     * the sign of the step value determines whether these handlers  are expected to induce monotonically increasing or
     * decreasing functions.
     *
     * @return double
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Spinner Example</a>
     */
    public double getStep()  {
        return getAttributeAsDouble("step");
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons unstacked mode}, the icon to decrease
     * the <code>SpinnerItem</code>'s value. <p> By default, <code>"[SKIN]/DynamicForm/Spinner_decrease_icon.png"</code> is
     * stretched to an 18x18 icon.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FormItemIcon
     */
    public FormItemIcon getUnstackedDecreaseIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("unstackedDecreaseIcon"));
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons unstacked mode}, the icon to increase
     * the <code>SpinnerItem</code>'s value. <p> By default, <code>"[SKIN]/DynamicForm/Spinner_increase_icon.png"</code> is
     * stretched to an 18x18 icon.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FormItemIcon
     */
    public FormItemIcon getUnstackedIncreaseIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("unstackedIncreaseIcon"));
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons unstacked mode}, the base CSS class
     * name for the <code>SpinnerItem</code>'s text box element when printed. If unset, then {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getUnstackedTextBoxStyle unstackedTextBoxStyle} is used.
     *
     * @param unstackedPrintTextBoxStyle  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} . Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setUnstackedPrintTextBoxStyle(String unstackedPrintTextBoxStyle) {
        setAttribute("unstackedPrintTextBoxStyle", unstackedPrintTextBoxStyle);
    }

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons unstacked mode}, the base CSS class
     * name for the <code>SpinnerItem</code>'s text box element when printed. If unset, then {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getUnstackedTextBoxStyle unstackedTextBoxStyle} is used.
     *
     * @return  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getUnstackedPrintTextBoxStyle()  {
        return getAttributeAsString("unstackedPrintTextBoxStyle");
    }
    

    /**
     * 
     *
     * @param unstackedReadOnlyTextBoxStyle  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} . Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setUnstackedReadOnlyTextBoxStyle(String unstackedReadOnlyTextBoxStyle) {
        setAttribute("unstackedReadOnlyTextBoxStyle", unstackedReadOnlyTextBoxStyle);
    }

    /**
     * 
     *
     * @return  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getUnstackedReadOnlyTextBoxStyle()  {
        return getAttributeAsString("unstackedReadOnlyTextBoxStyle");
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons unstacked mode}, the base CSS class
     * name for the <code>SpinnerItem</code>'s text box element. <P> NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @param unstackedTextBoxStyle  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} . Default value is "textItem"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setUnstackedTextBoxStyle(String unstackedTextBoxStyle) {
        setAttribute("unstackedTextBoxStyle", unstackedTextBoxStyle);
    }

    /**
     * In {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getWriteStackedIcons unstacked mode}, the base CSS class
     * name for the <code>SpinnerItem</code>'s text box element. <P> NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @return  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getUnstackedTextBoxStyle()  {
        return getAttributeAsString("unstackedTextBoxStyle");
    }
    

    /**
     * When set to <code>true</code>, the increase and decrease icons are stacked on top of each other, also called stacked
     * mode. When <code>false</code>, the increase and decrease icons are placed on the same line as the
     * <code>SpinnerItem</code>'s text box, also called unstacked mode. When <code>null</code>, a default setting depending on
     * {@link com.smartgwt.client.util.Browser#isTouch isTouch} is used (for touch browsers, the default is
     * <code>false</code>/unstacked mode). <p> In stacked mode, {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getIncreaseIcon increaseIcon} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getDecreaseIcon decreaseIcon} control the appearance of the stacked
     * icons. <p> In unstacked mode, {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getUnstackedIncreaseIcon
     * unstackedIncreaseIcon} and {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getUnstackedDecreaseIcon
     * unstackedDecreaseIcon} control the appearance of the unstacked icons.
     *
     * @param writeStackedIcons  Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWriteStackedIcons(Boolean writeStackedIcons) {
        setAttribute("writeStackedIcons", writeStackedIcons);
    }

    /**
     * When set to <code>true</code>, the increase and decrease icons are stacked on top of each other, also called stacked
     * mode. When <code>false</code>, the increase and decrease icons are placed on the same line as the
     * <code>SpinnerItem</code>'s text box, also called unstacked mode. When <code>null</code>, a default setting depending on
     * {@link com.smartgwt.client.util.Browser#isTouch isTouch} is used (for touch browsers, the default is
     * <code>false</code>/unstacked mode). <p> In stacked mode, {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getIncreaseIcon increaseIcon} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getDecreaseIcon decreaseIcon} control the appearance of the stacked
     * icons. <p> In unstacked mode, {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getUnstackedIncreaseIcon
     * unstackedIncreaseIcon} and {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getUnstackedDecreaseIcon
     * unstackedDecreaseIcon} control the appearance of the unstacked icons.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWriteStackedIcons()  {
        return getAttributeAsBoolean("writeStackedIcons", true);
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
     * @param spinnerItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SpinnerItem spinnerItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},spinnerItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.SpinnerItem.addProperties(properties);
    }-*/;

    // ***********************************************************



    public final void setMax(Integer max) {
        setMax(max == null ? null : max.doubleValue());
    }

    public final void setMin(Integer min) {
        setMin(min == null ? null : min.doubleValue());
    }

    public void setDefaultValue(Double defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    public void setDefaultValue(Integer defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMin() min} and
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMax() max} are both null
     * or unspecified, the nextValueHandler is used to get the next higher value from the
     * currentValue. The default implementation returns (currentValue&nbsp;+&nbsp;step).
     * <p>
     * To indicate that the given currentValue is the maximum value, return currentValue again.
     * <p>
     * Implementations should expect to be passed any value for currentValue. Also, if
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getStep() step} is non-negative,
     * the nextValueHandler must induce a <a href="http://en.wikipedia.org/wiki/Monotonic_function">monotonically increasing (non-decreasing) function</a>;
     * otherwise, the nextValueHandler must induce a monotonically decreasing function.
     */
    public native void setNextValueHandler(NextValueHandler handler) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();

        if (handler == null) {
            if (self.getClass) {
                self.getNextValue = self.getClass().getInstanceProperty("getNextValue");
            } else {
                delete self.getNextValue;
            }
        } else {
            self.getNextValue = $entry(function (currentValue, step) {
                return handler.@com.smartgwt.client.widgets.form.fields.NextValueHandler::execute(DD)(currentValue, step);
            });
        }
    }-*/;

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMin() min} and
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getMax() max} are both null
     * or unspecified, the previousValueHandler is used to get the previous lower value from the
     * currentValue. The default implementation returns (currentValue&nbsp;<b>+</b>&nbsp;step)
     * because the step parameter is based on <em>the opposite</em> of
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getStep() this.step}.
     * <p>
     * To indicate that the given currentValue is the minimum value, return currentValue again.
     * <p>
     * Implementations should expect to be passed any value for currentValue. Also, if
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem#getStep() step} is non-negative,
     * the previousValueHandler must induce a <a href="http://en.wikipedia.org/wiki/Monotonic_function">monotonically decreasing (non-increasing) function</a>;
     * otherwise, the previousValueHandler must induce a monotonically increasing function.
     */
    public native void setPreviousValueHandler(PreviousValueHandler handler) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();

        if (handler == null) {
            if (self.getClass) {
                self.getPreviousValue = self.getClass().getInstanceProperty("getPreviousValue");
            } else {
                delete self.getPreviousValue;
            }
        } else {
            self.getPreviousValue = $entry(function (currentValue, step) {
                return handler.@com.smartgwt.client.widgets.form.fields.PreviousValueHandler::execute(DD)(currentValue, step);
            });
        }
    }-*/;

}


