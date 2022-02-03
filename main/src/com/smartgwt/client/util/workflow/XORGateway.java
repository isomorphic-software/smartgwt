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
     * Simple or {@link com.smartgwt.client.data.AdvancedCriteria} to be applied against the {@link
     * com.smartgwt.client.util.workflow.Process#getState Process.state}. <P> Data values in this criteria prefixed with "$"
     * will be treated as dynamic expressions as detailed in {@link com.smartgwt.client.docs.TaskInputExpression}. 
     * Specifically, this means that for  simple criteria, any property value that is a String and is prefixed with "$" will be
     * assumed to be an expression, and for AdvancedCriteria, the same treatment will be applied to {@link
     * com.smartgwt.client.data.Criterion#getValue Criterion.value}. <p> Note that dynamic expressions starting with "$input"
     * are not applicable for an XORGateway but "$inputRecord" can be used for direct reference to {@link
     * com.smartgwt.client.util.workflow.Process#getState Process.state}.  <p> This property supports {@link
     * com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @param criteria New criteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.XORGateway XORGateway} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public XORGateway setCriteria(Criteria criteria)  throws IllegalStateException {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (XORGateway)setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), false);
    }

    /**
     * Simple or {@link com.smartgwt.client.data.AdvancedCriteria} to be applied against the {@link
     * com.smartgwt.client.util.workflow.Process#getState Process.state}. <P> Data values in this criteria prefixed with "$"
     * will be treated as dynamic expressions as detailed in {@link com.smartgwt.client.docs.TaskInputExpression}. 
     * Specifically, this means that for  simple criteria, any property value that is a String and is prefixed with "$" will be
     * assumed to be an expression, and for AdvancedCriteria, the same treatment will be applied to {@link
     * com.smartgwt.client.data.Criterion#getValue Criterion.value}. <p> Note that dynamic expressions starting with "$input"
     * are not applicable for an XORGateway but "$inputRecord" can be used for direct reference to {@link
     * com.smartgwt.client.util.workflow.Process#getState Process.state}.  <p> This property supports {@link
     * com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @return Current criteria value. Default value is null
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * ID of the next sequence or element to proceed to if the criteria do not match.
     *
     * @param failureElement New failureElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.XORGateway XORGateway} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public XORGateway setFailureElement(String failureElement)  throws IllegalStateException {
        return (XORGateway)setAttribute("failureElement", failureElement, false);
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
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute if the criteria match the process state.   <p>
     * <code>nextElement</code> does not need to be specified if this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence. <p> Note that
     * if there is both a <code>sequence</code> and a normal <code>element</code> with the same name in the current
     * <code>Process</code>, the <code>sequence</code> will be used.
     *
     * @param nextElement New nextElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.XORGateway XORGateway} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public XORGateway setNextElement(String nextElement)  throws IllegalStateException {
        return (XORGateway)setAttribute("nextElement", nextElement, false);
    }

    /**
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute if the criteria match the process state.   <p>
     * <code>nextElement</code> does not need to be specified if this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence. <p> Note that
     * if there is both a <code>sequence</code> and a normal <code>element</code> with the same name in the current
     * <code>Process</code>, the <code>sequence</code> will be used.
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
