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
 * A form that allows the user to input advanced search criteria, including operators on field values such as "less than",
 * and sub-clauses using "AND" and "OR" operators. <P> A FilterBuilder produces an {@link
 * com.smartgwt.client.data.AdvancedCriteria} object, which the {@link com.smartgwt.client.data.DataSource} subsystem can
 * use to filter datasets, including the ability to perform such filtering within the browser for datasets that are
 * completely loaded. <P> The operators available for each field can be customized at the DataSource level via {@link
 * com.smartgwt.client.data.DataSourceField#getValidOperators DataSourceField.validOperators}, {@link
 * com.smartgwt.client.data.DataSource#setTypeOperators DataSource.setTypeOperators()} and related APIs.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FilterBuilder")
public class FilterBuilder extends Layout implements com.smartgwt.client.widgets.form.events.HasFilterChangedHandlers, com.smartgwt.client.widgets.form.events.HasSearchHandlers {

    public static FilterBuilder getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new FilterBuilder(jsObj);
        } else {
            assert refInstance instanceof FilterBuilder;
            return (FilterBuilder)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FilterBuilder.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.FilterBuilder.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FilterBuilder.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.FilterBuilder.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public FilterBuilder(){
        scClassName = "FilterBuilder";
    }

    public FilterBuilder(JavaScriptObject jsObj){
        scClassName = "FilterBuilder";
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
     * An ImgButton that allows new clauses to be added if {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getShowAddButton showAddButton} is set.
     * <p>
     * This component is an AutoChild named "addButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current addButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getAddButton() throws IllegalStateException {
        errorIfNotCreated("addButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("addButton"));
    }
    

    /**
     * The hover prompt text for the add button.
     *
     * @param addButtonPrompt New addButtonPrompt value. Default value is "Add"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddButtonPrompt(String addButtonPrompt)  throws IllegalStateException {
        setAttribute("addButtonPrompt", addButtonPrompt, false);
    }

    /**
     * The hover prompt text for the add button.
     *
     * @return Current addButtonPrompt value. Default value is "Add"
     */
    public String getAddButtonPrompt()  {
        return getAttributeAsString("addButtonPrompt");
    }
    

    /**
     * If set to false, the last clause cannot be removed.
     *
     * @param allowEmpty New allowEmpty value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowEmpty(Boolean allowEmpty)  throws IllegalStateException {
        setAttribute("allowEmpty", allowEmpty, false);
    }

    /**
     * If set to false, the last clause cannot be removed.
     *
     * @return Current allowEmpty value. Default value is false
     */
    public Boolean getAllowEmpty()  {
        Boolean result = getAttributeAsBoolean("allowEmpty");
        return result == null ? false : result;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Widget used as a "bracket" to hint to the user that a subclause groups several field-by-field filter criteria under one
     * logical operator. <P> By default, a simple CSS-style Canvas with borders on three sides.  A vertical StretchImg could
     * provide a more elaborate appearance.
     *
     * @return null
     */
    public Canvas getBracket()  {
        return null;
    }
    

    /**
     * VStack of all clauses that are part of this FilterBuilder
     * <p>
     * This component is an AutoChild named "clauseStack".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current clauseStack value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public VStack getClauseStack() throws IllegalStateException {
        errorIfNotCreated("clauseStack");
        return (VStack)VStack.getByJSObject(getAttributeAsJavaScriptObject("clauseStack"));
    }
    

    /**
     * Initial criteria. <P> When initialized with criteria, appropriate clauses for editing the provided criteria will be
     * automatically generated. <P> Note that empty or partial criteria are allowed, for example, criteria that specify {@link
     * com.smartgwt.client.data.Criterion#getFieldName Criterion.fieldName} only will generate an expression with the operator
     * not chosen yet, and a {@link com.smartgwt.client.data.Criterion} with a logical operator ("and" or "or") but not {@link
     * com.smartgwt.client.data.Criterion#getCriteria subcriteria} defined will generate an empty subclause.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set new criteria for editing.   <P> An interface for editing the provided criteria will be generated identically to what happens when initialized with {@link com.smartgwt.client.data.Criteria}. <P> Any existing criteria entered by the user will be discarded.
     *
     * @param criteria new criteria.  Pass null or {} to effectively reset the                                    filterBuilder to it's initial
     * state when no criteria are                                    specified. Default value is null
     */
    public void setCriteria(AdvancedCriteria criteria) {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), true);
    }

    /**
     * Initial criteria. <P> When initialized with criteria, appropriate clauses for editing the provided criteria will be
     * automatically generated. <P> Note that empty or partial criteria are allowed, for example, criteria that specify {@link
     * com.smartgwt.client.data.Criterion#getFieldName Criterion.fieldName} only will generate an expression with the operator
     * not chosen yet, and a {@link com.smartgwt.client.data.Criterion} with a logical operator ("and" or "or") but not {@link
     * com.smartgwt.client.data.Criterion#getCriteria subcriteria} defined will generate an empty subclause.
     *
     * @return Get the criteria entered by the user. Default value is null
     */
    public AdvancedCriteria getCriteria()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * DataSource this filter should use for field definitions and available {@link com.smartgwt.client.data.Operator}s.
     *
     * @return Current dataSource value. Default value is null
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * DataSource this filter should use for field definitions and available {@link com.smartgwt.client.data.Operator}s.
     *
     * @return Current dataSource value. Default value is null
     */
    public String getDataSourceAsString()  {
        return getAttributeAsString("dataSource");
    }
    
    

    /**
     * If specified, the FilterBuilder will dynamically fetch DataSourceField definitions from  this DataSource rather than
     * using {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSource dataSource}.  The {@link
     * com.smartgwt.client.widgets.FieldPicker}  will default to being a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} rather than a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} so that the user  will have type-ahead auto-completion. <P> The
     * records returned from the <code>fieldDataSource</code> must have properties  corresponding to a {@link
     * com.smartgwt.client.data.DataSourceField} definition, at a minimum,  {@link
     * com.smartgwt.client.data.DataSourceField#getName "name"} and {@link com.smartgwt.client.data.DataSourceField#getType
     * "type"}.  Any property  legal on a DataSourceField is legal on the returned records, including  {@link
     * com.smartgwt.client.data.DataSourceField#getValueMap valueMap}. <P> Even when a <code>fieldDataSource</code> is
     * specified, {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSource dataSource} may still be specified in
     * order to control the list of  {@link com.smartgwt.client.data.DataSource#setTypeOperators valid operators} for each
     * field.
     *
     * @param fieldDataSource New fieldDataSource value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldDataSource(DataSource fieldDataSource)  throws IllegalStateException {
        setAttribute("fieldDataSource", fieldDataSource == null ? null : fieldDataSource.getOrCreateJsObj(), false);
    }

    /**
     * If specified, the FilterBuilder will dynamically fetch DataSourceField definitions from  this DataSource rather than
     * using {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSource dataSource}.  The {@link
     * com.smartgwt.client.widgets.FieldPicker}  will default to being a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} rather than a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} so that the user  will have type-ahead auto-completion. <P> The
     * records returned from the <code>fieldDataSource</code> must have properties  corresponding to a {@link
     * com.smartgwt.client.data.DataSourceField} definition, at a minimum,  {@link
     * com.smartgwt.client.data.DataSourceField#getName "name"} and {@link com.smartgwt.client.data.DataSourceField#getType
     * "type"}.  Any property  legal on a DataSourceField is legal on the returned records, including  {@link
     * com.smartgwt.client.data.DataSourceField#getValueMap valueMap}. <P> Even when a <code>fieldDataSource</code> is
     * specified, {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSource dataSource} may still be specified in
     * order to control the list of  {@link com.smartgwt.client.data.DataSource#setTypeOperators valid operators} for each
     * field.
     *
     * @return Current fieldDataSource value. Default value is null
     */
    public DataSource getFieldDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("fieldDataSource"));
    }
    
    

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.FieldPicker} autoChild FormItem.
     *
     * @param fieldPickerProperties New fieldPickerProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerProperties(FormItem fieldPickerProperties)  throws IllegalStateException {
        if (fieldPickerProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(FilterBuilder.class, "setFieldPickerProperties", "FormItem");
        }                                                                       
        fieldPickerProperties.setConfigOnly(true);
        setAttribute("fieldPickerProperties", fieldPickerProperties == null ? null : fieldPickerProperties.getEditorTypeConfig(), false);
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
     * The title for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker field-picker} select-item.
     *
     * @param fieldPickerTitle New fieldPickerTitle value. Default value is "Field Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerTitle(String fieldPickerTitle)  throws IllegalStateException {
        setAttribute("fieldPickerTitle", fieldPickerTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker field-picker} select-item.
     *
     * @return Current fieldPickerTitle value. Default value is "Field Name"
     */
    public String getFieldPickerTitle()  {
        return getAttributeAsString("fieldPickerTitle");
    }
    

    /**
     * Width for the field picker formItem displayed in clauses within this FilterBuilder.
     *
     * @param fieldPickerWidth New fieldPickerWidth value. Default value is "*"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerWidth(Integer fieldPickerWidth)  throws IllegalStateException {
        setAttribute("fieldPickerWidth", fieldPickerWidth, false);
    }

    /**
     * Width for the field picker formItem displayed in clauses within this FilterBuilder.
     *
     * @return Current fieldPickerWidth value. Default value is "*"
     */
    public Integer getFieldPickerWidth()  {
        return getAttributeAsInt("fieldPickerWidth");
    }

    /**
     * Width for the field picker formItem displayed in clauses within this FilterBuilder.
     *
     * @param fieldPickerWidth New fieldPickerWidth value. Default value is "*"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerWidth(String fieldPickerWidth)  throws IllegalStateException {
        setAttribute("fieldPickerWidth", fieldPickerWidth, false);
    }

    /**
     * Width for the field picker formItem displayed in clauses within this FilterBuilder.
     *
     * @return Current fieldPickerWidth value. Default value is "*"
     */
    public String getFieldPickerWidthAsString()  {
        return getAttributeAsString("fieldPickerWidth");
    }
    

    /**
     * Title for the "And Not" operator (only applicable to the "inline" appearance)
     *
     * @param inlineAndNotTitle New inlineAndNotTitle value. Default value is "and not"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineAndNotTitle(String inlineAndNotTitle)  throws IllegalStateException {
        setAttribute("inlineAndNotTitle", inlineAndNotTitle, false);
    }

    /**
     * Title for the "And Not" operator (only applicable to the "inline" appearance)
     *
     * @return Current inlineAndNotTitle value. Default value is "and not"
     */
    public String getInlineAndNotTitle()  {
        return getAttributeAsString("inlineAndNotTitle");
    }
    

    /**
     * Title for the "And" operator (only applicable to the "inline" appearance)
     *
     * @param inlineAndTitle New inlineAndTitle value. Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineAndTitle(String inlineAndTitle)  throws IllegalStateException {
        setAttribute("inlineAndTitle", inlineAndTitle, false);
    }

    /**
     * Title for the "And" operator (only applicable to the "inline" appearance)
     *
     * @return Current inlineAndTitle value. Default value is "and"
     */
    public String getInlineAndTitle()  {
        return getAttributeAsString("inlineAndTitle");
    }
    

    /**
     * Title for the "Or" operator (only applicable to the "inline" appearance)
     *
     * @param inlineOrTitle New inlineOrTitle value. Default value is "or"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineOrTitle(String inlineOrTitle)  throws IllegalStateException {
        setAttribute("inlineOrTitle", inlineOrTitle, false);
    }

    /**
     * Title for the "Or" operator (only applicable to the "inline" appearance)
     *
     * @return Current inlineOrTitle value. Default value is "or"
     */
    public String getInlineOrTitle()  {
        return getAttributeAsString("inlineOrTitle");
    }
    

    /**
     * The hover prompt text for the remove button in the last remaining clause, when  {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getAllowEmpty allowEmpty} is false.
     *
     * @param lastClausePrompt New lastClausePrompt value. Default value is "The last clause cannot be removed"
     */
    public void setLastClausePrompt(String lastClausePrompt) {
        setAttribute("lastClausePrompt", lastClausePrompt, true);
    }

    /**
     * The hover prompt text for the remove button in the last remaining clause, when  {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getAllowEmpty allowEmpty} is false.
     *
     * @return Current lastClausePrompt value. Default value is "The last clause cannot be removed"
     */
    public String getLastClausePrompt()  {
        return getAttributeAsString("lastClausePrompt");
    }
    

    /**
     * Title for the "Match All" (and) operator  when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @param matchAllTitle New matchAllTitle value. Default value is "Match All"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchAllTitle(String matchAllTitle)  throws IllegalStateException {
        setAttribute("matchAllTitle", matchAllTitle, false);
    }

    /**
     * Title for the "Match All" (and) operator  when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @return Current matchAllTitle value. Default value is "Match All"
     */
    public String getMatchAllTitle()  {
        return getAttributeAsString("matchAllTitle");
    }
    

    /**
     * Title for the "Match Any" (or) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @param matchAnyTitle New matchAnyTitle value. Default value is "Match Any"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchAnyTitle(String matchAnyTitle)  throws IllegalStateException {
        setAttribute("matchAnyTitle", matchAnyTitle, false);
    }

    /**
     * Title for the "Match Any" (or) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @return Current matchAnyTitle value. Default value is "Match Any"
     */
    public String getMatchAnyTitle()  {
        return getAttributeAsString("matchAnyTitle");
    }
    

    /**
     * Title for the "Match None" (not) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @param matchNoneTitle New matchNoneTitle value. Default value is "Match None"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchNoneTitle(String matchNoneTitle)  throws IllegalStateException {
        setAttribute("matchNoneTitle", matchNoneTitle, false);
    }

    /**
     * Title for the "Match None" (not) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @return Current matchNoneTitle value. Default value is "Match None"
     */
    public String getMatchNoneTitle()  {
        return getAttributeAsString("matchNoneTitle");
    }
    

    /**
     * The message to display next to fieldNames that do not exist in the available dataSource.
     *
     * @param missingFieldPrompt New missingFieldPrompt value. Default value is "[missing field definition]"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMissingFieldPrompt(String missingFieldPrompt)  throws IllegalStateException {
        setAttribute("missingFieldPrompt", missingFieldPrompt, false);
    }

    /**
     * The message to display next to fieldNames that do not exist in the available dataSource.
     *
     * @return Current missingFieldPrompt value. Default value is "[missing field definition]"
     */
    public String getMissingFieldPrompt()  {
        return getAttributeAsString("missingFieldPrompt");
    }
    

    /**
     * Label to change between simple and advanced mode. When clicked the filter mode is switched to the other mode. This label
     * is only shown if {@link com.smartgwt.client.widgets.form.FilterBuilder#getShowModeSwitcher showModeSwitcher} is true.
     * <P> Shows either {@link com.smartgwt.client.widgets.form.FilterBuilder#getModeSwitcherSimpleMessage
     * modeSwitcherSimpleMessage} or {@link com.smartgwt.client.widgets.form.FilterBuilder#getModeSwitcherAdvancedMessage
     * modeSwitcherAdvancedMessage} depending on the current state of the filter.
     * <p>
     * This component is an AutoChild named "modeSwitcher".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current modeSwitcher value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getModeSwitcher() throws IllegalStateException {
        errorIfNotCreated("modeSwitcher");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("modeSwitcher"));
    }
    

    /**
     * Title for the "Advanced.." mode switcher label (only applicable to the "radio" appearance).
     *
     * @param modeSwitcherAdvancedMessage New modeSwitcherAdvancedMessage value. Default value is "Advanced.."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setModeSwitcherAdvancedMessage(String modeSwitcherAdvancedMessage)  throws IllegalStateException {
        setAttribute("modeSwitcherAdvancedMessage", modeSwitcherAdvancedMessage, false);
    }

    /**
     * Title for the "Advanced.." mode switcher label (only applicable to the "radio" appearance).
     *
     * @return Current modeSwitcherAdvancedMessage value. Default value is "Advanced.."
     */
    public String getModeSwitcherAdvancedMessage()  {
        return getAttributeAsString("modeSwitcherAdvancedMessage");
    }
    

    /**
     * Message displayed when switching to "radio" mode if the criteria will be logically changed.
     *
     * @param modeSwitcherFlattenWarningMessage New modeSwitcherFlattenWarningMessage value. Default value is "Criteria will be modified to fit in simpler editing interface"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setModeSwitcherFlattenWarningMessage(String modeSwitcherFlattenWarningMessage)  throws IllegalStateException {
        setAttribute("modeSwitcherFlattenWarningMessage", modeSwitcherFlattenWarningMessage, false);
    }

    /**
     * Message displayed when switching to "radio" mode if the criteria will be logically changed.
     *
     * @return Current modeSwitcherFlattenWarningMessage value. Default value is "Criteria will be modified to fit in simpler editing interface"
     */
    public String getModeSwitcherFlattenWarningMessage()  {
        return getAttributeAsString("modeSwitcherFlattenWarningMessage");
    }
    

    /**
     * Title for the "Simple Mode.." mode switcher label (only applicable to the "bracket" appearance).
     *
     * @param modeSwitcherSimpleMessage New modeSwitcherSimpleMessage value. Default value is "Simple Mode.."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setModeSwitcherSimpleMessage(String modeSwitcherSimpleMessage)  throws IllegalStateException {
        setAttribute("modeSwitcherSimpleMessage", modeSwitcherSimpleMessage, false);
    }

    /**
     * Title for the "Simple Mode.." mode switcher label (only applicable to the "bracket" appearance).
     *
     * @return Current modeSwitcherSimpleMessage value. Default value is "Simple Mode.."
     */
    public String getModeSwitcherSimpleMessage()  {
        return getAttributeAsString("modeSwitcherSimpleMessage");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * AutoChild for the {@link com.smartgwt.client.widgets.form.fields.FormItem} that allows a user to select the operator
     * when creating filter clauses. Each clause will create an operatorPicker automatically. To customize this item, use
     * {@link com.smartgwt.client.widgets.form.FilterBuilder#getOperatorPickerProperties operatorPickerProperties}
     *
     * @return null
     */
    public SelectItem getOperatorPicker()  {
        return null;
    }
    

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterBuilder#getOperatorPicker operatorPicker}
     * autoChild FormItem.
     *
     * @param operatorPickerProperties New operatorPickerProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperatorPickerProperties(FormItem operatorPickerProperties)  throws IllegalStateException {
        if (operatorPickerProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(FilterBuilder.class, "setOperatorPickerProperties", "FormItem");
        }                                                                       
        operatorPickerProperties.setConfigOnly(true);
        setAttribute("operatorPickerProperties", operatorPickerProperties == null ? null : operatorPickerProperties.getEditorTypeConfig(), false);
    }

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterBuilder#getOperatorPicker operatorPicker}
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperatorPickerTitle(String operatorPickerTitle)  throws IllegalStateException {
        setAttribute("operatorPickerTitle", operatorPickerTitle, false);
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
     * Width for the operator picker formItem displayed in clauses within this FilterBuilder.
     *
     * @param operatorPickerWidth New operatorPickerWidth value. Default value is 150
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperatorPickerWidth(Integer operatorPickerWidth)  throws IllegalStateException {
        setAttribute("operatorPickerWidth", operatorPickerWidth, false);
    }

    /**
     * Width for the operator picker formItem displayed in clauses within this FilterBuilder.
     *
     * @return Current operatorPickerWidth value. Default value is 150
     */
    public Integer getOperatorPickerWidth()  {
        return getAttributeAsInt("operatorPickerWidth");
    }

    /**
     * Width for the operator picker formItem displayed in clauses within this FilterBuilder.
     *
     * @param operatorPickerWidth New operatorPickerWidth value. Default value is 150
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperatorPickerWidth(String operatorPickerWidth)  throws IllegalStateException {
        setAttribute("operatorPickerWidth", operatorPickerWidth, false);
    }

    /**
     * Width for the operator picker formItem displayed in clauses within this FilterBuilder.
     *
     * @return Current operatorPickerWidth value. Default value is 150
     */
    public String getOperatorPickerWidthAsString()  {
        return getAttributeAsString("operatorPickerWidth");
    }
    

    /**
     * With {@link com.smartgwt.client.types.TopOperatorAppearance}:"radio", form that appears above the stack of clauses and
     * allows picking the {@link com.smartgwt.client.types.LogicalOperator} for the overall FilterBuilder. <P> By default,
     * consists of a simple RadioGroupItem.
     * <p>
     * This component is an AutoChild named "radioOperatorForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current radioOperatorForm value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getRadioOperatorForm() throws IllegalStateException {
        errorIfNotCreated("radioOperatorForm");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("radioOperatorForm"));
    }
    

    /**
     * HLayout of radioOperationForm and optional modeSwitcher.
     * <p>
     * This component is an AutoChild named "radioOperatorLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current radioOperatorLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getRadioOperatorLayout() throws IllegalStateException {
        errorIfNotCreated("radioOperatorLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("radioOperatorLayout"));
    }
    

    /**
     * The title for the Operator RadioGroupItem displayed in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getRadioOperatorForm radioOperatorForm}.
     *
     * @param radioOperatorTitle New radioOperatorTitle value. Default value is "Overall Operator"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRadioOperatorTitle(String radioOperatorTitle)  throws IllegalStateException {
        setAttribute("radioOperatorTitle", radioOperatorTitle, false);
    }

    /**
     * The title for the Operator RadioGroupItem displayed in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getRadioOperatorForm radioOperatorForm}.
     *
     * @return Current radioOperatorTitle value. Default value is "Overall Operator"
     */
    public String getRadioOperatorTitle()  {
        return getAttributeAsString("radioOperatorTitle");
    }
    
    

    /**
     * For operators that check that a value is within a range, text to show between the start and end input fields for
     * specifying the limits of the range.
     *
     * @param rangeSeparator New rangeSeparator value. Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRangeSeparator(String rangeSeparator)  throws IllegalStateException {
        setAttribute("rangeSeparator", rangeSeparator, false);
    }

    /**
     * For operators that check that a value is within a range, text to show between the start and end input fields for
     * specifying the limits of the range.
     *
     * @return Current rangeSeparator value. Default value is "and"
     */
    public String getRangeSeparator()  {
        return getAttributeAsString("rangeSeparator");
    }
    

    /**
     * The removal ImgButton that appears before each clause if {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getShowRemoveButton showRemoveButton} is set.
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        setAttribute("removeButtonPrompt", removeButtonPrompt, false);
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
     * Dictates whether values entered by a user should be retained in the value fields when a  different field is selected. 
     * Default value is true. <P> Note that, when switching between fields that have an optionDataSource or valueMap, this
     * property is ignored and the values are never retained.
     *
     * @param retainValuesAcrossFields New retainValuesAcrossFields value. Default value is true
     */
    public void setRetainValuesAcrossFields(Boolean retainValuesAcrossFields) {
        setAttribute("retainValuesAcrossFields", retainValuesAcrossFields, true);
    }

    /**
     * Dictates whether values entered by a user should be retained in the value fields when a  different field is selected. 
     * Default value is true. <P> Note that, when switching between fields that have an optionDataSource or valueMap, this
     * property is ignored and the values are never retained.
     *
     * @return Current retainValuesAcrossFields value. Default value is true
     */
    public Boolean getRetainValuesAcrossFields()  {
        Boolean result = getAttributeAsBoolean("retainValuesAcrossFields");
        return result == null ? true : result;
    }
    

    /**
     * If true, when the user hits the Enter key while focused in a text-item in this  FilterBuilder, we automatically invoke
     * the user-supplied {@link com.smartgwt.client.widgets.form.FilterBuilder#addSearchHandler FilterBuilder.search()} method.
     *
     * @param saveOnEnter New saveOnEnter value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSaveOnEnter(Boolean saveOnEnter)  throws IllegalStateException {
        setAttribute("saveOnEnter", saveOnEnter, false);
    }

    /**
     * If true, when the user hits the Enter key while focused in a text-item in this  FilterBuilder, we automatically invoke
     * the user-supplied {@link com.smartgwt.client.widgets.form.FilterBuilder#addSearchHandler FilterBuilder.search()} method.
     *
     * @return Current saveOnEnter value. Default value is null
     */
    public Boolean getSaveOnEnter()  {
        return getAttributeAsBoolean("saveOnEnter");
    }
    

    /**
     * If set, a button will be shown underneath all current clauses allowing a new clause to be added.
     *
     * @param showAddButton New showAddButton value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowAddButton(Boolean showAddButton)  throws IllegalStateException {
        setAttribute("showAddButton", showAddButton, false);
    }

    /**
     * If set, a button will be shown underneath all current clauses allowing a new clause to be added.
     *
     * @return Current showAddButton value. Default value is true
     */
    public Boolean getShowAddButton()  {
        Boolean result = getAttributeAsBoolean("showAddButton");
        return result == null ? true : result;
    }
    

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead. When {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSources multiple DataSources} are
     * configured, {@link com.smartgwt.client.widgets.form.FilterBuilder#getMultiDSFieldFormat multiDSFieldFormat} controls how
     * field names appear in the field drop-down.
     *
     * @param showFieldTitles New showFieldTitles value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowFieldTitles(Boolean showFieldTitles)  throws IllegalStateException {
        setAttribute("showFieldTitles", showFieldTitles, false);
    }

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead. When {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSources multiple DataSources} are
     * configured, {@link com.smartgwt.client.widgets.form.FilterBuilder#getMultiDSFieldFormat multiDSFieldFormat} controls how
     * field names appear in the field drop-down.
     *
     * @return Current showFieldTitles value. Default value is true
     */
    public Boolean getShowFieldTitles()  {
        Boolean result = getAttributeAsBoolean("showFieldTitles");
        return result == null ? true : result;
    }
    

    /**
     * When enabled allows FilterBuilder in <code>topOperatorAppearance:"radio"</code> or 
     * <code>topOperatorAppearance:"bracket"</code> mode to be switch to the other view by the user. "radio" mode is considered
     * simple where "bracket" mode is advanced mode. <P> Note that when switching from "bracket" to "radio" mode any entered
     * criteria will be flattened by calling {@link com.smartgwt.client.data.DataSource#flattenCriteria
     * DataSource.flattenCriteria()}. If the criteria cannot be flattened without losing symantics (see {@link
     * com.smartgwt.client.data.DataSource#canFlattenCriteria DataSource.canFlattenCriteria()}) the user is prompted to
     * confirm. <P> If showModeSwitcher is set and topOperatorAppearance is unset: <ul> <li> when first drawn, the
     * filterBuilder will choose which mode to use based on the      provided {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getCriteria criteria} if any: advanced mode ("bracket") will be used if  
     * AdvancedCriteria are provided which cannot be flattened without loss of data (see      {@link
     * com.smartgwt.client.data.DataSource#canFlattenCriteria DataSource.canFlattenCriteria()}), otherwise simple mode
     * ("radio") will be used.  <li> for any calls to {@link com.smartgwt.client.widgets.form.FilterBuilder#setCriteria
     * setCriteria()} after draw, the FilterBuilder will      switch to advanced mode if the criteria cannot be shown in simple
     * mode without losing      information, but will never automatically switch to simple mode, but an explicit call     
     * {@link com.smartgwt.client.widgets.form.FilterBuilder#setTopOperatorAppearance setTopOperatorAppearance("radio")} can be
     * used to do so. </ul>
     *
     * @param showModeSwitcher New showModeSwitcher value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.form.FilterBuilder#setModeSwitcherSimpleMessage
     * @see com.smartgwt.client.widgets.form.FilterBuilder#setModeSwitcherAdvancedMessage
     * @see com.smartgwt.client.widgets.form.FilterBuilder#setModeSwitcherFlattenWarningMessage
     */
    public void setShowModeSwitcher(Boolean showModeSwitcher)  throws IllegalStateException {
        setAttribute("showModeSwitcher", showModeSwitcher, false);
    }

    /**
     * When enabled allows FilterBuilder in <code>topOperatorAppearance:"radio"</code> or 
     * <code>topOperatorAppearance:"bracket"</code> mode to be switch to the other view by the user. "radio" mode is considered
     * simple where "bracket" mode is advanced mode. <P> Note that when switching from "bracket" to "radio" mode any entered
     * criteria will be flattened by calling {@link com.smartgwt.client.data.DataSource#flattenCriteria
     * DataSource.flattenCriteria()}. If the criteria cannot be flattened without losing symantics (see {@link
     * com.smartgwt.client.data.DataSource#canFlattenCriteria DataSource.canFlattenCriteria()}) the user is prompted to
     * confirm. <P> If showModeSwitcher is set and topOperatorAppearance is unset: <ul> <li> when first drawn, the
     * filterBuilder will choose which mode to use based on the      provided {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getCriteria criteria} if any: advanced mode ("bracket") will be used if  
     * AdvancedCriteria are provided which cannot be flattened without loss of data (see      {@link
     * com.smartgwt.client.data.DataSource#canFlattenCriteria DataSource.canFlattenCriteria()}), otherwise simple mode
     * ("radio") will be used.  <li> for any calls to {@link com.smartgwt.client.widgets.form.FilterBuilder#setCriteria
     * setCriteria()} after draw, the FilterBuilder will      switch to advanced mode if the criteria cannot be shown in simple
     * mode without losing      information, but will never automatically switch to simple mode, but an explicit call     
     * {@link com.smartgwt.client.widgets.form.FilterBuilder#setTopOperatorAppearance setTopOperatorAppearance("radio")} can be
     * used to do so. </ul>
     *
     * @return Current showModeSwitcher value. Default value is null
     * @see com.smartgwt.client.widgets.form.FilterBuilder#getModeSwitcherSimpleMessage
     * @see com.smartgwt.client.widgets.form.FilterBuilder#getModeSwitcherAdvancedMessage
     * @see com.smartgwt.client.widgets.form.FilterBuilder#getModeSwitcherFlattenWarningMessage
     */
    public Boolean getShowModeSwitcher()  {
        return getAttributeAsBoolean("showModeSwitcher");
    }
    

    /**
     * If set, a button will be shown for each clause allowing it to be removed.
     *
     * @param showRemoveButton New showRemoveButton value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRemoveButton(Boolean showRemoveButton)  throws IllegalStateException {
        setAttribute("showRemoveButton", showRemoveButton, false);
    }

    /**
     * If set, a button will be shown for each clause allowing it to be removed.
     *
     * @return Current showRemoveButton value. Default value is true
     */
    public Boolean getShowRemoveButton()  {
        Boolean result = getAttributeAsBoolean("showRemoveButton");
        return result == null ? true : result;
    }
    

    /**
     * If true, causes a CheckboxItem to appear to the left of each clause in "inline"  {@link
     * com.smartgwt.client.types.TopOperatorAppearance appearance}.  This checkbox allows the user to select  individual
     * clauses so that, for example, clauses can be removed from the filterBuilder  by application code.  This property is
     * ignored for appearances other than "inline".
     *
     * @param showSelectionCheckbox New showSelectionCheckbox value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowSelectionCheckbox(Boolean showSelectionCheckbox)  throws IllegalStateException {
        setAttribute("showSelectionCheckbox", showSelectionCheckbox, false);
    }

    /**
     * If true, causes a CheckboxItem to appear to the left of each clause in "inline"  {@link
     * com.smartgwt.client.types.TopOperatorAppearance appearance}.  This checkbox allows the user to select  individual
     * clauses so that, for example, clauses can be removed from the filterBuilder  by application code.  This property is
     * ignored for appearances other than "inline".
     *
     * @return Current showSelectionCheckbox value. Default value is false
     */
    public Boolean getShowSelectionCheckbox()  {
        Boolean result = getAttributeAsBoolean("showSelectionCheckbox");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the {@link
     * com.smartgwt.client.types.TopOperatorAppearance} is "radio" or "inline", true in all other cases.
     *
     * @param showSubClauseButton New showSubClauseButton value. Default value is See Description
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowSubClauseButton(Boolean showSubClauseButton)  throws IllegalStateException {
        setAttribute("showSubClauseButton", showSubClauseButton, false);
    }

    /**
     * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the {@link
     * com.smartgwt.client.types.TopOperatorAppearance} is "radio" or "inline", true in all other cases.
     *
     * @return Current showSubClauseButton value. Default value is See Description
     */
    public Boolean getShowSubClauseButton()  {
        return getAttributeAsBoolean("showSubClauseButton");
    }
    

    /**
     * Should the {@link com.smartgwt.client.widgets.FieldPicker} items be sorted alphabetically in the drop down list.
     *
     * @param sortFields New sortFields value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSortFields(Boolean sortFields)  throws IllegalStateException {
        setAttribute("sortFields", sortFields, false);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.FieldPicker} items be sorted alphabetically in the drop down list.
     *
     * @return Current sortFields value. Default value is true
     */
    public Boolean getSortFields()  {
        Boolean result = getAttributeAsBoolean("sortFields");
        return result == null ? true : result;
    }
    

    /**
     * Button allowing the user to add subclauses grouped by a {@link com.smartgwt.client.types.LogicalOperator}.
     * <p>
     * This component is an AutoChild named "subClauseButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current subClauseButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getSubClauseButton() throws IllegalStateException {
        errorIfNotCreated("subClauseButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("subClauseButton"));
    }
    

    /**
     * The hover prompt text for the subClauseButton.
     *
     * @param subClauseButtonPrompt New subClauseButtonPrompt value. Default value is "Add Subclause"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubClauseButtonPrompt(String subClauseButtonPrompt)  throws IllegalStateException {
        setAttribute("subClauseButtonPrompt", subClauseButtonPrompt, false);
    }

    /**
     * The hover prompt text for the subClauseButton.
     *
     * @return Current subClauseButtonPrompt value. Default value is "Add Subclause"
     */
    public String getSubClauseButtonPrompt()  {
        return getAttributeAsString("subClauseButtonPrompt");
    }
    

    /**
     * The title of the subClauseButton
     *
     * @param subClauseButtonTitle New subClauseButtonTitle value. Default value is "+()"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubClauseButtonTitle(String subClauseButtonTitle)  throws IllegalStateException {
        setAttribute("subClauseButtonTitle", subClauseButtonTitle, false);
    }

    /**
     * The title of the subClauseButton
     *
     * @return Current subClauseButtonTitle value. Default value is "+()"
     */
    public String getSubClauseButtonTitle()  {
        return getAttributeAsString("subClauseButtonTitle");
    }
    

    /**
     * Default logical operator for all top-level clauses in the FilterBuilder. <P> May be able to be changed by the user via
     * the UI, according to {@link com.smartgwt.client.types.TopOperatorAppearance}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Programmatically change the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperator topOperator} for this FilterBuilder.
     *
     * @param topOperator new top-level operator. Default value is "and"
     */
    public void setTopOperator(LogicalOperator topOperator) {
        setAttribute("topOperator", topOperator == null ? null : topOperator.getValue(), true);
    }

    /**
     * Default logical operator for all top-level clauses in the FilterBuilder. <P> May be able to be changed by the user via
     * the UI, according to {@link com.smartgwt.client.types.TopOperatorAppearance}.
     *
     * @return Current topOperator value. Default value is "and"
     */
    public LogicalOperator getTopOperator()  {
        return EnumUtil.getEnum(LogicalOperator.values(), getAttribute("topOperator"));
    }
    

    /**
     * How to display and edit the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperator top-level operator} for
     * this FilterBuilder. <P> See {@link com.smartgwt.client.types.TopOperatorAppearance} for a list of options.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Modify {@link com.smartgwt.client.types.TopOperatorAppearance} at runtime. <P> Note that when changing from "bracket" to "radio" mode the criteria will be flattened by calling {@link com.smartgwt.client.data.DataSource#flattenCriteria DataSource.flattenCriteria()} which could result in a logical change to the criteria.
     *
     * @param topOperatorAppearance new topOperatorAppearance. Default value is "bracket"
     */
    public void setTopOperatorAppearance(TopOperatorAppearance topOperatorAppearance) {
        setAttribute("topOperatorAppearance", topOperatorAppearance == null ? null : topOperatorAppearance.getValue(), true);
    }

    /**
     * How to display and edit the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperator top-level operator} for
     * this FilterBuilder. <P> See {@link com.smartgwt.client.types.TopOperatorAppearance} for a list of options.
     *
     * @return Current topOperatorAppearance value. Default value is "bracket"
     */
    public TopOperatorAppearance getTopOperatorAppearance()  {
        return EnumUtil.getEnum(TopOperatorAppearance.values(), getAttribute("topOperatorAppearance"));
    }
    

    /**
     * With {@link com.smartgwt.client.types.TopOperatorAppearance} "bracket" and "inline", a form that appears to the left of
     * the stack of clauses and allows picking the {@link com.smartgwt.client.types.LogicalOperator} for the overall 
     * FilterBuilder (or for that specific FilterClause, in the case of "inline") <P> By default, consists of a CheckboxItem if
     * {@link com.smartgwt.client.widgets.form.FilterBuilder#getShowSelectionCheckbox showSelectionCheckbox} is true, and a 
     * simple SelectItem containing the available logical operators. <P> If this FilterBuilder shows nested sub-clauses, the
     * same defaults will be applied to the top-operator item for each sub-clause.
     * <p>
     * This component is an AutoChild named "topOperatorForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current topOperatorForm value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getTopOperatorForm() throws IllegalStateException {
        errorIfNotCreated("topOperatorForm");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("topOperatorForm"));
    }
    

    /**
     * Automatically generated SelectItem autoChild shown in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorForm topOperatorForm}. Developers may customize this item
     * using the standard autoChild pattern (by modifying <code>topOperatorItemDefaults</code> and 
     * <code>topOperatorItemProperties</code>). <P> If this FilterBuilder shows nested sub-clauses, the same defaults will be
     * applied to the top-operator item for each sub-clause.
     * <p>
     * This component is an AutoChild named "topOperatorItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current topOperatorItem value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SelectItem getTopOperatorItem() throws IllegalStateException {
        errorIfNotCreated("topOperatorItem");
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("topOperatorItem"));
    }
    

    /**
     * Width for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorItem topOperatorItem} autoChild.
     *
     * @param topOperatorItemWidth New topOperatorItemWidth value. Default value is "*"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTopOperatorItemWidth(int topOperatorItemWidth)  throws IllegalStateException {
        setAttribute("topOperatorItemWidth", topOperatorItemWidth, false);
    }

    /**
     * Width for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorItem topOperatorItem} autoChild.
     *
     * @return Current topOperatorItemWidth value. Default value is "*"
     */
    public int getTopOperatorItemWidth()  {
        return getAttributeAsInt("topOperatorItemWidth");
    }

    /**
     * Width for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorItem topOperatorItem} autoChild.
     *
     * @param topOperatorItemWidth New topOperatorItemWidth value. Default value is "*"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTopOperatorItemWidth(String topOperatorItemWidth)  throws IllegalStateException {
        setAttribute("topOperatorItemWidth", topOperatorItemWidth, false);
    }

    /**
     * Width for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorItem topOperatorItem} autoChild.
     *
     * @return Current topOperatorItemWidth value. Default value is "*"
     */
    public String getTopOperatorItemWidthAsString()  {
        return getAttributeAsString("topOperatorItemWidth");
    }
    

    /**
     * Logical operators to allow for {@link com.smartgwt.client.types.TopOperatorAppearance}s of "radio" and "bracket". <P>
     * Note that this list may be further limited according to the  {@link
     * com.smartgwt.client.data.DataSource#getTypeOperatorMap available operators} returned by the  {@link
     * com.smartgwt.client.data.DataSource}.
     *
     * @param topOperatorOptions New topOperatorOptions value. Default value is ["and", "or", "not"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTopOperatorOptions(OperatorId... topOperatorOptions)  throws IllegalStateException {
        setAttribute("topOperatorOptions", topOperatorOptions, false);
    }

    /**
     * Logical operators to allow for {@link com.smartgwt.client.types.TopOperatorAppearance}s of "radio" and "bracket". <P>
     * Note that this list may be further limited according to the  {@link
     * com.smartgwt.client.data.DataSource#getTypeOperatorMap available operators} returned by the  {@link
     * com.smartgwt.client.data.DataSource}.
     *
     * @return Current topOperatorOptions value. Default value is ["and", "or", "not"]
     */
    public OperatorId[] getTopOperatorOptions()  {
        final String[] strings = getAttributeAsStringArray("topOperatorOptions");
        return EnumUtil.getEnums(OperatorId.values(), strings, strings == null ? null : new OperatorId[strings.length]);
    }
    

    /**
     * The title for the left-aligned Operator selectItem in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorForm topOperatorForm}.
     *
     * @param topOperatorTitle New topOperatorTitle value. Default value is "Clause Operator"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTopOperatorTitle(String topOperatorTitle)  throws IllegalStateException {
        setAttribute("topOperatorTitle", topOperatorTitle, false);
    }

    /**
     * The title for the left-aligned Operator selectItem in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorForm topOperatorForm}.
     *
     * @return Current topOperatorTitle value. Default value is "Clause Operator"
     */
    public String getTopOperatorTitle()  {
        return getAttributeAsString("topOperatorTitle");
    }
    

    /**
     * If true (the default), validates each entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterBuilder</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#validate validate()} from your own code.
     *
     * @param validateOnChange New validateOnChange value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValidateOnChange(Boolean validateOnChange)  throws IllegalStateException {
        setAttribute("validateOnChange", validateOnChange, false);
    }

    /**
     * If true (the default), validates each entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterBuilder</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#validate validate()} from your own code.
     *
     * @return Current validateOnChange value. Default value is true
     */
    public Boolean getValidateOnChange()  {
        Boolean result = getAttributeAsBoolean("validateOnChange");
        return result == null ? true : result;
    }
    

    /**
     * Width for the value-chooser formItem displayed in clauses within this FilterBuilder. Note that depending on the selected
     * operator type, this item may not be displayed, or may have different characteristics. See {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getValueFieldProperties getValueFieldProperties()} for information on
     * customizing the value item.
     *
     * @param valueItemWidth New valueItemWidth value. Default value is 150
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueItemWidth(Integer valueItemWidth)  throws IllegalStateException {
        setAttribute("valueItemWidth", valueItemWidth, false);
    }

    /**
     * Width for the value-chooser formItem displayed in clauses within this FilterBuilder. Note that depending on the selected
     * operator type, this item may not be displayed, or may have different characteristics. See {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getValueFieldProperties getValueFieldProperties()} for information on
     * customizing the value item.
     *
     * @return Current valueItemWidth value. Default value is 150
     */
    public Integer getValueItemWidth()  {
        return getAttributeAsInt("valueItemWidth");
    }

    /**
     * Width for the value-chooser formItem displayed in clauses within this FilterBuilder. Note that depending on the selected
     * operator type, this item may not be displayed, or may have different characteristics. See {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getValueFieldProperties getValueFieldProperties()} for information on
     * customizing the value item.
     *
     * @param valueItemWidth New valueItemWidth value. Default value is 150
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueItemWidth(String valueItemWidth)  throws IllegalStateException {
        setAttribute("valueItemWidth", valueItemWidth, false);
    }

    /**
     * Width for the value-chooser formItem displayed in clauses within this FilterBuilder. Note that depending on the selected
     * operator type, this item may not be displayed, or may have different characteristics. See {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getValueFieldProperties getValueFieldProperties()} for information on
     * customizing the value item.
     *
     * @return Current valueItemWidth value. Default value is 150
     */
    public String getValueItemWidthAsString()  {
        return getAttributeAsString("valueItemWidth");
    }
    

    // ********************* Methods ***********************
	/**
     * Add a new {@link com.smartgwt.client.widgets.form.FilterClause} to this FilterBuilder. <P> This API is intended for the
     * rare use case of adding a highly customized FilterClause component that does not include the standard
     * field/operator/value picking interface, instead providing a custom interface and returning a criterion via {@link
     * com.smartgwt.client.widgets.form.FilterClause#getCriterion FilterClause.getCriterion()}. <P> If you just want to
     * programmatically add a new FilterClause showing a specific Criterion use {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#addCriterion addCriterion()}. <P> If you want to use the standard
     * field/operator/value interface but provide a custom control for editing the value, see {@link
     * com.smartgwt.client.data.DataSource#addSearchOperator DataSource.addSearchOperator()} and {@link
     * com.smartgwt.client.data.Operator#getEditorType Operator.editorType}.
     * @param filterClause A {@link com.smartgwt.client.widgets.form.FilterClause} instance
     */
    public native void addClause(FilterClause filterClause) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addClause", "FilterClause");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addClause(filterClause == null ? null : filterClause.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Add a new criterion, including recursively adding sub-criteria for a criterion that contains other criteria.
     * @param criterion new criterion to be added
     */
    public native void addCriterion(Criterion criterion) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addCriterion", "Criterion");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Clear all current criteria.
     */
    public native void clearCriteria() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearCriteria", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearCriteria();
    }-*/;

    /**
     * Add a filterChanged handler.
     * <p>
     * Handler fired when there is a change() event fired on any FormItem within the  filterBuilder.
     *
     * @param handler the filterChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFilterChangedHandler(com.smartgwt.client.widgets.form.events.FilterChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.FilterChangedEvent.getType()) == 0) setupFilterChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.FilterChangedEvent.getType());
    }

    private native void setupFilterChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var filterChanged = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.form.events.FilterChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.FilterBuilder::handleTearDownFilterChangedEvent()();
            if (hasDefaultHandler) this.Super("filterChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("filterChanged"));
            obj.addProperties({filterChanged:  filterChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("filterChanged"));
            obj.filterChanged =  filterChanged             ;
        }
    }-*/;

    private void handleTearDownFilterChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.FilterChangedEvent.getType()) == 0) tearDownFilterChangedEvent();
    }

    private native void tearDownFilterChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("filterChanged")) delete obj.filterChanged;
    }-*/;

	/**
     * Returns the type of editor to use for the field. <P> Default behavior is to use the {@link
     * com.smartgwt.client.data.Operator#getEditorType Operator.editorType} for a custom operator, otherwise,  use {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem} for before/after/between operators on date fields, otherwise, 
     * use the same editor as would be chosen by a {@link com.smartgwt.client.widgets.form.SearchForm}.
     * @param field DataSourceField definition
     * @param operatorId {@link com.smartgwt.client.types.OperatorId} for the chosen operator
     *
     * @return Smart GWT class to use (must be subclass of FormItem).
     * See {@link com.smartgwt.client.docs.SCClassName SCClassName}
     */
    public native String getEditorType(DataSourceField field, OperatorId operatorId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEditorType", "DataSourceField,OperatorId");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditorType(field.@com.smartgwt.client.core.DataClass::getJsObj()(), operatorId.@com.smartgwt.client.types.OperatorId::getValue()());
        return ret;
    }-*/;

	/**
     * Returns the list of this FilterBuilder's FilterClauses that are currently selected.  A  clause is "selected" if the user
     * has checked the checkbox next to it; therefore, this  method always returns an empty list unless the  {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getShowSelectionCheckbox showSelectionCheckbox} property is set.  This
     * method is only  applicable where {@link com.smartgwt.client.types.TopOperatorAppearance} is "inline" (because that is
     * the only  appearance that supports <code>showSelectionCheckbox</code>)
     *
     * @return The list of selected clauses
     */
    public native FilterClause[] getSelectedClauses() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedClauses", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedClauses();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfFilterClause(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Add a search handler.
     * <p>
     * A StringMethod that is automatically invoked if {@link com.smartgwt.client.widgets.form.FilterBuilder#getSaveOnEnter
     * FilterBuilder.saveOnEnter} is set  and the user presses Enter whilst in a text-item in any clause or subclause.
     *
     * @param handler the search handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSearchHandler(com.smartgwt.client.widgets.form.events.SearchHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.FilterSearchEvent.getType()) == 0) setupSearchEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.FilterSearchEvent.getType());
    }

    private native void setupSearchEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var search = $entry(function(){
            var param = {"_this": this, "criteria" : arguments[0]};
            var event = @com.smartgwt.client.widgets.form.events.FilterSearchEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.FilterBuilder::handleTearDownSearchEvent()();
            if (hasDefaultHandler) this.Super("search", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("search"));
            obj.addProperties({search:  search              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("search"));
            obj.search =  search             ;
        }
    }-*/;

    private void handleTearDownSearchEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.FilterSearchEvent.getType()) == 0) tearDownSearchEvent();
    }

    private native void tearDownSearchEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("search")) delete obj.search;
    }-*/;

	/**
     * Validate the clauses of this FilterBuilder.
     *
     * @return true if all clauses are valid, false otherwise
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
     * @param filterBuilderProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(FilterBuilder filterBuilderProperties) /*-{
        if (filterBuilderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(FilterBuilder.@java.lang.Object::getClass()(), "setDefaultProperties", filterBuilderProperties.@java.lang.Object::getClass()());
        }
        filterBuilderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = filterBuilderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.FilterBuilder.addProperties(properties);
    }-*/;

    // ***********************************************************




    public void onInit () {
        super.onInit();
        onInit_FilterBuilder();
    }

    protected native void onInit_FilterBuilder () /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        self.__getValueFieldProperties = self.getValueFieldProperties;
        self.getValueFieldProperties = $entry(function(type, fieldName, operatorId, itemType) {
            var jObj = this.__ref;
            if (jObj == null) return this.__getValueFieldProperties(type, fieldName, operatorId, itemType);
            var fieldTypeEnum = @com.smartgwt.client.types.FieldType::values()(),
                operatorIdEnum = @com.smartgwt.client.types.OperatorId::values()(),
                itemTypeEnum = @com.smartgwt.client.types.ValueItemType::values()();
            var jType = @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(fieldTypeEnum,type),
                jOperatorId = @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(operatorIdEnum,operatorId),
                jItemType = @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(itemTypeEnum,itemType);
            if(jType == null) jType = @com.smartgwt.client.types.FieldType::CUSTOM;
            var formItemJ = jObj.@com.smartgwt.client.widgets.form.FilterBuilder::getValueFieldProperties(Lcom/smartgwt/client/types/FieldType;Ljava/lang/String;Lcom/smartgwt/client/types/OperatorId;Lcom/smartgwt/client/types/ValueItemType;Ljava/lang/String;)(jType, fieldName, jOperatorId, jItemType, type);
            if (formItemJ == null) return null;
            return formItemJ.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        });

    }-*/;

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show
     * actual field names instead.
     *
     * @param showFieldTitles showFieldTitles default is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowFieldTitles(boolean showFieldTitles) throws IllegalStateException {
        setAttribute("showFieldTitles", showFieldTitles, false);
    }

    /**
     * DataSource this filter should use for field definitions and available {@link com.smartgwt.client.data.Operator Operator}s.
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
     * Initial criteria. <P> When initialized with criteria, appropriate clauses for editing the provided criteria will be
     * automatically generated. <P> Note that empty or partial criteria are allowed, for example, criteria that specify {@link
     * com.smartgwt.client.data.Criterion#getFieldName Criterion.fieldName} only will generate an expression with the operator
     * not chosen yet, and a {@link com.smartgwt.client.data.Criterion} with a logical operator ("and" or "or") but not {@link
     * com.smartgwt.client.data.Criterion#getCriteria subcriteria} defined will generate an empty subclause.
     *
     * @param By default if a user has selected a field and operator type, but has failed to enter a value for
     *          the field it will be skipped. This optional parameter allows you to retrieve all criteria,
     *          including those with an empty value attribute.
     * @return Get the criteria entered by the user. Default value is null
     */
    public native AdvancedCriteria getCriteria(boolean includeEmptyValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = self.getCriteria(includeEmptyValues);
        return @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;

    /**
     * Remove a clause this FilterBuilder is currently showing.
     * @param clause clause as retrieved from filterBuilder.clauses
     */
    public native void removeClause(FilterClause clause) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeClause(clause.@com.smartgwt.client.widgets.BaseWidget::getJsObj()());
    }-*/;


    public Canvas[] getMembers() {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("members"));
    }

    /**
     * Override to return properties for the FormItem(s) used for the "value" field displayed within clauses within this
     * filterBuilder. <P> Note that the  valueType impacts when this method is called. For operators with valueType
     * <code>"fieldType"</code> or <code>"custom"</code>, a single value field is displayed. For operators with valueType
     * <code>"valueRange"</code> two value-field items are displayed (one for the start and one for the end position). The
     * <code>valueItemType</code> parameter may be used to determine which form item is being generated.
     * <p><b> Note :</b> This is an override point
     *
     * @param type type of the DataSource field for this filter row. Note that for {@link DataSourceSimpleTypeField} SimpleType
     *   based DataSource fields this attribute will be null
     * @param fieldName name of the DataSource field for this filter row
     * @param operatorId {@link com.smartgwt.client.types.OperatorId} for the chosen operator
     * @param itemType What valueItem is being generated.
     * @param fieldType type of the DataSource field for this filter row. Typically one would use the {@param type} parameter but this value is useful when the
     * {@link FieldType} is a custom SimpleType in which case the type will be {@link FieldType#CUSTOM} and this parameter is the name of the SimpleType
     *
     * @return properties for the value field
     */
    public native FormItem getValueFieldProperties(FieldType type, String fieldName, OperatorId operatorId, ValueItemType itemType, String fieldType) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.__getValueFieldProperties(type == @com.smartgwt.client.types.FieldType::CUSTOM ? fieldType : type.@com.smartgwt.client.types.FieldType::getValue()(), fieldName, operatorId.@com.smartgwt.client.types.OperatorId::getValue()(), itemType.@com.smartgwt.client.types.ValueItemType::getValue()());
        if(ret == null) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
    
    /**
     * This method installs a customizer that returns the set of OperatorIds applicable to the passed fieldName
     * 
     * @param customizer the customizer to execute.
     */
    public native void setFieldOperatorCustomizer(FieldOperatorCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            self.__getFieldOperators = self.getFieldOperators;
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self.__getFieldOperators = $wnd.isc[scClassName].getInstanceProperty("getFieldOperators");
        }

        self.getFieldOperators = $debox($entry(function(fieldName) {
            var thisJ = this.__ref;
            
            // if passed no fieldName, bail
            if (fieldName == null) return null;
            
            // get the default OperatorIds to pass to the customizer
            var defaultsJS = null;
            if (this.__getFieldOperators != null) defaultsJS = this.__getFieldOperators(fieldName);
            var defaultsJ = null;
            if (defaultsJS != null) {
                defaultsJ = @com.smartgwt.client.util.ConvertTo::arrayOfOperatorId(Lcom/google/gwt/core/client/JavaScriptObject;)(defaultsJS);
            }
                        
            // if passed an object as the fieldName, use fieldName.name
            if ($wnd.isc.isAn.Object(fieldName)) fieldName = fieldName.name;
            
            // run the customizer to get the Java OperatorIds
            var operatorIdsJ = customizer.@com.smartgwt.client.widgets.form.fields.FieldOperatorCustomizer::getFieldOperators(Ljava/lang/String;[Lcom/smartgwt/client/types/OperatorId;Lcom/smartgwt/client/widgets/form/FilterBuilder;)(fieldName, defaultsJ, thisJ);
            if (operatorIdsJ == null) return null;
            
            // and convert them to a JS array
            var stringsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(operatorIdsJ);
            if (stringsJS == null) return null;
            
            return stringsJS;
        }));
    }-*/;



    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(FilterBuilderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addButtonPrompt = getAttributeAsString("addButtonPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.addButtonPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.allowEmpty = getAttributeAsString("allowEmpty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.allowEmpty:" + t.getMessage() + "\n";
        }
        try {
            s.criteria = getCriteria();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.criteria:" + t.getMessage() + "\n";
        }
        try {
            s.dataSourceAsDataSource = getDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.dataSourceAsDataSource:" + t.getMessage() + "\n";
        }
        try {
            s.dataSourceAsString = getAttributeAsString("dataSource");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.dataSourceAsString:" + t.getMessage() + "\n";
        }
        try {
            s.fieldDataSource = getFieldDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.fieldDataSource:" + t.getMessage() + "\n";
        }
        try {
            s.fieldPickerTitle = getAttributeAsString("fieldPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.fieldPickerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.fieldPickerWidthAsString = getAttributeAsString("fieldPickerWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.fieldPickerWidthAsString:" + t.getMessage() + "\n";
        }
        try {
            s.inlineAndNotTitle = getAttributeAsString("inlineAndNotTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.inlineAndNotTitle:" + t.getMessage() + "\n";
        }
        try {
            s.inlineAndTitle = getAttributeAsString("inlineAndTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.inlineAndTitle:" + t.getMessage() + "\n";
        }
        try {
            s.inlineOrTitle = getAttributeAsString("inlineOrTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.inlineOrTitle:" + t.getMessage() + "\n";
        }
        try {
            s.lastClausePrompt = getAttributeAsString("lastClausePrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.lastClausePrompt:" + t.getMessage() + "\n";
        }
        try {
            s.matchAllTitle = getAttributeAsString("matchAllTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.matchAllTitle:" + t.getMessage() + "\n";
        }
        try {
            s.matchAnyTitle = getAttributeAsString("matchAnyTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.matchAnyTitle:" + t.getMessage() + "\n";
        }
        try {
            s.matchNoneTitle = getAttributeAsString("matchNoneTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.matchNoneTitle:" + t.getMessage() + "\n";
        }
        try {
            s.missingFieldPrompt = getAttributeAsString("missingFieldPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.missingFieldPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.modeSwitcherAdvancedMessage = getAttributeAsString("modeSwitcherAdvancedMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.modeSwitcherAdvancedMessage:" + t.getMessage() + "\n";
        }
        try {
            s.modeSwitcherFlattenWarningMessage = getAttributeAsString("modeSwitcherFlattenWarningMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.modeSwitcherFlattenWarningMessage:" + t.getMessage() + "\n";
        }
        try {
            s.modeSwitcherSimpleMessage = getAttributeAsString("modeSwitcherSimpleMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.modeSwitcherSimpleMessage:" + t.getMessage() + "\n";
        }
        try {
            s.operatorPickerTitle = getAttributeAsString("operatorPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.operatorPickerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.operatorPickerWidthAsString = getAttributeAsString("operatorPickerWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.operatorPickerWidthAsString:" + t.getMessage() + "\n";
        }
        try {
            s.radioOperatorTitle = getAttributeAsString("radioOperatorTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.radioOperatorTitle:" + t.getMessage() + "\n";
        }
        try {
            s.rangeSeparator = getAttributeAsString("rangeSeparator");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.rangeSeparator:" + t.getMessage() + "\n";
        }
        try {
            s.removeButtonPrompt = getAttributeAsString("removeButtonPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.removeButtonPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.retainValuesAcrossFields = getAttributeAsString("retainValuesAcrossFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.retainValuesAcrossFields:" + t.getMessage() + "\n";
        }
        try {
            s.saveOnEnter = getAttributeAsString("saveOnEnter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.saveOnEnter:" + t.getMessage() + "\n";
        }
        try {
            s.showAddButton = getAttributeAsString("showAddButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.showAddButton:" + t.getMessage() + "\n";
        }
        try {
            s.showFieldTitles = getAttributeAsString("showFieldTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.showFieldTitles:" + t.getMessage() + "\n";
        }
        try {
            s.showModeSwitcher = getAttributeAsString("showModeSwitcher");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.showModeSwitcher:" + t.getMessage() + "\n";
        }
        try {
            s.showRemoveButton = getAttributeAsString("showRemoveButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.showRemoveButton:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectionCheckbox = getAttributeAsString("showSelectionCheckbox");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.showSelectionCheckbox:" + t.getMessage() + "\n";
        }
        try {
            s.showSubClauseButton = getAttributeAsString("showSubClauseButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.showSubClauseButton:" + t.getMessage() + "\n";
        }
        try {
            s.sortFields = getAttributeAsString("sortFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.sortFields:" + t.getMessage() + "\n";
        }
        try {
            s.subClauseButtonPrompt = getAttributeAsString("subClauseButtonPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.subClauseButtonPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.subClauseButtonTitle = getAttributeAsString("subClauseButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.subClauseButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.topOperator = getAttributeAsString("topOperator");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.topOperator:" + t.getMessage() + "\n";
        }
        try {
            s.topOperatorAppearance = getAttributeAsString("topOperatorAppearance");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.topOperatorAppearance:" + t.getMessage() + "\n";
        }
        try {
            s.topOperatorItemWidthAsString = getAttributeAsString("topOperatorItemWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.topOperatorItemWidthAsString:" + t.getMessage() + "\n";
        }
        try {
            s.topOperatorOptions = getAttributeAsStringArray("topOperatorOptions");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.topOperatorOptionsArray:" + t.getMessage() + "\n";
        }
        try {
            s.topOperatorTitle = getAttributeAsString("topOperatorTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.topOperatorTitle:" + t.getMessage() + "\n";
        }
        try {
            s.validateOnChange = getAttributeAsString("validateOnChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.validateOnChange:" + t.getMessage() + "\n";
        }
        try {
            s.valueItemWidthAsString = getAttributeAsString("valueItemWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.valueItemWidthAsString:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        FilterBuilderLogicalStructure s = new FilterBuilderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
