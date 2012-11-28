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
 * FormItem that shows a set of mutually exclusive options as a group of radio buttons.
 */
public class RadioGroupItem extends FormItem {

    public static RadioGroupItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RadioGroupItem(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


    public RadioGroupItem(){
        setAttribute("editorType", "RadioGroupItem");
    }

    public RadioGroupItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }

    public RadioGroupItem(String name) {
        setName(name);
        setAttribute("editorType", "RadioGroupItem");
    }

    public RadioGroupItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "RadioGroupItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Base CSS class applied to the text for items within this radiogroup.
     *
     * @param textBoxStyle . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}. Default value is "labelAnchor"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class applied to the text for items within this radiogroup.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * True == display options vertically, false == display in a single row
     *
     * @param vertical vertical Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical);
    }

    /**
     * True == display options vertically, false == display in a single row
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Should the text for items within this radio group wrap?
     *
     * @param wrap wrap Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * Should the text for items within this radio group wrap?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * Return the value tracked by this form item.
     *
     * @return value of this element
     */
    public native String getValueAsString() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if(self.setValue) {
             ret = self.getValue();
        } else {
            ret = self.value;
        }
        return ret == null || ret === undefined ? null : ret.toString();
    }-*/;    
    
    /**
     * Disable or Enable a specific option within this radioGroup
     * @param value value of option to disable
     * @param disabled true to disable the option, false to enable it
     */
    public native void setValueDisabled(Object value, boolean disabled) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (self.setValueDisabled) {
            self.setValueDisabled(value, disabled);
        } else {
            // pre-init, update the disabledValues object.
            var stringVal = value + "";
            if (self.disabledValues == null) {
                self.disabledValues = $wnd.Array.create();
            }
            if (self.disabledValues.contains(stringVal)) {
                if (!disabled) self.disabledValues.remove(stringVal);
            } else {
                if (disabled) self.disabledValues.add(stringVal);
            }
        }
        
    }-*/;
    
   /**
    * The FormItemHoverFormatter should return the HTML to display in a hover canvas when the 
    * user holds the mousepointer over a particular value in this item.
    * Return null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
    */
    public native void setValueHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.valueHoverHTML = $debox($entry(function(item, form) {
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        }));
    }-*/;


}



