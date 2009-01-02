/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.logical.shared.HasHandlers;
   /**
    * A form that allows the user to input advanced search criteria, including operators on field values such as "less than", and sub-clauses using "AND" and "OR" operators. <P> A FilterBuilder produces an ${isc.DocUtils.linkForRef('object:AdvancedCriteria')} object, which the {@link com.smartgwt.client.data.DataSource} subsystem can use to filter datasets, including the ability to perform such filtering within the browser for datasets that are completely loaded.

    */
public class FilterBuilder extends Layout {

    public static FilterBuilder getOrCreateRef(JavaScriptObject jsObj) {
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (FilterBuilder) obj;
        } else {
            return new FilterBuilder(jsObj);
        }
    }


    public FilterBuilder(){
        
    }

    public FilterBuilder(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.FilterBuilder.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * If true, when the user hits the Enter key while focussed in a text-item in this  FilterBuilder, we automatically invoke the user-supplied {@link com.smartgwt.client.widgets.form.FilterBuilder#search} method.
    *
    * @param saveOnExit saveOnExit Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSaveOnExit(Boolean saveOnExit)  throws IllegalStateException {
        setAttribute("saveOnExit", saveOnExit, false);
    }
    /**
     * If true, when the user hits the Enter key while focussed in a text-item in this  FilterBuilder, we automatically invoke the user-supplied {@link com.smartgwt.client.widgets.form.FilterBuilder#search} method.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSaveOnExit()  {
        return getAttributeAsBoolean("saveOnExit");
    }

    /**
    * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual field names instead.
    *
    * @param showFieldTitles showFieldTitles Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowFieldTitles(Boolean showFieldTitles)  throws IllegalStateException {
        setAttribute("showFieldTitles", showFieldTitles, false);
    }
    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual field names instead.
     *
     *
     * @return Boolean
     *
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
     *
     */
    public Boolean getShowRemoveButton()  {
        return getAttributeAsBoolean("showRemoveButton");
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
     *
     */
    public Boolean getShowAddButton()  {
        return getAttributeAsBoolean("showAddButton");
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
     *
     */
    public Boolean getAllowEmpty()  {
        return getAttributeAsBoolean("allowEmpty");
    }

    /**
    * For operators that check that a value is within a range, text to show between the start and end input fields for specifying the limits of the range.
    *
    * @param rangeSeparator rangeSeparator Default value is ">>"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setRangeSeparator(String rangeSeparator)  throws IllegalStateException {
        setAttribute("rangeSeparator", rangeSeparator, false);
    }
    /**
     * For operators that check that a value is within a range, text to show between the start and end input fields for specifying the limits of the range.
     *
     *
     * @return String
     *
     */
    public String getRangeSeparator()  {
        return getAttributeAsString("rangeSeparator");
    }

    /**
    * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the ${isc.DocUtils.linkForRef('type:TopOperatorAppearance')} is "radio", true in all other cases.
    *
    * @param showSubClauseButton showSubClauseButton Default value is See Description
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowSubClauseButton(Boolean showSubClauseButton)  throws IllegalStateException {
        setAttribute("showSubClauseButton", showSubClauseButton, false);
    }
    /**
     * Whether to show a button that allows the user to add subclauses.  Defaults to false if  the ${isc.DocUtils.linkForRef('type:TopOperatorAppearance')} is "radio", true in all other cases.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowSubClauseButton()  {
        return getAttributeAsBoolean("showSubClauseButton");
    }

    // ********************* Methods ***********************







        /**
         * Clear all current criteria.
         */
        public native void clearCriteria() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.clearCriteria();
        }-*/;



        /**
         * Handler fired when there is a change() event fired on any FormItem within the  filterBuilder.
         */
        public native void filterChanged() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.filterChanged();
        }-*/;

    // ********************* Static Methods ***********************





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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataSource(DataSource dataSource) throws IllegalStateException {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), false);
    }


    /**
     * How to display and edit the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperator topOperator} for
     * this FilterBuilder. <P> See ${isc.DocUtils.linkForRef('type:TopOperatorAppearance')} for a list of options.
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
     * specify {@link com.smartgwt.client..Criterion#getFieldName fieldName} only will generate an expression with the
     * operator not chosen yet, and a ${isc.DocUtils.linkForRef('object:Criterion')} with a logical operator ("and" or
     * "or") but not ${isc.DocUtils.linkForRef('criteria.criteria','subcriteria')} defined will generate an empty
     * subclause. Set new criteria for editing.   <P> An interface for editing the provided criteria will be generated
     * identically to what happens when initialized with ${isc.DocUtils.linkForRef('type:Criteria')}. <P> Any existing
     * criteria entered by the user will be discarded.
     *
     * @param criteria new criteria.  Pass null or {} to effectively reset the
     *                 filterBuilder to it's initial state when no criteria are
     *                 specified. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCriteria(AdvancedCriteria criteria) throws IllegalStateException {
        setAttribute("criteria", criteria, false);
    }

    /**
     * Initial criteria. <P> When initialized with criteria, appropriate clauses for editing the provided criteria will
     * be automatically generated. <P> Note that empty or partial criteria are allowed, for example, criteria that
     * specify {@link com.smartgwt.client..Criterion#getFieldName fieldName} only will generate an expression with the
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






