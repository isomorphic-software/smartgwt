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
 * A instance of Process represents a stateful process executing a series of Tasks,  which may be: <ul> <li> user
 * interactions <li> calls to DataSources (hence: any database or web service) <li> arbitrary code <li> other Processes
 * </ul> A Process is <i>stateful</i> in the sense that it maintains {@link
 * com.smartgwt.client.util.workflow.Process#getState state} across the different tasks that are executed.  This allows you
 * to maintain context as you walk a user through a multi-step business process in your application, which may involve
 * multiple operations on multiple entities.  Each Task that executes can use the Process state as inputs, and can output a
 * result which is stored in the Process state - see {@link com.smartgwt.client.docs.TaskIO}. <P> A Process can have
 * multiple branches, choosing the next Task to execute based on {@link com.smartgwt.client.data.Criteria} - see {@link
 * com.smartgwt.client.util.workflow.XORGateway} and {@link com.smartgwt.client.util.workflow.DecisionGateway}. <P> Because
 * a Process may return to a previous Task in various situations, the data model of a Process is strictly speaking a
 * <i>graph</i> (a set of nodes connected by arbitary interlinks). However, most processes have sequences of several tasks
 * in a row, and the definition format allows these to be represented as simple Arrays called "sequences", specified via
 * {@link com.smartgwt.client.util.workflow.Process#getSequences sequences}.  This reduces the need to manually specify IDs
 * and interlinks for Tasks that simply proceed to the next task in a sequence.
 */
public class Process extends Task {

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
        id = JSOHelper.getAttribute(jsObj, "ID");
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
    // ********************* Properties / Attributes ***********************

    /**
     * Identifier of canvas where should be added UI elements created by using {@link
     * com.smartgwt.client.util.workflow.UserTask#getInlineView inline view} property.
     *
     * @param containerId . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setContainerId(String containerId) {
        setAttribute("containerId", containerId, true);
    }

    /**
     * Identifier of canvas where should be added UI elements created by using {@link
     * com.smartgwt.client.util.workflow.UserTask#getInlineView inline view} property.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getContainerId()  {
        return getAttributeAsString("containerId");
    }

    /**
     * Sequences of ProcessElements.  By defining a sequences of elements you can make the
     *  {@link com.smartgwt.client.util.workflow.ProcessElement#getNextElement nextElement} implicit.
     *  <P>
     *  
     *  
     *  Example of using sequences:
     *  <pre>
     *  Process process = new Process();
     *  process.setStartElement("firstSequence");
     *  ProcessSequence innerSequence = new ProcessSequence(incTask, add2Task, incTask);
     *  process.setSequences(
     *      new ProcessSequence("firstSequence", serviceTask, decisionGateway),
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
     * @param sequences sequences Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSequences(ProcessSequence... sequences)  throws IllegalStateException {
        setAttribute("sequences", sequences, false);
    }

    /**
     * Sequences of ProcessElements.  By defining a sequences of elements you can make the
     *  {@link com.smartgwt.client.util.workflow.ProcessElement#getNextElement nextElement} implicit.
     *  <P>
     *  
     *  
     *  Example of using sequences:
     *  <pre>
     *  Process process = new Process();
     *  process.setStartElement("firstSequence");
     *  ProcessSequence innerSequence = new ProcessSequence(incTask, add2Task, incTask);
     *  process.setSequences(
     *      new ProcessSequence("firstSequence", serviceTask, decisionGateway),
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
     *
     * @return ProcessSequence
     */
    public ProcessSequence[] getSequences()  {
        return ProcessSequence.convertToProcessSequenceArray(getAttributeAsJavaScriptObject("sequences"));
    }

    /**
     * Set new process state.
     *
     * @param setState setState Default value is null
     */
    public void setSetState(Record setState) {
        setAttribute("setState", setState.getJsObj(), true);
    }

    /**
     * Set new process state.
     *
     *
     * @return Record
     */
    public Record getSetState()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("setState"));
    }

    /**
     * The ID of either a {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or an {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} which should be the starting point of the process.  If
     * not specified, the first sequence is chosen, or if there are no sequences, the first element. - log a warning and do
     * nothing if there are neither sequences or elements
     *
     * @param startElement . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStartElement(String startElement)  throws IllegalStateException {
        setAttribute("startElement", startElement, false);
    }

    /**
     * The ID of either a {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or an {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} which should be the starting point of the process.  If
     * not specified, the first sequence is chosen, or if there are no sequences, the first element. - log a warning and do
     * nothing if there are neither sequences or elements
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getStartElement()  {
        return getAttributeAsString("startElement");
    }

    /**
     * Current state of a process.  As with Records in general, any field of a Record may contain a nested Record or Array of
     * Records, so the process state is essentially a hierarchical data structure.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set process state for current process
     *
     * @param state the new process state. Default value is null
     */
    public void setState(Record state) {
        setAttribute("state", state.getJsObj(), true);
    }

    /**
     * Current state of a process.  As with Records in general, any field of a Record may contain a nested Record or Array of
     * Records, so the process state is essentially a hierarchical data structure.
     *
     *
     * @return Record
     */
    public Record getState()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("state"));
    }

    /**
     * If wizard is set then current workflow will be handled as wizard. Every userTask will hide associated form after user
     * finished step.
     *
     * @param wizard wizard Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setWizard(Boolean wizard)  throws IllegalStateException {
        setAttribute("wizard", wizard, false);
    }

    /**
     * If wizard is set then current workflow will be handled as wizard. Every userTask will hide associated form after user
     * finished step.
     *
     *
     * @return Boolean
     */
    public Boolean getWizard()  {
        return getAttributeAsBoolean("wizard");
    }

    // ********************* Methods ***********************

    /**
     * StringMethod called when a process completes, meaning the process executes a  ProcessElement with no next element.
     * @param state the final process state
     */
    public native void finished(Record state) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.finished(state.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Retrieve a {@link com.smartgwt.client.util.workflow.ProcessElement} by it's ID
     * @param ID id of the process element
     *
     * @return the indicated process element, or null if no such element exists
     */
    public native ProcessElement getElement(String ID) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getElement(ID);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.util.workflow.ProcessElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * Reset process to it's initial state, so process can be started again.
     * @param state new state of the process
     */
    public native void reset(Record state) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.reset(state.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Starts this task by executing the {@link com.smartgwt.client.util.workflow.Process#getStartElement startElement}.
     */
    public native void start() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.start();
    }-*/;

    // ********************* Static Methods ***********************

    /**
     * Get a Process instance by it's ID.  See {@link com.smartgwt.client.util.workflow.Process#loadProcess
     * Process.loadProcess}.
     * @param processId process IDs to retrieve
     *
     * @return the process, or null if not loaded
     */
    public static native Process getProcess(String processId) /*-{
        var ret = $wnd.isc.Process.getProcess(processId);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.util.workflow.Process::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
        
    // ***********************************************************        



    public static interface ProcessCallback {
    	public void execute(Process process);
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
                callback.@com.smartgwt.client.util.workflow.Process.ProcessCallback::execute(Lcom/smartgwt/client/util/workflow/Process;)(processJ);
            });
        } else {
	  		processCallback = function (process) {};
        }
        $wnd.isc.Process.loadProcess(processId, processCallback);
    }-*/;
    
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
     * Elements involved in this Process.  You can also group elements into {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequences} to reduce the need to explicitly define IDs for
     * elements and interlink them.
     *
     * @param elements elements Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setElements(ProcessElement... elements)  throws IllegalStateException {
        setAttribute("elements", elements, false);
    }

    /**
     * @see #setStartElement(String)
     */
    public void setStartElement(ProcessElement startElement)  throws IllegalStateException {
        setAttribute("startElement", startElement.getID(), false);
    }

    protected native void onInit_Process() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        self.__finished = self.finished;
        self.finished = $entry(function(state) {
            var jObj = this.__ref;
            var stateJ = state == null ? null : @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(state);
            jObj.@com.smartgwt.client.util.workflow.Process::finished(Lcom/smartgwt/client/data/Record;)(stateJ);
        });
    }-*/;
    
    
    protected void onInit() {
        onInit_Process();
    };    

}




