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
 * A form that allows the user to input advanced search criteria, including operators on field values such as "less than",
 * and sub-clauses using "AND" and "OR" operators. <P> A FilterBuilder produces an {@link
 * com.smartgwt.client.data.AdvancedCriteria} object, which the {@link com.smartgwt.client.data.DataSource} subsystem can
 * use to filter datasets, including the ability to perform such filtering within the browser for datasets that are
 * completely loaded.
 */
public class FilterBuilder extends Layout  implements com.smartgwt.client.widgets.form.events.HasFilterChangedHandlers, com.smartgwt.client.widgets.form.events.HasSearchHandlers {

    public static FilterBuilder getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (FilterBuilder) obj;
        } else {
            return new FilterBuilder(jsObj);
        }
    }

    public FilterBuilder(){
        scClassName = "FilterBuilder";
    }

    public FilterBuilder(JavaScriptObject jsObj){
        super(jsObj);
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
     * @param addButtonPrompt addButtonPrompt Default value is "Add"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddButtonPrompt(String addButtonPrompt)  throws IllegalStateException {
        setAttribute("addButtonPrompt", addButtonPrompt, false);
    }

    /**
     * The hover prompt text for the add button.
     *
     *
     * @return String
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
     * Title for the "And Not" operator (only applicable to the "inline" appearance)
     *
     * @param inlineAndNotTitle inlineAndNotTitle Default value is "and not"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineAndNotTitle(String inlineAndNotTitle)  throws IllegalStateException {
        setAttribute("inlineAndNotTitle", inlineAndNotTitle, false);
    }

    /**
     * Title for the "And Not" operator (only applicable to the "inline" appearance)
     *
     *
     * @return String
     */
    public String getInlineAndNotTitle()  {
        return getAttributeAsString("inlineAndNotTitle");
    }

    /**
     * Title for the "And" operator (only applicable to the "inline" appearance)
     *
     * @param inlineAndTitle inlineAndTitle Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineAndTitle(String inlineAndTitle)  throws IllegalStateException {
        setAttribute("inlineAndTitle", inlineAndTitle, false);
    }

    /**
     * Title for the "And" operator (only applicable to the "inline" appearance)
     *
     *
     * @return String
     */
    public String getInlineAndTitle()  {
        return getAttributeAsString("inlineAndTitle");
    }

    /**
     * Title for the "Or" operator (only applicable to the "inline" appearance)
     *
     * @param inlineOrTitle inlineOrTitle Default value is "or"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInlineOrTitle(String inlineOrTitle)  throws IllegalStateException {
        setAttribute("inlineOrTitle", inlineOrTitle, false);
    }

    /**
     * Title for the "Or" operator (only applicable to the "inline" appearance)
     *
     *
     * @return String
     */
    public String getInlineOrTitle()  {
        return getAttributeAsString("inlineOrTitle");
    }

    /**
     * Title for the "Match All" (and) operator
     *
     * @param matchAllTitle matchAllTitle Default value is "Match All"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchAllTitle(String matchAllTitle)  throws IllegalStateException {
        setAttribute("matchAllTitle", matchAllTitle, false);
    }

    /**
     * Title for the "Match All" (and) operator
     *
     *
     * @return String
     */
    public String getMatchAllTitle()  {
        return getAttributeAsString("matchAllTitle");
    }

    /**
     * Title for the "Match Any" (or) operator
     *
     * @param matchAnyTitle matchAnyTitle Default value is "Match Any"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchAnyTitle(String matchAnyTitle)  throws IllegalStateException {
        setAttribute("matchAnyTitle", matchAnyTitle, false);
    }

    /**
     * Title for the "Match Any" (or) operator
     *
     *
     * @return String
     */
    public String getMatchAnyTitle()  {
        return getAttributeAsString("matchAnyTitle");
    }

    /**
     * Title for the "Match None" (not) operator
     *
     * @param matchNoneTitle matchNoneTitle Default value is "Match None"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMatchNoneTitle(String matchNoneTitle)  throws IllegalStateException {
        setAttribute("matchNoneTitle", matchNoneTitle, false);
    }

    /**
     * Title for the "Match None" (not) operator
     *
     *
     * @return String
     */
    public String getMatchNoneTitle()  {
        return getAttributeAsString("matchNoneTitle");
    }

    /**
     * The message to display next to fieldNames that do not exist in the available dataSource.
     *
     * @param missingFieldPrompt missingFieldPrompt Default value is "[missing field definition]"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMissingFieldPrompt(String missingFieldPrompt)  throws IllegalStateException {
        setAttribute("missingFieldPrompt", missingFieldPrompt, false);
    }

    /**
     * The message to display next to fieldNames that do not exist in the available dataSource.
     *
     *
     * @return String
     */
    public String getMissingFieldPrompt()  {
        return getAttributeAsString("missingFieldPrompt");
    }

    /**
     * For operators that check that a value is within a range, text to show between the start and end input fields for
     * specifying the limits of the range.
     *
     * @param rangeSeparator rangeSeparator Default value is "and"
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
     * @return String
     */
    public String getRangeSeparator()  {
        return getAttributeAsString("rangeSeparator");
    }

    /**
     * The hover prompt text for the remove button.
     *
     * @param removeButtonPrompt removeButtonPrompt Default value is "Remove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        setAttribute("removeButtonPrompt", removeButtonPrompt, false);
    }

    /**
     * The hover prompt text for the remove button.
     *
     *
     * @return String
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
     * If true, causes a CheckboxItem to appear to the left of each clause in "inline"   appearance.  This checkbox allows the
     * user to select  individual clauses so that, for example, clauses can be removed from the filterBuilder  by application
     * code.  This property is ignored for appearances other than "inline".
     *
     * @param showSelectionCheckbox showSelectionCheckbox Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowSelectionCheckbox(Boolean showSelectionCheckbox)  throws IllegalStateException {
        setAttribute("showSelectionCheckbox", showSelectionCheckbox, false);
    }

    /**
     * If true, causes a CheckboxItem to appear to the left of each clause in "inline"   appearance.  This checkbox allows the
     * user to select  individual clauses so that, for example, clauses can be removed from the filterBuilder  by application
     * code.  This property is ignored for appearances other than "inline".
     *
     *
     * @return Boolean
     */
    public Boolean getShowSelectionCheckbox()  {
        return getAttributeAsBoolean("showSelectionCheckbox");
    }

    /**
     * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the TopOperatorAppearance is
     * "radio" or "inline", true in all other cases.
     *
     * @param showSubClauseButton showSubClauseButton Default value is See Description
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowSubClauseButton(Boolean showSubClauseButton)  throws IllegalStateException {
        setAttribute("showSubClauseButton", showSubClauseButton, false);
    }

    /**
     * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the TopOperatorAppearance is
     * "radio" or "inline", true in all other cases.
     *
     *
     * @return Boolean
     */
    public Boolean getShowSubClauseButton()  {
        return getAttributeAsBoolean("showSubClauseButton");
    }

    /**
     * The hover prompt text for the subClauseButton.
     *
     * @param subClauseButtonPrompt subClauseButtonPrompt Default value is "Add Subclause"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubClauseButtonPrompt(String subClauseButtonPrompt)  throws IllegalStateException {
        setAttribute("subClauseButtonPrompt", subClauseButtonPrompt, false);
    }

    /**
     * The hover prompt text for the subClauseButton.
     *
     *
     * @return String
     */
    public String getSubClauseButtonPrompt()  {
        return getAttributeAsString("subClauseButtonPrompt");
    }

    /**
     * The title of the subClauseButton
     *
     * @param subClauseButtonTitle subClauseButtonTitle Default value is "+()"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubClauseButtonTitle(String subClauseButtonTitle)  throws IllegalStateException {
        setAttribute("subClauseButtonTitle", subClauseButtonTitle, false);
    }

    /**
     * The title of the subClauseButton
     *
     *
     * @return String
     */
    public String getSubClauseButtonTitle()  {
        return getAttributeAsString("subClauseButtonTitle");
    }

    /**
     * Default logical operator for all top-level clauses in the FilterBuilder. <P> May be able to be changed by the user via
     * the UI, according to TopOperatorAppearance.
     * Programmatically change the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperator topOperator} for this FilterBuilder.
     *
     * @param topOperator new top-level operator. Default value is "and"
     */
    public void setTopOperator(LogicalOperator topOperator) {
        setAttribute("topOperator", topOperator.getValue(), true);
    }

    /**
     * Default logical operator for all top-level clauses in the FilterBuilder. <P> May be able to be changed by the user via
     * the UI, according to TopOperatorAppearance.
     *
     *
     * @return LogicalOperator
     */
    public LogicalOperator getTopOperator()  {
        return EnumUtil.getEnum(LogicalOperator.values(), getAttribute("topOperator"));
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
     * Add a new {@link com.smartgwt.client.widgets.form.FilterClause} to this FilterBuilder.
     * @param filterClause A {@link com.smartgwt.client.widgets.form.FilterClause} instance
     */
    public native void addClause(FilterClause filterClause) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addClause(filterClause.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
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
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({filterChanged:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.form.events.FilterChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.filterChanged = $entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.form.events.FilterChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Returns the type of editor to use for the field. <P> Default behavior is to use the  editorType for a custom operator,
     * otherwise,  use {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} for before/after/between operators on
     * date fields, otherwise,  use the same editor as would be chosen by a {@link
     * com.smartgwt.client.widgets.form.SearchForm}.
     * @param fieldName DataSourceField definition
     * @param operatorId {@link com.smartgwt.client.types.OperatorId} for the chosen operator
     *
     * @return Smart GWT class to use (must be subclass of FormItem)
     */
    public native String getEditorType(DataSourceField fieldName, OperatorId operatorId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEditorType(fieldName.@com.smartgwt.client.core.DataClass::getJsObj()(), operatorId.@com.smartgwt.client.types.OperatorId::getValue()());
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
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({search:$entry(function(){
                        var param = {"criteria" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.form.events.FilterSearchEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.search = $entry(function(){
                   var param = {"criteria" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.form.events.FilterSearchEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
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
     * Initial criteria. <P> When initialized with criteria, appropriate clauses for editing the provided criteria will
     * be automatically generated. <P> Note that empty or partial criteria are allowed, for example, criteria that
     * specify {@link com.smartgwt.client.data.Criterion#getFieldName fieldName} only will generate an expression with the
     * operator not chosen yet, and a ${isc.DocUtils.linkForRef('object:Criterion')} with a logical operator ("and" or
     * "or") but not ${isc.DocUtils.linkForRef('criteria.criteria','subcriteria')} defined will generate an empty
     * subclause.
     *
     * @return Get the criteria entered by the user.
     */
    public native AdvancedCriteria getCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = self.getCriteria();
        return @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;

}







