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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * A horizontal, Layout-based widget that allows a user to input a single criterion based on  one field and one operator.
 * <P> Note that FilterClauses must be used in conjunction with a {@link com.smartgwt.client.widgets.form.FilterBuilder}.
 * By default the FilterBuilder will auto-generate its clauses based on specified criteria, but for advanced usage a
 * FilterClause may be instantiated directly and passed to a filterBuilder via  {@link
 * com.smartgwt.client.widgets.form.FilterBuilder#addClause FilterBuilder.addClause()}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FilterClause")
public class FilterClause extends HStack {

    public static FilterClause getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new FilterClause(jsObj);
        } else {
            assert refInstance instanceof FilterClause;
            return (FilterClause)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FilterClause.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.FilterClause.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FilterClause.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.FilterClause.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public FilterClause(){
        scClassName = "FilterClause";
    }

    public FilterClause(JavaScriptObject jsObj){
        scClassName = "FilterClause";
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
     * AutoChild containing the UI for the filter-properties in this FilterClause.
     * <p>
     * This component is an AutoChild named "clause".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current clause value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SearchForm getClause() throws IllegalStateException {
        errorIfNotCreated("clause");
        return (SearchForm)SearchForm.getByJSObject(getAttributeAsJavaScriptObject("clause"));
    }
    

    /**
     * Initial criterion for this FilterClause. <P> When initialized with a criterion, the clause will be automatically set up
     * for editing the supplied criterion. <P> Note that an empty or partial criterion is allowed, for example, it may specify
     * {@link com.smartgwt.client.data.Criterion#getFieldName Criterion.fieldName} only and will generate an expression with
     * the operator not chosen.
     *
     * @param criterion New criterion value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     */
    public FilterClause setCriterion(Criteria criterion) {
        if (criterion instanceof Criterion) {
            criterion.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (FilterClause)setAttribute("criterion", criterion == null ? null : criterion.getJsObj(), true);
    }

    /**
     * Initial criterion for this FilterClause. <P> When initialized with a criterion, the clause will be automatically set up
     * for editing the supplied criterion. <P> Note that an empty or partial criterion is allowed, for example, it may specify
     * {@link com.smartgwt.client.data.Criterion#getFieldName Criterion.fieldName} only and will generate an expression with
     * the operator not chosen.
     *
     * @return Return the criterion specified by this FilterClause. Default value is null
     */
    public Criteria getCriterion()  {
        return new Criteria(getAttributeAsJavaScriptObject("criterion"));
    }
    
    

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.FieldPicker} autoChild FormItem.
     *
     * @param fieldPickerProperties New fieldPickerProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setFieldPickerProperties(FormItem fieldPickerProperties)  throws IllegalStateException {
        if (fieldPickerProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(FilterClause.class, "setFieldPickerProperties", "FormItem");
        }                                                                       
        fieldPickerProperties.setConfigOnly(true);
        return (FilterClause)setAttribute("fieldPickerProperties", fieldPickerProperties == null ? null : fieldPickerProperties.getEditorTypeConfig(), false);
    }

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.FieldPicker} autoChild FormItem.
     *
     * @return Current fieldPickerProperties value. Default value is null
     */
    public FormItem getFieldPickerProperties()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("fieldPickerProperties"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.FieldPicker field-picker} select-item.
     *
     * @param fieldPickerTitle New fieldPickerTitle value. Default value is "Field Name"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setFieldPickerTitle(String fieldPickerTitle)  throws IllegalStateException {
        return (FilterClause)setAttribute("fieldPickerTitle", fieldPickerTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.FieldPicker field-picker} select-item.
     *
     * @return Current fieldPickerTitle value. Default value is "Field Name"
     */
    public String getFieldPickerTitle()  {
        return getAttributeAsString("fieldPickerTitle");
    }
    

    /**
     * AutoChild for the {@link com.smartgwt.client.widgets.form.fields.FormItem} that allows a user to select the operator
     * when creating filter clauses. Each clause will create an operatorPicker automatically. To customize this item, use
     * {@link com.smartgwt.client.widgets.form.FilterClause#getOperatorPickerProperties operatorPickerProperties}
     * <p>
     * This component is an AutoChild named "operatorPicker".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current operatorPicker value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SelectItem getOperatorPicker() throws IllegalStateException {
        errorIfNotCreated("operatorPicker");
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("operatorPicker"));
    }
    

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterClause#getOperatorPicker operatorPicker}
     * autoChild FormItem.
     *
     * @param operatorPickerProperties New operatorPickerProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setOperatorPickerProperties(FormItem operatorPickerProperties)  throws IllegalStateException {
        if (operatorPickerProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(FilterClause.class, "setOperatorPickerProperties", "FormItem");
        }                                                                       
        operatorPickerProperties.setConfigOnly(true);
        return (FilterClause)setAttribute("operatorPickerProperties", operatorPickerProperties == null ? null : operatorPickerProperties.getEditorTypeConfig(), false);
    }

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterClause#getOperatorPicker operatorPicker}
     * autoChild FormItem.
     *
     * @return Current operatorPickerProperties value. Default value is null
     */
    public FormItem getOperatorPickerProperties()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("operatorPickerProperties"));
    }
    

    /**
     * The title for the operator-picker select-item.
     *
     * @param operatorPickerTitle New operatorPickerTitle value. Default value is "Operator"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setOperatorPickerTitle(String operatorPickerTitle)  throws IllegalStateException {
        return (FilterClause)setAttribute("operatorPickerTitle", operatorPickerTitle, false);
    }

    /**
     * The title for the operator-picker select-item.
     *
     * @return Current operatorPickerTitle value. Default value is "Operator"
     */
    public String getOperatorPickerTitle()  {
        return getAttributeAsString("operatorPickerTitle");
    }
    

    /**
     * The clause removal ImgButton that appears before this clause if {@link
     * com.smartgwt.client.widgets.form.FilterClause#getShowRemoveButton showRemoveButton} is set.
     * <p>
     * This component is an AutoChild named "removeButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current removeButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getRemoveButton() throws IllegalStateException {
        errorIfNotCreated("removeButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("removeButton"));
    }
    

    /**
     * The hover prompt text for the remove button.
     *
     * @param removeButtonPrompt New removeButtonPrompt value. Default value is "Remove"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        return (FilterClause)setAttribute("removeButtonPrompt", removeButtonPrompt, false);
    }

    /**
     * The hover prompt text for the remove button.
     *
     * @return Current removeButtonPrompt value. Default value is "Remove"
     */
    public String getRemoveButtonPrompt()  {
        return getAttributeAsString("removeButtonPrompt");
    }
    

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     * @param showFieldTitles New showFieldTitles value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setShowFieldTitles(Boolean showFieldTitles)  throws IllegalStateException {
        return (FilterClause)setAttribute("showFieldTitles", showFieldTitles, false);
    }

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     * @return Current showFieldTitles value. Default value is true
     */
    public Boolean getShowFieldTitles()  {
        Boolean result = getAttributeAsBoolean("showFieldTitles");
        return result == null ? true : result;
    }
    

    /**
     * If set, show a button for this clause allowing it to be removed.
     *
     * @param showRemoveButton New showRemoveButton value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setShowRemoveButton(Boolean showRemoveButton)  throws IllegalStateException {
        return (FilterClause)setAttribute("showRemoveButton", showRemoveButton, false);
    }

    /**
     * If set, show a button for this clause allowing it to be removed.
     *
     * @return Current showRemoveButton value. Default value is true
     */
    public Boolean getShowRemoveButton()  {
        Boolean result = getAttributeAsBoolean("showRemoveButton");
        return result == null ? true : result;
    }
    

    /**
     * If true (the default), validates the entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterClause</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterClause#validate validate()} from your own code.
     *
     * @param validateOnChange New validateOnChange value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setValidateOnChange(Boolean validateOnChange)  throws IllegalStateException {
        return (FilterClause)setAttribute("validateOnChange", validateOnChange, false);
    }

    /**
     * If true (the default), validates the entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterClause</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterClause#validate validate()} from your own code.
     *
     * @return Current validateOnChange value. Default value is true
     */
    public Boolean getValidateOnChange()  {
        Boolean result = getAttributeAsBoolean("validateOnChange");
        return result == null ? true : result;
    }
    

    /**
     * A hint to show in the value-item when using an operator that allows users to select  field-names from a list.
     *
     * @param valueItemFieldHint New valueItemFieldHint value. Default value is "Select a field"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setValueItemFieldHint(String valueItemFieldHint)  throws IllegalStateException {
        return (FilterClause)setAttribute("valueItemFieldHint", valueItemFieldHint, false);
    }

    /**
     * A hint to show in the value-item when using an operator that allows users to select  field-names from a list.
     *
     * @return Current valueItemFieldHint value. Default value is "Select a field"
     */
    public String getValueItemFieldHint()  {
        return getAttributeAsString("valueItemFieldHint");
    }
    

    /**
     * A hint to show in the value-item when using an operator that allows users to select values from a list.
     *
     * @param valueItemListHint New valueItemListHint value. Default value is "Select a value"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setValueItemListHint(String valueItemListHint)  throws IllegalStateException {
        return (FilterClause)setAttribute("valueItemListHint", valueItemListHint, false);
    }

    /**
     * A hint to show in the value-item when using an operator that allows users to select values from a list.
     *
     * @return Current valueItemListHint value. Default value is "Select a value"
     */
    public String getValueItemListHint()  {
        return getAttributeAsString("valueItemListHint");
    }
    

    /**
     * A hint to show in the value-item when using an operator that takes user-entered values.
     *
     * @param valueItemTextHint New valueItemTextHint value. Default value is "Enter a value"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setValueItemTextHint(String valueItemTextHint)  throws IllegalStateException {
        return (FilterClause)setAttribute("valueItemTextHint", valueItemTextHint, false);
    }

    /**
     * A hint to show in the value-item when using an operator that takes user-entered values.
     *
     * @return Current valueItemTextHint value. Default value is "Enter a value"
     */
    public String getValueItemTextHint()  {
        return getAttributeAsString("valueItemTextHint");
    }
    

    /**
     * The title for the value-item.
     *
     * @param valueItemTitle New valueItemTitle value. Default value is "Value"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setValueItemTitle(String valueItemTitle)  throws IllegalStateException {
        return (FilterClause)setAttribute("valueItemTitle", valueItemTitle, false);
    }

    /**
     * The title for the value-item.
     *
     * @return Current valueItemTitle value. Default value is "Value"
     */
    public String getValueItemTitle()  {
        return getAttributeAsString("valueItemTitle");
    }
    

    /**
     * A hint to show in the value-item when using an operator that takes an array of values.
     *
     * @param valueSetHint New valueSetHint value. Default value is "Comma-separated values"
     * @return {@link com.smartgwt.client.widgets.form.FilterClause FilterClause} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FilterClause setValueSetHint(String valueSetHint)  throws IllegalStateException {
        return (FilterClause)setAttribute("valueSetHint", valueSetHint, false);
    }

    /**
     * A hint to show in the value-item when using an operator that takes an array of values.
     *
     * @return Current valueSetHint value. Default value is "Comma-separated values"
     */
    public String getValueSetHint()  {
        return getAttributeAsString("valueSetHint");
    }
    

    // ********************* Methods ***********************
	/**
     * Returns the {@link com.smartgwt.client.widgets.form.FilterBuilder filterBuilder} containing this clause, or null if this
     * filterClause is not embedded in a filterBuilder.
     */
    public native void getFilterBuilder() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFilterBuilder", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getFilterBuilder();
    }-*/;

	/**
     * Remove this clause by destroy()ing it.
     */
    public native void remove() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "remove", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.remove();
    }-*/;

	/**
     * Validate this clause.
     *
     * @return true if if the clause is valid, false otherwise
     */
    public native Boolean validate() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "validate", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validate();
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
     * @param filterClauseProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(FilterClause filterClauseProperties) /*-{
        if (filterClauseProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(FilterClause.@java.lang.Object::getClass()(), "setDefaultProperties", filterClauseProperties.@java.lang.Object::getClass()());
        }
        filterClauseProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = filterClauseProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.FilterClause.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(FilterClauseLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.criterion = getCriterion();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.criterion:" + t.getMessage() + "\n";
        }
        try {
            s.fieldPickerTitle = getAttributeAsString("fieldPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.fieldPickerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.operatorPickerTitle = getAttributeAsString("operatorPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.operatorPickerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.removeButtonPrompt = getAttributeAsString("removeButtonPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.removeButtonPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.showFieldTitles = getAttributeAsString("showFieldTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.showFieldTitles:" + t.getMessage() + "\n";
        }
        try {
            s.showRemoveButton = getAttributeAsString("showRemoveButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.showRemoveButton:" + t.getMessage() + "\n";
        }
        try {
            s.validateOnChange = getAttributeAsString("validateOnChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.validateOnChange:" + t.getMessage() + "\n";
        }
        try {
            s.valueItemFieldHint = getAttributeAsString("valueItemFieldHint");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.valueItemFieldHint:" + t.getMessage() + "\n";
        }
        try {
            s.valueItemListHint = getAttributeAsString("valueItemListHint");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.valueItemListHint:" + t.getMessage() + "\n";
        }
        try {
            s.valueItemTextHint = getAttributeAsString("valueItemTextHint");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.valueItemTextHint:" + t.getMessage() + "\n";
        }
        try {
            s.valueItemTitle = getAttributeAsString("valueItemTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.valueItemTitle:" + t.getMessage() + "\n";
        }
        try {
            s.valueSetHint = getAttributeAsString("valueSetHint");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.valueSetHint:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        FilterClauseLogicalStructure s = new FilterClauseLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
