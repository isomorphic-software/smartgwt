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
 
package com.smartgwt.client.widgets.form.fields;


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
 * Item for picking a number. Includes arrow buttons to increase / decrease the value
 */
public class SpinnerItem extends TextItem {

    public static SpinnerItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);


        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SpinnerItem) obj;
        } else {
            return new SpinnerItem(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
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
        $wnd.isc["SpinnerItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["SpinnerItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param mask . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setMask(String mask) {
        setAttribute("mask", mask);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }


    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode maskOverwriteMode Default value is null
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
        return getAttributeAsBoolean("maskOverwriteMode");
    }


    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPadChar . See {@link com.smartgwt.client.docs.String String}. Default value is " "
     */
    public void setMaskPadChar(String maskPadChar) {
        setAttribute("maskPadChar", maskPadChar);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMaskPadChar()  {
        return getAttributeAsString("maskPadChar");
    }


    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPromptChar . See {@link com.smartgwt.client.docs.String String}. Default value is "_"
     */
    public void setMaskPromptChar(String maskPromptChar) {
        setAttribute("maskPromptChar", maskPromptChar);
    }

    /**
     * Not applicable to a SpinnerItem.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMaskPromptChar()  {
        return getAttributeAsString("maskPromptChar");
    }


    /**
     * Not applicable to a SpinnerItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals maskSaveLiterals Default value is null
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
        return getAttributeAsBoolean("maskSaveLiterals");
    }




    // ********************* Methods ***********************

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
     * @param spinnerItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SpinnerItem spinnerItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},spinnerItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
    	delete properties.ID;
        $wnd.isc.SpinnerItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * How much should the value be incremented / decremented when the user hits the icons  to increase / decrease the
     * value?
     *
     * @param step step Default value is 1
     */
    public void setStep(double step) {
        setAttribute("step", step);
    }

    public void setStep(int step) {
        setAttribute("step", step);
    }

    /**
     * How much should the value be incremented / decremented when the user hits the icons  to increase / decrease the
     * value?
     *
     * @return int
     */
    public double getStep() {
        return getAttributeAsFloat("step");
    }

    /**
     * Maximum valid value for this item
     *
     * @param max max Default value is null
     */
    public void setMax(Double max) {
        setAttribute("max", max);
    }

    public void setMax(Integer max) {
        setAttribute("max", max);
    }

    /**
     * Maximum valid value for this item
     *
     * @return Integer
     */
    public Double getMax() {
        return getAttributeAsDouble("max");
    }

    /**
     * Minimum valid value for this item
     *
     * @param min min Default value is null
     */
    public void setMin(Double min) {
        setAttribute("min", min);
    }

    public void setMin(Integer min) {
        setAttribute("min", min);
    }

    /**
     * Minimum valid value for this item
     *
     * @return Integer
     */
    public Double getMin() {
        return getAttributeAsDouble("min");
    }

    public void setDefaultValue(Double defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    public void setDefaultValue(Integer defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }       

}


