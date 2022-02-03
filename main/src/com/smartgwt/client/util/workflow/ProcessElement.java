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
 * A ProcessElement is an abstract superclass for elements involved in a {@link com.smartgwt.client.util.workflow.Process},
 * such as a {@link com.smartgwt.client.util.workflow.Task} or {@link com.smartgwt.client.util.workflow.XORGateway}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ProcessElement")
public class ProcessElement extends BaseClass {

    public static ProcessElement getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ProcessElement) obj;
        } else {
            return new ProcessElement(jsObj);
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
        


    public ProcessElement(){
        scClassName = "ProcessElement";
    }

    public ProcessElement(JavaScriptObject jsObj){
        scClassName = "ProcessElement";
        setJavaScriptObject(jsObj);
    }


    public ProcessElement(String ID) {
        setID(ID);
                scClassName = "ProcessElement";
    }


    public ProcessElement(String ID, String nextElement) {
        setID(ID);
		setNextElement(nextElement);
                scClassName = "ProcessElement";
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
     * Optional description of the general nature of the kinds of tasks this this process element performs. Not to be confused
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getDescription description} which describes what the
     * specific instance of the process element has been configured to do. <P> For example, the <code>classDescription</code>
     * for a task to disable a field might be "disables a field" whereas the <code>description</code> for a concrete instance
     * might be "disables the 'shipTo' field in the 'ordering' form". <P> Used by editor to display additional details along
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getTitle title}.
     *
     * @param classDescription New classDescription value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setClassDescription(String classDescription)  throws IllegalStateException {
        return (ProcessElement)setAttribute("classDescription", classDescription, false);
    }

    /**
     * Optional description of the general nature of the kinds of tasks this this process element performs. Not to be confused
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getDescription description} which describes what the
     * specific instance of the process element has been configured to do. <P> For example, the <code>classDescription</code>
     * for a task to disable a field might be "disables a field" whereas the <code>description</code> for a concrete instance
     * might be "disables the 'shipTo' field in the 'ordering' form". <P> Used by editor to display additional details along
     * with {@link com.smartgwt.client.util.workflow.ProcessElement#getTitle title}.
     *
     * @return Current classDescription value. Default value is null
     */
    public String getClassDescription()  {
        return getAttributeAsString("classDescription");
    }
    

    /**
     * Optional description for this specific instance of process element.
     *
     * @param description New description value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setDescription(String description)  throws IllegalStateException {
        return (ProcessElement)setAttribute("description", description, false);
    }

    /**
     * Optional description for this specific instance of process element.
     *
     * @return Current description value. Default value is null
     */
    public String getDescription()  {
        return getAttributeAsString("description");
    }
    

    /**
     * Editor type used to edit instances of this type of process element.
     *
     * @param editorType New editorType value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setEditorType(String editorType)  throws IllegalStateException {
        return (ProcessElement)setAttribute("editorType", editorType, false);
    }

    /**
     * Editor type used to edit instances of this type of process element.
     *
     * @return Current editorType value. Default value is null
     */
    public String getEditorType()  {
        return getAttributeAsString("editorType");
    }
    

    /**
     * Optional ID for this process element, allowing it to be referred to from  {@link
     * com.smartgwt.client.util.workflow.DecisionGateway Gateways}, or as the {@link
     * com.smartgwt.client.util.workflow.Process#getStartElement Process.startElement}.  See {@link
     * com.smartgwt.client.util.workflow.ProcessSequence} and {@link com.smartgwt.client.util.workflow.Process} to understand
     * when this is required or can be omitted. <P> Unlike {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} a
     * <code>processElement</code>'s is a not a globally unique variable, it need only by unique within it's process. <P> When
     * assigned an ID, a <code>processElement</code> can be retrieve via {@link
     * com.smartgwt.client.util.workflow.Process#getElement Process.getElement()}.
     *
     * @param ID New ID value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setID(String ID)  throws IllegalStateException {
        return (ProcessElement)setAttribute("ID", ID, false);
    }

    /**
     * Optional ID for this process element, allowing it to be referred to from  {@link
     * com.smartgwt.client.util.workflow.DecisionGateway Gateways}, or as the {@link
     * com.smartgwt.client.util.workflow.Process#getStartElement Process.startElement}.  See {@link
     * com.smartgwt.client.util.workflow.ProcessSequence} and {@link com.smartgwt.client.util.workflow.Process} to understand
     * when this is required or can be omitted. <P> Unlike {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} a
     * <code>processElement</code>'s is a not a globally unique variable, it need only by unique within it's process. <P> When
     * assigned an ID, a <code>processElement</code> can be retrieve via {@link
     * com.smartgwt.client.util.workflow.Process#getElement Process.getElement()}.
     *
     * @return Current ID value. Default value is null
     */
    public String getID()  {
        return getAttributeAsString("ID");
    }
    

    /**
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute after this one completes.   <p>
     * <code>nextElement</code> does not need to be specified on most elements if you use {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequences}. <p> Note that if there is both a
     * <code>sequence</code> and a normal <code>element</code> with the same name in the current <code>Process</code>, the
     * <code>sequence</code> will be used.
     *
     * @param nextElement New nextElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setNextElement(String nextElement)  throws IllegalStateException {
        return (ProcessElement)setAttribute("nextElement", nextElement, false);
    }

    /**
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute after this one completes.   <p>
     * <code>nextElement</code> does not need to be specified on most elements if you use {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequences}. <p> Note that if there is both a
     * <code>sequence</code> and a normal <code>element</code> with the same name in the current <code>Process</code>, the
     * <code>sequence</code> will be used.
     *
     * @return Current nextElement value. Default value is null
     */
    public String getNextElement()  {
        return getAttributeAsString("nextElement");
    }
    

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state.
     *
     * @param passThruOutput New passThruOutput value. Default value is true
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setPassThruOutput(Boolean passThruOutput)  throws IllegalStateException {
        return (ProcessElement)setAttribute("passThruOutput", passThruOutput, false);
    }

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state.
     *
     * @return Current passThruOutput value. Default value is true
     */
    public Boolean getPassThruOutput()  {
        Boolean result = getAttributeAsBoolean("passThruOutput");
        return result == null ? true : result;
    }
    

    /**
     * Optional short, descriptive title for this process element. Used by an editor a title for process elements of this type.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ProcessElement ProcessElement} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ProcessElement setTitle(String title)  throws IllegalStateException {
        return (ProcessElement)setAttribute("title", title, false);
    }

    /**
     * Optional short, descriptive title for this process element. Used by an editor a title for process elements of this type.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************
	/**
     * Returns a text description of the element derived from the configuration. <p> If no override is provided by the concrete
     * ProcessElement implementation the {@link com.smartgwt.client.util.workflow.ProcessElement#getDescription description} or
     * {@link com.smartgwt.client.util.workflow.ProcessElement#getID ID} is returned.
     *
     * @return the derived element description
     */
    public native String getElementDescription() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getElementDescription", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getElementDescription();
        return ret;
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************


    
    private Map<String, ProcessElement[]> elementParameters = new HashMap<String, ProcessElement[]>();
    
    // IDs for elements are not unique, also all elements should be created when process
    // started, so elements don't act as BaseClass
    protected void onInit() {
        for (String key : elementParameters.keySet()) {
            setProperty(key, ProcessElement.convertToJavaScriptArray(elementParameters.get(key)));
        }        
    }

    public ProcessElement setAttribute(String attribute, ProcessElement[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            elementParameters.put(attribute, value);
        } else if (allowPostCreate) {
            elementParameters.put(attribute, value);
            setProperty(attribute, ProcessElement.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
        return this;
    }
    
    public ProcessElement[] getProcessElements(String attribute) {
        return elementParameters.get(attribute); 
    }
    
    public static JavaScriptObject convertToJavaScriptArray(ProcessElement[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = JSOHelper.createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i].getOrCreateJsObj());
        }
        return jsArray;
    }

}
