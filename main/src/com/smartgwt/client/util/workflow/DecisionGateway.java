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
 * Chooses a next element in a {@link com.smartgwt.client.util.workflow.Process} by evaluating a series of criteria against
 * the {@link com.smartgwt.client.util.workflow.Process#getState Process.state} and choosing the element associated with
 * the criteria that matched, or a {@link com.smartgwt.client.util.workflow.MultiDecisionTask#getDefaultElement
 * defaultElement} if none of the criteria match.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DecisionGateway")
public class DecisionGateway extends MultiDecisionTask {

    public static DecisionGateway getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DecisionGateway) obj;
        } else {
            return new DecisionGateway(jsObj);
        }
    }
        


    public DecisionGateway(){
        scClassName = "DecisionGateway";
    }

    public DecisionGateway(JavaScriptObject jsObj){
        scClassName = "DecisionGateway";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * A Map from {@link com.smartgwt.client.util.workflow.ProcessElement#getID ProcessElement.ID} to Criteria that will cause
     * this ProcessElement to be chosen as the next element if the criteria matches. <P> If no criteria is matched the next
     * element is {@link com.smartgwt.client.util.workflow.MultiDecisionTask#getDefaultElement defaultElement} or the workflow
     * is finished. <P> Data values in this criteria prefixed with "$" will be treated as dynamic expressions as detailed in
     * {@link com.smartgwt.client.docs.TaskInputExpression}.  Specifically, this means that for  simple criteria, any property
     * value that is a String and is prefixed with "$" will be assumed to be an expression, and for AdvancedCriteria, the same
     * treatment will be applied to {@link com.smartgwt.client.data.Criterion#getValue Criterion.value}. <P> Note that dynamic
     * expressions starting with "$input" are not applicable for an decisionGateway but "$inputRecord" can be used for direct
     * reference to {@link com.smartgwt.client.util.workflow.Process#getState Process.state}.  <p> This property supports
     * {@link com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @param criteriaMap New criteriaMap value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.DecisionGateway DecisionGateway} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated In favor of {@link com.smartgwt.client.util.workflow.MultiDecisionTask#getDecisionList decisionList} as of  SmartGWT
     * release 12.1
     */
    public DecisionGateway setCriteriaMap(Map<String,Criteria> criteriaMap)  throws IllegalStateException {
        return (DecisionGateway)setAttribute("criteriaMap", criteriaMap, false);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * A Map from {@link com.smartgwt.client.util.workflow.ProcessElement#getID ID} to Criteria that will cause this
     * ProcessElement to be chosen as the next element if the criteria matches.
     *
     * @deprecated in favor of {@link #getDecisionList}.
     * @return LinkedHashMap<String,Criteria>
     */
    public LinkedHashMap getCriteriaMap()  {
        return (LinkedHashMap) getAttributeAsMap("criteriaMap");
    }

    /**
     * @see #setDefaultElement(String)
     */
    public void setDefaultElement(ProcessElement defaultElement)  throws IllegalStateException {
        this.setDefaultElement(defaultElement.getID());
    }


}
