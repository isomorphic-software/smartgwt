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
 * A ProcessElement is an abstract superclass for elements involved in a {@link com.smartgwt.client.util.workflow.Process},
 * such as a {@link com.smartgwt.client.util.workflow.Task} or {@link com.smartgwt.client.util.workflow.DecisionTask}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ProcessElement")
public class ProcessElement extends BaseClass {

    public static ProcessElement getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ProcessElement) obj;
        } else {
            return new ProcessElement(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        this.jsObj = jsObj;
        onBind();
    }
        


    public ProcessElement(){
        scClassName = "ProcessElement";
    }

    public ProcessElement(JavaScriptObject jsObj){
        scClassName = "ProcessElement";
        setJavaScriptObject(jsObj);
    }


    public ProcessElement(String ID) {
        setID(ID);
                scClassName = "ProcessElement";
    }


    public ProcessElement(String ID, String nextElement) {
        setID(ID);
		setNextElement(nextElement);
                scClassName = "ProcessElement";
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    private JavaScriptObject jsObj;
    
    @Override
    public boolean isCreated(){
        return this.jsObj != null;
    }

    @Override
    public JavaScriptObject getJsObj(){
        return this.jsObj;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return this.jsObj;
    }


    // ********************* Properties / Attributes ***********************

    /**
     * When set, the output of the task will be automatically bound to the specified value in the {@link
     * com.smartgwt.client.util.workflow.Process#getState process state}. <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs.
     *
     * @param bindOutput New bindOutput value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setBindOutput(String bindOutput)  throws IllegalStateException {
        return (ProcessElement)setAttribute("bindOutput", bindOutput, false);
    }

    /**
     * When set, the output of the task will be automatically bound to the specified value in the {@link
     * com.smartgwt.client.util.workflow.Process#getState process state}. <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs.
     *
     * @return Current bindOutput value. Default value is null
     */
    public String getBindOutput()  {
        return getAttributeAsString("bindOutput");
    }
    

    /**
     * Optional description of the general nature of the kinds of tasks this this process element performs. Not to be confused
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getDescription description} which describes what the
     * specific instance of the process element has been configured to do. <P> For example, the <code>classDescription</code>
     * for a task to disable a field might be "disables a field" whereas the <code>description</code> for a concrete instance
     * might be "disables the 'shipTo' field in the 'ordering' form". <P> Used by editor to display additional details along
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getTypeTitle typeTitle}.
     *
     * @param classDescription New classDescription value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setClassDescription(String classDescription)  throws IllegalStateException {
        return (ProcessElement)setAttribute("classDescription", classDescription, false);
    }

    /**
     * Optional description of the general nature of the kinds of tasks this this process element performs. Not to be confused
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getDescription description} which describes what the
     * specific instance of the process element has been configured to do. <P> For example, the <code>classDescription</code>
     * for a task to disable a field might be "disables a field" whereas the <code>description</code> for a concrete instance
     * might be "disables the 'shipTo' field in the 'ordering' form". <P> Used by editor to display additional details along
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getTypeTitle typeTitle}.
     *
     * @return Current classDescription value. Default value is null
     */
    public String getClassDescription()  {
        return getAttributeAsString("classDescription");
    }
    

    /**
     * Optional description for this specific instance of process element.
     *
     * @param description New description value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setDescription(String description)  throws IllegalStateException {
        return (ProcessElement)setAttribute("description", description, false);
    }

    /**
     * Optional description for this specific instance of process element.
     *
     * @return Current description value. Default value is null
     */
    public String getDescription()  {
        return getAttributeAsString("description");
    }
    

    /**
     * Editor type used to edit instances of this type of process element.
     *
     * @param editorType New editorType value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setEditorType(String editorType)  throws IllegalStateException {
        return (ProcessElement)setAttribute("editorType", editorType, false);
    }

    /**
     * Editor type used to edit instances of this type of process element.
     *
     * @return Returns the workflow task editor type to be used edit instances of this type of process element. The default
     * implementation returns <code>this.editorType</code> but a custom override could determine an editor type based on the
     * property values. Default value is null
     */
    public String getEditorType()  {
        return getAttributeAsString("editorType");
    }
    

    /**
     * Should {@link com.smartgwt.client.util.workflow.ProcessElement#getSupportsMultipleInputRecords multiple record
     * processing} be suppressed for this task instance? This property can be set at any time is checked before executing the
     * task and after each execution during processing of multiple last task output records. <p> Note that since this property
     * applies to an instance of a task that could be used multiple times in a process (by branching) care should be taken to
     * restore the property value after execution completes. See {@link
     * com.smartgwt.client.util.workflow.ProcessElement#completeElement completeElement()} or {@link
     * com.smartgwt.client.util.workflow.ProcessElement#reset reset()}.
     *
     * @param forceSingle New forceSingle value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     */
    public ProcessElement setForceSingle(Boolean forceSingle) {
        return (ProcessElement)setAttribute("forceSingle", forceSingle, true);
    }

    /**
     * Should {@link com.smartgwt.client.util.workflow.ProcessElement#getSupportsMultipleInputRecords multiple record
     * processing} be suppressed for this task instance? This property can be set at any time is checked before executing the
     * task and after each execution during processing of multiple last task output records. <p> Note that since this property
     * applies to an instance of a task that could be used multiple times in a process (by branching) care should be taken to
     * restore the property value after execution completes. See {@link
     * com.smartgwt.client.util.workflow.ProcessElement#completeElement completeElement()} or {@link
     * com.smartgwt.client.util.workflow.ProcessElement#reset reset()}.
     *
     * @return Current forceSingle value. Default value is null
     */
    public Boolean getForceSingle()  {
        return getAttributeAsBoolean("forceSingle");
    }
    

    /**
     * Optional ID for this process element, allowing it to be referred to from  {@link
     * com.smartgwt.client.util.workflow.MultiDecisionTask Decisions}, or as the {@link
     * com.smartgwt.client.util.workflow.Process#getStartElement Process.startElement}. See {@link
     * com.smartgwt.client.util.workflow.ProcessSequence} and {@link com.smartgwt.client.util.workflow.Process} to understand
     * when this is required or can be omitted. <P> Unlike {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} a
     * <code>processElement</code>'s is a not a globally unique variable, it need only by unique within it's process. <P> When
     * assigned an ID, a <code>processElement</code> can be retrieve via {@link
     * com.smartgwt.client.util.workflow.Process#getElement Process.getElement()}.
     *
     * @param ID New ID value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setID(String ID)  throws IllegalStateException {
        return (ProcessElement)setAttribute("ID", ID, false);
    }

    /**
     * Optional ID for this process element, allowing it to be referred to from  {@link
     * com.smartgwt.client.util.workflow.MultiDecisionTask Decisions}, or as the {@link
     * com.smartgwt.client.util.workflow.Process#getStartElement Process.startElement}. See {@link
     * com.smartgwt.client.util.workflow.ProcessSequence} and {@link com.smartgwt.client.util.workflow.Process} to understand
     * when this is required or can be omitted. <P> Unlike {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} a
     * <code>processElement</code>'s is a not a globally unique variable, it need only by unique within it's process. <P> When
     * assigned an ID, a <code>processElement</code> can be retrieve via {@link
     * com.smartgwt.client.util.workflow.Process#getElement Process.getElement()}.
     *
     * @return Current ID value. Default value is null
     */
    public String getID()  {
        return getAttributeAsString("ID");
    }
    

    /**
     * Enable mock mode on the task? If {@link com.smartgwt.client.util.workflow.Process#getMockMode Process.mockMode} is
     * enabled, setting this property to <code>false</code> disables mockMode on this task only. Otherwise, mock mode can be
     * enabled on this task by setting it to <code>true</code>. <p> Note that it is up to each task determine what effect mock
     * mode has.
     *
     * @param mockMode New mockMode value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     */
    public ProcessElement setMockMode(Boolean mockMode) {
        return (ProcessElement)setAttribute("mockMode", mockMode, true);
    }

    /**
     * Enable mock mode on the task? If {@link com.smartgwt.client.util.workflow.Process#getMockMode Process.mockMode} is
     * enabled, setting this property to <code>false</code> disables mockMode on this task only. Otherwise, mock mode can be
     * enabled on this task by setting it to <code>true</code>. <p> Note that it is up to each task determine what effect mock
     * mode has.
     *
     * @return Current mockMode value. Default value is null
     */
    public Boolean getMockMode()  {
        return getAttributeAsBoolean("mockMode");
    }
    

    /**
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute after this one completes.   <p>
     * <code>nextElement</code> does not need to be specified on most elements if you use {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequences}. <p> Note that if there is both a
     * <code>sequence</code> and a normal <code>element</code> with the same name in the current <code>Process</code>, the
     * <code>sequence</code> will be used.
     *
     * @param nextElement New nextElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setNextElement(String nextElement)  throws IllegalStateException {
        return (ProcessElement)setAttribute("nextElement", nextElement, false);
    }

    /**
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute after this one completes.   <p>
     * <code>nextElement</code> does not need to be specified on most elements if you use {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequences}. <p> Note that if there is both a
     * <code>sequence</code> and a normal <code>element</code> with the same name in the current <code>Process</code>, the
     * <code>sequence</code> will be used.
     *
     * @return Current nextElement value. Default value is null
     */
    public String getNextElement()  {
        return getAttributeAsString("nextElement");
    }
    

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs. <p> Note
     * that this property does not affect the task at all but is an indicator to the user and to the workflow editor of the
     * behavior of the task as coded (See {@link com.smartgwt.client.util.workflow.Process#passThruTaskOutput
     * Process.passThruTaskOutput()}).
     *
     * @param passThruOutput New passThruOutput value. Default value is true
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setPassThruOutput(Boolean passThruOutput)  throws IllegalStateException {
        return (ProcessElement)setAttribute("passThruOutput", passThruOutput, false);
    }

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs. <p> Note
     * that this property does not affect the task at all but is an indicator to the user and to the workflow editor of the
     * behavior of the task as coded (See {@link com.smartgwt.client.util.workflow.Process#passThruTaskOutput
     * Process.passThruTaskOutput()}).
     *
     * @return Current passThruOutput value. Default value is true
     */
    public Boolean getPassThruOutput()  {
        Boolean result = getAttributeAsBoolean("passThruOutput");
        return result == null ? true : result;
    }
    

    /**
     * Does this processElement support being called multiple times for multiple records in the {@link
     * com.smartgwt.client.util.workflow.Process#setTaskOutput last task output}? <p> By default a processElement is {@link
     * com.smartgwt.client.util.workflow.ProcessElement#executeElement executed} exactly once, however, for a task that can
     * process records from the last task output it can be useful to handle each incoming record individually. Setting this
     * property indicates to the {@link com.smartgwt.client.util.workflow.Process process} that if the last task output is an
     * array, it should be executed once per value in the array. Normal processing of {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} or use of {@link
     * com.smartgwt.client.util.workflow.Process#getLastTaskOutput Process.getLastTaskOutput()} will have exactly one record
     * except uses of the output for criteria values where the full output is used at once. <p> Processing of the task can
     * determine that multiple incoming records should not result in multiple calls and set {@link
     * com.smartgwt.client.util.workflow.ProcessElement#getForceSingle forceSingle}. For example, a task that uses last task
     * output for a criteria or for values should set <code>forceSingle=true</code> when a criteria is used because multiple
     * calls do not make sense.
     *
     * @param supportsMultipleInputRecords New supportsMultipleInputRecords value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setSupportsMultipleInputRecords(Boolean supportsMultipleInputRecords)  throws IllegalStateException {
        return (ProcessElement)setAttribute("supportsMultipleInputRecords", supportsMultipleInputRecords, false);
    }

    /**
     * Does this processElement support being called multiple times for multiple records in the {@link
     * com.smartgwt.client.util.workflow.Process#setTaskOutput last task output}? <p> By default a processElement is {@link
     * com.smartgwt.client.util.workflow.ProcessElement#executeElement executed} exactly once, however, for a task that can
     * process records from the last task output it can be useful to handle each incoming record individually. Setting this
     * property indicates to the {@link com.smartgwt.client.util.workflow.Process process} that if the last task output is an
     * array, it should be executed once per value in the array. Normal processing of {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} or use of {@link
     * com.smartgwt.client.util.workflow.Process#getLastTaskOutput Process.getLastTaskOutput()} will have exactly one record
     * except uses of the output for criteria values where the full output is used at once. <p> Processing of the task can
     * determine that multiple incoming records should not result in multiple calls and set {@link
     * com.smartgwt.client.util.workflow.ProcessElement#getForceSingle forceSingle}. For example, a task that uses last task
     * output for a criteria or for values should set <code>forceSingle=true</code> when a criteria is used because multiple
     * calls do not make sense.
     *
     * @return Current supportsMultipleInputRecords value. Default value is null
     */
    public Boolean getSupportsMultipleInputRecords()  {
        return getAttributeAsBoolean("supportsMultipleInputRecords");
    }
    

    /**
     * Optional short, descriptive title for this process element. Used by an editor as a title for process elements of this
     * type.
     *
     * @param typeTitle New typeTitle value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setTypeTitle(String typeTitle)  throws IllegalStateException {
        return (ProcessElement)setAttribute("typeTitle", typeTitle, false);
    }

    /**
     * Optional short, descriptive title for this process element. Used by an editor as a title for process elements of this
     * type.
     *
     * @return Current typeTitle value. Default value is null
     */
    public String getTypeTitle()  {
        return getAttributeAsString("typeTitle");
    }
    

    // ********************* Methods ***********************
	/**
     * StringMethod called when a processElement completes. Typically used to clear transient state applied to the task while
     * running like {@link com.smartgwt.client.util.workflow.ProcessElement#getForceSingle forceSingle} so it can be executed
     * again later. See also {@link com.smartgwt.client.util.workflow.ProcessElement#reset reset()}.
     * @param process the containing process
     */
    public native void completeElement(Process process) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "completeElement", "Process");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.completeElement(process == null ? null : process.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Method called by {@link com.smartgwt.client.util.workflow.Process} to have the processElement perform its work. There is
     * no default implementation by ProcessElement, however, all of the system-provided subclasses do implement this method. An
     * implementation or override of this method is one possible customization point. Some classes like {@link
     * com.smartgwt.client.util.workflow.ScriptTask} perform other means to add customization. For ScriptTask, custom code is
     * expected to handle the {@link com.smartgwt.client.util.workflow.ScriptTask#execute ScriptTask.execute()} method instead.
     * <p> Any implementation of this method must return <code>true</code> if all the work this element needed to perform was
     * completed. Return <code>false</code> if additional work is being performed asynchronously and the process should be
     * paused until element restarts it. Once asynchronous work is complete the task must call {@link
     * com.smartgwt.client.util.workflow.Process#start Process.start()} to restart the workflow with the next task.
     * @param process the process that is handling the workflow
     *
     * @return return true if all the work this element needed to perform was                   completed. Return false if additional
     * work is being performed                   asynchronously and the process should be paused until element                 
     *  restarts it.
     */
    public native Boolean executeElement(Process process) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "executeElement", "Process");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.executeElement(process == null ? null : process.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Resolves a dynamic value as {@link com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} or returns the
     * value as-is.
     * @param value the value to resolve
     * @param process the current process
     *
     * @return the resolved value
     */
    public native String getDynamicValue(String value, Process process) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDynamicValue", "String,Process");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getDynamicValue(value, process == null ? null : process.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Returns a text description of the element derived from the configuration. <p> If no override is provided by the concrete
     * ProcessElement implementation the {@link com.smartgwt.client.util.workflow.ProcessElement#getDescription description} is
     * returned.
     *
     * @return the derived element description
     */
    public native String getElementDescription() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getElementDescription", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getElementDescription();
        return ret;
    }-*/;

	/**
     * Resolves a {@link com.smartgwt.client.widgets.UserSummary} value against the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     * @param textFormula the UserSummary value to resolve
     * @param process the current process
     *
     * @return the resolved value
     */
    public native String getTextFormulaValue(UserSummary textFormula, Process process) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getTextFormulaValue", "UserSummary,Process");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getTextFormulaValue(textFormula.@com.smartgwt.client.core.DataClass::getJsObj()(), process == null ? null : process.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Does the object have fields that reference the last task output (i.e. $last)?
     * @param object object to be checked
     * @param process the enclosing process
     *
     * @return true if any field in the object references $last
     */
    public native Boolean objectReferencesLastTaskOutput(Map object, Process process) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "objectReferencesLastTaskOutput", "Map,Process");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.objectReferencesLastTaskOutput(object == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(object), process == null ? null : process.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * StringMethod called during {@link com.smartgwt.client.util.workflow.Process#reset Process.reset()} giving the task a
     * chance to reset any internal state so it can be executed later. See also {@link
     * com.smartgwt.client.util.workflow.ProcessElement#completeElement completeElement()}.
     */
    public native void reset() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reset", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.reset();
    }-*/;

	/**
     * Updates {@link com.smartgwt.client.data.AdvancedCriteria} {@link com.smartgwt.client.data.Criterion} {@link
     * com.smartgwt.client.docs.TaskInputExpression} values containing ruleScope references. <p> This method is a helper to
     * implement task-specific {@link com.smartgwt.client.util.workflow.ProcessElement#updateGlobalIDReferences
     * updateGlobalIDReferences()}.
     * @param criteria the criteria to be updated in place
     * @param oldId the ID being renamed.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newId the new ID to be assigned.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return true if any references were updated; false otherwise
     */
    public native Boolean updateGlobalIDInCriteria(AdvancedCriteria criteria, String oldId, String newId) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateGlobalIDInCriteria", "AdvancedCriteria,String,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        var ret = self.updateGlobalIDInCriteria(criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldId, newId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Updates a {@link com.smartgwt.client.docs.TaskInputExpression} property value containing ruleScope references. <p> This
     * method is a helper to implement task-specific {@link
     * com.smartgwt.client.util.workflow.ProcessElement#updateGlobalIDReferences updateGlobalIDReferences()}.
     * @param propertyName the property name to be updated in this task
     * @param oldId the ID being renamed.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newId the new ID to be assigned.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return true if any references were updated; false otherwise
     */
    public native Boolean updateGlobalIDInValueProperty(String propertyName, String oldId, String newId) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateGlobalIDInValueProperty", "String,String,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.updateGlobalIDInValueProperty(propertyName, oldId, newId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Updates a set of {@link com.smartgwt.client.docs.TaskInputExpression} values containing ruleScope references. <p> This
     * method is a helper to implement task-specific {@link
     * com.smartgwt.client.util.workflow.ProcessElement#updateGlobalIDReferences updateGlobalIDReferences()}.
     * @param values the object to be updated
     * @param oldId the ID being renamed.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newId the new ID to be assigned.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return true if any references were updated; false otherwise
     */
    public native Boolean updateGlobalIDInValues(Map values, String oldId, String newId) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateGlobalIDInValues", "Map,String,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.updateGlobalIDInValues(values == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(values), oldId, newId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Updates references to a global ID within the properties of this process element (i.e. rename). This method is not called
     * as part of workflow execution but is used by {@link com.smartgwt.client.tools.Reify} to keep workflow event handlers in
     * sync with ID changes within the screen. <p> Each processElement or Task that has properties that save global IDs (like a
     * component ID or criteria referencing {@link com.smartgwt.client.widgets.Canvas#getRuleScope ruleContext}) must  be able
     * to update its references on demand by overriding this method or defer to its superclass. <p> There are a number of
     * helper methods to make this easier listed below.
     * @param oldId the ID being renamed.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newId the new ID to be assigned.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return true if any references were updated; false otherwise
     * @see com.smartgwt.client.util.workflow.ProcessElement#updateGlobalIDInValueProperty
     * @see com.smartgwt.client.util.workflow.ProcessElement#updateGlobalIDInValues
     * @see com.smartgwt.client.util.workflow.ProcessElement#updateGlobalIDInCriteria
     */
    public native Boolean updateGlobalIDReferences(String oldId, String newId) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateGlobalIDReferences", "String,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.updateGlobalIDReferences(oldId, newId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Update references to a binding $last within properties of this processElement. This method is not called as part of
     * workflow execution but is used by the {@link com.smartgwt.client.tools.WorkflowEditor} to adjust last task references as
     * new tasks are inserted. <p> Each processElement or Task that has properties supporting {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} using the $last syntax must  be able to update its
     * references on demand by overriding this method or defer to its superclass. <p> There are a number of helper methods to
     * make this easier listed below.
     * @param oldId the ID being renamed.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newId the new ID to be assigned.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return true if any references were updated; false otherwise
     * @see com.smartgwt.client.util.workflow.ProcessElement#updateLastElementInValueProperty
     * @see com.smartgwt.client.util.workflow.ProcessElement#updateLastElementInValues
     * @see com.smartgwt.client.util.workflow.ProcessElement#updateLastElementInCriteria
     */
    public native Boolean updateLastElementBindingReferences(String oldId, String newId) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateLastElementBindingReferences", "String,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.updateLastElementBindingReferences(oldId, newId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Updates {@link com.smartgwt.client.data.AdvancedCriteria} {@link com.smartgwt.client.data.Criterion} {@link
     * com.smartgwt.client.docs.TaskInputExpression} values containing $last references. Any implicit reference to the last
     * task is updated to reference a last task of a specified <code>taskType</code>. <p> For example, a value of
     * "$last.sequenceNo" would be replaced with "$last[fetch].sequenceNo" if the taskType is "fetch". Existing "$last[...]"
     * references are left as-is. <p> This method is a helper to implement task-specific {@link
     * com.smartgwt.client.util.workflow.ProcessElement#updateLastElementBindingReferences
     * updateLastElementBindingReferences()}.
     * @param criteria the criteria to be updated in place
     * @param taskType the taskType to be used in new reference
     *
     * @return true if any references were update; false otherwise
     */
    public native Boolean updateLastElementInCriteria(AdvancedCriteria criteria, String taskType) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateLastElementInCriteria", "AdvancedCriteria,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        var ret = self.updateLastElementInCriteria(criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), taskType);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Updates a {@link com.smartgwt.client.docs.TaskInputExpression} property value containing $last references. Any implicit
     * reference to the last task is updated to reference a last task of a specified <code>taskType</code>. <p> For example, a
     * value of "$last.sequenceNo" would be replaced with "$last[fetch].sequenceNo" if the taskType is "fetch". Existing
     * "$last[...]" references are left as-is. <p> This method is a helper to implement task-specific {@link
     * com.smartgwt.client.util.workflow.ProcessElement#updateLastElementBindingReferences
     * updateLastElementBindingReferences()}.
     * @param propertyName the property name to be updated in this task
     * @param taskType the taskType to be used in new reference
     *
     * @return true if any references were update; false otherwise
     */
    public native Boolean updateLastElementInValueProperty(String propertyName, String taskType) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateLastElementInValueProperty", "String,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.updateLastElementInValueProperty(propertyName, taskType);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Updates a set of {@link com.smartgwt.client.docs.TaskInputExpression} values containing $last references. Any implicit
     * reference to the last task is updated to reference a last task of a specified <code>taskType</code>. <p> For example, a
     * value of "$last.sequenceNo" would be replaced with "$last[fetch].sequenceNo" if the taskType is "fetch". Existing
     * "$last[...]" references are left as-is. <p> This method is a helper to implement task-specific {@link
     * com.smartgwt.client.util.workflow.ProcessElement#updateLastElementBindingReferences
     * updateLastElementBindingReferences()}.
     * @param values the object to be updated
     * @param taskType the taskType to be used in new reference
     *
     * @return true if any references were update; false otherwise
     */
    public native Boolean updateLastElementInValues(Map values, String taskType) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateLastElementInValues", "Map,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.updateLastElementInValues(values == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(values), taskType);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************


    
    private Map<String, ProcessElement[]> elementParameters = new HashMap<String, ProcessElement[]>();
    
    // IDs for elements are not unique, also all elements should be created when process
    // started, so elements don't act as BaseClass
    protected void onInit() {
        super.onInit();
        for (String key : elementParameters.keySet()) {
            setProperty(key, ProcessElement.convertToJavaScriptArray(elementParameters.get(key)));
        }        
    }

    public ProcessElement setAttribute(String attribute, ProcessElement[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            elementParameters.put(attribute, value);
        } else if (allowPostCreate) {
            elementParameters.put(attribute, value);
            setProperty(attribute, ProcessElement.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
        return this;
    }
    
    public ProcessElement[] getProcessElements(String attribute) {
        return elementParameters.get(attribute); 
    }
    
    public static JavaScriptObject convertToJavaScriptArray(ProcessElement[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = JSOHelper.createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i].getOrCreateJsObj());
        }
        return jsArray;
    }

}
