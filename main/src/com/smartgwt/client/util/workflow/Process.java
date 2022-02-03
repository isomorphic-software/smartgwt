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
 * A instance of Process represents a stateful process executing a series of Tasks, 
 *  which may be:
 *  <ul>
 *  <li> user interactions
 *  <li> calls to DataSources (hence: any database or web service)
 *  <li> arbitrary code
 *  <li> other Processes
 *  </ul>
 * A Process is <i>stateful</i> in the sense that it maintains {@link com.smartgwt.client.util.workflow.Process#getState
 * state}
 *  across the different tasks that are executed.  This allows you to maintain context as you
 *  walk a user through a multi-step business process in your application, which may involve
 *  multiple operations on multiple entities.  Each Task that executes can use the Process state
 *  as inputs, and can output a result which is stored in the Process state - see
 *  {@link com.smartgwt.client.docs.TaskIO}.
 *  <P>
 *  A Process can have multiple branches, choosing the next Task to execute based on
 * {@link com.smartgwt.client.data.Criteria} - see {@link com.smartgwt.client.util.workflow.DecisionTask} and {@link
 * com.smartgwt.client.util.workflow.MultiDecisionTask}.
 *  <P>
 *  Because a Process may return to a previous Task in various situations, the data model of a
 *  Process is strictly speaking a <i>graph</i> (a set of nodes connected by arbitary
 *  interlinks). However, most processes have sequences of several tasks in a row, and the
 *  definition format allows these to be represented as simple Arrays called "sequences",
 * specified via {@link com.smartgwt.client.util.workflow.Process#getSequences sequences}.  This reduces the need to
 * manually specify IDs and
 *  interlinks for Tasks that simply proceed to the next task in a sequence.
 *  <P>
 *  Processes follow all the standard rules for encoding as {@link com.smartgwt.client.docs.ComponentXML}, however,
 * note that the &lt;Process&gt; tag allows any kind of {@link com.smartgwt.client.util.workflow.ProcessElement} (tasks,
 * decisions
 *  and sequences) to appear as a direct subelement of the &lt;Process&gt; tag without the need
 *  for an intervening &lt;elements&gt; or &lt;sequences&gt; tag.  The example below
 *  demonstrates this shorthand format.
 *  <pre>
 *  &lt;Process ID="<i>processId</i>"&gt;
 *      &lt;ServiceTask ID="<i>serviceTaskId</i>" nextElement="<i>sequenceId</i>" ..&gt;
 *          &lt;inputFieldList&gt;
 *              &lt;value&gt;order.countryName&lt;/value&gt;
 *          &lt;/inputFieldList&gt;
 *          &lt;outputFieldList&gt;
 *              &lt;value&gt;order.countryName&lt;/value&gt;
 *              &lt;value&gt;order.continent&lt;/value&gt;
 *          &lt;outputFieldList&gt;
 *      &lt;/ServiceTask&gt;
 *      &lt;sequence ID="<i>sequenceId</i>" &gt;
 *          &lt;StateTask ../&gt;
 *          &lt;StateTask ../&gt;
 *          &lt;StateTask ../&gt;
 *          &lt;StateTask nextElement="<i>userTaskId</i>" ../&gt;
 *      &lt;/sequence&gt;
 *      &lt;UserTask ID="<i>userTaskId</id>" ../&gt;
 *      ...
 *  &lt;/Process&gt;
 *  </pre>
 *  <b>NOTE:</b> you must load the standard DataBinding module before you can use <code>Process</code>.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Process")
public class Process extends BaseClass implements com.smartgwt.client.util.workflow.events.HasFinishedHandlers, com.smartgwt.client.util.workflow.events.HasTraceElementHandlers {

    public static Process getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (Process) obj;
        } else {
            return new Process(jsObj);
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
        


    public Process(){
        scClassName = "Process";
    }

    public Process(JavaScriptObject jsObj){
        scClassName = "Process";
        setJavaScriptObject(jsObj);
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
     * Identifier of canvas where UI elements created by using {@link com.smartgwt.client.util.workflow.UserTask#getInlineView
     * inline view} property should be added using addMember.
     *
     * @param containerId New containerId value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     */
    public Process setContainerId(String containerId) {
        return (Process)setAttribute("containerId", containerId, true);
    }

    /**
     * Identifier of canvas where UI elements created by using {@link com.smartgwt.client.util.workflow.UserTask#getInlineView
     * inline view} property should be added using addMember.
     *
     * @return Current containerId value. Default value is null
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     */
    public String getContainerId()  {
        return getAttributeAsString("containerId");
    }
    

    /**
     * Elements involved in this Process.  You can also group elements into {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequences} to reduce the need to explicitly define IDs for
     * elements and interlink them.
     *
     * @param elements New elements value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Process setElements(ProcessElement... elements)  throws IllegalStateException {
        return (Process)setAttribute("elements", elements, false);
    }
    

    /**
     * Enable mock mode on the workflow? By default, this setting does nothing but is available for individual tasks to trigger
     * special action. For example, a task that would normally fail outside of its target environment can take an alternative
     * action during testing. <p> mockMode can also be enabled or disabled for an individual task with {@link
     * com.smartgwt.client.util.workflow.ProcessElement#getMockMode ProcessElement.mockMode}.
     *
     * @param mockMode New mockMode value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     */
    public Process setMockMode(Boolean mockMode) {
        return (Process)setAttribute("mockMode", mockMode, true);
    }

    /**
     * Enable mock mode on the workflow? By default, this setting does nothing but is available for individual tasks to trigger
     * special action. For example, a task that would normally fail outside of its target environment can take an alternative
     * action during testing. <p> mockMode can also be enabled or disabled for an individual task with {@link
     * com.smartgwt.client.util.workflow.ProcessElement#getMockMode ProcessElement.mockMode}.
     *
     * @return Current mockMode value. Default value is null
     */
    public Boolean getMockMode()  {
        return getAttributeAsBoolean("mockMode");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} of the component that manages "rule context" for which this
     * process participates. The rule context can be used in {@link com.smartgwt.client.docs.TaskInputExpression
     * taskInputExpression}.
     *
     * @param ruleScope New ruleScope value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.Canvas#setRuleScope
     */
    public Process setRuleScope(String ruleScope)  throws IllegalStateException {
        return (Process)setAttribute("ruleScope", ruleScope, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} of the component that manages "rule context" for which this
     * process participates. The rule context can be used in {@link com.smartgwt.client.docs.TaskInputExpression
     * taskInputExpression}.
     *
     * @return Current ruleScope value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getRuleScope
     */
    public String getRuleScope()  {
        return getAttributeAsString("ruleScope");
    }
    

    /**
     * Sequences of ProcessElements.  By defining a sequences of elements you can make the
     *  {@link com.smartgwt.client.util.workflow.ProcessElement#getNextElement ProcessElement.nextElement} implicit.
     *  <P>
     *  
     *  
     *  Example of using sequences:
     *  <pre>
     *  Process process = new Process();
     *  process.setStartElement("firstSequence");
     *  ProcessSequence innerSequence = new ProcessSequence(incTask, add2Task, incTask);
     *  process.setSequences(
     *      new ProcessSequence("firstSequence", serviceTask, multiDecisionTask),
     *      new ProcessSequence("errorFlow", failureTask, userNotifyTask)
     *  );
     *  // standalone process elements not part of sequences
     *  process.setElements(new ServiceTask(){...});
     *  Record state = new Record();
     *  state.setAttribute("someField", "someValue");
     *  process.setState(state);
     *  process.start();
     *  </pre>
     * 
     *
     * @param sequences New sequences value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Process setSequences(ProcessSequence... sequences)  throws IllegalStateException {
        return (Process)setAttribute("sequences", sequences, false);
    }

    /**
     * Sequences of ProcessElements.  By defining a sequences of elements you can make the
     *  {@link com.smartgwt.client.util.workflow.ProcessElement#getNextElement ProcessElement.nextElement} implicit.
     *  <P>
     *  
     *  
     *  Example of using sequences:
     *  <pre>
     *  Process process = new Process();
     *  process.setStartElement("firstSequence");
     *  ProcessSequence innerSequence = new ProcessSequence(incTask, add2Task, incTask);
     *  process.setSequences(
     *      new ProcessSequence("firstSequence", serviceTask, multiDecisionTask),
     *      new ProcessSequence("errorFlow", failureTask, userNotifyTask)
     *  );
     *  // standalone process elements not part of sequences
     *  process.setElements(new ServiceTask(){...});
     *  Record state = new Record();
     *  state.setAttribute("someField", "someValue");
     *  process.setState(state);
     *  process.start();
     *  </pre>
     * 
     *
     * @return Current sequences value. Default value is null
     */
    public ProcessSequence[] getSequences()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfProcessSequence(getAttributeAsJavaScriptObject("sequences"));
    }
    

    /**
     * The ID of either a {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or an {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} which should be the starting point of the process.  If
     * not specified, the first sequence is chosen, or if there are no sequences, the first element. - log a warning and do
     * nothing if there are neither sequences or elements
     *
     * @param startElement New startElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Process setStartElement(String startElement)  throws IllegalStateException {
        return (Process)setAttribute("startElement", startElement, false);
    }

    /**
     * The ID of either a {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or an {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} which should be the starting point of the process.  If
     * not specified, the first sequence is chosen, or if there are no sequences, the first element. - log a warning and do
     * nothing if there are neither sequences or elements
     *
     * @return Current startElement value. Default value is null
     */
    public String getStartElement()  {
        return getAttributeAsString("startElement");
    }
    

    /**
     * Current state of a process.  As with Records in general, any field of a Record may contain a nested Record or Array of
     * Records, so the process state is essentially a hierarchical data structure. <p> <h4>Transient state</h4> In addition to
     * the explicit process state there is a "transient state." The transient state represents the complete output of each of
     * the last tasks of each type within the current process execution. This allows easy reference to the previous task output
     * with {@link com.smartgwt.client.docs.TaskInputExpression taskInputExpressions}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set process state for current process
     *
     * @param state the new process state. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     */
    public Process setState(Record state) {
        return (Process)setAttribute("state", state == null ? null : state.getJsObj(), true);
    }

    /**
     * Current state of a process.  As with Records in general, any field of a Record may contain a nested Record or Array of
     * Records, so the process state is essentially a hierarchical data structure. <p> <h4>Transient state</h4> In addition to
     * the explicit process state there is a "transient state." The transient state represents the complete output of each of
     * the last tasks of each type within the current process execution. This allows easy reference to the previous task output
     * with {@link com.smartgwt.client.docs.TaskInputExpression taskInputExpressions}.
     *
     * @return Current state value. Default value is null
     */
    public Record getState()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("state"));
    }
    

    /**
     * Context object to be passed to {@link com.smartgwt.client.util.workflow.Process#addTraceElementHandler
     * Process.traceElement()} during process execution.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param traceContext New traceContext value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     */
    public Process setTraceContext(Map traceContext) {
        return (Process)setAttribute("traceContext", traceContext, true);
    }

    /**
     * Context object to be passed to {@link com.smartgwt.client.util.workflow.Process#addTraceElementHandler
     * Process.traceElement()} during process execution.
     *
     * @return Current traceContext value. Default value is null
     */
    public Map getTraceContext()  {
        return getAttributeAsMap("traceContext");
    }
    

    /**
     * If wizard is set then current workflow will be handled as wizard. Every userTask will hide associated form after user
     * finished step.
     *
     * @param wizard New wizard value. Default value is false
     * @return {@link com.smartgwt.client.util.workflow.Process Process} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Process setWizard(Boolean wizard)  throws IllegalStateException {
        return (Process)setAttribute("wizard", wizard, false);
    }

    /**
     * If wizard is set then current workflow will be handled as wizard. Every userTask will hide associated form after user
     * finished step.
     *
     * @return Current wizard value. Default value is false
     */
    public Boolean getWizard()  {
        Boolean result = getAttributeAsBoolean("wizard");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a finished handler.
     * <p>
     * StringMethod called when a process completes, meaning the process executes a  ProcessElement with no next element.
     *
     * @param handler the finished handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFinishedHandler(com.smartgwt.client.util.workflow.events.FinishedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.util.workflow.events.ProcessFinishedEvent.getType()) == 0) setupFinishedEvent();
        return doAddHandler(handler, com.smartgwt.client.util.workflow.events.ProcessFinishedEvent.getType());
    }

    private native void setupFinishedEvent() /*-{
        var obj;
        var selfJ = this;
        var finished = $entry(function(){
            var param = {"_this": this, "state" : arguments[0]};
                var event = @com.smartgwt.client.util.workflow.events.ProcessFinishedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.util.workflow.Process::handleTearDownFinishedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({finished:  finished              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.finished =  finished             ;
        }
    }-*/;

    private void handleTearDownFinishedEvent() {
        if (getHandlerCount(com.smartgwt.client.util.workflow.events.ProcessFinishedEvent.getType()) == 0) tearDownFinishedEvent();
    }

    private native void tearDownFinishedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("finished")) delete obj.finished;
    }-*/;

	/**
     * Retrieve a {@link com.smartgwt.client.util.workflow.ProcessElement} by it's ID
     * @param ID id of the process element
     *
     * @return the indicated process element, or null if no such element exists
     */
    public native ProcessElement getElement(String ID) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getElement", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getElement(ID);
        if(ret == null) return null;
        return @com.smartgwt.client.util.workflow.ProcessElement::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the task output of the last task executed. More commonly a {@link com.smartgwt.client.docs.TaskInputExpression}
     * property is used (see {@link com.smartgwt.client.util.workflow.ProcessElement#getDynamicValue
     * ProcessElement.getDynamicValue()}).
     *
     * @return the last task output or null if none is found
     */
    public native Object getLastTaskOutput() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLastTaskOutput", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getLastTaskOutput();
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

	/**
     * Returns the task output of the last task executed. More commonly a {@link com.smartgwt.client.docs.TaskInputExpression}
     * property is used (see {@link com.smartgwt.client.util.workflow.ProcessElement#getDynamicValue
     * ProcessElement.getDynamicValue()}).
     * @param taskType the optional task type to lookup in last task output
     *
     * @return the last task output or null if none is found
     */
    public native Object getLastTaskOutput(String taskType) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLastTaskOutput", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getLastTaskOutput(taskType);
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;
	
	/**
     * Returns a variable value from the {@link com.smartgwt.client.util.workflow.Process#getState process state}. Values can
     * be written into process state by {@link com.smartgwt.client.util.workflow.Process#setStateVariable setStateVariable()},
     * setting {@link com.smartgwt.client.util.workflow.ProcessElement#getBindOutput ProcessElement.bindOutput}, or various
     * task output settings (See {@link com.smartgwt.client.docs.TaskIO}.)
     * @param stateVariablePath path to variable in process state to set.                                   segments are separated by a decimal point
     * (.)
     *
     * @return the value found at the path
     */
    public native Object getStateVariable(String stateVariablePath) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getStateVariable", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getStateVariable(stateVariablePath);
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

	/**
     * Takes the {@link com.smartgwt.client.util.workflow.Process#getLastTaskOutput last task output} and sets it as the {@link
     * com.smartgwt.client.util.workflow.Process#setTaskOutput task output} for the <code>task</code>. <p> This method is not
     * just a shortcut to set output of a pass-thru task but it also records the correct schema of the passed-thru output so it
     * can be quickly looked up.
     * @param task the workflow task setting the output (i.e. this)
     */
    public native void passThruTaskOutput(ProcessElement task) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "passThruTaskOutput", "ProcessElement");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.passThruTaskOutput(task == null ? null : task.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Reset process to it's initial state, so process can be started again.
     */
    public native void reset() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reset", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.reset();
    }-*/;

	/**
     * Reset process to it's initial state, so process can be started again.
     * @param state new state of the process
     */
    public native void reset(Record state) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reset", "Record");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.reset(state == null ? null : state.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Sets the task ID of the next task to execute after the current task finishes. If the task is not found or
     * <code>null</code> is passed as the nextElement, the current process will be terminated instead.
     */
    public native void setNextElement() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNextElement", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setNextElement();
    }-*/;

	/**
     * Sets the task ID of the next task to execute after the current task finishes. If the task is not found or
     * <code>null</code> is passed as the nextElement, the current process will be terminated instead.
     * @param nextElement ID of the next task execute or null to terminate process
     */
    public native void setNextElement(String nextElement) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNextElement", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setNextElement(nextElement);
    }-*/;
	
	/**
     * Sets a {@link com.smartgwt.client.util.workflow.Process#getState process state} variable for later reference with {@link
     * com.smartgwt.client.util.workflow.Process#getStateVariable getStateVariable()} or more commonly with a {@link
     * com.smartgwt.client.docs.TaskInputExpression} property.
     * @param stateVariablePath path to variable in process state to set.                                   segments are separated by a decimal point
     * (.)
     * @param value the value to save
     */
    public native void setStateVariable(String stateVariablePath, Object value) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setStateVariable", "String,Object");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setStateVariable(stateVariablePath, value);
    }-*/;

	/**
     * Sets the task output of <code>task</code> in the {@link com.smartgwt.client.types.State process state} so it can be used
     * by later tasks with {@link com.smartgwt.client.util.workflow.Process#getLastTaskOutput getLastTaskOutput()} or more
     * commonly with a {@link com.smartgwt.client.docs.TaskInputExpression} property. <p> If the task sets
     * <code>bindOutput</code> the output value is also written into that {@link
     * com.smartgwt.client.util.workflow.Process#getState process state} variable.
     * @param task the workflow task setting the output (i.e. this)
     * @param value the output value for task
     */
    public native void setTaskOutput(ProcessElement task, Object value) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setTaskOutput", "ProcessElement,Object");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setTaskOutput(task == null ? null : task.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), value);
    }-*/;

	/**
     * Starts this task by executing the {@link com.smartgwt.client.util.workflow.Process#getStartElement startElement}. Also
     * used by asynchronous tasks to restart the workflow.
     */
    public native void start() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "start", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.start();
    }-*/;

    /**
     * Add a traceElement handler.
     * <p>
     * StringMethod called during process execution before each task element is processed.
     *
     * @param handler the traceElement handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTraceElementHandler(com.smartgwt.client.util.workflow.events.TraceElementHandler handler) {
        if(getHandlerCount(com.smartgwt.client.util.workflow.events.ProcessTraceElementEvent.getType()) == 0) setupTraceElementEvent();
        return doAddHandler(handler, com.smartgwt.client.util.workflow.events.ProcessTraceElementEvent.getType());
    }

    private native void setupTraceElementEvent() /*-{
        var obj;
        var selfJ = this;
        var traceElement = $entry(function(){
            var param = {"_this": this, "element" : arguments[0], "context" : arguments[1]};
                var event = @com.smartgwt.client.util.workflow.events.ProcessTraceElementEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.util.workflow.Process::handleTearDownTraceElementEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({traceElement:  traceElement              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.traceElement =  traceElement             ;
        }
    }-*/;

    private void handleTearDownTraceElementEvent() {
        if (getHandlerCount(com.smartgwt.client.util.workflow.events.ProcessTraceElementEvent.getType()) == 0) tearDownTraceElementEvent();
    }

    private native void tearDownTraceElementEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("traceElement")) delete obj.traceElement;
    }-*/;


    // ********************* Static Methods ***********************

	/**
     * Get a Process instance by it's ID.  See {@link com.smartgwt.client.util.workflow.Process#loadProcess loadProcess()}.
     * @param processId process ID to retrieve.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return the process, or null if not loaded
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public static native Process getProcess(String processId) /*-{
        var ret = $wnd.isc.Process.getProcess(processId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.workflow.Process::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;



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

    public Process setAttribute(String attribute, ProcessElement[] value, boolean allowPostCreate) {
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

    public void setConfig(JavaScriptObject jsObj) {
        this.config = jsObj;
    }
    
    public static native void loadProcess(String processId, ProcessCallback callback) /*-{
        var processCallback = null;
        if (callback != null) {
            processCallback = $entry(function (process) {
                var processJ = @com.smartgwt.client.util.workflow.Process::new(Lcom/google/gwt/core/client/JavaScriptObject;)(process);
                processJ.@com.smartgwt.client.util.workflow.Process::setConfig(Lcom/google/gwt/core/client/JavaScriptObject;)(process);
                callback.@com.smartgwt.client.callbacks.ProcessCallback::execute(Lcom/smartgwt/client/util/workflow/Process;)(processJ);
            });
        } else {
	  		processCallback = function (process) {};
        }
        $wnd.isc.Process.loadProcess(processId, processCallback);
    }-*/;
    
    public ProcessElement[] getProcessElements(String attribute) {
        return elementParameters.get(attribute); 
    }
    
    /**
     * Elements involved in this Process.  You can also group elements into {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequences} to reduce the need to explicitly define IDs for
     * elements and interlink them.
     *
     *
     * @return ProcessElement
     */
    public ProcessElement[] getElements()  {
        return getProcessElements("elements");
    }

    /**
     * @see #setStartElement(String)
     */
    public void setStartElement(ProcessElement startElement)  throws IllegalStateException {
        setAttribute("startElement", startElement.getID(), false);
    }


}
