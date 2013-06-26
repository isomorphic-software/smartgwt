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
import com.smartgwt.client.callbacks.*;
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
 * Chooses a next element in a {@link com.smartgwt.client.util.workflow.Process} by evaluating a series of criteria against
 * the {@link com.smartgwt.client.util.workflow.Process#getState state} and choosing the element associated with the
 * criteria that matched, or a {@link com.smartgwt.client.util.workflow.DecisionGateway#getDefaultElement defaultElement}
 * if none of the criteria match.
 */
public class DecisionGateway extends ProcessElement {

    public static DecisionGateway getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DecisionGateway) obj;
        } else {
            return new DecisionGateway(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
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
     * Next element to pick if no criteria match.  If this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence, the
     * <code>defaultElement</code> is assumed to be the next element and does not need to be specified.
     *
     * @param defaultElement . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDefaultElement(String defaultElement)  throws IllegalStateException {
        setAttribute("defaultElement", defaultElement, false);
    }

    /**
     * Next element to pick if no criteria match.  If this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence, the
     * <code>defaultElement</code> is assumed to be the next element and does not need to be specified.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getDefaultElement()  {
        return getAttributeAsString("defaultElement");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * A Map from {@link com.smartgwt.client.util.workflow.ProcessElement#getID ID} to Criteria that will cause this
     * ProcessElement to be chosen as the next element if the criteria matches.
     *
     * @param criteriaMap criteriaMap Default value is null
     */
    public void setCriteriaMap(LinkedHashMap<String,Criteria> criteriaMap) {
        setAttribute("criteriaMap", criteriaMap, false);
    }

    /**
     * A Map from {@link com.smartgwt.client.util.workflow.ProcessElement#getID ID} to Criteria that will cause this
     * ProcessElement to be chosen as the next element if the criteria matches.
     *
     *
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


