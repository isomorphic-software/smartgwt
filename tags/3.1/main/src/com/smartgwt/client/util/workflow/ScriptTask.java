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
 * Task that executes arbitrary code, either synchronous or asynchronous.  Override the {@link
 * com.smartgwt.client.util.workflow.ScriptTask#getExecute execute} method to provide custom logic.
 */
public class ScriptTask extends Task {

    public static ScriptTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ScriptTask) obj;
        } else {
            return new ScriptTask(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public ScriptTask(){
        scClassName = "ScriptTask";
    }

    public ScriptTask(JavaScriptObject jsObj){
        scClassName = "ScriptTask";
        setJavaScriptObject(jsObj);
    }

    public ScriptTask(String ID) {
        setID(ID);
        scClassName = "ScriptTask";
    }

    public ScriptTask(String ID, String nextElement) {
        setID(ID);
		setNextElement(nextElement);
        scClassName = "ScriptTask";
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Whether the script task is asynchronous.  A synchronous task is expected to return data directly from execute() and is
     * considered complete once the execute() method exits. <P> An asnychronous task is expected to start processing in
     * execute(), and will not be considered complete until either {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputData ScriptTask.setOutputData} or {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord ScriptTask.setOutputRecord} is called.
     *
     * @param isAsync isAsync Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setIsAsync(Boolean isAsync)  throws IllegalStateException {
        setAttribute("isAsync", isAsync, false);
    }

    /**
     * Whether the script task is asynchronous.  A synchronous task is expected to return data directly from execute() and is
     * considered complete once the execute() method exits. <P> An asnychronous task is expected to start processing in
     * execute(), and will not be considered complete until either {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputData ScriptTask.setOutputData} or {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord ScriptTask.setOutputRecord} is called.
     *
     *
     * @return Boolean
     */
    public Boolean getIsAsync()  {
        return getAttributeAsBoolean("isAsync");
    }

    // ********************* Methods ***********************

    /**
     * Execute the task.
     * @param input the task input
     * @param inputRecord the task input record if an <code>inputFieldList</code> was specified. See {@link com.smartgwt.client.docs.TaskIO}
     *
     * @return the task output.  For multiple field output, call  {@link com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord
     * ScriptTask.setOutputRecord} instead, and return null
     */
    public native Object execute(Object input, Record inputRecord) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.execute(input, inputRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

    /**
     * Get the inputs to this task as specified by {@link com.smartgwt.client.util.workflow.Task#getInputField inputField}. <P>
     * For a task with a {@link com.smartgwt.client.util.workflow.Task#getInputFieldList inputFieldList}, use {@link
     * com.smartgwt.client.util.workflow.ScriptTask#getInputRecord ScriptTask.getInputRecord} to get access to other inputs.
     *
     * @return input data
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public native Object getInputData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getInputData();
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

    /**
     * Get all inputs to the task as specified by the  {@link com.smartgwt.client.util.workflow.Task#getInputFieldList
     * inputFieldList}, as a Record.
     *
     * @return input data
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public native Record getInputRecord() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getInputRecord();
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * Set all outputs of the task as specified by the {@link com.smartgwt.client.util.workflow.Task#getOutputFieldList
     * outputFieldList}, by providing a Record.
     * @param outputRecord output record
     */
    public native void setOutputRecord(Record outputRecord) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setOutputRecord(outputRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    public ScriptTask(String ID, ProcessElement nextElement) {
        this(ID, nextElement.getID());
    }

    /**
     * Set the task output as specified by {@link com.smartgwt.client.util.workflow.Task#getOutputField outputField}. <P> NOTE:
     * for an  asychronous task, calling <code>setOutputData()</code> indicates the task is complete.  For a task with {@link
     * com.smartgwt.client.util.workflow.Task#getOutputFieldList multiple outputs}, call {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord ScriptTask.setOutputRecord} instead.
     * @param taskOutput task output
     */
    public native void setOutputData(Object taskOutput) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setOutputData($wnd.SmartGWT.convertToPrimitiveType(taskOutput));
    }-*/;

    protected native void onInit_ScriptTask() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        self.__execute = self.execute;
        self.execute = function(input, inputRecord) {
            var jObj = this.__ref;
            var inputRecordJ = null;
            if (inputRecord != null) {
                inputRecordJ = @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(inputRecord);
            }
            var inputJ = $wnd.SmartGWT.convertToJavaType(input);
            var resJ = jObj.@com.smartgwt.client.util.workflow.ScriptTask::execute(Ljava/lang/Object;Lcom/smartgwt/client/data/Record;)(inputJ, inputRecordJ);
            if (resJ == null) return;
            var res = $wnd.SmartGWT.convertToPrimitiveType(resJ);
            if (typeof res == 'object') {
                res = resJ.@com.smartgwt.client.core.JsObject::getJsObj()();
            }
            return res;
        };
    }-*/;

    protected void onInit() {
        onInit_ScriptTask();
    };

}



