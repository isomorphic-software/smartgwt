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
 * Show or hide a component. When showing, reveals any hidden parents as well.
 * @see com.smartgwt.client.widgets.Canvas#show
 * @see com.smartgwt.client.widgets.Canvas#hide
 * @see com.smartgwt.client.widgets.form.fields.FormItem#show
 * @see com.smartgwt.client.widgets.form.fields.FormItem#hide
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ShowHideTask")
public class ShowHideTask extends ComponentTask {

    public static ShowHideTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ShowHideTask) obj;
        } else {
            return new ShowHideTask(jsObj);
        }
    }
        


    public ShowHideTask(){
        scClassName = "ShowHideTask";
    }

    public ShowHideTask(JavaScriptObject jsObj){
        scClassName = "ShowHideTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Should the target form item be hidden?
     *
     * @param hide New hide value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowHideTask setHide(Boolean hide)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("hide", hide, false);
    }

    /**
     * Should the target form item be hidden?
     *
     * @return Current hide value. Default value is null
     */
    public Boolean getHide()  {
        return getAttributeAsBoolean("hide");
    }
    

    /**
     * Should focus be moved to target component when showing?
     *
     * @param moveFocusToTarget New moveFocusToTarget value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowHideTask setMoveFocusToTarget(Boolean moveFocusToTarget)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("moveFocusToTarget", moveFocusToTarget, false);
    }

    /**
     * Should focus be moved to target component when showing?
     *
     * @return Current moveFocusToTarget value. Default value is null
     */
    public Boolean getMoveFocusToTarget()  {
        return getAttributeAsBoolean("moveFocusToTarget");
    }
    

    /**
     * Set to <code>false</code> to prevent scrolling the component into view when showing.
     *
     * @param scrollIntoView New scrollIntoView value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowHideTask setScrollIntoView(Boolean scrollIntoView)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("scrollIntoView", scrollIntoView, false);
    }

    /**
     * Set to <code>false</code> to prevent scrolling the component into view when showing.
     *
     * @return Current scrollIntoView value. Default value is null
     */
    public Boolean getScrollIntoView()  {
        return getAttributeAsBoolean("scrollIntoView");
    }
    

    /**
     * Set to <code>false</code> to not show a component's parents.
     *
     * @param showRecursively New showRecursively value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowHideTask setShowRecursively(Boolean showRecursively)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("showRecursively", showRecursively, false);
    }

    /**
     * Set to <code>false</code> to not show a component's parents.
     *
     * @return Current showRecursively value. Default value is null
     */
    public Boolean getShowRecursively()  {
        return getAttributeAsBoolean("showRecursively");
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a DynamicForm, this
     * property specifies the name of the target field to assign new title.
     *
     * @param targetFieldName New targetFieldName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public ShowHideTask setTargetFieldName(String targetFieldName)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("targetFieldName", targetFieldName, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a DynamicForm, this
     * property specifies the name of the target field to assign new title.
     *
     * @return Current targetFieldName value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public String getTargetFieldName()  {
        return getAttributeAsString("targetFieldName");
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the name of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.ShowHideTask#getTargetSectionTitle targetSectionTitle}.
     *
     * @param targetSectionName New targetSectionName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowHideTask setTargetSectionName(String targetSectionName)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("targetSectionName", targetSectionName, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the name of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.ShowHideTask#getTargetSectionTitle targetSectionTitle}.
     *
     * @return Current targetSectionName value. Default value is null
     */
    public String getTargetSectionName()  {
        return getAttributeAsString("targetSectionName");
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the title of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.ShowHideTask#getTargetSectionName targetSectionName}.
     *
     * @param targetSectionTitle New targetSectionTitle value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowHideTask setTargetSectionTitle(String targetSectionTitle)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("targetSectionTitle", targetSectionTitle, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the title of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.ShowHideTask#getTargetSectionName targetSectionName}.
     *
     * @return Current targetSectionTitle value. Default value is null
     */
    public String getTargetSectionTitle()  {
        return getAttributeAsString("targetSectionTitle");
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a TabSet, this property
     * specifies the name or ID of the target tab to assign new title.
     *
     * @param targetTabName New targetTabName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowHideTask ShowHideTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TabName TabName 
     */
    public ShowHideTask setTargetTabName(String targetTabName)  throws IllegalStateException {
        return (ShowHideTask)setAttribute("targetTabName", targetTabName, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a TabSet, this property
     * specifies the name or ID of the target tab to assign new title.
     *
     * @return Current targetTabName value. Default value is null
     * @see com.smartgwt.client.docs.TabName TabName 
     */
    public String getTargetTabName()  {
        return getAttributeAsString("targetTabName");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
