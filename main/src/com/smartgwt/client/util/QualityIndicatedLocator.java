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
 
package com.smartgwt.client.util;


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
 * An object returned from {@link com.smartgwt.client.util.AutoTest#getLocatorWithIndicators
 * AutoTest.getLocatorWithIndicators()} that includes the locator and properties that describe the quality of the locator.
 */
@BeanFactory.FrameworkClass
public class QualityIndicatedLocator extends DataClass {

    public static QualityIndicatedLocator getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new QualityIndicatedLocator(jsObj);
    }
        


    public QualityIndicatedLocator(){
        
    }

    public QualityIndicatedLocator(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * True if the returned {@link com.smartgwt.client.util.QualityIndicatedLocator#getLocator locator} includes a reference
     * using an auto-generated global ID.
     *
     * @param containsGlobalId New containsGlobalId value. Default value is null
     * @return {@link com.smartgwt.client.util.QualityIndicatedLocator QualityIndicatedLocator} instance, for chaining setter calls
     */
    public QualityIndicatedLocator setContainsGlobalId(Boolean containsGlobalId) {
        return (QualityIndicatedLocator)setAttribute("containsGlobalId", containsGlobalId);
    }

    /**
     * True if the returned {@link com.smartgwt.client.util.QualityIndicatedLocator#getLocator locator} includes a reference
     * using an auto-generated global ID.
     *
     * @return Current containsGlobalId value. Default value is null
     */
    public Boolean getContainsGlobalId()  {
        return getAttributeAsBoolean("containsGlobalId", true);
    }
    

    /**
     * True if the returned {@link com.smartgwt.client.util.QualityIndicatedLocator#getLocator locator} includes references
     * using index positions.
     *
     * @param containsIndices New containsIndices value. Default value is null
     * @return {@link com.smartgwt.client.util.QualityIndicatedLocator QualityIndicatedLocator} instance, for chaining setter calls
     */
    public QualityIndicatedLocator setContainsIndices(Boolean containsIndices) {
        return (QualityIndicatedLocator)setAttribute("containsIndices", containsIndices);
    }

    /**
     * True if the returned {@link com.smartgwt.client.util.QualityIndicatedLocator#getLocator locator} includes references
     * using index positions.
     *
     * @return Current containsIndices value. Default value is null
     */
    public Boolean getContainsIndices()  {
        return getAttributeAsBoolean("containsIndices", true);
    }
    

    /**
     * The ID of the first parent within the locator segments that has a child referenced by index. Note that a child component
     * with an explicit {@link com.smartgwt.client.widgets.Canvas#getLocatorName locatorName} will be excluded since the name
     * is a reliable means to locate the component.
     *
     * @param firstParentOfIndex New firstParentOfIndex value. Default value is null
     * @return {@link com.smartgwt.client.util.QualityIndicatedLocator QualityIndicatedLocator} instance, for chaining setter calls
     */
    public QualityIndicatedLocator setFirstParentOfIndex(String firstParentOfIndex) {
        return (QualityIndicatedLocator)setAttribute("firstParentOfIndex", firstParentOfIndex);
    }

    /**
     * The ID of the first parent within the locator segments that has a child referenced by index. Note that a child component
     * with an explicit {@link com.smartgwt.client.widgets.Canvas#getLocatorName locatorName} will be excluded since the name
     * is a reliable means to locate the component.
     *
     * @return Current firstParentOfIndex value. Default value is null
     */
    public String getFirstParentOfIndex()  {
        return getAttributeAsString("firstParentOfIndex");
    }
    

    /**
     * The ID of the component within the locator segments that has an auto-generated global ID.
     *
     * @param globalID New globalID value. Default value is null
     * @return {@link com.smartgwt.client.util.QualityIndicatedLocator QualityIndicatedLocator} instance, for chaining setter calls
     */
    public QualityIndicatedLocator setGlobalID(String globalID) {
        return (QualityIndicatedLocator)setAttribute("globalID", globalID);
    }

    /**
     * The ID of the component within the locator segments that has an auto-generated global ID.
     *
     * @return Current globalID value. Default value is null
     */
    public String getGlobalID()  {
        return getAttributeAsString("globalID");
    }
    

    /**
     * The {@link com.smartgwt.client.docs.AutoTestLocator} associated with some DOM element in a Smart GWT application page.
     *
     * @param locator New locator value. Default value is null
     * @return {@link com.smartgwt.client.util.QualityIndicatedLocator QualityIndicatedLocator} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.AutoTestLocator AutoTestLocator 
     */
    public QualityIndicatedLocator setLocator(String locator) {
        return (QualityIndicatedLocator)setAttribute("locator", locator);
    }

    /**
     * The {@link com.smartgwt.client.docs.AutoTestLocator} associated with some DOM element in a Smart GWT application page.
     *
     * @return Current locator value. Default value is null
     * @see com.smartgwt.client.docs.AutoTestLocator AutoTestLocator 
     */
    public String getLocator()  {
        return getAttributeAsString("locator");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
