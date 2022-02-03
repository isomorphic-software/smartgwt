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
 * A Task is an abstract superclass for {@link com.smartgwt.client.util.workflow.Process} and for all Task types that can
 * be involved in a Process, such as a {@link com.smartgwt.client.util.workflow.ServiceTask}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Task")
public class Task extends ProcessElement {

    public static Task getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (Task) obj;
        } else {
            return new Task(jsObj);
        }
    }
        


    public Task(){
        scClassName = "Task";
    }

    public Task(JavaScriptObject jsObj){
        scClassName = "Task";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Field in the {@link com.smartgwt.client.util.workflow.Process#getState process state} which is provided as input data to
     * this task.   See {@link com.smartgwt.client.docs.TaskIO}.
     *
     * @param inputField New inputField value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInputField(String inputField)  throws IllegalStateException {
        setAttribute("inputField", inputField, false);
    }

    /**
     * Field in the {@link com.smartgwt.client.util.workflow.Process#getState process state} which is provided as input data to
     * this task.   See {@link com.smartgwt.client.docs.TaskIO}.
     *
     * @return Current inputField value. Default value is null
     */
    public String getInputField()  {
        return getAttributeAsString("inputField");
    }
    

    /**
     * List of multiple fields from the {@link com.smartgwt.client.util.workflow.Process#getState process state} which are
     * provided as input data to this task. See {@link com.smartgwt.client.docs.TaskIO}. <P> If {@link
     * com.smartgwt.client.util.workflow.Task#getInputField inputField} is also specified, it will be implicitly added to the
     * <code>inputFieldList</code> if it is not already present.
     *
     * @param inputFieldList New inputFieldList value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInputFieldList(String... inputFieldList)  throws IllegalStateException {
        setAttribute("inputFieldList", inputFieldList, false);
    }

    /**
     * List of multiple fields from the {@link com.smartgwt.client.util.workflow.Process#getState process state} which are
     * provided as input data to this task. See {@link com.smartgwt.client.docs.TaskIO}. <P> If {@link
     * com.smartgwt.client.util.workflow.Task#getInputField inputField} is also specified, it will be implicitly added to the
     * <code>inputFieldList</code> if it is not already present.
     *
     * @return Current inputFieldList value. Default value is null
     */
    public String[] getInputFieldList()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("inputFieldList"));
    }
    

    /**
     * Field in the {@link com.smartgwt.client.util.workflow.Process#getState process state} which this task writes outputs to.
     * See {@link com.smartgwt.client.docs.TaskIO}.
     *
     * @param outputField New outputField value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setOutputField(String outputField)  throws IllegalStateException {
        setAttribute("outputField", outputField, false);
    }

    /**
     * Field in the {@link com.smartgwt.client.util.workflow.Process#getState process state} which this task writes outputs to.
     * See {@link com.smartgwt.client.docs.TaskIO}.
     *
     * @return Current outputField value. Default value is null
     */
    public String getOutputField()  {
        return getAttributeAsString("outputField");
    }
    

    /**
     * List of multiple fields from the {@link com.smartgwt.client.util.workflow.Process#getState process state} which this
     * task will write to. See {@link com.smartgwt.client.docs.TaskIO}.   <P> If {@link
     * com.smartgwt.client.util.workflow.Task#getOutputField outputField} is also specified, it will be implicitly added to the
     * <code>outputFieldList</code> if it is not already present.
     *
     * @param outputFieldList New outputFieldList value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setOutputFieldList(String... outputFieldList)  throws IllegalStateException {
        setAttribute("outputFieldList", outputFieldList, false);
    }

    /**
     * List of multiple fields from the {@link com.smartgwt.client.util.workflow.Process#getState process state} which this
     * task will write to. See {@link com.smartgwt.client.docs.TaskIO}.   <P> If {@link
     * com.smartgwt.client.util.workflow.Task#getOutputField outputField} is also specified, it will be implicitly added to the
     * <code>outputFieldList</code> if it is not already present.
     *
     * @return Current outputFieldList value. Default value is null
     */
    public String[] getOutputFieldList()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("outputFieldList"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
