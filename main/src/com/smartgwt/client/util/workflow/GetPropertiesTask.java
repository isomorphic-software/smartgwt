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
 * Gets the value properties from a component and makes them available within the workflow as the {@link
 * com.smartgwt.client.docs.TaskInputExpression last task output}. Using {@link
 * com.smartgwt.client.util.workflow.ProcessElement#getBindOutput bindOutput}, these values can also be placed into the
 * {@link com.smartgwt.client.util.workflow.Process#getState process state}. <P> For a canvas the {@link
 * com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} specifies everything necessary to identify
 * the target. For a form control more information is needed. The {@link
 * com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} identifies the container (i.e. DynamicForm)
 * and the individual field is specified as {@link com.smartgwt.client.util.workflow.GetPropertiesTask#getTargetFieldName
 * targetFieldName}. <P> The next task might be a save operation on a DataSource, or SetPropertiesTask to copy settings
 * from one component to another. <p> GetPropertiesTask <em>is an advanced and rarely used task</em>. If you need a
 * component property to be dynamic, you can configure that property as a  Dynamic Property without the need for a
 * Workflow.  <em>Dynamic Properties</em> created this way automatically update as your users make changes.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GetPropertiesTask")
public class GetPropertiesTask extends ComponentTask {

    public static GetPropertiesTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (GetPropertiesTask) obj;
        } else {
            return new GetPropertiesTask(jsObj);
        }
    }
        


    public GetPropertiesTask(){
        scClassName = "GetPropertiesTask";
    }

    public GetPropertiesTask(JavaScriptObject jsObj){
        scClassName = "GetPropertiesTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Properties to be retrieved from {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId}.
     *
     * @param properties New properties value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GetPropertiesTask GetPropertiesTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GetPropertiesTask setProperties(String... properties)  throws IllegalStateException {
        return (GetPropertiesTask)setAttribute("properties", properties, false);
    }

    /**
     * Properties to be retrieved from {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId}.
     *
     * @return Current properties value. Default value is null
     */
    public String[] getProperties()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("properties"));
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a DynamicForm, this
     * property specifies the name of the target field.
     *
     * @param targetFieldName New targetFieldName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GetPropertiesTask GetPropertiesTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public GetPropertiesTask setTargetFieldName(String targetFieldName)  throws IllegalStateException {
        return (GetPropertiesTask)setAttribute("targetFieldName", targetFieldName, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a DynamicForm, this
     * property specifies the name of the target field.
     *
     * @return Current targetFieldName value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public String getTargetFieldName()  {
        return getAttributeAsString("targetFieldName");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
