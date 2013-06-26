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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public Hilite(){
        
    }

    public Hilite(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * When edited via a {@link com.smartgwt.client.widgets.grid.HiliteEditor}, the value for the background color of this 
     * hilite.  If this is omitted, it will be automatically derived from the <i>backgroundColor</i> attribute of {@link
     * com.smartgwt.client.data.Hilite#getCssText cssText}.  When a hilite is saved in a HiliteEditor, both  attributes are set
     * automatically.
     *
     * @param backgroundColor . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setBackgroundColor(String backgroundColor) {
        setAttribute("backgroundColor", backgroundColor);
    }

    /**
     * When edited via a {@link com.smartgwt.client.widgets.grid.HiliteEditor}, the value for the background color of this 
     * hilite.  If this is omitted, it will be automatically derived from the <i>backgroundColor</i> attribute of {@link
     * com.smartgwt.client.data.Hilite#getCssText cssText}.  When a hilite is saved in a HiliteEditor, both  attributes are set
     * automatically.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getBackgroundColor()  {
        return getAttributeAsString("backgroundColor");
    }



    /**
     * CSS text to be applied to cells where this hilite is applied, for example, "background-color:#FF0000"
     *
     * @param cssText . See {@link com.smartgwt.client.docs.CSSText CSSText}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setCssText(String cssText) {
        setAttribute("cssText", cssText);
    }

    /**
     * CSS text to be applied to cells where this hilite is applied, for example, "background-color:#FF0000"
     *
     * @return . See {@link com.smartgwt.client.docs.CSSText CSSText}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getCssText()  {
        return getAttributeAsString("cssText");
    }


    /**
     * Whether this hilite is currently disabled. <P> Hilites can be programmatically enabled and disabled via {@link
     * com.smartgwt.client.widgets.DataBoundComponent#enableHilite DataBoundComponent.enableHilite}.
     *
     * @param disabled disabled Default value is false
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setDisabled(Boolean disabled) {
        setAttribute("disabled", disabled);
    }

    /**
     * Whether this hilite is currently disabled. <P> Hilites can be programmatically enabled and disabled via {@link
     * com.smartgwt.client.widgets.DataBoundComponent#enableHilite DataBoundComponent.enableHilite}.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled");
    }


    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     * @param fieldName . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setFieldName(String fieldName) {
        setAttribute("fieldName", fieldName);
    }

    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getFieldName()  {
        return getAttributeAsString("fieldName");
    }


    /**
     * HTML to append to the end of cell values where this hilite is applied.
     *
     * @param htmlAfter . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHtmlAfter(String htmlAfter) {
        setAttribute("htmlAfter", htmlAfter);
    }

    /**
     * HTML to append to the end of cell values where this hilite is applied.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getHtmlAfter()  {
        return getAttributeAsString("htmlAfter");
    }


    /**
     * HTML to prepend to cell values where this hilite is applied.
     *
     * @param htmlBefore . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHtmlBefore(String htmlBefore) {
        setAttribute("htmlBefore", htmlBefore);
    }

    /**
     * HTML to prepend to cell values where this hilite is applied.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getHtmlBefore()  {
        return getAttributeAsString("htmlBefore");
    }


    /**
     * Value to show <b>in place of</b> the actual value from the record, for a record that matches this hilite. <P> This can
     * be used to take ranges of numeric values and simplify them to "Low", "Medium", "High" or similar textual values,
     * translate very small or very large values to "Outlier" or "Negligible", and similar use cases.
     *
     * @param htmlValue . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHtmlValue(String htmlValue) {
        setAttribute("htmlValue", htmlValue);
    }

    /**
     * Value to show <b>in place of</b> the actual value from the record, for a record that matches this hilite. <P> This can
     * be used to take ranges of numeric values and simplify them to "Low", "Medium", "High" or similar textual values,
     * translate very small or very large values to "Outlier" or "Negligible", and similar use cases.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getHtmlValue()  {
        return getAttributeAsString("htmlValue");
    }


    /**
     * URL of an icon to show when this hilite is applied to a cell.  Position of the icon  is controlled by {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition hiliteIconPosition} or  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition}.
     *
     * @param icon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * URL of an icon to show when this hilite is applied to a cell.  Position of the icon  is controlled by {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition hiliteIconPosition} or  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition}.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }


    /**
     * Unique id for this hilite definition.   <P> For hilites that include {@link com.smartgwt.client.data.Hilite#getCriteria
     * criteria} this is not required. <P> If you are explicitly marking records for hiliting, set {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteProperty hiliteProperty} on the record to this id.
     *
     * @param id . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setId(String id) {
        setAttribute("id", id);
    }

    /**
     * Unique id for this hilite definition.   <P> For hilites that include {@link com.smartgwt.client.data.Hilite#getCriteria
     * criteria} this is not required. <P> If you are explicitly marking records for hiliting, set {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteProperty hiliteProperty} on the record to this id.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getId()  {
        return getAttributeAsString("id");
    }


    /**
     * HTML which replaces the cell's textual value where this hilite is applied. <p> Note that sorting, filtering, etc
     * behavior will still operate on the underlying value. For example, if there is a date field with the FilterEditor
     * enabled, the default search interface will still offer date-range based filtering even if hilites have caused values to
     * be displayed as text such as "current" or "past due".
     *
     * @param replacementValue . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setReplacementValue(String replacementValue) {
        setAttribute("replacementValue", replacementValue);
    }

    /**
     * HTML which replaces the cell's textual value where this hilite is applied. <p> Note that sorting, filtering, etc
     * behavior will still operate on the underlying value. For example, if there is a date field with the FilterEditor
     * enabled, the default search interface will still offer date-range based filtering even if hilites have caused values to
     * be displayed as text such as "current" or "past due".
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getReplacementValue()  {
        return getAttributeAsString("replacementValue");
    }


    /**
     * When edited via a {@link com.smartgwt.client.widgets.grid.HiliteEditor}, the value for the foreground color of this 
     * hilite.  If this is omitted, it will be automatically derived from the <i>textColor</i> attribute of {@link
     * com.smartgwt.client.data.Hilite#getCssText cssText}.  When a hilite is saved in a HiliteEditor, both  attributes are set
     * automatically.
     *
     * @param textColor . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setTextColor(String textColor) {
        setAttribute("textColor", textColor);
    }

    /**
     * When edited via a {@link com.smartgwt.client.widgets.grid.HiliteEditor}, the value for the foreground color of this 
     * hilite.  If this is omitted, it will be automatically derived from the <i>textColor</i> attribute of {@link
     * com.smartgwt.client.data.Hilite#getCssText cssText}.  When a hilite is saved in a HiliteEditor, both  attributes are set
     * automatically.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getTextColor()  {
        return getAttributeAsString("textColor");
    }


    /**
     * User-visible title for this hilite.  Used for interfaces such as menus that can enable or disable hilites.
     *
     * @param title . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User-visible title for this hilite.  Used for interfaces such as menus that can enable or disable hilites.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
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

}


