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
 * An Array of {@link com.smartgwt.client.util.workflow.ProcessElement}s involved in a {@link
 * com.smartgwt.client.util.workflow.Process}.  A  <code>ProcessSequence</code> is used to reduce the number of explicit
 * {@link com.smartgwt.client.util.workflow.ProcessElement#getID ProcessElement.ID}s that need to be assigned, by creating
 * an implicit next element - the next in the sequence. <P> A sequence cannot be executed outside of a Process and has no
 * state.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ProcessSequence")
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

    /**
     * The {@link com.smartgwt.client.util.workflow.ProcessElement}s in this sequence.
     *
     * @param elements New elements value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setElements(ProcessElement... elements)  throws IllegalStateException {
        setAttribute("elements", elements, false);
    }
    

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

}
