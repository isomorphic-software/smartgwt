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
 * A form that allows the user to input advanced search criteria, including operators on field values such as "less than",
 * and sub-clauses using "AND" and "OR" operators. <P> A FilterBuilder produces an {@link
 * com.smartgwt.client.data.AdvancedCriteria} object, which the {@link com.smartgwt.client.data.DataSource} subsystem can
 * use to filter datasets, including the ability to perform such filtering within the browser for datasets that are
 * completely loaded. <P> The operators available for each field can be customized at the DataSource level via {@link
 * com.smartgwt.client.data.DataSourceField#getValidOperators validOperators}, {@link
 * com.smartgwt.client.data.DataSource#setTypeOperators DataSource.setTypeOperators} and related APIs.
 */
public class FilterBuilder extends Layout  implements com.smartgwt.client.widgets.form.events.HasFilterChangedHandlers, com.smartgwt.client.widgets.form.events.HasSearchHandlers {

    public native static FilterBuilder getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("FilterBuilder",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.form.FilterBuilder::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


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
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * The hover prompt text for the add button.
     *
     * @param addButtonPrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "Add"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddButtonPrompt(String addButtonPrompt)  throws IllegalStateException {
        setAttribute("addButtonPrompt", addButtonPrompt, false);
    }

    /**
     * The hover prompt text for the add button.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getAddButtonPrompt()  {
        return getAttributeAsString("addButtonPrompt");
    }

    /**
     * If set to false, the last clause cannot be removed.
     *
     * @param allowEmpty allowEmpty Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowEmpty(Boolean allowEmpty)  throws IllegalStateException {
        setAttribute("allowEmpty", allowEmpty, false);
    }

    /**
     * If set to false, the last clause cannot be removed.
     *
     *
     * @return Boolean
     */
    public Boolean getAllowEmpty()  {
        return getAttributeAsBoolean("allowEmpty");
    }

    /**
     * If specified, the FilterBuilder will dynamically fetch DataSourceField definitions from  this DataSource rather than
     * using {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSource dataSource}.  The {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker fieldPicker}  will default to being a {@link
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
     * @param fieldDataSource fieldDataSource Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldDataSource(DataSource fieldDataSource)  throws IllegalStateException {
        setAttribute("fieldDataSource", fieldDataSource == null ? null : fieldDataSource.getOrCreateJsObj(), false);
    }

    /**
     * If specified, the FilterBuilder will dynamically fetch DataSourceField definitions from  this DataSource rather than
     * using {@link com.smartgwt.client.widgets.form.FilterBuilder#getDataSource dataSource}.  The {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker fieldPicker}  will default to being a {@link
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
     *
     * @return DataSource
     */
    public DataSource getFieldDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("fieldDataSource"));
    }

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker fieldPicker}
     * autoChild FormItem.
     *
     * @param fieldPickerProperties fieldPickerProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerProperties(FormItem fieldPickerProperties)  throws IllegalStateException {
        setAttribute("fieldPickerProperties", fieldPickerProperties.getJsObj(), false);
    }

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker fieldPicker}
     * autoChild FormItem.
     *
     *
     * @return FormItem
     */
    public FormItem getFieldPickerProperties()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("fieldPickerProperties"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker field-picker} select-item.
     *
     * @param fieldPickerTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Field Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerTitle(String fieldPickerTitle)  throws IllegalStateException {
        setAttribute("fieldPickerTitle", fieldPickerTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker field-picker} select-item.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFieldPickerTitle()  {
        return getAttributeAsString("fieldPickerTitle");
    }

    /**
     * Title for the "And Not" operator (only applicable to the "inline" appearance)
     *
     * @param inlineAndNotTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "and not"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineAndNotTitle(String inlineAndNotTitle)  throws IllegalStateException {
        setAttribute("inlineAndNotTitle", inlineAndNotTitle, false);
    }

    /**
     * Title for the "And Not" operator (only applicable to the "inline" appearance)
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getInlineAndNotTitle()  {
        return getAttributeAsString("inlineAndNotTitle");
    }

    /**
     * Title for the "And" operator (only applicable to the "inline" appearance)
     *
     * @param inlineAndTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineAndTitle(String inlineAndTitle)  throws IllegalStateException {
        setAttribute("inlineAndTitle", inlineAndTitle, false);
    }

    /**
     * Title for the "And" operator (only applicable to the "inline" appearance)
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getInlineAndTitle()  {
        return getAttributeAsString("inlineAndTitle");
    }

    /**
     * Title for the "Or" operator (only applicable to the "inline" appearance)
     *
     * @param inlineOrTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "or"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineOrTitle(String inlineOrTitle)  throws IllegalStateException {
        setAttribute("inlineOrTitle", inlineOrTitle, false);
    }

    /**
     * Title for the "Or" operator (only applicable to the "inline" appearance)
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getInlineOrTitle()  {
        return getAttributeAsString("inlineOrTitle");
    }

    /**
     * Title for the "Match All" (and) operator  when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @param matchAllTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Match All"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchAllTitle(String matchAllTitle)  throws IllegalStateException {
        setAttribute("matchAllTitle", matchAllTitle, false);
    }

    /**
     * Title for the "Match All" (and) operator  when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMatchAllTitle()  {
        return getAttributeAsString("matchAllTitle");
    }

    /**
     * Title for the "Match Any" (or) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @param matchAnyTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Match Any"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchAnyTitle(String matchAnyTitle)  throws IllegalStateException {
        setAttribute("matchAnyTitle", matchAnyTitle, false);
    }

    /**
     * Title for the "Match Any" (or) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMatchAnyTitle()  {
        return getAttributeAsString("matchAnyTitle");
    }

    /**
     * Title for the "Match None" (not) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     * @param matchNoneTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Match None"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchNoneTitle(String matchNoneTitle)  throws IllegalStateException {
        setAttribute("matchNoneTitle", matchNoneTitle, false);
    }

    /**
     * Title for the "Match None" (not) operator when using {@link com.smartgwt.client.types.TopOperatorAppearance
     * topOperatorAppearance}:"radio".
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMatchNoneTitle()  {
        return getAttributeAsString("matchNoneTitle");
    }

    /**
     * The message to display next to fieldNames that do not exist in the available dataSource.
     *
     * @param missingFieldPrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "[missing field definition]"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMissingFieldPrompt(String missingFieldPrompt)  throws IllegalStateException {
        setAttribute("missingFieldPrompt", missingFieldPrompt, false);
    }

    /**
     * The message to display next to fieldNames that do not exist in the available dataSource.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMissingFieldPrompt()  {
        return getAttributeAsString("missingFieldPrompt");
    }

    /**
     * The title for the operator-picker select-item.
     *
     * @param operatorPickerTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Operator"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperatorPickerTitle(String operatorPickerTitle)  throws IllegalStateException {
        setAttribute("operatorPickerTitle", operatorPickerTitle, false);
    }

    /**
     * The title for the operator-picker select-item.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getOperatorPickerTitle()  {
        return getAttributeAsString("operatorPickerTitle");
    }

    /**
     * The title for the Operator RadioGroupItem displayed in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getRadioOperatorForm radioOperatorForm}.
     *
     * @param radioOperatorTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Overall Operator"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRadioOperatorTitle(String radioOperatorTitle)  throws IllegalStateException {
        setAttribute("radioOperatorTitle", radioOperatorTitle, false);
    }

    /**
     * The title for the Operator RadioGroupItem displayed in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getRadioOperatorForm radioOperatorForm}.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getRadioOperatorTitle()  {
        return getAttributeAsString("radioOperatorTitle");
    }

    /**
     * For operators that check that a value is within a range, text to show between the start and end input fields for
     * specifying the limits of the range.
     *
     * @param rangeSeparator . See {@link com.smartgwt.client.docs.String String}. Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRangeSeparator(String rangeSeparator)  throws IllegalStateException {
        setAttribute("rangeSeparator", rangeSeparator, false);
    }

    /**
     * For operators that check that a value is within a range, text to show between the start and end input fields for
     * specifying the limits of the range.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getRangeSeparator()  {
        return getAttributeAsString("rangeSeparator");
    }

    /**
     * The hover prompt text for the remove button.
     *
     * @param removeButtonPrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "Remove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        setAttribute("removeButtonPrompt", removeButtonPrompt, false);
    }

    /**
     * The hover prompt text for the remove button.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getRemoveButtonPrompt()  {
        return getAttributeAsString("removeButtonPrompt");
    }

    /**
     * Dictates whether values entered by a user should be retained in the value fields when a  different field is selected. 
     * Default value is true. <P> Note that, when switching between fields that have an optionDataSource or valueMap, this
     * property is ignored and the values are never retained.
     *
     * @param retainValuesAcrossFields retainValuesAcrossFields Default value is true
     */
    public void setRetainValuesAcrossFields(Boolean retainValuesAcrossFields) {
        setAttribute("retainValuesAcrossFields", retainValuesAcrossFields, true);
    }

    /**
     * Dictates whether values entered by a user should be retained in the value fields when a  different field is selected. 
     * Default value is true. <P> Note that, when switching between fields that have an optionDataSource or valueMap, this
     * property is ignored and the values are never retained.
     *
     *
     * @return Boolean
     */
    public Boolean getRetainValuesAcrossFields()  {
        return getAttributeAsBoolean("retainValuesAcrossFields");
    }

    /**
     * If true, when the user hits the Enter key while focused in a text-item in this  FilterBuilder, we automatically invoke
     * the user-supplied {@link com.smartgwt.client.widgets.form.FilterBuilder#addSearchHandler FilterBuilder.search} method.
     *
     * @param saveOnEnter saveOnEnter Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSaveOnEnter(Boolean saveOnEnter)  throws IllegalStateException {
        setAttribute("saveOnEnter", saveOnEnter, false);
    }

    /**
     * If true, when the user hits the Enter key while focused in a text-item in this  FilterBuilder, we automatically invoke
     * the user-supplied {@link com.smartgwt.client.widgets.form.FilterBuilder#addSearchHandler FilterBuilder.search} method.
     *
     *
     * @return Boolean
     */
    public Boolean getSaveOnEnter()  {
        return getAttributeAsBoolean("saveOnEnter");
    }

    /**
     * If set, a button will be shown underneath all current clauses allowing a new clause to be added.
     *
     * @param showAddButton showAddButton Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowAddButton(Boolean showAddButton)  throws IllegalStateException {
        setAttribute("showAddButton", showAddButton, false);
    }

    /**
     * If set, a button will be shown underneath all current clauses allowing a new clause to be added.
     *
     *
     * @return Boolean
     */
    public Boolean getShowAddButton()  {
        return getAttributeAsBoolean("showAddButton");
    }

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     * @param showFieldTitles showFieldTitles Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowFieldTitles(Boolean showFieldTitles)  throws IllegalStateException {
        setAttribute("showFieldTitles", showFieldTitles, false);
    }

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     *
     * @return Boolean
     */
    public Boolean getShowFieldTitles()  {
        return getAttributeAsBoolean("showFieldTitles");
    }

    /**
     * If set, a button will be shown for each clause allowing it to be removed.
     *
     * @param showRemoveButton showRemoveButton Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRemoveButton(Boolean showRemoveButton)  throws IllegalStateException {
        setAttribute("showRemoveButton", showRemoveButton, false);
    }

    /**
     * If set, a button will be shown for each clause allowing it to be removed.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRemoveButton()  {
        return getAttributeAsBoolean("showRemoveButton");
    }

    /**
     * If true, causes a CheckboxItem to appear to the left of each clause in "inline"  {@link
     * com.smartgwt.client.types.TopOperatorAppearance appearance}.  This checkbox allows the user to select  individual
     * clauses so that, for example, clauses can be removed from the filterBuilder  by application code.  This property is
     * ignored for appearances other than "inline".
     *
     * @param showSelectionCheckbox showSelectionCheckbox Default value is false
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
     *
     * @return Boolean
     */
    public Boolean getShowSelectionCheckbox()  {
        return getAttributeAsBoolean("showSelectionCheckbox");
    }

    /**
     * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the {@link
     * com.smartgwt.client.types.TopOperatorAppearance} is "radio" or "inline", true in all other cases.
     *
     * @param showSubClauseButton showSubClauseButton Default value is See Description
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowSubClauseButton(Boolean showSubClauseButton)  throws IllegalStateException {
        setAttribute("showSubClauseButton", showSubClauseButton, false);
    }

    /**
     * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the {@link
     * com.smartgwt.client.types.TopOperatorAppearance} is "radio" or "inline", true in all other cases.
     *
     *
     * @return Boolean
     */
    public Boolean getShowSubClauseButton()  {
        return getAttributeAsBoolean("showSubClauseButton");
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker fieldPicker} items be sorted
     * alphabetically in the drop down list.
     *
     * @param sortFields sortFields Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSortFields(Boolean sortFields)  throws IllegalStateException {
        setAttribute("sortFields", sortFields, false);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker fieldPicker} items be sorted
     * alphabetically in the drop down list.
     *
     *
     * @return Boolean
     */
    public Boolean getSortFields()  {
        return getAttributeAsBoolean("sortFields");
    }

    /**
     * The hover prompt text for the subClauseButton.
     *
     * @param subClauseButtonPrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "Add Subclause"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubClauseButtonPrompt(String subClauseButtonPrompt)  throws IllegalStateException {
        setAttribute("subClauseButtonPrompt", subClauseButtonPrompt, false);
    }

    /**
     * The hover prompt text for the subClauseButton.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getSubClauseButtonPrompt()  {
        return getAttributeAsString("subClauseButtonPrompt");
    }

    /**
     * The title of the subClauseButton
     *
     * @param subClauseButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "+()"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubClauseButtonTitle(String subClauseButtonTitle)  throws IllegalStateException {
        setAttribute("subClauseButtonTitle", subClauseButtonTitle, false);
    }

    /**
     * The title of the subClauseButton
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     *
     * @return LogicalOperator
     */
    public LogicalOperator getTopOperator()  {
        return EnumUtil.getEnum(LogicalOperator.values(), getAttribute("topOperator"));
    }

    /**
     * The title for the left-aligned Operator selectItem in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorForm topOperatorForm}.
     *
     * @param topOperatorTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Clause Operator"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTopOperatorTitle(String topOperatorTitle)  throws IllegalStateException {
        setAttribute("topOperatorTitle", topOperatorTitle, false);
    }

    /**
     * The title for the left-aligned Operator selectItem in the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getTopOperatorForm topOperatorForm}.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getTopOperatorTitle()  {
        return getAttributeAsString("topOperatorTitle");
    }

    /**
     * If true (the default), validates each entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterBuilder</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#validate FilterBuilder.validate} from your own code.
     *
     * @param validateOnChange validateOnChange Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValidateOnChange(Boolean validateOnChange)  throws IllegalStateException {
        setAttribute("validateOnChange", validateOnChange, false);
    }

    /**
     * If true (the default), validates each entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterBuilder</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#validate FilterBuilder.validate} from your own code.
     *
     *
     * @return Boolean
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    // ********************* Methods ***********************

    /**
     * Add a new {@link com.smartgwt.client.widgets.form.FilterClause} to this FilterBuilder. <P> This API is intended for the
     * rare use case of adding a highly customized FilterClause component that does not include the standard
     * field/operator/value picking interface, instead providing a custom interface and returning a criterion via {@link
     * com.smartgwt.client.widgets.form.FilterClause#getCriterion FilterClause.getCriterion}. <P> If you just want to
     * programmatically add a new FilterClause showing a specific Criterion use {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#addCriterion FilterBuilder.addCriterion}. <P> If you want to use the
     * standard field/operator/value interface but provide a custom control for editing the value, see {@link
     * com.smartgwt.client.data.DataSource#addSearchOperator DataSource.addSearchOperator} and  editorType.
     * @param filterClause A {@link com.smartgwt.client.widgets.form.FilterClause} instance
     */
    public native void addClause(FilterClause filterClause) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addClause(filterClause.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Add a new criterion, including recursively adding sub-criteria for a criterion that contains other criteria.
     * @param criterion new criterion to be added
     */
    public native void addCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Clear all current criteria.
     */
    public native void clearCriteria() /*-{
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
        var obj = null;
        var selfJ = this;
        var filterChanged = $entry(function(){
            var param = {};

                var event = @com.smartgwt.client.widgets.form.events.FilterChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({filterChanged:  filterChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.filterChanged =  filterChanged             ;
        }
   }-*/;

    /**
     * Returns the type of editor to use for the field. <P> Default behavior is to use the  editorType for a custom operator,
     * otherwise,  use {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} for before/after/between operators on
     * date fields, otherwise,  use the same editor as would be chosen by a {@link
     * com.smartgwt.client.widgets.form.SearchForm}.
     * @param field DataSourceField definition
     * @param operatorId {@link com.smartgwt.client.types.OperatorId} for the chosen operator
     *
     * @return Smart GWT class to use (must be subclass of FormItem)
     */
    public native String getEditorType(DataSourceField field, OperatorId operatorId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEditorType(field.@com.smartgwt.client.core.DataClass::getJsObj()(), operatorId.@com.smartgwt.client.types.OperatorId::getValue()());
    }-*/;
    /**
     * Add a search handler.
     * <p>
     * A StringMethod that is automatically invoked if {@link com.smartgwt.client.widgets.form.FilterBuilder#getSaveOnEnter
     * saveOnEnter} is set  and the user presses Enter whilst in a text-item in any clause or subclause.
     *
     * @param handler the search handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSearchHandler(com.smartgwt.client.widgets.form.events.SearchHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.FilterSearchEvent.getType()) == 0) setupSearchEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.FilterSearchEvent.getType());
    }

    private native void setupSearchEvent() /*-{
        var obj = null;
        var selfJ = this;
        var search = $entry(function(){
            var param = {"criteria" : arguments[0]};

                var event = @com.smartgwt.client.widgets.form.events.FilterSearchEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({search:  search              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.search =  search             ;
        }
   }-*/;

    /**
     * Validate the clauses of this FilterBuilder.
     *
     * @return true if all clauses are valid, false otherwise
     */
    public native Boolean validate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.validate();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
     * @param filterBuilderProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(FilterBuilder filterBuilderProperties) /*-{
    	var properties = $wnd.isc.addProperties({},filterBuilderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
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
     * DataSource this filter should use for field definitions and available ${isc.DocUtils.linkForRef('object:Operator')}s.
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * How to display and edit the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperator topOperator} for
     * this FilterBuilder. <P> See {@link TopOperatorAppearance} for a list of options.
     *
     * @param topOperatorAppearance topOperatorAppearance Default value is "bracket"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTopOperatorAppearance(TopOperatorAppearance topOperatorAppearance) throws IllegalStateException {
        setAttribute("topOperatorAppearance", topOperatorAppearance.getValue(), false);
    }


    /**
     * Initial criteria. <P> When initialized with criteria, appropriate clauses for editing the provided criteria will
     * be automatically generated. <P> Note that empty or partial criteria are allowed, for example, criteria that
     * specify {@link com.smartgwt.client.data.Criterion#getFieldName fieldName} only will generate an expression with the
     * operator not chosen yet, and a ${isc.DocUtils.linkForRef('object:Criterion')} with a logical operator ("and" or
     * "or") but not ${isc.DocUtils.linkForRef('criteria.criteria','subcriteria')} defined will generate an empty
     * subclause. Set new criteria for editing.   <P> An interface for editing the provided criteria will be generated
     * identically to what happens when initialized with {@link com.smartgwt.client.data.Criteria}. <P> Any existing
     * criteria entered by the user will be discarded.
     *
     * @param criteria new criteria.  Pass null or {} to effectively reset the
     *                 filterBuilder to it's initial state when no criteria are
     *                 specified. Default value is null
     */
    public void setCriteria(AdvancedCriteria criteria) {
        setAttribute("criteria", criteria == null ? null : criteria, true);
    }

    /**
     * Get the edited criteria entered by the user.
     *
     * @return Get the criteria entered by the user.
     */
    public native AdvancedCriteria getCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = self.getCriteria();
        return @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;
    
    /**
     * Get the edited criteria entered by the user.
     *
     * @param By default if a user has selected a field and operator type, but has failed to enter a value for 
     *          the field it will be skipped. This optional parameter allows you to retrieve all criteria, 
     *          including those with an empty value attribute.
     * @return Get the criteria entered by the user.
     */
    public native AdvancedCriteria getCriteria(boolean includeEmptyValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = self.getCriteria(includeEmptyValues);
        return @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;
    
    /**
     * Returns the list of this FilterBuilder's FilterClauses that are currently selected.  A  clause is "selected" if the user
     * has checked the checkbox next to it; therefore, this  method always returns an empty list unless the  {@link
     * com.smartgwt.client.widgets.form.FilterBuilder#getShowSelectionCheckbox showSelectionCheckbox} property is set.  This
     * method is only  applicable where TopOperatorAppearance is "inline" (because that is the only  appearance that supports
     * <code>showSelectionCheckbox</code>)
     *
     * @return The list of selected clauses
     */
    public native FilterClause[] getSelectedClauses() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var clauses = self.getSelectedClauses();
        return @com.smartgwt.client.widgets.form.FilterBuilder::convertToFilterClauseArray(Lcom/google/gwt/core/client/JavaScriptObject;)(clauses);
    }-*/;
    protected static FilterClause[] convertToFilterClauseArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new FilterClause[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        FilterClause[] objects = new FilterClause[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            FilterClause obj = (FilterClause) BaseWidget.getRef(componentJS);
            if (obj == null) {
                obj = new FilterClause(componentJS);
            }
            objects[i] = obj;
        }
        return objects;
    }

    
    /**
     * Remove a clause this FilterBuilder is currently showing.
     * @param clause clause as retrieved from filterBuilder.clauses
     */
    public native void removeClause(FilterClause clause) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeClause(clause.@com.smartgwt.client.widgets.BaseWidget::getJsObj()());
    }-*/;


    public Canvas[] getMembers() {
        return Canvas.convertToCanvasArray(getAttributeAsJavaScriptObject("members"));
    }
    
    /**
     * Override to return properties for the FormItem(s) used for the "value" field displayed within clauses within this
     * filterBuilder. <P> Note that the  valueType impacts when this method is called. For operators with valueType
     * <code>"fieldType"</code> or <code>"custom"</code>, a single value field is displayed. For operators with valueType
     * <code>"valueRange"</code> two value-field items are displayed (one for the start and one for the end position). The
     * <code>valueItemType</code> parameter may be used to determine which form item is being generated.
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
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

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
            s.fieldPickerProperties = getAttributeAsString("fieldPickerProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.fieldPickerProperties:" + t.getMessage() + "\n";
        }
        try {
            s.fieldPickerTitle = getAttributeAsString("fieldPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.fieldPickerTitle:" + t.getMessage() + "\n";
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
            s.operatorPickerTitle = getAttributeAsString("operatorPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.operatorPickerTitle:" + t.getMessage() + "\n";
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
            s.topOperatorTitle = getAttributeAsString("topOperatorTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.topOperatorTitle:" + t.getMessage() + "\n";
        }
        try {
            s.validateOnChange = getAttributeAsString("validateOnChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterBuilder.validateOnChange:" + t.getMessage() + "\n";
        }
        return s;
    }
    
    public LogicalStructureObject getLogicalStructure() {
        FilterBuilderLogicalStructure s = new FilterBuilderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

