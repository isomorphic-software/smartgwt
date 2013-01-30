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
 
package com.smartgwt.client.util.workflow;



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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A ServiceTask is an element of a {@link com.smartgwt.client.util.workflow.Process} which calls a DataSource operation, 
 * optionally using part of the {@link com.smartgwt.client.util.workflow.Process#getState process state} as inputs or
 * storing outputs in the process state. <P> By default a ServiceTask takes the data indicated by {@link
 * com.smartgwt.client.util.workflow.Task#getInputField inputField} and uses it as {@link
 * com.smartgwt.client.data.DSRequest#getData data}.  This means the input data becomes {@link
 * com.smartgwt.client.util.workflow.ServiceTask#getCritera Critera} for a "fetch" operation, new record values for an
 * "add" operation, etc. <P> Alternatively, you can set {@link com.smartgwt.client.util.workflow.ServiceTask#getCriteria
 * criteria} for a "fetch" operation, or {@link com.smartgwt.client.util.workflow.ServiceTask#getValues values} for other
 * operationTypes.  In both cases, you have the ability to use simple expressions like $input.<i>fieldName</i> to take
 * portions of the input data and use it as part of the criteria or values. <P> As a special case, if the
 * <code>inputField</code> is an atomic value (just a String or Number rather than a Record) and operationType is "fetch",
 * it will be assumed to be value for the primary key field of the target DataSource if {@link
 * com.smartgwt.client.util.workflow.ServiceTask#getCriteria criteria} is not explicitly specified
 */
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
        super(jsObj);
    }

    public ServiceTask(String ID) {
        setID(ID);
        scClassName = "ServiceTask";
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Criteria (including AdvancedCriteria) to use for a "fetch" operation. <P> Data values in this criteria prefixed with "$"
     * will be treated as dynamic expressions which can access the inputs to this task as $input - see {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Specifically, this means that for simple criteria, any property value
     * that is a String and is prefixed with "$" will be assumed to be an expression, and for AdvancedCriteria, the same
     * treatment will be applied to {@link com.smartgwt.client.data.Criterion#getValue value}. <P> If any data value should not
     * be treated as dynamic (for example, a "$" should be taken as literal), you can place it in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getFixedCriteria fixedCriteria} instead. <P> Ignored for any operationType
     * other than "fetch".  Update or delete operations should place the primary key to update in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values}.
     *
     * @param criteria criteria Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public void setCriteria(Criteria criteria)  throws IllegalStateException {
        setAttribute("criteria", criteria.getJsObj(), false);
    }

    /**
     * Criteria (including AdvancedCriteria) to use for a "fetch" operation. <P> Data values in this criteria prefixed with "$"
     * will be treated as dynamic expressions which can access the inputs to this task as $input - see {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Specifically, this means that for simple criteria, any property value
     * that is a String and is prefixed with "$" will be assumed to be an expression, and for AdvancedCriteria, the same
     * treatment will be applied to {@link com.smartgwt.client.data.Criterion#getValue value}. <P> If any data value should not
     * be treated as dynamic (for example, a "$" should be taken as literal), you can place it in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getFixedCriteria fixedCriteria} instead. <P> Ignored for any operationType
     * other than "fetch".  Update or delete operations should place the primary key to update in {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values}.
     *
     *
     * @return Criteria
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }

    /**
     * Criteria to be submitted as part of the DSRequest, regardless of inputs to the task. Will be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getCriteria criteria} if specified, via {@link
     * com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria}.
     *
     * @param fixedCriteria fixedCriteria Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFixedCriteria(Criteria fixedCriteria)  throws IllegalStateException {
        setAttribute("fixedCriteria", fixedCriteria.getJsObj(), false);
    }

    /**
     * Criteria to be submitted as part of the DSRequest, regardless of inputs to the task. Will be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getCriteria criteria} if specified, via {@link
     * com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria}.
     *
     *
     * @return Criteria
     */
    public Criteria getFixedCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("fixedCriteria"));
    }

    /**
     * Values to be submitted as part of the DSRequest, regardless of inputs to the task. Will  be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} if specified, via simple copying of fields, with
     * <code>fixedValues</code> overwriting values provided by the <code>inputField</code>, but explicitly specified {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} overriding <code>fixedValues</code>.
     *
     * @param fixedValues fixedValues Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFixedValues(Record fixedValues)  throws IllegalStateException {
        setAttribute("fixedValues", fixedValues.getJsObj(), false);
    }

    /**
     * Values to be submitted as part of the DSRequest, regardless of inputs to the task. Will  be combined with the data from
     * the {@link com.smartgwt.client.util.workflow.Task#getInputField inputField} or with {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} if specified, via simple copying of fields, with
     * <code>fixedValues</code> overwriting values provided by the <code>inputField</code>, but explicitly specified {@link
     * com.smartgwt.client.util.workflow.ServiceTask#getValues values} overriding <code>fixedValues</code>.
     *
     *
     * @return Record
     */
    public Record getFixedValues()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("fixedValues"));
    }

    /**
     * Type of operation to invoke
     *
     * @param operationType operationType Default value is "fetch"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setOperationType(DSOperationType operationType)  throws IllegalStateException {
        setAttribute("operationType", operationType.getValue(), false);
    }

    /**
     * Type of operation to invoke
     *
     *
     * @return DSOperationType
     */
    public DSOperationType getOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }

    /**
     * Values to be submitted for "update", "add" and "remove" operations. <P> Similar to {@link
     * com.smartgwt.client.data.Criteria}, data values prefixed with "$" will be treated as a {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Use {@link com.smartgwt.client.util.workflow.ServiceTask#getFixedValues
     * fixedValues} for any values that start with "$" but should be treated as a literal.
     *
     * @param values values Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValues(Record values)  throws IllegalStateException {
        setAttribute("values", values.getJsObj(), false);
    }

    /**
     * Values to be submitted for "update", "add" and "remove" operations. <P> Similar to {@link
     * com.smartgwt.client.data.Criteria}, data values prefixed with "$" will be treated as a {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Use {@link com.smartgwt.client.util.workflow.ServiceTask#getFixedValues
     * fixedValues} for any values that start with "$" but should be treated as a literal.
     *
     *
     * @return Record
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
        setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }


}



