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
 
package com.smartgwt.client.data;



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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Definition of a hilite style. <P> See {@link com.smartgwt.client.docs.Hiliting} for an overview.
 */
public class Hilite extends RefDataClass {

    public static Hilite getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (Hilite) obj;
        } else {
            return new Hilite(jsObj);
        }
    }

    public Hilite(){
        
    }

    public Hilite(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * When edited via a HiliteEditor, the value for the background color of this  hilite.  If this is omitted, it will be
     * automatically derived from the <i>backgroundColor</i> attribute of {@link com.smartgwt.client.data.Hilite#getCssText
     * cssText}.  When a hilite is saved in a HiliteEditor, both  attributes are set automatically.
     *
     * @param backgroundColor backgroundColor Default value is null
     */
    public void setBackgroundColor(String backgroundColor) {
        setAttribute("backgroundColor", backgroundColor);
    }

    /**
     * When edited via a HiliteEditor, the value for the background color of this  hilite.  If this is omitted, it will be
     * automatically derived from the <i>backgroundColor</i> attribute of {@link com.smartgwt.client.data.Hilite#getCssText
     * cssText}.  When a hilite is saved in a HiliteEditor, both  attributes are set automatically.
     *
     *
     * @return String
     */
    public String getBackgroundColor()  {
        return getAttributeAsString("backgroundColor");
    }

    /**
     * CSS text to be applied to cells where this hilite is applied, for example, "background-color:#FF0000"
     *
     * @param cssText cssText Default value is null
     */
    public void setCssText(String cssText) {
        setAttribute("cssText", cssText);
    }

    /**
     * CSS text to be applied to cells where this hilite is applied, for example, "background-color:#FF0000"
     *
     *
     * @return String
     */
    public String getCssText()  {
        return getAttributeAsString("cssText");
    }

    /**
     * Whether this hilite is currently disabled. <P> Hilites can be programmatically enabled and disabled via {@link
     * com.smartgwt.client.widgets.DataBoundComponent#enableHilite DataBoundComponent.enableHilite}.
     *
     * @param disabled disabled Default value is false
     */
    public void setDisabled(Boolean disabled) {
        setAttribute("disabled", disabled);
    }

    /**
     * Whether this hilite is currently disabled. <P> Hilites can be programmatically enabled and disabled via {@link
     * com.smartgwt.client.widgets.DataBoundComponent#enableHilite DataBoundComponent.enableHilite}.
     *
     *
     * @return Boolean
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled");
    }

    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     * @param fieldName fieldName Default value is null
     */
    public void setFieldName(String fieldName) {
        setAttribute("fieldName", fieldName);
    }

    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     *
     * @return String
     */
    public String getFieldName()  {
        return getAttributeAsString("fieldName");
    }

    /**
     * HTML to append to the end of cell values where this hilite is applied.
     *
     * @param htmlAfter htmlAfter Default value is null
     */
    public void setHtmlAfter(String htmlAfter) {
        setAttribute("htmlAfter", htmlAfter);
    }

    /**
     * HTML to append to the end of cell values where this hilite is applied.
     *
     *
     * @return String
     */
    public String getHtmlAfter()  {
        return getAttributeAsString("htmlAfter");
    }

    /**
     * HTML to prepend to cell values where this hilite is applied.
     *
     * @param htmlBefore htmlBefore Default value is null
     */
    public void setHtmlBefore(String htmlBefore) {
        setAttribute("htmlBefore", htmlBefore);
    }

    /**
     * HTML to prepend to cell values where this hilite is applied.
     *
     *
     * @return String
     */
    public String getHtmlBefore()  {
        return getAttributeAsString("htmlBefore");
    }

    /**
     * Value to show <b>in place of</b> the actual value from the record, for a record that matches this hilite. <P> This can
     * be used to take ranges of numeric values and simplify them to "Low", "Medium", "High" or similar textual values,
     * translate very small or very large values to "Outlier" or "Negligible", and similar use cases.
     *
     * @param htmlValue htmlValue Default value is null
     */
    public void setHtmlValue(String htmlValue) {
        setAttribute("htmlValue", htmlValue);
    }

    /**
     * Value to show <b>in place of</b> the actual value from the record, for a record that matches this hilite. <P> This can
     * be used to take ranges of numeric values and simplify them to "Low", "Medium", "High" or similar textual values,
     * translate very small or very large values to "Outlier" or "Negligible", and similar use cases.
     *
     *
     * @return String
     */
    public String getHtmlValue()  {
        return getAttributeAsString("htmlValue");
    }

    /**
     * URL of an icon to show when this hilite is applied to a cell.  Position of the icon  is controlled by {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition hiliteIconPosition} or  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition}.
     *
     * @param icon icon Default value is null
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * URL of an icon to show when this hilite is applied to a cell.  Position of the icon  is controlled by {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition hiliteIconPosition} or  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition}.
     *
     *
     * @return String
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
     * Unique id for this hilite definition.   <P> For hilites that include {@link com.smartgwt.client.data.Hilite#getCriteria
     * criteria} this is not required. <P> If you are explicitly marking records for hiliting, set {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteProperty hiliteProperty} on the record to this id.
     *
     * @param id id Default value is null
     */
    public void setId(String id) {
        setAttribute("id", id);
    }

    /**
     * Unique id for this hilite definition.   <P> For hilites that include {@link com.smartgwt.client.data.Hilite#getCriteria
     * criteria} this is not required. <P> If you are explicitly marking records for hiliting, set {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteProperty hiliteProperty} on the record to this id.
     *
     *
     * @return String
     */
    public String getId()  {
        return getAttributeAsString("id");
    }

    /**
     * When edited via a HiliteEditor, the value for the foreground color of this  hilite.  If this is omitted, it will be
     * automatically derived from the <i>textColor</i> attribute of {@link com.smartgwt.client.data.Hilite#getCssText cssText}.
     *  When a hilite is saved in a HiliteEditor, both  attributes are set automatically.
     *
     * @param textColor textColor Default value is null
     */
    public void setTextColor(String textColor) {
        setAttribute("textColor", textColor);
    }

    /**
     * When edited via a HiliteEditor, the value for the foreground color of this  hilite.  If this is omitted, it will be
     * automatically derived from the <i>textColor</i> attribute of {@link com.smartgwt.client.data.Hilite#getCssText cssText}.
     *  When a hilite is saved in a HiliteEditor, both  attributes are set automatically.
     *
     *
     * @return String
     */
    public String getTextColor()  {
        return getAttributeAsString("textColor");
    }

    /**
     * User-visible title for this hilite.  Used for interfaces such as menus that can enable or disable hilites.
     *
     * @param title title Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User-visible title for this hilite.  Used for interfaces such as menus that can enable or disable hilites.
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



/**
 * Definition of a hilite style. <P> See {@link com.smartgwt.client.docs.Hiliting} for an overview.
 */

    /**
     * Name of the fields that hilite should be applied to.   <P> If unset, hilite is applied to every field of the record.
     *
     * @param fieldNames fieldNames Default value is null
     */
    public void setFieldNames(String... fieldNames) {
        setAttribute("fieldName", fieldNames);
    }

    /**
     * Criteria defining what records this hilite should apply to.
     *
     * @param criteria criteria Default value is null
     */
    public void setCriteria(Criteria criteria) {
        setAttribute("criteria", criteria);
    }

    /**
     * Criteria defining what records this hilite should apply to.
     * @return Criteria
     */
    public Criteria getCriteria() {
        JavaScriptObject jso = getAttributeAsJavaScriptObject("criteria");
        return new Criteria(jso);
    }

    /**
     * Convert the native Javascript Hilite array representation into a Hilite array.
     *
     * @param nativeArray native hilite array
     * @return hilite array
     */
    public static Hilite[] convertToHiliteArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Hilite[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] hilitesJS = JSOHelper.toArray(nativeArray);
            Hilite[] objects = new Hilite[hilitesJS.length];
            for (int i = 0; i < hilitesJS.length; i++) {
                JavaScriptObject hiliteJS = hilitesJS[i];
                Hilite obj = (Hilite) RefDataClass.getRef(hiliteJS);
                if (obj == null) obj = new Hilite(hiliteJS);
                objects[i] = obj;
            }
            return objects;
        } else {
            Hilite[] ret = new Hilite[1];
            ret[0] = Hilite.getOrCreateRef(nativeArray);
            return ret;
        }
    }

}



