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
 
package com.smartgwt.client.util.workflow;


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


/**
 * Edit an existing record in a grid or start editing a new one. A new record is added unless {@link
 * com.smartgwt.client.util.workflow.GridEditRecordTask#getCriteria criteria} is specified. Alternatively, if {@link
 * com.smartgwt.client.util.workflow.GridEditRecordTask#getEditFirstRecord editFirstRecord} is specified, the first record
 * is edited.  <p> If criteria is provided and the criteria matches more than one record, the first matched record is
 * edited. Additionally, if the record to be edited is not visible, the record will be scrolled into view. <p> Note that
 * the record to be matched must already be loaded in the grid - no fetch will be performed.
 * @see com.smartgwt.client.widgets.grid.ListGrid#editExistingRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#startEditingNew
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GridEditRecordTask")
public class GridEditRecordTask extends ComponentTask {

    public static GridEditRecordTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (GridEditRecordTask) obj;
        } else {
            return new GridEditRecordTask(jsObj);
        }
    }
        


    public GridEditRecordTask(){
        scClassName = "GridEditRecordTask";
    }

    public GridEditRecordTask(JavaScriptObject jsObj){
        scClassName = "GridEditRecordTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Criteria (including AdvancedCriteria) used to locate the record to be edited. If criteria matches more than one record,
     * the first record is edited. <P> Data values in this criteria prefixed with "$" will be treated as dynamic expressions
     * which can access the inputs to this task as $input - see {@link com.smartgwt.client.docs.TaskInputExpression}. 
     * Specifically, this means that for simple criteria, any property value that is a String and is prefixed with "$" will be
     * assumed to be an expression, and for AdvancedCriteria, the same treatment will be applied to {@link
     * com.smartgwt.client.data.Criterion#getValue Criterion.value}. <p> This property supports {@link
     * com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @param criteria New criteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridEditRecordTask GridEditRecordTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditRecordTask setCriteria(Criteria criteria)  throws IllegalStateException {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (GridEditRecordTask)setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), false);
    }

    /**
     * Criteria (including AdvancedCriteria) used to locate the record to be edited. If criteria matches more than one record,
     * the first record is edited. <P> Data values in this criteria prefixed with "$" will be treated as dynamic expressions
     * which can access the inputs to this task as $input - see {@link com.smartgwt.client.docs.TaskInputExpression}. 
     * Specifically, this means that for simple criteria, any property value that is a String and is prefixed with "$" will be
     * assumed to be an expression, and for AdvancedCriteria, the same treatment will be applied to {@link
     * com.smartgwt.client.data.Criterion#getValue Criterion.value}. <p> This property supports {@link
     * com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @return Current criteria value. Default value is null
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * When neither {@link com.smartgwt.client.util.workflow.GridEditRecordTask#getInitialValues initialValues} nor {@link
     * com.smartgwt.client.data.Criteria} are provided should the first record in the grid be edited? If not set, a new record
     * is added.
     *
     * @param editFirstRecord New editFirstRecord value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridEditRecordTask GridEditRecordTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditRecordTask setEditFirstRecord(Boolean editFirstRecord)  throws IllegalStateException {
        return (GridEditRecordTask)setAttribute("editFirstRecord", editFirstRecord, false);
    }

    /**
     * When neither {@link com.smartgwt.client.util.workflow.GridEditRecordTask#getInitialValues initialValues} nor {@link
     * com.smartgwt.client.data.Criteria} are provided should the first record in the grid be edited? If not set, a new record
     * is added.
     *
     * @return Current editFirstRecord value. Default value is null
     */
    public Boolean getEditFirstRecord()  {
        return getAttributeAsBoolean("editFirstRecord");
    }
    

    /**
     * Initial values for a new edit record. <p> Data values prefixed with "$" will be treated as a {@link
     * com.smartgwt.client.docs.TaskInputExpression} excluding "$input" and "$inputRecord" references.
     *
     * @param initialValues New initialValues value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridEditRecordTask GridEditRecordTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditRecordTask setInitialValues(Record initialValues)  throws IllegalStateException {
        return (GridEditRecordTask)setAttribute("initialValues", initialValues == null ? null : initialValues.getJsObj(), false);
    }

    /**
     * Initial values for a new edit record. <p> Data values prefixed with "$" will be treated as a {@link
     * com.smartgwt.client.docs.TaskInputExpression} excluding "$input" and "$inputRecord" references.
     *
     * @return Current initialValues value. Default value is null
     */
    public Record getInitialValues()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("initialValues"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
