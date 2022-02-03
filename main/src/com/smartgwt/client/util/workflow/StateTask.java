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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * StateTask can either copy fields of {@link com.smartgwt.client.util.workflow.Process#getState Process.state} to other
 * fields, or apply hardcoded values to {@link com.smartgwt.client.util.workflow.Process#getState Process.state} via {@link
 * com.smartgwt.client.util.workflow.StateTask#getValue value}. <p> Some examples: <ul> <li>inputField: "a", outputField:
 * "b" - copies "a" to "b" <li>inputField: "a", outputField: "b", type: "integer" - copies "a" to "b" converting "a" to an
 * integer <li>inputFieldList: ["a","b"], outputField: ["c","d"] - copies "a" and "b" to "c" and "d" respectively. </ul>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("StateTask")
public class StateTask extends Task {

    public static StateTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (StateTask) obj;
        } else {
            return new StateTask(jsObj);
        }
    }
        


    public StateTask(){
        scClassName = "StateTask";
    }

    public StateTask(JavaScriptObject jsObj){
        scClassName = "StateTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * ID of the next sequence or element to proceed to if a failure condition arises, such as the output data not being
     * convertible to the target {@link com.smartgwt.client.util.workflow.StateTask#getType type}.
     *
     * @param failureElement New failureElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.StateTask StateTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public StateTask setFailureElement(String failureElement)  throws IllegalStateException {
        return (StateTask)setAttribute("failureElement", failureElement, false);
    }

    /**
     * ID of the next sequence or element to proceed to if a failure condition arises, such as the output data not being
     * convertible to the target {@link com.smartgwt.client.util.workflow.StateTask#getType type}.
     *
     * @return Current failureElement value. Default value is null
     */
    public String getFailureElement()  {
        return getAttributeAsString("failureElement");
    }
    
    

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state.
     *
     * @param passThruOutput New passThruOutput value. Default value is false
     * @return {@link com.smartgwt.client.util.workflow.StateTask StateTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public StateTask setPassThruOutput(Boolean passThruOutput)  throws IllegalStateException {
        return (StateTask)setAttribute("passThruOutput", passThruOutput, false);
    }

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state.
     *
     * @return Current passThruOutput value. Default value is false
     */
    public Boolean getPassThruOutput()  {
        Boolean result = getAttributeAsBoolean("passThruOutput");
        return result == null ? false : result;
    }
    
    
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
