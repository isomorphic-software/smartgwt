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
 
package com.smartgwt.client.data;


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
 * An object representing a user-created and user-modifiable hilite, which can be created and edited with a {@link
 * com.smartgwt.client.widgets.grid.HiliteEditor} either directly or via the {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanEditHilites ListGrid.canEditHilites} behavior. <P> See {@link
 * com.smartgwt.client.docs.Hiliting} for an overview.
 */
@BeanFactory.FrameworkClass
public class Hilite extends RefDataClass {

    public static Hilite getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof Hilite) {
            existingObj.setJsObj(jsObj);
            return (Hilite)existingObj;
        } else

        {
            return new Hilite(jsObj);
        }
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
     * @param backgroundColor New backgroundColor value. Default value is null
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
     * @return Current backgroundColor value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getBackgroundColor()  {
        return getAttributeAsString("backgroundColor");
    }
    

    /**
     * Can highlight be edited from header context menu? Setting attribute to <code>false</code> prevents editing. A
     * <code>null</code> or <code>true</code> value allows editing.
     *
     * @param canEdit New canEdit value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Can highlight be edited from header context menu? Setting attribute to <code>false</code> prevents editing. A
     * <code>null</code> or <code>true</code> value allows editing.
     *
     * @return Current canEdit value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit", true);
    }
    
    

    /**
     * CSS text to be applied to cells where this hilite is applied, for example, "background-color:#FF0000"
     *
     * @param cssText New cssText value. Default value is null
     * @see com.smartgwt.client.docs.CSSText CSSText 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setCssText(String cssText) {
        setAttribute("cssText", cssText);
    }

    /**
     * CSS text to be applied to cells where this hilite is applied, for example, "background-color:#FF0000"
     *
     * @return Current cssText value. Default value is null
     * @see com.smartgwt.client.docs.CSSText CSSText 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getCssText()  {
        return getAttributeAsString("cssText");
    }
    

    /**
     * Whether this hilite is currently disabled. <P> Hilites can be programmatically enabled and disabled via {@link
     * com.smartgwt.client.widgets.DataBoundComponent#enableHilite DataBoundComponent.enableHilite()}.
     *
     * @param disabled New disabled value. Default value is false
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setDisabled(Boolean disabled) {
        setAttribute("disabled", disabled);
    }

    /**
     * Whether this hilite is currently disabled. <P> Hilites can be programmatically enabled and disabled via {@link
     * com.smartgwt.client.widgets.DataBoundComponent#enableHilite DataBoundComponent.enableHilite()}.
     *
     * @return Current disabled value. Default value is false
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Boolean getDisabled()  {
        Boolean result = getAttributeAsBoolean("disabled", true);
        return result == null ? false : result;
    }
    

    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     * @param fieldName New fieldName value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setFieldName(String fieldName) {
        setAttribute("fieldName", fieldName);
    }

    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     * @return Current fieldName value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getFieldName()  {
        return getAttributeAsString("fieldName");
    }

    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     * @param fieldName New fieldName value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setFieldName(String... fieldName) {
        setAttribute("fieldName", fieldName);
    }

    /**
     * Name of the field, or array of fieldNames, this hilite should be applied to.   <P> If unset, hilite is applied to every
     * field of the record.
     *
     * @return Current fieldName value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String[] getFieldNameAsStringArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("fieldName"));
    }
    

    /**
     * HTML to append to the end of cell values where this hilite is applied.
     *
     * @param htmlAfter New htmlAfter value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHtmlAfter(String htmlAfter) {
        setAttribute("htmlAfter", htmlAfter);
    }

    /**
     * HTML to append to the end of cell values where this hilite is applied.
     *
     * @return Current htmlAfter value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getHtmlAfter()  {
        return getAttributeAsString("htmlAfter");
    }
    

    /**
     * HTML to pre-pend to cell values where this hilite is applied.
     *
     * @param htmlBefore New htmlBefore value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHtmlBefore(String htmlBefore) {
        setAttribute("htmlBefore", htmlBefore);
    }

    /**
     * HTML to pre-pend to cell values where this hilite is applied.
     *
     * @return Current htmlBefore value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param htmlValue New htmlValue value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     * @deprecated <code>htmlValue</code> is deprecated in favor of {@link com.smartgwt.client.data.Hilite#getReplacementValue
     * replacementValue}.   Note that unlike <code>replacementValue</code>, this property does not respect  {@link
     * com.smartgwt.client.data.Hilite#getDisabled disabled}, and will be applied even if <code>disabled</code> is set to 
     * <code>true</code>
     */
    public void setHtmlValue(String htmlValue) {
        setAttribute("htmlValue", htmlValue);
    }

    /**
     * Value to show <b>in place of</b> the actual value from the record, for a record that matches this hilite. <P> This can
     * be used to take ranges of numeric values and simplify them to "Low", "Medium", "High" or similar textual values,
     * translate very small or very large values to "Outlier" or "Negligible", and similar use cases.
     *
     * @return Current htmlValue value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     * @deprecated <code>htmlValue</code> is deprecated in favor of {@link com.smartgwt.client.data.Hilite#getReplacementValue
     * replacementValue}.   Note that unlike <code>replacementValue</code>, this property does not respect  {@link
     * com.smartgwt.client.data.Hilite#getDisabled disabled}, and will be applied even if <code>disabled</code> is set to 
     * <code>true</code>
     */
    public String getHtmlValue()  {
        return getAttributeAsString("htmlValue");
    }
    

    /**
     * URL of an icon to show when this hilite is applied to a cell.  Position of the icon  is controlled by {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition DataBoundComponent.hiliteIconPosition} or  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition ListGridField.hiliteIconPosition}.
     *
     * @param icon New icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * URL of an icon to show when this hilite is applied to a cell.  Position of the icon  is controlled by {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition DataBoundComponent.hiliteIconPosition} or  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition ListGridField.hiliteIconPosition}.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * Unique id for this hilite definition.   <P> For hilites that include {@link com.smartgwt.client.data.Hilite#getCriteria
     * criteria} this is not required. <P> If you are explicitly marking records for hiliting, set {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteProperty DataBoundComponent.hiliteProperty} on the record to
     * this id.
     *
     * @param id New id value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setId(String id) {
        setAttribute("id", id);
    }

    /**
     * Unique id for this hilite definition.   <P> For hilites that include {@link com.smartgwt.client.data.Hilite#getCriteria
     * criteria} this is not required. <P> If you are explicitly marking records for hiliting, set {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteProperty DataBoundComponent.hiliteProperty} on the record to
     * this id.
     *
     * @return Current id value. Default value is null
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
     * @param replacementValue New replacementValue value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @return Current replacementValue value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param textColor New textColor value. Default value is null
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
     * @return Current textColor value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String getTextColor()  {
        return getAttributeAsString("textColor");
    }
    

    /**
     * User-visible title for this hilite.  Used for interfaces such as menus that can enable or disable hilites.
     *
     * @param title New title value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User-visible title for this hilite.  Used for interfaces such as menus that can enable or disable hilites.
     *
     * @return Current title value. Default value is null
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
