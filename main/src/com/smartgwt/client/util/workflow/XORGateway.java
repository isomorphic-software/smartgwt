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
 * Chooses one or another next process element based on AdvancedCriteria applied to {@link
 * com.smartgwt.client.util.workflow.Process#getState Process.state}. <P> If the AdvancedCriteria evaluate to true, the
 * {@link com.smartgwt.client.util.workflow.XORGateway#getNextElement nextElement} is chosen, otherwise the {@link
 * com.smartgwt.client.util.workflow.XORGateway#getFailureElement failureElement}. <P> Note that "XOR" in
 * <code>XORGateway</code> means "exclusive or" - only one next element is chosen.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("XORGateway")
public class XORGateway extends ProcessElement {

    public static XORGateway getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (XORGateway) obj;
        } else {
            return new XORGateway(jsObj);
        }
    }
        


    public XORGateway(){
        scClassName = "XORGateway";
    }

    public XORGateway(JavaScriptObject jsObj){
        scClassName = "XORGateway";
        setJavaScriptObject(jsObj);
    }


    public XORGateway(String ID, String nextElement, String failureElement) {
        setID(ID);
		setNextElement(nextElement);
		setFailureElement(failureElement);
                scClassName = "XORGateway";
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Simple or {@link com.smartgwt.client.data.AdvancedCriteria} to be applied to the task inputs.  These will be applied to
     * either the data indicated by the {@link com.smartgwt.client.util.workflow.Task#getInputField Task.inputField} or to the
     * "inputRecord" if multiple input fields are declared (see {@link com.smartgwt.client.docs.TaskIO}).
     *
     * @param criteria New criteria value. Default value is IR
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCriteria(Criteria criteria)  throws IllegalStateException {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), false);
    }

    /**
     * Simple or {@link com.smartgwt.client.data.AdvancedCriteria} to be applied to the task inputs.  These will be applied to
     * either the data indicated by the {@link com.smartgwt.client.util.workflow.Task#getInputField Task.inputField} or to the
     * "inputRecord" if multiple input fields are declared (see {@link com.smartgwt.client.docs.TaskIO}).
     *
     * @return Current criteria value. Default value is IR
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * ID of the next sequence or element to proceed to if the criteria do not match.
     *
     * @param failureElement New failureElement value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFailureElement(String failureElement)  throws IllegalStateException {
        setAttribute("failureElement", failureElement, false);
    }

    /**
     * ID of the next sequence or element to proceed to if the criteria do not match.
     *
     * @return Current failureElement value. Default value is null
     */
    public String getFailureElement()  {
        return getAttributeAsString("failureElement");
    }
    

    /**
     * ID of the next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {process.elements,element} to
     * procede to if the criteria match the process state.  If this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence,
     * <code>nextElement</code> does not need to be specified.
     *
     * @param nextElement New nextElement value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setNextElement(String nextElement)  throws IllegalStateException {
        setAttribute("nextElement", nextElement, false);
    }

    /**
     * ID of the next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {process.elements,element} to
     * procede to if the criteria match the process state.  If this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence,
     * <code>nextElement</code> does not need to be specified.
     *
     * @return Current nextElement value. Default value is null
     */
    public String getNextElement()  {
        return getAttributeAsString("nextElement");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    public XORGateway(String ID, ProcessElement nextElement, ProcessElement failureElement) {
        this(ID, nextElement.getID(), failureElement.getID());
    }

    /**
     * @see #setFailureElement(String)
     */
    public void setFailureElement(ProcessElement failureElement)  throws IllegalStateException {
        this.setFailureElement(failureElement.getID());
    }

    /**
     * @see setNextElement(String)
     */
    public void setNextElement(ProcessElement nextElement)  throws IllegalStateException {
        this.setNextElement(nextElement.getID());
    }

}
