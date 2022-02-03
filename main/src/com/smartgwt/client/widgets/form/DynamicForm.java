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
 * The DynamicForm manages a collection of FormItems which represent user input controls.  The
 *  DynamicForm provides {@link com.smartgwt.client.docs.FormLayout layout}, value management, validation and
 *  databinding for the controls it manages.
 *  <P>
 *  
 *  To create a DynamicForm, create several {@link com.smartgwt.client.widgets.form.fields.FormItem}s and pass them to
 *  {@link com.smartgwt.client.widgets.form.DynamicForm#setItems setItems()}.  For example:
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
 * the automatically chosen FormItem via {@link com.smartgwt.client.data.DataSourceField#getEditorType
 * DataSourceField.editorType}.  
 *  <P>
 *  FormItem lifecycle is managed by the DynamicForm itself. FormItem instances are created
 *  and destroyed automatically when new fields are added to the form. 
 *  <P>
 *  When using DataSource binding, you can also add additional FormItems not specified in the
 *  DataSource, or override any properties on the automatically generated FormItems, without
 *  having to re-declare any information that comes from the DataSource.  See the QuickStart
 *  Guide chapter on Data Binding for an overview.
 *  <P>
 * All FormItems share a common set of properties for controlling {@link com.smartgwt.client.docs.FormLayout form\n
 * layout}.  Other properties common to all FormItems are documented on the {@link
 * com.smartgwt.client.widgets.form.fields.FormItem}
 *  class, and properties specific to particular FormItems are documented on the respective
 *  FormItems.  
 *  <P>
 *  NOTE: For very simple forms consisting of exactly one item, you still use a DynamicForm.
 * See the "fontSelector" form in the <a href="http://www.smartclient.com/smartgwt/showcase/#toolstrip"
 * target="examples">Toolstrip example</a>.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DynamicForm")
public class DynamicForm extends Canvas implements DataBoundComponent, com.smartgwt.client.widgets.form.events.HasFormSubmitFailedHandlers, com.smartgwt.client.widgets.form.events.HasAsyncValidationReplyHandlers, com.smartgwt.client.widgets.form.events.HasHiddenValidationErrorsHandlers, com.smartgwt.client.widgets.form.events.HasItemChangeHandlers, com.smartgwt.client.widgets.form.events.HasItemChangedHandlers, com.smartgwt.client.widgets.form.events.HasItemKeyPressHandlers, com.smartgwt.client.widgets.form.events.HasSubmitValuesHandlers, com.smartgwt.client.widgets.form.events.HasValuesChangedHandlers {

    public static DynamicForm getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DynamicForm(jsObj);
        } else {
            assert refInstance instanceof DynamicForm;
            return (DynamicForm)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DynamicForm.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DynamicForm.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DynamicForm.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DynamicForm.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
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
     * @param action New action URL. Default value is "#"
     * @see com.smartgwt.client.rpc.RPCManager
     * @see com.smartgwt.client.docs.URL URL 
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
     * @return Current action value. Default value is "#"
     * @see com.smartgwt.client.rpc.RPCManager
     * @see com.smartgwt.client.docs.URL URL 
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public String getAction()  {
        return getAttributeAsString("action");
    }
    

    /**
     * For a form that produces filter criteria (see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}), allows the user to enter simple expressions in any field in this form that takes text
     * input. <P> Also note that enabling <code>allowExpressions</code> for an entire form changes the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDefaultSearchOperator defaultSearchOperator} to {@link
     * com.smartgwt.client.data.DataSource#getTranslatePatternOperators "iContainsPattern"}, so that simple search expressions
     * similar to SQL "LIKE" patterns can be entered in most fields. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions FormItem.allowExpressions} for details.
     *
     * @param allowExpressions New allowExpressions value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setAllowExpressions(Boolean allowExpressions) {
        setAttribute("allowExpressions", allowExpressions, true);
    }

    /**
     * For a form that produces filter criteria (see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}), allows the user to enter simple expressions in any field in this form that takes text
     * input. <P> Also note that enabling <code>allowExpressions</code> for an entire form changes the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDefaultSearchOperator defaultSearchOperator} to {@link
     * com.smartgwt.client.data.DataSource#getTranslatePatternOperators "iContainsPattern"}, so that simple search expressions
     * similar to SQL "LIKE" patterns can be entered in most fields. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions FormItem.allowExpressions} for details.
     *
     * @return Current allowExpressions value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Boolean getAllowExpressions()  {
        return getAttributeAsBoolean("allowExpressions");
    }
    

    /**
     * Should this form allow browser auto-completion of its items' values?      Applies only to items based on native HTML
     * form elements ({@link com.smartgwt.client.widgets.form.fields.TextItem}, {@link
     * com.smartgwt.client.widgets.form.fields.PasswordItem}, etc), and will only have a user-visible impact for browsers where
     * native autoComplete behavior is actually supported and enabled via user settings. <P> This property may be explicitly
     * specified per item via {@link com.smartgwt.client.widgets.form.fields.FormItem#getAutoComplete FormItem.autoComplete}.
     * <P> Note that even with this value set to <code>"none"</code>, native browser  auto-completion may occur for log in
     * forms (forms containing username and  {@link com.smartgwt.client.widgets.form.fields.PasswordItem password} fields).
     * This behavior varies by browser, and is a result of an  <a
     * href='https://www.google.com/search?q=password+ignores+autocomplete+off' target='_blank'>intentional change by some
     * browser developers</a> to disregard the HTML setting <i>autocomplete=off</i> for password items or log-in forms.
     *
     * @param autoComplete New autoComplete value. Default value is "none"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setAutoComplete
     */
    public void setAutoComplete(AutoComplete autoComplete) {
        setAttribute("autoComplete", autoComplete == null ? null : autoComplete.getValue(), true);
    }

    /**
     * Should this form allow browser auto-completion of its items' values?      Applies only to items based on native HTML
     * form elements ({@link com.smartgwt.client.widgets.form.fields.TextItem}, {@link
     * com.smartgwt.client.widgets.form.fields.PasswordItem}, etc), and will only have a user-visible impact for browsers where
     * native autoComplete behavior is actually supported and enabled via user settings. <P> This property may be explicitly
     * specified per item via {@link com.smartgwt.client.widgets.form.fields.FormItem#getAutoComplete FormItem.autoComplete}.
     * <P> Note that even with this value set to <code>"none"</code>, native browser  auto-completion may occur for log in
     * forms (forms containing username and  {@link com.smartgwt.client.widgets.form.fields.PasswordItem password} fields).
     * This behavior varies by browser, and is a result of an  <a
     * href='https://www.google.com/search?q=password+ignores+autocomplete+off' target='_blank'>intentional change by some
     * browser developers</a> to disregard the HTML setting <i>autocomplete=off</i> for password items or log-in forms.
     *
     * @return Current autoComplete value. Default value is "none"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getAutoComplete
     */
    public AutoComplete getAutoComplete()  {
        return EnumUtil.getEnum(AutoComplete.values(), getAttribute("autoComplete"));
    }
    
    
    

    /**
     * If true, when the form is drawn, focus will automatically be put into the first focusable element in the form.<br> Note
     * that to put focus in a different item you can explicitly call  <code>dynamicForm.focusInItem(<i>itemName</i>)</code>
     *
     * @param autoFocus New autoFocus value. Default value is false
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
     * @return Current autoFocus value. Default value is false
     * @see com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getAutoFocus()  {
        Boolean result = getAttributeAsBoolean("autoFocus");
        return result == null ? false : result;
    }
    

    /**
     * If true, when {@link com.smartgwt.client.widgets.form.DynamicForm#validate validation} fails focus will automatically be
     * put into the first focusable field which failed validation.
     *
     * @param autoFocusOnError New autoFocusOnError value. Default value is true
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setAutoFocusOnError(Boolean autoFocusOnError) {
        setAttribute("autoFocusOnError", autoFocusOnError, true);
    }

    /**
     * If true, when {@link com.smartgwt.client.widgets.form.DynamicForm#validate validation} fails focus will automatically be
     * put into the first focusable field which failed validation.
     *
     * @return Current autoFocusOnError value. Default value is true
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getAutoFocusOnError()  {
        Boolean result = getAttributeAsBoolean("autoFocusOnError");
        return result == null ? true : result;
    }
    

    /**
     * If this browser has a 'spellCheck' feature for text-based form item elements, should it be used for items in this form?
     * Can be overridden at the item level via  {@link com.smartgwt.client.widgets.form.fields.FormItem#getBrowserSpellCheck
     * FormItem.browserSpellCheck} <P> Notes:<br> - this property only applies to text based items such as TextItem and
     * TextAreaItem.<br> - this property is not supported on all browsers.
     *
     * @param browserSpellCheck New browserSpellCheck value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setBrowserSpellCheck
     */
    public void setBrowserSpellCheck(Boolean browserSpellCheck) {
        setAttribute("browserSpellCheck", browserSpellCheck, true);
    }

    /**
     * If this browser has a 'spellCheck' feature for text-based form item elements, should it be used for items in this form?
     * Can be overridden at the item level via  {@link com.smartgwt.client.widgets.form.fields.FormItem#getBrowserSpellCheck
     * FormItem.browserSpellCheck} <P> Notes:<br> - this property only applies to text based items such as TextItem and
     * TextAreaItem.<br> - this property is not supported on all browsers.
     *
     * @return Current browserSpellCheck value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getBrowserSpellCheck
     */
    public Boolean getBrowserSpellCheck()  {
        Boolean result = getAttributeAsBoolean("browserSpellCheck");
        return result == null ? true : result;
    }
    

    /**
     * The name of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * cancel()}
     *
     * @param cancelParamName New cancelParamName value. Default value is "org.apache.struts.taglib.html.CANCEL"
     */
    public void setCancelParamName(String cancelParamName) {
        setAttribute("cancelParamName", cancelParamName, true);
    }

    /**
     * The name of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * cancel()}
     *
     * @return Current cancelParamName value. Default value is "org.apache.struts.taglib.html.CANCEL"
     */
    public String getCancelParamName()  {
        return getAttributeAsString("cancelParamName");
    }
    

    /**
     * The value of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * cancel()}
     *
     * @param cancelParamValue New cancelParamValue value. Default value is "cancel"
     */
    public void setCancelParamValue(String cancelParamValue) {
        setAttribute("cancelParamValue", cancelParamValue, true);
    }

    /**
     * The value of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel
     * cancel()}
     *
     * @return Current cancelParamValue value. Default value is "cancel"
     */
    public String getCancelParamValue()  {
        return getAttributeAsString("cancelParamValue");
    }
    

    /**
     * If set to <code>false</code>, the form will be marked read-only. A widget on the form is editable if either (1)
     * beginning with the widget and continuing up the containment hierarchy, including the form, the first widget to have a
     * non-null <code>canEdit</code> attribute has canEdit:true, or (2) neither the widget nor any parent has a non-null
     * <code>canEdit</code> attribute. This setting allows you to enable or disable the default editability of the form's items
     * at one time. <p> This setting differs from the enabled/disabled state in that most form items will allow copying of the
     * contents while read-only but do not while disabled. <p> Note that a form is considered editable if <code>canEdit</code>
     * is null (default) or <code>true</code>. <P>Note that this property may validly be <code>null</code> as a distinct state
     * from <code>false</code>.  See {@link com.smartgwt.client.widgets.form.DynamicForm#fieldIsEditable fieldIsEditable()} for
     * an API that will always return <code>true</code> or <code>false</code> and give a definitive answer as to whether
     * editing is possible.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Is this form editable or read-only? Setting the form to non-editable causes all form items to render as read-only unless a form item is specifically marked as editable (the item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} attribute is <code>true</code>).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEdit Can this form be edited?. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setReadOnlyDisplay
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit, true);
    }

    /**
     * If set to <code>false</code>, the form will be marked read-only. A widget on the form is editable if either (1)
     * beginning with the widget and continuing up the containment hierarchy, including the form, the first widget to have a
     * non-null <code>canEdit</code> attribute has canEdit:true, or (2) neither the widget nor any parent has a non-null
     * <code>canEdit</code> attribute. This setting allows you to enable or disable the default editability of the form's items
     * at one time. <p> This setting differs from the enabled/disabled state in that most form items will allow copying of the
     * contents while read-only but do not while disabled. <p> Note that a form is considered editable if <code>canEdit</code>
     * is null (default) or <code>true</code>. <P>Note that this property may validly be <code>null</code> as a distinct state
     * from <code>false</code>.  See {@link com.smartgwt.client.widgets.form.DynamicForm#fieldIsEditable fieldIsEditable()} for
     * an API that will always return <code>true</code> or <code>false</code> and give a definitive answer as to whether
     * editing is possible.
     *
     * @return Current canEdit value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }
    

    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields DataBoundComponent.fields} array, that
     * property will be respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit ListGridField.canEdit}). Also note that individual
     * dataBoundComponents may have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell()} may be overridden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEditFieldAttribute New canEditFieldAttribute value. Default value is "canEdit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public void setCanEditFieldAttribute(String canEditFieldAttribute)  throws IllegalStateException {
        setAttribute("canEditFieldAttribute", canEditFieldAttribute, false);
    }

    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields DataBoundComponent.fields} array, that
     * property will be respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit ListGridField.canEdit}). Also note that individual
     * dataBoundComponents may have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell()} may be overridden.
     *
     * @return Current canEditFieldAttribute value. Default value is "canEdit"
     * @see com.smartgwt.client.docs.Identifier Identifier 
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
     * @param canFocus New canFocus value. Default value is true
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
     * @return Current canFocus value. Default value is true
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getCanFocus()  {
        Boolean result = getAttributeAsBoolean("canFocus");
        return result == null ? true : result;
    }
    

    /**
     * Governs whether this form will be used to perform a standard HTML form submission. Note that if true, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit submit()} will perform a native HTML submission to the specified
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action} URL.<br> Wherever possible we strongly recommend
     * using the  {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods} to send data to the
     * server as they provide a far more sophisticated interface, with built in  options for server validation, required
     * fields, etc.<br>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canSubmit New canSubmit value. Default value is false
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setCanSubmit(Boolean canSubmit) {
        setAttribute("canSubmit", canSubmit, true);
    }

    /**
     * Governs whether this form will be used to perform a standard HTML form submission. Note that if true, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit submit()} will perform a native HTML submission to the specified
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action} URL.<br> Wherever possible we strongly recommend
     * using the  {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods} to send data to the
     * server as they provide a far more sophisticated interface, with built in  options for server validation, required
     * fields, etc.<br>
     *
     * @return Current canSubmit value. Default value is false
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public Boolean getCanSubmit()  {
        Boolean result = getAttributeAsBoolean("canSubmit");
        return result == null ? false : result;
    }
    

    /**
     * Should users be able to tab into the {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} for items within this form by default?
     * <p> May be overridden at the item level by {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanTabToIcons
     * FormItem.canTabToIcons}. <P> Developers may also suppress tabbing to individual icons by  setting {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getTabIndex FormItemIcon.tabIndex} to <code>-1</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToIcons New canTabToIcons value. Default value is true
     */
    public void setCanTabToIcons(Boolean canTabToIcons) {
        setAttribute("canTabToIcons", canTabToIcons, true);
    }

    /**
     * Should users be able to tab into the {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} for items within this form by default?
     * <p> May be overridden at the item level by {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanTabToIcons
     * FormItem.canTabToIcons}. <P> Developers may also suppress tabbing to individual icons by  setting {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getTabIndex FormItemIcon.tabIndex} to <code>-1</code>.
     *
     * @return Current canTabToIcons value. Default value is true
     */
    public Boolean getCanTabToIcons()  {
        Boolean result = getAttributeAsBoolean("canTabToIcons");
        return result == null ? true : result;
    }
    

    /**
     * If true, the headers for any {@link com.smartgwt.client.widgets.layout.SectionStackSection#getItems SectionItems} will
     * be included in the page's tab order for accessibility. May also be set at the item level via {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#getCanTabToHeader SectionItem.canTabToHeader} <P> If unset, section
     * headers will be focusable if  {@link com.smartgwt.client.util.SC#setScreenReaderMode SC.setScreenReaderMode()}  has been
     * called. See {@link com.smartgwt.client.docs.Accessibility}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToSectionHeaders New canTabToSectionHeaders value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanTabToSectionHeaders(Boolean canTabToSectionHeaders)  throws IllegalStateException {
        setAttribute("canTabToSectionHeaders", canTabToSectionHeaders, false);
    }

    /**
     * If true, the headers for any {@link com.smartgwt.client.widgets.layout.SectionStackSection#getItems SectionItems} will
     * be included in the page's tab order for accessibility. May also be set at the item level via {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#getCanTabToHeader SectionItem.canTabToHeader} <P> If unset, section
     * headers will be focusable if  {@link com.smartgwt.client.util.SC#setScreenReaderMode SC.setScreenReaderMode()}  has been
     * called. See {@link com.smartgwt.client.docs.Accessibility}.
     *
     * @return Current canTabToSectionHeaders value. Default value is null
     */
    public Boolean getCanTabToSectionHeaders()  {
        return getAttributeAsBoolean("canTabToSectionHeaders");
    }
    

    /**
     * Width of border for the table that form is drawn in. This is primarily used for debugging form layout.
     *
     * @param cellBorder New cellBorder value. Default value is 0
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setCellBorder(int cellBorder) {
        setAttribute("cellBorder", cellBorder, true);
    }

    /**
     * Width of border for the table that form is drawn in. This is primarily used for debugging form layout.
     *
     * @return Current cellBorder value. Default value is 0
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getCellBorder()  {
        return getAttributeAsInt("cellBorder");
    }
    

    /**
     * The amount of empty space, in pixels, surrounding each form item within its cell in the layout grid.
     *
     * @param cellPadding New cellPadding value. Default value is 2
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setCellPadding(int cellPadding) {
        setAttribute("cellPadding", cellPadding, true);
    }

    /**
     * The amount of empty space, in pixels, surrounding each form item within its cell in the layout grid.
     *
     * @return Current cellPadding value. Default value is 2
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getCellPadding()  {
        return getAttributeAsInt("cellPadding");
    }
    

    /**
     * Should the titles for form items be clipped if they are too large for the available  space? <p> Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getClipTitle FormItem.clipTitle}.
     *
     * @param clipItemTitles New clipItemTitles value. Default value is false
     */
    public void setClipItemTitles(boolean clipItemTitles) {
        setAttribute("clipItemTitles", clipItemTitles, true);
    }

    /**
     * Should the titles for form items be clipped if they are too large for the available  space? <p> Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getClipTitle FormItem.clipTitle}.
     *
     * @return Current clipItemTitles value. Default value is false
     */
    public boolean getClipItemTitles()  {
        Boolean result = getAttributeAsBoolean("clipItemTitles");
        return result == null ? false : result;
    }
    

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getClipStaticValue FormItem.clipStaticValue} setting for
     * items in this form. When unset, this is equivalent to <code>false</code>.
     *
     * @param clipStaticValue New clipStaticValue value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClipStaticValue(Boolean clipStaticValue)  throws IllegalStateException {
        setAttribute("clipStaticValue", clipStaticValue, false);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getClipStaticValue FormItem.clipStaticValue} setting for
     * items in this form. When unset, this is equivalent to <code>false</code>.
     *
     * @return Current clipStaticValue value. Default value is null
     */
    public Boolean getClipStaticValue()  {
        return getAttributeAsBoolean("clipStaticValue");
    }
    
    

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @param dataFetchMode New dataFetchMode value. Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @return Current dataFetchMode value. Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public void setDataSource(String dataSource) {
        setAttribute("dataSource", dataSource, true);
    }
    

    /**
     * Default {@link com.smartgwt.client.types.DateDisplayFormat} for Date type values displayed in this form. <P> If some
     * field's value is set to a native Date object, how should it be displayed to the user? If specified this is the default
     * display format to use, and will apply to all fields except those specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type:"time"}  (See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter timeFormatter}). <P> May be overridden at the component
     * level for fields of type <code>datetime</code> via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter}. <P> Note that if specified, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} take precedence over the
     * format specified at the component level. <P> If no explicit formatter is specified at the field or component level,
     * dates will be  formatted according to the system-wide {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat
     * short date display format} or  {@link com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat short datetime
     * display format} depending on the specified field type.
     *
     * @param dateFormatter New dateFormatter value. Default value is null
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
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} take precedence over the
     * format specified at the component level. <P> If no explicit formatter is specified at the field or component level,
     * dates will be  formatted according to the system-wide {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat
     * short date display format} or  {@link com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat short datetime
     * display format} depending on the specified field type.
     *
     * @return Current dateFormatter value. Default value is null
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * Default {@link com.smartgwt.client.types.DateDisplayFormat} for Date type values displayed in this form in fields of
     * type <code>datetime</code>. <P> For datetime fields, this attribute will be used instead of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} when formatting Date values. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} take precedence over
     * the format specified at the component level. <P> If no explicit formatter is specified at the field or component level,
     * datetime field values will be formatted according to the system-wide {@link
     * com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat short datetime display format}.
     *
     * @param datetimeFormatter New datetimeFormatter value. Default value is null
     */
    public void setDatetimeFormatter(DateDisplayFormat datetimeFormatter) {
        setAttribute("datetimeFormatter", datetimeFormatter == null ? null : datetimeFormatter.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DateDisplayFormat} for Date type values displayed in this form in fields of
     * type <code>datetime</code>. <P> For datetime fields, this attribute will be used instead of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} when formatting Date values. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} take precedence over
     * the format specified at the component level. <P> If no explicit formatter is specified at the field or component level,
     * datetime field values will be formatted according to the system-wide {@link
     * com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat short datetime display format}.
     *
     * @return Current datetimeFormatter value. Default value is null
     */
    public DateDisplayFormat getDatetimeFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("datetimeFormatter"));
    }
    

    /**
     * Default {@link com.smartgwt.client.types.OperatorId search operator} to use for fields in a form that produces {@link
     * com.smartgwt.client.data.AdvancedCriteria}.  Default is "iContains" unless {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAllowExpressions allowExpressions} is enabled for the form as a whole,
     * in which case the default is {@link com.smartgwt.client.data.DataSource#getTranslatePatternOperators
     * "iContainsPattern"}. <p> Does not apply to special fields where exact match is obviously the right default setting, such
     * as fields of type:"enum", or fields with a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}
     * or  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}. <p>
     * <code>defaultSearchOperator</code> also has no effect in a form that does not produce <code>AdvancedCriteria</code> -
     * see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria getValuesAsCriteria()} for settings that
     * cause a form to produce AdvancedCriteria.
     *
     * @param defaultSearchOperator New defaultSearchOperator value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultSearchOperator(OperatorId defaultSearchOperator)  throws IllegalStateException {
        setAttribute("defaultSearchOperator", defaultSearchOperator == null ? null : defaultSearchOperator.getValue(), false);
    }

    /**
     * Default {@link com.smartgwt.client.types.OperatorId search operator} to use for fields in a form that produces {@link
     * com.smartgwt.client.data.AdvancedCriteria}.  Default is "iContains" unless {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAllowExpressions allowExpressions} is enabled for the form as a whole,
     * in which case the default is {@link com.smartgwt.client.data.DataSource#getTranslatePatternOperators
     * "iContainsPattern"}. <p> Does not apply to special fields where exact match is obviously the right default setting, such
     * as fields of type:"enum", or fields with a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}
     * or  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}. <p>
     * <code>defaultSearchOperator</code> also has no effect in a form that does not produce <code>AdvancedCriteria</code> -
     * see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria getValuesAsCriteria()} for settings that
     * cause a form to produce AdvancedCriteria.
     *
     * @return Current defaultSearchOperator value. Default value is null
     */
    public OperatorId getDefaultSearchOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("defaultSearchOperator"));
    }
    

    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validators (if
     * any) will still run on attempted save.
     *
     * @param disableValidation New disableValidation value. Default value is null
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
     * @return Current disableValidation value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getDisableValidation()  {
        return getAttributeAsBoolean("disableValidation");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "FormEditProxy"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "FormEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * encoding for the form, use MULTIPART_ENCODING for file upload forms
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param encoding New encoding value. Default value is DynamicForm.NORMAL
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setEncoding(Encoding encoding) {
        setAttribute("encoding", encoding == null ? null : encoding.getValue(), true);
    }

    /**
     * encoding for the form, use MULTIPART_ENCODING for file upload forms
     *
     * @return Current encoding value. Default value is DynamicForm.NORMAL
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
     * @param errorItemCellStyle New errorItemCellStyle value. Default value is "formCellError"
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
     * @return Current errorItemCellStyle value. Default value is "formCellError"
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getErrorItemCellStyle()  {
        return getAttributeAsString("errorItemCellStyle");
    }
    
    
    
    

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is <code>false</code>, all
     * errors for the items in the form are rendered as a single item at the top of the form. This attribute specifies an
     * introductory message rendered out before the individual error messages.
     *
     * @param errorsPreamble New errorsPreamble value. Default value is "The following errors were found:"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setErrorsPreamble(String errorsPreamble)  throws IllegalStateException {
        setAttribute("errorsPreamble", errorsPreamble, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is <code>false</code>, all
     * errors for the items in the form are rendered as a single item at the top of the form. This attribute specifies an
     * introductory message rendered out before the individual error messages.
     *
     * @return Current errorsPreamble value. Default value is "The following errors were found:"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param fixedColWidths New fixedColWidths value. Default value is false
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
     * @return Current fixedColWidths value. Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getFixedColWidths()  {
        Boolean result = getAttributeAsBoolean("fixedColWidths");
        return result == null ? false : result;
    }
    

    /**
     * Warning to display to the user if an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm natively
     * submit} a form is unable to submit to the server. The most common cause for this failure is that the user has typed an
     * invalid file-path into an upload type field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param formSubmitFailedWarning New formSubmitFailedWarning value. Default value is "Form was unable to be submitted. The most likely cause for this is an invalid value in an upload field."
     * @deprecated see {@link com.smartgwt.client.widgets.form.DynamicForm#addFormSubmitFailedHandler DynamicForm.formSubmitFailed()}
     */
    public void setFormSubmitFailedWarning(String formSubmitFailedWarning) {
        setAttribute("formSubmitFailedWarning", formSubmitFailedWarning, true);
    }

    /**
     * Warning to display to the user if an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm natively
     * submit} a form is unable to submit to the server. The most common cause for this failure is that the user has typed an
     * invalid file-path into an upload type field.
     *
     * @return Current formSubmitFailedWarning value. Default value is "Form was unable to be submitted. The most likely cause for this is an invalid value in an upload field."
     * @deprecated see {@link com.smartgwt.client.widgets.form.DynamicForm#addFormSubmitFailedHandler DynamicForm.formSubmitFailed()}
     */
    public String getFormSubmitFailedWarning()  {
        return getAttributeAsString("formSubmitFailedWarning");
    }
    

    /**
     * Indicates whether the titles of required items in this form should use the special prefix and suffix specified by the
     * next two properties, instead of the standard prefix and suffix.
     *
     * @param hiliteRequiredFields New hiliteRequiredFields value. Default value is true
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setHiliteRequiredFields(Boolean hiliteRequiredFields) {
        setAttribute("hiliteRequiredFields", hiliteRequiredFields, true);
    }

    /**
     * Indicates whether the titles of required items in this form should use the special prefix and suffix specified by the
     * next two properties, instead of the standard prefix and suffix.
     *
     * @return Current hiliteRequiredFields value. Default value is true
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public Boolean getHiliteRequiredFields()  {
        Boolean result = getAttributeAsBoolean("hiliteRequiredFields");
        return result == null ? true : result;
    }
    
    

    /**
     * When true, indicates that changes to items in this form will be automatically saved on a  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveDelay delay}, as well as when the entire form is submitted. 
     * Unless {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveOnBlur form.implicitSaveOnBlur} is set  to
     * false, changes will also be automatically saved on editorExit for each item.  This attribute can also be set directly on
     * FormItems.
     *
     * @param implicitSave New implicitSave value. Default value is false
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
     * @return Current implicitSave value. Default value is false
     */
    public Boolean getImplicitSave()  {
        Boolean result = getAttributeAsBoolean("implicitSave");
        return result == null ? false : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSave implicitSave} is true, this attribute dictates
     * the  millisecond delay after which form items are automatically saved during editing.
     *
     * @param implicitSaveDelay New implicitSaveDelay value. Default value is 2000
     */
    public void setImplicitSaveDelay(int implicitSaveDelay) {
        setAttribute("implicitSaveDelay", implicitSaveDelay, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSave implicitSave} is true, this attribute dictates
     * the  millisecond delay after which form items are automatically saved during editing.
     *
     * @return Current implicitSaveDelay value. Default value is 2000
     */
    public int getImplicitSaveDelay()  {
        return getAttributeAsInt("implicitSaveDelay");
    }
    

    /**
     * If true, form item values will be automatically saved when each item's "editorExit"  handler is fired as well as on a
     * delay and when the entire form is submitted.  This attribute can also be set directly on FormItems.
     *
     * @param implicitSaveOnBlur New implicitSaveOnBlur value. Default value is false
     */
    public void setImplicitSaveOnBlur(Boolean implicitSaveOnBlur) {
        setAttribute("implicitSaveOnBlur", implicitSaveOnBlur, true);
    }

    /**
     * If true, form item values will be automatically saved when each item's "editorExit"  handler is fired as well as on a
     * delay and when the entire form is submitted.  This attribute can also be set directly on FormItems.
     *
     * @return Current implicitSaveOnBlur value. Default value is false
     */
    public Boolean getImplicitSaveOnBlur()  {
        Boolean result = getAttributeAsBoolean("implicitSaveOnBlur");
        return result == null ? false : result;
    }
    
    

    /**
     * Text alignment for hovers shown for items
     *
     * @param itemHoverAlign New itemHoverAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverAlign
     */
    public void setItemHoverAlign(Alignment itemHoverAlign) {
        setAttribute("itemHoverAlign", itemHoverAlign == null ? null : itemHoverAlign.getValue(), true);
    }

    /**
     * Text alignment for hovers shown for items
     *
     * @return Current itemHoverAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverAlign
     */
    public Alignment getItemHoverAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("itemHoverAlign"));
    }
    

    /**
     * If the user rolls over an item, how long a delay before we fire any hover action / show a hover for that item?
     *
     * @param itemHoverDelay New itemHoverDelay value. Default value is 500
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverDelay
     */
    public void setItemHoverDelay(int itemHoverDelay) {
        setAttribute("itemHoverDelay", itemHoverDelay, true);
    }

    /**
     * If the user rolls over an item, how long a delay before we fire any hover action / show a hover for that item?
     *
     * @return Current itemHoverDelay value. Default value is 500
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverDelay
     */
    public int getItemHoverDelay()  {
        return getAttributeAsInt("itemHoverDelay");
    }
    

    /**
     * A default height for hovers shown for items
     *
     * @param itemHoverHeight New itemHoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverHeight
     */
    public void setItemHoverHeight(Integer itemHoverHeight) {
        setAttribute("itemHoverHeight", itemHoverHeight, true);
    }

    /**
     * A default height for hovers shown for items
     *
     * @return Current itemHoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverHeight
     */
    public Integer getItemHoverHeight()  {
        return getAttributeAsInt("itemHoverHeight");
    }
    

    /**
     * Opacity for hovers shown for items
     *
     * @param itemHoverOpacity New itemHoverOpacity value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverOpacity
     */
    public void setItemHoverOpacity(Integer itemHoverOpacity) {
        setAttribute("itemHoverOpacity", itemHoverOpacity, true);
    }

    /**
     * Opacity for hovers shown for items
     *
     * @return Current itemHoverOpacity value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverOpacity
     */
    public Integer getItemHoverOpacity()  {
        return getAttributeAsInt("itemHoverOpacity");
    }
    

    /**
     * CSS Style for hovers shown for items
     *
     * @param itemHoverStyle New itemHoverStyle value. Default value is "formHover"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setItemHoverStyle(String itemHoverStyle) {
        setAttribute("itemHoverStyle", itemHoverStyle, true);
    }

    /**
     * CSS Style for hovers shown for items
     *
     * @return Current itemHoverStyle value. Default value is "formHover"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getItemHoverStyle()  {
        return getAttributeAsString("itemHoverStyle");
    }
    

    /**
     * Vertical text alignment for hovers shown for items
     *
     * @param itemHoverVAlign New itemHoverVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverVAlign
     */
    public void setItemHoverVAlign(Integer itemHoverVAlign) {
        setAttribute("itemHoverVAlign", itemHoverVAlign, true);
    }

    /**
     * Vertical text alignment for hovers shown for items
     *
     * @return Current itemHoverVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHoverVAlign
     */
    public Integer getItemHoverVAlign()  {
        return getAttributeAsInt("itemHoverVAlign");
    }
    

    /**
     * A default width for hovers shown for items
     *
     * @param itemHoverWidth New itemHoverWidth value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHoverWidth
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_hovers" target="examples">Hovers Example</a>
     */
    public void setItemHoverWidth(Integer itemHoverWidth) {
        setAttribute("itemHoverWidth", itemHoverWidth, true);
    }

    /**
     * A default width for hovers shown for items
     *
     * @return Current itemHoverWidth value. Default value is null
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
     * com.smartgwt.client.widgets.form.fields.FormItem#setLeft FormItem.setLeft()}      and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setTop FormItem.setTop()} can be used for manual reflow. <li> only
     * pixel and percent sizes are allowed, no "*".  Percent widths mean percentage      of the overall form size rather than
     * the column size <li> with different font styling or internationalized titles, items may overlap that did      not
     * overlap in the skin used at design time </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param itemLayout New itemLayout value. Default value is "table"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setWidth
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHeight
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
     * com.smartgwt.client.widgets.form.fields.FormItem#setLeft FormItem.setLeft()}      and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setTop FormItem.setTop()} can be used for manual reflow. <li> only
     * pixel and percent sizes are allowed, no "*".  Percent widths mean percentage      of the overall form size rather than
     * the column size <li> with different font styling or internationalized titles, items may overlap that did      not
     * overlap in the skin used at design time </ul>
     *
     * @return Current itemLayout value. Default value is "table"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getWidth
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHeight
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
     * @param longTextEditorThreshold New longTextEditorThreshold value. Default value is 255
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
     * @return Current longTextEditorThreshold value. Default value is 255
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getLongTextEditorThreshold()  {
        return getAttributeAsInt("longTextEditorThreshold");
    }
    

    /**
     * Name of the Form Item class to use for text fields which exceed the  longTextEditorThreshold for this form.
     *
     * @param longTextEditorType New longTextEditorType value. Default value is "textArea"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setLongTextEditorType(String longTextEditorType) {
        setAttribute("longTextEditorType", longTextEditorType, true);
    }

    /**
     * Name of the Form Item class to use for text fields which exceed the  longTextEditorThreshold for this form.
     *
     * @return Current longTextEditorType value. Default value is "textArea"
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
     * @return Current method value. Default value is DynamicForm.POST
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public FormMethod getMethod()  {
        return EnumUtil.getEnum(FormMethod.values(), getAttribute("method"));
    }
    

    /**
     * Minimum width of a form column.
     *
     * @param minColWidth New minColWidth value. Default value is 20
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setMinColWidth(int minColWidth) {
        setAttribute("minColWidth", minColWidth, true);
    }

    /**
     * Minimum width of a form column.
     *
     * @return Current minColWidth value. Default value is 20
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getMinColWidth()  {
        return getAttributeAsInt("minColWidth");
    }
    

    /**
     * Minimum horizontal space made available for {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * FormItem.hint} text. Typically this reflects how much space the hint text takes up before it wraps. May be overridden at
     * the item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getMinHintWidth FormItem.minHintWidth}. <p>
     * This setting does not apply to hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField
     * shown in field}.
     *
     * @param minHintWidth New minHintWidth value. Default value is 80
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.form.DynamicForm#setWrapHintText
     */
    public void setMinHintWidth(Integer minHintWidth)  throws IllegalStateException {
        setAttribute("minHintWidth", minHintWidth, false);
    }

    /**
     * Minimum horizontal space made available for {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * FormItem.hint} text. Typically this reflects how much space the hint text takes up before it wraps. May be overridden at
     * the item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getMinHintWidth FormItem.minHintWidth}. <p>
     * This setting does not apply to hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField
     * shown in field}.
     *
     * @return Current minHintWidth value. Default value is 80
     * @see com.smartgwt.client.widgets.form.DynamicForm#getWrapHintText
     */
    public Integer getMinHintWidth()  {
        return getAttributeAsInt("minHintWidth");
    }
    
    
    

    /**
     * A message to display to the user if server-side validation fails with an error but the server did not provide an error
     * message
     *
     * @param noErrorDetailsMessage New noErrorDetailsMessage value. Default value is "Error during validation; no error details were provided"
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setNoErrorDetailsMessage(String noErrorDetailsMessage) {
        setAttribute("noErrorDetailsMessage", noErrorDetailsMessage, true);
    }

    /**
     * A message to display to the user if server-side validation fails with an error but the server did not provide an error
     * message
     *
     * @return Current noErrorDetailsMessage value. Default value is "Error during validation; no error details were provided"
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getNoErrorDetailsMessage()  {
        return getAttributeAsString("noErrorDetailsMessage");
    }
    

    /**
     * The number of columns of titles and items in this form's layout grid. A title and corresponding item each have their own
     * column, so to display two form elements per row (each having a title and item), you would set this property to 4.
     *
     * @param numCols New numCols value. Default value is 2
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setNumCols(int numCols) {
        setAttribute("numCols", numCols, true);
    }

    /**
     * The number of columns of titles and items in this form's layout grid. A title and corresponding item each have their own
     * column, so to display two form elements per row (each having a title and item), you would set this property to 4.
     *
     * @return Current numCols value. Default value is 2
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getNumCols()  {
        return getAttributeAsInt("numCols");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator FormItem.operator} has been set for any {@link
     * com.smartgwt.client.widgets.form.fields.FormItem} in this form, what logical operator should be applied across the
     * {@link com.smartgwt.client.data.Criterion criteria} produced by the form items?  Only applicable to forms that have a
     * {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}.
     *
     * @param operator New operator value. Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperator(OperatorId operator)  throws IllegalStateException {
        setAttribute("operator", operator == null ? null : operator.getValue(), false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator FormItem.operator} has been set for any {@link
     * com.smartgwt.client.widgets.form.fields.FormItem} in this form, what logical operator should be applied across the
     * {@link com.smartgwt.client.data.Criterion criteria} produced by the form items?  Only applicable to forms that have a
     * {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}.
     *
     * @return Current operator value. Default value is "and"
     */
    public OperatorId getOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }
    

    /**
     * Default template HTML string when an item does not set its own {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOriginalValueMessage FormItem.originalValueMessage}. <p> Variables
     * in the template are substituted as follows: <table border="1"> <tr>   <th>Variable</th>   <th>Substitution</th> </tr>
     * <tr>   <td><code>$value</code></td>   <td>The item's old value as stored in the       map       returned by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOldValues getOldValues()}.</td> </tr> <tr>  
     * <td><code>$newValue</code></td>   <td>The item's new value.</td> </tr> </table> <p> For <code>$value</code> and
     * <code>$newValue</code>, any formatters or stored/display value mapping will be applied.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param originalValueMessage New originalValueMessage value. Default value is "Original value: $value"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setOriginalValueMessage(String originalValueMessage) {
        setAttribute("originalValueMessage", originalValueMessage, true);
    }

    /**
     * Default template HTML string when an item does not set its own {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOriginalValueMessage FormItem.originalValueMessage}. <p> Variables
     * in the template are substituted as follows: <table border="1"> <tr>   <th>Variable</th>   <th>Substitution</th> </tr>
     * <tr>   <td><code>$value</code></td>   <td>The item's old value as stored in the       map       returned by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOldValues getOldValues()}.</td> </tr> <tr>  
     * <td><code>$newValue</code></td>   <td>The item's new value.</td> </tr> </table> <p> For <code>$value</code> and
     * <code>$newValue</code>, any formatters or stored/display value mapping will be applied.
     *
     * @return Current originalValueMessage value. Default value is "Original value: $value"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getOriginalValueMessage()  {
        return getAttributeAsString("originalValueMessage");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit} is set to <code>false</code>, how should the
     * items in this form be displayed to the user? <p> Can be overridden via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay FormItem.readOnlyDisplay} on individual form items.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay readOnlyDisplay} attribute.
     *
     * @param readOnlyDisplay New read-only display appearance. Default value is "readOnly"
     */
    public void setReadOnlyDisplay(ReadOnlyDisplayAppearance readOnlyDisplay) {
        setAttribute("readOnlyDisplay", readOnlyDisplay == null ? null : readOnlyDisplay.getValue(), true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit} is set to <code>false</code>, how should the
     * items in this form be displayed to the user? <p> Can be overridden via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay FormItem.readOnlyDisplay} on individual form items.
     *
     * @return Current readOnlyDisplay value. Default value is "readOnly"
     */
    public ReadOnlyDisplayAppearance getReadOnlyDisplay()  {
        return EnumUtil.getEnum(ReadOnlyDisplayAppearance.values(), getAttribute("readOnlyDisplay"));
    }
    

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyTextBoxStyle FormItem.readOnlyTextBoxStyle}
     * setting for items in this form.
     *
     * @param readOnlyTextBoxStyle New readOnlyTextBoxStyle value. Default value is "staticTextItem"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     */
    public void setReadOnlyTextBoxStyle(String readOnlyTextBoxStyle) {
        setAttribute("readOnlyTextBoxStyle", readOnlyTextBoxStyle, true);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyTextBoxStyle FormItem.readOnlyTextBoxStyle}
     * setting for items in this form.
     *
     * @return Current readOnlyTextBoxStyle value. Default value is "staticTextItem"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     */
    public String getReadOnlyTextBoxStyle()  {
        return getAttributeAsString("readOnlyTextBoxStyle");
    }
    

    /**
     * If validateOnChange is true, and validation fails for an item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rejectInvalidValueOnChange New rejectInvalidValueOnChange value. Default value is null
     */
    public void setRejectInvalidValueOnChange(Boolean rejectInvalidValueOnChange) {
        setAttribute("rejectInvalidValueOnChange", rejectInvalidValueOnChange, true);
    }

    /**
     * If validateOnChange is true, and validation fails for an item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     *
     * @return Current rejectInvalidValueOnChange value. Default value is null
     */
    public Boolean getRejectInvalidValueOnChange()  {
        return getAttributeAsBoolean("rejectInvalidValueOnChange");
    }
    

    /**
     * The required message for required field errors.
     *
     * @param requiredMessage New requiredMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage, true);
    }

    /**
     * The required message for required field errors.
     *
     * @return Current requiredMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredMessage()  {
        return getAttributeAsString("requiredMessage");
    }
    

    /**
     * The string pre-pended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true and the {@link
     * com.smartgwt.client.types.TitleOrientation} property is set to "right".
     *
     * @param requiredRightTitlePrefix New requiredRightTitlePrefix value. Default value is "&lt;b&gt;:&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredRightTitlePrefix(String requiredRightTitlePrefix) {
        setAttribute("requiredRightTitlePrefix", requiredRightTitlePrefix, true);
    }

    /**
     * The string pre-pended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true and the {@link
     * com.smartgwt.client.types.TitleOrientation} property is set to "right".
     *
     * @return Current requiredRightTitlePrefix value. Default value is "&lt;b&gt;:&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredRightTitlePrefix()  {
        return getAttributeAsString("requiredRightTitlePrefix");
    }
    

    /**
     * The string appended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true and the {@link
     * com.smartgwt.client.types.TitleOrientation} property is set to "right".
     *
     * @param requiredRightTitleSuffix New requiredRightTitleSuffix value. Default value is "&lt;/b&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredRightTitleSuffix(String requiredRightTitleSuffix) {
        setAttribute("requiredRightTitleSuffix", requiredRightTitleSuffix, true);
    }

    /**
     * The string appended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true and the {@link
     * com.smartgwt.client.types.TitleOrientation} property is set to "right".
     *
     * @return Current requiredRightTitleSuffix value. Default value is "&lt;/b&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredRightTitleSuffix()  {
        return getAttributeAsString("requiredRightTitleSuffix");
    }
    

    /**
     * The string pre-pended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true.
     *
     * @param requiredTitlePrefix New requiredTitlePrefix value. Default value is "&lt;b&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredTitlePrefix(String requiredTitlePrefix) {
        setAttribute("requiredTitlePrefix", requiredTitlePrefix, true);
    }

    /**
     * The string pre-pended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true.
     *
     * @return Current requiredTitlePrefix value. Default value is "&lt;b&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredTitlePrefix()  {
        return getAttributeAsString("requiredTitlePrefix");
    }
    

    /**
     * The string appended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true.
     *
     * @param requiredTitleSuffix New requiredTitleSuffix value. Default value is "&amp;nbsp;:&lt;/b&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredTitleSuffix(String requiredTitleSuffix) {
        setAttribute("requiredTitleSuffix", requiredTitleSuffix, true);
    }

    /**
     * The string appended to the title of every required item in this form if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getHiliteRequiredFields hiliteRequiredFields} is true.
     *
     * @return Current requiredTitleSuffix value. Default value is "&amp;nbsp;:&lt;/b&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredTitleSuffix()  {
        return getAttributeAsString("requiredTitleSuffix");
    }
    

    /**
     * Keyboard shortcut that causes the value of the currently focused form item to be reverted to whatever value would be
     * shown if {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues resetValues()} were called.
     *
     * @param revertValueKey New revertValueKey value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_pending_values" target="examples">Pending Values Example</a>
     */
    public void setRevertValueKey(KeyIdentifier revertValueKey)  throws IllegalStateException {
        setAttribute("revertValueKey", revertValueKey == null ? null : revertValueKey.getJsObj(), false);
    }

    /**
     * Keyboard shortcut that causes the value of the currently focused form item to be reverted to whatever value would be
     * shown if {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues resetValues()} were called.
     *
     * @return Current revertValueKey value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_pending_values" target="examples">Pending Values Example</a>
     */
    public KeyIdentifier getRevertValueKey()  {
        return new KeyIdentifier(getAttributeAsJavaScriptObject("revertValueKey"));
    }
    

    /**
     * The string pre-pended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @param rightTitlePrefix New rightTitlePrefix value. Default value is ":&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRightTitlePrefix(String rightTitlePrefix) {
        setAttribute("rightTitlePrefix", rightTitlePrefix, true);
    }

    /**
     * The string pre-pended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @return Current rightTitlePrefix value. Default value is ":&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRightTitlePrefix()  {
        return getAttributeAsString("rightTitlePrefix");
    }
    

    /**
     * The string appended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @param rightTitleSuffix New rightTitleSuffix value. Default value is ""
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRightTitleSuffix(String rightTitleSuffix) {
        setAttribute("rightTitleSuffix", rightTitleSuffix, true);
    }

    /**
     * The string appended to the title of an item in this form if its titleOrientation property is set to "right".
     *
     * @return Current rightTitleSuffix value. Default value is ""
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRightTitleSuffix()  {
        return getAttributeAsString("rightTitleSuffix");
    }
    

    /**
     * If <code>true</code>, when the user hits the Enter key while focused in a text-item in this form, we automatically
     * submit the form to the server using the  {@link com.smartgwt.client.widgets.form.DynamicForm#submit submit()} method.
     *
     * @param saveOnEnter New saveOnEnter value. Default value is false
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public void setSaveOnEnter(Boolean saveOnEnter) {
        setAttribute("saveOnEnter", saveOnEnter, true);
    }

    /**
     * If <code>true</code>, when the user hits the Enter key while focused in a text-item in this form, we automatically
     * submit the form to the server using the  {@link com.smartgwt.client.widgets.form.DynamicForm#submit submit()} method.
     *
     * @return Current saveOnEnter value. Default value is false
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public Boolean getSaveOnEnter()  {
        Boolean result = getAttributeAsBoolean("saveOnEnter");
        return result == null ? false : result;
    }
    

    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} is called. This property is automatically set on a
     * call to {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord editRecord()} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord editNewRecord()}, or may be set directly via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType setSaveOperationType()}. <P> If
     * <code>saveOperationType</code> is unset, the form will heuristically determine whether an "add" or "update" operation is
     * intended based on whether the primaryKey field is present and editable.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the default {@link com.smartgwt.client.types.DSOperationType} when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} is called. Note that this property can also be set by calling {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord editRecord()} or  {@link com.smartgwt.client.widgets.form.DynamicForm#editNewRecord editNewRecord()}
     *
     * @param saveOperationType Operation type to use as a default. Valid values are  <code>"add"</code> or <code>"update"</code>. Default value is null
     */
    public void setSaveOperationType(DSOperationType saveOperationType) {
        setAttribute("saveOperationType", saveOperationType == null ? null : saveOperationType.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} is called. This property is automatically set on a
     * call to {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord editRecord()} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord editNewRecord()}, or may be set directly via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType setSaveOperationType()}. <P> If
     * <code>saveOperationType</code> is unset, the form will heuristically determine whether an "add" or "update" operation is
     * intended based on whether the primaryKey field is present and editable.
     *
     * @return Returns the {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} is called. Valid options are <code>"add"</code> or
     * <code>"update"</code>. <P> If a {@link com.smartgwt.client.data.DSRequest} configuration object is passed in containing
     * an explicit operationType this will be returned. Otherwise {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType} will be returned. This attribute is
     * automatically set via calls to data binding methods such as {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord editNewRecord()}, or it may be set explicitly. <P> If no
     * explicit saveOperationType is specified for this form, the system will  look at the current values for the form. If the
     * form has no value for the {@link com.smartgwt.client.data.DataSource#getPrimaryKeyField primaryKey field}, or that field
     * is editable and has been modified we assume an add operation, otherwise an update. If the form is a member of a {@link
     * com.smartgwt.client.widgets.form.ValuesManager}, the primary key field value will be derived from the valuesManager's
     * values object. Default value is null
     */
    public DSOperationType getSaveOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("saveOperationType"));
    }
    

    /**
     * If the form has sections, [implemented as {@link com.smartgwt.client.widgets.form.fields.SectionItem}s], this attribute
     * controls whether multiple sections can be expanded at once.
     *
     * @param sectionVisibilityMode New sectionVisibilityMode value. Default value is "multiple"
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
     * @return Current sectionVisibilityMode value. Default value is "multiple"
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
     * focusInItem()}), or via a mouse click, all text within the item will be selected. <P> If you only want the value to be
     * selected when on programmatic focus or keyboard navigation (this is the native browser behavior), set  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} instead. <P> May be overridden at the form
     * item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnClick FormItem.selectOnClick}.
     *
     * @param selectOnClick New selectOnClick value. Default value is false
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnClick(Boolean selectOnClick) {
        setAttribute("selectOnClick", selectOnClick, true);
    }

    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus - whether programmatically (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem
     * focusInItem()}), or via a mouse click, all text within the item will be selected. <P> If you only want the value to be
     * selected when on programmatic focus or keyboard navigation (this is the native browser behavior), set  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} instead. <P> May be overridden at the form
     * item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnClick FormItem.selectOnClick}.
     *
     * @return Current selectOnClick value. Default value is false
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnClick()  {
        Boolean result = getAttributeAsBoolean("selectOnClick");
        return result == null ? false : result;
    }
    

    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem focusInItem()}), all
     * text within the item will be selected. <P> Note that this flag affects only programmatic focus.  It's the normal
     * behavior of text fields to select all text if the user navigates into them via keyboard, or if the user navigates via
     * mouse, to place the text insertion point at the mouse click, and Smart GWT preserves these behaviors. 
     * <code>selectOnFocus</code> is only needed for cases like a form within a pop-up dialog that should have the first field
     * selected. <P> If you also want the value to be selected when the user clicks on the field, set  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} instead. <P> If <code>selectOnFocus</code>
     * is false, the selection is not modified on focus - any previous selection within the item will be maintained. <P> May be
     * overridden at the form item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnFocus
     * FormItem.selectOnFocus}.
     *
     * @param selectOnFocus New selectOnFocus value. Default value is false
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnFocus(Boolean selectOnFocus) {
        setAttribute("selectOnFocus", selectOnFocus, true);
    }

    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem focusInItem()}), all
     * text within the item will be selected. <P> Note that this flag affects only programmatic focus.  It's the normal
     * behavior of text fields to select all text if the user navigates into them via keyboard, or if the user navigates via
     * mouse, to place the text insertion point at the mouse click, and Smart GWT preserves these behaviors. 
     * <code>selectOnFocus</code> is only needed for cases like a form within a pop-up dialog that should have the first field
     * selected. <P> If you also want the value to be selected when the user clicks on the field, set  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} instead. <P> If <code>selectOnFocus</code>
     * is false, the selection is not modified on focus - any previous selection within the item will be maintained. <P> May be
     * overridden at the form item level via {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnFocus
     * FormItem.selectOnFocus}.
     *
     * @return Current selectOnFocus value. Default value is false
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnFocus()  {
        Boolean result = getAttributeAsBoolean("selectOnFocus");
        return result == null ? false : result;
    }
    

    /**
     * If set, this <code>DynamicForm</code> will set both  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields showComplexFields} and 
     * <code>showComplexFieldsRecursively</code> on any nested component used for showing/editing a complex field.  Thus any of
     * this form's items that handle complex fields will themselves also show complex fields.  This allows for handling of
     * field structures of any complexity. <p> If set, this value automatically sets {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields showComplexFields} as well.
     *
     * @param showComplexFieldsRecursively New showComplexFieldsRecursively value. Default value is null
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
     * @return Current showComplexFieldsRecursively value. Default value is null
     */
    public Boolean getShowComplexFieldsRecursively()  {
        return getAttributeAsBoolean("showComplexFieldsRecursively");
    }
    

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDeletions FormItem.showDeletions} setting for
     * items in this form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDeletions New showDeletions value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDeletions(Boolean showDeletions)  throws IllegalStateException {
        setAttribute("showDeletions", showDeletions, false);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDeletions FormItem.showDeletions} setting for
     * items in this form.
     *
     * @return Current showDeletions value. Default value is null
     */
    public Boolean getShowDeletions()  {
        return getAttributeAsBoolean("showDeletions");
    }
    

    /**
     * For databound forms, whether to show fields marked as detail fields.
     *
     * @param showDetailFields New showDetailFields value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * For databound forms, whether to show fields marked as detail fields.
     *
     * @return Current showDetailFields value. Default value is true
     */
    public Boolean getShowDetailFields()  {
        Boolean result = getAttributeAsBoolean("showDetailFields");
        return result == null ? true : result;
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
     * FormItem.getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc FormItem.errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth FormItem.errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight FormItem.errorIconHeight} <P>
     * <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which
     * have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle FormItem.showTitle} set to
     * false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the
     * error HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. Error styling is achieved
     * by applying suffixes to existing styling applied to various parts of the form item. See {@link
     * com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @param showErrorIcons New showErrorIcons value. Default value is true
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
     * FormItem.getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc FormItem.errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth FormItem.errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight FormItem.errorIconHeight} <P>
     * <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which
     * have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle FormItem.showTitle} set to
     * false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the
     * error HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. Error styling is achieved
     * by applying suffixes to existing styling applied to various parts of the form item. See {@link
     * com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @return Current showErrorIcons value. Default value is true
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowErrorIcons()  {
        Boolean result = getAttributeAsBoolean("showErrorIcons");
        return result == null ? true : result;
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
     * FormItem.getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc FormItem.errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth FormItem.errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight FormItem.errorIconHeight} <P>
     * <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which
     * have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle FormItem.showTitle} set to
     * false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the
     * error HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. Error styling is achieved
     * by applying suffixes to existing styling applied to various parts of the form item. See {@link
     * com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @param showErrorStyle New showErrorStyle value. Default value is true
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
     * FormItem.getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc FormItem.errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth FormItem.errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight FormItem.errorIconHeight} <P>
     * <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which
     * have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle FormItem.showTitle} set to
     * false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the
     * error HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. Error styling is achieved
     * by applying suffixes to existing styling applied to various parts of the form item. See {@link
     * com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @return Current showErrorStyle value. Default value is true
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowErrorStyle()  {
        Boolean result = getAttributeAsBoolean("showErrorStyle");
        return result == null ? true : result;
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
     * FormItem.getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc FormItem.errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth FormItem.errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight FormItem.errorIconHeight} <P>
     * <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which
     * have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle FormItem.showTitle} set to
     * false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the
     * error HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. Error styling is achieved
     * by applying suffixes to existing styling applied to various parts of the form item. See {@link
     * com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @param showErrorText New showErrorText value. Default value is false
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
     * FormItem.getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc FormItem.errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth FormItem.errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight FormItem.errorIconHeight} <P>
     * <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which
     * have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle FormItem.showTitle} set to
     * false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the
     * error HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. Error styling is achieved
     * by applying suffixes to existing styling applied to various parts of the form item. See {@link
     * com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @return Current showErrorText value. Default value is false
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowErrorText()  {
        Boolean result = getAttributeAsBoolean("showErrorText");
        return result == null ? false : result;
    }
    

    /**
     * If true, field errors are written into the form next to the item(s) where the errors occurred.  Errors may appear as
     * text or just an icon (via {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}:false).
     * <P> If false, errors are written at the top of the form. <P> To do some other kind of error display, override {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors showErrors()}.
     *
     * @param showInlineErrors New showInlineErrors value. Default value is true
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setShowInlineErrors(Boolean showInlineErrors) {
        setAttribute("showInlineErrors", showInlineErrors, true);
    }

    /**
     * If true, field errors are written into the form next to the item(s) where the errors occurred.  Errors may appear as
     * text or just an icon (via {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}:false).
     * <P> If false, errors are written at the top of the form. <P> To do some other kind of error display, override {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors showErrors()}.
     *
     * @return Current showInlineErrors value. Default value is true
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowInlineErrors()  {
        Boolean result = getAttributeAsBoolean("showInlineErrors");
        return result == null ? true : result;
    }
    

    /**
     * Default setting for the form items' {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} setting.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOldValueInHover New showOldValueInHover value. Default value is null
     */
    public void setShowOldValueInHover(Boolean showOldValueInHover) {
        setAttribute("showOldValueInHover", showOldValueInHover, true);
    }

    /**
     * Default setting for the form items' {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} setting.
     *
     * @return Current showOldValueInHover value. Default value is null
     */
    public Boolean getShowOldValueInHover()  {
        return getAttributeAsBoolean("showOldValueInHover");
    }
    

    /**
     * This property applies to all of the items that a form has, and works according to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPending FormItem.showPending}. <P> Also, in a form with
     * showPending:true, an individual {@link com.smartgwt.client.widgets.form.fields.FormItem} can set  showPending:false and
     * vice versa.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showPending New showPending value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowPending(Boolean showPending)  throws IllegalStateException {
        setAttribute("showPending", showPending, false);
    }

    /**
     * This property applies to all of the items that a form has, and works according to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPending FormItem.showPending}. <P> Also, in a form with
     * showPending:true, an individual {@link com.smartgwt.client.widgets.form.fields.FormItem} can set  showPending:false and
     * vice versa.
     *
     * @return Current showPending value. Default value is null
     */
    public Boolean getShowPending()  {
        return getAttributeAsBoolean("showPending");
    }
    

    /**
     * Indicates whether on validation failure, the error message displayed to the          user should be pre-pended with the
     * title for the item.
     *
     * @param showTitlesWithErrorMessages New showTitlesWithErrorMessages value. Default value is false
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setShowTitlesWithErrorMessages(Boolean showTitlesWithErrorMessages) {
        setAttribute("showTitlesWithErrorMessages", showTitlesWithErrorMessages, true);
    }

    /**
     * Indicates whether on validation failure, the error message displayed to the          user should be pre-pended with the
     * title for the item.
     *
     * @return Current showTitlesWithErrorMessages value. Default value is false
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getShowTitlesWithErrorMessages()  {
        Boolean result = getAttributeAsBoolean("showTitlesWithErrorMessages");
        return result == null ? false : result;
    }
    

    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> Enabling this property also implies {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit FormItem.validateOnExit} is automatically enabled. If
     * there are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation FormItem.synchronousValidation} is forced on.
     *
     * @param stopOnError New stopOnError value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStopOnError(Boolean stopOnError)  throws IllegalStateException {
        setAttribute("stopOnError", stopOnError, false);
    }

    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> Enabling this property also implies {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit FormItem.validateOnExit} is automatically enabled. If
     * there are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation FormItem.synchronousValidation} is forced on.
     *
     * @return Current stopOnError value. Default value is null
     */
    public Boolean getStopOnError()  {
        return getAttributeAsBoolean("stopOnError");
    }
    

    /**
     * For editable fields with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField
     * FormItem.displayField} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, if the user selects a new value (typically from PickList based item such as a SelectItem),
     * should the selected displayValue be updated on the record being edited in addition to the value for the actual item.<br>
     * Note that this only applies for fields using  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display field values} - typically
     * {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey fields} where the display field is {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#includeFrom included from} another dataSource. <P> Default value is
     * <code>true</code>. This is typically desirable for editing records with a displayField-mapped field, as it ensures the
     * edited record will be be updated to contain the correct display value as well as the correct data value. As such, the
     * expected display value is available on the record for display (for example in a ListGrid cell). <P> It may not be
     * desirable for an interface specifically intended for  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria gathering criteria} - in this case, results ought to be
     * limited by an item's actual selected value, not by whatever text is displayed to  the user. <P> See {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField DataSourceField.displayField} for more details. <P> Note: the
     * modified display field value will be passed to the server along with the modified foreignKey field value if a  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData databound update operation} is performed. This occurs even if the
     * displayField is {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom included from another DataSource}
     * and therefore read-only. In this case the server will simply ignore the modified display field value. This is as
     * expected - a subsequent fetch for the same record would recalculate the displayField value on the server using the
     * updated foreignKey field value (and return the same display value previously displayed to the user). <P> This attribute
     * can also be set for {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues individual items}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param storeDisplayValues New storeDisplayValues value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStoreDisplayValues(Boolean storeDisplayValues)  throws IllegalStateException {
        setAttribute("storeDisplayValues", storeDisplayValues, false);
    }

    /**
     * For editable fields with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField
     * FormItem.displayField} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, if the user selects a new value (typically from PickList based item such as a SelectItem),
     * should the selected displayValue be updated on the record being edited in addition to the value for the actual item.<br>
     * Note that this only applies for fields using  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display field values} - typically
     * {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey fields} where the display field is {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#includeFrom included from} another dataSource. <P> Default value is
     * <code>true</code>. This is typically desirable for editing records with a displayField-mapped field, as it ensures the
     * edited record will be be updated to contain the correct display value as well as the correct data value. As such, the
     * expected display value is available on the record for display (for example in a ListGrid cell). <P> It may not be
     * desirable for an interface specifically intended for  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria gathering criteria} - in this case, results ought to be
     * limited by an item's actual selected value, not by whatever text is displayed to  the user. <P> See {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField DataSourceField.displayField} for more details. <P> Note: the
     * modified display field value will be passed to the server along with the modified foreignKey field value if a  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData databound update operation} is performed. This occurs even if the
     * displayField is {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom included from another DataSource}
     * and therefore read-only. In this case the server will simply ignore the modified display field value. This is as
     * expected - a subsequent fetch for the same record would recalculate the displayField value on the server using the
     * updated foreignKey field value (and return the same display value previously displayed to the user). <P> This attribute
     * can also be set for {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues individual items}.
     *
     * @return Current storeDisplayValues value. Default value is true
     */
    public Boolean getStoreDisplayValues()  {
        Boolean result = getAttributeAsBoolean("storeDisplayValues");
        return result == null ? true : result;
    }
    

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.TextItem#getSuppressBrowserClearIcon
     * TextItem.suppressBrowserClearIcon} value for TextItems within this  form.
     *
     * @param suppressBrowserClearIcons New suppressBrowserClearIcons value. Default value is false
     */
    public void setSuppressBrowserClearIcons(boolean suppressBrowserClearIcons) {
        setAttribute("suppressBrowserClearIcons", suppressBrowserClearIcons, true);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.TextItem#getSuppressBrowserClearIcon
     * TextItem.suppressBrowserClearIcon} value for TextItems within this  form.
     *
     * @return Current suppressBrowserClearIcons value. Default value is false
     */
    public boolean getSuppressBrowserClearIcons()  {
        Boolean result = getAttributeAsBoolean("suppressBrowserClearIcons");
        return result == null ? false : result;
    }
    

    /**
     * When calling {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} on a form or valuesManager, by
     * default if the server returns an error code, any callback passed into saveData() will not be fired. If the error code
     * returned by the server indicates a validation error, it will be displayed to the user by updating the form items to show
     * the error messages, and firing any specified hiddenValidationErrors handler, otherwise the standard RPCManager error
     * handling logic would be invoked. <P> Developers who want to handle errors themselves can override this default by
     * specifying {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError dsRequest.willHandleError} on the DSRequest. In
     * this case the callback passed in  will be fired even if the server returns an error status code. <P> If
     * <code>suppressValidationErrorCallback</code> is set to true, if a save attempt returns a <i>validation</i> error code,
     * the user-specified callback will not be fired <i>even if <code>willHandleError:true</code> was specified on the
     * dsRequest</i>  - though for other error codes, the callback would be fired if willHandleError is  specified on the
     * request. Note that this is the historical behavior for  SmartGWT builds 4.0 and earlier
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param suppressValidationErrorCallback New suppressValidationErrorCallback value. Default value is false
     */
    public void setSuppressValidationErrorCallback(Boolean suppressValidationErrorCallback) {
        setAttribute("suppressValidationErrorCallback", suppressValidationErrorCallback, true);
    }

    /**
     * When calling {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} on a form or valuesManager, by
     * default if the server returns an error code, any callback passed into saveData() will not be fired. If the error code
     * returned by the server indicates a validation error, it will be displayed to the user by updating the form items to show
     * the error messages, and firing any specified hiddenValidationErrors handler, otherwise the standard RPCManager error
     * handling logic would be invoked. <P> Developers who want to handle errors themselves can override this default by
     * specifying {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError dsRequest.willHandleError} on the DSRequest. In
     * this case the callback passed in  will be fired even if the server returns an error status code. <P> If
     * <code>suppressValidationErrorCallback</code> is set to true, if a save attempt returns a <i>validation</i> error code,
     * the user-specified callback will not be fired <i>even if <code>willHandleError:true</code> was specified on the
     * dsRequest</i>  - though for other error codes, the callback would be fired if willHandleError is  specified on the
     * request. Note that this is the historical behavior for  SmartGWT builds 4.0 and earlier
     *
     * @return Current suppressValidationErrorCallback value. Default value is false
     */
    public Boolean getSuppressValidationErrorCallback()  {
        Boolean result = getAttributeAsBoolean("suppressValidationErrorCallback");
        return result == null ? false : result;
    }
    

    /**
     * If enabled, whenever validation is triggered and a request to the server is required, user interactivity will be blocked
     * until the request returns. Can be set for the entire form or individual FormItems. <p> If false, the form will try to
     * avoid blocking user interaction until it is strictly required. That is until the user attempts to use a FormItem whose
     * state could be affected by a server request that has not yet returned.
     *
     * @param synchronousValidation New synchronousValidation value. Default value is false
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
     * @return Current synchronousValidation value. Default value is false
     */
    public Boolean getSynchronousValidation()  {
        Boolean result = getAttributeAsBoolean("synchronousValidation");
        return result == null ? false : result;
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
     * @param target New submission target. Default value is null
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
     * @return Current target value. Default value is null
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }
    

    /**
     * Default {@link com.smartgwt.client.types.TimeDisplayFormat} for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type:"time"} field values displayed in this form. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} take precedence over
     * the format specified at the component level. <P> If no explicit formatter is specified at the field or component level,
     * time values will be  formatted according to the system-wide String. specified field type.
     *
     * @param timeFormatter New timeFormatter value. Default value is null
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.TimeDisplayFormat} for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type:"time"} field values displayed in this form. <P> Note that
     * if specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} take precedence over
     * the format specified at the component level. <P> If no explicit formatter is specified at the field or component level,
     * time values will be  formatted according to the system-wide String. specified field type.
     *
     * @return Current timeFormatter value. Default value is null
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }
    

    /**
     * Default alignment for item titles. If unset default alignment will be derived from {@link
     * com.smartgwt.client.util.Page#isRTL text direction} as described in {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleAlign getTitleAlign()}
     *
     * @param titleAlign New titleAlign value. Default value is null
     */
    public void setTitleAlign(Alignment titleAlign) {
        setAttribute("titleAlign", titleAlign == null ? null : titleAlign.getValue(), true);
    }

    /**
     * Default alignment for item titles. If unset default alignment will be derived from {@link
     * com.smartgwt.client.util.Page#isRTL text direction} as described in {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleAlign getTitleAlign()}
     *
     * @return Get the alignment for the title for some item. Default implementation is as follows: <ul><li>If {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleAlign FormItem.titleAlign} is specified, it will be
     * respected</li>     <li>Otherwise if {@link com.smartgwt.client.widgets.form.DynamicForm#getTitleAlign this.titleAlign}
     * is set, it will be         respected</li>     <li>Otherwise titles will be aligned according to {@link
     * com.smartgwt.client.util.Page#isRTL text direction},         with this method returning <code>"right"</code> if text
     * direction is LTR,         or <code>"left"</code> if text direction is RTL. </ul>. Default value is null
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
     * @return Return the orientation of the title for a specific item or the default title orientation if no item is passed. Default value is "left"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public TitleOrientation getTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("titleOrientation"));
    }
    

    /**
     * The string pre-pended to the title of every item in this form.  See also +{requiredTitlePrefix} for fields that are
     * required.
     *
     * @param titlePrefix New titlePrefix value. Default value is ""
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setTitlePrefix(String titlePrefix) {
        setAttribute("titlePrefix", titlePrefix, true);
    }

    /**
     * The string pre-pended to the title of every item in this form.  See also +{requiredTitlePrefix} for fields that are
     * required.
     *
     * @return Current titlePrefix value. Default value is ""
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getTitlePrefix()  {
        return getAttributeAsString("titlePrefix");
    }
    

    /**
     * The string appended to the title of every item in this form.  See also +{requiredTitleSuffix} for fields that are
     * required.
     *
     * @param titleSuffix New titleSuffix value. Default value is "&amp;nbsp;:"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setTitleSuffix(String titleSuffix) {
        setAttribute("titleSuffix", titleSuffix, true);
    }

    /**
     * The string appended to the title of every item in this form.  See also +{requiredTitleSuffix} for fields that are
     * required.
     *
     * @return Current titleSuffix value. Default value is "&amp;nbsp;:"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getTitleSuffix()  {
        return getAttributeAsString("titleSuffix");
    }
    
    

    /**
     * The error message for a failed validator that does not specify its own errorMessage.
     *
     * @param unknownErrorMessage New unknownErrorMessage value. Default value is "Invalid value"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setUnknownErrorMessage(String unknownErrorMessage) {
        setAttribute("unknownErrorMessage", unknownErrorMessage, true);
    }

    /**
     * The error message for a failed validator that does not specify its own errorMessage.
     *
     * @return Current unknownErrorMessage value. Default value is "Invalid value"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getUnknownErrorMessage()  {
        return getAttributeAsString("unknownErrorMessage");
    }
    

    /**
     * Associated userTask if current dynamic form used along with workflow.  See {@link
     * com.smartgwt.client.util.workflow.UserTask userTask} for more details.
     *
     * @param userTask New userTask value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUserTask(UserTask userTask)  throws IllegalStateException {
        setAttribute("userTask", userTask == null ? null : userTask.getOrCreateJsObj(), false);
    }

    /**
     * Associated userTask if current dynamic form used along with workflow.  See {@link
     * com.smartgwt.client.util.workflow.UserTask userTask} for more details.
     *
     * @return Current userTask value. Default value is null
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
     * @param validateOnChange New validateOnChange value. Default value is false
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
     * @return Current validateOnChange value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getValidateOnChange()  {
        Boolean result = getAttributeAsBoolean("validateOnChange");
        return result == null ? false : result;
    }
    

    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <P> Note that this property can also be set at the item level to enable finer granularity
     * validation in response to user interaction - if true at either level, validation will occur on editorExit.
     *
     * @param validateOnExit New validateOnExit value. Default value is false
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
     * @return Current validateOnExit value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit
     */
    public Boolean getValidateOnExit()  {
        Boolean result = getAttributeAsBoolean("validateOnExit");
        return result == null ? false : result;
    }
    

    /**
     * validationURL can be set to do server-side validation against a different URL from where the form will ultimately save,
     * as part of an incremental upgrade strategy for Struts and Struts-like applications.   <P> If set, calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit submit()} causes an RPC to be sent to this URL to perform
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
     * @param validationURL New validationURL value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.URL URL 
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setValidationURL(String validationURL) {
        setAttribute("validationURL", validationURL, true);
    }

    /**
     * validationURL can be set to do server-side validation against a different URL from where the form will ultimately save,
     * as part of an incremental upgrade strategy for Struts and Struts-like applications.   <P> If set, calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit submit()} causes an RPC to be sent to this URL to perform
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
     * @return Current validationURL value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.URL URL 
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getValidationURL()  {
        return getAttributeAsString("validationURL");
    }
    

    /**
     * An Object containing the initial values of the form as properties, where each propertyName is the name of a {@link
     * com.smartgwt.client.docs.Items form item} in the form, and each property value is the value held by that form item. <P>
     * The form's values may contain values that are not managed by any FormItem, and these values will be preserved and
     * available when the form values are subsequently retrieved via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues getValues()}. <P> Providing values on initialization is
     * equivalent to calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValues setValues()}. <P> As the user
     * manipulates form items to change values, change events fire {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler on the items} and  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addItemChangeHandler on the form as a whole}. <P> Note that form values are
     * logical values, for example, the value of a {@link com.smartgwt.client.widgets.form.fields.DateItem} is a JavaScript
     * Date object, not a String, even if the user enters the date via a text input.  Likewise the value of a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem} or {@link com.smartgwt.client.widgets.form.fields.CheckboxItem} that
     * started out null remains null until the user changes it; the value will not be automatically converted to the null
     * string ("") or false respectively, as happens with native HTML elements.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Replaces the current values of the entire form with the values passed in. <P> Note: when working with a form that is saving to a DataSource, you would typically call either {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord editRecord()} for an existing record, or {@link com.smartgwt.client.widgets.form.DynamicForm#editNewRecord editNewRecord()} for a new record.  In addition to setting the current values of the form, these APIs establish the {@link com.smartgwt.client.data.DSRequest#getOperationType DSRequest.operationType} used to save ("update" vs "add"). <P> Values should be provided as an Object containing the new values as properties, where each propertyName is the name of a {@link com.smartgwt.client.docs.Items form item} in the form, and each property value is the value to apply to that form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()}.  <P> Values with no corresponding form item may also be passed, will be tracked by the form and returned by subsequent calls to {@link com.smartgwt.client.widgets.form.DynamicForm#getValues getValues()}. <P> Any {@link com.smartgwt.client.widgets.form.fields.FormItem} for which a value is not provided will revert to its {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue}.  To cause all FormItems to revert to default values, pass null. <P> This method also calls {@link com.smartgwt.client.widgets.form.DynamicForm#rememberValues rememberValues()} so that a subsequent later call to {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues resetValues()} will revert to the passed values.
     *
     * @param values values for the form, or null to reset all items to default values. Default value is null
     */
    public void setValues(Map values) {
        setAttribute("values", values, true);
    }

    /**
     * An Object containing the initial values of the form as properties, where each propertyName is the name of a {@link
     * com.smartgwt.client.docs.Items form item} in the form, and each property value is the value held by that form item. <P>
     * The form's values may contain values that are not managed by any FormItem, and these values will be preserved and
     * available when the form values are subsequently retrieved via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues getValues()}. <P> Providing values on initialization is
     * equivalent to calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValues setValues()}. <P> As the user
     * manipulates form items to change values, change events fire {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler on the items} and  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addItemChangeHandler on the form as a whole}. <P> Note that form values are
     * logical values, for example, the value of a {@link com.smartgwt.client.widgets.form.fields.DateItem} is a JavaScript
     * Date object, not a String, even if the user enters the date via a text input.  Likewise the value of a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem} or {@link com.smartgwt.client.widgets.form.fields.CheckboxItem} that
     * started out null remains null until the user changes it; the value will not be automatically converted to the null
     * string ("") or false respectively, as happens with native HTML elements.
     *
     * @return An Object containing the values of the form as properties, where each propertyName is the name of a {@link
     * com.smartgwt.client.docs.Items form item} in the form, and each property value is the value held by that form item. Default value is null
     */
    public Map getValues()  {
        return getAttributeAsMap("values");
    }
    
    

    /**
     * Should items within this form that are showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * FormItem.hint} have the hint text wrap? May be overridden at the item level via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getWrapHintText FormItem.wrapHintText}. If <code>wrapHintText</code> is
     * unset on both the form and item, then the default behavior is not wrapping the hint. <p> This setting does not apply to
     * hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField shown in field}.
     *
     * @param wrapHintText New wrapHintText value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.form.DynamicForm#setMinHintWidth
     */
    public void setWrapHintText(Boolean wrapHintText)  throws IllegalStateException {
        setAttribute("wrapHintText", wrapHintText, false);
    }

    /**
     * Should items within this form that are showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * FormItem.hint} have the hint text wrap? May be overridden at the item level via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getWrapHintText FormItem.wrapHintText}. If <code>wrapHintText</code> is
     * unset on both the form and item, then the default behavior is not wrapping the hint. <p> This setting does not apply to
     * hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField shown in field}.
     *
     * @return Current wrapHintText value. Default value is true
     * @see com.smartgwt.client.widgets.form.DynamicForm#getMinHintWidth
     */
    public Boolean getWrapHintText()  {
        Boolean result = getAttributeAsBoolean("wrapHintText");
        return result == null ? true : result;
    }
    

    /**
     * Whether titles for form items should wrap.  If not specified, titles will wrap by default.  Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getWrapTitle FormItem.wrapTitle}
     *
     * @param wrapItemTitles New wrapItemTitles value. Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setWrapItemTitles(Boolean wrapItemTitles) {
        setAttribute("wrapItemTitles", wrapItemTitles, true);
    }

    /**
     * Whether titles for form items should wrap.  If not specified, titles will wrap by default.  Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getWrapTitle FormItem.wrapTitle}
     *
     * @return Current wrapItemTitles value. Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public Boolean getWrapItemTitles()  {
        return getAttributeAsBoolean("wrapItemTitles");
    }
    

    // ********************* Methods ***********************
	/**
     * This method is called automatically by the DynamicForm when the set of items changes and ensures that items show up in
     * the correct tab order positions. <P> Makes use of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#sortItemsIntoTabOrder sortItemsIntoTabOrder()} to order the items and
     * ensures the items are ordered in the {@link com.smartgwt.client.widgets.TabIndexManager} correctly.
     */
    public native void assignItemsTabPositions() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "assignItemsTabPositions", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.assignItemsTabPositions();
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
     * @see com.smartgwt.client.widgets.form.DynamicForm#cancelEditing
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public native void cancel() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancel", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancel", "DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancel(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * If the form or valuesManager has associated userTask workflow task than notify it about cancelling the changes.
     */
    public native void cancelEditing() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancelEditing", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelEditing();
    }-*/;

	/**
     * Performs silent validation of the current form values, like {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valuesAreValid valuesAreValid()}.  In contrast to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valuesAreValid valuesAreValid()}, this method allows checking for
     * server-side errors, and finding out what the errors are.   <P> The callback must be passed unless server-side validation
     * is being skipped, and If passed, it always fires, errors or not, firing synchronously if server validation is skipped.
     * @param callback callback to invoke after validation is complete
     *
     * @return null if server-side validation is required, or no errors are present; otherwise, a Map of field names to the associated
     * errors, for those fields that failed validation.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native Map checkForValidationErrors(ValidationStatusCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "checkForValidationErrors", "ValidationStatusCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.checkForValidationErrors(
			$entry( function(errorMap) { 
				if(callback!=null) callback.@com.smartgwt.client.data.ValidationStatusCallback::execute(Ljava/util/Map;)(
					@com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(errorMap)
				);
			}));
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see DynamicForm#checkForValidationErrors
     */
    public Map checkForValidationErrors(ValidationStatusCallback callback, boolean validateHiddenFields){
        return checkForValidationErrors(callback, validateHiddenFields, false);
    }

	/**
     * Performs silent validation of the current form values, like {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valuesAreValid valuesAreValid()}.  In contrast to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valuesAreValid valuesAreValid()}, this method allows checking for
     * server-side errors, and finding out what the errors are.   <P> The callback must be passed unless server-side validation
     * is being skipped, and If passed, it always fires, errors or not, firing synchronously if server validation is skipped.
     * @param callback callback to invoke after validation is complete
     * @param validateHiddenFields should validators be processed for non-visible fields         such as dataSource fields with no associated item or
     * fields with visibility set to         <code>"hidden"</code>
     * @param skipServerValidation whether to skip doing server-side validation
     *
     * @return null if server-side validation is required, or no errors are present; otherwise, a Map of field names to the associated
     * errors, for those fields that failed validation.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native Map checkForValidationErrors(ValidationStatusCallback callback, boolean validateHiddenFields, boolean skipServerValidation) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "checkForValidationErrors", "ValidationStatusCallback,boolean,boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.checkForValidationErrors(
			$entry( function(errorMap) { 
				if(callback!=null) callback.@com.smartgwt.client.data.ValidationStatusCallback::execute(Ljava/util/Map;)(
					@com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(errorMap)
				);
			}), validateHiddenFields, skipServerValidation);
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Clears all errors for this DynamicForm.
     * @param show If true, redraw the form to clear any visible error messages.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void clearErrors(boolean show) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearErrors", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearErrors(show);
    }-*/;

	/**
     * Clear any validation errors on the field passed in.
     * @param fieldName field to clear errors from
     * @param show If true this method will fall through to {@link com.smartgwt.client.widgets.form.DynamicForm#showFieldErrors
     * showFieldErrors()}  to update the display
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void clearFieldErrors(String fieldName, boolean show) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearFieldErrors", "String,boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearFieldErrors(fieldName, show);
    }-*/;

	/**
     * Clears the value for some field via a call to {@link com.smartgwt.client.widgets.form.fields.FormItem#clearValue
     * FormItem.clearValue()} if appropriate. If there is no item associated with the field name, the field will just be
     * cleared within our stored set of values.
     * @param fieldName Name of the field being cleared. A {@link com.smartgwt.client.docs.DataPath} may be used for  clearing details of nested
     * data structures.
     */
    public native void clearValue(String fieldName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearValue", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearValue(fieldName);
    }-*/;

	/**
     * Reset to default form values and clear errors
     */
    public native void clearValues() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearValues", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearValues();
    }-*/;

	/**
     * Finish editing and store edited values in {@link com.smartgwt.client.util.workflow.Process#getState process state}.
     */
    public native void completeEditing() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "completeEditing", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.completeEditing();
    }-*/;

	/**
     * Prepare to edit a new record by clearing the current set of values (or replacing them  with initialValues if specified).
     * <br> This method will also call {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType
     * setSaveOperationType()} to ensure subsequent calls to <code>saveData()</code> will use an <code>add</code> rather than
     * an <code>update</code> operation.
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editNewRecord() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editNewRecord", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editNewRecord();
    }-*/;

	/**
     * Prepare to edit a new record by clearing the current set of values (or replacing them  with initialValues if specified).
     * <br> This method will also call {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType
     * setSaveOperationType()} to ensure subsequent calls to <code>saveData()</code> will use an <code>add</code> rather than
     * an <code>update</code> operation.
     * @param initialValues initial set of values for the editor as a map of field names to their corresponding     values
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editNewRecord(Map initialValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editNewRecord", "Map");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editNewRecord(initialValues == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(initialValues));
    }-*/;

	/**
     * Prepare to edit a new record by clearing the current set of values (or replacing them  with initialValues if specified).
     * <br> This method will also call {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType
     * setSaveOperationType()} to ensure subsequent calls to <code>saveData()</code> will use an <code>add</code> rather than
     * an <code>update</code> operation.
     * @param initialValues initial set of values for the editor as a map of field names to their corresponding     values
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editNewRecord(Record initialValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editNewRecord", "Record");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editNewRecord(initialValues.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Edit an existing record.  Updates this editors values to match the values of the record  passed in, via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues setValues()}. <P> This method will also call {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType setSaveOperationType()} to ensure  subsequent calls to
     * <code>saveData()</code> will use an <code>update</code> rather than an <code>add</code> operation.
     * @param record the record to be edited as a map of field names to their corresponding values
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editRecord(Record record) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editRecord", "Record");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the "schema"
     * argument, call fetchData() to retrieve records in this data set that are related to the passed-in record. <P>
     * Relationships between DataSources are declared via {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * DataSourceField.foreignKey}. <P> For example, given two related DataSources "orders" and "orderItems", where we want to
     * fetch the "orderItems" that belong to a given "order".  "orderItems" should declare a field that is a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} to the "orders" table (for example, it might be named
     * "orderId" with foreignKey="orders.id").  Then, to load the records related to a given "order", call fetchRelatedData()
     * on the component bound to "orderItems", pass the "orders" DataSource as the "schema" and pass a record from the "orders"
     * DataSource as the "record" argument.
     * @param record DataSource record
     * @param schema schema of the DataSource record, or                            DataBoundComponent already bound to that schema
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchRelatedData(ListGridRecord record, Canvas schema) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchRelatedData", "ListGridRecord,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchRelatedData(record.@com.smartgwt.client.core.DataClass::getJsObj()(), schema == null ? null : schema.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * @see DynamicForm#fetchRelatedData
     */
    public void fetchRelatedData(ListGridRecord record, Canvas schema, DSCallback callback){
        fetchRelatedData(record, schema, callback, null);
    }

	/**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the "schema"
     * argument, call fetchData() to retrieve records in this data set that are related to the passed-in record. <P>
     * Relationships between DataSources are declared via {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * DataSourceField.foreignKey}. <P> For example, given two related DataSources "orders" and "orderItems", where we want to
     * fetch the "orderItems" that belong to a given "order".  "orderItems" should declare a field that is a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} to the "orders" table (for example, it might be named
     * "orderId" with foreignKey="orders.id").  Then, to load the records related to a given "order", call fetchRelatedData()
     * on the component bound to "orderItems", pass the "orders" DataSource as the "schema" and pass a record from the "orders"
     * DataSource as the "record" argument.
     * @param record DataSource record
     * @param schema schema of the DataSource record, or                            DataBoundComponent already bound to that schema
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchRelatedData(ListGridRecord record, Canvas schema, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchRelatedData", "ListGridRecord,Canvas,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchRelatedData(record.@com.smartgwt.client.core.DataClass::getJsObj()(), schema == null ? null : schema.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Can the field be edited?  This method looks at {@link com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit}
     * for the grid as well as the {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} value,
     * to determine whether editing is actually allowed. For a detailed discussion, see the documentation at {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit}.
     * @param field field object or identifier
     *
     * @return whether field can be edited
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native boolean fieldIsEditable(FormItem field) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fieldIsEditable", "FormItem");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.fieldIsEditable(field.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

	/**
     * Can the field be edited?  This method looks at {@link com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit}
     * for the grid as well as the {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} value,
     * to determine whether editing is actually allowed. For a detailed discussion, see the documentation at {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit}.
     * @param field field object or identifier
     *
     * @return whether field can be edited
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native boolean fieldIsEditable(int field) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fieldIsEditable", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.fieldIsEditable(field);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Can the field be edited?  This method looks at {@link com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit}
     * for the grid as well as the {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} value,
     * to determine whether editing is actually allowed. For a detailed discussion, see the documentation at {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit}.
     * @param field field object or identifier
     *
     * @return whether field can be edited
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native boolean fieldIsEditable(String field) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fieldIsEditable", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.fieldIsEditable(field);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Give keyboard focus to this form. If this form has had focus before, focus will be passed to the item which last had
     * focus (see {@link com.smartgwt.client.widgets.form.DynamicForm#getFocusItem getFocusItem()}) -  otherwise focus will be
     * passed to the first focusable item in the form. <P> To put focus in a specific item, use {@link
     * com.smartgwt.client.widgets.form.DynamicForm#focusInItem focusInItem()} instead.
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public native void focus() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "focus", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.focus();
    }-*/;

    /**
     * Add a formSubmitFailed handler.
     * <p>
     * Method called when an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm natively submit} a form
     * is unable to submit to the server. Default behavior is to display the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getFormSubmitFailedWarning DynamicForm.formSubmitFailedWarning} in a
     * warning dialog. The most common cause for this failure is that the user has typed an invalid file-path into an upload
     * type field. <P> <b>Note:</b> This is very unlikely to occur with modern versions of IE, which don't allow the path of a
     * file to be edited by hand (only selected via file navigation).  It was last seen in IE6-7 under Windows XP. <P> Rather
     * than throwing an exception on the client during submit(), normally all failures in native form submission are handled by
     * the server.  For further information, see {@link com.smartgwt.client.docs.Upload File Uploading}.
     *
     * @param handler the formSubmitFailed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFormSubmitFailedHandler(com.smartgwt.client.widgets.form.events.FormSubmitFailedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent.getType()) == 0) setupFormSubmitFailedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent.getType());
    }

    private native void setupFormSubmitFailedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var formSubmitFailed = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownFormSubmitFailedEvent()();
            if (hasDefaultHandler) this.Super("formSubmitFailed", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("formSubmitFailed"));
            obj.addProperties({formSubmitFailed:  formSubmitFailed              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("formSubmitFailed"));
            obj.formSubmitFailed =  formSubmitFailed             ;
        }
    }-*/;

    private void handleTearDownFormSubmitFailedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent.getType()) == 0) tearDownFormSubmitFailedEvent();
    }

    private native void tearDownFormSubmitFailedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("formSubmitFailed")) delete obj.formSubmitFailed;
    }-*/;

	/**
     * If the current mouse event occurred over an item in this dynamicForm, returns that item.
     *
     * @return the current event target item
     */
    public native FormItem getEventItem() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventItem", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventItem();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return the current focus item for this form.  <P> This is the item which either currently has focus, or if focus is not
     * currently within this form, would be given focus on a call to {@link com.smartgwt.client.widgets.form.DynamicForm#focus
     * focus()}. May return null if this form has never had focus, in which case a call to <code>form.focus()</code> would put
     * focus into the  first focusable item within the the form. <P> Note that if focus is currently in a sub-item of a
     * ContainerItem, this method will return the parent ContainerItem, not the sub-item.
     *
     * @return Current focus item within this form. May be null.
     * @see com.smartgwt.client.widgets.form.DynamicForm#isFocused
     * @see com.smartgwt.client.widgets.form.fields.FormItem#isFocused
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public native FormItem getFocusItem() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFocusItem", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFocusItem();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return an AdvancedCriteria object based on the current set of values within this form. <p> Similar to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria getValuesAsCriteria()}, except the returned criteria
     * object is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator FormItem.operator}
     *
     * @return a {@link com.smartgwt.client.data.AdvancedCriteria} based on the form's current values
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native AdvancedCriteria getValuesAsAdvancedCriteria() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getValuesAsAdvancedCriteria", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getValuesAsAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return an AdvancedCriteria object based on the current set of values within this form. <p> Similar to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria getValuesAsCriteria()}, except the returned criteria
     * object is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator FormItem.operator}
     * @param textMatchStyle If specified the text match style will be used to   generate the appropriate <code>operator</code> for per field
     * criteria.
     *
     * @return a {@link com.smartgwt.client.data.AdvancedCriteria} based on the form's current values
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native AdvancedCriteria getValuesAsAdvancedCriteria(TextMatchStyle textMatchStyle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getValuesAsAdvancedCriteria", "TextMatchStyle");
        }
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var handleAsyncValidationReply = $entry(function(){
            var param = {"_this": this, "success" : arguments[0], "errors" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.events.AsyncValidationReplyEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownAsyncValidationReplyEvent()();
            if (hasDefaultHandler) this.Super("handleAsyncValidationReply", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("handleAsyncValidationReply"));
            obj.addProperties({handleAsyncValidationReply:  handleAsyncValidationReply              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("handleAsyncValidationReply"));
            obj.handleAsyncValidationReply =  handleAsyncValidationReply             ;
        }
    }-*/;

    private void handleTearDownAsyncValidationReplyEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.AsyncValidationReplyEvent.getType()) == 0) tearDownAsyncValidationReplyEvent();
    }

    private native void tearDownAsyncValidationReplyEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("handleAsyncValidationReply")) delete obj.handleAsyncValidationReply;
    }-*/;

    /**
     * Add a hiddenValidationErrors handler.
     * <p>
     * Method to display validation error messages for fields that are not currently visible  in this form.<br> This will be
     * called when validation fails for<br> - a hidden field in this form<br> - if this form is databound, a datasource field
     * with specified validators, for which we   have no specified form item.<br> Implement this to provide custom validation
     * error handling for these fields.<br> By default hidden validation errors will be logged as warnings in the
     * developerConsole. Call {@link com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent#cancel()} from within
     * {@link com.smartgwt.client.widgets.form.events.HiddenValidationErrorsHandler#onHiddenValidationErrors} from this method
     * to suppress that behavior.
     *
     * @param handler the hiddenValidationErrors handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addHiddenValidationErrorsHandler(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType()) == 0) setupHiddenValidationErrorsEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType());
    }

    private native void setupHiddenValidationErrorsEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var handleHiddenValidationErrors = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownHiddenValidationErrorsEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("handleHiddenValidationErrors"));
            obj.addProperties({handleHiddenValidationErrors: 
                function () {
                    var param = {"_this": this, "errors" : arguments[0]};
                    var ret = handleHiddenValidationErrors(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("handleHiddenValidationErrors", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("handleHiddenValidationErrors"));
            obj.handleHiddenValidationErrors = 
                function () {
                    var param = {"_this": this, "errors" : arguments[0]};
                    var ret = handleHiddenValidationErrors(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("handleHiddenValidationErrors", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownHiddenValidationErrorsEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType()) == 0) tearDownHiddenValidationErrorsEvent();
    }

    private native void tearDownHiddenValidationErrorsEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("handleHiddenValidationErrors")) delete obj.handleHiddenValidationErrors;
    }-*/;

	/**
     * Returns whether there are currently any errors visible to the user for this form, without performing validation. <P>
     * Note that validation errors are set up automatically by validation (see {@link
     * com.smartgwt.client.widgets.form.DynamicForm#validate validate()}), or may be explicitly set via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setErrors setErrors()} or  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors setFieldErrors()}.
     *
     * @return true if the form currently has validation errors.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native Boolean hasErrors() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasErrors", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hasErrors();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns whether there are currently any errors visible to the user for the specified field in this form, without
     * performing any validation. <P> Note that validation errors are set up automatically by validation (see {@link
     * com.smartgwt.client.widgets.form.DynamicForm#validate validate()}), or may be explicitly set via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setErrors setErrors()} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors setFieldErrors()}.
     * @param fieldName field to test for validation errors
     *
     * @return true if the form has outstanding errors for the field in question.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native Boolean hasFieldErrors(String fieldName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasFieldErrors", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hasFieldErrors(fieldName);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Hide a form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#hide FormItem.hide()}
     * @param itemName Name of the item to show
     */
    public native void hideItem(String itemName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideItem", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideItem(itemName);
    }-*/;

	/**
     * Returns true if this DynamicForm has the keyboard focus. <P> Unlike standard canvases, for a DynamicForm this method
     * will return true when keyboard focus is currently on one of the form's {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItems items}. <P> Note that in some cases the items of a form may be
     * written directly into a different {@link com.smartgwt.client.widgets.form.fields.FormItem#getContainerWidget canvas}. In
     * this case the dynamicForm containing the items may not have been drawn on the page itself, but this method can still
     * return true if one of the items has focus.
     *
     * @return whether focus is currently in one of this form's items.
     */
    public native Boolean isFocused() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isFocused", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isFocused();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType} is currently
     * "add".  See {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType}.
     *
     * @return whether this form will use an "add" operation when saving
     */
    public native Boolean isNewRecord() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isNewRecord", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isNewRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Is this component waiting for an asynchronous validation to complete? This method will return true after {@link
     * com.smartgwt.client.widgets.form.DynamicForm#validate validate()} is called on a component with server-side validators
     * for some field(s), until the server responds. <P> Note that the notification method {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addAsyncValidationReplyHandler DynamicForm.asyncValidationReply()} will be
     * fired when validation completes.
     *
     * @return true if this widget has pending asynchronous validations in process
     */
    public native Boolean isPendingAsyncValidation() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isPendingAsyncValidation", "");
        }
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var itemChange = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.events.ItemChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownItemChangeEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("itemChange"));
            obj.addProperties({itemChange: 
                function () {
                    var param = {"_this": this, "item" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2]};
                    var ret = itemChange(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("itemChange", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("itemChange"));
            obj.itemChange = 
                function () {
                    var param = {"_this": this, "item" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2]};
                    var ret = itemChange(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("itemChange", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownItemChangeEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.ItemChangeEvent.getType()) == 0) tearDownItemChangeEvent();
    }

    private native void tearDownItemChangeEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("itemChange")) delete obj.itemChange;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var itemChanged = $entry(function(){
            var param = {"_this": this, "item" : arguments[0], "newValue" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.events.ItemChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownItemChangedEvent()();
            if (hasDefaultHandler) this.Super("itemChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("itemChanged"));
            obj.addProperties({itemChanged:  itemChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("itemChanged"));
            obj.itemChanged =  itemChanged             ;
        }
    }-*/;

    private void handleTearDownItemChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.ItemChangedEvent.getType()) == 0) tearDownItemChangedEvent();
    }

    private native void tearDownItemChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("itemChanged")) delete obj.itemChanged;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var itemKeyPress = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.events.ItemKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownItemKeyPressEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("itemKeyPress"));
            obj.addProperties({itemKeyPress: 
                function () {
                    var param = {"_this": this, "item" : arguments[0], "keyName" : arguments[1], "characterValue" : arguments[2]};
                    var ret = itemKeyPress(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("itemKeyPress", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("itemKeyPress"));
            obj.itemKeyPress = 
                function () {
                    var param = {"_this": this, "item" : arguments[0], "keyName" : arguments[1], "characterValue" : arguments[2]};
                    var ret = itemKeyPress(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("itemKeyPress", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownItemKeyPressEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.ItemKeyPressEvent.getType()) == 0) tearDownItemKeyPressEvent();
    }

    private native void tearDownItemKeyPressEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("itemKeyPress")) delete obj.itemKeyPress;
    }-*/;

	/**
     * Resets values to the state it was the last time <code>setValues()</code> or <code>rememberValues()</code> was called. If
     * neither of those methods has been called, values will be set back to their initial values at init time.
     */
    public native void reset() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reset", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reset();
    }-*/;

	/**
     * Same as {@link com.smartgwt.client.widgets.form.DynamicForm#reset reset()}.
     */
    public native void resetValues() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resetValues", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resetValues();
    }-*/;

	/**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is bound
     * to. <p> If client-side validators are defined, they are executed first, and if any errors are found the save is aborted
     * and the form will show the errors. <p> If client-side validation passes, a {@link com.smartgwt.client.data.DSRequest}
     * will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()} or {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData()} had been called with  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues the form's values} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType DSRequest.operationType} will be either "update" or "add", depending
     * on the current {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType}. <P> On
     * either a client-side or server-side validation failure, validation errors will be displayed in the form.  Visible items
     * within a DynamicForm will be redrawn to display errors. Validation failure occurring on hidden items, or DataSource
     * fields with no  associated form items may be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHiddenValidationErrorsHandler DynamicForm.hiddenValidationErrors()} or
     * {@link com.smartgwt.client.widgets.form.ValuesManager#addHiddenValidationErrorsHandler
     * ValuesManager.hiddenValidationErrors()}. <P> In the case of a validation error, the callback will <b>not</b> be called
     * by default since the form has already handled the failed save by displaying the validation errors to the user.  If you
     * need to do something additional in this case, you can set {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError
     * RPCRequest.willHandleError} via the <code>requestProperties</code> parameter to force your callback to be invoked. 
     * However, first consider: <ul> <li> if you are trying to customize display of validation errors, there are several {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons built-in modes} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors showErrors()} may be a better place to put customizations. <li>
     * for unrecoverable general errors (eg server is down), {@link com.smartgwt.client.rpc.HandleErrorCallback#handleError
     * central error handling} in invoked, so consider placing customizations there unless an unrecoverable error should be
     * handled specially by this specific form. </ul>
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_grid_form_category" target="examples">Add Example</a>
     */
    public native void saveData() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "saveData", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData();
    }-*/;

    /**
     * @see DynamicForm#saveData
     */
    public void saveData(DSCallback callback){
        saveData(callback, null);
    }

	/**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is bound
     * to. <p> If client-side validators are defined, they are executed first, and if any errors are found the save is aborted
     * and the form will show the errors. <p> If client-side validation passes, a {@link com.smartgwt.client.data.DSRequest}
     * will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()} or {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData()} had been called with  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues the form's values} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType DSRequest.operationType} will be either "update" or "add", depending
     * on the current {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType}. <P> On
     * either a client-side or server-side validation failure, validation errors will be displayed in the form.  Visible items
     * within a DynamicForm will be redrawn to display errors. Validation failure occurring on hidden items, or DataSource
     * fields with no  associated form items may be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHiddenValidationErrorsHandler DynamicForm.hiddenValidationErrors()} or
     * {@link com.smartgwt.client.widgets.form.ValuesManager#addHiddenValidationErrorsHandler
     * ValuesManager.hiddenValidationErrors()}. <P> In the case of a validation error, the callback will <b>not</b> be called
     * by default since the form has already handled the failed save by displaying the validation errors to the user.  If you
     * need to do something additional in this case, you can set {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError
     * RPCRequest.willHandleError} via the <code>requestProperties</code> parameter to force your callback to be invoked. 
     * However, first consider: <ul> <li> if you are trying to customize display of validation errors, there are several {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons built-in modes} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors showErrors()} may be a better place to put customizations. <li>
     * for unrecoverable general errors (eg server is down), {@link com.smartgwt.client.rpc.HandleErrorCallback#handleError
     * central error handling} in invoked, so consider placing customizations there unless an unrecoverable error should be
     * handled specially by this specific form. </ul>
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_grid_form_category" target="examples">Add Example</a>
     */
    public native void saveData(DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "saveData", "DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData(
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Sets the value for some field
     * @param fieldName Name of the field being updated. A {@link com.smartgwt.client.docs.DataPath} may                           be passed to
     * set nested values
     * @param value New value.
     */
    public native void setValue(String fieldName, String value) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setValue", "String,String");
        }
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
     * FormItem.shouldSaveValue} is true for the item and   {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#canEditCriterion FormItem.canEditCriterion()} returns true for the
     * criterion in question. By default  this method checks for a match with both the <code>fieldName</code> and
     * <code>operator</code>  of the criterion. The criterion is actually passed to the item for editing via    the
     * <code>FormItemCriterionSetter</code>'s <code>setCriterion()</code> method.  Note that these methods may be overridden
     * for custom  handling. Also note that the default   <code>FormItemCriterionSetter.setCriterion()</code> implementation 
     * used by {@link com.smartgwt.client.widgets.form.fields.CanvasItem} handles editing nested criteria via embedded
     * dynamicForms.</li> <li>Criteria which don't map to any form item will be stored directly on the form and  recombined
     * with the edited values from each item when {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * getValuesAsCriteria()} is  called.</li> </ul>
     * @param criteria criteria to edit.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native void setValuesAsCriteria(Criterion criteria) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setValuesAsCriteria", "Criterion");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValuesAsCriteria(criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * If this form has any outstanding validation errors for the field passed in, show them now. Called when field errors are
     * set directly via {@link com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors setFieldErrors()} /  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addFieldErrors addFieldErrors()} / {@link
     * com.smartgwt.client.widgets.form.DynamicForm#clearFieldErrors clearFieldErrors()}.<br> Default implementation simply
     * falls through to {@link com.smartgwt.client.widgets.form.DynamicForm#showErrors showErrors()}.
     * @param fieldName field to show errors for
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void showFieldErrors(String fieldName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showFieldErrors", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showFieldErrors(fieldName);
    }-*/;

	/**
     * Show a form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#show FormItem.show()}
     * @param itemName Name of the item to show
     */
    public native void showItem(String itemName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showItem", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showItem(itemName);
    }-*/;

	/**
     * Called when the mouse is right-clicked in some formItem.  If the implementation returns false, default browser behavior
     * is cancelled. <P>  Note that it can be bad practice to cancel this method if the mouse is over the data  element of an
     * item, because doing so would replace the builtin browser-default menus  that users may expect.  You can use {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getEventItemInfo getEventItemInfo()} to return an   info object that can be
     * used to determine which part of the  item is under the mouse.
     * @param item the form item showing its context menu
     *
     * @return return false to cancel default behavior
     */
    public native boolean showItemContextMenu(FormItem item) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showItemContextMenu", "FormItem");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.showItemContextMenu(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

	/**
     * Helper method to take our specified items and sort them into their desired tab sequence <P> Default behavior will
     * respect explicitly specified tab index as a local tab index, otherwise just use specified order within the items array
     *
     * @return Returns an array containing our items in the desired tab sequence.
     */
    public native FormItem[] sortItemsIntoTabOrder() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "sortItemsIntoTabOrder", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sortItemsIntoTabOrder();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfFormItem(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem} included
     * in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is set,
     * when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If this form is part of a
     * {@link com.smartgwt.client.widgets.form.ValuesManager}, this method will simply fall through to the submit method on the
     * valuesManager. If not, and {@link com.smartgwt.client.widgets.form.DynamicForm#addSubmitValuesHandler
     * form.submitValues()} exists, it will be called, and no further action will be taken. <P> Otherwise, default behavior
     * varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit form.canSubmit}: if
     * <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} will be called
     * to handle saving via Smart GWT databinding.   <P> If <code>canSubmit</code> is true, the form will be submitted like an
     * ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm submitForm()}. <P> The parameters
     * to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()}.  If you override <code>submit()</code>, you can
     * safely ignore the parameters as Smart GWT framework code does not pass them.
     * @see com.smartgwt.client.widgets.form.events.SubmitValuesEvent
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void submit() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "submit", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submit();
    }-*/;

    /**
     * @see DynamicForm#submit
     */
    public void submit(DSCallback callback){
        submit(callback, null);
    }

	/**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem} included
     * in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is set,
     * when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If this form is part of a
     * {@link com.smartgwt.client.widgets.form.ValuesManager}, this method will simply fall through to the submit method on the
     * valuesManager. If not, and {@link com.smartgwt.client.widgets.form.DynamicForm#addSubmitValuesHandler
     * form.submitValues()} exists, it will be called, and no further action will be taken. <P> Otherwise, default behavior
     * varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit form.canSubmit}: if
     * <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} will be called
     * to handle saving via Smart GWT databinding.   <P> If <code>canSubmit</code> is true, the form will be submitted like an
     * ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm submitForm()}. <P> The parameters
     * to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()}.  If you override <code>submit()</code>, you can
     * safely ignore the parameters as Smart GWT framework code does not pass them.
     * @param callback callback to invoke on completion.                                          [Ignored if this.canSubmit is true]
     * @param requestProperties additional properties to set on the DSRequest                                          that will be issued              
     *                            [Ignored if this.canSubmit is true]
     * @see com.smartgwt.client.widgets.form.events.SubmitValuesEvent
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void submit(DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "submit", "DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submit(
			$entry( function(dsResponse, data, dsRequest) { 
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
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue FormItem.defaultValue} set.  This is analogous to
     * &lt;input type="hidden"&gt; in HTML forms. </ul>
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     */
    public native void submitForm() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "submitForm", "");
        }
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var submitValues = $entry(function(){
            var param = {"_this": this, "values" : arguments[0], "form" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.events.SubmitValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownSubmitValuesEvent()();
            if (hasDefaultHandler) this.Super("submitValues", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("submitValues"));
            obj.addProperties({submitValues:  submitValues              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("submitValues"));
            obj.submitValues =  submitValues             ;
        }
    }-*/;

    private void handleTearDownSubmitValuesEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.SubmitValuesEvent.getType()) == 0) tearDownSubmitValuesEvent();
    }

    private native void tearDownSubmitValuesEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("submitValues")) delete obj.submitValues;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "titleClipped", "FormItem");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleClipped(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

	/**
     * Validates the form without submitting it, and redraws the form to display error messages if there are any validation
     * errors. Returns true if validation succeeds, or false if validation fails. <P> For databound forms, any {@link
     * com.smartgwt.client.data.DataSource} field validators will be run even if there is no associated item in the form. 
     * Validators will also be run on hidden form items.  In both these cases, validation failure can be handled via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHiddenValidationErrorsHandler DynamicForm.hiddenValidationErrors()}. <P>
     * If this form has any fields which require server-side validation (see  {@link
     * com.smartgwt.client.docs.serverds.Validator#serverCondition Validator.serverCondition}) this will also be initialized.
     * Such validation will occur asynchronously.  Developers can use {@link
     * com.smartgwt.client.widgets.form.DynamicForm#isPendingAsyncValidation isPendingAsyncValidation()} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addAsyncValidationReplyHandler DynamicForm.asyncValidationReply()} to
     * detect and respond to asynchronous validation. <P> Note that for silent validation, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valuesAreValid valuesAreValid()} (client-side) and  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#checkForValidationErrors checkForValidationErrors()} (client and
     * server-side) can be used instead.
     *
     * @return true if validation succeeds, or false if validation fails.
     * @see com.smartgwt.client.widgets.form.ValuesManager#validate
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_type" target="examples">Type Example</a>
     */
    public native boolean validate() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "validate", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validate();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Validates the form without submitting it, and redraws the form to display error messages if there are any validation
     * errors. Returns true if validation succeeds, or false if validation fails. <P> For databound forms, any {@link
     * com.smartgwt.client.data.DataSource} field validators will be run even if there is no associated item in the form. 
     * Validators will also be run on hidden form items.  In both these cases, validation failure can be handled via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHiddenValidationErrorsHandler DynamicForm.hiddenValidationErrors()}. <P>
     * If this form has any fields which require server-side validation (see  {@link
     * com.smartgwt.client.docs.serverds.Validator#serverCondition Validator.serverCondition}) this will also be initialized.
     * Such validation will occur asynchronously.  Developers can use {@link
     * com.smartgwt.client.widgets.form.DynamicForm#isPendingAsyncValidation isPendingAsyncValidation()} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addAsyncValidationReplyHandler DynamicForm.asyncValidationReply()} to
     * detect and respond to asynchronous validation. <P> Note that for silent validation, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valuesAreValid valuesAreValid()} (client-side) and  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#checkForValidationErrors checkForValidationErrors()} (client and
     * server-side) can be used instead.
     * @param validateHiddenFields Should validators be processed for non-visible fields         such as dataSource fields with no associated item or
     * fields with visibility set to         <code>"hidden"</code>?
     *
     * @return true if validation succeeds, or false if validation fails.
     * @see com.smartgwt.client.widgets.form.ValuesManager#validate
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_type" target="examples">Type Example</a>
     */
    public native boolean validate(boolean validateHiddenFields) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "validate", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validate(validateHiddenFields);
        return ret == null ? false : ret;
    }-*/;
	
    /**
     * @see DynamicForm#validateData
     */
    public boolean validateData(DSCallback callback){
        return validateData(callback, null);
    }

	/**
     * <code>validateData()</code> can be used to check for errors in server-side validators  without showing such errors to
     * the user.  Errors, if any, can be discovered by looking at the <code>DSResponse</code> object returned in the callback.
     * <p> <code>validateData()</code> will first call {@link com.smartgwt.client.widgets.form.DynamicForm#validate validate()}
     * to check for client-side errors, and will return <code>false</code> without contacting the server if errors are present.
     * In this case, any errors detected client-side will be displayed; to avoid this and purely perform silent, server-side
     * validation, you can use  {@link com.smartgwt.client.data.DataSource#validateData DataSource.validateData()} with the
     * form's {@link com.smartgwt.client.widgets.form.DynamicForm#getValues current values}. {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valuesAreValid valuesAreValid()} can be used in lieu of a call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#validate validate()} if silent checking of client-side errors is also
     * desired.
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                   the DSRequest that will be issued
     *
     * @return true if the server will be contacted, false otherwise
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native boolean validateData(DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "validateData", "DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validateData(
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;
	
	/**
     * Method to determine whether the current form values would pass validation. This method operates client-side, without
     * contacting the server, running validators on the form's values and returning a value indicating whether validation was
     * successful.   <P> Unlike {@link com.smartgwt.client.widgets.form.DynamicForm#validate validate()} this method will not
     * store the errors on the DynamicForm or display them to the user. <P> Note that {@link
     * com.smartgwt.client.widgets.form.DynamicForm#checkForValidationErrors checkForValidationErrors()} allows for checking
     * for server-side errors, and finding out what those errors are via a callback.
     * @param validateHiddenFields Should validators be processed for non-visible fields         such as dataSource fields with no associated item or
     * fields with visibility set to         <code>"hidden"</code>?
     *
     * @return Boolean value indicating validation success, or if  <code>returnErrors</code> was specified,  a map of field names to
     * the associated errors, for those fields that failed validation, or null if validation succeeded.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native boolean valuesAreValid(boolean validateHiddenFields) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "valuesAreValid", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.valuesAreValid(validateHiddenFields);
        return ret == null ? false : ret;
    }-*/;

    /**
     * Add a valuesChanged handler.
     * <p>
     * Handler fired when the entire set of values is replaced, as by a call to  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#resetValues DynamicForm.resetValues()} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()}. <P> Note that it is invalid to call
     * such methods from this handler because doing so would  result in an infinite loop.
     *
     * @param handler the valuesChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValuesChangedHandler(com.smartgwt.client.widgets.form.events.ValuesChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ValuesChangedEvent.getType()) == 0) setupValuesChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ValuesChangedEvent.getType());
    }

    private native void setupValuesChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var valuesChanged = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.form.events.ValuesChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.DynamicForm::handleTearDownValuesChangedEvent()();
            if (hasDefaultHandler) this.Super("valuesChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("valuesChanged"));
            obj.addProperties({valuesChanged:  valuesChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("valuesChanged"));
            obj.valuesChanged =  valuesChanged             ;
        }
    }-*/;

    private void handleTearDownValuesChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.ValuesChangedEvent.getType()) == 0) tearDownValuesChangedEvent();
    }

    private native void tearDownValuesChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("valuesChanged")) delete obj.valuesChanged;
    }-*/;

	/**
     * Compares the current set of values with the values stored by the call to the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#rememberValues rememberValues()} method.  <code>rememberValues()</code>
     * runs when the form is initialized and on every call to {@link com.smartgwt.client.widgets.form.DynamicForm#setValues
     * setValues()}. Returns true if the values have changed, and false otherwise.
     *
     * @return true if current values do not match remembered values
     * @see com.smartgwt.client.widgets.form.DynamicForm#getChangedValues
     * @see com.smartgwt.client.widgets.form.DynamicForm#getOldValues
     */
    public native Boolean valuesHaveChanged() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "valuesHaveChanged", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.valuesHaveChanged();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param dynamicFormProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DynamicForm dynamicFormProperties) /*-{
        if (dynamicFormProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DynamicForm.@java.lang.Object::getClass()(), "setDefaultProperties", dynamicFormProperties.@java.lang.Object::getClass()());
        }
        dynamicFormProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = dynamicFormProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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
        if(self._showErrors) {
        	self._showErrors();
        } else {
        	self.showErrors();
        }
    }-*/;

    private void linkFields() {
        if (fields == null) return;

        for (FormItem field : fields) {
            if (field.isConfigOnly()) {
                ConfigUtil.warnOfPostConfigInstantiation(this.getClass(), "linkFields", "");
            }
            JavaScriptObject fieldJS = getFieldJS(field.getName());
            field.setJavaScriptObject(fieldJS);
        }
    }

    private native JavaScriptObject getFieldJS(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldJS = self.getField(fieldName);
        return fieldJS;
    }-*/;

    /**
     * Adds this DynamicForm as a member of the specified valuesManager.  After init, this
     * method is functionally equivalent to <code>valuesManager.addMember(form)</code> and
     * <code>valuesManager.removeMember(form)</code> <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param valuesManager valuesManager Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValuesManager(ValuesManager valuesManager) throws IllegalStateException {
        setAttribute("valuesManager", valuesManager.getOrCreateJsObj(), true);
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
     * An array of field objects, specifying the order, layout, and types of each field in the
     * DynamicForm. When both {@link #setFields fields} and {@link #setDataSource dataSource}
     * are set, {@link #setFields fields} acts as a set of overrides as explained in
     * DataBoundComponent fields.  <p/> See Form Layout for information about how flags
     * specified on the FormItems control how the form is laid out.
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
     * Return the form fields.
     * <P>
     * If you've installed the fields as JavaScriptObjects using
     * {@link #setFields(JavaScriptObject...) setFields()}, it's not recommended to call this method
     * or otherwise try to access the fields as
     * {@link com.smartgwt.client.widgets.form.fields.FormItem FormItem}s before the DynamicForm
     * has been {@link com.smartgwt.client.widgets.BaseWidget#isCreated created}, as this may
     * result in the incorrect subclass of FormItem being built.  Instead, use 
     * {@link #getFieldsAsJavaScriptObjects getFieldsAsJavaScriptObjects()}.
     * <P>
     * If the situation is unavoidable, you can set the "editorType" attribute of the
     * JavaScriptObject field to the desired subclass to ensure it will be used.
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
            if (fieldJS != null) return FormItemFactory.getFormItem(fieldJS, getJsObj());
        }
        return null;
    }

    public native String getValueAsString(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null ? null : val.toString();
    }-*/;

    public native Object getValue(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null ? null : $wnd.SmartGWT.convertToJavaType(val);
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
        return val == null ? null : @com.smartgwt.client.widgets.form.FormItemEventInfo::new(Lcom/google/gwt/core/client/JavaScriptObject;)(val);
    }-*/;

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
        if(!@com.smartgwt.client.util.JSOHelper::isArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value)) {
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
        
    /**
     * Call this method passing true to skip conversion of the Javascript object to a Java Map when 
     * calling the mapDisplayToValue() API.  By default, we do convert the value, and 
     * your methods will be returned a Java Map of native Java types.  Passing true to this method 
     * switches off conversion, and your methods will be passed a JavaScriptObject
     * @param convert Whether the mapDisplayTovalue() method should skip conversion of its return value to a native Java Map
     */
    public static void setSkipConversionOnMapping(Boolean convert) {
        _setSkipConversionOnMapping(Boolean.TRUE.equals(convert));
    }
    private static native void _setSkipConversionOnMapping(boolean convert) /*-{
        $wnd.isc.DynamicForm._skipConversionOnMapping = convert;
    }-*/;
    /**
     * Returns true if the system is set to skip conversion of the Javascript object to a Java Map when 
     * calling the mapDisplayToValue() API. See {@link com.smartgwt.client.widgets.form.DynamicForm#setSkipConversionOnMapping}
     * @return Boolean indicating whether the mapDisplayTovalue() method will skip conversion of its return value to a native Java Map
     */
    public static native Boolean getSkipConversionOnMapping() /*-{
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)($wnd.isc.DynamicForm._skipConversionOnMapping);
    }-*/;




    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        Integer dataPageSize = getAttributeAsInt("dataPageSize");
        return dataPageSize == null ? 0 : dataPageSize;
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

    public void setExportIncludeSummaries(Boolean exportIncludeSummaries) {
        setAttribute("exportIncludeSummaries", exportIncludeSummaries, true);
    }

    public Boolean getExportIncludeSummaries() {
        return getAttributeAsBoolean("exportIncludeSummaries");
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

    /**
     * Indicates whether or not this component will load its data {@link DataSource#setProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading  
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @param progressiveLoading
     */
    public void setProgressiveLoading(Boolean progressiveLoading) {
        setAttribute("progressiveLoading", progressiveLoading, false);
    }

    /**
     * Indicates whether or not this component will load its data {@link DataSource#getProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @return
     */
    public Boolean getProgressiveLoading() {
        return getAttributeAsBoolean("progressiveLoading");
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordsJS == null ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
    
    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
         if(retVal == null) {
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

    public native DataSource getDataSource() /*-{
        var dataSourceJS = this.@com.smartgwt.client.widgets.grid.ListGrid::getAttributeAsJavaScriptObject(Ljava/lang/String;)("dataSource");
        if ($wnd.isc.isA.String(dataSourceJS)) dataSourceJS = $wnd.isc.DataSource.get(dataSourceJS);
        return @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceJS);
    }-*/;

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

    public void setImplicitCriteria(Criteria implicitCriteria) {
        if (implicitCriteria instanceof Criterion) {
            implicitCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("implicitCriteria", implicitCriteria == null ? 
                     null : implicitCriteria.getJsObj(), true);
    }

    public Criteria getImplicitCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("implicitCriteria"));
    }
    
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
    	if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        return ResultSet.getOrCreateRef(dataJS);
    }

    public native RecordList getRecordList() /*-{
        var dataJS = this.@com.smartgwt.client.widgets.DataBoundComponent::getDataAsJSList()();
        if (dataJS == null) return null;
        if ($wnd.isc.isA.ResultSet(dataJS)) {
            return this.@com.smartgwt.client.widgets.DataBoundComponent::getResultSet()();
        } else if ($wnd.isc.isA.ResultTree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.ResultTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        } else if ($wnd.isc.isA.Tree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        }
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
    }-*/;

    public native JavaScriptObject getDataAsJSList() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
    	if (self == null) return null;
    	return self.getDataAsList();
    	
    }-*/;

    public void exportData() {
        exportData(null);
    }

    public native void exportData(DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


    public native void exportData(DSRequest requestProperties, RPCCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(),
			$entry( function(response, rawData, request) {
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					rawData, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			}));
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
                    var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
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
                    var param = {"_this": this, "transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
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
                    var param = {"_this": this};
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public native Alignment[] getFieldAlignments()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var alignJS = self.getFieldAlignments();
        return @com.smartgwt.client.util.ConvertTo::arrayOfAlignment(Lcom/google/gwt/core/client/JavaScriptObject;)(alignJS);
    }-*/;

    public Boolean getDeepCloneOnEdit() {
        return getAttributeAsBoolean("deepCloneOnEdit");
    }

    public void setDeepCloneOnEdit(Boolean deepCloneOnEdit) {
        setAttribute("deepCloneOnEdit", deepCloneOnEdit, true);
    }

    public void setFields(JavaScriptObject... fields) {
        if (fields != null) for(int i = 0; i < fields.length; i++) {
            fields[i] = duplicateFieldConfig(JSOHelper.cleanProperties(fields[i], false));
        }
        setAttribute("fields", fields, true);
    }

    private native JavaScriptObject duplicateFieldConfig(JavaScriptObject config) /*-{
        return $wnd.isc.shallowClone(config);
    }-*/;

    public JavaScriptObject[] getFieldsAsJavaScriptObjects() {
        JavaScriptObject fieldsJsArray = getAttributeAsJavaScriptObject("fields");
        return JSOHelper.isArray(fieldsJsArray) ? JSOHelper.toArray(fieldsJsArray) : null;
    }

    public int getFieldCount() {
        JavaScriptObject[] fields = getFieldsAsJavaScriptObjects();
        return fields != null ? fields.length : 0;
    }
    
    public native void transferRecords(Record[] records, Record targetRecord, Integer index, Canvas sourceWidget, TransferRecordsCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var targetRecordJS = targetRecord == null ? null : targetRecord.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var indexJS = index == null ? null : index.@java.lang.Integer::intValue()();
        var sourceWidgetJS = sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferRecords(recordsJS, targetRecordJS, indexJS, sourceWidgetJS, $entry(function(records) {
            if(callback != null) {
	    		var convertedArray = [];
	    		for (var i = 0; i < records.length; i++) {
	    			convertedArray[i] =  @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(records[i]);
	    		}
                var recordsJ = @com.smartgwt.client.util.JSOHelper::convertToJavaObjectArray(Lcom/google/gwt/core/client/JavaScriptObject;)(convertedArray);
                callback.@com.smartgwt.client.widgets.TransferRecordsCallback::execute([Lcom/smartgwt/client/data/Record;)(recordsJ);
            }
        }));
    }-*/;

	/**
     * During a drag-and-drop interaction, this method returns the set of records being dragged
     * out of the component.  In the default implementation, this is the list of currently
     * selected records.<p>
     * This method is consulted by
     * {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop willAcceptDrop()}.
     * @param DragDataCustomizer customizer
     */
    public native void setDragDataCustomizer(DragDataCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        var componentJ = this;
        self.getDragData = $debox($entry(function() {
        	var returnJ = customizer.@com.smartgwt.client.widgets.DragDataCustomizer::getDragData(Lcom/smartgwt/client/widgets/DataBoundComponent;)(componentJ);
        	return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(returnJ);
    	}));
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
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
            s.autoComplete = getAttributeAsString("autoComplete");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.autoComplete:" + t.getMessage() + "\n";
        }
        try {
            s.autoFocus = getAttributeAsString("autoFocus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.autoFocus:" + t.getMessage() + "\n";
        }
        try {
            s.autoFocusOnError = getAttributeAsString("autoFocusOnError");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.autoFocusOnError:" + t.getMessage() + "\n";
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
            s.canTabToIcons = getAttributeAsString("canTabToIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.canTabToIcons:" + t.getMessage() + "\n";
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
            s.clipStaticValue = getAttributeAsString("clipStaticValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.clipStaticValue:" + t.getMessage() + "\n";
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
            s.defaultSearchOperator = getAttributeAsString("defaultSearchOperator");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.defaultSearchOperator:" + t.getMessage() + "\n";
        }
        try {
            s.disableValidation = getAttributeAsString("disableValidation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.disableValidation:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.editProxyConstructor:" + t.getMessage() + "\n";
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
            s.minHintWidth = getAttributeAsString("minHintWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.minHintWidth:" + t.getMessage() + "\n";
        }
        try {
            s.noErrorDetailsMessage = getAttributeAsString("noErrorDetailsMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.noErrorDetailsMessage:" + t.getMessage() + "\n";
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
            s.originalValueMessage = getAttributeAsString("originalValueMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.originalValueMessage:" + t.getMessage() + "\n";
        }
        try {
            s.readOnlyDisplay = getAttributeAsString("readOnlyDisplay");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.readOnlyDisplay:" + t.getMessage() + "\n";
        }
        try {
            s.readOnlyTextBoxStyle = getAttributeAsString("readOnlyTextBoxStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.readOnlyTextBoxStyle:" + t.getMessage() + "\n";
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
            s.revertValueKey = getRevertValueKey();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.revertValueKey:" + t.getMessage() + "\n";
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
            s.showDeletions = getAttributeAsString("showDeletions");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showDeletions:" + t.getMessage() + "\n";
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
            s.showOldValueInHover = getAttributeAsString("showOldValueInHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showOldValueInHover:" + t.getMessage() + "\n";
        }
        try {
            s.showPending = getAttributeAsString("showPending");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.showPending:" + t.getMessage() + "\n";
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
            s.storeDisplayValues = getAttributeAsString("storeDisplayValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.storeDisplayValues:" + t.getMessage() + "\n";
        }
        try {
            s.suppressBrowserClearIcons = getAttributeAsString("suppressBrowserClearIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.suppressBrowserClearIcons:" + t.getMessage() + "\n";
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
            s.wrapHintText = getAttributeAsString("wrapHintText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.wrapHintText:" + t.getMessage() + "\n";
        }
        try {
            s.wrapItemTitles = getAttributeAsString("wrapItemTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DynamicForm.wrapItemTitles:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DynamicFormLogicalStructure s = new DynamicFormLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
