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
 * Base class for tasks that target SmartGWT UI-specific operations. <P> Note: This task is not for direct use - use one of
 * the subclasses instead.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ComponentTask")
public class ComponentTask extends ProcessElement {

    public static ComponentTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ComponentTask) obj;
        } else {
            return new ComponentTask(jsObj);
        }
    }
        


    public ComponentTask(){
        scClassName = "ComponentTask";
    }

    public ComponentTask(JavaScriptObject jsObj){
        scClassName = "ComponentTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Base class of components that this task targets.
     *
     * @param componentBaseClass New componentBaseClass value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ComponentTask ComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ComponentTask setComponentBaseClass(String componentBaseClass)  throws IllegalStateException {
        return (ComponentTask)setAttribute("componentBaseClass", componentBaseClass, false);
    }

    /**
     * Base class of components that this task targets.
     *
     * @return Current componentBaseClass value. Default value is null
     */
    public String getComponentBaseClass()  {
        return getAttributeAsString("componentBaseClass");
    }

    /**
     * Base class of components that this task targets.
     *
     * @param componentBaseClass New componentBaseClass value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ComponentTask ComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ComponentTask setComponentBaseClass(String... componentBaseClass)  throws IllegalStateException {
        return (ComponentTask)setAttribute("componentBaseClass", componentBaseClass, false);
    }

    /**
     * Base class of components that this task targets.
     *
     * @return Current componentBaseClass value. Default value is null
     */
    public String[] getComponentBaseClassAsStringArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("componentBaseClass"));
    }
    

    /**
     * ID of component targeted by this task.
     *
     * @param componentId New componentId value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ComponentTask ComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     */
    public ComponentTask setComponentId(String componentId)  throws IllegalStateException {
        return (ComponentTask)setAttribute("componentId", componentId, false);
    }

    /**
     * ID of component targeted by this task.
     *
     * @return Current componentId value. Default value is null
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     */
    public String getComponentId()  {
        return getAttributeAsString("componentId");
    }
    

    /**
     * Must target components of this task have a DataSource?
     *
     * @param componentRequiresDataSource New componentRequiresDataSource value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ComponentTask ComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ComponentTask setComponentRequiresDataSource(Boolean componentRequiresDataSource)  throws IllegalStateException {
        return (ComponentTask)setAttribute("componentRequiresDataSource", componentRequiresDataSource, false);
    }

    /**
     * Must target components of this task have a DataSource?
     *
     * @return Current componentRequiresDataSource value. Default value is null
     */
    public Boolean getComponentRequiresDataSource()  {
        return getAttributeAsBoolean("componentRequiresDataSource");
    }
    

    // ********************* Methods ***********************
	/**
     * Returns the actual component specified by {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId
     * componentId} for this task. Unless <code>skipValidation</code> is true, the component type is validated against {@link
     * com.smartgwt.client.util.workflow.ComponentTask#getComponentBaseClass componentBaseClass} and only returned if it
     * matches. Null is returned otherwise.
     * @param process the process that is handling the workflow
     */
    public native void getTargetComponent(Process process) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getTargetComponent", "Process");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getTargetComponent(process == null ? null : process.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Returns the actual component specified by {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId
     * componentId} for this task. Unless <code>skipValidation</code> is true, the component type is validated against {@link
     * com.smartgwt.client.util.workflow.ComponentTask#getComponentBaseClass componentBaseClass} and only returned if it
     * matches. Null is returned otherwise.
     * @param process the process that is handling the workflow
     * @param skipValidation skip validation against componentBaseClass?
     */
    public native void getTargetComponent(Process process, Boolean skipValidation) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getTargetComponent", "Process,Boolean");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getTargetComponent(process == null ? null : process.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), skipValidation == null ? null : skipValidation.@java.lang.Boolean::booleanValue()());
    }-*/;
	

    // ********************* Static Methods ***********************

    // ***********************************************************

}
