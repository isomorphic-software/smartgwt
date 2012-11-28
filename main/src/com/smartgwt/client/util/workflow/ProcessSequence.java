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
 * An Array of {@link com.smartgwt.client.util.workflow.ProcessElement}s involved in a {@link
 * com.smartgwt.client.util.workflow.Process}.  A  <code>ProcessSequence</code> is used to reduce the number of explicit
 * {@link com.smartgwt.client.util.workflow.ProcessElement#getID ID}s that need to be assigned, by creating an implicit
 * next element - the next in the sequence. <P> A sequence cannot be executed outside of a Process and has no state.
 */
public class ProcessSequence extends ProcessElement {

    public static ProcessSequence getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ProcessSequence) obj;
        } else {
            return new ProcessSequence(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public ProcessSequence(){
        scClassName = "ProcessSequence";
    }

    public ProcessSequence(JavaScriptObject jsObj){
        scClassName = "ProcessSequence";
        setJavaScriptObject(jsObj);
    }

    public ProcessSequence(String ID) {
        setID(ID);
        scClassName = "ProcessSequence";
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    
    public ProcessSequence(ProcessElement... elements){
        scClassName = "ProcessSequence";
        setElements(elements);
    }
    
    public ProcessSequence(String id, ProcessElement... elements){
        super(id);
        scClassName = "ProcessSequence";
        setElements(elements);
    }

    /**
     * The {@link com.smartgwt.client.util.workflow.ProcessElement}s in this sequence.
     *
     *
     * @return ProcessElement
     */
    public ProcessElement[] getElements()  {
        return getProcessElements("elements");
    }

    /**
     * The {@link com.smartgwt.client.util.workflow.ProcessElement}s in this sequence.
     *
     * @param elements elements Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setElements(ProcessElement... elements)  throws IllegalStateException {
        setAttribute("elements", elements, false);
    }

    public static ProcessSequence[] convertToProcessSequenceArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ProcessSequence[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] processSequenceJS = JSOHelper.toArray(nativeArray);
            ProcessSequence[] objects = new ProcessSequence[processSequenceJS.length];
            for (int i = 0; i < processSequenceJS.length; i++) {
                JavaScriptObject criteriaJS = processSequenceJS[i];
                ProcessSequence obj = new ProcessSequence(criteriaJS);
                objects[i] = obj;
            }
            return objects;
        } else {
            ProcessSequence[] ret = new ProcessSequence[1];
            ret[0] = new ProcessSequence(nativeArray);
            return ret;
        }
    }
    

}



