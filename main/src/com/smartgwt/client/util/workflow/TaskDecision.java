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
 * Identifies a potential decision (branch) within a {@link com.smartgwt.client.util.workflow.DecisionGateway}. Each
 * decision has a criteria and a target ProcessElement ID.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TaskDecision")
public class TaskDecision extends BaseClass {

    public static TaskDecision getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (TaskDecision) obj;
        } else {
            return new TaskDecision(jsObj);
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
        


    public TaskDecision(){
        scClassName = "TaskDecision";
    }

    public TaskDecision(JavaScriptObject jsObj){
        scClassName = "TaskDecision";
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
     * Criteria identifying when the {@link com.smartgwt.client.util.workflow.TaskDecision#getTargetTask targetTask} should be
     * chosen within a {@link com.smartgwt.client.util.workflow.DecisionGateway#getDecisionList DecisionGateway.decisionList}.
     * <P> Data values in this criteria prefixed with "$" will be treated as dynamic expressions as detailed in {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Specifically, this means that for  simple criteria, any property value
     * that is a String and is prefixed with "$" will be assumed to be an expression, and for AdvancedCriteria, the same
     * treatment will be applied to {@link com.smartgwt.client.data.Criterion#getValue Criterion.value}. <P> Note that dynamic
     * expressions starting with "$input" are not applicable in this context but "$inputRecord" can be used for direct
     * reference to {@link com.smartgwt.client.util.workflow.Process#getState Process.state}.  <p> This property supports
     * {@link com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @param criteria New criteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.TaskDecision TaskDecision} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TaskDecision setCriteria(Criteria criteria)  throws IllegalStateException {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (TaskDecision)setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), false);
    }

    /**
     * Criteria identifying when the {@link com.smartgwt.client.util.workflow.TaskDecision#getTargetTask targetTask} should be
     * chosen within a {@link com.smartgwt.client.util.workflow.DecisionGateway#getDecisionList DecisionGateway.decisionList}.
     * <P> Data values in this criteria prefixed with "$" will be treated as dynamic expressions as detailed in {@link
     * com.smartgwt.client.docs.TaskInputExpression}.  Specifically, this means that for  simple criteria, any property value
     * that is a String and is prefixed with "$" will be assumed to be an expression, and for AdvancedCriteria, the same
     * treatment will be applied to {@link com.smartgwt.client.data.Criterion#getValue Criterion.value}. <P> Note that dynamic
     * expressions starting with "$input" are not applicable in this context but "$inputRecord" can be used for direct
     * reference to {@link com.smartgwt.client.util.workflow.Process#getState Process.state}.  <p> This property supports
     * {@link com.smartgwt.client.docs.DynamicCriteria} - use {@link com.smartgwt.client.data.Criterion#getValuePath
     * Criterion.valuePath} to refer to values in the {@link com.smartgwt.client.util.workflow.Process#getRuleScope
     * Process.ruleScope}.
     *
     * @return Current criteria value. Default value is null
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * {@link com.smartgwt.client.util.workflow.ProcessElement#getID ProcessElement.ID} of element to be used as next element
     * if {@link com.smartgwt.client.util.workflow.TaskDecision#getCriteria criteria} matches.
     *
     * @param targetTask New targetTask value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.TaskDecision TaskDecision} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TaskDecision setTargetTask(String targetTask)  throws IllegalStateException {
        return (TaskDecision)setAttribute("targetTask", targetTask, false);
    }

    /**
     * {@link com.smartgwt.client.util.workflow.ProcessElement#getID ProcessElement.ID} of element to be used as next element
     * if {@link com.smartgwt.client.util.workflow.TaskDecision#getCriteria criteria} matches.
     *
     * @return Current targetTask value. Default value is null
     */
    public String getTargetTask()  {
        return getAttributeAsString("targetTask");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
