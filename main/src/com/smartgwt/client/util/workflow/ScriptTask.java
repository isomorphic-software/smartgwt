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

/**
 * Task that executes arbitrary code, either synchronous or asynchronous.  Override the {@link
 * com.smartgwt.client.util.workflow.ScriptTask#execute execute()} method to provide custom logic.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ScriptTask")
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
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputData setOutputData()} or {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord setOutputRecord()} is called.
     *
     * @param isAsync New isAsync value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setIsAsync(Boolean isAsync)  throws IllegalStateException {
        setAttribute("isAsync", isAsync, false);
    }

    /**
     * Whether the script task is asynchronous.  A synchronous task is expected to return data directly from execute() and is
     * considered complete once the execute() method exits. <P> An asnychronous task is expected to start processing in
     * execute(), and will not be considered complete until either {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputData setOutputData()} or {@link
     * com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord setOutputRecord()} is called.
     *
     * @return Current isAsync value. Default value is false
     */
    public Boolean getIsAsync()  {
        Boolean result = getAttributeAsBoolean("isAsync");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Execute the task.
     * @param input the task input
     * @param inputRecord the task input record if an <code>inputFieldList</code> was specified. See {@link com.smartgwt.client.docs.TaskIO}
     *
     * @return the task output.  For multiple field output, call  {@link com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord
     * setOutputRecord()} instead, and return null
     */
    public native Object execute(Object input, Record inputRecord) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "execute", "Object,Record");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.execute(input, inputRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

	/**
     * Get the inputs to this task as specified by {@link com.smartgwt.client.util.workflow.Task#getInputField
     * Task.inputField}. <P> For a task with a {@link com.smartgwt.client.util.workflow.Task#getInputFieldList inputFieldList},
     * use {@link com.smartgwt.client.util.workflow.ScriptTask#getInputRecord getInputRecord()} to get access to other inputs.
     *
     * @return input data
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public native Object getInputData() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getInputData", "");
        }
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getInputRecord", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getInputRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Set all outputs of the task as specified by the {@link com.smartgwt.client.util.workflow.Task#getOutputFieldList
     * outputFieldList}, by providing a Record.
     * @param outputRecord output record
     * @see com.smartgwt.client.docs.TaskIO TaskIO overview and related methods
     */
    public native void setOutputRecord(Record outputRecord) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setOutputRecord", "Record");
        }
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
