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
@BeanFactory.ScClassName("MultiDecisionTask")
public class MultiDecisionTask extends ProcessElement {

    public static MultiDecisionTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (MultiDecisionTask) obj;
        } else {
            return new MultiDecisionTask(jsObj);
        }
    }
        


    public MultiDecisionTask(){
        scClassName = "MultiDecisionTask";
    }

    public MultiDecisionTask(JavaScriptObject jsObj){
        scClassName = "MultiDecisionTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * List of {@link com.smartgwt.client.util.workflow.DecisionBranch DecisionBranchs} to be processed to find the first with
     * matching
     * criteria. The specified {@link com.smartgwt.client.util.workflow.DecisionBranch#getTargetTask DecisionBranch.targetTask}
     * is then used to identify the the next
     *  element.
     *  <P>
     * If no criteria is matched the next element is {@link
     * com.smartgwt.client.util.workflow.MultiDecisionTask#getDefaultElement defaultElement} or the workflow
     *  is finished.
     *  <p>
     *  When providing a MultiDecisionTask in XML, the <code>decisionList</code> is expressed as:
     *  <pre>
     *      &lt;MultiDecisionTask ID="continentDecision" description="Which continent?" defaultElement="summary"&gt;
     *          &lt;decisionList&gt;
     *              &lt;decisionBranch targetTask="europeVATTask"&gt;
     *                  &lt;criteria fieldName="order.continent" operator="equals" value="Europe" /&gt;
     *              &lt;/decisionBranch&gt;
     *              ...
     *          &lt;/decisionList&gt;
     *      &lt;MultiDecisionTask&gt;
     *  </pre>
     *
     * @param decisionList New decisionList value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.MultiDecisionTask MultiDecisionTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public MultiDecisionTask setDecisionList(DecisionBranch... decisionList)  throws IllegalStateException {
        return (MultiDecisionTask)setAttribute("decisionList", decisionList, false);
    }

    /**
     * List of {@link com.smartgwt.client.util.workflow.DecisionBranch DecisionBranchs} to be processed to find the first with
     * matching
     * criteria. The specified {@link com.smartgwt.client.util.workflow.DecisionBranch#getTargetTask DecisionBranch.targetTask}
     * is then used to identify the the next
     *  element.
     *  <P>
     * If no criteria is matched the next element is {@link
     * com.smartgwt.client.util.workflow.MultiDecisionTask#getDefaultElement defaultElement} or the workflow
     *  is finished.
     *  <p>
     *  When providing a MultiDecisionTask in XML, the <code>decisionList</code> is expressed as:
     *  <pre>
     *      &lt;MultiDecisionTask ID="continentDecision" description="Which continent?" defaultElement="summary"&gt;
     *          &lt;decisionList&gt;
     *              &lt;decisionBranch targetTask="europeVATTask"&gt;
     *                  &lt;criteria fieldName="order.continent" operator="equals" value="Europe" /&gt;
     *              &lt;/decisionBranch&gt;
     *              ...
     *          &lt;/decisionList&gt;
     *      &lt;MultiDecisionTask&gt;
     *  </pre>
     *
     * @return Current decisionList value. Default value is null
     */
    public DecisionBranch[] getDecisionList()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDecisionBranch(getAttributeAsJavaScriptObject("decisionList"));
    }
    

    /**
     * Next element to pick if no criteria match.  If this decision is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence, the
     * <code>defaultElement</code> is assumed to be the next element and does not need to be specified.
     *
     * @param defaultElement New defaultElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.MultiDecisionTask MultiDecisionTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public MultiDecisionTask setDefaultElement(String defaultElement)  throws IllegalStateException {
        return (MultiDecisionTask)setAttribute("defaultElement", defaultElement, false);
    }

    /**
     * Next element to pick if no criteria match.  If this decision is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence, the
     * <code>defaultElement</code> is assumed to be the next element and does not need to be specified.
     *
     * @return Current defaultElement value. Default value is null
     */
    public String getDefaultElement()  {
        return getAttributeAsString("defaultElement");
    }
    
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
