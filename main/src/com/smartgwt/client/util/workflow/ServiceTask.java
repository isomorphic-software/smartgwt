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
 * A ServiceTask is an element of a {@link com.smartgwt.client.util.workflow.Process} which calls a DataSource operation, 
 * optionally using part of the {@link com.smartgwt.client.util.workflow.Process#getState process state} as inputs or
 * storing outputs in the process state. A special "export" {@link
 * com.smartgwt.client.util.workflow.ServiceTask#getOperationType operationType} is supported to perform a server export
 * based on criteria. <P> By default a ServiceTask takes the data indicated by {@link
 * com.smartgwt.client.util.workflow.Task#getInputField inputField} and/or {@link
 * com.smartgwt.client.util.workflow.Task#getInputFieldList inputFieldList} as detailed in {@link
 * com.smartgwt.client.docs.TaskIO} and uses the <code>inputRecord</code> as {@link
 * com.smartgwt.client.data.DSRequest#getData DSRequest.data}.  This means the input data becomes {@link
 * com.smartgwt.client.data.Criteria} for "fetch" and "export" operations, new record values for an "add" operation, etc. 
 * For simplicity, if no <code>inputFieldList</code> is provided and <code>inputField</code> specifies an object,
 * <code>inputData</code> is used as <code>dsRequest.data</code>. <P> Alternatively, you can set {@link
 * com.smartgwt.client.util.workflow.ServiceTask#getCriteria criteria} for a "fetch" and "export" operations, or {@link
 * com.smartgwt.client.util.workflow.ServiceTask#getValues values} for other operationTypes.  In both cases, you have the
 * ability to use simple expressions like $input.<i>fieldName</i> to take portions of the input data and use it as part of
 * the criteria or values. <P> OutputData and outputFieldList work as filters. You should determine which properties should
 * be fetched into the process state. If you want to load all data without defining every property manually you can pass a
 * name started with '$' and fetched record or records will be  placed as a record or an array of records by the name
 * without this specific symbol. <P> For example if you specify 'id' and 'name' in outputFieldList, only these properties
 * will be fetched in the process state. If you pass '$orderHeader' in outputField a whole record will be  stored in
 * process state under the 'orderHeader' key.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ServiceTask")
public class ServiceTask extends Task {

    public static ServiceTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ServiceTask) obj;
        } else {
            return new ServiceTask(jsObj);
        }
    }
        


    public ServiceTask(){
        scClassName = "ServiceTask";
    }

    public ServiceTask(JavaScriptObject jsObj){
        scClassName = "ServiceTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Criteria (including AdvancedCriteria) to use for "fetch" and "export" operations. <P> Data values in this criteria
     * prefixed with "$" will be treated as dynamic expressions which can access the inputs to this task as $input - see {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Specifically, this means that for simple criteria, any property value
     * that is a String and is prefixed with "$" will be assumed to be an expression, and for AdvancedCriteria, the same
     * treatment will be applied to {@link com.smartgwt.client.data.Criterion#getValue Criterion.value}. <P> If any data value
     * should not be treated as dynamic (for example, a "$" should be taken as literal), you can place it in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getFixedCriteria fixedCriteria} instead. <P> Ignored for any operationType
     * other than "fetch" and "export".  Update or delete operations should place the primary key to update in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values}. <p> This property supports {@link
     * com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @param criteria New criteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public ServiceTask setCriteria(Criteria criteria)  throws IllegalStateException {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (ServiceTask)setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), false);
    }

    /**
     * Criteria (including AdvancedCriteria) to use for "fetch" and "export" operations. <P> Data values in this criteria
     * prefixed with "$" will be treated as dynamic expressions which can access the inputs to this task as $input - see {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Specifically, this means that for simple criteria, any property value
     * that is a String and is prefixed with "$" will be assumed to be an expression, and for AdvancedCriteria, the same
     * treatment will be applied to {@link com.smartgwt.client.data.Criterion#getValue Criterion.value}. <P> If any data value
     * should not be treated as dynamic (for example, a "$" should be taken as literal), you can place it in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getFixedCriteria fixedCriteria} instead. <P> Ignored for any operationType
     * other than "fetch" and "export".  Update or delete operations should place the primary key to update in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values}. <p> This property supports {@link
     * com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @return Current criteria value. Default value is null
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    
    

    /**
     * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more 
     * information.
     *
     * @param exportFormat New exportFormat value. Default value is "csv"
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setExportFormat(ExportFormat exportFormat)  throws IllegalStateException {
        return (ServiceTask)setAttribute("exportFormat", exportFormat == null ? null : exportFormat.getValue(), false);
    }

    /**
     * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more 
     * information.
     *
     * @return Current exportFormat value. Default value is "csv"
     */
    public ExportFormat getExportFormat()  {
        return EnumUtil.getEnum(ExportFormat.values(), getAttribute("exportFormat"));
    }
    

    /**
     * ID of the next sequence or element to proceed to if a failure condition arises from DataSource operation.
     *
     * @param failureElement New failureElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setFailureElement(String failureElement)  throws IllegalStateException {
        return (ServiceTask)setAttribute("failureElement", failureElement, false);
    }

    /**
     * ID of the next sequence or element to proceed to if a failure condition arises from DataSource operation.
     *
     * @return Current failureElement value. Default value is null
     */
    public String getFailureElement()  {
        return getAttributeAsString("failureElement");
    }
    

    /**
     * Criteria to be submitted as part of the DSRequest, regardless of inputs to the task. Will be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField Task.inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getCriteria criteria} if specified, via {@link
     * com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria()}.
     *
     * @param fixedCriteria New fixedCriteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setFixedCriteria(Criteria fixedCriteria)  throws IllegalStateException {
        if (fixedCriteria instanceof Criterion) {
            fixedCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (ServiceTask)setAttribute("fixedCriteria", fixedCriteria == null ? null : fixedCriteria.getJsObj(), false);
    }

    /**
     * Criteria to be submitted as part of the DSRequest, regardless of inputs to the task. Will be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField Task.inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getCriteria criteria} if specified, via {@link
     * com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria()}.
     *
     * @return Current fixedCriteria value. Default value is null
     */
    public Criteria getFixedCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("fixedCriteria"));
    }
    

    /**
     * Values to be submitted as part of the DSRequest, regardless of inputs to the task. Will  be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField Task.inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} if specified, via simple copying of fields, with
     * <code>fixedValues</code> overwriting values provided by the <code>inputField</code>, but explicitly specified {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} overriding <code>fixedValues</code>.
     *
     * @param fixedValues New fixedValues value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setFixedValues(Record fixedValues)  throws IllegalStateException {
        return (ServiceTask)setAttribute("fixedValues", fixedValues == null ? null : fixedValues.getJsObj(), false);
    }

    /**
     * Values to be submitted as part of the DSRequest, regardless of inputs to the task. Will  be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField Task.inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} if specified, via simple copying of fields, with
     * <code>fixedValues</code> overwriting values provided by the <code>inputField</code>, but explicitly specified {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} overriding <code>fixedValues</code>.
     *
     * @return Current fixedValues value. Default value is null
     */
    public Record getFixedValues()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("fixedValues"));
    }
    

    /**
     * The {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId} to invoke.
     *
     * @param operationId New operationId value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setOperationId(String operationId)  throws IllegalStateException {
        return (ServiceTask)setAttribute("operationId", operationId, false);
    }

    /**
     * The {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId} to invoke.
     *
     * @return Current operationId value. Default value is null
     */
    public String getOperationId()  {
        return getAttributeAsString("operationId");
    }
    

    /**
     * Type of operation to invoke. A special "export" operation type is supported to perform a server export based on
     * criteria.
     *
     * @param operationType New operationType value. Default value is "fetch"
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setOperationType(DSOperationType operationType)  throws IllegalStateException {
        return (ServiceTask)setAttribute("operationType", operationType == null ? null : operationType.getValue(), false);
    }

    /**
     * Type of operation to invoke. A special "export" operation type is supported to perform a server export based on
     * criteria.
     *
     * @return Current operationType value. Default value is "fetch"
     */
    public DSOperationType getOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }
    

    /**
     * Field in the {@link com.smartgwt.client.util.workflow.Process#getState process state} where this task writes outputs.
     * See {@link com.smartgwt.client.docs.TaskIO}. <p> See {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getOutputFieldList outputFieldList} for a shorthand method to save the
     * full operation response data.
     *
     * @param outputField New outputField value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public ServiceTask setOutputField(String outputField)  throws IllegalStateException {
        return (ServiceTask)setAttribute("outputField", outputField, false);
    }

    /**
     * Field in the {@link com.smartgwt.client.util.workflow.Process#getState process state} where this task writes outputs.
     * See {@link com.smartgwt.client.docs.TaskIO}. <p> See {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getOutputFieldList outputFieldList} for a shorthand method to save the
     * full operation response data.
     *
     * @return Current outputField value. Default value is null
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public String getOutputField()  {
        return getAttributeAsString("outputField");
    }
    

    /**
     * List of multiple fields in the {@link com.smartgwt.client.util.workflow.Process#getState process state} where this task
     * will write outputs. See {@link com.smartgwt.client.docs.TaskIO}.   <P> If {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getOutputField outputField} is also specified, it will be implicitly added
     * to the <code>outputFieldList</code> if it is not already present. <P> In addition to pulling individual fields from the
     * task operation result and placing them into the process state the full response data can also be written into the
     * process state without specifying individual fields. Prefix a destination field path with a "$" (ex. $orderHeader) causes
     * the entire <code>dsResponse.data</code> to be saved.
     *
     * @param outputFieldList New outputFieldList value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public ServiceTask setOutputFieldList(String... outputFieldList)  throws IllegalStateException {
        return (ServiceTask)setAttribute("outputFieldList", outputFieldList, false);
    }

    /**
     * List of multiple fields in the {@link com.smartgwt.client.util.workflow.Process#getState process state} where this task
     * will write outputs. See {@link com.smartgwt.client.docs.TaskIO}.   <P> If {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getOutputField outputField} is also specified, it will be implicitly added
     * to the <code>outputFieldList</code> if it is not already present. <P> In addition to pulling individual fields from the
     * task operation result and placing them into the process state the full response data can also be written into the
     * process state without specifying individual fields. Prefix a destination field path with a "$" (ex. $orderHeader) causes
     * the entire <code>dsResponse.data</code> to be saved.
     *
     * @return Current outputFieldList value. Default value is null
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public String[] getOutputFieldList()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("outputFieldList"));
    }
    

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs. <p> Note
     * that this property does not affect the task at all but is an indicator to the user and to the workflow editor of the
     * behavior of the task as coded (See {@link com.smartgwt.client.util.workflow.Process#passThruTaskOutput
     * Process.passThruTaskOutput()}).
     *
     * @param passThruOutput New passThruOutput value. Default value is false
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setPassThruOutput(Boolean passThruOutput)  throws IllegalStateException {
        return (ServiceTask)setAttribute("passThruOutput", passThruOutput, false);
    }

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs. <p> Note
     * that this property does not affect the task at all but is an indicator to the user and to the workflow editor of the
     * behavior of the task as coded (See {@link com.smartgwt.client.util.workflow.Process#passThruTaskOutput
     * Process.passThruTaskOutput()}).
     *
     * @return Current passThruOutput value. Default value is false
     */
    public Boolean getPassThruOutput()  {
        Boolean result = getAttributeAsBoolean("passThruOutput");
        return result == null ? false : result;
    }
    

    /**
     * Values to be submitted for "update", "add" and "remove" operations. <P> Similar to {@link
     * com.smartgwt.client.data.Criteria}, data values prefixed with "$" will be treated as a {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Use {@link com.smartgwt.client.util.workflow.ServiceTask#getFixedValues
     * fixedValues} for any values that start with "$" but should be treated as a literal.
     *
     * @param values New values value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ServiceTask ServiceTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ServiceTask setValues(Record values)  throws IllegalStateException {
        return (ServiceTask)setAttribute("values", values == null ? null : values.getJsObj(), false);
    }

    /**
     * Values to be submitted for "update", "add" and "remove" operations. <P> Similar to {@link
     * com.smartgwt.client.data.Criteria}, data values prefixed with "$" will be treated as a {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Use {@link com.smartgwt.client.util.workflow.ServiceTask#getFixedValues
     * fixedValues} for any values that start with "$" but should be treated as a literal.
     *
     * @return Current values value. Default value is null
     */
    public Record getValues()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("values"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * DataSource ID or DataSource instance to be used.
     *
     *
     * @return DataSource
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * DataSource ID or DataSource instance to be used.
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(String dataSource) {
        setAttribute("dataSource", dataSource, false);
    }

    /**
     * DataSource ID or DataSource instance to be used.
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), false);
    }


}
