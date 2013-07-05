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
 
package com.smartgwt.client.widgets.form;


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
 * The DynamicForm manages a collection of FormItems which represent user input controls.  The
 *  DynamicForm provides {@link com.smartgwt.client.docs.FormLayout layout}, value management, validation and
 *  databinding for the controls it manages.
 *  <P>
 *  
 *  To create a DynamicForm, create several {@link com.smartgwt.client.widgets.form.fields.FormItem}s and pass them to
 *  {@link com.smartgwt.client.widgets.form.DynamicForm#getSetItems setItems}.  For example:
 *  <pre>
 *     DynamicForm form = new DynamicForm();
 *     TextItem textItem = new TextItem("userName");
 *     SelectItem selectItem = new SelectItem("usState");
 *     form.setItems(textItem, selectItem);
 *  </pre>
 *  
 *  
 *  The item <code>name</code> is an identifier for the item that must be unique just within
 *  this form.  It is used:
 *  <ul>
 *  <li> as the name under which the item's value is stored in the form (the form's
 *       current values are accessible as {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}
 *  <li> when retrieving the FormItem's current value (via
 *       {@link com.smartgwt.client.widgets.form.DynamicForm#getValue form.getValue()}) 
 *  <li> to retrieve the item itself via {@link com.smartgwt.client.widgets.form.DynamicForm#getItem form.getItem()}
 *  </ul>
 *  FormItems can also be created by binding the form to a DataSource via
 *  <code>setDataSource()</code>.  In this case, FormItems are
 *  chosen based on the data type of the field - see {@link com.smartgwt.client.types.FormItemType}.  You can override
 *  the automatically chosen FormItem via {@link com.smartgwt.client.data.DataSourceField#getEditorType editorType}.  
 *  <P>
 *  When using DataSource binding, you can also add additional FormItems not specified in the
 *  DataSource, or override any properties on the automatically generated FormItems, without
 *  having to re-declare any information that comes from the DataSource.  See the QuickStart
 *  Guide chapter on Data Binding for an overview.
 *  <P>
 *  All FormItems share a common set of properties for controlling {@link com.smartgwt.client.docs.FormLayout form
 * layout}.  Other properties common to all FormItems are documented on the {@link
 * com.smartgwt.client.widgets.form.fields.FormItem}
 *  class, and properties specific to particular FormItems are documented on the respective
 *  FormItems.  
 *  <P>
 *  NOTE: For very simple forms consisting of exactly one item, you still use a DynamicForm.
 * See the "fontSelector" form in the <a href="http://www.smartclient.com/smartgwt/showcase/#toolstrip"
 * target="examples">Toolstrip example</a>.
 */
public class DynamicForm extends Canvas  implements DataBoundComponent, com.smartgwt.client.widgets.form.events.HasFormSubmitFailedHandlers, com.smartgwt.client.widgets.form.events.HasAsyncValidationReplyHandlers, com.smartgwt.client.widgets.form.events.HasHiddenValidationErrorsHandlers, com.smartgwt.client.widgets.form.events.HasItemChangeHandlers, com.smartgwt.client.widgets.form.events.HasItemChangedHandlers, com.smartgwt.client.widgets.form.events.HasItemKeyPressHandlers, com.smartgwt.client.widgets.form.events.HasSubmitValuesHandlers {

    public native static DynamicForm getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("DynamicForm",jsObj);
        } else {
            return instance;
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
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
        $wnd.isc["DynamicForm"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["DynamicForm"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public DynamicForm(){
        scClassName = "DynamicForm";
    }

    public DynamicForm(JavaScriptObject jsObj){
        scClassName = "DynamicForm";
        setJavaScriptObject(jsObj);
        
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************


    /**
     * The URL to which the form will submit its values. <p> <b>NOTE:</b> this is used only in the very rare case that a form
     * is used to submit data directly to a URL.  Normal server contact is through RPCManager.<br> See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit canSubmit} for more on this.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action} for this form.
     *
     * @param action New action URL. See {@link com.smartgwt.client.docs.String String}. Default value is "#"
     * @see com.smartgwt.client.rpc.RPCManager
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setAction(String action) {
        setAttribute("action", action, true);
    }

    /**
     * The URL to which the form will submit its values. <p> <b>NOTE:</b> this is used only in the very rare case that a form
     * is used to submit data directly to a URL.  Normal server contact is through RPCManager.<br> See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit canSubmit} for more on this.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.rpc.RPCManager
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public String getAction()  {
        return getAttributeAsString("action");
    }


    /**
     * For a form that produces filter criteria (see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}), allows the user to enter simple expressions in any field in this form that takes text
     * input. <P> See {@link com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions allowExpressions} for
     * details.
     *
     * @param allowExpressions allowExpressions Default value is null
     */
    public void setAllowExpressions(Boolean allowExpressions) {
        setAttribute("allowExpressions", allowExpressions, true);
    }

    /**
     * For a form that produces filter criteria (see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}), allows the user to enter simple expressions in any field in this form that takes text
     * input. <P> See {@link com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions allowExpressions} for
     * details.
     *
     * @return Boolean
     */
    public Boolean getAllowExpressions()  {
        return getAttributeAsBoolean("allowExpressions");
    }




    /**
     * If true, when the form is drawn, focus will automatically be put into the first focusable element in the form.<br> Note
     * that to put focus in a different item you can explicitly call  <code>dynamicForm.focusInItem(<i>itemName</i>)</code>
     *
     * @param autoFocus autoFocus Default value is false
     * @see com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setAutoFocus(Boolean autoFocus) {
        setAttribute("autoFocus", autoFocus, true);
    }

    /**
     * If true, when the form is drawn, focus will automatically be put into the first focusable element in the form.<br> Note
     * that to put focus in a different item you can explicitly call  <code>dynamicForm.focusInItem(<i>itemName</i>)</code>
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getAutoFocus()  {
        return getAttributeAsBoolean("autoFocus");
    }


    /**
     * If this browser has a 'spellCheck' feature for text-based form item elements, should it be used for items in this form?
     * Can be overridden at the item level via  {@link com.smartgwt.client.widgets.form.fields.FormItem#getBrowserSpellCheck
     * browserSpellCheck} <P> Notes:<br> - this property only applies to text based items such as TextItem and
     * TextAreaItem.<br> - this property is not supported on all browsers.
     *
     * @param browserSpellCheck browserSpellCheck Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setBrowserSpellCheck
     */
    public void setBrowserSpellCheck(Boolean browserSpellCheck) {
        setAttribute("browserSpellCheck", browserSpellCheck, true);
    }

    /**
     * If this browser has a 'spellCheck' feature for text-based form item elements, should it be used for items in this form?
     * Can be overridden at the item level via  {@link com.smartgwt.client.widgets.form.fields.FormItem#getBrowserSpellCheck
     * browserSpellCheck} <P> Notes:<br> - this property only applies to text based items such as TextItem and
     * TextAreaItem.<br> - this property is not supported on all browsers.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getBrowserSpellCheck
     */
    public Boolean getBrowserSpellCheck()  {
        return getAttributeAsBoolean("browserSpellCheck");
    }


    /**
     * The name of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * DynamicForm.cancel}
     *
     * @param cancelParamName . See {@link com.smartgwt.client.docs.String String}. Default value is "org.apache.struts.taglib.html.CANCEL"
     */
    public void setCancelParamName(String cancelParamName) {
        setAttribute("cancelParamName", cancelParamName, true);
    }

    /**
     * The name of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * DynamicForm.cancel}
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCancelParamName()  {
        return getAttributeAsString("cancelParamName");
    }


    /**
     * The value of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * DynamicForm.cancel}
     *
     * @param cancelParamValue . See {@link com.smartgwt.client.docs.String String}. Default value is "cancel"
     */
    public void setCancelParamValue(String cancelParamValue) {
        setAttribute("cancelParamValue", cancelParamValue, true);
    }

    /**
     * The value of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * DynamicForm.cancel}
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCancelParamValue()  {
        return getAttributeAsString("cancelParamValue");
    }


    /**
     * If set to false, the form will be marked read-only. A widget on the form is editable if either (1) beginning with the
     * widget and continuing up the containment hierarchy, including the form, the first widget to have a non-<code>null</code>
     * canEdit attribute has canEdit:true, or (2) neither the widget nor any parent has a non-<code>null</code> canEdit
     * attribute. This setting allows you to enable or disable the default editability of the form's components at one time.
     * <P> This setting differs from the enabled/disabled state in that most form items will allow copying of the contents
     * while read-only but do not while disabled. <P> Note that a form is considered editable if canEdit is null (default) or
     * <code>true</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Is this form editable or read-only? Setting the form to non-editable causes all form items to render as read-only unless a form item is specifically marked as editable (the item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} attribute is <code>true</code>).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEdit Can this form be edited?. Default value is null
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit, true);
    }

    /**
     * If set to false, the form will be marked read-only. A widget on the form is editable if either (1) beginning with the
     * widget and continuing up the containment hierarchy, including the form, the first widget to have a non-<code>null</code>
     * canEdit attribute has canEdit:true, or (2) neither the widget nor any parent has a non-<code>null</code> canEdit
     * attribute. This setting allows you to enable or disable the default editability of the form's components at one time.
     * <P> This setting differs from the enabled/disabled state in that most form items will allow copying of the contents
     * while read-only but do not while disabled. <P> Note that a form is considered editable if canEdit is null (default) or
     * <code>true</code>.
     *
     * @return Boolean
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }


    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields} array, that property will be
     * respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}). Also note that individual dataBoundComponents may
     * have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell} may be overridden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEditFieldAttribute . See {@link com.smartgwt.client.docs.String String}. Default value is "canEdit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanEditFieldAttribute(String canEditFieldAttribute)  throws IllegalStateException {
        setAttribute("canEditFieldAttribute", canEditFieldAttribute, false);
    }

    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields} array, that property will be
     * respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}). Also note that individual dataBoundComponents may
     * have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell} may be overridden.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCanEditFieldAttribute()  {
        return getAttributeAsString("canEditFieldAttribute");
    }


    /**
     * DynamicForms are considered to have focus if any of their form items have focus. Note that setting
     * <code>dynamicForm.canFocus</code> to false will have no effect on whether form items within the form may receive focus.
     * This property will only govern whether the form may receive focus if the form contains no focusable items.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canFocus canFocus Default value is true
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setCanFocus(Boolean canFocus) {
        setAttribute("canFocus", canFocus, true);
    }

    /**
     * DynamicForms are considered to have focus if any of their form items have focus. Note that setting
     * <code>dynamicForm.canFocus</code> to false will have no effect on whether form items within the form may receive focus.
     * This property will only govern whether the form may receive focus if the form contains no focusable items.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus");
    }


    /**
     * Governs whether this form will be used to perform a standard HTML form submission. Note that if true, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit} will perform a native HTML submission to the
     * specified {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action} URL.<br> Wherever possible we strongly
     * recommend using the  {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods} to send data
     * to the server as they provide a far more sophisticated interface, with built in  options for server validation, required
     * fields, etc.<br>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canSubmit canSubmit Default value is false
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setCanSubmit(Boolean canSubmit) {
        setAttribute("canSubmit", canSubmit, true);
    }

    /**
     * Governs whether this form will be used to perform a standard HTML form submission. Note that if true, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit} will perform a native HTML submission to the
     * specified {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action} URL.<br> Wherever possible we strongly
     * recommend using the  {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods} to send data
     * to the server as they provide a far more sophisticated interface, with built in  options for server validation, required
     * fields, etc.<br>
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public Boolean getCanSubmit()  {
        return getAttributeAsBoolean("canSubmit");
    }


    /**
     * If true, the headers for any {@link com.smartgwt.client.widgets.form.DynamicForm#getSectionItems SectionItems} will be
     * included in the page's tab order for accessibility. May also be set at the item level via {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#getCanTabToHeader canTabToHeader} <P> If unset, section headers will
     * be focusable if  setScreenReaderMode has been called. See {@link com.smartgwt.client.docs.Accessibility}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToSectionHeaders canTabToSectionHeaders Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanTabToSectionHeaders(Boolean canTabToSectionHeaders)  throws IllegalStateException {
        setAttribute("canTabToSectionHeaders", canTabToSectionHeaders, false);
    }

    /**
     * If true, the headers for any {@link com.smartgwt.client.widgets.form.DynamicForm#getSectionItems SectionItems} will be
     * included in the page's tab order for accessibility. May also be set at the item level via {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#getCanTabToHeader canTabToHeader} <P> If unset, section headers will
     * be focusable if  setScreenReaderMode has been called. See {@link com.smartgwt.client.docs.Accessibility}.
     *
     * @return Boolean
     */
    public Boolean getCanTabToSectionHeaders()  {
        return getAttributeAsBoolean("canTabToSectionHeaders");
    }


    /**
     * Width of border for the table that form is drawn in. This is primarily used for debugging form layout.
     *
     * @param cellBorder cellBorder Default value is 0
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setCellBorder(int cellBorder) {
        setAttribute("cellBorder", cellBorder, true);
    }

    /**
     * Width of border for the table that form is drawn in. This is primarily used for debugging form layout.
     *
     * @return int
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getCellBorder()  {
        return getAttributeAsInt("cellBorder");
    }


    /**
     * The amount of empty space, in pixels, surrounding each form item within its cell in the layout grid.
     *
     * @param cellPadding cellPadding Default value is 2
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setCellPadding(int cellPadding) {
        setAttribute("cellPadding", cellPadding, true);
    }

    /**
     * The amount of empty space, in pixels, surrounding each form item within its cell in the layout grid.
     *
     * @return int
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getCellPadding()  {
        return getAttributeAsInt("cellPadding");
    }


    /**
     * Should the titles for form items be clipped if they are too large for the available  space? <p> Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getClipTitle clipTitle}.
     *
     * @param clipItemTitles clipItemTitles Default value is false
     */
    public void setClipItemTitles(boolean clipItemTitles) {
        setAttribute("clipItemTitles", clipItemTitles, true);
    }

    /**
     * Should the titles for form items be clipped if they are too large for the available  space? <p> Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getClipTitle clipTitle}.
     *
     * @return boolean
     */
    public boolean getClipItemTitles()  {
        return getAttributeAsBoolean("clipItemTitles");
    }



    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData DynamicForm.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @param dataFetchMode dataFetchMode Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData DynamicForm.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @return FetchMode
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }


    /**
     * Default {@link com.smartgwt.client.types.DateDisplayFormat} for Date type values displayed in this form. <P> If some
     * field's value is set to a native Date object, how should it be displayed to the user? If specified this is the default
     * display format to use, and will apply to all fields except those specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type:"time"}  (See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter timeFormatter}). <P> May be overridden at the component
     * level for fields of type <code>datetime</code> via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter}. <P> Note that if specified, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} take precedence over the format
     * specified at the component level. <P> If no explicit formatter is specified at the field or component level, dates will
     * be  formatted according to the system-wide {@link com.smartgwt.client.util.Date#setShortDisplayFormat short date display
     * format} or  {@link com.smartgwt.client.util.Date#setShortDatetimeDisplayFormat short datetime display format} depending
     * on the specified field type.
     *
     * @param dateFormatter dateFormatter Default value is null
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DateDisplayFormat} for Date type values displayed in this form. <P> If some
     * field's value is set to a native Date object, how should it be displayed to the user? If specified this is the default
     * display format to use, and will apply to all fields except those specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type:"time"}  (See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter timeFormatter}). <P> May be overridden at the component
     * level for fields of type <code>datetime</code> via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter}. <P> Note that if specified, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} take precedence over the format
     * specified at the component level. <P> If no explicit formatter is specified at the field or component level, dates will
     * be  formatted according to the system-wide {@link com.smartgwt.client.util.Date#setShortDisplayFormat short date display
     * format} or  {@link com.smartgwt.client.util.Date#setShortDatetimeDisplayFormat short datetime display format} depending
     * on the specified field type.
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }


    /**
     * Default {@link com.smartgwt.client.types.DateDisplayFormat} for Date type values displayed in this form in fields of
     * type <code>datetime</code>. <P> For datetime fields, this attribute will be used instead of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} when formatting Date values. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} take precedence over the format
     * specified at the component level. <P> If no explicit formatter is specified at the field or component level, datetime
     * field values will be formatted according to the system-wide {@link
     * com.smartgwt.client.util.Date#setShortDatetimeDisplayFormat short datetime display format}.
     *
     * @param datetimeFormatter datetimeFormatter Default value is null
     */
    public void setDatetimeFormatter(DateDisplayFormat datetimeFormatter) {
        setAttribute("datetimeFormatter", datetimeFormatter == null ? null : datetimeFormatter.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DateDisplayFormat} for Date type values displayed in this form in fields of
     * type <code>datetime</code>. <P> For datetime fields, this attribute will be used instead of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} when formatting Date values. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} take precedence over the format
     * specified at the component level. <P> If no explicit formatter is specified at the field or component level, datetime
     * field values will be formatted according to the system-wide {@link
     * com.smartgwt.client.util.Date#setShortDatetimeDisplayFormat short datetime display format}.
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDatetimeFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("datetimeFormatter"));
    }


    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validators (if
     * any) will still run on attempted save.
     *
     * @param disableValidation disableValidation Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setDisableValidation(Boolean disableValidation) {
        setAttribute("disableValidation", disableValidation, true);
    }

    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validators (if
     * any) will still run on attempted save.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getDisableValidation()  {
        return getAttributeAsBoolean("disableValidation");
    }


    /**
     * encoding for the form, use MULTIPART_ENCODING for file upload forms
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param encoding encoding Default value is DynamicForm.NORMAL
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setEncoding(Encoding encoding) {
        setAttribute("encoding", encoding == null ? null : encoding.getValue(), true);
    }

    /**
     * encoding for the form, use MULTIPART_ENCODING for file upload forms
     *
     * @return Encoding
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public Encoding getEncoding()  {
        return EnumUtil.getEnum(Encoding.values(), getAttribute("encoding"));
    }


    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies the cellStyle to apply
     * to this item.
     *
     * @param errorItemCellStyle . See {@link com.smartgwt.client.docs.String String}. Default value is "formCellError"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setErrorItemCellStyle(String errorItemCellStyle)  throws IllegalStateException {
        setAttribute("errorItemCellStyle", errorItemCellStyle, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies the cellStyle to apply
     * to this item.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getErrorItemCellStyle()  {
        return getAttributeAsString("errorItemCellStyle");
    }





    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies an introductory string
     * rendered out before the individual error messages.
     *
     * @param errorsPreamble . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "The following errors were found"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setErrorsPreamble(String errorsPreamble)  throws IllegalStateException {
        setAttribute("errorsPreamble", errorsPreamble, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies an introductory string
     * rendered out before the individual error messages.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getErrorsPreamble()  {
        return getAttributeAsString("errorsPreamble");
    }



    /**
     * If true, we ensure that column widths are at least as large as you specify them.  This means that if any single column
     * overflows (due to, eg, a long unbreakable title), the form as a whole overflows. <P> If false, columns will have their
     * specified sizes as long as no column overflows.  If any column overflows, space will be taken from any other columns
     * that aren't filling the available room, until there is no more free space, in which case the form as a whole overflows.
     *
     * @param fixedColWidths fixedColWidths Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setFixedColWidths(Boolean fixedColWidths) {
        setAttribute("fixedColWidths", fixedColWidths, true);
    }

    /**
     * If true, we ensure that column widths are at least as large as you specify them.  This means that if any single column
     * overflows (due to, eg, a long unbreakable title), the form as a whole overflows. <P> If false, columns will have their
     * specified sizes as long as no column overflows.  If any column overflows, space will be taken from any other columns
     * that aren't filling the available room, until there is no more free space, in which case the form as a whole overflows.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getFixedColWidths()  {
        return getAttributeAsBoolean("fixedColWidths");
    }


    /**
     * Warning to display to the user if an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm natively
     * submit} a form is unable to submit to the server. The most common cause for this failure is that the user has typed an
     * invalid file-path into an upload type field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param formSubmitFailedWarning . See {@link com.smartgwt.client.docs.String String}. Default value is "Form was unable to be submitted. The most likely cause for this is an invalid value in an upload field."
     */
    public void setFormSubmitFailedWarning(String formSubmitFailedWarning) {
        setAttribute("formSubmitFailedWarning", formSubmitFailedWarning, true);
    }

    /**
     * Warning to display to the user if an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm natively
     * submit} a form is unable to submit to the server. The most common cause for this failure is that the user has typed an
     * invalid file-path into an upload type field.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFormSubmitFailedWarning()  {
        return getAttributeAsString("formSubmitFailedWarning");
    }


    /**
     * Indicates whether the titles of required items in this form should use the special prefix and suffix specified by the
     * next two properties, instead of the standard prefix and suffix.
     *
     * @param hiliteRequiredFields hiliteRequiredFields Default value is true
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setHiliteRequiredFields(Boolean hiliteRequiredFields) {
        setAttribute("hiliteRequiredFields", hiliteRequiredFields, true);
    }

    /**
     * Indicates whether the titles of required items in this form should use the special prefix and suffix specified by the
     * next two properties, instead of the standard prefix and suffix.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public Boolean getHiliteRequiredFields()  {
        return getAttributeAsBoolean("hiliteRequiredFields");
    }


    /**
     * When true, indicates that changes to items in this form will be automatically saved on a  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveDelay delay}, as well as when the entire form is submitted. 
     * Unless {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveOnBlur form.implicitSaveOnBlur} is set  to
     * false, changes will also be automatically saved on editorExit for each item.  This attribute can also be set directly on
     * FormItems.
     *
     * @param implicitSave implicitSave Default value is false
     */
    public void setImplicitSave(Boolean implicitSave) {
        setAttribute("implicitSave", implicitSave, true);
    }

    /**
     * When true, indicates that changes to items in this form will be automatically saved on a  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveDelay delay}, as well as when the entire form is submitted. 
     * Unless {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveOnBlur form.implicitSaveOnBlur} is set  to
     * false, changes will also be automatically saved on editorExit for each item.  This attribute can also be set directly on
     * FormItems.
     *
     * @return Boolean
     */
    public Boolean getImplicitSave()  {
        return getAttributeAsBoolean("implicitSave");
    }


    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSave implicitSave} is true, this attribute dictates
     * the  millisecond delay after which form items are automatically saved during editing.
     *
     * @param implicitSaveDelay implicitSaveDelay Default value is 2000
     */
    public void setImplicitSaveDelay(int implicitSaveDelay) {
        setAttribute("implicitSaveDelay", implicitSaveDelay, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSave implicitSave} is true, this attribute dictates
     * the  millisecond delay after which form items are automatically saved during editing.
     *
     * @return int
     */
    public int getImplicitSaveDelay()  {
        return getAttributeAsInt("implicitSaveDelay");
    }


    /**
     * If true, form item values will be automatically saved when each item's "editorExit"  handler is fired as well as on a
     * delay and when the entire form is submitted.  This attribute can also be set directly on FormItems.
     *
     * @param implicitSaveOnBlur implicitSaveOnBlur Default value is false
     */
    public void setImplicitSaveOnBlur(Boolean implicitSaveOnBlur) {
        setAttribute("implicitSaveOnBlur", implicitSaveOnBlur, true);
    }

    /**
     * If true, form item values will be automatically saved when each item's "editorExit"  handler is fired as well as on a
     * delay and when the entire form is submitted.  This attribute can also be set directly on FormItems.
     *
     * @return Boolean
     */
    public Boolean getImplicitSaveOnBlur()  {
        return getAttributeAsBoolean("implicitSaveOnBlur");
    }



    /**
     * Text alignment for hovers shown for items
     *
     * @param itemHoverAlign itemHoverAlign Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverAlign
     */
    public void setItemHoverAlign(Alignment itemHoverAlign) {
        setAttribute("itemHoverAlign", itemHoverAlign == null ? null : itemHoverAlign.getValue(), true);
    }

    /**
     * Text alignment for hovers shown for items
     *
     * @return Alignment
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverAlign
     */
    public Alignment getItemHoverAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("itemHoverAlign"));
    }


    /**
     * If the user rolls over an item, how long a delay before we fire any hover action / show a hover for that item?
     *
     * @param itemHoverDelay itemHoverDelay Default value is 500
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverDelay
     */
    public void setItemHoverDelay(int itemHoverDelay) {
        setAttribute("itemHoverDelay", itemHoverDelay, true);
    }

    /**
     * If the user rolls over an item, how long a delay before we fire any hover action / show a hover for that item?
     *
     * @return int
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverDelay
     */
    public int getItemHoverDelay()  {
        return getAttributeAsInt("itemHoverDelay");
    }


    /**
     * A default height for hovers shown for items
     *
     * @param itemHoverHeight itemHoverHeight Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverHeight
     */
    public void setItemHoverHeight(Integer itemHoverHeight) {
        setAttribute("itemHoverHeight", itemHoverHeight, true);
    }

    /**
     * A default height for hovers shown for items
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverHeight
     */
    public Integer getItemHoverHeight()  {
        return getAttributeAsInt("itemHoverHeight");
    }


    /**
     * Opacity for hovers shown for items
     *
     * @param itemHoverOpacity itemHoverOpacity Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverOpacity
     */
    public void setItemHoverOpacity(Integer itemHoverOpacity) {
        setAttribute("itemHoverOpacity", itemHoverOpacity, true);
    }

    /**
     * Opacity for hovers shown for items
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverOpacity
     */
    public Integer getItemHoverOpacity()  {
        return getAttributeAsInt("itemHoverOpacity");
    }


    /**
     * CSS Style for hovers shown for items
     *
     * @param itemHoverStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "formHover"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverStyle
     */
    public void setItemHoverStyle(String itemHoverStyle) {
        setAttribute("itemHoverStyle", itemHoverStyle, true);
    }

    /**
     * CSS Style for hovers shown for items
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverStyle
     */
    public String getItemHoverStyle()  {
        return getAttributeAsString("itemHoverStyle");
    }


    /**
     * Vertical text alignment for hovers shown for items
     *
     * @param itemHoverVAlign itemHoverVAlign Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverVAlign
     */
    public void setItemHoverVAlign(Integer itemHoverVAlign) {
        setAttribute("itemHoverVAlign", itemHoverVAlign, true);
    }

    /**
     * Vertical text alignment for hovers shown for items
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverVAlign
     */
    public Integer getItemHoverVAlign()  {
        return getAttributeAsInt("itemHoverVAlign");
    }


    /**
     * A default width for hovers shown for items
     *
     * @param itemHoverWidth itemHoverWidth Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverWidth
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_hovers" target="examples">Hovers Example</a>
     */
    public void setItemHoverWidth(Integer itemHoverWidth) {
        setAttribute("itemHoverWidth", itemHoverWidth, true);
    }

    /**
     * A default width for hovers shown for items
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverWidth
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_hovers" target="examples">Hovers Example</a>
     */
    public Integer getItemHoverWidth()  {
        return getAttributeAsInt("itemHoverWidth");
    }


    /**
     * Layout style to use with this form.   <P> The default of "table" uses a tabular layout similar to HTML tables, but with
     * much more powerful control over sizing, item visibility and reflow, overflow handling, etc. <P>
     * <code>itemLayout:"absolute"</code> allows absolute positioning of every form item.  This provides maximum flexibility in
     * placement, with the following limitations:<ul> <li> titles, which normally take up an adjacent cell, are not shown.  Use
     * StaticTextItems to show titles <li> no automatic reflow when showing or hiding items.  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setLeft FormItem.setLeft}      and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setTop FormItem.setTop} can be used for manual reflow. <li> only pixel
     * and percent sizes are allowed, no "*".  Percent widths mean percentage      of the overall form size rather than the
     * column size <li> with different font styling or internationalized titles, items may overlap that did      not overlap in
     * the skin used at design time </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param itemLayout itemLayout Default value is "table"
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setItemLayout(FormLayoutType itemLayout) {
        setAttribute("itemLayout", itemLayout == null ? null : itemLayout.getValue(), true);
    }

    /**
     * Layout style to use with this form.   <P> The default of "table" uses a tabular layout similar to HTML tables, but with
     * much more powerful control over sizing, item visibility and reflow, overflow handling, etc. <P>
     * <code>itemLayout:"absolute"</code> allows absolute positioning of every form item.  This provides maximum flexibility in
     * placement, with the following limitations:<ul> <li> titles, which normally take up an adjacent cell, are not shown.  Use
     * StaticTextItems to show titles <li> no automatic reflow when showing or hiding items.  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setLeft FormItem.setLeft}      and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setTop FormItem.setTop} can be used for manual reflow. <li> only pixel
     * and percent sizes are allowed, no "*".  Percent widths mean percentage      of the overall form size rather than the
     * column size <li> with different font styling or internationalized titles, items may overlap that did      not overlap in
     * the skin used at design time </ul>
     *
     * @return FormLayoutType
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public FormLayoutType getItemLayout()  {
        return EnumUtil.getEnum(FormLayoutType.values(), getAttribute("itemLayout"));
    }



    /**
     * When creating form items for fields with text type data, if the specified length of the field exceeds this threshold we
     * will create form item of type  <code>this.longTextEditorType</code> (a TextAreaItem by default), rather than a simple
     * text item.  Overridden by explicitly specifying <code>editorType</code> for the field.
     *
     * @param longTextEditorThreshold longTextEditorThreshold Default value is 255
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setLongTextEditorThreshold(int longTextEditorThreshold) {
        setAttribute("longTextEditorThreshold", longTextEditorThreshold, true);
    }

    /**
     * When creating form items for fields with text type data, if the specified length of the field exceeds this threshold we
     * will create form item of type  <code>this.longTextEditorType</code> (a TextAreaItem by default), rather than a simple
     * text item.  Overridden by explicitly specifying <code>editorType</code> for the field.
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getLongTextEditorThreshold()  {
        return getAttributeAsInt("longTextEditorThreshold");
    }


    /**
     * Name of the Form Item class to use for text fields which exceed the  longTextEditorThreshold for this form.
     *
     * @param longTextEditorType . See {@link com.smartgwt.client.docs.String String}. Default value is "textArea"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setLongTextEditorType(String longTextEditorType) {
        setAttribute("longTextEditorType", longTextEditorType, true);
    }

    /**
     * Name of the Form Item class to use for text fields which exceed the  longTextEditorThreshold for this form.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getLongTextEditorType()  {
        return getAttributeAsString("longTextEditorType");
    }


    /**
     * The mechanism by which form data is sent to the action URL. See FormMethod type for details. <p> <b>NOTE:</b> this is
     * used only in the very rare case that a form is used to submit data directly to a URL.  Normal server contact is through 
     * {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.DynamicForm#getMethod method} for this form.
     *
     * @param method html form submission method (get or post). Default value is DynamicForm.POST
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setMethod(FormMethod method) {
        setAttribute("method", method == null ? null : method.getValue(), true);
    }

    /**
     * The mechanism by which form data is sent to the action URL. See FormMethod type for details. <p> <b>NOTE:</b> this is
     * used only in the very rare case that a form is used to submit data directly to a URL.  Normal server contact is through 
     * {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods}.
     *
     * @return FormMethod
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public FormMethod getMethod()  {
        return EnumUtil.getEnum(FormMethod.values(), getAttribute("method"));
    }


    /**
     * Minimum width of a form column.
     *
     * @param minColWidth minColWidth Default value is 20
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setMinColWidth(int minColWidth) {
        setAttribute("minColWidth", minColWidth, true);
    }

    /**
     * Minimum width of a form column.
     *
     * @return int
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getMinColWidth()  {
        return getAttributeAsInt("minColWidth");
    }




    /**
     * The number of columns of titles and items in this form's layout grid. A title and corresponding item each have their own
     * column, so to display two form elements per row (each having a title and item), you would set this property to 4.
     *
     * @param numCols numCols Default value is 2
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setNumCols(int numCols) {
        setAttribute("numCols", numCols, true);
    }

    /**
     * The number of columns of titles and items in this form's layout grid. A title and corresponding item each have their own
     * column, so to display two form elements per row (each having a title and item), you would set this property to 4.
     *
     * @return int
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getNumCols()  {
        return getAttributeAsInt("numCols");
    }



    /**
     * If validateOnChange is true, and validation fails for an item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rejectInvalidValueOnChange rejectInvalidValueOnChange Default value is null
     */
    public void setRejectInvalidValueOnChange(Boolean rejectInvalidValueOnChange) {
        setAttribute("rejectInvalidValueOnChange", rejectInvalidValueOnChange, true);
    }

    /**
     * If validateOnChange is true, and validation fails for an item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     *
     * @return Boolean
     */
    public Boolean getRejectInvalidValueOnChange()  {
        return getAttributeAsBoolean("rejectInvalidValueOnChange");
    }


    /**
     * The required message for required field errors.
     *
     * @param requiredMessage . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage, true);
    }

    /**
     * The required message for required field errors.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredMessage()  {
        return getAttributeAsString("requiredMessage");
    }


    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     * @param requiredRightTitlePrefix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "<b>:&nbsp;"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredRightTitlePrefix(String requiredRightTitlePrefix) {
        setAttribute("requiredRightTitlePrefix", requiredRightTitlePrefix, true);
    }

    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredRightTitlePrefix()  {
        return getAttributeAsString("requiredRightTitlePrefix");
    }


    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     * @param requiredRightTitleSuffix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "</b>"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredRightTitleSuffix(String requiredRightTitleSuffix) {
        setAttribute("requiredRightTitleSuffix", requiredRightTitleSuffix, true);
    }

    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredRightTitleSuffix()  {
        return getAttributeAsString("requiredRightTitleSuffix");
    }


    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true.
     *
     * @param requiredTitlePrefix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "<b>"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredTitlePrefix(String requiredTitlePrefix) {
        setAttribute("requiredTitlePrefix", requiredTitlePrefix, true);
    }

    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredTitlePrefix()  {
        return getAttributeAsString("requiredTitlePrefix");
    }


    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true.
     *
     * @param requiredTitleSuffix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "&nbsp;:</b>"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredTitleSuffix(String requiredTitleSuffix) {
        setAttribute("requiredTitleSuffix", requiredTitleSuffix, true);
    }

    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredTitleSuffix()  {
        return getAttributeAsString("requiredTitleSuffix");
    }


    /**
     * The string prepended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @param rightTitlePrefix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is ":&nbsp;"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRightTitlePrefix(String rightTitlePrefix) {
        setAttribute("rightTitlePrefix", rightTitlePrefix, true);
    }

    /**
     * The string prepended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRightTitlePrefix()  {
        return getAttributeAsString("rightTitlePrefix");
    }


    /**
     * The string appended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @param rightTitleSuffix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is ""
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRightTitleSuffix(String rightTitleSuffix) {
        setAttribute("rightTitleSuffix", rightTitleSuffix, true);
    }

    /**
     * The string appended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRightTitleSuffix()  {
        return getAttributeAsString("rightTitleSuffix");
    }


    /**
     * If <code>true</code>, when the user hits the Enter key while focused in a text-item in this form, we automatically
     * submit the form to the server using the  {@link com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit}
     * method.
     *
     * @param saveOnEnter saveOnEnter Default value is false
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setSaveOnEnter(Boolean saveOnEnter) {
        setAttribute("saveOnEnter", saveOnEnter, true);
    }

    /**
     * If <code>true</code>, when the user hits the Enter key while focused in a text-item in this form, we automatically
     * submit the form to the server using the  {@link com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit}
     * method.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public Boolean getSaveOnEnter()  {
        return getAttributeAsBoolean("saveOnEnter");
    }


    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called. This property is automatically
     * set on a call to {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord}, or may be set directly via 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType DynamicForm.setSaveOperationType}. <P> If
     * <code>saveOperationType</code> is unset, the form will heuristically determine whether an "add" or "update" operation is
     * intended based on whether the primaryKey field is present and editable.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the default {@link com.smartgwt.client.types.DSOperationType} when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called. Note that this property can also be set by calling {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord} or  {@link com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord}
     *
     * @param saveOperationType Operation type to use as a default. Valid values are  <code>"add"</code> or <code>"update"</code>.. Default value is null
     */
    public void setSaveOperationType(DSOperationType saveOperationType) {
        setAttribute("saveOperationType", saveOperationType == null ? null : saveOperationType.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called. This property is automatically
     * set on a call to {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord}, or may be set directly via 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType DynamicForm.setSaveOperationType}. <P> If
     * <code>saveOperationType</code> is unset, the form will heuristically determine whether an "add" or "update" operation is
     * intended based on whether the primaryKey field is present and editable.
     *
     * @return Returns the {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called. Valid options are
     * <code>"add"</code> or <code>"update"</code>. <P> If a {@link com.smartgwt.client.data.DSRequest} configuration object is
     * passed in containing an explicit operationType this will be returned. Otherwise {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType} will be returned. This attribute is
     * automatically set via calls to data binding methods such as {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord}, or it may be set explicitly. <P>
     * If no explicit saveOperationType is specified for this form, the system will  look at the current values for the form.
     * If the form has no value for the {@link com.smartgwt.client.data.DataSource#getPrimaryKeyField primaryKey field}, or
     * that field is editable and has been modified we assume an add operation, otherwise an update. If the form is a member of
     * a {@link com.smartgwt.client.widgets.form.ValuesManager}, the primary key field value will be derived from the
     * valuesManager's values object.
     */
    public DSOperationType getSaveOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("saveOperationType"));
    }


    /**
     * If the form has sections, [implemented as {@link com.smartgwt.client.widgets.form.fields.SectionItem}s], this attribute
     * controls whether multiple sections can be expanded at once.
     *
     * @param sectionVisibilityMode sectionVisibilityMode Default value is "multiple"
     * @see com.smartgwt.client.types.VisibilityMode
     * @see com.smartgwt.client.widgets.form.fields.SectionItem
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setSectionVisibilityMode(VisibilityMode sectionVisibilityMode) {
        setAttribute("sectionVisibilityMode", sectionVisibilityMode == null ? null : sectionVisibilityMode.getValue(), true);
    }

    /**
     * If the form has sections, [implemented as {@link com.smartgwt.client.widgets.form.fields.SectionItem}s], this attribute
     * controls whether multiple sections can be expanded at once.
     *
     * @return VisibilityMode
     * @see com.smartgwt.client.types.VisibilityMode
     * @see com.smartgwt.client.widgets.form.fields.SectionItem
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public VisibilityMode getSectionVisibilityMode()  {
        return EnumUtil.getEnum(VisibilityMode.values(), getAttribute("sectionVisibilityMode"));
    }


    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus - whether programmatically (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * DynamicForm.focusInItem}), or via a mouse click, all text within the item will be selected. <P> If you only want the
     * value to be selected when on programmatic focus or keyboard navigation (this is the native browser behavior), set 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} instead. <P> May be overridden at
     * the form item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnClick selectOnClick}.
     *
     * @param selectOnClick selectOnClick Default value is false
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnClick(Boolean selectOnClick) {
        setAttribute("selectOnClick", selectOnClick, true);
    }

    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus - whether programmatically (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * DynamicForm.focusInItem}), or via a mouse click, all text within the item will be selected. <P> If you only want the
     * value to be selected when on programmatic focus or keyboard navigation (this is the native browser behavior), set 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} instead. <P> May be overridden at
     * the form item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnClick selectOnClick}.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnClick()  {
        return getAttributeAsBoolean("selectOnClick");
    }


    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * DynamicForm.focusInItem}), all text within the item will be selected. <P> Note that this flag affects only programmatic
     * focus.  It's the normal behavior of text fields to select all text if the user navigates into them via keyboard, or if
     * the user navigates via mouse, to place the text insertion point at the mouse click, and Smart GWT preserves these
     * behaviors.  <code>selectOnFocus</code> is only needed for cases like a form within a pop-up dialog that should have the
     * first field selected. <P> If you also want the value to be selected when the user clicks on the field, set  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} instead. <P> If <code>selectOnFocus</code>
     * is false, the selection is not modified on focus - any previous selection within the item will be maintained. <P> May be
     * overridden at the form item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnFocus
     * selectOnFocus}.
     *
     * @param selectOnFocus selectOnFocus Default value is false
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnFocus(Boolean selectOnFocus) {
        setAttribute("selectOnFocus", selectOnFocus, true);
    }

    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * DynamicForm.focusInItem}), all text within the item will be selected. <P> Note that this flag affects only programmatic
     * focus.  It's the normal behavior of text fields to select all text if the user navigates into them via keyboard, or if
     * the user navigates via mouse, to place the text insertion point at the mouse click, and Smart GWT preserves these
     * behaviors.  <code>selectOnFocus</code> is only needed for cases like a form within a pop-up dialog that should have the
     * first field selected. <P> If you also want the value to be selected when the user clicks on the field, set  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} instead. <P> If <code>selectOnFocus</code>
     * is false, the selection is not modified on focus - any previous selection within the item will be maintained. <P> May be
     * overridden at the form item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnFocus
     * selectOnFocus}.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnFocus()  {
        return getAttributeAsBoolean("selectOnFocus");
    }


    /**
     * If set, this <code>DynamicForm</code> will set both  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields showComplexFields} and 
     * <code>showComplexFieldsRecursively</code> on any nested component used for showing/editing a complex field.  Thus any of
     * this form's items that handle complex fields will themselves also show complex fields.  This allows for handling of
     * field structures of any complexity. <p> If set, this value automatically sets {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields showComplexFields} as well.
     *
     * @param showComplexFieldsRecursively showComplexFieldsRecursively Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowComplexFieldsRecursively(Boolean showComplexFieldsRecursively)  throws IllegalStateException {
        setAttribute("showComplexFieldsRecursively", showComplexFieldsRecursively, false);
    }

    /**
     * If set, this <code>DynamicForm</code> will set both  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields showComplexFields} and 
     * <code>showComplexFieldsRecursively</code> on any nested component used for showing/editing a complex field.  Thus any of
     * this form's items that handle complex fields will themselves also show complex fields.  This allows for handling of
     * field structures of any complexity. <p> If set, this value automatically sets {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields showComplexFields} as well.
     *
     * @return Boolean
     */
    public Boolean getShowComplexFieldsRecursively()  {
        return getAttributeAsBoolean("showComplexFieldsRecursively");
    }


    /**
     * For databound forms, whether to show fields marked as detail fields.
     *
     * @param showDetailFields showDetailFields Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * For databound forms, whether to show fields marked as detail fields.
     *
     * @return Boolean
     */
    public Boolean getShowDetailFields()  {
        return getAttributeAsBoolean("showDetailFields");
    }


    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See FormItemBaseStyle for
     * a  discussion for how error styling is calculated.
     *
     * @param showErrorIcons showErrorIcons Default value is true
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setShowErrorIcons(Boolean showErrorIcons) {
        setAttribute("showErrorIcons", showErrorIcons, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See FormItemBaseStyle for
     * a  discussion for how error styling is calculated.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowErrorIcons()  {
        return getAttributeAsBoolean("showErrorIcons");
    }


    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See FormItemBaseStyle for
     * a  discussion for how error styling is calculated.
     *
     * @param showErrorStyle showErrorStyle Default value is true
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setShowErrorStyle(Boolean showErrorStyle) {
        setAttribute("showErrorStyle", showErrorStyle, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See FormItemBaseStyle for
     * a  discussion for how error styling is calculated.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowErrorStyle()  {
        return getAttributeAsBoolean("showErrorStyle");
    }


    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See FormItemBaseStyle for
     * a  discussion for how error styling is calculated.
     *
     * @param showErrorText showErrorText Default value is false
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setShowErrorText(Boolean showErrorText) {
        setAttribute("showErrorText", showErrorText, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See FormItemBaseStyle for
     * a  discussion for how error styling is calculated.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowErrorText()  {
        return getAttributeAsBoolean("showErrorText");
    }


    /**
     * If true, field errors are written into the form next to the item(s) where the errors occurred.  Errors may appear as
     * text or just an icon (via {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}:false).
     * <P> If false, errors are written at the top of the form. <P> To do some other kind of error display, override {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors DynamicForm.showErrors}.
     *
     * @param showInlineErrors showInlineErrors Default value is true
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setShowInlineErrors(Boolean showInlineErrors) {
        setAttribute("showInlineErrors", showInlineErrors, true);
    }

    /**
     * If true, field errors are written into the form next to the item(s) where the errors occurred.  Errors may appear as
     * text or just an icon (via {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}:false).
     * <P> If false, errors are written at the top of the form. <P> To do some other kind of error display, override {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors DynamicForm.showErrors}.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowInlineErrors()  {
        return getAttributeAsBoolean("showInlineErrors");
    }


    /**
     * Indicates whether on validation failure, the error message displayed to the          user should be prepended with the
     * title for the item.
     *
     * @param showTitlesWithErrorMessages showTitlesWithErrorMessages Default value is false
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setShowTitlesWithErrorMessages(Boolean showTitlesWithErrorMessages) {
        setAttribute("showTitlesWithErrorMessages", showTitlesWithErrorMessages, true);
    }

    /**
     * Indicates whether on validation failure, the error message displayed to the          user should be prepended with the
     * title for the item.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowTitlesWithErrorMessages()  {
        return getAttributeAsBoolean("showTitlesWithErrorMessages");
    }


    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> Enabling this property also implies {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is automatically enabled. If there
     * are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     * @param stopOnError stopOnError Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStopOnError(Boolean stopOnError)  throws IllegalStateException {
        setAttribute("stopOnError", stopOnError, false);
    }

    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> Enabling this property also implies {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is automatically enabled. If there
     * are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     * @return Boolean
     */
    public Boolean getStopOnError()  {
        return getAttributeAsBoolean("stopOnError");
    }


    /**
     * When calling {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} on a form or
     * valuesManager, by default if the server returns an error code, any callback passed into saveData() will not be fired. If
     * the error code returned by the server indicates a validation error, it will be displayed to the user by updating the
     * form items to show the error messages, and firing any specified hiddenValidationErrors handler, otherwise the standard
     * RPCManager error handling logic would be invoked. <P> Developers who want to handle errors themselves can override this
     * default by specifying  willHandleError on the DSRequest. In this case the callback passed in  will be fired even if the
     * server returns an error status code. <P> If <code>suppressValidationErrorCallback</code> is set to true, if a save
     * attempt returns a <i>validation</i> error code, the user-specified callback will not be fired <i>even if
     * <code>willHandleError:true</code> was specified on the dsRequest</i>  - though for other error codes, the callback would
     * be fired if willHandle error is  specified on the request. Note that this is the historical behavior for <var
     * class=smartclient>Smart GWT builds 8.0 and earlier</var> <var class=smartgwt>SmartGWT builds 4.0 and earlier</var>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param suppressValidationErrorCallback suppressValidationErrorCallback Default value is false
     */
    public void setSuppressValidationErrorCallback(Boolean suppressValidationErrorCallback) {
        setAttribute("suppressValidationErrorCallback", suppressValidationErrorCallback, true);
    }

    /**
     * When calling {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} on a form or
     * valuesManager, by default if the server returns an error code, any callback passed into saveData() will not be fired. If
     * the error code returned by the server indicates a validation error, it will be displayed to the user by updating the
     * form items to show the error messages, and firing any specified hiddenValidationErrors handler, otherwise the standard
     * RPCManager error handling logic would be invoked. <P> Developers who want to handle errors themselves can override this
     * default by specifying  willHandleError on the DSRequest. In this case the callback passed in  will be fired even if the
     * server returns an error status code. <P> If <code>suppressValidationErrorCallback</code> is set to true, if a save
     * attempt returns a <i>validation</i> error code, the user-specified callback will not be fired <i>even if
     * <code>willHandleError:true</code> was specified on the dsRequest</i>  - though for other error codes, the callback would
     * be fired if willHandle error is  specified on the request. Note that this is the historical behavior for <var
     * class=smartclient>Smart GWT builds 8.0 and earlier</var> <var class=smartgwt>SmartGWT builds 4.0 and earlier</var>
     *
     * @return Boolean
     */
    public Boolean getSuppressValidationErrorCallback()  {
        return getAttributeAsBoolean("suppressValidationErrorCallback");
    }


    /**
     * If enabled, whenever validation is triggered and a request to the server is required, user interactivity will be blocked
     * until the request returns. Can be set for the entire form or individual FormItems. <p> If false, the form will try to
     * avoid blocking user interaction until it is strictly required. That is until the user attempts to use a FormItem whose
     * state could be affected by a server request that has not yet returned.
     *
     * @param synchronousValidation synchronousValidation Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSynchronousValidation(Boolean synchronousValidation)  throws IllegalStateException {
        setAttribute("synchronousValidation", synchronousValidation, false);
    }

    /**
     * If enabled, whenever validation is triggered and a request to the server is required, user interactivity will be blocked
     * until the request returns. Can be set for the entire form or individual FormItems. <p> If false, the form will try to
     * avoid blocking user interaction until it is strictly required. That is until the user attempts to use a FormItem whose
     * state could be affected by a server request that has not yet returned.
     *
     * @return Boolean
     */
    public Boolean getSynchronousValidation()  {
        return getAttributeAsBoolean("synchronousValidation");
    }


    /**
     * The name of a window or frame that will receive the results returned by the form's action. The default null indicates to
     * use the current frame. <p> <b>NOTE:</b> this is used only in the very rare case that a form is used to submit data
     * directly to a URL.  Normal server contact is through {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound
     * Component Methods}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.DynamicForm#getTarget target} for this form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param target New submission target. See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setTarget(String target) {
        setAttribute("target", target, true);
    }

    /**
     * The name of a window or frame that will receive the results returned by the form's action. The default null indicates to
     * use the current frame. <p> <b>NOTE:</b> this is used only in the very rare case that a form is used to submit data
     * directly to a URL.  Normal server contact is through {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound
     * Component Methods}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }


    /**
     * Default {@link com.smartgwt.client.types.TimeDisplayFormat} for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type:"time"} field values displayed in this form. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} take precedence over the format
     * specified at the component level. <P> If no explicit formatter is specified at the field or component level, time values
     * will be  formatted according to the system-wide String. specified field type.
     *
     * @param timeFormatter timeFormatter Default value is null
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.TimeDisplayFormat} for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type:"time"} field values displayed in this form. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} take precedence over the format
     * specified at the component level. <P> If no explicit formatter is specified at the field or component level, time values
     * will be  formatted according to the system-wide String. specified field type.
     *
     * @return TimeDisplayFormat
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }


    /**
     * Default alignment for item titles. If unset default alignment will be derived from {@link
     * com.smartgwt.client.util.Page#isRTL text direction} as described in {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleAlign DynamicForm.getTitleAlign}
     *
     * @param titleAlign titleAlign Default value is null
     */
    public void setTitleAlign(Alignment titleAlign) {
        setAttribute("titleAlign", titleAlign == null ? null : titleAlign.getValue(), true);
    }

    /**
     * Default alignment for item titles. If unset default alignment will be derived from {@link
     * com.smartgwt.client.util.Page#isRTL text direction} as described in {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleAlign DynamicForm.getTitleAlign}
     *
     * @return Get the alignment for the title for some item. Default implementation is as follows: <ul><li>If {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleAlign titleAlign} is specified, it will be respected</li>    
     * <li>Otherwise if {@link com.smartgwt.client.widgets.form.DynamicForm#getTitleAlign this.titleAlign} is set, it will be  
     * respected</li>     <li>Otherwise titles will be aligned according to {@link com.smartgwt.client.util.Page#isRTL text
     * direction},         with this method returning <code>"right"</code> if text direction is LTR,         or
     * <code>"left"</code> if text direction is RTL. </ul>
     */
    public Alignment getTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("titleAlign"));
    }


    /**
     * Default orientation for titles for items in this form.  {@link com.smartgwt.client.types.TitleOrientation} lists valid
     * options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout
     * form layouts}, but titles on top do not.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Modify this form's {@link com.smartgwt.client.types.TitleOrientation} at runtime
     *
     * @param titleOrientation new default item titleOrientation. Default value is "left"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public void setTitleOrientation(TitleOrientation titleOrientation) {
        setAttribute("titleOrientation", titleOrientation == null ? null : titleOrientation.getValue(), true);
    }

    /**
     * Default orientation for titles for items in this form.  {@link com.smartgwt.client.types.TitleOrientation} lists valid
     * options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout
     * form layouts}, but titles on top do not.
     *
     * @return Return the orientation of the title for a specific item or the default title orientation if no item is passed.
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public TitleOrientation getTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("titleOrientation"));
    }


    /**
     * The string prepended to the title of every item in this form.  See also +{requiredTitlePrefix} for fields that are
     * required.
     *
     * @param titlePrefix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is ""
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setTitlePrefix(String titlePrefix) {
        setAttribute("titlePrefix", titlePrefix, true);
    }

    /**
     * The string prepended to the title of every item in this form.  See also +{requiredTitlePrefix} for fields that are
     * required.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getTitlePrefix()  {
        return getAttributeAsString("titlePrefix");
    }


    /**
     * The string appended to the title of every item in this form.  See also +{requiredTitleSuffix} for fields that are
     * required.
     *
     * @param titleSuffix . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "&nbsp;:"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setTitleSuffix(String titleSuffix) {
        setAttribute("titleSuffix", titleSuffix, true);
    }

    /**
     * The string appended to the title of every item in this form.  See also +{requiredTitleSuffix} for fields that are
     * required.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getTitleSuffix()  {
        return getAttributeAsString("titleSuffix");
    }



    /**
     * The error message for a failed validator that does not specify its own errorMessage.
     *
     * @param unknownErrorMessage . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "Invalid value"
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setUnknownErrorMessage(String unknownErrorMessage) {
        setAttribute("unknownErrorMessage", unknownErrorMessage, true);
    }

    /**
     * The error message for a failed validator that does not specify its own errorMessage.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getUnknownErrorMessage()  {
        return getAttributeAsString("unknownErrorMessage");
    }


    /**
     * Associated userTask if current dynamic form used along with workflow.  See {@link
     * com.smartgwt.client.util.workflow.UserTask userTask} for more details.
     *
     * @param userTask userTask Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUserTask(UserTask userTask)  throws IllegalStateException {
        setAttribute("userTask", userTask == null ? null : userTask.getOrCreateJsObj(), false);
    }

    /**
     * Associated userTask if current dynamic form used along with workflow.  See {@link
     * com.smartgwt.client.util.workflow.UserTask userTask} for more details.
     *
     * @return UserTask
     */
    public UserTask getUserTask()  {
        return UserTask.getOrCreateRef(getAttributeAsJavaScriptObject("userTask"));
    }


    /**
     * If true, form fields will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the item level or on each validator to enable
     * finer granularity validation in response to user interaction. If true at the form or field level, validators not
     * explicitly set with <code>validateOnChange:false</code> will be fired on change - displaying errors and rejecting the
     * change on validation failure.
     *
     * @param validateOnChange validateOnChange Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValidateOnChange
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange, true);
    }

    /**
     * If true, form fields will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the item level or on each validator to enable
     * finer granularity validation in response to user interaction. If true at the form or field level, validators not
     * explicitly set with <code>validateOnChange:false</code> will be fired on change - displaying errors and rejecting the
     * change on validation failure.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }


    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <P> Note that this property can also be set at the item level to enable finer granularity
     * validation in response to user interaction - if true at either level, validation will occur on editorExit.
     *
     * @param validateOnExit validateOnExit Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValidateOnExit
     */
    public void setValidateOnExit(Boolean validateOnExit) {
        setAttribute("validateOnExit", validateOnExit, true);
    }

    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <P> Note that this property can also be set at the item level to enable finer granularity
     * validation in response to user interaction - if true at either level, validation will occur on editorExit.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit
     */
    public Boolean getValidateOnExit()  {
        return getAttributeAsBoolean("validateOnExit");
    }


    /**
     * validationURL can be set to do server-side validation against a different URL from where the form will ultimately save,
     * as part of an incremental upgrade strategy for Struts and Struts-like applications.   <P> If set, calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit} causes an RPC to be sent to this URL to perform
     * server-side validation of the form values.  If the validation fails, the validation errors returned by the server are
     * rendered in the form.  If the validation succeeds, the form is submitted to the URL specified by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAction action}. <p> The form values are available on the server as
     * request parameters (just like a normal form submit) and also as the values of a DSRequest sent as an RPC alongside the
     * normal submit. <p> The expected response to this request is a DSResponse sent via the RPC mechanism.  If validation is
     * successful, an empty response with the STATUS_SUCCESS status code is sufficient.  If there are validation errors, the
     * DSResponse should have the status set to  STATUS_VALIDATION_ERROR and the errors should be set on the response via the
     * addError()/setErrorReport() API on DSResponse.  See the javadoc for DSResponse for details. <P> See the Struts examples
     * in <code>[webroot]/examples/struts</code> for usage examples.
     *
     * @param validationURL . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setValidationURL(String validationURL) {
        setAttribute("validationURL", validationURL, true);
    }

    /**
     * validationURL can be set to do server-side validation against a different URL from where the form will ultimately save,
     * as part of an incremental upgrade strategy for Struts and Struts-like applications.   <P> If set, calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit} causes an RPC to be sent to this URL to perform
     * server-side validation of the form values.  If the validation fails, the validation errors returned by the server are
     * rendered in the form.  If the validation succeeds, the form is submitted to the URL specified by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAction action}. <p> The form values are available on the server as
     * request parameters (just like a normal form submit) and also as the values of a DSRequest sent as an RPC alongside the
     * normal submit. <p> The expected response to this request is a DSResponse sent via the RPC mechanism.  If validation is
     * successful, an empty response with the STATUS_SUCCESS status code is sufficient.  If there are validation errors, the
     * DSResponse should have the status set to  STATUS_VALIDATION_ERROR and the errors should be set on the response via the
     * addError()/setErrorReport() API on DSResponse.  See the javadoc for DSResponse for details. <P> See the Struts examples
     * in <code>[webroot]/examples/struts</code> for usage examples.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getValidationURL()  {
        return getAttributeAsString("validationURL");
    }




    /**
     * Whether titles for form items should wrap.  If not specified, titles will wrap by default.  Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getWrapTitle wrapTitle}
     *
     * @param wrapItemTitles wrapItemTitles Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setWrapItemTitles(Boolean wrapItemTitles) {
        setAttribute("wrapItemTitles", wrapItemTitles, true);
    }

    /**
     * Whether titles for form items should wrap.  If not specified, titles will wrap by default.  Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getWrapTitle wrapTitle}
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public Boolean getWrapItemTitles()  {
        return getAttributeAsBoolean("wrapItemTitles");
    }

    // ********************* Methods ***********************
	/**
     * 
     *  This method exists for clean integration with existing server frameworks that have a 'cancel'
     *  feature which typically clears session state associated with the form.  When this method is
     *  called, an RPC is sent to the server with a parameter named
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName cancelParamName} with the value
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue cancelParamValue}.<p>
     * 
     *  Note that no other form data is sent.  By default the current top-level page is replaced with the
     *  reply.  If you wish to ignore the server reply instead, call this method like this:
     *  <pre>
     *  dynamicFormInstance.cancel({ignoreTimeout: true, target: null});
     *  </pre>
     * 
     * @see com.smartgwt.client.widgets.form.DynamicForm#cancelEditing
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public native void cancel() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancel();
    }-*/;
	/**
     * 
     *  This method exists for clean integration with existing server frameworks that have a 'cancel'
     *  feature which typically clears session state associated with the form.  When this method is
     *  called, an RPC is sent to the server with a parameter named
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName cancelParamName} with the value
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue cancelParamValue}.<p>
     * 
     *  Note that no other form data is sent.  By default the current top-level page is replaced with the
     *  reply.  If you wish to ignore the server reply instead, call this method like this:
     *  <pre>
     *  dynamicFormInstance.cancel({ignoreTimeout: true, target: null});
     *  </pre>
     * 
     * @param requestProperties additional properties to set on the RPCRequest                                          that will be issued
     * @see com.smartgwt.client.widgets.form.DynamicForm#cancelEditing
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public native void cancel(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancel(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * If the form or valuesManager has associated userTask workflow task than notify it about cancelling the changes.
     */
    public native void cancelEditing() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelEditing();
    }-*/;
	/**
     * Clears all errors for this DynamicForm.
     * @param show If true, redraw the form to clear any visible error messages.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void clearErrors(boolean show) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearErrors(show == null ? false : show);
    }-*/;
	/**
     * Clear any validation errors on the field passed in.
     * @param fieldName field to clear errors from
     * @param show If true this method will fall through to {@link com.smartgwt.client.widgets.form.DynamicForm#showFieldErrors
     * DynamicForm.showFieldErrors}  to update the display
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void clearFieldErrors(String fieldName, boolean show) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearFieldErrors(fieldName, show == null ? false : show);
    }-*/;
	/**
     * Clears the value for some field via a call to {@link com.smartgwt.client.widgets.form.fields.FormItem#clearValue
     * FormItem.clearValue} if appropriate. If there is no item associated with the field name, the field will just be cleared
     * within our stored set of values.
     * @param fieldName Name of the field being cleared. A DataPath may be used for  clearing details of nested data structures.
     */
    public native void clearValue(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearValue(fieldName);
    }-*/;
	/**
     * Reset to default form values and clear errors
     */
    public native void clearValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearValues();
    }-*/;
	/**
     * Finish editing and store edited values in {@link com.smartgwt.client.util.workflow.Process#getState process state}.
     */
    public native void completeEditing() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.completeEditing();
    }-*/;
    /**
     * Add a formSubmitFailed handler.
     * <p>
     * Method called when an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm natively submit} a form
     * is unable to submit to the server. Default behavior is to display the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getFormSubmitFailedWarning formSubmitFailedWarning} in a warning dialog.
     * The most common cause for this failure is that the user has typed an invalid file-path into an upload type field.
     *
     * @param handler the formSubmitFailed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFormSubmitFailedHandler(com.smartgwt.client.widgets.form.events.FormSubmitFailedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent.getType()) == 0) setupFormSubmitFailedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent.getType());
    }

    private native void setupFormSubmitFailedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var formSubmitFailed = $entry(function(){
            var param = {};

                var event = @com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({formSubmitFailed:  formSubmitFailed              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.formSubmitFailed =  formSubmitFailed             ;
        }
   }-*/;
	/**
     * If the current mouse event occurred over an item in this dynamicForm, returns that item.
     *
     * @return the current event target item
     */
    public native FormItem getEventItem() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventItem();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Return the current focus item for this form. If this form is drawn and has focus, this is the currently focused item. If
     * the form does not have focus or is undrawn this is the item that last had focus, or would have focus if the item were
     * drawn/given focus. Therefore note that this method can validly return an item which doesn't currently have focus. <P>
     * May be null.
     *
     * @return returns the item that has the focus, or null if no item is currently focused
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public native FormItem getFocusItem() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFocusItem();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Return an AdvancedCriteria object based on the current set of values within this form. <p> Similar to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}, except the returned
     * criteria object is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}
     *
     * @return a {@link com.smartgwt.client.data.AdvancedCriteria} based on the form's current values
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native AdvancedCriteria getValuesAsAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getValuesAsAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Return an AdvancedCriteria object based on the current set of values within this form. <p> Similar to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}, except the returned
     * criteria object is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}
     * @param textMatchStyle If specified the text match style will be used to   generate the appropriate <code>operator</code> for per field
     * criteria.
     *
     * @return a {@link com.smartgwt.client.data.AdvancedCriteria} based on the form's current values
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native AdvancedCriteria getValuesAsAdvancedCriteria(TextMatchStyle textMatchStyle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getValuesAsAdvancedCriteria(textMatchStyle == null ? null : textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    /**
     * Add a asyncValidationReply handler.
     * <p>
     * Notification fired when an asynchronous validation completes.
     *
     * @param handler the asyncValidationReply handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addAsyncValidationReplyHandler(com.smartgwt.client.widgets.form.events.AsyncValidationReplyHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.AsyncValidationReplyEvent.getType()) == 0) setupAsyncValidationReplyEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.AsyncValidationReplyEvent.getType());
    }

    private native void setupAsyncValidationReplyEvent() /*-{
        var obj = null;
        var selfJ = this;
        var handleAsyncValidationReply = $entry(function(){
            var param = {"success" : arguments[0], "errors" : arguments[1]};

                var event = @com.smartgwt.client.widgets.form.events.AsyncValidationReplyEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({handleAsyncValidationReply:  handleAsyncValidationReply              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.handleAsyncValidationReply =  handleAsyncValidationReply             ;
        }
   }-*/;
    /**
     * Add a hiddenValidationErrors handler.
     * <p>
     * Method to display validation error messages for fields that are not currently visible  in this form.<br> This will be
     * called when validation fails for<br> - a hidden field in this form<br> - if this form is databound, a datasource field
     * with specified validators, for which we   have no specified form item.<br> Implement this to provide custom validation
     * error handling for these fields.<br> By default hidden validation errors will be logged as warnings in the
     * developerConsole. Call {@link com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent#cancel()} from within
     * {@link HiddenValidationErrorsHandler#onHiddenValidationErrors} from this method to suppress that behavior.
     *
     * @param handler the hiddenValidationErrors handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addHiddenValidationErrorsHandler(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType()) == 0) setupHiddenValidationErrorsEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType());
    }

    private native void setupHiddenValidationErrorsEvent() /*-{
        var obj = null;
        var selfJ = this;
        var handleHiddenValidationErrors = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({handleHiddenValidationErrors: 
                function () {
                    var param = {"errors" : arguments[0]};
                    return handleHiddenValidationErrors(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.handleHiddenValidationErrors = 
                function () {
                    var param = {"errors" : arguments[0]};
                    return handleHiddenValidationErrors(param) == true;
                }
            ;
        }
   }-*/;
	/**
     * Return whether this form currently has any validation errors.<br> Validation errors are set up automatically by
     * validation, or may be explicitly set via {@link com.smartgwt.client.widgets.form.DynamicForm#setErrors
     * DynamicForm.setErrors} or {@link com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors
     * DynamicForm.setFieldErrors}.
     *
     * @return true == form currently has validation errors.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native Boolean hasErrors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hasErrors();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Does this form currently h ave any validation errors on the field passed in?<br> Validation errors are set up
     * automatically by validation, or may be explicitly set via {@link com.smartgwt.client.widgets.form.DynamicForm#setErrors
     * DynamicForm.setErrors} or {@link com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors
     * DynamicForm.setFieldErrors}.
     * @param fieldName field to test for validation errors
     *
     * @return true if the form has outstanding errors for the field in question.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native Boolean hasFieldErrors(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hasFieldErrors(fieldName);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Hide a form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#hide FormItem.hide}
     * @param itemName Name of the item to show
     */
    public native void hideItem(String itemName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideItem(itemName);
    }-*/;
	/**
     * Returns true if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType} is currently
     * "add".  See {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType}.
     *
     * @return whether this form will use an "add" operation when saving
     */
    public native Boolean isNewRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isNewRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Is this component waiting for an asynchronous validation to complete? This method will return true after {@link
     * com.smartgwt.client.widgets.form.DynamicForm#validate DynamicForm.validate} is called on a component with server-side
     * validators for some field(s), until the server responds. <P> Note that the notification method {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHandleAsyncValidationReplyHandler
     * DynamicForm.handleAsyncValidationReply} will be fired when validation completes.
     *
     * @return true if this widget has pending asynchronous validations in process
     */
    public native Boolean isPendingAsyncValidation() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isPendingAsyncValidation();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
    /**
     * Add a itemChange handler.
     * <p>
     * Handler fired when there is a change() event fired on a FormItem within this form. <P> Fires after the change() handler
     * on the FormItem itself, and only if the item did not cancel the change event and chooses to allow it to propagate to the
     * form as a whole.
     *
     * @param handler the itemChange handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemChangeHandler(com.smartgwt.client.widgets.form.events.ItemChangeHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ItemChangeEvent.getType()) == 0) setupItemChangeEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ItemChangeEvent.getType());
    }

    private native void setupItemChangeEvent() /*-{
        var obj = null;
        var selfJ = this;
        var itemChange = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.form.events.ItemChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemChange: 
                function () {
                    var param = {"item" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2]};
                    return itemChange(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemChange = 
                function () {
                    var param = {"item" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2]};
                    return itemChange(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a itemChanged handler.
     * <p>
     * Handler fired when there is a changed() event fired on a FormItem within this form. <P> Fires after the change() handler
     * on the FormItem itself, and only if the item did not cancel the change event and chooses to allow it to propagate to the
     * form as a whole.
     *
     * @param handler the itemChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemChangedHandler(com.smartgwt.client.widgets.form.events.ItemChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ItemChangedEvent.getType()) == 0) setupItemChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ItemChangedEvent.getType());
    }

    private native void setupItemChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var itemChanged = $entry(function(){
            var param = {"item" : arguments[0], "newValue" : arguments[1]};

                var event = @com.smartgwt.client.widgets.form.events.ItemChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemChanged:  itemChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemChanged =  itemChanged             ;
        }
   }-*/;
    /**
     * Add a itemKeyPress handler.
     * <p>
     * Handler fired when a FormItem within this form receives a keypress event. <P> Fires after the keyPress handler on the
     * FormItem itself, and only if the item did not cancel the event and chooses to allow it to propagate to the form as a
     * whole.
     *
     * @param handler the itemKeyPress handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemKeyPressHandler(com.smartgwt.client.widgets.form.events.ItemKeyPressHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ItemKeyPressEvent.getType()) == 0) setupItemKeyPressEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ItemKeyPressEvent.getType());
    }

    private native void setupItemKeyPressEvent() /*-{
        var obj = null;
        var selfJ = this;
        var itemKeyPress = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.form.events.ItemKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemKeyPress: 
                function () {
                    var param = {"item" : arguments[0], "keyName" : arguments[1], "characterValue" : arguments[2]};
                    return itemKeyPress(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemKeyPress = 
                function () {
                    var param = {"item" : arguments[0], "keyName" : arguments[1], "characterValue" : arguments[2]};
                    return itemKeyPress(param) == true;
                }
            ;
        }
   }-*/;
	/**
     * Resets values to the state it was the last time <code>setValues()</code> or <code>rememberValues()</code> was called. If
     * neither of those methods has been called, values will be set back to their initial values at init time.
     */
    public native void reset() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reset();
    }-*/;
	/**
     * Same as {@link com.smartgwt.client.widgets.form.DynamicForm#reset DynamicForm.reset}.
     */
    public native void resetValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resetValues();
    }-*/;
	/**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is bound
     * to. <p> If client-side validators are defined, they are executed first, and if any errors are found the save is aborted
     * and the form will show the errors. <p> If client-side validation passes, a {@link com.smartgwt.client.data.DSRequest}
     * will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData DataSource.addData} or {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData} had been called with 
     * ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','the form's values')} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType operationType} will be either "update" or "add", depending on the
     * current {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType}. <P> On either a
     * client-side or server-side validation failure, validation errors will be displayed in the form.  Visible items within a
     * DynamicForm will be redrawn to display errors. Validation failure occurring on hidden items, or DataSource fields with
     * no  associated form items may be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHandleHiddenValidationErrorsHandler
     * DynamicForm.handleHiddenValidationErrors} or {@link
     * com.smartgwt.client.widgets.form.ValuesManager#addHandleHiddenValidationErrorsHandler
     * ValuesManager.handleHiddenValidationErrors}. <P> In the case of a validation error, the callback will <b>not</b> be
     * called by default since the form has already handled the failed save by displaying the validation errors to the user. 
     * If you need to do something additional in this case, you can set {@link
     * com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError} via the <code>requestProperties</code> parameter
     * to force your callback to be invoked.  However, first consider: <ul> <li> if you are trying to customize display of
     * validation errors, there are several {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons built-in
     * modes} and {@link com.smartgwt.client.widgets.form.DynamicForm#showErrors DynamicForm.showErrors} may be a better place
     * to put customizations. <li> for unrecoverable general errors (eg server is down), {@link
     * com.smartgwt.client.rpc.RPCManager#handleError central error handling} in invoked, so consider placing customizations
     * there unless an unrecoverable error should be handled specially by this specific form. </ul>
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_grid_form_category" target="examples">Add Example</a>
     */
    public native void saveData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData();
    }-*/;

	/**
	 * @see {@link DynamicForm#saveData()}
	 */
	public void saveData(DSCallback callback){
		saveData(callback,null);
	}
	/**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is bound
     * to. <p> If client-side validators are defined, they are executed first, and if any errors are found the save is aborted
     * and the form will show the errors. <p> If client-side validation passes, a {@link com.smartgwt.client.data.DSRequest}
     * will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData DataSource.addData} or {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData} had been called with 
     * ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','the form's values')} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType operationType} will be either "update" or "add", depending on the
     * current {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType}. <P> On either a
     * client-side or server-side validation failure, validation errors will be displayed in the form.  Visible items within a
     * DynamicForm will be redrawn to display errors. Validation failure occurring on hidden items, or DataSource fields with
     * no  associated form items may be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHandleHiddenValidationErrorsHandler
     * DynamicForm.handleHiddenValidationErrors} or {@link
     * com.smartgwt.client.widgets.form.ValuesManager#addHandleHiddenValidationErrorsHandler
     * ValuesManager.handleHiddenValidationErrors}. <P> In the case of a validation error, the callback will <b>not</b> be
     * called by default since the form has already handled the failed save by displaying the validation errors to the user. 
     * If you need to do something additional in this case, you can set {@link
     * com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError} via the <code>requestProperties</code> parameter
     * to force your callback to be invoked.  However, first consider: <ul> <li> if you are trying to customize display of
     * validation errors, there are several {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons built-in
     * modes} and {@link com.smartgwt.client.widgets.form.DynamicForm#showErrors DynamicForm.showErrors} may be a better place
     * to put customizations. <li> for unrecoverable general errors (eg server is down), {@link
     * com.smartgwt.client.rpc.RPCManager#handleError central error handling} in invoked, so consider placing customizations
     * there unless an unrecoverable error should be handled specially by this specific form. </ul>
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_grid_form_category" target="examples">Add Example</a>
     */
    public native void saveData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData(
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Sets the value for some field
     * @param fieldName Name of the field being updated. A DataPath may                           be passed to set nested values
     * @param value New value.
     */
    public native void setValue(String fieldName, String value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;
	/**
     * This method will display the specified criteria in this form for editing. The criteria parameter may be a simple {@link
     * com.smartgwt.client.data.Criterion} object or an {@link com.smartgwt.client.data.AdvancedCriteria} object. <P> For
     * simple criteria, the specified fieldName will be used to apply criteria to form items, as with a standard setValues()
     * call. <P> For AdvancedCriteria, behavior is as follows: <ul> <li>If the top level operator doesn't match the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOperator operator} for  this form, the entire criteria will be nested in
     * an outer advanced criteria object with  the appropriate operator.</li> <li>Each criterion within AdvancedCriteria will
     * be applied to a form item if  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue
     * shouldSaveValue} is true for the item and   {@link com.smartgwt.client.widgets.form.fields.FormItem#canEditCriterion
     * FormItem.canEditCriterion} returns true for the criterion in question. By default  this method checks for a match with
     * both the <code>fieldName</code> and <code>operator</code>  of the criterion. The criterion is actually passed to the
     * item for editing via    the <code>FormItemCriterionSetter</code>'s <code>setCriterion()</code> method.  Note that these
     * methods may be overridden for custom  handling. Also note that the default  
     * <code>FormItemCriterionSetter.setCriterion()</code> implementation  used by {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem} handles editing nested criteria via embedded dynamicForms.</li>
     * <li>Criteria which don't map to any form item will be stored directly on the form and  recombined with the edited values
     * from each item when {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * DynamicForm.getValuesAsCriteria} is  called.</li> </ul>
     * @param criteria criteria to edit.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native void setValuesAsCriteria(Criterion criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValuesAsCriteria(criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * If this form has any outstanding validation errors for the field passed in, show them now. Called when field errors are
     * set directly via {@link com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors DynamicForm.setFieldErrors} / 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#addFieldErrors DynamicForm.addFieldErrors} / {@link
     * com.smartgwt.client.widgets.form.DynamicForm#clearFieldErrors DynamicForm.clearFieldErrors}.<br> Default implementation
     * simply falls through to {@link com.smartgwt.client.widgets.form.DynamicForm#showErrors DynamicForm.showErrors}.
     * @param fieldName field to show errors for
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void showFieldErrors(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showFieldErrors(fieldName);
    }-*/;
	/**
     * Show a form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#show FormItem.show}
     * @param itemName Name of the item to show
     */
    public native void showItem(String itemName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showItem(itemName);
    }-*/;
	/**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem} included
     * in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is set,
     * when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If this form is part of a
     * {@link com.smartgwt.client.widgets.form.ValuesManager}, this method will simply fall through to the submit method on the
     * valuesManager. If not, and {@link com.smartgwt.client.widgets.form.DynamicForm#addSubmitValuesHandler
     * form.submitValues()} exists, it will be called, and no further action will be taken. <P> Otherwise, default behavior
     * varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit form.canSubmit}: if
     * <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} will
     * be called to handle saving via Smart GWT databinding.   <P> If <code>canSubmit</code> is true, the form will be
     * submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm
     * DynamicForm.submitForm}. <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling
     * {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData}.  If you override
     * <code>submit()</code>, you can safely ignore the parameters as Smart GWT framework code does not pass them.
     * @see com.smartgwt.client.widgets.form.events.SubmitValuesEvent
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void submit() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submit();
    }-*/;

	/**
	 * @see {@link DynamicForm#submit()}
	 */
	public void submit(DSCallback callback){
		submit(callback,null);
	}
	/**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem} included
     * in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is set,
     * when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If this form is part of a
     * {@link com.smartgwt.client.widgets.form.ValuesManager}, this method will simply fall through to the submit method on the
     * valuesManager. If not, and {@link com.smartgwt.client.widgets.form.DynamicForm#addSubmitValuesHandler
     * form.submitValues()} exists, it will be called, and no further action will be taken. <P> Otherwise, default behavior
     * varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit form.canSubmit}: if
     * <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} will
     * be called to handle saving via Smart GWT databinding.   <P> If <code>canSubmit</code> is true, the form will be
     * submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm
     * DynamicForm.submitForm}. <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling
     * {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData}.  If you override
     * <code>submit()</code>, you can safely ignore the parameters as Smart GWT framework code does not pass them.
     * @param callback callback to invoke on completion.                                          [Ignored if this.canSubmit is true]
     * @param requestProperties additional properties to set on the DSRequest                                          that will be issued              
     *                            [Ignored if this.canSubmit is true]
     * @see com.smartgwt.client.widgets.form.events.SubmitValuesEvent
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void submit(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submit(
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Submits the form to the URL defined by {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action}, 
     * identically to how a plain HTML &lt;form&gt; element would submit data, as either an HTTP GET or POST as specified by
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getMethod method}. <P> <b>Notes:</b> <ul> <li>this is used only in
     * the very rare case that a form is used to submit data directly to a URL.  Normal server contact is through  {@link
     * com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods}.</li> <li>For this method to reliably
     * include values for every field in the grid,       {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit} must be set to <code>true</code></li> <li>To submit values for fields that do not have an editor, use {@link
     * com.smartgwt.client.widgets.form.fields.HiddenItem}  with a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} set.  This is analogous to &lt;input
     * type="hidden"&gt; in HTML forms. </ul>
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public native void submitForm() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submitForm();
    }-*/;
    /**
     * Add a submitValues handler.
     * <p>
     * Triggered when a SubmitItem is included in the form is submitted and gets pressed.
     *
     * @param handler the submitValues handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSubmitValuesHandler(com.smartgwt.client.widgets.form.events.SubmitValuesHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.SubmitValuesEvent.getType()) == 0) setupSubmitValuesEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.SubmitValuesEvent.getType());
    }

    private native void setupSubmitValuesEvent() /*-{
        var obj = null;
        var selfJ = this;
        var submitValues = $entry(function(){
            var param = {"values" : arguments[0], "form" : arguments[1]};

                var event = @com.smartgwt.client.widgets.form.events.SubmitValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({submitValues:  submitValues              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.submitValues =  submitValues             ;
        }
   }-*/;
	/**
     * Is the title for the given form item clipped? The form item must have title clipping enabled.
     * @param item the form item.
     *
     * @return true if the title is clipped; false otherwise.
     * @see com.smartgwt.client.widgets.form.DynamicForm#getClipItemTitles
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getClipTitle
     */
    public native boolean titleClipped(FormItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleClipped(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Validates the form without submitting it, and redraws the form to display error messages if there are any validation
     * errors. Returns true if validation succeeds, or false if validation fails.<br> For databound forms, any Datasource field
     * validators will be run even if there is no  associated item in the form.<br> Validators will also be run on hidden form
     * items<br> In both these cases, validation failure can be handled via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHandleHiddenValidationErrorsHandler
     * DynamicForm.handleHiddenValidationErrors} <P> If this form has any fields which require server-side validation  (see
     * {@link com.smartgwt.client.docs.serverds.Validator#serverCondition serverCondition}) this will also be initialized. Such
     * validation will occur asynchronously.  Developers can use {@link
     * com.smartgwt.client.widgets.form.DynamicForm#isPendingAsyncValidation DynamicForm.isPendingAsyncValidation} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHandleAsyncValidationReplyHandler
     * DynamicForm.handleAsyncValidationReply} to detect and respond to asynchronous validation.
     * @param validateHiddenFields Should validators be processed for non-visible fields         such as dataSource fields with no associated item or
     * fields with visibility set to         <code>"hidden"</code>?
     *
     * @return true if validation succeeds, or false if validation fails.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_type" target="examples">Type Example</a>
     */
    public native boolean validate(boolean validateHiddenFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validate(validateHiddenFields == null ? false : validateHiddenFields);
        return ret;
    }-*/;
	/**
     * Perform validation on the client and the server.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native void validateData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.validateData();
    }-*/;
	/**
     * Compares the current set of values with the values stored by the call to the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#rememberValues DynamicForm.rememberValues} method. 
     * <code>rememberValues()</code> runs when the form is initialized and on every call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues}. Returns true if the values have changed,
     * and false otherwise.
     *
     * @return true if current values do not match remembered values
     * @see com.smartgwt.client.widgets.form.DynamicForm#getChangedValues
     * @see com.smartgwt.client.widgets.form.DynamicForm#getOldValues
     */
    public native Boolean valuesHaveChanged() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.valuesHaveChanged();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

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
     * @param dynamicFormProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DynamicForm dynamicFormProperties) /*-{
    	var properties = $wnd.isc.addProperties({},dynamicFormProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.DynamicForm.addProperties(properties);
    }-*/;

    // ***********************************************************



    private FormItem[] fields;

    protected void onInit() {
    	super.onInit();
    	onInit_DynamicForm();
    }
    protected native void onInit_DynamicForm() /*-{
        this.@com.smartgwt.client.widgets.form.DynamicForm::linkFields()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._showErrors = self.showErrors;
        self.showErrors = $entry(function() {
            var jObj = this.__ref;
            jObj.@com.smartgwt.client.widgets.form.DynamicForm::showErrors()();
        });
    }-*/;


    /**
     * If this form has any outstanding validation errors, show them now.<br>&#010 This method is called when the set of errors are
     * changed by {@link com.smartgwt.client.widgets.form.DynamicForm#setErrors} or&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#validate}.
     * <br>&#010 Default implementation will redraw the form to display error messages and call&#010
     * {@link com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors} to&#010 display errors with no visible field.
     * <p/>
     * <br>
     * <p/>
     * <p><b>Note: This is an override point</b>.&#010 This method may be overridden to perform custom display of validation errors.
     */
    public native void showErrors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._showErrors();
    }-*/;

    private void linkFields() {
        if (fields != null) {
            for (FormItem field : fields) {
                JavaScriptObject fieldJS = getFieldJS(field.getName());
                field.setJsObj(fieldJS);
            }
        }
    }

    private native JavaScriptObject getFieldJS(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldJS = self.getField(fieldName);
        return fieldJS;
    }-*/;

    /**
     * If set at init time, this dynamicForm will be created as a member form for the specified valuesManager.  To
     * update the valuesManager to which a form belongs after init use <code>valuesManager.addMember(form)</code> and
     * <code>valuesManager.removeMember(form)</code> <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param valuesManager valuesManager Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValuesManager(ValuesManager valuesManager) throws IllegalStateException {
        setAttribute("valuesManager", valuesManager.getOrCreateJsObj(), false);
    }

    /**
     * Return the ValuesManager for this form.
     *
     * @return the ValuesManager
     */
    public ValuesManager getValuesManager() {
        return ValuesManager.getOrCreateRef(getAttributeAsJavaScriptObject("valuesManager"));
    }

    /**
     * Set the cellSpacing.
     *
     * @param cellSpacing the cellSpacing
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated use {@link #setCellPadding(int)} instead
     */
    public void setCellSpacing(int cellSpacing) throws IllegalStateException {
        setCellPadding(cellSpacing);
    }

    /**
     * Return the cellSpacing.
     *
     * @return the cellSpacing
     * @deprecated use {@link #getCellPadding()} instead
     */
    public int getCellSpacing() {
        return getCellPadding();
    }

    /**
     * If true, the set of fields given by the "default binding" (see DataBoundComponent.fields) is used, with any
     * fields specified in component.fields acting as overrides that can suppress or modify the display of individual
     * fields, without having to list the entire set of fields that should be shown.
     * <p/>
     * If component.fields contains fields that are not found in the DataSource, they will be shown after the most
     * recently referred to DataSource field. If the new fields appear first, they will be shown first.
     *
     * @param useAllDataSourceFields useAllDataSourceFields
     */
    public void setUseAllDataSourceFields(boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    /**
     * et the values for this DynamicForm. Member forms will be updated as required by this change. Note that pre-existant values in other fields are cleared out by this. .
     *
     * @param values the values
     */
    public void setValues(Map values) {
        setAttribute("values", values, true);
    }

    /**
     * Returns the current set of values where each propertyName is the name of a form item in the form, and each property
     * value is the value held by that form item.
     *
     * @return the values
     */
    public native Map getValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getValues();
        if(value == null) return null;
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Returns all values within this DynamicForm that have changed since  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#rememberValues DynamicForm.rememberValues} last ran. Note that {@link
     * com.smartgwt.client.widgets.form.DynamicForm#rememberValues DynamicForm.rememberValues} runs on dynamicForm
     * initialization, and with every call to {@link com.smartgwt.client.widgets.form.DynamicForm#setValues
     * DynamicForm.setValues} so this will typically contain all values the user has explicitly edited since then.
     *
     * @return the values
     */
    public native Map getChangedValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getChangedValues();
        if(value == null) return null;
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Returns the set of values last stored by {@link com.smartgwt.client.widgets.form.DynamicForm#rememberValues
     * DynamicForm.rememberValues}. Note that <code>rememberValues()</code> is called automatically by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues}, and on form initialization, so this
     * typically contains all values as they were before the user edited them.
     *
     * @return the values
     */
    public native Map getOldValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getOldValues();
        if(value == null) return null;
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, double value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, boolean value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, int[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, Date value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, String[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, Map value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, JavaScriptObject value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, Record value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = value.@com.smartgwt.client.data.Record::getJsObj()();
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, DataClass value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = value.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, Record[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, DataClass[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;


    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public void setValue(String fieldName, RelativeDate value) {
        setValue(fieldName, value.getValue());
    }


    /**
     * Synonym for {@link #setFields(com.smartgwt.client.widgets.form.fields.FormItem[])}.
     *
     * @param items the items
     */
    public void setItems(FormItem... items) {
        setFields(items);
    }


    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} has been set for any {@link
     * com.smartgwt.client.widgets.form.fields.FormItem} in this form, what logical operator should be applied across
     * the ${isc.DocUtils.linkForRef('object:Criterion','criteria')} produced by the form items?  Only applicable to
     * forms that have a {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}.
     *
     * @param operator operator Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperator(OperatorId operator) throws IllegalStateException {
        setAttribute("operator", operator, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} has been set for any {@link
     * com.smartgwt.client.widgets.form.fields.FormItem} in this form, what logical operator should be applied across
     * the ${isc.DocUtils.linkForRef('object:Criterion','criteria')} produced by the form items?  Only applicable to
     * forms that have a {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}.
     *
     * @return OperationId
     */
    public OperatorId getOperator() {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }

    /**
     * An array of field objects, specifying the order, layout, and types of each field in the DynamicForm. When both
     * {@link #setFields fields} and {@link #setDataSource dataSource} are set, {@link #setFields fields} acts as a set
     * of overrides as explained in DataBoundComponent fields.
     * <p/>
     * See Form Layout for information about how flags specified on the FormItems control how the form is laid out.
     *
     * @param fields form item fields
     */
    public void setFields(FormItem... fields) {
        setAttribute("fields", fields, true);
        this.fields = fields;
        if(isCreated()) {
            linkFields();
        }
    }

    /**
     * Return thhe form fields
     *
     * @return the form fields
     */
    public FormItem[] getFields() {
        if(fields == null || getDataSource() != null) {
            return com.smartgwt.client.util.ConvertTo.arrayOfFormItem(getAttributeAsJavaScriptObject("fields"));
        } else {
            return fields;
        }
    }

    public FormItem getItem(String name) {
        return getField(name);
    }

    public FormItem getField(String name) {
        if (fields != null) {
            for (FormItem field : fields) {
                if (name.equals(field.getName())) {
                    return field;
                }
            }
        } else {
            JavaScriptObject fieldJS = getFieldJS(name);

            if(fieldJS!=null && JSOHelper.getAttribute(fieldJS, SC.REF)==null){
                FormItem formItem = new FormItem();
                formItem.setJsObj(fieldJS);

                String type = formItem.getClassName();

                return com.smartgwt.client.util.ObjectFactory.createFormItem(type,fieldJS);
            } else if(fieldJS != null) {
                return FormItemFactory.getFormItem(fieldJS);
            }
        }

        return null;
    }

    public native String getValueAsString(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null || val === undefined ? null : val.toString();
    }-*/;

    public native Object getValue(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null || val === undefined ? null : $wnd.SmartGWT.convertToJavaType(val);
    }-*/;

    /**
     * If the current mouse event occurred over an item, or the title of an item in this dynamicForm, return details about where the event occurred.
     *
     * @param fieldName the field name
     * @return the form item event info
     */
    public native FormItemEventInfo getEventItemInfo(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var val = self.getEventItemInfo(fieldName);
        return val == null || val === undefined ? null : @com.smartgwt.client.widgets.form.FormItemEventInfo::new(Lcom/google/gwt/core/client/JavaScriptObject;)(val);
    }-*/;

    /**
     * Validates the form without submitting it, and redraws the form to display error messages if there are any
     * validation errors. Returns true if validation succeeds, or false if validation fails.<br>
     * For databound forms,
     * any Datasource field validators will be run even if there is no  associated item in the form.<br>
     * Validators will
     * also be run on hidden form items<br>
     * In both these cases, validation failure can be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors}
     * <P>
     * If this form has any fields which require server-side validation
     * this will also be initialized. Such validation will
     * occur asynchronously.<br>
     * Developers can use {@link com.smartgwt.client.widgets.form.DynamicForm#isPendingAsyncValidation()}
     * and
     * {@link com.smartgwt.client.widgets.form.DynamicForm#addAsyncValidationReplyHandler(com.smartgwt.client.widgets.form.events.AsyncValidationReplyHandler)}
     * to detect and respond to asynchronous validation.
     *
     * @return true if validation succeeds, or false if validation fails.
     */
    public native boolean validate() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.validate();
    }-*/;

    /**
     * Prepare to edit a new record by clearing the current set of values (or replacing them with initialValues if specified).
     * Subsequent calls to saveData() will use an add rather than an update operation.
     */
    public native void editNewRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.editNewRecord();
    }-*/;

    /**
     * Prepare to edit a new record by clearing the current set of values (or replacing them with initialValues if specified).
     * Subsequent calls to saveData() will use an add rather than an update operation.
     *
     * @param initialValues initial set of values for the editor as a map of field names to their corresponding values
     */
    public native void editNewRecord(Map initialValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var initialValuesJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(initialValues);
        return self.editNewRecord(initialValuesJS);
    }-*/;

    /**
     * Prepare to edit a new record by clearing the current set of values (or replacing them with initialValues if specified).
     * Subsequent calls to saveData() will use an add rather than an update operation.
     *
     * @param initialValues initial set of values for the editor as a {@link Record} of attributes whose names correspond to form values. 
     */
    public void editNewRecord(Record initialValues) {
        editNewRecord(initialValues.toMap());
    }

    /**
     * Edit the record selected in the specified ListGrid.
     * <br/><br/>
     * Updates the values of this editor to match the selected record's values.
     * <br/><br/>
     * If this form has a dataSource, then saving via {@link com.smartgwt.client.widgets.form.DynamicForm#saveData()}  will use the "update" operation type.
     *
     * @param selectionComponent the List Grid whose currently selected record(s) is/are to be edited
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#update_grid_form_category" target="examples">Grid-Form Update Example</a>
     */
    public native void editSelectedData(ListGrid selectionComponent) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionComponentJS = selectionComponent.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editSelectedData(selectionComponentJS);
    }-*/;

    /**
     * Edit the record selected in the specified ListGrid.
     * <br/><br/>
     * Updates the values of this editor to match the selected record's values.
     * <br/><br/>
     * If this form has a dataSource, then saving via {@link com.smartgwt.client.widgets.form.DynamicForm#saveData()}  will use the "update" operation type.
     *
     * @param listGridID the List Grid ID whose currently selected record(s) is/are to be edited
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#update_grid_form_category" target="examples">Grid-Form Update Example</a>
     */
    public native void editSelectedData(String listGridID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editSelectedData(listGridID);
    }-*/;

    /**
     * Return search criteria based on the current set of values within this form.
     * For simple criteria, each form item simply maps its value to it's fieldName.
     * <br/><br/>
     * See FormItem.getCriterion() for details on how form items generate advanced criteria. Note that any values or criteria
     * specified via DynamicForm.setValues() or DynamicForm.setValuesAsCriteria() which do not correspond to an item within the
     * form will be combined with the live item values when criteria are generated.
     * <br/><br/>
     * The returned criteria object can be used to filter data via methods such as ListGrid.fetchData(), DataSource.fetchData(), or,
     * for more advanced usage, ResultSet.setCriteria().
     * <br/><br/>
     * Note that any form field which the user has left blank is omitted as criteria, that is, a blank field is assumed to mean "allow any value for this field" and not "this field must be blank". Examples of empty values include a blank text field or SelectItem with an empty selection.
     *
     *
     * @return the criteria
     */
    //TODO add support for returning AdvancedCriteria
    public native Criteria getValuesAsCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = self.getValuesAsCriteria();
        if (critJS == null) critJS = @com.smartgwt.client.util.JSOHelper::createObject()();
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;

    /**
     * Return the current set of values within this form as a Record.
     *
     * @return a Record object containing the form's current values
     */
    public Record getValuesAsRecord() {
    	Map values = getValues();
        //if the map contains the actual reference to the underlying record then return it, else
        //build a record from the map values
        Object ref = values.get("__ref");
        if(ref != null && ref instanceof Record) {
            return (Record) ref;
        } else {
    	    return new Record(JSOHelper.convertMapToJavascriptObject(values));
        }
    }


    /**
     * An array of widths for the columns of items in this form's layout grid. <p> If specified, these widths should sum
     * to the total width of the form (form.width). If not specified, we assume every other column will contain form item
     * titles, and so should have <code>form.titleWidth</code>, and all other columns should share the remaining space.
     * <p>
     * Acceptable values for each element in the array are:<br>
     * <ul>
     * <li>A number (e.g. 100) representing the number of pixel widths to allocate to a column.</li>
     * <li>A percent (e.g. 20%) representing the percentage of the total form.width to allocate to a column.</li>
     * <li> &quot;*&quot; (all) to allocate remaining width (form.width minus all specified column widths). Multiple columns
     * can use &quot;*&quot;, in which case remaining width is divided between all columns marked </li>
     * </ul>
     * @param colWidths the column widths
     */
    public void setColWidths(Object... colWidths) {
        setAttribute("colWidths", colWidths, true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called. This property is automatically
     * set on a call to {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord}, or may be set directly via
     * {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType DynamicForm.setSaveOperationType}. <P> If
     * <code>saveOperationType</code> is unset, the form will heuristically determine whether an "add" or "update" operation is
     * intended based on whether the primaryKey field is present and editable.
     *
     *
     * @return Returns the {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called. Valid options are
     * <code>"add"</code> or <code>"update"</code>. <P> If a {@link com.smartgwt.client.data.DSRequest} configuration object is
     * passed in containing an explicit operationType this will be returned. Otherwise {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType} will be returned.
     *
     * @param requestProperties Optional DSRequest config properties for the save operation
     */
    public native DSOperationType getSaveOperationType(DSRequest requestProperties)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.data.DSRequest::getJsObj()();
        var operationTypeJS = self.getSaveOperationType(requestPropertiesJS);
        return @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(@com.smartgwt.client.types.DSOperationType::values()(), operationTypeJS);
    }-*/;

    /**
     * The width in pixels allocated to the title of every item in this form. If you don't specify explicit {@link DynamicForm#setColWidths(Object...) colWidths},
     * you can set this value to the string "*" to divide the usable space evenly between titles and fields.
     *
     * @param titleWidth the title width
     */
    public void setTitleWidth(int titleWidth) {
        setAttribute("titleWidth", titleWidth, true);
    }

    /**
     * The width in pixels allocated to the title of every item in this form. If you don't specify explicit {@link DynamicForm#setColWidths(Object...) colWidths},
     * you can set this value to the string "*" to divide the usable space evenly between titles and fields.
     *
     * @param titleWidth the title width
     */
    public void setTitleWidth(String titleWidth) {
        setAttribute("titleWidth", titleWidth, true);
    }

    /**
     * If DynamicForm.showInlineErrors is true, where should the error icon and text appear relative to form items? Valid options are "top",
     * "bottom", "left" or "right".
     * <p>
     * May be overridden at the item level via {@link FormItem#setErrorOrientation(com.smartgwt.client.types.FormErrorOrientation)}.
     *
     * @param errorOrientation the error orientation
     */
    public void setErrorOrientation(FormErrorOrientation errorOrientation) {
        setAttribute("errorOrientation", errorOrientation, true);
    }

    /**
     * Edit an existing record.  Updates this editors values to match the values of the record  passed in. <P> Subsequent calls to <code>saveData()</code> will use an <code>update</code> rather than an <code>add</code> operation.
     * @param record the record to be edited as a map of field names to their corresponding values
     */
    public native void editRecord(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Move the keyboard focus into a particular item.
     *
     * @param itemNumber the item number
     */
    public native void focusInItem(int itemNumber) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.focusInItem(itemNumber);
    }-*/;

    /**
     * Move the keyboard focus into a particular item.
     *
     * @param itemName the item name
     */
    public native void focusInItem(String itemName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.focusInItem(itemName);
    }-*/;

    /**
     * Move the keyboard focus into a particular item.
     *
     * @param formItem the form item
     */
    public native void focusInItem(FormItem formItem) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var formItemJS = formItem.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.focusInItem(formItemJS);
    }-*/;

    /**
     * Setter for validation errors on this form. Errors passed in should be a Map in the format
     * {fieldName1:errors, fieldName2:errors}
     *
     * Where the errors value may be either a string (single error message) or an array of strings (if multiple errors should be applied to the field in question).

     * @param errors  list of errors as a map with the field names as keys
     * @param showErrors If true redraw form to display errors now. Otherwise errors can be displayed by calling
     *      {@link DynamicForm#showErrors} <b>Note</b>: When the errors are shown, handleHiddenValidationErrors() will be fired for errors
     *      on hidden fields, or with no associated formItem.
     */
    public native void setErrors(Map errors, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(errors);
        return self.setErrors(errorsJS, showErrors);
    }-*/;

    /**
     * Returns the set of errors.
     *
     * @return errors. key is field name, value is error. Returns null if no errors are present
     */
    public native Map getErrors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getErrors();
        if(value == null) return null;
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Set field validation error for some field. The showErrors parameter allows the errors to be displayed immediately.
     * Alternatively, an explicit call to {@link DynamicForm#showFieldErrors} will display the errors for this field.
     *
     * @param fieldName field to apply the new errors to
     * @param error error to apply to the field in question
     * @param showErrors If true this method will fall through to DynamicForm.showFieldErrors() to update the display
     */
    public native void setFieldErrors(String fieldName, String error, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setFieldErrors(fieldName, error, showErrors);
    }-*/;

    /**
     * Set field validation errors for some field. The showErrors parameter allows the errors to be displayed immediately.
     * Alternatively, an explicit call to {@link DynamicForm#showFieldErrors} will display the errors for this field.
     *
     * @param fieldName field to apply the new errors to
     * @param errors errors to apply to the field in question
     * @param showErrors If true this method will fall through to DynamicForm.showFieldErrors() to update the display
     */
    public native void setFieldErrors(String fieldName, String[] errors, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(errors);
        return self.setFieldErrors(fieldName, errorsJS, showErrors);
    }-*/;

    /**
     * Returns any validation errors for some field in this valuesManager. If no errors are present, will return null.
     *
     * @param fieldName the field name
     * @return error messages for the field.
     */
    public native String[] getFieldErrors(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getFieldErrors(fieldName);
        if(value == null) return null;
        if(!@com.smartgwt.client.util.JSOHelper::isArray(Lcom/google/gwt/core/client/JavaScriptObject;)(data)) {
            value = [value];
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;

    /**
     * Make a snapshot of the current set of values, so we can reset to them later. Creates a new object, then adds all
     * non-method properties of values to the new object. Use resetValues() to revert to these values. Note that this
     * method is automatically called when the values for this form are set programmatically via a call to
     * DynamicForm.setValues().
     *
     * @return copy of current form values
     */
    public native JavaScriptObject rememberValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.rememberValues();
    }-*/;

    /**
     * Method to determine whether the current form values would pass validation. This method will run validators on the
     * form's values and return a value indicating whether validation was successful.
     *
     * <p>
     * Unlike DynamicForm.validate() this method will not store the errors on the DynamicForm or display them to the user.
     *
     * @param validateHiddenFields Should validators be processed for non-visible fields such as dataSource fields with no
     * associated item or fields with visibility set to "hidden"?
     * @return boolean value indicating success or failure of validation
     */
    public native boolean valuesAreValid(boolean validateHiddenFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.valuesAreValid(validateHiddenFields);
    }-*/;

   /**
    * The FormItemHoverFormatter should return the HTML to display in a hover canvas when the user holds the mousepointer over this item.
    * Return null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
    */
    public native void setItemHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var formJ = this;
        self.itemHoverHTML = $debox($entry(function(item) {
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        }));
    }-*/;

   /**
    * The <code>FormItemHoverFormatter</code> should return the HTML to display in a hover canvas
    * when the user holds the mousepointer over an item's title and the title is clipped. Return
    * null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
    * @see #titleClipped(com.smartgwt.client.widgets.form.fields.FormItem)
    */
    public native void setItemTitleHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var formJ = this;
        self.titleHoverHTML = $debox($entry(function(item) {
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        }));
    }-*/;

    /**
     * The <code>FormItemHoverFormatter</code> should return the HTML to display in a hover canvas
     * when the user holds the mousepointer over an item's value and the value is clipped. Return
     * null to suppress the hover canvas altogether.
     *
     * @param hoverFormatter the hover formatter
     * @see com.smartgwt.client.widgets.form.fields.FormItem#valueClipped()
     */
    public native void setItemValueHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var formJ = this;
         self.valueHoverHTML = $debox($entry(function(item) {
             var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
             return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
         }));
     }-*/;

    /**
     * Bind to a DataSource.
     * <P>
     * Binding to a DataSource means that the component will use the DataSource to provide default data for
     * its fields.
     * <P>
     * When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     * these will be discarded by default, since it is assumed the new DataSource may represent a completely
     * unrelated set of objects. If the old "fields" are still relevant, pass them to setDataSource().
     * @param dataSource
     * @param fields
     */
    public void setDataSource(DataSource dataSource, FormItem... fields) {
        if (!isCreated()) {
            setFields(fields);
            setDataSource(dataSource);
        } else {
            JavaScriptObject jsFields = null;
            if (fields != null) {
                jsFields = JSOHelper.createJavaScriptArray();
                for (int i = 0; i < fields.length; i++) {
                    JSOHelper.setArrayValue(jsFields, i, fields[i].getJsObj());
                }
            }
            setDataSourceJS(dataSource.getOrCreateJsObj(), jsFields);
        }
    }
    private native void setDataSourceJS(JavaScriptObject dataSource, JavaScriptObject fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDataSource(dataSource, fields);
    }-*/;



    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        return getAttributeAsInt("dataPageSize");
    }

    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public void setShowHiddenFields(Boolean showHiddenFields) {
        setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public void setShowComplexFields(Boolean showComplexFields) {
        setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public void setUpdateOperation(String updateOperation) {
        setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public void setAddOperation(String addOperation) {
        setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public void setRemoveOperation(String removeOperation) {
        setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public void setExportFields(String[] exportFields) {
        setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public void setExportAll(Boolean exportAll) {
        setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public void setAddDropValues(Boolean addDropValues) {
        setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public void setDropValues(Map dropValues) {
        setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    public void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public void setHiliteProperty(String hiliteProperty) {
        setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    /** 
     * Shows a FieldPicker interface allowing end-users to rearrange the order and visibiility
     * of the fields in the associated DataBoundComponent.
     */
    public native void editFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editFields();
    }-*/;

    /**
     * Shows a HiliteEditor interface allowing end-users to edit the data-hilites currently in use by this DataBoundComponent.
     */
    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    /**
     * Get the current hilites encoded as a String, for saving.
     *
     * @return the hilite state
     */
    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    /**
     * Set the current hilites based on a hiliteState String previously returned from getHilitesState.
     *
     * @param hiliteState hilites state encoded as a String
     */
    public native void setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setHiliteState(hiliteState);
    }-*/;

    /**
     * Accepts an array of hilite objects and applies them to this DataBoundComponent. See also {@link #getHilites() getHilites} for a method of
     * retrieving the hilite array for storage, including hilites manually added by the user.
     *
     * @param hilites array of hilite objects
     */
    public native void setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
    }-*/;

    /**
     * Return the set of hilite-objects currently applied to this DataBoundComponent. These can be saved for
     * storage and then restored to a component later via setHilites().
     *
     * @return array of hilite objects
     */
    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public void setCanAddFormulaFields(Boolean canAddFormulaFields) {
        setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public void setAddFormulaFieldText(String addFormulaFieldText) {
        setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public void setEditFormulaFieldText(String editFormulaFieldText) {
        setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public void setCanAddSummaryFields(Boolean canAddSummaryFields) {
        setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public void setAddSummaryFieldText(String addSummaryFieldText) {
        setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public void setEditSummaryFieldText(String editSummaryFieldText) {
        setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************
    /**
     * Filters all objects according to the AdvancedCriteria passed
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.findAll(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;
    
    /**
     * Filters all objects according to the AdvancedCriteria passed and returns the first matching object or null if not found
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return first matching object or null if not found
     */
    public native Record find(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = self.find(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
    
    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.findIndex(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex and endIndex parameters.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * @param endIndex last index to consider
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria, int endIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), null, endIndex);
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex parameter.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null || retVal === undefined) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public void setDataSource(DataSource dataSource) {
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle) throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    public TextMatchStyle getAutoFetchTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("autoFetchTextMatchStyle"));
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

    public ResultSet getResultSet() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            SC.logWarn("getResultSet(): data is not a ResultSet; returning null " +
                "(if grouped, use getOriginalResultSet(); if unbound, use getRecordList(); " +
                "can only be called on DataBoundComponents after initial data has been fetched)");
            return null;
        }
        return new ResultSet(dataJS);
    }

    public RecordList getRecordList() {
        JavaScriptObject dataJS = getDataAsJSList();
        if(dataJS == null) return null;

        if(ResultSet.isResultSet(dataJS)) {
            return getResultSet();
        }
        return new RecordList(dataJS);
    }
    public native JavaScriptObject getDataAsJSList() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
    	if (self == null) return null;
    	return self.getDataAsList();
    	
    }-*/;

    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    public native void exportData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public native void exportClientData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData();
    }-*/;

    public native void exportClientData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Add a fetchData handler.
     * <p>
     * Notification function fired on fetchData() or filterData()
     *
     * @param handler the filterData handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFetchDataHandler(FetchDataHandler handler) {
        if(getHandlerCount(FetchDataEvent.getType()) == 0) setupFetchDataEvent();
        return doAddHandler(handler, FetchDataEvent.getType());
    }

    private native void setupFetchDataEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onFetchData:$debox($entry(function(){
                    var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DropCompleteHandler}.  See that class's documentation for a definition of "drop complete",
     * and how it differs from "drag complete" ({@link com.smartgwt.client.widgets.DragCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDropCompleteHandler(DropCompleteHandler handler) {
        if(getHandlerCount(DropCompleteEvent.getType()) == 0) setupDropCompleteEvent();
        return doAddHandler(handler, DropCompleteEvent.getType());
    }

    private native void setupDropCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dropComplete:$debox($entry(function(){
                    var param = {"transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DragCompleteHandler}.  See that class's documentation for a definition of "drag complete",
     * and how it differs from "drop complete" ({@link com.smartgwt.client.widgets.DropCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragCompleteHandler(DragCompleteHandler handler) {
        if(getHandlerCount(DragCompleteEvent.getType()) == 0) setupDragCompleteEvent();
        return doAddHandler(handler, DragCompleteEvent.getType());
    }

    private native void setupDragCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dragComplete:$debox($entry(function(){
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)();
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)();
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public LogicalStructureObject setLogicalStructure(DynamicFormLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.action = getAttributeAsString("action");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.action:" + t.getMessage() + "\n";
        }
        try {
            s.allowExpressions = getAttributeAsString("allowExpressions");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.allowExpressions:" + t.getMessage() + "\n";
        }
        try {
            s.autoFocus = getAttributeAsString("autoFocus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.autoFocus:" + t.getMessage() + "\n";
        }
        try {
            s.browserSpellCheck = getAttributeAsString("browserSpellCheck");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.browserSpellCheck:" + t.getMessage() + "\n";
        }
        try {
            s.cancelParamName = getAttributeAsString("cancelParamName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.cancelParamName:" + t.getMessage() + "\n";
        }
        try {
            s.cancelParamValue = getAttributeAsString("cancelParamValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.cancelParamValue:" + t.getMessage() + "\n";
        }
        try {
            s.canEdit = getAttributeAsString("canEdit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.canEdit:" + t.getMessage() + "\n";
        }
        try {
            s.canEditFieldAttribute = getAttributeAsString("canEditFieldAttribute");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.canEditFieldAttribute:" + t.getMessage() + "\n";
        }
        try {
            s.canFocus = getAttributeAsString("canFocus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.canFocus:" + t.getMessage() + "\n";
        }
        try {
            s.canSubmit = getAttributeAsString("canSubmit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.canSubmit:" + t.getMessage() + "\n";
        }
        try {
            s.canTabToSectionHeaders = getAttributeAsString("canTabToSectionHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.canTabToSectionHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.cellBorder = getAttributeAsString("cellBorder");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.cellBorder:" + t.getMessage() + "\n";
        }
        try {
            s.cellPadding = getAttributeAsString("cellPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.cellPadding:" + t.getMessage() + "\n";
        }
        try {
            s.clipItemTitles = getAttributeAsString("clipItemTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.clipItemTitles:" + t.getMessage() + "\n";
        }
        try {
            s.colWidths = getAttributeAsString("colWidths");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.colWidths:" + t.getMessage() + "\n";
        }
        try {
            s.dataFetchMode = getAttributeAsString("dataFetchMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.dataFetchMode:" + t.getMessage() + "\n";
        }
        try {
            s.dateFormatter = getAttributeAsString("dateFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.dateFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.datetimeFormatter = getAttributeAsString("datetimeFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.datetimeFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.disableValidation = getAttributeAsString("disableValidation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.disableValidation:" + t.getMessage() + "\n";
        }
        try {
            s.encoding = getAttributeAsString("encoding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.encoding:" + t.getMessage() + "\n";
        }
        try {
            s.errorItemCellStyle = getAttributeAsString("errorItemCellStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.errorItemCellStyle:" + t.getMessage() + "\n";
        }
        try {
            s.errorOrientation = getAttributeAsString("errorOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.errorOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.errors = getAttributeAsString("errors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.errors:" + t.getMessage() + "\n";
        }
        try {
            s.errorsPreamble = getAttributeAsString("errorsPreamble");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.errorsPreamble:" + t.getMessage() + "\n";
        }
        try {
            s.fields = getAttributeAsStringArray("fields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.fieldsArray:" + t.getMessage() + "\n";
        }
        try {
            s.fixedColWidths = getAttributeAsString("fixedColWidths");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.fixedColWidths:" + t.getMessage() + "\n";
        }
        try {
            s.formSubmitFailedWarning = getAttributeAsString("formSubmitFailedWarning");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.formSubmitFailedWarning:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteRequiredFields = getAttributeAsString("hiliteRequiredFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.hiliteRequiredFields:" + t.getMessage() + "\n";
        }
        try {
            s.implicitSave = getAttributeAsString("implicitSave");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.implicitSave:" + t.getMessage() + "\n";
        }
        try {
            s.implicitSaveDelay = getAttributeAsString("implicitSaveDelay");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.implicitSaveDelay:" + t.getMessage() + "\n";
        }
        try {
            s.implicitSaveOnBlur = getAttributeAsString("implicitSaveOnBlur");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.implicitSaveOnBlur:" + t.getMessage() + "\n";
        }
        try {
            s.itemHoverAlign = getAttributeAsString("itemHoverAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemHoverAlign:" + t.getMessage() + "\n";
        }
        try {
            s.itemHoverDelay = getAttributeAsString("itemHoverDelay");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemHoverDelay:" + t.getMessage() + "\n";
        }
        try {
            s.itemHoverHeight = getAttributeAsString("itemHoverHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemHoverHeight:" + t.getMessage() + "\n";
        }
        try {
            s.itemHoverOpacity = getAttributeAsString("itemHoverOpacity");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemHoverOpacity:" + t.getMessage() + "\n";
        }
        try {
            s.itemHoverStyle = getAttributeAsString("itemHoverStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemHoverStyle:" + t.getMessage() + "\n";
        }
        try {
            s.itemHoverVAlign = getAttributeAsString("itemHoverVAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemHoverVAlign:" + t.getMessage() + "\n";
        }
        try {
            s.itemHoverWidth = getAttributeAsString("itemHoverWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemHoverWidth:" + t.getMessage() + "\n";
        }
        try {
            s.itemLayout = getAttributeAsString("itemLayout");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.itemLayout:" + t.getMessage() + "\n";
        }
        try {
            s.longTextEditorThreshold = getAttributeAsString("longTextEditorThreshold");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.longTextEditorThreshold:" + t.getMessage() + "\n";
        }
        try {
            s.longTextEditorType = getAttributeAsString("longTextEditorType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.longTextEditorType:" + t.getMessage() + "\n";
        }
        try {
            s.method = getAttributeAsString("method");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.method:" + t.getMessage() + "\n";
        }
        try {
            s.minColWidth = getAttributeAsString("minColWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.minColWidth:" + t.getMessage() + "\n";
        }
        try {
            s.numCols = getAttributeAsString("numCols");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.numCols:" + t.getMessage() + "\n";
        }
        try {
            s.operator = getAttributeAsString("operator");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.operator:" + t.getMessage() + "\n";
        }
        try {
            s.rejectInvalidValueOnChange = getAttributeAsString("rejectInvalidValueOnChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.rejectInvalidValueOnChange:" + t.getMessage() + "\n";
        }
        try {
            s.requiredMessage = getAttributeAsString("requiredMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.requiredMessage:" + t.getMessage() + "\n";
        }
        try {
            s.requiredRightTitlePrefix = getAttributeAsString("requiredRightTitlePrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.requiredRightTitlePrefix:" + t.getMessage() + "\n";
        }
        try {
            s.requiredRightTitleSuffix = getAttributeAsString("requiredRightTitleSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.requiredRightTitleSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.requiredTitlePrefix = getAttributeAsString("requiredTitlePrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.requiredTitlePrefix:" + t.getMessage() + "\n";
        }
        try {
            s.requiredTitleSuffix = getAttributeAsString("requiredTitleSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.requiredTitleSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.rightTitlePrefix = getAttributeAsString("rightTitlePrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.rightTitlePrefix:" + t.getMessage() + "\n";
        }
        try {
            s.rightTitleSuffix = getAttributeAsString("rightTitleSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.rightTitleSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.saveOnEnter = getAttributeAsString("saveOnEnter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.saveOnEnter:" + t.getMessage() + "\n";
        }
        try {
            s.saveOperationType = getAttributeAsString("saveOperationType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.saveOperationType:" + t.getMessage() + "\n";
        }
        try {
            s.sectionVisibilityMode = getAttributeAsString("sectionVisibilityMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.sectionVisibilityMode:" + t.getMessage() + "\n";
        }
        try {
            s.selectOnClick = getAttributeAsString("selectOnClick");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.selectOnClick:" + t.getMessage() + "\n";
        }
        try {
            s.selectOnFocus = getAttributeAsString("selectOnFocus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.selectOnFocus:" + t.getMessage() + "\n";
        }
        try {
            s.showComplexFieldsRecursively = getAttributeAsString("showComplexFieldsRecursively");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showComplexFieldsRecursively:" + t.getMessage() + "\n";
        }
        try {
            s.showDetailFields = getAttributeAsString("showDetailFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showDetailFields:" + t.getMessage() + "\n";
        }
        try {
            s.showErrorIcons = getAttributeAsString("showErrorIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showErrorIcons:" + t.getMessage() + "\n";
        }
        try {
            s.showErrorStyle = getAttributeAsString("showErrorStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showErrorStyle:" + t.getMessage() + "\n";
        }
        try {
            s.showErrorText = getAttributeAsString("showErrorText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showErrorText:" + t.getMessage() + "\n";
        }
        try {
            s.showInlineErrors = getAttributeAsString("showInlineErrors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showInlineErrors:" + t.getMessage() + "\n";
        }
        try {
            s.showTitlesWithErrorMessages = getAttributeAsString("showTitlesWithErrorMessages");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showTitlesWithErrorMessages:" + t.getMessage() + "\n";
        }
        try {
            s.stopOnError = getAttributeAsString("stopOnError");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.stopOnError:" + t.getMessage() + "\n";
        }
        try {
            s.suppressValidationErrorCallback = getAttributeAsString("suppressValidationErrorCallback");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.suppressValidationErrorCallback:" + t.getMessage() + "\n";
        }
        try {
            s.synchronousValidation = getAttributeAsString("synchronousValidation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.synchronousValidation:" + t.getMessage() + "\n";
        }
        try {
            s.target = getAttributeAsString("target");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.target:" + t.getMessage() + "\n";
        }
        try {
            s.timeFormatter = getAttributeAsString("timeFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.timeFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.titleAlign = getAttributeAsString("titleAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.titleAlign:" + t.getMessage() + "\n";
        }
        try {
            s.titleOrientation = getAttributeAsString("titleOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.titleOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.titlePrefix = getAttributeAsString("titlePrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.titlePrefix:" + t.getMessage() + "\n";
        }
        try {
            s.titleSuffix = getAttributeAsString("titleSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.titleSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.titleWidthAsString = getAttributeAsString("titleWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.titleWidthAsString:" + t.getMessage() + "\n";
        }
        try {
            s.unknownErrorMessage = getAttributeAsString("unknownErrorMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.unknownErrorMessage:" + t.getMessage() + "\n";
        }
        try {
            s.userTask = getUserTask();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.userTask:" + t.getMessage() + "\n";
        }
        try {
            s.validateOnChange = getAttributeAsString("validateOnChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.validateOnChange:" + t.getMessage() + "\n";
        }
        try {
            s.validateOnExit = getAttributeAsString("validateOnExit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.validateOnExit:" + t.getMessage() + "\n";
        }
        try {
            s.validationURL = getAttributeAsString("validationURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.validationURL:" + t.getMessage() + "\n";
        }
        try {
            s.values = getAttributeAsString("values");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.values:" + t.getMessage() + "\n";
        }
        try {
            s.wrapItemTitles = getAttributeAsString("wrapItemTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.wrapItemTitles:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        DynamicFormLogicalStructure s = new DynamicFormLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

